package com.animania.common.blocks;

import javax.annotation.Nullable;

import com.animania.common.blockentity.BlockEntitySaltLick;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

 
public class BlockSaltLick extends Block implements EntityBlock
{
	private static final double MIN_X = 0.1875 * 16;
	private static final double MAX_X = 0.8125 * 16;
	private static final double MIN_Z = 0.1875 * 16;
	private static final double MAX_Z = 0.8125 * 16;
	private static final double MAX_Y = 0.625 * 16;

	public BlockSaltLick(BlockBehaviour.Properties properties)
	{
		super(properties);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		double fraction = level.getBlockEntity(pos) instanceof BlockEntitySaltLick te ? te.getFractionRemaining() : 1.0;
		return Block.box(MIN_X, 0.0, MIN_Z, MAX_X, Math.max(1.0, MAX_Y * fraction), MAX_Z);
	}

	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return this.getShape(state, level, pos, context);
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
		return new BlockEntitySaltLick(pos, state);
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
	{
		super.setPlacedBy(level, pos, state, placer, stack);
		if (level.isClientSide || !(level.getBlockEntity(pos) instanceof BlockEntitySaltLick saltLick))
			return;

		int usesLeft = AnimaniaConfig.careAndFeeding.saltLickMaxUses.get();
		CustomData data = stack.get(DataComponents.CUSTOM_DATA);
		if (data != null && data.contains("UsesLeft"))
			usesLeft = data.copyTag().getInt("UsesLeft");
		saltLick.setUsesLeft(usesLeft);
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool)
	{
		 
		player.awardStat(Stats.BLOCK_MINED.get(this));
		player.causeFoodExhaustion(.005F);
		if (blockEntity instanceof BlockEntitySaltLick saltLick)
			Block.popResource(level, pos, createItemStack(saltLick.getUsesLeft()));
	}

	@Override
	public boolean dropFromExplosion(net.minecraft.world.level.Explosion explosion)
	{
		 
		return false;
	}

	private ItemStack createItemStack(int usesLeft)
	{
		ItemStack stack = new ItemStack(this);
		CompoundTag data = new CompoundTag();
		data.putInt("UsesLeft", usesLeft);
		stack.set(DataComponents.CUSTOM_DATA, CustomData.of(data));
		stack.setDamageValue(Math.max(0, AnimaniaConfig.careAndFeeding.saltLickMaxUses.get() - usesLeft));
		return stack;
	}

	 



	public static boolean use(Level level, BlockPos pos)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntitySaltLick te))
			return false;

		boolean depleted = te.consumeUse();
		if (depleted)
			level.removeBlock(pos, false);

		return depleted;
	}
}
