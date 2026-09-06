package com.animania.addons.farm.common.entity.goats;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmSounds;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IMateable;
import com.animania.api.interfaces.ISterilizable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.entity.generic.ai.GenericAIButtHeadsGoatsGoal;
import com.animania.common.entity.generic.ai.GenericAIGoatsLeapAtTargetGoal;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

 



public class EntityBuckBase extends EntityAnimaniaGoat implements IMateable, ISterilizable
{
	protected static final EntityDataAccessor<Boolean> FIGHTING = SynchedEntityData.defineId(EntityBuckBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> STERILIZED = SynchedEntityData.defineId(EntityBuckBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Optional<UUID>> RIVAL_UNIQUE_ID = SynchedEntityData.defineId(EntityBuckBase.class, EntityDataSerializers.OPTIONAL_UUID);
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityBuckBase.class, EntityDataSerializers.OPTIONAL_UUID);

	public EntityBuckBase(EntityType<? extends EntityBuckBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.MALE;
		this.headbutting = true;
		this.mateable = true;
	}

	public static AttributeSupplier.Builder createBuckAttributes()
	{
		return EntityAnimaniaGoat.createAnimaniaGoatAttributes()
				.add(Attributes.MAX_HEALTH, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.265D);
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		if (AnimaniaConfig.gameRules.animalsCanAttackOthers.get() && !this.getSterilized())
		{
			this.goalSelector.addGoal(3, new GenericAIButtHeadsGoatsGoal(this, 1.3D));
			this.goalSelector.addGoal(3, new GenericAIGoatsLeapAtTargetGoal(this, 0.25F));
		}
		if (!this.getSterilized())
			this.goalSelector.addGoal(5, new BreedGoal(this, 1.0D));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(FIGHTING, false);
		builder.define(STERILIZED, false);
		builder.define(RIVAL_UNIQUE_ID, Optional.empty());
		builder.define(MATE_UNIQUE_ID, Optional.empty());
	}

	public boolean getFighting()
	{
		return this.getBoolFromDataManager(FIGHTING);
	}

	public void setFighting(boolean fighting)
	{
		this.entityData.set(FIGHTING, fighting);
	}

	@Nullable
	public UUID getRivalUniqueId()
	{
		return this.getUUIDFromDataManager(RIVAL_UNIQUE_ID);
	}

	public void setRivalUniqueId(@Nullable UUID uuid)
	{
		this.entityData.set(RIVAL_UNIQUE_ID, Optional.ofNullable(uuid));
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.GOAT_LIVING_1.get(), FarmSounds.GOAT_LIVING_2.get(), FarmSounds.GOAT_LIVING_2.get(),
				FarmSounds.GOAT_LIVING_3.get(), FarmSounds.GOAT_LIVING_4.get(), FarmSounds.GOAT_LIVING_5.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.GOAT_HURT_1.get(), FarmSounds.GOAT_HURT_2.get(), FarmSounds.GOAT_LIVING_3.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return GenericBehavior.getRandomSound(FarmSounds.GOAT_HURT_1.get(), FarmSounds.GOAT_HURT_2.get(), FarmSounds.GOAT_LIVING_3.get());
	}

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null && !this.getSleeping())
			this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch() - 0.2F);
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state)
	{
		this.playSound(SoundEvents.PIG_STEP, 0.10F, 0.8F);
	}

	@Override
	public void aiStep()
	{
		GenericBehavior.livingUpdateMateable(this, EntityDoeBase.class);
		super.aiStep();
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return !stack.isEmpty() && AnimaniaHelper.containsItemStack(this.getFoodItems(), stack);
	}

	@Override
	public EntityBuckBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public EntityDataAccessor<Optional<UUID>> getMateUniqueIdParam()
	{
		return MATE_UNIQUE_ID;
	}

	@Override
	public boolean getSterilized()
	{
		return this.getBoolFromDataManager(STERILIZED);
	}

	@Override
	public void setSterilized(boolean sterilized)
	{
		this.entityData.set(STERILIZED, sterilized);
	}

	@Override
	public void sterilize()
	{
		this.setSterilized(true);
		this.goalSelector.removeAllGoals(goal -> goal instanceof BreedGoal
				|| goal instanceof GenericAIButtHeadsGoatsGoal
				|| goal instanceof GenericAIGoatsLeapAtTargetGoal);
	}
}
