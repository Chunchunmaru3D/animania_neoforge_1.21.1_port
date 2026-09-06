package com.animania.addons.farm.common.entity.cows;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.addons.farm.FarmSounds;
import com.animania.common.fluids.CommonFluids;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IImpregnable;
import com.animania.api.interfaces.IMateable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

 








public class EntityCowBase extends EntityAnimaniaCow implements IMateable, IImpregnable
{
	protected static final EntityDataAccessor<Boolean> PREGNANT = SynchedEntityData.defineId(EntityCowBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HAS_KIDS = SynchedEntityData.defineId(EntityCowBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> FERTILE = SynchedEntityData.defineId(EntityCowBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> GESTATION_TIMER = SynchedEntityData.defineId(EntityCowBase.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityCowBase.class, EntityDataSerializers.OPTIONAL_UUID);

	public int dryTimer;

	public EntityCowBase(EntityType<? extends EntityCowBase> entityType, Level level)
	{
		super(entityType, level);
		this.mateable = true;
		this.gender = EntityGender.FEMALE;
	}

	public static AttributeSupplier.Builder createCowAttributes()
	{
		return EntityAnimaniaCow.createAnimaniaCowAttributes()
				.add(Attributes.MAX_HEALTH, 18.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2D, false));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(PREGNANT, false);
		builder.define(HAS_KIDS, com.animania.addons.farm.config.FarmConfig.settings.cowsMilkableAtSpawn.get());
		builder.define(FERTILE, true);
		builder.define(GESTATION_TIMER, AnimaniaConfig.careAndFeeding.gestationTimer.get() + this.random.nextInt(200));
		builder.define(MATE_UNIQUE_ID, Optional.empty());
	}

	@Override
	public boolean doHurtTarget(Entity entityIn)
	{
		if (this.getSleeping())
		{
			this.setSleeping(false);
			this.setSleepTimer(0F);
			this.jumpFromGround();
		}

		boolean flag = entityIn.hurt(this.damageSources().mobAttack(this), 2.0F);

		 

		if (entityIn instanceof Player)
			((LivingEntity) entityIn).knockback(1, this.getX() - entityIn.getX(), this.getZ() - entityIn.getZ());

		return flag;
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		if (!this.getSleeping())
			this.level().broadcastEntityEvent(this, (byte) 18);
	}

	@Override
	public net.minecraft.world.entity.SpawnGroupData finalizeSpawn(net.minecraft.world.level.ServerLevelAccessor level,
			net.minecraft.world.DifficultyInstance difficulty, net.minecraft.world.entity.MobSpawnType spawnType,
			@Nullable net.minecraft.world.entity.SpawnGroupData spawnGroupData)
	{
		GenericBehavior.initialSpawnFemale(this, EntityAnimaniaCow.class);
		return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
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
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.COW_MOO_1.get(), FarmSounds.COW_MOO_3.get(), FarmSounds.COW_MOO_4.get(), FarmSounds.COW_MOO_4.get(),
				FarmSounds.COW_MOO_5.get(), FarmSounds.COW_MOO_6.get(), FarmSounds.COW_MOO_7.get(), FarmSounds.COW_MOO_8.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return Animania.RANDOM.nextBoolean() ? FarmSounds.COW_HURT_1.get() : FarmSounds.COW_HURT_2.get();
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return Animania.RANDOM.nextBoolean() ? FarmSounds.COW_DEATH_1.get() : FarmSounds.COW_DEATH_2.get();
	}

	@Override
	protected void playStepSound(net.minecraft.core.BlockPos pos, net.minecraft.world.level.block.state.BlockState state)
	{
		this.playSound(SoundEvents.COW_STEP, 0.10F, 1.0F);
	}

	@Override
	public void aiStep()
	{
		GenericBehavior.livingUpdateFemale(this, EntityBullBase.class);
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
					ItemStack milkStack;
					if (this.hasCustomName() && "purp".equals(this.getCustomName().getString().trim().toLowerCase()))
					{
						 
						milkStack = new ItemStack(Items.LAVA_BUCKET);
					}
					else
					{
						milkStack = this.milkBucket();
					}
					stack.shrink(1);
					AnimaniaHelper.addItem(player, milkStack);
					this.setWatered(false);
				}
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			}
			else if (stack.is(Items.GLASS_BOTTLE))
			{
				if (!this.level().isClientSide)
				{
					player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
					ItemStack milkBottle = new ItemStack(Items.POTION);
					milkBottle.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));
					stack.shrink(1);
					AnimaniaHelper.addItem(player, milkBottle);
					this.setWatered(false);
				}
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			}
		}

		return super.mobInteract(player, hand);
	}

	 



	private ItemStack milkBucket()
	{
		return switch (this.cowType)
		{
			case FRIESIAN -> new ItemStack(CommonFluids.MILK_FRIESIAN_BUCKET.get());
			case HOLSTEIN -> new ItemStack(CommonFluids.MILK_HOLSTEIN_BUCKET.get());
			case JERSEY -> new ItemStack(CommonFluids.MILK_JERSEY_BUCKET.get());
			default -> new ItemStack(Items.MILK_BUCKET);
		};
	}

	@Override
	public EntityCowBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
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
}
