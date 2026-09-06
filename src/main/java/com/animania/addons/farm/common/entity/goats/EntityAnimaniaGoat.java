package com.animania.addons.farm.common.entity.goats;

import java.util.Set;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;
import com.animania.api.interfaces.IAnimaniaAnimalBase;
import com.animania.api.interfaces.IConvertable;
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
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;

 






public abstract class EntityAnimaniaGoat extends Sheep implements IAnimaniaAnimalBase, IConvertable
{
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SHEARED = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> SHEARED_TIMER = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SPOOKED = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Float> SPOOKED_TIMER = SynchedEntityData.defineId(EntityAnimaniaGoat.class, EntityDataSerializers.FLOAT);

	protected int happyTimer;
	public int blinkTimer;
	public int eatTimer;
	protected int fedTimer;
	protected int wateredTimer;
	protected int damageTimer;
	public GoatType goatType = GoatType.ALPINE;
	public GenericAIEatGrassGoal<EntityAnimaniaGoat> entityAIEatGrass;
	protected boolean mateable = false;
	protected boolean headbutting = false;
	public EntityGender gender = EntityGender.NONE;
	protected ResourceLocation resourceLocation;
	protected ResourceLocation resourceLocationSheared;
	protected ResourceLocation resourceLocationBlink;
	public int lidCol;

	public EntityAnimaniaGoat(EntityType<? extends EntityAnimaniaGoat> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() + this.random.nextInt(100);
		this.happyTimer = 60;
		this.blinkTimer = 100 + this.random.nextInt(100);
		this.setPersistenceRequired();
	}

	public static AttributeSupplier.Builder createAnimaniaGoatAttributes()
	{
		return Sheep.createAttributes();
	}

	@Override
	protected void registerGoals()
	{
		this.entityAIEatGrass = new GenericAIEatGrassGoal<>(this, 1.0D);

		this.goalSelector.addGoal(0, new PanicGoal(this, 1.4D));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(2, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(3, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new TemptGoal(this, 1.25D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack)
				|| stack.is(net.minecraft.tags.ItemTags.SMALL_FLOWERS), false));
		this.goalSelector.addGoal(8, this.entityAIEatGrass);
		this.goalSelector.addGoal(9, new net.minecraft.world.entity.ai.goal.AvoidEntityGoal<>(this, Wolf.class, 20.0F, 2.2D, 2.2D,
				entity -> !(entity instanceof net.minecraft.world.entity.TamableAnimal tamable && tamable.isTame())));
		this.goalSelector.addGoal(10, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F));
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(10, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(FarmConfig.settings.goatBed.get()),
					AnimaniaHelper.getBlock(FarmConfig.settings.goatBed2.get())));
		}

		this.goalSelector.addGoal(11, new com.animania.common.entity.generic.ai.GenericAIFindSaltLickGoal<>(this, 1.0D));
		this.goalSelector.addGoal(12, new com.animania.common.entity.generic.ai.GenericAIGetDogHerdedGoal<>(this,
				com.animania.addons.catsdogs.common.entity.canids.DogType.GERMAN_SHEPHERD));

		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
	}

	 





	@Override
	protected void customServerAiStep()
	{
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(FED, true);
		builder.define(HANDFED, false);
		builder.define(WATERED, true);
		builder.define(SHEARED, false);
		builder.define(SHEARED_TIMER, AnimaniaConfig.careAndFeeding.woolRegrowthTimer.get() + this.random.nextInt(500));
		builder.define(SPOOKED, false);
		builder.define(SPOOKED_TIMER, 0.0F);
		builder.define(AGE, 0);
		builder.define(SLEEPING, false);
		builder.define(INTERACTED, false);
	}

	@Override
	public void aiStep()
	{
		if (this.entityAIEatGrass != null)
			this.eatTimer = this.entityAIEatGrass.getEatingGrassTimer();

		if (this.getSpooked())
		{
			this.setJumping(this.getSpookedTimer() == 1.0F);

			this.getNavigation().stop();
			this.setNoAi(true);
			this.setSpookedTimer(this.getSpookedTimer() - 0.01F);

			if (this.getSpookedTimer() <= 0.20F && this.getSpookedTimer() > 0.1F)
				this.setJumping(true);
			else if (this.getSpookedTimer() <= 0.0F)
			{
				this.setSpooked(false);
				this.setSpookedTimer(0.0F);
				this.setNoAi(false);
				this.setJumping(false);
			}
		}

		GenericBehavior.livingUpdateCommon(this);

		 
		if (this.getSleeping())
		{
			if (this.sleepTimer > -0.55F)
				this.sleepTimer -= 0.01F;
		}
		else
		{
			this.sleepTimer = 0F;
		}

		if (this.getSheared())
		{
			int shearedTimer = this.getWoolRegrowthTimer() - 1;
			this.setWoolRegrowthTimer(shearedTimer);
			if (shearedTimer < 0)
				this.setSheared(false);
		}

		super.aiStep();
	}

	public void setSpooked(boolean spooked)
	{
		this.entityData.set(SPOOKED, spooked);
	}

	public boolean getSpooked()
	{
		return this.getBoolFromDataManager(SPOOKED);
	}

	public Float getSpookedTimer()
	{
		return this.getFloatFromDataManager(SPOOKED_TIMER);
	}

	public void setSpookedTimer(Float timer)
	{
		this.entityData.set(SPOOKED_TIMER, timer);
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		if (!this.getSleeping())
			this.level().broadcastEntityEvent(this, (byte) 18);
	}

	 


	protected boolean isShearable()
	{
		return false;
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (stack.getItem() instanceof ShearsItem && !this.getSheared() && !this.isBaby() && this.isShearable())
		{
			if (!this.level().isClientSide)
			{
				this.setSheared(true);
				int count = 1 + this.random.nextInt(2);
				for (int i = 0; i < count; i++)
					this.spawnAtLocation(new ItemStack(Items.WHITE_WOOL));
				this.playSound(SoundEvents.SHEEP_SHEAR, 1.0F, 1.0F);
			}
			player.swing(hand);
			if (this.getSleeping())
				this.setSleeping(false);
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}
		else if (stack.getItem() instanceof DyeItem || stack.getItem() instanceof ShearsItem)
		{
			 
			return InteractionResult.CONSUME;
		}

		if (GenericBehavior.interactCommon(this, player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return super.mobInteract(player, hand);
	}

	@Override
	public boolean readyForShearing()
	{
		return this.isShearable() && !this.getSheared() && !this.isBaby();
	}

	@Override
	public ResourceKey<LootTable> getDefaultLootTable()
	{
		if (this instanceof EntityKidBase)
			return net.minecraft.world.level.storage.loot.BuiltInLootTables.EMPTY;
		return ResourceKey.create(Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath(Animania.MODID,
						this.goatType.isPrime() ? "entities/goat_prime" : "entities/goat_regular"));
	}

	public boolean getSheared()
	{
		return this.getBoolFromDataManager(SHEARED);
	}

	public void setSheared(boolean sheared)
	{
		if (sheared)
		{
			this.entityData.set(SHEARED, true);
			this.setWoolRegrowthTimer(AnimaniaConfig.careAndFeeding.woolRegrowthTimer.get() + this.random.nextInt(500));
		}
		else
		{
			this.entityData.set(SHEARED, false);
		}
	}

	public int getWoolRegrowthTimer()
	{
		return this.getIntFromDataManager(SHEARED_TIMER);
	}

	public void setWoolRegrowthTimer(int time)
	{
		this.entityData.set(SHEARED_TIMER, time);
	}

	public ResourceLocation getResourceLocation()
	{
		return this.getSheared() && this.resourceLocationSheared != null ? this.resourceLocationSheared : this.resourceLocation;
	}

	public ResourceLocation getResourceLocationBlink()
	{
		return this.resourceLocationBlink;
	}

	@Override
	public EntityDataAccessor<Boolean> getSleepingParam()
	{
		return SLEEPING;
	}

	 





	protected float sleepTimer = 0F;

	@Override
	public EntityDataAccessor<Float> getSleepTimerParam()
	{
		return null;
	}

	@Override
	public Float getSleepTimer()
	{
		return this.sleepTimer;
	}

	@Override
	public void setSleepTimer(Float timer)
	{
		this.sleepTimer = timer;
	}

	@Override
	public EntityDataAccessor<Boolean> getFedParam()
	{
		return FED;
	}

	@Override
	public EntityDataAccessor<Boolean> getHandFedParam()
	{
		return HANDFED;
	}

	@Override
	public EntityDataAccessor<Boolean> getWateredParam()
	{
		return WATERED;
	}

	@Override
	public EntityDataAccessor<Boolean> getInteractedParam()
	{
		return INTERACTED;
	}

	@Override
	public EntityDataAccessor<Integer> getAgeParam()
	{
		return AGE;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Sheared", this.getSheared());
		tag.putBoolean("Spooked", this.getSpooked());
		GenericBehavior.writeCommonNBT(tag, this);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setSheared(tag.getBoolean("Sheared"));
		this.setSpooked(tag.getBoolean("Spooked"));
		GenericBehavior.readCommonNBT(tag, this);
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
		return this.gender;
	}

	@Override
	public Set<ItemStack> getFoodItems()
	{
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(FarmConfig.settings.goatFood.get()));
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return this.mateable && !stack.isEmpty() && AnimaniaHelper.containsItemStack(this.getFoodItems(), stack);
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
		return this.goatType;
	}

	@Override
	@Nullable
	public Sheep getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public Entity convertToVanilla()
	{
		net.minecraft.world.entity.animal.goat.Goat entity = EntityType.GOAT.create(this.level());
		if (entity != null)
		{
			entity.setPos(this.getX(), this.getY(), this.getZ());
			if (this.hasCustomName())
				entity.setCustomName(this.getCustomName());
		}
		return entity;
	}
}
