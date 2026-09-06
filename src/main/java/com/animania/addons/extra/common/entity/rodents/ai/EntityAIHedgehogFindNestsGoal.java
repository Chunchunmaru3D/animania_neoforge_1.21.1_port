package com.animania.addons.extra.common.entity.rodents.ai;

import java.util.EnumSet;

import com.animania.addons.extra.common.entity.rodents.EntityHedgehogBase;
import com.animania.addons.farm.FarmItems;
import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.blocks.BlockNest;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

 





public class EntityAIHedgehogFindNestsGoal extends Goal
{
	private final EntityHedgehogBase hedgehog;
	private final double speed;
	private BlockPos nestPos;
	private int eatTimer;

	public EntityAIHedgehogFindNestsGoal(EntityHedgehogBase hedgehog, double speed)
	{
		this.hedgehog = hedgehog;
		this.speed = speed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (this.hedgehog.getFed() || this.hedgehog.getSleeping())
			return false;

		if (this.hedgehog.getRandom().nextInt(20) != 0)
			return false;

		this.nestPos = this.findNestWithEgg();
		return this.nestPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.nestPos != null && !this.hedgehog.getFed() && !this.hedgehog.getSleeping();
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

		if (this.hedgehog.blockPosition().distSqr(this.nestPos) <= 4.0)
		{
			this.hedgehog.getLookControl().setLookAt(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5);
			this.eatTimer++;
			if (this.eatTimer >= 30)
			{
				if (this.hedgehog.level().getBlockEntity(this.nestPos) instanceof BlockEntityNest te)
				{
					ItemStack stack = te.getItemHandler().getStackInSlot(0);
					if (isChickenEgg(stack))
					{
						te.getItemHandler().extractItem(0, 1, false);
						this.hedgehog.setFed(true);
					}
				}

				this.nestPos = null;
			}
		}
		else if (this.hedgehog.getNavigation().isDone())
			this.moveToNest();
	}

	private void moveToNest()
	{
		if (this.nestPos != null)
			this.hedgehog.getNavigation().moveTo(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5, this.speed);
	}

	private static boolean isChickenEgg(ItemStack stack)
	{
		return !stack.isEmpty() && (stack.is(Items.EGG) || stack.is(FarmItems.BROWN_EGG.get()));
	}

	private BlockPos findNestWithEgg()
	{
		BlockPos origin = this.hedgehog.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-16, -3, -16), origin.offset(16, 3, 16)))
		{
			if (!(this.hedgehog.level().getBlockState(pos).getBlock() instanceof BlockNest))
				continue;

			if (this.hedgehog.level().getBlockEntity(pos) instanceof BlockEntityNest te && isChickenEgg(te.getItemHandler().getStackInSlot(0)))
				return pos.immutable();
		}
		return null;
	}
}
