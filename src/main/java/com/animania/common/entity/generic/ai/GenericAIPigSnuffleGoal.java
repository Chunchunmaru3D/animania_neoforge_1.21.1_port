package com.animania.common.entity.generic.ai;

import java.util.EnumSet;
import java.util.List;

import com.animania.Animania;
import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.common.entity.pigs.EntityAnimaniaPig;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;

 









public class GenericAIPigSnuffleGoal extends Goal
{
	private final EntityAnimaniaPig entity;
	private final Block mudBlock;
	private int eatingTimer;
	private boolean hasSpawned;
	private boolean hasEaten;

	public int getEatingGrassTimer()
	{
		return this.eatingTimer;
	}

	public GenericAIPigSnuffleGoal(EntityAnimaniaPig entity, Block mudBlock)
	{
		this.entity = entity;
		this.mudBlock = mudBlock;
		this.setFlags(EnumSet.of(Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse()
	{
		BlockPos below = this.entity.blockPosition().below();
		if (this.entity.level().getBlockState(below).getBlock() == this.mudBlock)
			return false;

		if (this.entity.getSleeping() || this.entity.getFed())
			return false;

		return Animania.RANDOM.nextInt(120) == 50;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.eatingTimer > 0;
	}

	@Override
	public void start()
	{
		this.eatingTimer = 0;
		this.hasSpawned = false;
		this.hasEaten = false;
	}

	@Override
	public void stop()
	{
		this.eatingTimer = 0;
	}

	@Override
	public void tick()
	{
		this.eatingTimer++;

		BlockPos below = this.entity.blockPosition().below();
		if (this.entity.level().getBlockState(below).getBlock() == this.mudBlock)
		{
			this.stop();
			return;
		}

		if (this.entity.level().isClientSide)
			return;

		boolean isForest = this.entity.level().getBiome(below).is(BiomeTags.IS_FOREST);

		if (this.eatingTimer > 80 && isForest && !this.entity.isBaby()
				&& this.entity.isLeashed() && this.entity.getLeashHolder() instanceof Player)
		{
			this.entity.level().levelEvent(2001, below, net.minecraft.world.level.block.Block.getId(this.entity.level().getBlockState(below)));
			if (!this.hasSpawned)
			{
				ItemEntity truffle = new ItemEntity(this.entity.level(),
						below.getX() + 0.5, below.getY() + 1, below.getZ() + 0.5,
						new ItemStack(FarmItems.TRUFFLE.get(), Animania.RANDOM.nextInt(2) + 1));
				this.entity.level().addFreshEntity(truffle);
				this.hasSpawned = true;
			}
		}

		if (this.eatingTimer < 100 && !this.hasEaten)
		{
			List<ItemEntity> items = this.entity.level().getEntitiesOfClass(ItemEntity.class,
					new AABB(this.entity.blockPosition()).inflate(3));
			for (ItemEntity ei : items)
			{
				if (ei.getItem().is(FarmItems.TRUFFLE.get()))
				{
					ei.getItem().shrink(64);
					this.entity.setFed(true);
					this.hasEaten = true;
					break;
				}
			}
		}

		if (this.eatingTimer >= 100)
			this.stop();
	}
}
