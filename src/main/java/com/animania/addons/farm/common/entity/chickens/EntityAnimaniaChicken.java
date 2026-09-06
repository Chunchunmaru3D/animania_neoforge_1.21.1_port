package com.animania.addons.farm.common.entity.chickens;

import java.util.Set;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmSounds;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;
import com.animania.api.interfaces.IAnimaniaAnimalBase;
import com.animania.api.interfaces.IConvertable;
import com.animania.common.entity.generic.GenericBehavior;
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
import com.animania.Animania;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

 

















public class EntityAnimaniaChicken extends Chicken implements IAnimaniaAnimalBase, IConvertable
{
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaChicken.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaChicken.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAnimaniaChicken.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaChicken.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaChicken.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaChicken.class, EntityDataSerializers.BOOLEAN);

	protected ResourceLocation resourceLocation;
	protected ResourceLocation resourceLocationBlink;
	private int fedTimer;
	protected int wateredTimer;
	protected int happyTimer;
	public int blinkTimer;
	private int featherTimer;
	protected int damageTimer;
	public ChickenType type = ChickenType.LEGHORN;
	public EntityGender gender = EntityGender.NONE;
	public int lidCol;

	public EntityAnimaniaChicken(EntityType<? extends EntityAnimaniaChicken> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() + this.random.nextInt(100);
		this.happyTimer = 60;
		this.blinkTimer = 80 + this.random.nextInt(80);
		this.featherTimer = AnimaniaConfig.careAndFeeding.featherTimer.get() + this.random.nextInt(1000);
		this.setPersistenceRequired();
	}

	 


	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new FloatGoal(this));  
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));  
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(2, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(3, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}

		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));  
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));  
		this.goalSelector.addGoal(7, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F)  
		{
			@Override
			protected boolean isWatchSuppressed()
			{
				 
				return !EntityAnimaniaChicken.this.level().isDay() && EntityAnimaniaChicken.this.getSleeping();
			}
		});
		this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));  
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(8, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(FarmConfig.settings.chickenBed.get()),
					AnimaniaHelper.getBlock(FarmConfig.settings.chickenBed2.get())));
		}
		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));  
	}

	 



	public static AttributeSupplier.Builder createAnimaniaChickenAttributes()
	{
		return Chicken.createAttributes()
				.add(Attributes.MAX_HEALTH, 6.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.29D)
				.add(Attributes.ATTACK_DAMAGE, 1.0D);
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

	public ResourceLocation getResourceLocation()
	{
		return this.resourceLocation;
	}

	public ResourceLocation getResourceLocationBlink()
	{
		return this.resourceLocationBlink;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(FED, true);
		builder.define(WATERED, true);
		builder.define(AGE, 0);
		builder.define(SLEEPING, false);
		builder.define(HANDFED, false);
		builder.define(INTERACTED, false);
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

		this.fallDistance = 0;

		if (!this.level().isClientSide && !this.isBaby() && AnimaniaConfig.gameRules.birdsDropFeathers.get() && !this.isChickenJockey() && --this.featherTimer <= 0)
		{
			this.playSound(FarmSounds.CHICKEN_CLUCK_2.get(), 0.5F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.spawnAtLocation(net.minecraft.world.item.Items.FEATHER, 1);
			this.featherTimer = AnimaniaConfig.careAndFeeding.featherTimer.get() + this.random.nextInt(1000);
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
		return GenericBehavior.getAmbientSound(this,
				FarmSounds.CHICKEN_CLUCK_1.get(), FarmSounds.CHICKEN_CLUCK_2.get(), FarmSounds.CHICKEN_CLUCK_3.get(),
				FarmSounds.CHICKEN_CLUCK_4.get(), FarmSounds.CHICKEN_CLUCK_5.get(), FarmSounds.CHICKEN_CLUCK_6.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return null;
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return null;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state)
	{
		this.playSound(SoundEvents.CHICKEN_STEP, 0.10F, 1.4F);
	}

	@Override
	public void playSound(SoundEvent sound, float volume, float pitch)
	{
		if (!this.isSilent() && !this.getSleeping())
			this.level().playSound(null, this.getX(), this.getY(), this.getZ(), sound, this.getSoundSource(), volume, pitch);
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
	public Chicken getBreedOffspring(ServerLevel level, AgeableMob otherParent)
	{
		return null;  
	}

	@Override
	public Item getSpawnEgg()
	{
		SpawnEggItem egg = SpawnEggItem.byId(this.getType());
		return egg != null ? egg : net.minecraft.world.item.Items.AIR;
	}

	@Override
	public ItemStack getPickResult()
	{
		return new ItemStack(this.getSpawnEgg());
	}

	@Override
	protected net.minecraft.resources.ResourceKey<net.minecraft.world.level.storage.loot.LootTable> getDefaultLootTable()
	{
		 
		return net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath(Animania.MODID,
						this.type.isPrime() ? "entities/chicken_prime" : "entities/chicken_regular"));
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
	public Set<ItemStack> getFoodItems()
	{
		 
		 
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(FarmConfig.settings.chickenFood.get()));
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

	@Override
	public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source)
	{
		return false;  
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData)
	{
		return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
	}

	@Override
	public Entity convertToVanilla()
	{
		Chicken entity = EntityType.CHICKEN.create(this.level());
		if (entity != null)
		{
			entity.setPos(this.getX(), this.getY(), this.getZ());
			if (this.hasCustomName())
				entity.setCustomName(this.getCustomName());
		}
		return entity;
	}
}
