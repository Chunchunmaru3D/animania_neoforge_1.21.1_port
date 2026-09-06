package com.animania.addons.farm.common.block;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.common.blockentity.BlockEntityCheeseMold;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

 










public class BlockCheeseMold extends Block implements EntityBlock
{
	public static final EnumProperty<BlockEntityCheeseMold.MoldContent> CONTENT =
			EnumProperty.create("content", BlockEntityCheeseMold.MoldContent.class);

	private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0);

	public BlockCheeseMold(BlockBehaviour.Properties properties)
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(CONTENT, BlockEntityCheeseMold.MoldContent.EMPTY));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
	{
		builder.add(CONTENT);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return SHAPE;
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
	@Nullable
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlockEntityCheeseMold(pos, state);
	}

	@Override
	@Nullable
	@SuppressWarnings("unchecked")
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type)
	{
		if (level.isClientSide || type != FarmBlocks.CHEESE_MOLD_BLOCK_ENTITY.get())
			return null;

		return (BlockEntityTicker<T>) (BlockEntityTicker<BlockEntityCheeseMold>) BlockEntityCheeseMold::serverTick;
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston)
	{
		if (state.getBlock() != newState.getBlock() && level.getBlockEntity(pos) instanceof BlockEntityCheeseMold mold)
		{
			ItemStack result = mold.tryTakeResult();
			if (result != null && !result.isEmpty())
				Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), result);
		}

		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntityCheeseMold mold))
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

		if (!heldItem.isEmpty() && mold.tryFill(heldItem))
		{
			if (!player.getAbilities().instabuild)
			{
				heldItem.shrink(1);
				AnimaniaHelper.addItem(player, new ItemStack(Items.BUCKET));
			}
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntityCheeseMold mold))
			return InteractionResult.PASS;

		if (player.isShiftKeyDown())
		{
			if (!level.isClientSide)
			{
				String message = mold.getContent().isAging()
						? (int) (((float) mold.getProgress() / (float) FarmConfig.settings.cheeseMaturityTime.get()) * 100) + "%"
						: mold.getContent().isFinished() ? "100%" : "empty";
				player.displayClientMessage(Component.literal(message), true);
			}
			return InteractionResult.SUCCESS;
		}

		ItemStack result = mold.tryTakeResult();
		if (result != null && !result.isEmpty())
		{
			AnimaniaHelper.addItem(player, result);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}
}
