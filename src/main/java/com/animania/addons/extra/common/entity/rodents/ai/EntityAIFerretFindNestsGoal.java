package com.animania.addons.extra.common.entity.rodents.ai;

import java.util.EnumSet;

import com.animania.addons.extra.common.entity.rodents.EntityFerretBase;
import com.animania.addons.farm.FarmItems;
import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.blocks.BlockNest;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

 









public class EntityAIFerretFindNestsGoal extends Goal
{
	private final EntityFerretBase ferret;
	private final double speed;
	private BlockPos nestPos;
	private int eatTimer;

	public EntityAIFerretFindNestsGoal(EntityFerretBase ferret, double speed)
	{
		this.ferret = ferret;
		this.speed = speed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (this.ferret.getFed() || this.ferret.getSleeping())
			return false;

		if (this.ferret.getRandom().nextInt(20) != 0)
			return false;

		this.nestPos = this.findNestWithEgg();
		return this.nestPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.nestPos != null && !this.ferret.getFed() && !this.ferret.getSleeping();
	}

	@Override
	public void start()
	{
		this.eatTimer = 0;
		this.moveToNest();
	}

	@Override
	public void tick()
	{
		if (this.nestPos == null)
			return;

		if (this.ferret.blockPosition().distSqr(this.nestPos) <= 4.0)
		{
			this.ferret.getLookControl().setLookAt(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5);
			this.eatTimer++;
			if (this.eatTimer >= 30)
			{
				if (this.ferret.level().getBlockEntity(this.nestPos) instanceof BlockEntityNest te)
				{
					ItemStack stack = te.getItemHandler().getStackInSlot(0);
					if (isChickenEgg(stack))
					{
						te.getItemHandler().extractItem(0, 1, false);
						this.ferret.setFed(true);
						this.ferret.setWatered(true);
					}
				}

				this.nestPos = null;
			}
		}
		else if (this.ferret.getNavigation().isDone())
			this.moveToNest();
	}

	private void moveToNest()
	{
		if (this.nestPos != null)
			this.ferret.getNavigation().moveTo(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5, this.speed);
	}

	private static boolean isChickenEgg(ItemStack stack)
	{
		return !stack.isEmpty() && (stack.is(Items.EGG) || stack.is(FarmItems.BROWN_EGG.get()));
	}

	private BlockPos findNestWithEgg()
	{
		BlockPos origin = this.ferret.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-16, -3, -16), origin.offset(16, 3, 16)))
		{
			if (!(this.ferret.level().getBlockState(pos).getBlock() instanceof BlockNest))
				continue;

			if (this.ferret.level().getBlockEntity(pos) instanceof BlockEntityNest te && isChickenEgg(te.getItemHandler().getStackInSlot(0)))
				return pos.immutable();
		}
		return null;
	}
}
