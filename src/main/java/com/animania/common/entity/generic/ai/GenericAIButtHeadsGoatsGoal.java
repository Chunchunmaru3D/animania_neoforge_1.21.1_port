package com.animania.common.entity.generic.ai;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.goats.EntityBuckBase;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.world.entity.ai.goal.Goal;

 



public class GenericAIButtHeadsGoatsGoal extends Goal
{
	private final EntityBuckBase buck;
	private final double speed;
	private int delayCounter;
	private int fightTimer;
	private EntityBuckBase targetRival;

	public GenericAIButtHeadsGoatsGoal(EntityBuckBase buck, double speed)
	{
		this.buck = buck;
		this.speed = speed;
		this.fightTimer = 100 + Animania.RANDOM.nextInt(50);
		this.delayCounter = 0;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		this.delayCounter++;
		if (this.delayCounter <= 1000)
			return false;

		if (!this.buck.level().isDay())
		{
			this.delayCounter = 0;
			return false;
		}

		this.targetRival = this.findRival();

		if (this.targetRival != null && Animania.RANDOM.nextInt(20) == 0)
		{
			this.delayCounter = 0;
			this.resetRivalry();
			return false;
		}

		return this.targetRival != null && this.buck.getFighting();
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.targetRival != null && this.targetRival.isAlive();
	}

	@Override
	public void stop()
	{
		this.targetRival = null;
	}

	@Override
	public void tick()
	{
		if (this.buck.getFighting() && this.targetRival != null)
		{
			this.buck.getLookControl().setLookAt(this.targetRival, 10.0F, (float) this.buck.getMaxHeadXRot());
			this.buck.getNavigation().moveTo(this.targetRival, this.speed);
		}
		else
		{
			this.buck.getNavigation().stop();
		}
	}

	private EntityBuckBase findRival()
	{
		EntityBuckBase found = null;

		List<EntityBuckBase> nearby = AnimaniaHelper.getEntitiesInRange(EntityBuckBase.class, 10,
				this.buck.level(), this.buck.blockPosition());

		for (EntityBuckBase other : nearby)
		{
			if (other == this.buck)
				continue;

			UUID myRival = this.buck.getRivalUniqueId();
			UUID otherRival = other.getRivalUniqueId();

			if (myRival == null && otherRival == null)
			{
				found = other;
				other.setRivalUniqueId(this.buck.getUUID());
				this.buck.setRivalUniqueId(other.getUUID());
				this.buck.setFighting(true);
				other.setFighting(true);
				this.buck.setTarget(other);
				other.setTarget(this.buck);
				break;
			}
			else if (myRival != null && myRival.equals(other.getUUID()))
			{
				found = other;
				other.setRivalUniqueId(this.buck.getUUID());
				this.buck.setRivalUniqueId(other.getUUID());
				this.buck.setTarget(other);
				other.setTarget(this.buck);
				break;
			}
		}

		this.fightTimer--;

		if (found != null)
		{
			if (this.fightTimer < 0 && this.buck.getFighting())
			{
				this.fightTimer = 100 + Animania.RANDOM.nextInt(50);
				this.resetRivalryWith(found);
				return null;
			}
			return found;
		}
		else
		{
			this.fightTimer = 100 + Animania.RANDOM.nextInt(50);
			this.resetRivalry();
			return null;
		}
	}

	private void resetRivalry()
	{
		this.targetRival = null;
		this.buck.setFighting(false);
		this.buck.setRivalUniqueId(null);
		this.buck.setTarget(null);
		this.delayCounter = 0;
	}

	private void resetRivalryWith(EntityBuckBase other)
	{
		this.targetRival = null;
		this.buck.setFighting(false);
		other.setFighting(false);
		this.buck.setRivalUniqueId(null);
		other.setRivalUniqueId(null);
		this.buck.setTarget(null);
		other.setTarget(null);
		this.delayCounter = 0;
	}
}
