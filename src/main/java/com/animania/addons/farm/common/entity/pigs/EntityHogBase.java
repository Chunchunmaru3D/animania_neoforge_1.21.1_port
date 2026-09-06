package com.animania.addons.farm.common.entity.pigs;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmSounds;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IMateable;
import com.animania.api.interfaces.ISterilizable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

 



public class EntityHogBase extends EntityAnimaniaPig implements IMateable, ISterilizable
{
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityHogBase.class, EntityDataSerializers.OPTIONAL_UUID);
	protected static final EntityDataAccessor<Boolean> STERILIZED = SynchedEntityData.defineId(EntityHogBase.class, EntityDataSerializers.BOOLEAN);

	public EntityHogBase(EntityType<? extends EntityHogBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.MALE;
	}

	public static AttributeSupplier.Builder createHogAttributes()
	{
		return EntityAnimaniaPig.createAnimaniaPigAttributes()
				.add(Attributes.MAX_HEALTH, 14.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.265D);
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		if (!this.getSterilized())
			this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(MATE_UNIQUE_ID, Optional.empty());
		builder.define(STERILIZED, false);
	}

	@Override
	public EntityDataAccessor<Optional<UUID>> getMateUniqueIdParam()
	{
		return MATE_UNIQUE_ID;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.HOG_1.get(), FarmSounds.HOG_2.get(), FarmSounds.HOG_3.get(), FarmSounds.HOG_4.get(), FarmSounds.HOG_5.get(),
				FarmSounds.PIG_1.get(), FarmSounds.PIG_2.get(), FarmSounds.PIG_4.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.PIG_HURT_1.get(), FarmSounds.PIG_HURT_2.get(), FarmSounds.PIG_3.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return GenericBehavior.getRandomSound(FarmSounds.PIG_HURT_1.get(), FarmSounds.PIG_HURT_2.get(), FarmSounds.PIG_3.get());
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
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);
		if (!stack.isEmpty() && stack.is(Items.CARROT_ON_A_STICK) && !this.isVehicle() && this.getWatered() && this.getFed())
		{
			player.startRiding(this);
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}
		return super.mobInteract(player, hand);
	}

	@Override
	public void aiStep()
	{
		GenericBehavior.livingUpdateMateable(this, EntitySowBase.class);
		super.aiStep();
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return !stack.isEmpty() && (AnimaniaHelper.containsItemStack(this.getFoodItems(), stack) || stack.is(com.animania.common.fluids.CommonFluids.SLOP_BUCKET.get()));
	}

	@Override
	public EntityHogBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
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
