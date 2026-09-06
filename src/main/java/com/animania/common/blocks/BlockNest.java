package com.animania.common.blocks;

import javax.annotation.Nullable;

import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

 












public class BlockNest extends Block implements EntityBlock
{
	private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 4.8, 16.0);

	private static final java.util.List<HatchCallback> HATCH_CALLBACKS = new java.util.ArrayList<>();

	public interface HatchCallback
	{
		void tryHatch(ServerLevel level, BlockPos pos, BlockEntityNest nest, RandomSource random);
	}

	 
	public static void addHatchCallback(HatchCallback callback)
	{
		BlockNest.HATCH_CALLBACKS.add(callback);
	}

	public BlockNest(BlockBehaviour.Properties properties)
	{
		super(properties);
	}

	@Override
	protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
	{
		if (HATCH_CALLBACKS.isEmpty())
			return;

		if (level.getBlockEntity(pos) instanceof BlockEntityNest te && !te.getItemHandler().getStackInSlot(0).isEmpty())
		{
			for (HatchCallback callback : HATCH_CALLBACKS)
				callback.tryHatch(level, pos, te, random);
		}
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return SHAPE;
	}

	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return Shapes.empty();
	}

	@Override
	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
	{
		BlockPos below = pos.below();
		return level.getBlockState(below).isFaceSturdy(level, below, Direction.UP);
	}

	@Override
	protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos)
	{
		if (direction == Direction.DOWN && !this.canSurvive(state, level, pos))
			return Blocks.AIR.defaultBlockState();

		return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston)
	{
		if (state.getBlock() != newState.getBlock() && level.getBlockEntity(pos) instanceof BlockEntityNest te)
		{
			ItemStack stack = te.getItemHandler().getStackInSlot(0);
			if (!stack.isEmpty())
				net.minecraft.world.Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), stack);
		}

		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	@Nullable
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlockEntityNest(pos, state);
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
	{
		if (player.isShiftKeyDown())
			return InteractionResult.PASS;

		if (!(level.getBlockEntity(pos) instanceof BlockEntityNest te))
			return InteractionResult.PASS;

		ItemStack existing = te.getItemHandler().getStackInSlot(0);
		if (existing.isEmpty())
			return InteractionResult.PASS;

		ItemStack extracted = te.getItemHandler().extractItem(0, 1, false);
		AnimaniaHelper.addItem(player, extracted);
		return InteractionResult.SUCCESS;
	}
}
