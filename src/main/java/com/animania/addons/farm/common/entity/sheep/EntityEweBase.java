package com.animania.addons.farm.common.entity.sheep;

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
import net.minecraft.sounds.SoundEvents;
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

 






public class EntityEweBase extends EntityAnimaniaSheep implements IMateable, IImpregnable
{
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityEweBase.class, EntityDataSerializers.OPTIONAL_UUID);
	protected static final EntityDataAccessor<Boolean> PREGNANT = SynchedEntityData.defineId(EntityEweBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HAS_KIDS = SynchedEntityData.defineId(EntityEweBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> FERTILE = SynchedEntityData.defineId(EntityEweBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> GESTATION_TIMER = SynchedEntityData.defineId(EntityEweBase.class, EntityDataSerializers.INT);

	public int dryTimer;

	public EntityEweBase(EntityType<? extends EntityEweBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.FEMALE;
		this.mateable = true;
	}

	public static AttributeSupplier.Builder createEweAttributes()
	{
		return EntityAnimaniaSheep.createAnimaniaSheepAttributes()
				.add(Attributes.MAX_HEALTH, 15.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.265D);
	}

	@Override
	public net.minecraft.world.entity.SpawnGroupData finalizeSpawn(net.minecraft.world.level.ServerLevelAccessor level,
			net.minecraft.world.DifficultyInstance difficulty, net.minecraft.world.entity.MobSpawnType spawnType,
			@Nullable net.minecraft.world.entity.SpawnGroupData spawnGroupData)
	{
		GenericBehavior.initialSpawnFemale(this, EntityAnimaniaSheep.class);
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
		return this.dryTimer;
	}

	@Override
	public void setDryTimer(int i)
	{
		this.dryTimer = i;
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
				FarmSounds.SHEEP_LIVING_1.get(), FarmSounds.SHEEP_LIVING_2.get(), FarmSounds.SHEEP_LIVING_3.get(),
				FarmSounds.SHEEP_LIVING_4.get(), FarmSounds.SHEEP_LIVING_5.get(), FarmSounds.SHEEP_LIVING_6.get(), FarmSounds.SHEEP_LIVING_7.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.SHEEP_HURT_1.get(), FarmSounds.SHEEP_LIVING_7.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return GenericBehavior.getRandomSound(FarmSounds.SHEEP_HURT_1.get(), FarmSounds.SHEEP_LIVING_7.get());
	}

	@Override
	public void playAmbientSound()
	{
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null && !this.getSleeping())
			this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch());
	}

	@Override
	public void aiStep()
	{
		GenericBehavior.livingUpdateFemale(this, EntityRamBase.class);
		super.aiStep();
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (this.getFed() && this.getWatered() && !stack.isEmpty() && this.getHasKids())
		{
			if (stack.is(Items.BUCKET))
			{
				if (!this.level().isClientSide)
				{
					player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
					stack.shrink(1);
					AnimaniaHelper.addItem(player, new ItemStack(com.animania.addons.farm.FarmItems.SHEEP_MILK_BUCKET.get()));
					this.setWatered(false);
				}
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			}
		}

		return super.mobInteract(player, hand);
	}

	@Override
	public EntityEweBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}
}
