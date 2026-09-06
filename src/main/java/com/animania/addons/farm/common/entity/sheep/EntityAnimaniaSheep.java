package com.animania.addons.farm.common.entity.sheep;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.addons.farm.FarmSounds;
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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.FloatGoal;
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

 










public abstract class EntityAnimaniaSheep extends Sheep implements IAnimaniaAnimalBase, IConvertable
{
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SHEARED = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> SHEARED_TIMER = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Integer> COLOR_NUM = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Integer> DYE_COLOR = SynchedEntityData.defineId(EntityAnimaniaSheep.class, EntityDataSerializers.INT);

	protected int happyTimer;
	public int blinkTimer;
	public int eatTimer;
	protected int fedTimer;
	protected int wateredTimer;
	protected int damageTimer;
	public SheepType sheepType = SheepType.FRIESIAN;
	public GenericAIEatGrassGoal<EntityAnimaniaSheep> entityAIEatGrass;
	protected boolean mateable = false;
	protected boolean headbutting = false;
	public EntityGender gender = EntityGender.NONE;
	protected DyeColor color;
	protected ResourceLocation resourceLocation;
	protected ResourceLocation resourceLocationSheared;
	protected ResourceLocation resourceLocationBlink;
	public int lidCol;

	 







	protected int getColorVariantCount()
	{
		return 1;
	}

	public EntityAnimaniaSheep(EntityType<? extends EntityAnimaniaSheep> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() + this.random.nextInt(100);
		this.happyTimer = 60;
		this.blinkTimer = 100 + this.random.nextInt(100);
		this.setPersistenceRequired();
	}

	public static AttributeSupplier.Builder createAnimaniaSheepAttributes()
	{
		return Sheep.createAttributes();
	}

	@Override
	protected void registerGoals()
	{
		this.entityAIEatGrass = new GenericAIEatGrassGoal<>(this, 1.0D);

		this.goalSelector.addGoal(5, new FloatGoal(this));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(2, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(3, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new PanicGoal(this, 2.2D));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.25D, stack -> stack.is(net.minecraft.tags.ItemTags.SMALL_FLOWERS), false));
		this.goalSelector.addGoal(7, new TemptGoal(this, 1.25D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(8, this.entityAIEatGrass);
		this.goalSelector.addGoal(9, new net.minecraft.world.entity.ai.goal.AvoidEntityGoal<>(this, Wolf.class, 24.0F, 2.0D, 2.2D,
				entity -> !(entity instanceof net.minecraft.world.entity.TamableAnimal tamable && tamable.isTame())));
		this.goalSelector.addGoal(10, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F));
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(11, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(FarmConfig.settings.sheepBed.get()),
					AnimaniaHelper.getBlock(FarmConfig.settings.sheepBed2.get())));
		}

		this.goalSelector.addGoal(12, new com.animania.common.entity.generic.ai.GenericAIFindSaltLickGoal<>(this, 1.0D));
		this.goalSelector.addGoal(13, new com.animania.common.entity.generic.ai.GenericAIGetDogHerdedGoal<>(this,
				com.animania.addons.catsdogs.common.entity.canids.DogType.GERMAN_SHEPHERD));

		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
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
		builder.define(SLEEPING, false);
		builder.define(DYE_COLOR, DyeColor.WHITE.getId());
		builder.define(INTERACTED, false);
		builder.define(COLOR_NUM, this.getColorVariantCount() > 1 ? this.random.nextInt(this.getColorVariantCount()) : 0);
		builder.define(AGE, 0);
	}

	@Override
	public void aiStep()
	{
		if (this.entityAIEatGrass != null)
			this.eatTimer = this.entityAIEatGrass.getEatingGrassTimer();

		GenericBehavior.livingUpdateCommon(this);

		if (this.getSheared())
		{
			int shearedTimer = this.getWoolRegrowthTimer() - 1;
			this.setWoolRegrowthTimer(shearedTimer);
			if (shearedTimer < 0)
				this.setSheared(false);
		}

		super.aiStep();
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		if (!this.getSleeping())
			this.level().broadcastEntityEvent(this, (byte) 18);
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (stack.getItem() instanceof ShearsItem && !this.getSheared() && !this.isBaby())
		{
			if (!this.level().isClientSide)
				this.playSound(SoundEvents.SHEEP_SHEAR, 1.0F, 1.0F);
			player.swing(hand);
			if (this.getSleeping())
				this.setSleeping(false);
			if (!this.level().isClientSide)
				this.shearSheep();
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		if (stack.getItem() instanceof DyeItem dyeItem && !this.isBaby() && !this.getSheared())
		{
			if (this.isDyeable())
			{
				DyeColor col = dyeItem.getDyeColor();
				if (this.getDyeColor() != col)
				{
					if (!player.getAbilities().instabuild)
						stack.shrink(1);
					this.color = col;
					this.setDyeColorNum(col.getId());
				}
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			}
			return InteractionResult.PASS;
		}

		if (GenericBehavior.interactCommon(this, player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return super.mobInteract(player, hand);
	}

	 



	protected void shearSheep()
	{
		for (ItemStack drop : this.getWoolDrops())
			this.spawnAtLocation(drop);
		this.setSheared(true);
	}

	 




	protected java.util.List<ItemStack> getWoolDrops()
	{
		int count = 1 + this.random.nextInt(2);
		return java.util.List.of(new ItemStack(woolItemFor(this.getDyeColor()), count));
	}

	 



	public ItemStack getDeathWoolDrop()
	{
		if (this.getSheared())
			return ItemStack.EMPTY;
		java.util.List<ItemStack> drops = this.getWoolDrops();
		if (drops.isEmpty())
			return ItemStack.EMPTY;
		ItemStack result = drops.getFirst().copy();
		result.setCount(1);
		return result;
	}

	protected static Item woolItemFor(DyeColor color)
	{
		return switch (color)
		{
			case WHITE -> Items.WHITE_WOOL;
			case ORANGE -> Items.ORANGE_WOOL;
			case MAGENTA -> Items.MAGENTA_WOOL;
			case LIGHT_BLUE -> Items.LIGHT_BLUE_WOOL;
			case YELLOW -> Items.YELLOW_WOOL;
			case LIME -> Items.LIME_WOOL;
			case PINK -> Items.PINK_WOOL;
			case GRAY -> Items.GRAY_WOOL;
			case LIGHT_GRAY -> Items.LIGHT_GRAY_WOOL;
			case CYAN -> Items.CYAN_WOOL;
			case PURPLE -> Items.PURPLE_WOOL;
			case BLUE -> Items.BLUE_WOOL;
			case BROWN -> Items.BROWN_WOOL;
			case GREEN -> Items.GREEN_WOOL;
			case RED -> Items.RED_WOOL;
			case BLACK -> Items.BLACK_WOOL;
		};
	}

	public boolean isDyeable()
	{
		return false;
	}

	@Override
	public boolean readyForShearing()
	{
		return !this.getSheared() && !this.isBaby();
	}

	@Override
	public ResourceKey<LootTable> getDefaultLootTable()
	{
		if (this instanceof EntityLambBase)
			return net.minecraft.world.level.storage.loot.BuiltInLootTables.EMPTY;
		return ResourceKey.create(Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath(Animania.MODID,
						this.sheepType.isPrime() ? "entities/sheep_prime" : "entities/sheep_regular"));
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

	public int getColorNumber()
	{
		return this.getIntFromDataManager(COLOR_NUM);
	}

	public void setColorNumber(int color)
	{
		this.entityData.set(COLOR_NUM, color);
	}

	public int getDyeColorNum()
	{
		return this.getIntFromDataManager(DYE_COLOR);
	}

	public void setDyeColorNum(int col)
	{
		this.entityData.set(DYE_COLOR, col);
	}

	public DyeColor getDyeColor()
	{
		if (this.color == null)
			this.color = DyeColor.byId(this.getDyeColorNum());
		return this.color;
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

	@Override
	public EntityDataAccessor<Float> getSleepTimerParam()
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
		tag.putInt("ColorNumber", this.getColorNumber());
		tag.putInt("DyeColor", this.getDyeColorNum());
		GenericBehavior.writeCommonNBT(tag, this);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setColorNumber(tag.getInt("ColorNumber"));
		this.setSheared(tag.getBoolean("Sheared"));
		this.setDyeColorNum(tag.getInt("DyeColor"));
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
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(FarmConfig.settings.sheepFood.get()));
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
		return this.sheepType;
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
		Sheep entity = EntityType.SHEEP.create(this.level());
		if (entity != null)
		{
			entity.setPos(this.getX(), this.getY(), this.getZ());
			if (this.hasCustomName())
				entity.setCustomName(this.getCustomName());
		}
		return entity;
	}
}
