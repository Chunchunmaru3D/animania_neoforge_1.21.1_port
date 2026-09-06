package com.animania.addons.extra.common.entity.rodents;

import java.util.Set;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.amphibians.EntityAmphibian;
import com.animania.addons.extra.common.entity.amphibians.EntityFrogs;
import com.animania.addons.extra.common.entity.amphibians.EntityToad;
import com.animania.addons.extra.common.entity.rodents.ai.EntityAIHedgehogFindNestsGoal;
import com.animania.addons.extra.config.ExtraConfig;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;
import com.animania.api.interfaces.IAnimaniaAnimalBase;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.entity.generic.ai.GenericAIFindFoodGoal;
import com.animania.common.entity.generic.ai.GenericAIFindWaterGoal;
import com.animania.common.entity.generic.ai.GenericAISleepGoal;
import com.animania.common.entity.generic.ai.GenericAIWatchClosestGoal;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;
import com.google.common.collect.Sets;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;

 











public class EntityHedgehogBase extends TamableAnimal implements IAnimaniaAnimalBase
{
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityHedgehogBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityHedgehogBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityHedgehogBase.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityHedgehogBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityHedgehogBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityHedgehogBase.class, EntityDataSerializers.BOOLEAN);

	private int fedTimer;
	protected int wateredTimer;
	protected int happyTimer;
	public int blinkTimer;
	protected int damageTimer;
	public HedgehogType type = HedgehogType.NORMAL;
	protected net.minecraft.resources.ResourceLocation resourceLocation;

	public net.minecraft.resources.ResourceLocation getResourceLocation()
	{
		return this.resourceLocation;
	}

	public EntityHedgehogBase(EntityType<? extends EntityHedgehogBase> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() * 2 + this.random.nextInt(200);
		this.happyTimer = 60;
		this.blinkTimer = 80 + this.random.nextInt(80);
		this.setPersistenceRequired();
	}

	 
	@Override
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entities/hedgehog"));
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(1, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(2, new EntityAIHedgehogFindNestsGoal(this, 1.0D));
			this.goalSelector.addGoal(3, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}
		this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, 0.2F));
		this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(8, new TemptGoal(this, 1.2D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(9, new PanicGoal(this, 1.5D));
		this.goalSelector.addGoal(12, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(13, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F));
		this.goalSelector.addGoal(14, new RandomLookAroundGoal(this));
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(15, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(ExtraConfig.settings.hedgehogBed.get()),
					AnimaniaHelper.getBlock(ExtraConfig.settings.hedgehogBed2.get())));
		}
		if (AnimaniaConfig.gameRules.animalsCanAttackOthers.get())
		{
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Silverfish.class, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityFrogs.class, false));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityToad.class, false));
		}
		this.targetSelector.addGoal(13, new HurtByTargetGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return TamableAnimal.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 8.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.ATTACK_DAMAGE, 1.0D)
				.add(Attributes.STEP_HEIGHT, 1.1D);
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		this.level().broadcastEntityEvent(this, (byte) 18);
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (!this.isTame() && this.isFood(stack) && !this.level().isClientSide)
		{
			if (!player.getAbilities().instabuild)
				stack.shrink(1);

			if (this.random.nextInt(3) == 0)
				this.tame(player);
			else
				this.level().broadcastEntityEvent(this, (byte) 6);

			return InteractionResult.SUCCESS;
		}

		if (this.isTame() && this.isOwnedBy(player) && stack.isEmpty() && player.isShiftKeyDown())
		{
			this.setOrderedToSit(!this.isOrderedToSit());
			return InteractionResult.SUCCESS;
		}

		if (GenericBehavior.interactCommon(this, player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return super.mobInteract(player, hand);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn)
	{
		boolean flag = entityIn.hurt(this.level().damageSources().mobAttack(this), 2.0F);

		 

		if (entityIn instanceof EntityAmphibian)
			this.setFed(true);

		if (entityIn instanceof Player)
			((LivingEntity) entityIn).knockback(1.0, this.getX() - entityIn.getX(), this.getZ() - entityIn.getZ());

		return flag;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(FED, true);
		builder.define(WATERED, true);
		builder.define(AGE, 0);
		builder.define(SLEEPING, false);
		builder.define(INTERACTED, false);
		builder.define(HANDFED, false);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		GenericBehavior.writeCommonNBT(tag, this);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		GenericBehavior.readCommonNBT(tag, this);
	}

	@Override
	public EntityDataAccessor<Integer> getAgeParam()
	{
		return AGE;
	}

	@Override
	public void aiStep()
	{
		super.aiStep();
		GenericBehavior.livingUpdateCommon(this);

		if (this.hasCustomName() && !this.level().isClientSide)
		{
			String name = this.getName().getString();
			if ("Sonic".equals(name))
				this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 4, false, false));
			else if ("Sanic".equals(name))
			{
				this.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2, 3, false, false));
				this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 6, false, false));
			}
		}
	}

	@Override
	public EntityDataAccessor<Boolean> getFedParam()
	{
		return FED;
	}

	@Override
	public EntityDataAccessor<Boolean> getWateredParam()
	{
		return WATERED;
	}

	@Override
	public EntityDataAccessor<Boolean> getSleepingParam()
	{
		return SLEEPING;
	}

	@Override
	public EntityDataAccessor<Boolean> getHandFedParam()
	{
		return HANDFED;
	}

	@Override
	public EntityDataAccessor<Boolean> getInteractedParam()
	{
		return INTERACTED;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return com.animania.common.entity.generic.GenericBehavior.getAmbientSound(this,
				com.animania.addons.farm.FarmSounds.HEDGEHOG_LIVING_1.get(), com.animania.addons.farm.FarmSounds.HEDGEHOG_LIVING_2.get(),
				com.animania.addons.farm.FarmSounds.HEDGEHOG_LIVING_3.get(), com.animania.addons.farm.FarmSounds.HEDGEHOG_LIVING_4.get(),
				com.animania.addons.farm.FarmSounds.HEDGEHOG_LIVING_5.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return com.animania.common.entity.generic.GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.HEDGEHOG_HURT_1.get(), com.animania.addons.farm.FarmSounds.HEDGEHOG_HURT_2.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return com.animania.common.entity.generic.GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.HEDGEHOG_HURT_1.get(), com.animania.addons.farm.FarmSounds.HEDGEHOG_HURT_2.get());
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state)
	{
		this.playSound(SoundEvents.WOLF_STEP, 0.02F, 1.5F);
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return !stack.isEmpty() && AnimaniaHelper.containsItemStack(this.getFoodItems(), stack);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer)
	{
		return false;
	}

	@Override
	@Nullable
	public AgeableMob getBreedOffspring(net.minecraft.server.level.ServerLevel level, AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public Item getSpawnEgg()
	{
		SpawnEggItem egg = SpawnEggItem.byId(this.getType());
		return egg != null ? egg : Items.AIR;
	}

	@Override
	public ItemStack getPickResult()
	{
		return new ItemStack(this.getSpawnEgg());
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 0;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 0;
	}

	@Override
	public EntityGender getEntityGender()
	{
		return EntityGender.NONE;
	}

	@Override
	public Set<ItemStack> getFoodItems()
	{
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(ExtraConfig.settings.hedgehogFood.get()));
	}

	@Override
	public void setCustomSleepingPos(BlockPos pos)
	{
	}

	@Override
	public BlockPos getCustomSleepingPos()
	{
		return null;
	}

	@Override
	public Float getSleepTimer()
	{
		return -100f;
	}

	@Override
	public void setSleepTimer(Float timer)
	{
	}

	@Override
	public EntityDataAccessor<Float> getSleepTimerParam()
	{
		return null;
	}

	@Override
	public int getBlinkTimer()
	{
		return this.blinkTimer;
	}

	@Override
	public void setBlinkTimer(int i)
	{
		this.blinkTimer = i;
	}

	@Override
	public int getEatTimer()
	{
		return 0;
	}

	@Override
	public void setEatTimer(int i)
	{
	}

	@Override
	public int getFedTimer()
	{
		return this.fedTimer;
	}

	@Override
	public void setFedTimer(int i)
	{
		this.fedTimer = i;
	}

	@Override
	public int getWaterTimer()
	{
		return this.wateredTimer;
	}

	@Override
	public void setWaterTimer(int i)
	{
		this.wateredTimer = i;
	}

	@Override
	public int getDamageTimer()
	{
		return this.damageTimer;
	}

	@Override
	public void setDamageTimer(int i)
	{
		this.damageTimer = i;
	}

	@Override
	public int getHappyTimer()
	{
		return this.happyTimer;
	}

	@Override
	public void setHappyTimer(int i)
	{
		this.happyTimer = i;
	}

	@Override
	public AnimaniaType getAnimalType()
	{
		return this.type;
	}
}
