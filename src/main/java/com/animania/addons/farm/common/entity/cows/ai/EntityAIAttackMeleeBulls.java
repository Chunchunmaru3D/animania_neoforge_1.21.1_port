package com.animania.addons.farm.common.entity.cows.ai;

import com.animania.addons.farm.common.entity.cows.EntityBullBase;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

 








public class EntityAIAttackMeleeBulls extends MeleeAttackGoal
{
	private final EntityBullBase bull;

	public EntityAIAttackMeleeBulls(EntityBullBase bull, double speed, boolean followingTargetEvenIfNotSeen)
	{
		super(bull, speed, followingTargetEvenIfNotSeen);
		this.bull = bull;
	}

	@Override
	public void start()
	{
		super.start();
		if (this.bull.getSleeping())
			this.bull.setSleeping(false);
		else
			this.bull.setFighting(true);
	}

	@Override
	public void stop()
	{
		super.stop();
		this.bull.setFighting(false);
	}
}
