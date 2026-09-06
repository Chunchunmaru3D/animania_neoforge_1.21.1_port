package com.animania.common.entity.generic.ai;

import java.util.EnumSet;
import java.util.List;

import com.animania.addons.farm.common.entity.pigs.EntityAnimaniaPig;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

 









public class GenericAIFindMudGoal extends Goal
{
	private final EntityAnimaniaPig entity;
	private final double speed;
	private final Block mudBlock;
	private BlockPos targetMud;

	public GenericAIFindMudGoal(EntityAnimaniaPig entity, double speed, Block mudBlock)
	{
		this.entity = entity;
		this.speed = speed;
		this.mudBlock = mudBlock;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse()
	{
		if (this.entity.getPlayed() || this.entity.getSleeping() || !this.entity.level().isDay())
			return false;

		if (this.entity.getRandom().nextInt(100) != 0)
			return false;

		BlockPos here = this.entity.blockPosition();
		if (this.entity.level().getBlockState(here).getBlock() == this.mudBlock)
		{
			this.entity.setPlayed(true);
			return false;
		}

		this.targetMud = this.findMud();
		return this.targetMud != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.targetMud != null && !this.entity.getNavigation().isDone();
	}

	@Override
	public void start()
	{
		if (this.targetMud != null)
			this.entity.getNavigation().moveTo(this.targetMud.getX() + 0.5, this.targetMud.getY(), this.targetMud.getZ() + 0.5, this.speed);
	}

	@Override
	public void stop()
	{
		this.targetMud = null;
		this.entity.getNavigation().stop();
	}

	private BlockPos findMud()
	{
		BlockPos origin = this.entity.blockPosition();
		BlockPos best = null;
		int bestDist = Integer.MAX_VALUE;

		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-10, -2, -10), origin.offset(10, 2, 10)))
		{
			if (this.entity.level().getBlockState(pos).getBlock() != this.mudBlock)
				continue;

			List<EntityAnimaniaPig> nearby = this.entity.level().getEntitiesOfClass(EntityAnimaniaPig.class,
					new net.minecraft.world.phys.AABB(pos).inflate(2));
			if (nearby.size() >= 2)
				continue;

			int dist = Math.abs(pos.getX() - origin.getX()) + Math.abs(pos.getY() - origin.getY()) + Math.abs(pos.getZ() - origin.getZ());
			if (dist < bestDist)
			{
				bestDist = dist;
				best = pos.immutable();
			}
		}

		return best;
	}
}
