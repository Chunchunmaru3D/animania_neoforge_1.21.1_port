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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

 





public class GenericAIFindFoodGoal<T extends PathfinderMob & IFoodEating & ISleeping> extends Goal
{
	private final T entity;
	private final double speed;
	private final boolean destroyBlock;
	private BlockPos foodPos;
	private boolean foundTrough;
	private boolean foundFluid;
	private int eatTimer;

	public GenericAIFindFoodGoal(T entity, double speed, boolean destroyBlock)
	{
		this.entity = entity;
		this.speed = speed;
		this.destroyBlock = destroyBlock;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (this.entity.getFed() || this.entity.getSleeping())
			return false;

		if (this.entity.getRandom().nextInt(20) != 0)
			return false;

		this.foodPos = this.findFood();
		return this.foodPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.foodPos != null && !this.entity.getFed() && !this.entity.getSleeping();
	}

	@Override
	public void start()
	{
		this.eatTimer = 0;
		this.moveToFood();
	}

	@Override
	public void tick()
	{
		if (this.foodPos == null)
			return;

		if (this.entity.blockPosition().distSqr(this.foodPos) <= 4.0)
		{
			this.entity.getLookControl().setLookAt(this.foodPos.getX() + 0.5, this.foodPos.getY(), this.foodPos.getZ() + 0.5);
			this.eatTimer++;
			if (this.eatTimer >= 40)
			{
				if (this.foundTrough)
					this.eatFromTrough();
				else if (this.foundFluid && !this.entity.level().isClientSide)
					this.entity.level().setBlock(this.foodPos, Blocks.AIR.defaultBlockState(), 3);
				else if (this.destroyBlock && !this.entity.level().isClientSide)
					this.entity.level().destroyBlock(this.foodPos, false);

				this.entity.setFed(true);
				if (this.foundTrough)
					this.entity.setHandFed(true);
				this.entity.setInteracted(true);
				this.entity.setEatTimer(80);
				this.foodPos = null;
			}
		}
		else if (this.entity.getNavigation().isDone())
			this.moveToFood();
	}

	private void eatFromTrough()
	{
		BlockEntity be = this.entity.level().getBlockEntity(this.foodPos);
		if (be instanceof IFoodProviderTE trough && trough.canConsume(this.entity.getFoodItems(), this.entity.getFoodFluids()))
		{
			FluidStack held = be instanceof com.animania.common.blockentity.BlockEntityTrough troughEntity
					? troughEntity.getFluidTank().getFluid() : FluidStack.EMPTY;
			boolean liquid = !held.isEmpty() && isAcceptedFoodFluid(held.getFluid());
			trough.consumeSolidOrLiquid(100, 1);
			this.entity.setLiquidFed(liquid);
		}
	}

	private void moveToFood()
	{
		if (this.foodPos != null)
			this.entity.getNavigation().moveTo(this.foodPos.getX() + 0.5, this.foodPos.getY(), this.foodPos.getZ() + 0.5, this.speed);
	}

	private BlockPos findFood()
	{
		Class<? extends Block>[] foodBlocks = this.entity.getFoodBlocks();

		BlockPos origin = this.entity.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-12, -2, -12), origin.offset(12, 2, 12)))
		{
			Block block = this.entity.level().getBlockState(pos).getBlock();

			if (block instanceof IFoodProviderBlock && this.entity.level().getBlockEntity(pos) instanceof IFoodProviderTE trough
					&& trough.canConsume(this.entity.getFoodItems(), this.entity.getFoodFluids()))
			{
				this.foundTrough = true;
				this.foundFluid = false;
				return pos.immutable();
			}

			if (this.entity.level().getFluidState(pos).isSource() && isAcceptedFoodFluid(this.entity.level().getFluidState(pos).getType()))
			{
				this.foundTrough = false;
				this.foundFluid = true;
				return pos.immutable();
			}

			if (foodBlocks != null)
			{
				for (Class<? extends Block> clazz : foodBlocks)
				{
					if (clazz.isInstance(block))
					{
						this.foundTrough = false;
						this.foundFluid = false;
						return pos.immutable();
					}
				}
			}
		}
		return null;
	}

	private boolean isAcceptedFoodFluid(Fluid candidate)
	{
		Fluid[] foodFluids = this.entity.getFoodFluids();
		if (foodFluids == null)
			return false;
		for (Fluid fluid : foodFluids)
		{
			if (fluid == candidate)
				return true;
		}
		return false;
	}
}
