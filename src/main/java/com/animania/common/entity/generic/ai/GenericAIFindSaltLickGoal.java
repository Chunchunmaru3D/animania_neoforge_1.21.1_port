package com.animania.common.entity.generic.ai;

import java.util.EnumSet;

import com.animania.api.interfaces.ISleeping;
import com.animania.common.blocks.BlockSaltLick;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

 




public class GenericAIFindSaltLickGoal<T extends PathfinderMob & ISleeping> extends Goal
{
	private final T entity;
	private final double speed;
	private BlockPos saltPos;
	private int delay;

	public GenericAIFindSaltLickGoal(T entity, double speed)
	{
		this.entity = entity;
		this.speed = speed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (++this.delay <= AnimaniaConfig.careAndFeeding.saltLickTick.get())
			return false;

		this.delay = 0;

		if (this.entity.getHealth() >= this.entity.getMaxHealth() || this.entity.isVehicle() || this.entity.getSleeping())
			return false;

		if (this.entity.getRandom().nextInt(3) != 0)
			return false;

		this.saltPos = this.findSaltLick();
		return this.saltPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.saltPos != null && this.entity.getHealth() < this.entity.getMaxHealth() && !this.entity.getSleeping();
	}

	@Override
	public void start()
	{
		this.moveToSalt();
	}

	@Override
	public void tick()
	{
		if (this.saltPos == null)
			return;

		if (this.entity.blockPosition().distSqr(this.saltPos) <= 4.0)
		{
			this.entity.getLookControl().setLookAt(this.saltPos.getX() + 0.5, this.saltPos.getY(), this.saltPos.getZ() + 0.5);

			if (this.entity.level().getBlockState(this.saltPos).getBlock() instanceof BlockSaltLick
					&& this.entity.level() instanceof ServerLevel serverLevel)
			{
				BlockSaltLick.use(serverLevel, this.saltPos);
				this.entity.heal(2.0F);
			}

			this.saltPos = null;
		}
		else if (this.entity.getNavigation().isDone())
			this.moveToSalt();
	}

	private void moveToSalt()
	{
		if (this.saltPos != null)
			this.entity.getNavigation().moveTo(this.saltPos.getX() + 0.5, this.saltPos.getY(), this.saltPos.getZ() + 0.5, this.speed);
	}

	private BlockPos findSaltLick()
	{
		BlockPos origin = this.entity.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-10, -2, -10), origin.offset(10, 2, 10)))
		{
			if (this.entity.level().getBlockState(pos).getBlock() instanceof BlockSaltLick)
				return pos.immutable();
		}
		return null;
	}
}
