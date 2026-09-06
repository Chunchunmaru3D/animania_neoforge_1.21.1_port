package com.animania.addons.extra.common.entity.peafowl;

import java.util.Optional;
import java.util.UUID;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IChild;
import com.animania.common.entity.generic.GenericBehavior;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

 



public class EntityPeachickBase extends EntityAnimaniaPeacock implements IChild
{
	protected static final EntityDataAccessor<Float> ENTITY_AGE = SynchedEntityData.defineId(EntityPeachickBase.class, EntityDataSerializers.FLOAT);
	protected static final EntityDataAccessor<Optional<UUID>> PARENT_UNIQUE_ID = SynchedEntityData.defineId(EntityPeachickBase.class, EntityDataSerializers.OPTIONAL_UUID);

	protected int ageTimer;

	public EntityPeachickBase(EntityType<? extends EntityPeachickBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.CHILD;
		this.ageTimer = 0;
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		 
		 
		 
		builder.define(ENTITY_AGE, 0.0F);
		builder.define(PARENT_UNIQUE_ID, Optional.empty());
	}

	@Override
	public void aiStep()
	{
		super.aiStep();
		GenericBehavior.livingUpdateChild(this, EntityPeafowlBase.class);
	}

	@Override
	public boolean isBaby()
	{
		return true;
	}

	@Override
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		return BuiltInLootTables.EMPTY;
	}

	@Override
	public EntityDataAccessor<Float> getEntityAgeParam()
	{
		return ENTITY_AGE;
	}

	@Override
	public EntityDataAccessor<Optional<UUID>> getParentUniqueIdParam()
	{
		return PARENT_UNIQUE_ID;
	}

	@Override
	public int getAgeTimer()
	{
		return this.ageTimer;
	}

	@Override
	public void setAgeTimer(int timer)
	{
		this.ageTimer = timer;
	}

	@Override
	public float getSizeDividend()
	{
		return 2.125F;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putFloat("EntityAge", this.getEntityAge());
		UUID parent = this.getParentUniqueId();
		if (parent != null)
			tag.putUUID("ParentUUID", parent);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		if (tag.contains("EntityAge"))
			this.setEntityAge(tag.getFloat("EntityAge"));
		if (tag.hasUUID("ParentUUID"))
			this.setParentUniqueId(tag.getUUID("ParentUUID"));
	}
}
