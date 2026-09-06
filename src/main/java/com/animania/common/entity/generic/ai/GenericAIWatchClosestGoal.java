package com.animania.common.entity.generic.ai;

import java.util.EnumSet;

import com.animania.api.interfaces.ISleeping;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

 











public class GenericAIWatchClosestGoal<T extends Mob & ISleeping> extends Goal
{
	protected final T entity;
	private final Class<? extends LivingEntity> watchedClass;
	private final float maxDistance;
	private final float chance;
	private LivingEntity closestEntity;
	private int lookTime;

	public GenericAIWatchClosestGoal(T entity, Class<? extends LivingEntity> watchedClass, float maxDistance)
	{
		this(entity, watchedClass, maxDistance, 0.02F);
	}

	public GenericAIWatchClosestGoal(T entity, Class<? extends LivingEntity> watchedClass, float maxDistance, float chance)
	{
		this.entity = entity;
		this.watchedClass = watchedClass;
		this.maxDistance = maxDistance;
		this.chance = chance;
		this.setFlags(EnumSet.of(Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (this.isWatchSuppressed())
			return false;

		if (this.entity.getRandom().nextFloat() >= this.chance)
			return false;

		if (this.entity.getTarget() != null)
			this.closestEntity = this.entity.getTarget();
		else if (this.watchedClass == Player.class)
			this.closestEntity = this.entity.level().getNearestPlayer(this.entity, this.maxDistance);
		else
			this.closestEntity = this.entity.level().getNearestEntity(this.watchedClass,
					net.minecraft.world.entity.ai.targeting.TargetingConditions.forNonCombat(),
					this.entity,
					this.entity.getX(), this.entity.getY(), this.entity.getZ(),
					this.entity.getBoundingBox().inflate(this.maxDistance, 3.0D, this.maxDistance));

		return this.closestEntity != null;
	}

	 





	protected boolean isWatchSuppressed()
	{
		return this.entity.getSleeping();
	}

	@Override
	public boolean canContinueToUse()
	{
		if (this.closestEntity == null || !this.closestEntity.isAlive())
			return false;
		if (this.entity.distanceToSqr(this.closestEntity) > (double) (this.maxDistance * this.maxDistance))
			return false;
		return this.lookTime > 0;
	}

	@Override
	public void start()
	{
		this.lookTime = 40 + this.entity.getRandom().nextInt(40);
	}

	@Override
	public void stop()
	{
		this.closestEntity = null;
	}

	@Override
	public void tick()
	{
		this.entity.getLookControl().setLookAt(this.closestEntity.getX(), this.closestEntity.getEyeY() + 5.0D, this.closestEntity.getZ(),
				this.entity.getMaxHeadYRot(), this.entity.getMaxHeadXRot());
		this.lookTime--;
	}
}
