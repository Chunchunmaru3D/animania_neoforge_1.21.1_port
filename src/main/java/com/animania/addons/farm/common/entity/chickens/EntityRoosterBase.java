package com.animania.addons.farm.common.entity.chickens;

import java.util.List;

import com.animania.Animania;
import com.animania.addons.farm.FarmSounds;
import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.api.data.EntityGender;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

 










public class EntityRoosterBase extends EntityAnimaniaChicken
{
	protected static final EntityDataAccessor<Integer> CROWTIMER = SynchedEntityData.defineId(EntityRoosterBase.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Integer> CROWDURATION = SynchedEntityData.defineId(EntityRoosterBase.class, EntityDataSerializers.INT);

	public EntityRoosterBase(EntityType<? extends EntityRoosterBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.MALE;
		this.eggTime = 1000;
	}

	public static AttributeSupplier.Builder createRoosterAttributes()
	{
		return EntityAnimaniaChicken.createAnimaniaChickenAttributes()
				.add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.2F));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));

		if (FarmConfig.settings.roostersFight.getDefault())
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityRoosterBase.class, true));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(CROWTIMER, Animania.RANDOM.nextInt(200) + 200);
		builder.define(CROWDURATION, 0);
	}

	public int getCrowTimer()
	{
		return this.getIntFromDataManager(CROWTIMER);
	}

	public void setCrowTimer(int timer)
	{
		this.entityData.set(CROWTIMER, timer);
	}

	public int getCrowDuration()
	{
		return this.getIntFromDataManager(CROWDURATION);
	}

	public void setCrowDuration(int duration)
	{
		this.entityData.set(CROWDURATION, duration);
	}

	@Override
	public void aiStep()
	{
		this.eggTime = 1000;

		long dayTime = this.level().getDayTime() % 24000;
		if ((dayTime > 23250 || dayTime < 500) && !this.getSleeping())
		{
			int crowTimer = this.getCrowTimer();
			if (crowTimer > 0)
			{
				this.setCrowTimer(crowTimer - 1);
			}
			else
			{
				this.setCrowDuration(80);
				this.setCrowTimer(Animania.RANDOM.nextInt(200) + 200);

				if (!this.level().isClientSide())
				{
					int chooser = Animania.RANDOM.nextInt(3);
					if (chooser == 0)
						this.level().playSound(null, this.blockPosition(), FarmSounds.CHICKEN_CROW_1.get(), SoundSource.PLAYERS, 0.7F, 0.95F + this.getVoicePitchModifier());
					else if (chooser == 1)
						this.level().playSound(null, this.blockPosition(), FarmSounds.CHICKEN_CROW_2.get(), SoundSource.PLAYERS, 0.65F, 0.9F + this.getVoicePitchModifier());
					else
						this.level().playSound(null, this.blockPosition(), FarmSounds.CHICKEN_CROW_3.get(), SoundSource.PLAYERS, 0.6F, 1.05F + this.getVoicePitchModifier());

					 
					 
					 
					 
					 
					 
					List<EntityAnimaniaCow> nearbyCows = AnimaniaHelper.getEntitiesInRange(EntityAnimaniaCow.class, 30, this.level(), this);
					for (EntityAnimaniaCow nearbyCow : nearbyCows)
					{
						if (nearbyCow.getSleeping())
						{
							nearbyCow.setSleeping(false);
							nearbyCow.setSleepTimer(0F);
						}
					}
				}
			}
		}

		int crowDuration = this.getCrowDuration();
		if (crowDuration > 0)
			this.setCrowDuration(crowDuration - 1);

		super.aiStep();
	}

	private float getVoicePitchModifier()
	{
		return (Animania.RANDOM.nextFloat() - 0.5F) * 0.1F;
	}

	@Override
	public boolean doHurtTarget(net.minecraft.world.entity.Entity entityIn)
	{
		boolean flag = entityIn.hurt(this.damageSources().mobAttack(this), 2.0F);

		 

		if (entityIn instanceof Player)
			((LivingEntity) entityIn).knockback(1, this.getX() - entityIn.getX(), this.getZ() - entityIn.getZ());

		return flag;
	}

	@Override
	protected SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source)
	{
		return Animania.RANDOM.nextInt(2) == 0 ? FarmSounds.CHICKEN_HURT_1.get() : FarmSounds.CHICKEN_HURT_2.get();
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return Animania.RANDOM.nextInt(2) == 0 ? FarmSounds.CHICKEN_DEATH_1.get() : FarmSounds.CHICKEN_DEATH_2.get();
	}

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundevent = this.getAmbientSound();

		if (soundevent != null && !this.getSleeping())
			this.playSound(soundevent, this.getSoundVolume() - 0.2F, this.getVoicePitch());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putInt("CrowTime", this.getCrowTimer());
		tag.putInt("CrowDuration", this.getCrowDuration());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setCrowTimer(tag.getInt("CrowTime"));
		this.setCrowDuration(tag.getInt("CrowDuration"));
	}
}
