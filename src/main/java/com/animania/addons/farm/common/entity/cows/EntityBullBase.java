package com.animania.addons.farm.common.entity.cows;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.addons.farm.FarmSounds;
import com.animania.addons.farm.common.entity.cows.ai.EntityAIAttackMeleeBulls;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IMateable;
import com.animania.api.interfaces.ISterilizable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.config.AnimaniaConfig;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

 


public class EntityBullBase extends EntityAnimaniaCow implements IMateable, ISterilizable
{
	protected static final EntityDataAccessor<Boolean> FIGHTING = SynchedEntityData.defineId(EntityBullBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> STERILIZED = SynchedEntityData.defineId(EntityBullBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityBullBase.class, EntityDataSerializers.OPTIONAL_UUID);

	public EntityBullBase(EntityType<? extends EntityBullBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.MALE;
		this.mateable = true;
	}

	public static AttributeSupplier.Builder createBullAttributes()
	{
		return EntityAnimaniaCow.createAnimaniaCowAttributes()
				.add(Attributes.MAX_HEALTH, 24.0D)
				.add(Attributes.ATTACK_DAMAGE, 4.0D);
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();

		if (AnimaniaConfig.gameRules.animalsCanAttackOthers.get() && !this.getSterilized())
			this.goalSelector.addGoal(0, new EntityAIAttackMeleeBulls(this, 1.8D, false));

		if (!this.getSterilized())
			this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));  
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(FIGHTING, false);
		builder.define(STERILIZED, false);
		builder.define(MATE_UNIQUE_ID, Optional.empty());
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		if (!this.getFighting() && !this.getSleeping())
			this.level().broadcastEntityEvent(this, (byte) 18);
	}

	public boolean getFighting()
	{
		return this.getBoolFromDataManager(FIGHTING);
	}

	public void setFighting(boolean fighting)
	{
		this.entityData.set(FIGHTING, fighting);
	}

	 



	@Override
	public float getHeadAnchorPointY(float partialTicks)
	{
		if (this.getFighting())
			return 0F;

		int t = this.getEatTimer();
		return t <= 0 ? 0.0F : t >= 4 && t <= 76 ? 1.0F : t < 4 ? (t - partialTicks) / 4.0F : -(t - 80 - partialTicks) / 4.0F;
	}

	@Override
	public float getHeadAngleX(float partialTicks)
	{
		if (this.getFighting())
			return this.getEatTimer() > 0 ? (float) Math.PI / 5F : this.getXRot() * ((float) Math.PI / 180F);

		int t = this.getEatTimer();
		if (t > 4 && t <= 76)
		{
			float f = (t - 4 - partialTicks) / 24.0F;
			return (float) Math.PI / 5F + (float) Math.PI * 7F / 150F * net.minecraft.util.Mth.sin(f * 28.7F);
		}
		return t > 0 ? (float) Math.PI / 5F : this.getXRot() * ((float) Math.PI / 180F);
	}

	@Override
	public boolean hurt(DamageSource source, float amount)
	{
		if (this.getSleeping())
			this.setSleeping(false);

		if (this.isInvulnerableTo(source))
			return false;

		return super.hurt(source, amount);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn)
	{
		boolean flag = entityIn.hurt(this.damageSources().mobAttack(this), 5.0F);

		 

		if (entityIn instanceof Player)
			((LivingEntity) entityIn).knockback(1, this.getX() - entityIn.getX(), this.getZ() - entityIn.getZ());

		return flag;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.BULL_MOO_1.get(), FarmSounds.BULL_MOO_2.get(), FarmSounds.BULL_MOO_3.get(), FarmSounds.BULL_MOO_4.get(),
				FarmSounds.BULL_MOO_5.get(), FarmSounds.BULL_MOO_6.get(), FarmSounds.BULL_MOO_7.get(), FarmSounds.BULL_MOO_8.get(),
				FarmSounds.COW_MOO_4.get(), FarmSounds.COW_MOO_8.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.ANGRY_BULL_1.get(), FarmSounds.ANGRY_BULL_2.get(), FarmSounds.ANGRY_BULL_3.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return Animania.RANDOM.nextBoolean() ? FarmSounds.COW_DEATH_1.get() : FarmSounds.COW_DEATH_2.get();
	}

	@Override
	public void aiStep()
	{
		GenericBehavior.livingUpdateMateable(this, EntityCowBase.class);
		super.aiStep();
	}

	@Override
	public EntityBullBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Fighting", this.getFighting());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setFighting(tag.getBoolean("Fighting"));
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
		this.goalSelector.removeAllGoals(goal -> goal instanceof BreedGoal || goal instanceof EntityAIAttackMeleeBulls);
	}

	@Override
	public EntityDataAccessor<Optional<UUID>> getMateUniqueIdParam()
	{
		return MATE_UNIQUE_ID;
	}
}
