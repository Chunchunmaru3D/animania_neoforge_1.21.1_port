package com.animania.common.entity.generic.ai;

import java.util.EnumSet;

import com.animania.api.interfaces.ISleeping;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

 







public class GenericAISleepGoal<T extends PathfinderMob & ISleeping> extends Goal
{
	private final T entity;
	private final double speed;
	private final Block bed;
	private final Block bed2;
	private BlockPos sleepPos;

	public GenericAISleepGoal(T entity, double speed, Block bed, Block bed2)
	{
		this.entity = entity;
		this.speed = speed;
		this.bed = bed;
		this.bed2 = bed2;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
	}

	@Override
	public boolean canUse()
	{
		 
		if (this.entity.level().isDay())
		{
			if (this.entity.getSleeping())
			{
				this.entity.setSleeping(false);
				this.entity.setSleepTimer(0F);
			}
			return false;
		}

		if (this.entity.isVehicle() || this.entity.isLeashed())
			return false;

		return true;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.canUse();
	}

	@Override
	public void start()
	{
		this.sleepPos = this.findBed();
		if (this.sleepPos != null)
			this.entity.getNavigation().moveTo(this.sleepPos.getX() + 0.5, this.sleepPos.getY() + 1, this.sleepPos.getZ() + 0.5, this.speed);
	}

	@Override
	public void tick()
	{
		if (this.sleepPos != null && !this.entity.getSleeping())
		{
			if (this.entity.blockPosition().distSqr(this.sleepPos) <= 4.0)
			{
				this.entity.getNavigation().stop();
				this.entity.setSleeping(true);
				this.entity.setCustomSleepingPos(this.sleepPos);
			}
			else if (this.entity.getNavigation().isDone())
				this.entity.getNavigation().moveTo(this.sleepPos.getX() + 0.5, this.sleepPos.getY() + 1, this.sleepPos.getZ() + 0.5, this.speed);
		}
		else if (this.sleepPos == null && !this.entity.getSleeping() && this.entity.level().getRandom().nextInt(100) == 0)
		{
			 
			this.entity.getNavigation().stop();
			this.entity.setSleeping(true);
		}
	}

	@Override
	public void stop()
	{
		this.entity.setSleeping(false);
		this.entity.setSleepTimer(0F);
		this.sleepPos = null;
	}

	private BlockPos findBed()
	{
		BlockPos origin = this.entity.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-10, -2, -10), origin.offset(10, 2, 10)))
		{
			Block block = this.entity.level().getBlockState(pos).getBlock();
			if (block == this.bed || block == this.bed2)
				return pos.immutable();
		}
		return null;
	}
}
