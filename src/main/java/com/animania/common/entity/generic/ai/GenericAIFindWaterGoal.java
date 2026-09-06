package com.animania.common.entity.generic.ai;

import java.util.EnumSet;

import com.animania.api.interfaces.IFoodEating;
import com.animania.api.interfaces.IFoodProviderBlock;
import com.animania.api.interfaces.IFoodProviderTE;
import com.animania.api.interfaces.ISleeping;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;

 






public class GenericAIFindWaterGoal<T extends PathfinderMob & IFoodEating & ISleeping> extends Goal
{
	private final T entity;
	private final double speed;
	private BlockPos waterPos;
	private boolean foundTrough;
	private int drinkTimer;

	public GenericAIFindWaterGoal(T entity, double speed)
	{
		this.entity = entity;
		this.speed = speed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (this.entity.getWatered() || this.entity.getSleeping())
			return false;

		if (this.entity.getRandom().nextInt(20) != 0)
			return false;

		this.waterPos = this.findWater();
		return this.waterPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.waterPos != null && !this.entity.getWatered() && !this.entity.getSleeping();
	}

	@Override
	public void start()
	{
		this.drinkTimer = 0;
		this.moveToWater();
	}

	@Override
	public void tick()
	{
		if (this.waterPos == null)
			return;

		if (this.entity.blockPosition().distSqr(this.waterPos) <= 5.0)
		{
			this.entity.getLookControl().setLookAt(this.waterPos.getX() + 0.5, this.waterPos.getY(), this.waterPos.getZ() + 0.5);
			this.drinkTimer++;
			if (this.drinkTimer >= 40)
			{
				if (this.foundTrough)
					this.drinkFromTrough();

				this.entity.setWatered(true);
				this.entity.setInteracted(true);
				this.entity.setEatTimer(40);
				this.waterPos = null;
			}
		}
		else if (this.entity.getNavigation().isDone())
			this.moveToWater();
	}

	private void drinkFromTrough()
	{
		BlockEntity be = this.entity.level().getBlockEntity(this.waterPos);
		if (be instanceof IFoodProviderTE trough)
			trough.consumeLiquid(100);
	}

	private void moveToWater()
	{
		if (this.waterPos != null)
			this.entity.getNavigation().moveTo(this.waterPos.getX() + 0.5, this.waterPos.getY(), this.waterPos.getZ() + 0.5, this.speed);
	}

	private BlockPos findWater()
	{
		BlockPos origin = this.entity.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-12, -2, -12), origin.offset(12, 2, 12)))
		{
			Block block = this.entity.level().getBlockState(pos).getBlock();
			if (block instanceof IFoodProviderBlock && this.entity.level().getBlockEntity(pos) instanceof IFoodProviderTE trough
					&& trough.canConsume(new FluidStack(Fluids.WATER, 1), null))
			{
				this.foundTrough = true;
				return pos.immutable();
			}

			if (this.entity.level().getFluidState(pos).is(Fluids.WATER))
			{
				this.foundTrough = false;
				return pos.immutable();
			}
		}
		return null;
	}
}
