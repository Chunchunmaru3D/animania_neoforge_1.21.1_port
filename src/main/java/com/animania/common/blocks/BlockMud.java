package com.animania.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

 
public class BlockMud extends Block
{
	private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 14.08D, 16);

	public BlockMud(BlockBehaviour.Properties properties)
	{
		super(properties);
	}

	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return SHAPE;
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return SHAPE;
	}

	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity)
	{
		entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.2D, 1.0D, 0.2D));
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
	{
		entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.2D, 1.0D, 0.2D));
		super.stepOn(level, pos, state, entity);
	}
}
