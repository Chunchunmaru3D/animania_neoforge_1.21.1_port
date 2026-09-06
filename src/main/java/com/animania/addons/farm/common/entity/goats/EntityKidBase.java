package com.animania.addons.farm.common.entity.goats;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmSounds;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IChild;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

 


public class EntityKidBase extends EntityAnimaniaGoat implements IChild
{
	protected static final EntityDataAccessor<Optional<UUID>> PARENT_UNIQUE_ID = SynchedEntityData.defineId(EntityKidBase.class, EntityDataSerializers.OPTIONAL_UUID);
	protected static final EntityDataAccessor<Float> ENTITY_AGE = SynchedEntityData.defineId(EntityKidBase.class, EntityDataSerializers.FLOAT);

	protected int ageTimer;

	public EntityKidBase(EntityType<? extends EntityKidBase> entityType, Level level)
	{
		super(entityType, level);
		this.ageTimer = 0;
		this.gender = EntityGender.CHILD;
	}

	public static AttributeSupplier.Builder createKidAttributes()
	{
		return EntityAnimaniaGoat.createAnimaniaGoatAttributes()
				.add(Attributes.MAX_HEALTH, 8.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.315D);
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.1D));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(ENTITY_AGE, 0F);
		builder.define(PARENT_UNIQUE_ID, Optional.empty());
	}

	@Override
	public boolean isBaby()
	{
		return true;
	}

	@Override
	public ResourceKey<LootTable> getDefaultLootTable()
	{
		return BuiltInLootTables.EMPTY;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this, FarmSounds.KID_LIVING_1.get(), FarmSounds.KID_LIVING_2.get(), FarmSounds.KID_LIVING_3.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.KID_HURT_1.get(), FarmSounds.KID_HURT_2.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return GenericBehavior.getRandomSound(FarmSounds.KID_HURT_1.get(), FarmSounds.KID_HURT_2.get());
	}

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null && !this.getSleeping())
			this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch());
	}

	@Override
	public void aiStep()
	{
		super.aiStep();
		GenericBehavior.livingUpdateChild(this, EntityDoeBase.class);
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return !stack.isEmpty() && AnimaniaHelper.containsItemStack(this.getFoodItems(), stack);
	}

	@Override
	public EntityKidBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
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
		return 3.0357143f;
	}

	@Override
	public void addAdditionalSaveData(net.minecraft.nbt.CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putFloat("EntityAge", this.getEntityAge());
		UUID parent = this.getParentUniqueId();
		if (parent != null)
			tag.putUUID("ParentUUID", parent);
	}

	@Override
	public void readAdditionalSaveData(net.minecraft.nbt.CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		if (tag.contains("EntityAge"))
			this.setEntityAge(tag.getFloat("EntityAge"));
		if (tag.hasUUID("ParentUUID"))
			this.setParentUniqueId(tag.getUUID("ParentUUID"));
	}
}
