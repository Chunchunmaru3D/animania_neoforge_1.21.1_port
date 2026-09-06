package com.animania.addons.farm.common.entity.horses;

import java.util.Set;

import javax.annotation.Nullable;

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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

 























public class EntityAnimaniaHorse extends Horse implements IAnimaniaAnimalBase, IConvertable
{
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaHorse.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaHorse.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaHorse.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaHorse.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaHorse.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> COLOR_NUM = SynchedEntityData.defineId(EntityAnimaniaHorse.class, EntityDataSerializers.INT);

	protected int happyTimer;
	public int blinkTimer;
	public int eatTimer;
	protected int fedTimer;
	protected int wateredTimer;
	protected int damageTimer;
	private boolean boosting;
	private int boostTime;
	private int totalBoostTime;
	public HorseType horseType = HorseType.DRAFT;
	protected boolean mateable = false;
	public EntityGender gender = EntityGender.NONE;
	protected ResourceLocation resourceLocation;
	protected ResourceLocation resourceLocationBlink;
	public int lidCol;
	public GenericAIEatGrassGoal<EntityAnimaniaHorse> entityAIEatGrass;

	private static final String[] HORSE_TEXTURE_NAMES = { "black", "bw1", "bw2", "grey", "red", "white" };
	private static final int[] HORSE_LID_COLORS = { 0x1B1B1B, 0x181818, 0x171717, 0x797979, 0x8F3514, 0xC1C1C1 };

	public EntityAnimaniaHorse(EntityType<? extends EntityAnimaniaHorse> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() + this.random.nextInt(100);
		this.happyTimer = 60;
		this.blinkTimer = 100 + this.random.nextInt(100);
		this.setPersistenceRequired();
		 
		 
		 
		 
		 
		this.applyHorseTexture();
	}

	 





	protected void applyHorseTexture()
	{
		String color = HORSE_TEXTURE_NAMES[this.getColorNumber()];
		this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/horses/draft_horse_" + color + ".png");
		this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/horses/horse_blink_left.png");
		 
		 
		this.lidCol = HORSE_LID_COLORS[this.getColorNumber()];
	}

	 




	@Override
	protected void registerGoals()
	{
		this.entityAIEatGrass = new GenericAIEatGrassGoal<>(this, 1.0D);

		this.goalSelector.addGoal(0, new PanicGoal(this, 2.0D));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(1, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(1, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.goalSelector.addGoal(5, new TemptGoal(this, 1.25D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(6, this.entityAIEatGrass);
		this.goalSelector.addGoal(7, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(10, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(FarmConfig.settings.horseBed.get()),
					AnimaniaHelper.getBlock(FarmConfig.settings.horseBed2.get())));
		}

		this.goalSelector.addGoal(11, new com.animania.common.entity.generic.ai.GenericAIFindSaltLickGoal<>(this, 1.0D));

		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
	}

	public static AttributeSupplier.Builder createAnimaniaHorseAttributes()
	{
		 
		 
		return net.minecraft.world.entity.animal.horse.AbstractHorse.createBaseHorseAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.2849999940395355D);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer)
	{
		return false;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(COLOR_NUM, this.random.nextInt(6));
		builder.define(FED, true);
		builder.define(HANDFED, false);
		builder.define(WATERED, true);
		builder.define(SLEEPING, false);
		builder.define(INTERACTED, false);
	}

	 




	@Override
	public boolean isTamed()
	{
		return true;
	}

	@Override
	public void aiStep()
	{
		if (this.boosting)
		{
			if (!this.level().isClientSide)
				this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 3, false, false));
			if (++this.boostTime >= this.totalBoostTime)
			{
				this.boosting = false;
				this.boostTime = 0;
			}
		}

		if (this.entityAIEatGrass != null)
			this.eatTimer = this.entityAIEatGrass.getEatingGrassTimer();

		if (this.getSleeping())
		{
			if (this.sleepTimer > -0.55F)
				this.sleepTimer -= 0.01F;
		}
		else
		{
			this.sleepTimer = 0F;
		}

		GenericBehavior.livingUpdateCommon(this);
		super.aiStep();
	}

	 
	public boolean boost()
	{
		if (this.boosting)
			return false;

		this.boosting = true;
		this.boostTime = 0;
		this.totalBoostTime = this.random.nextInt(100) + 20;
		return true;
	}

	@Override
	public void playSound(SoundEvent sound, float volume, float pitch)
	{
		if (!this.isSilent() && !this.getSleeping())
			this.level().playSound(null, this.getX(), this.getY(), this.getZ(), sound, this.getSoundSource(), volume, pitch - 0.2F);
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.HORSE_LIVING_1.get(), FarmSounds.HORSE_LIVING_2.get(), FarmSounds.HORSE_LIVING_3.get(),
				FarmSounds.HORSE_LIVING_4.get(), FarmSounds.HORSE_LIVING_5.get(), FarmSounds.HORSE_LIVING_6.get());
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return GenericBehavior.getRandomSound(FarmSounds.HORSE_HURT_1.get(), FarmSounds.HORSE_HURT_2.get(), FarmSounds.HORSE_HURT_3.get());
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return GenericBehavior.getRandomSound(FarmSounds.HORSE_HURT_1.get(), FarmSounds.HORSE_HURT_2.get(), FarmSounds.HORSE_HURT_3.get());
	}

	@Override
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		if (this instanceof EntityFoalBase)
			return BuiltInLootTables.EMPTY;
		return ResourceKey.create(Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath(com.animania.Animania.MODID, "entities/horse"));
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		 
		 
		 
		 
		if (stack.isEmpty() && this.isSaddled() && !this.isVehicle() && !this.isBaby()
				&& (this.getSleeping() || !this.getWatered() || !this.getFed()))
			return InteractionResult.CONSUME;

		if (GenericBehavior.interactCommon(this, player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return super.mobInteract(player, hand);
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
		this.applyHorseTexture();
		GenericBehavior.readCommonNBT(tag, this);
	}

	public int getColorNumber()
	{
		return this.entityData.get(COLOR_NUM);
	}

	public void setColorNumber(int color)
	{
		this.entityData.set(COLOR_NUM, color);
	}

	@Override
	public Item getSpawnEgg()
	{
		SpawnEggItem egg = SpawnEggItem.byId(this.getType());
		return egg != null ? egg : Items.AIR;
	}

	public ResourceLocation getResourceLocation()
	{
		return this.resourceLocation;
	}

	public ResourceLocation getResourceLocationBlink()
	{
		return this.resourceLocationBlink;
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
	public void setCustomSleepingPos(BlockPos pos)
	{
	}

	@Override
	public BlockPos getCustomSleepingPos()
	{
		return null;
	}

	 



	protected float sleepTimer = 0F;

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
	public EntityDataAccessor<Float> getSleepTimerParam()
	{
		return null;
	}

	@Override
	public Set<ItemStack> getFoodItems()
	{
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(FarmConfig.settings.horseFood.get()));
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return this.mateable && !stack.isEmpty() && AnimaniaHelper.containsItemStack(this.getFoodItems(), stack);
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
		return this.horseType;
	}

	@Override
	public EntityDataAccessor<Boolean> getHandFedParam()
	{
		return HANDFED;
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
	public EntityDataAccessor<Boolean> getInteractedParam()
	{
		return INTERACTED;
	}

	@Override
	public EntityDataAccessor<Integer> getAgeParam()
	{
		return null;
	}

	@Override
	public EntityDataAccessor<Boolean> getSleepingParam()
	{
		return SLEEPING;
	}

	@Override
	@Nullable
	public Horse getBreedOffspring(ServerLevel level, AgeableMob otherParent)
	{
		return null;  
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData)
	{
		SpawnGroupData data = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
		this.applyHorseTexture();
		return data;
	}

	@Override
	public Entity convertToVanilla()
	{
		Horse entity = EntityType.HORSE.create(this.level());
		if (entity != null)
		{
			entity.setPos(this.getX(), this.getY(), this.getZ());
			if (this.hasCustomName())
				entity.setCustomName(this.getCustomName());
		}
		return entity;
	}
}
