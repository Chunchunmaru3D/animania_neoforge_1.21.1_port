package com.animania.addons.extra.common.entity.peafowl.ai;

import java.util.EnumSet;

import com.animania.addons.extra.common.entity.peafowl.EntityPeafowlBase;
import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.blocks.BlockNest;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.Item;

 







public class EntityAIFindPeacockNestGoal extends Goal
{
	private final EntityPeafowlBase peahen;
	private final double speed;
	private BlockPos nestPos;
	private int layTimer;

	public EntityAIFindPeacockNestGoal(EntityPeafowlBase peahen, double speed)
	{
		this.peahen = peahen;
		this.speed = speed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (this.peahen.getLaid() || this.peahen.getSleeping() || !this.peahen.level().isDay())
			return false;

		if (!this.peahen.getWatered() || !this.peahen.getFed())
			return false;

		if (this.peahen.getRandom().nextInt(20) != 0)
			return false;

		this.nestPos = this.findNest();
		return this.nestPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.nestPos != null && !this.peahen.getLaid() && !this.peahen.getSleeping();
	}

	@Override
	public void start()
	{
		this.layTimer = 0;
		this.moveToNest();
	}

	@Override
	public void tick()
	{
		if (this.nestPos == null)
			return;

		if (this.peahen.blockPosition().distSqr(this.nestPos) <= 4.0)
		{
			this.peahen.getLookControl().setLookAt(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5);
			this.layTimer++;
			if (this.layTimer >= 60)
			{
				Item eggItem = this.peahen.type.getEggItem();
				if (this.peahen.level().getBlockEntity(this.nestPos) instanceof BlockEntityNest te && te.layEgg(eggItem, this.peahen.type.name()))
					this.peahen.setLaid(true);

				this.nestPos = null;
			}
		}
		else if (this.peahen.getNavigation().isDone())
			this.moveToNest();
	}

	private void moveToNest()
	{
		if (this.nestPos != null)
			this.peahen.getNavigation().moveTo(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5, this.speed);
	}

	private BlockPos findNest()
	{
		Item eggItem = this.peahen.type.getEggItem();
		BlockPos origin = this.peahen.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-10, -3, -10), origin.offset(10, 3, 10)))
		{
			if (!(this.peahen.level().getBlockState(pos).getBlock() instanceof BlockNest))
				continue;

			if (this.peahen.level().getBlockEntity(pos) instanceof BlockEntityNest te && te.hasRoomFor(eggItem, this.peahen.type.name()))
				return pos.immutable();
		}
		return null;
	}
}
