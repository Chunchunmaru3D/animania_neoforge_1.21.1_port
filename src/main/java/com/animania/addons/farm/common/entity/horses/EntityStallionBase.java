package com.animania.addons.farm.common.entity.horses;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmSounds;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IMateable;
import com.animania.api.interfaces.ISterilizable;
import com.animania.common.entity.generic.GenericBehavior;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.level.Level;

 




public class EntityStallionBase extends EntityAnimaniaHorse implements IMateable, ISterilizable
{
	protected static final EntityDataAccessor<Boolean> STERILIZED = SynchedEntityData.defineId(EntityStallionBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityStallionBase.class, EntityDataSerializers.OPTIONAL_UUID);

	public EntityStallionBase(EntityType<? extends EntityStallionBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.MALE;
		this.mateable = true;
	}

	public static AttributeSupplier.Builder createStallionAttributes()
	{
		return EntityAnimaniaHorse.createAnimaniaHorseAttributes()
				.add(Attributes.MAX_HEALTH, 24.0D)
				.add(Attributes.ATTACK_DAMAGE, 4.0D);
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		if (!this.getSterilized())
			this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(STERILIZED, false);
		builder.define(MATE_UNIQUE_ID, Optional.empty());
	}

	 





	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float partialTick)
	{
		return new Vec3(0.0D, dimensions.height() * 0.72D, 0.0D);
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
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.HORSE_HURT_1.get(), FarmSounds.HORSE_HURT_2.get(), FarmSounds.HORSE_HURT_3.get());
	}

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null && !this.getSleeping())
			this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch() - 0.2F);
	}

	@Override
	public void aiStep()
	{
		if (this.getColorNumber() > 5)
			this.setColorNumber(0);

		GenericBehavior.livingUpdateMateable(this, EntityMareBase.class);
		super.aiStep();
	}

	@Override
	public EntityStallionBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
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
		this.goalSelector.removeAllGoals(goal -> goal instanceof BreedGoal);
	}
}
