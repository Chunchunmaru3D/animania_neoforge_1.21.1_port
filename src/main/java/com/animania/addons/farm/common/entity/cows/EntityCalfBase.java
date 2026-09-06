package com.animania.addons.farm.common.entity.cows;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IChild;
import com.animania.common.entity.generic.GenericBehavior;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

 


public class EntityCalfBase extends EntityAnimaniaCow implements IChild
{
	protected static final EntityDataAccessor<Float> ENTITY_AGE = SynchedEntityData.defineId(EntityCalfBase.class, EntityDataSerializers.FLOAT);
	protected static final EntityDataAccessor<Optional<UUID>> PARENT_UNIQUE_ID = SynchedEntityData.defineId(EntityCalfBase.class, EntityDataSerializers.OPTIONAL_UUID);

	protected int ageTimer;

	public EntityCalfBase(EntityType<? extends EntityCalfBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.CHILD;
		this.ageTimer = 0;
	}

	public static AttributeSupplier.Builder createCalfAttributes()
	{
		return EntityAnimaniaCow.createAnimaniaCowAttributes()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.26D);
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
	public void setInLove(Player player)
	{
		this.level().broadcastEntityEvent(this, (byte) 18);
	}

	@Override
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		return BuiltInLootTables.EMPTY;
	}

	@Override
	public void aiStep()
	{
		super.aiStep();
		GenericBehavior.livingUpdateChild(this, EntityCowBase.class);
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				com.animania.addons.farm.FarmSounds.MOO_CALF_1.get(),
				com.animania.addons.farm.FarmSounds.MOO_CALF_2.get(),
				com.animania.addons.farm.FarmSounds.MOO_CALF_3.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source)
	{
		return GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.MOO_CALF_1.get(),
				com.animania.addons.farm.FarmSounds.MOO_CALF_2.get(),
				com.animania.addons.farm.FarmSounds.MOO_CALF_3.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.MOO_CALF_1.get(),
				com.animania.addons.farm.FarmSounds.MOO_CALF_2.get(),
				com.animania.addons.farm.FarmSounds.MOO_CALF_3.get());
	}

	@Override
	protected void playStepSound(net.minecraft.core.BlockPos pos, net.minecraft.world.level.block.state.BlockState state)
	{
		this.playSound(net.minecraft.sounds.SoundEvents.COW_STEP, 0.05F, 1.1F);
	}

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null)
			this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch() + 0.2F - (this.getEntityAge() * 2));
	}

	@Override
	public EntityCalfBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
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
		return 1F;
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
