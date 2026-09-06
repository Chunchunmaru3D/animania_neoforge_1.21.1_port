package com.animania.common.entity.generic.ai;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.sheep.EntityRamBase;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.world.entity.ai.goal.Goal;

 








public class GenericAIButtHeadsGoal extends Goal
{
	private final EntityRamBase ram;
	private final double speed;
	private int delayCounter;
	private int fightTimer;
	private EntityRamBase targetRival;

	public GenericAIButtHeadsGoal(EntityRamBase ram, double speed)
	{
		this.ram = ram;
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

		if (!this.ram.level().isDay())
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

		return this.targetRival != null && this.ram.getFighting();
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
		if (this.ram.getFighting() && this.targetRival != null)
		{
			this.ram.getLookControl().setLookAt(this.targetRival, 10.0F, (float) this.ram.getMaxHeadXRot());
			this.ram.getNavigation().moveTo(this.targetRival, this.speed);
		}
		else
		{
			this.ram.getNavigation().stop();
		}
	}

	 



	private EntityRamBase findRival()
	{
		EntityRamBase found = null;

		List<EntityRamBase> nearby = AnimaniaHelper.getEntitiesInRange(EntityRamBase.class, 10,
				this.ram.level(), this.ram.blockPosition());

		for (EntityRamBase other : nearby)
		{
			if (other == this.ram)
				continue;

			UUID myRival = this.ram.getRivalUniqueId();
			UUID otherRival = other.getRivalUniqueId();

			if (myRival == null && otherRival == null)
			{
				found = other;
				other.setRivalUniqueId(this.ram.getUUID());
				this.ram.setRivalUniqueId(other.getUUID());
				this.ram.setFighting(true);
				other.setFighting(true);
				this.ram.setTarget(other);
				other.setTarget(this.ram);
				break;
			}
			else if (myRival != null && myRival.equals(other.getUUID()))
			{
				found = other;
				other.setRivalUniqueId(this.ram.getUUID());
				this.ram.setRivalUniqueId(other.getUUID());
				this.ram.setTarget(other);
				other.setTarget(this.ram);
				break;
			}
		}

		this.fightTimer--;

		if (found != null)
		{
			if (this.fightTimer < 0 && this.ram.getFighting())
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
		this.ram.setFighting(false);
		this.ram.setRivalUniqueId(null);
		this.ram.setTarget(null);
		this.delayCounter = 0;
	}

	private void resetRivalryWith(EntityRamBase other)
	{
		this.targetRival = null;
		this.ram.setFighting(false);
		other.setFighting(false);
		this.ram.setRivalUniqueId(null);
		other.setRivalUniqueId(null);
		this.ram.setTarget(null);
		other.setTarget(null);
		this.delayCounter = 0;
	}
}
