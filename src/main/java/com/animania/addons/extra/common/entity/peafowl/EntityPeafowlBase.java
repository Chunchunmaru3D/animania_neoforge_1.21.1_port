package com.animania.addons.extra.common.entity.peafowl;

import com.animania.api.data.EntityGender;
import com.animania.config.AnimaniaConfig;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 








public class EntityPeafowlBase extends EntityAnimaniaPeacock
{
	protected static final EntityDataAccessor<Boolean> LAID = SynchedEntityData.defineId(EntityPeafowlBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> LAID_TIMER = SynchedEntityData.defineId(EntityPeafowlBase.class, EntityDataSerializers.INT);

	public EntityPeafowlBase(EntityType<? extends EntityPeafowlBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.FEMALE;
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(1, new com.animania.addons.extra.common.entity.peafowl.ai.EntityAIFindPeacockNestGoal(this, 1.0D));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(LAID, true);
		builder.define(LAID_TIMER, AnimaniaConfig.careAndFeeding.laidTimer.get() / 2);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Laid", this.getLaid());
		tag.putInt("LaidTimer", this.getLaidTimer());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setLaid(tag.getBoolean("Laid"));
		this.setLaidTimer(tag.getInt("LaidTimer"));
	}

	public int getLaidTimer()
	{
		return this.getIntFromDataManager(LAID_TIMER);
	}

	public void setLaidTimer(int laidTimer)
	{
		this.entityData.set(LAID_TIMER, laidTimer);
	}

	@Override
	public void aiStep()
	{
		super.aiStep();

		int laidTimer = this.getLaidTimer();
		if (laidTimer > -1)
		{
			laidTimer--;
			this.setLaidTimer(laidTimer);
		}
		else
			this.setLaid(false);
	}

	public boolean getLaid()
	{
		return this.getBoolFromDataManager(LAID);
	}

	public void setLaid(boolean laid)
	{
		if (laid)
		{
			this.entityData.set(LAID, true);
			this.setLaidTimer(AnimaniaConfig.careAndFeeding.laidTimer.get() + this.random.nextInt(100));
		}
		else
			this.entityData.set(LAID, false);
	}
}
