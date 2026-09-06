package com.animania.common.entity.generic.ai;

import java.util.EnumSet;

import com.animania.addons.farm.common.entity.goats.EntityBuckBase;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

 




public class GenericAIGoatsLeapAtTargetGoal extends Goal
{
	private final EntityBuckBase buck;
	private final float leapMotionY;
	private LivingEntity leapTarget;

	public GenericAIGoatsLeapAtTargetGoal(EntityBuckBase buck, float leapMotionY)
	{
		this.buck = buck;
		this.leapMotionY = leapMotionY;
		this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse()
	{
		if (this.buck.getSleeping())
			return false;

		this.leapTarget = this.buck.getTarget();

		if (!this.buck.getFighting() || this.leapTarget == null)
			return false;

		double distSq = this.buck.distanceToSqr(this.leapTarget);
		return distSq >= 0.0D && distSq <= 4.0D && this.buck.onGround() && this.buck.getRandom().nextInt(20) == 0;
	}

	@Override
	public boolean canContinueToUse()
	{
		return !this.buck.onGround();
	}

	@Override
	public void start()
	{
		if (this.leapTarget == null)
			return;

		double dx = this.leapTarget.getX() - this.buck.getX();
		double dz = this.leapTarget.getZ() - this.buck.getZ();
		float dist = Mth.sqrt((float) (dx * dx + dz * dz));

		if (dist >= 1.0E-4D)
		{
			var motion = this.buck.getDeltaMovement();
			this.buck.setDeltaMovement(
					motion.x + dx / dist * 0.5D * 0.8D + motion.x * 0.2D,
					this.leapMotionY,
					motion.z + dz / dist * 0.5D * 0.8D + motion.z * 0.2D);
		}
	}
}
