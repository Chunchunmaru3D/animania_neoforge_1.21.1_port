package com.animania.addons.extra.common.entity.rodents.rabbits;

import java.util.Set;

import javax.annotation.Nullable;

import com.animania.addons.extra.config.ExtraConfig;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;
import com.animania.api.interfaces.IAnimaniaAnimalBase;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.entity.generic.ai.GenericAIEatGrassGoal;
import com.animania.common.entity.generic.ai.GenericAIFindFoodGoal;
import com.animania.common.entity.generic.ai.GenericAIFindWaterGoal;
import com.animania.common.entity.generic.ai.GenericAISleepGoal;
import com.animania.common.entity.generic.ai.GenericAIWatchClosestGoal;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;
import com.google.common.collect.Sets;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

 
















public class EntityAnimaniaRabbit extends Rabbit implements IAnimaniaAnimalBase
{
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaRabbit.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaRabbit.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAnimaniaRabbit.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaRabbit.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaRabbit.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaRabbit.class, EntityDataSerializers.BOOLEAN);
	 
	protected static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(EntityAnimaniaRabbit.class, EntityDataSerializers.INT);

	public GenericAIEatGrassGoal<EntityAnimaniaRabbit> entityAIEatGrass;

	private int fedTimer;
	protected int wateredTimer;
	protected int happyTimer;
	public int blinkTimer;
	public int eatTimer;
	protected int damageTimer;
	public RabbitType type = RabbitType.LOP;
	public EntityGender gender = EntityGender.NONE;
	protected ResourceLocation resourceLocation;

	public ResourceLocation getResourceLocation()
	{
		return this.resourceLocation;
	}

	public EntityAnimaniaRabbit(EntityType<? extends EntityAnimaniaRabbit> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() * 2 + this.random.nextInt(200);
		this.happyTimer = 60;
		this.blinkTimer = 80 + this.random.nextInt(80);
		this.setPersistenceRequired();
	}

	@Override
	protected void registerGoals()
	{
		this.entityAIEatGrass = new GenericAIEatGrassGoal<>(this, 1.0D);

		this.goalSelector.addGoal(0, new FloatGoal(this));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(1, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(2, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}
		this.goalSelector.addGoal(3, new PanicGoal(this, 1.5D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, this.entityAIEatGrass);
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(9, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(ExtraConfig.settings.rabbitBed.get()),
					AnimaniaHelper.getBlock(ExtraConfig.settings.rabbitBed2.get())));
		}
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return Rabbit.createAttributes()
				.add(Attributes.MAX_HEALTH, 9.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.3D);
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		this.level().broadcastEntityEvent(this, (byte) 18);
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		if (GenericBehavior.interactCommon(this, player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		return super.mobInteract(player, hand);
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
		builder.define(VARIANT, this.getVariantCount() > 0 ? this.random.nextInt(this.getVariantCount()) : 0);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putInt("ColorNumber", this.getColorNumber());
		GenericBehavior.writeCommonNBT(tag, this);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		if (tag.contains("ColorNumber"))
			this.setColorNumber(tag.getInt("ColorNumber"));
		GenericBehavior.readCommonNBT(tag, this);
	}

	 
	public int getVariantCount() { return 0; }

	 
	public int getColorNumber() { return this.entityData.get(VARIANT); }

	public void setColorNumber(int color)
	{
		this.entityData.set(VARIANT, this.getVariantCount() > 0 ? Math.floorMod(color, this.getVariantCount()) : 0);
	}

	 
	public int getEyeColorForVariant(int variant) { return 0xFFFFFF; }

	@Override
	public EntityDataAccessor<Integer> getAgeParam()
	{
		return AGE;
	}

	@Override
	public void aiStep()
	{
		if (this.entityAIEatGrass != null)
			this.eatTimer = this.entityAIEatGrass.getEatingGrassTimer();

		GenericBehavior.livingUpdateCommon(this);
		super.aiStep();
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
				com.animania.addons.farm.FarmSounds.RABBIT_LIVING_1.get(), com.animania.addons.farm.FarmSounds.RABBIT_LIVING_2.get(),
				com.animania.addons.farm.FarmSounds.RABBIT_LIVING_3.get(), com.animania.addons.farm.FarmSounds.RABBIT_LIVING_4.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return com.animania.common.entity.generic.GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.RABBIT_HURT_1.get(), com.animania.addons.farm.FarmSounds.RABBIT_HURT_2.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return com.animania.common.entity.generic.GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.RABBIT_HURT_1.get(), com.animania.addons.farm.FarmSounds.RABBIT_HURT_2.get());
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state)
	{
		this.playSound(net.minecraft.sounds.SoundEvents.RABBIT_JUMP, 0.15F, 1.0F);
	}

	protected boolean mateable = false;

	@Override
	public boolean isFood(ItemStack stack)
	{
		return this.mateable && !stack.isEmpty() && AnimaniaHelper.containsItemStack(this.getFoodItems(), stack);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer)
	{
		return false;
	}

	@Override
	@Nullable
	public Rabbit getBreedOffspring(net.minecraft.server.level.ServerLevel level, AgeableMob otherParent)
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
	protected net.minecraft.resources.ResourceKey<net.minecraft.world.level.storage.loot.LootTable> getDefaultLootTable()
	{
		if (this instanceof EntityRabbitKitBase)
			return net.minecraft.world.level.storage.loot.BuiltInLootTables.EMPTY;

		return net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath("animania", "entities/rabbit_" + (this.type.isPrime() ? "prime" : "regular")));
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
		return this.gender;
	}

	@Override
	public Set<ItemStack> getFoodItems()
	{
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(ExtraConfig.settings.rabbitFood.get()));
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
		return this.eatTimer;
	}

	@Override
	public void setEatTimer(int i)
	{
		this.eatTimer = i;
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
