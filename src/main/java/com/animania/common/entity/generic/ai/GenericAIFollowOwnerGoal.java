package com.animania.common.entity.generic.ai;

import java.util.EnumSet;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

 







public class GenericAIFollowOwnerGoal extends Goal
{
	private final TamableAnimal pet;
	private final double speed;
	private final float startDistance;
	private final float stopDistance;
	private LivingEntity owner;
	private int timeToRecalcPath;

	public GenericAIFollowOwnerGoal(TamableAnimal pet, double speed, float startDistance, float stopDistance)
	{
		this.pet = pet;
		this.speed = speed;
		this.startDistance = startDistance;
		this.stopDistance = stopDistance;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		LivingEntity owner = this.pet.getOwner();
		if (owner == null || owner.isSpectator() || !(owner instanceof Player) || this.pet.isOrderedToSit())
			return false;

		if (this.pet.distanceToSqr(owner) < (this.startDistance * this.startDistance))
			return false;

		this.owner = owner;
		return true;
	}

	@Override
	public boolean canContinueToUse()
	{
		return !this.pet.getNavigation().isDone() && this.owner != null && !this.pet.isOrderedToSit()
				&& this.pet.distanceToSqr(this.owner) > (this.stopDistance * this.stopDistance);
	}

	@Override
	public void start()
	{
		this.timeToRecalcPath = 0;
	}

	@Override
	public void stop()
	{
		this.owner = null;
		this.pet.getNavigation().stop();
	}

	@Override
	public void tick()
	{
		if (this.owner == null)
			return;

		this.pet.getLookControl().setLookAt(this.owner.getX(), this.owner.getEyeY(), this.owner.getZ());

		if (--this.timeToRecalcPath <= 0)
		{
			this.timeToRecalcPath = 10;
			if (!this.pet.isLeashed() && !this.pet.isPassenger())
				this.pet.getNavigation().moveTo(this.owner, this.speed);
		}
	}
}
