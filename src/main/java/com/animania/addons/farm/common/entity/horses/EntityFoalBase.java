package com.animania.addons.farm.common.entity.horses;

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

 




public class EntityFoalBase extends EntityAnimaniaHorse implements IChild
{
	protected static final EntityDataAccessor<Optional<UUID>> PARENT_UNIQUE_ID = SynchedEntityData.defineId(EntityFoalBase.class, EntityDataSerializers.OPTIONAL_UUID);
	protected static final EntityDataAccessor<Float> ENTITY_AGE = SynchedEntityData.defineId(EntityFoalBase.class, EntityDataSerializers.FLOAT);

	protected int ageTimer;

	public EntityFoalBase(EntityType<? extends EntityFoalBase> entityType, Level level)
	{
		super(entityType, level);
		this.ageTimer = 0;
		this.gender = EntityGender.CHILD;
	}

	public static AttributeSupplier.Builder createFoalAttributes()
	{
		return EntityAnimaniaHorse.createAnimaniaHorseAttributes()
				.add(Attributes.MAX_HEALTH, 12.0D)
				.add(Attributes.ATTACK_DAMAGE, 4.0D);
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
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		return BuiltInLootTables.EMPTY;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.HORSE_LIVING_1.get(), FarmSounds.HORSE_LIVING_2.get(), FarmSounds.HORSE_LIVING_3.get(),
				FarmSounds.HORSE_LIVING_4.get(), FarmSounds.HORSE_LIVING_5.get(), FarmSounds.HORSE_LIVING_6.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.HORSE_HURT_1.get(), FarmSounds.HORSE_HURT_2.get(), FarmSounds.HORSE_HURT_3.get());
	}

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null && !this.getSleeping())
			this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch() + 0.2F - (this.getEntityAge() * 2F));
	}

	@Override
	public void aiStep()
	{
		if (this.getColorNumber() > 5)
			this.setColorNumber(0);

		GenericBehavior.livingUpdateChild(this, EntityMareBase.class);
		super.aiStep();
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return !stack.isEmpty() && AnimaniaHelper.containsItemStack(this.getFoodItems(), stack);
	}

	@Override
	public EntityFoalBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
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
		return 1.889f;
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
