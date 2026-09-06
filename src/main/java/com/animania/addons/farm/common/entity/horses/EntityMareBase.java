package com.animania.addons.farm.common.entity.horses;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmSounds;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IImpregnable;
import com.animania.api.interfaces.IMateable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.config.AnimaniaConfig;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

 





public class EntityMareBase extends EntityAnimaniaHorse implements IMateable, IImpregnable
{
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityMareBase.class, EntityDataSerializers.OPTIONAL_UUID);
	protected static final EntityDataAccessor<Boolean> PREGNANT = SynchedEntityData.defineId(EntityMareBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HAS_KIDS = SynchedEntityData.defineId(EntityMareBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> FERTILE = SynchedEntityData.defineId(EntityMareBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> GESTATION_TIMER = SynchedEntityData.defineId(EntityMareBase.class, EntityDataSerializers.INT);

	public int dryTimerMare;

	public EntityMareBase(EntityType<? extends EntityMareBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.FEMALE;
		this.mateable = true;
	}

	public static AttributeSupplier.Builder createMareAttributes()
	{
		return EntityAnimaniaHorse.createAnimaniaHorseAttributes()
				.add(Attributes.MAX_HEALTH, 20.0D)
				.add(Attributes.ATTACK_DAMAGE, 4.0D);
	}

	@Override
	public net.minecraft.world.entity.SpawnGroupData finalizeSpawn(net.minecraft.world.level.ServerLevelAccessor level,
			net.minecraft.world.DifficultyInstance difficulty, net.minecraft.world.entity.MobSpawnType spawnType,
			@Nullable net.minecraft.world.entity.SpawnGroupData spawnGroupData)
	{
		GenericBehavior.initialSpawnFemale(this, EntityAnimaniaHorse.class);
		return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(MATE_UNIQUE_ID, Optional.empty());
		builder.define(PREGNANT, false);
		builder.define(HAS_KIDS, false);
		builder.define(FERTILE, true);
		builder.define(GESTATION_TIMER, AnimaniaConfig.careAndFeeding.gestationTimer.get() + this.random.nextInt(400));
	}

	@Override
	public EntityDataAccessor<Integer> getGestationParam()
	{
		return GESTATION_TIMER;
	}

	@Override
	public EntityDataAccessor<Boolean> getPregnantParam()
	{
		return PREGNANT;
	}

	@Override
	public EntityDataAccessor<Boolean> getFertileParam()
	{
		return FERTILE;
	}

	@Override
	public EntityDataAccessor<Boolean> getHasKidsParam()
	{
		return HAS_KIDS;
	}

	@Override
	public int getDryTimer()
	{
		return this.dryTimerMare;
	}

	@Override
	public void setDryTimer(int i)
	{
		this.dryTimerMare = i;
	}

	@Override
	public EntityDataAccessor<Optional<UUID>> getMateUniqueIdParam()
	{
		return MATE_UNIQUE_ID;
	}

	 






	@Override
	protected net.minecraft.world.phys.Vec3 getPassengerAttachmentPoint(net.minecraft.world.entity.Entity passenger,
			net.minecraft.world.entity.EntityDimensions dimensions, float partialTick)
	{
		return new net.minecraft.world.phys.Vec3(0.0D, dimensions.height() * 0.60D, 0.0D);
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
			this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch() - 0.05F);
	}

	@Override
	public void aiStep()
	{
		if (this.getColorNumber() > 5)
			this.setColorNumber(0);

		GenericBehavior.livingUpdateFemale(this, EntityStallionBase.class);
		super.aiStep();
	}

	@Override
	public EntityMareBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;  
	}
}
