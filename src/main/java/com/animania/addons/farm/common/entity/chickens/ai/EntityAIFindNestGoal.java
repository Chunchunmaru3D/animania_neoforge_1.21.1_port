package com.animania.addons.farm.common.entity.chickens.ai;

import java.util.EnumSet;

import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.common.entity.chickens.ChickenRhodeIslandRed.EntityHenRhodeIslandRed;
import com.animania.addons.farm.common.entity.chickens.ChickenWyandotte.EntityHenWyandotte;
import com.animania.addons.farm.common.entity.chickens.EntityHenBase;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.blocks.BlockNest;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

 










public class EntityAIFindNestGoal extends Goal
{
	private final EntityHenBase hen;
	private final double speed;
	private BlockPos nestPos;
	private int layTimer;

	public EntityAIFindNestGoal(EntityHenBase hen, double speed)
	{
		this.hen = hen;
		this.speed = speed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		if (!FarmConfig.settings.chickensDropEggs.get())
			return false;

		if (this.hen.getLaid() || this.hen.getSleeping() || !this.hen.level().isDay())
			return false;

		if (this.hen.getRandom().nextInt(20) != 0)
			return false;

		this.nestPos = this.findNest();
		return this.nestPos != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.nestPos != null && !this.hen.getLaid() && !this.hen.getSleeping();
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

		if (this.hen.blockPosition().distSqr(this.nestPos) <= 4.0)
		{
			this.hen.getLookControl().setLookAt(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5);
			this.layTimer++;
			if (this.layTimer >= 60)
			{
				if (this.hen.level().getBlockEntity(this.nestPos) instanceof BlockEntityNest te && te.layEgg(getEggItem(this.hen), this.hen.type.name()))
					this.hen.setLaid(true);

				this.nestPos = null;
			}
		}
		else if (this.hen.getNavigation().isDone())
			this.moveToNest();
	}

	private void moveToNest()
	{
		if (this.nestPos != null)
			this.hen.getNavigation().moveTo(this.nestPos.getX() + 0.5, this.nestPos.getY(), this.nestPos.getZ() + 0.5, this.speed);
	}

	private BlockPos findNest()
	{
		Item eggItem = getEggItem(this.hen);
		BlockPos origin = this.hen.blockPosition();
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-10, -3, -10), origin.offset(10, 3, 10)))
		{
			if (!(this.hen.level().getBlockState(pos).getBlock() instanceof BlockNest))
				continue;

			if (this.hen.level().getBlockEntity(pos) instanceof BlockEntityNest te && te.hasRoomFor(eggItem, this.hen.type.name()))
				return pos.immutable();
		}
		return null;
	}

	 
	private static Item getEggItem(EntityHenBase hen)
	{
		if (hen instanceof EntityHenRhodeIslandRed || hen instanceof EntityHenWyandotte)
			return FarmItems.BROWN_EGG.get();
		return Items.EGG;
	}
}
