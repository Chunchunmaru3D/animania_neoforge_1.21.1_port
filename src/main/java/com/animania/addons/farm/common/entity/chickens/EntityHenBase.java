package com.animania.addons.farm.common.entity.chickens;

import java.util.List;

import javax.annotation.Nullable;

import com.animania.addons.farm.config.FarmConfig;
import com.animania.api.data.EntityGender;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

 
















public class EntityHenBase extends EntityAnimaniaChicken
{
	protected static final EntityDataAccessor<Boolean> LAID = SynchedEntityData.defineId(EntityHenBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> LAID_TIMER = SynchedEntityData.defineId(EntityHenBase.class, EntityDataSerializers.INT);

	public EntityHenBase(EntityType<? extends EntityHenBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.FEMALE;
		this.eggTime = 6000;  
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(3, new com.animania.addons.farm.common.entity.chickens.ai.EntityAIFindNestGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new LeapAtTargetGoal(this, 0.2F));
		this.goalSelector.addGoal(10, new MeleeAttackGoal(this, 1.0D, true));
	}

	public static AttributeSupplier.Builder createHenAttributes()
	{
		return EntityAnimaniaChicken.createAnimaniaChickenAttributes()
				.add(Attributes.ATTACK_DAMAGE, 1.5D);
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData)
	{
		spawnGroupData = super.finalizeSpawn(levelAccessor, difficulty, spawnType, spawnGroupData);

		if (this.level().isClientSide)
			return spawnGroupData;

		List<EntityAnimaniaChicken> others = AnimaniaHelper.getEntitiesInRange(EntityAnimaniaChicken.class, 64, this.level(), this.blockPosition());

		if (others.size() <= 4)
		{
			int chooser = this.random.nextInt(3);

			if (chooser == 0)
			{
				LivingEntity entityChicken = this.type.getMale(this.level());
				if (entityChicken != null)
				{
					entityChicken.setPos(this.getX(), this.getY(), this.getZ());
					AnimaniaHelper.spawnEntity(this.level(), entityChicken);
				}
			}
			else if (chooser == 1)
			{
				LivingEntity entityChicken = this.type.getChild(this.level());
				if (entityChicken != null)
				{
					entityChicken.setPos(this.getX(), this.getY(), this.getZ());
					AnimaniaHelper.spawnEntity(this.level(), entityChicken);
				}
			}
		}

		this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(
				new AttributeModifier(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("animania", "random_spawn_bonus"),
						this.random.nextGaussian() * 0.05D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

		this.setLeftHanded(this.random.nextFloat() < 0.05F);

		return spawnGroupData;
	}

	@Override
	public boolean doHurtTarget(Entity entityIn)
	{
		if (this.getSleeping())
			this.setSleeping(false);

		boolean flag = entityIn.hurt(this.level().damageSources().mobAttack(this), 2.0F);

		 

		 
		if (entityIn instanceof Player)
			((LivingEntity) entityIn).knockback(1, this.getX() - entityIn.getX(), this.getZ() - entityIn.getZ());

		return flag;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(LAID, true);
		builder.define(LAID_TIMER, AnimaniaConfig.careAndFeeding.laidTimer.getDefault() / 2);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Laid", this.getLaid());
		tag.putInt("EggLayTime", this.eggTime);
		tag.putInt("LaidTimer", this.getLaidTimer());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.eggTime = tag.getInt("EggLayTime");
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
		if (!FarmConfig.settings.chickensDropEggs.get())
			this.eggTime = 1000;

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

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundEvent = this.getAmbientSound();

		if (soundEvent != null)
			this.playSound(soundEvent, this.getSoundVolume() - .3F, this.getVoicePitch());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return null;
	}
}
