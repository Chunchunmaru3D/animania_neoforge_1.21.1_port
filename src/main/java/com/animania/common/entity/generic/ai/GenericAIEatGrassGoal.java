package com.animania.common.entity.generic.ai;

import java.util.EnumSet;

import com.animania.api.interfaces.IFoodEating;
import com.animania.api.interfaces.ISleeping;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;

 










public class GenericAIEatGrassGoal<T extends PathfinderMob & IFoodEating & ISleeping> extends Goal
{
	private final T entity;
	private final double speed;
	private BlockPos grassPos;
	private int eatingGrassTimer;

	public GenericAIEatGrassGoal(T entity, double speed)
	{
		this.entity = entity;
		this.speed = speed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	public int getEatingGrassTimer()
	{
		return this.eatingGrassTimer;
	}

	@Override
	public boolean canUse()
	{
		if (this.entity.getFed() || this.entity.getSleeping())
			return false;

		if (this.entity.getRandom().nextInt(120) != 0)
			return false;

		this.grassPos = this.findGrass();
		return this.grassPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.eatingGrassTimer > 0 || (this.grassPos != null && !this.entity.getFed() && !this.entity.getSleeping());
	}

	@Override
	public void start()
	{
		this.eatingGrassTimer = 0;
		this.moveToGrass();
	}

	@Override
	public void stop()
	{
		this.eatingGrassTimer = 0;
		this.grassPos = null;
	}

	@Override
	public void tick()
	{
		this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);

		if (this.grassPos == null)
			return;

		if (this.entity.blockPosition().distSqr(this.grassPos) <= 4.0)
		{
			this.entity.getLookControl().setLookAt(this.grassPos.getX() + 0.5, this.grassPos.getY(), this.grassPos.getZ() + 0.5);

			if (this.eatingGrassTimer <= 0)
			{
				this.eatingGrassTimer = 40;
				this.entity.level().broadcastEntityEvent(this.entity, (byte) 10);  
				this.entity.getNavigation().stop();
			}

			if (this.eatingGrassTimer == 4 && !this.entity.level().isClientSide)
			{
				BlockState state = this.entity.level().getBlockState(this.grassPos);
				this.entity.level().levelEvent(2001, this.grassPos, net.minecraft.world.level.block.Block.getId(state));
				this.entity.level().setBlockAndUpdate(this.grassPos, Blocks.DIRT.defaultBlockState());
				this.entity.setFed(true);
				this.grassPos = null;
			}
		}
		else if (this.entity.getNavigation().isDone())
		{
			this.moveToGrass();
		}
	}

	private void moveToGrass()
	{
		if (this.grassPos != null)
			this.entity.getNavigation().moveTo(this.grassPos.getX() + 0.5, this.grassPos.getY(), this.grassPos.getZ() + 0.5, this.speed);
	}

	private BlockPos findGrass()
	{
		BlockPos origin = this.entity.blockPosition();
		boolean canEatMycelium = this.entity.canEatMycelium();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-8, -2, -8), origin.offset(8, 2, 8)))
		{
			var block = this.entity.level().getBlockState(pos).getBlock();
			if (block instanceof GrassBlock || (canEatMycelium && block == Blocks.MYCELIUM))
				return pos.immutable();
		}
		return null;
	}
}
