package com.animania.addons.farm.common.entity.pigs;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmSounds;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IImpregnable;
import com.animania.api.interfaces.IMateable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

 


public class EntitySowBase extends EntityAnimaniaPig implements IMateable, IImpregnable
{
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntitySowBase.class, EntityDataSerializers.OPTIONAL_UUID);
	protected static final EntityDataAccessor<Boolean> PREGNANT = SynchedEntityData.defineId(EntitySowBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HAS_KIDS = SynchedEntityData.defineId(EntitySowBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> FERTILE = SynchedEntityData.defineId(EntitySowBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> GESTATION_TIMER = SynchedEntityData.defineId(EntitySowBase.class, EntityDataSerializers.INT);

	public int dryTimerSow;

	public EntitySowBase(EntityType<? extends EntitySowBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.FEMALE;
	}

	public static AttributeSupplier.Builder createSowAttributes()
	{
		return EntityAnimaniaPig.createAnimaniaPigAttributes()
				.add(Attributes.MAX_HEALTH, 12.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.265D);
	}

	@Override
	public net.minecraft.world.entity.SpawnGroupData finalizeSpawn(net.minecraft.world.level.ServerLevelAccessor level,
			net.minecraft.world.DifficultyInstance difficulty, net.minecraft.world.entity.MobSpawnType spawnType,
			@Nullable net.minecraft.world.entity.SpawnGroupData spawnGroupData)
	{
		GenericBehavior.initialSpawnFemale(this, EntityAnimaniaPig.class);
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
		builder.define(GESTATION_TIMER, AnimaniaConfig.careAndFeeding.gestationTimer.get() + this.random.nextInt(200));
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
	public int getDryTimer()
	{
		return this.dryTimerSow;
	}

	@Override
	public void setDryTimer(int i)
	{
		this.dryTimerSow = i;
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
	public EntityDataAccessor<Optional<UUID>> getMateUniqueIdParam()
	{
		return MATE_UNIQUE_ID;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.PIG_1.get(), FarmSounds.PIG_2.get(), FarmSounds.PIG_4.get(),
				FarmSounds.PIG_5.get(), FarmSounds.PIG_6.get(), FarmSounds.PIG_7.get());
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
		GenericBehavior.livingUpdateFemale(this, EntityHogBase.class);
		super.aiStep();
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return !stack.isEmpty() && (AnimaniaHelper.containsItemStack(this.getFoodItems(), stack) || stack.is(com.animania.common.fluids.CommonFluids.SLOP_BUCKET.get()));
	}

	@Override
	public EntitySowBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}
}
