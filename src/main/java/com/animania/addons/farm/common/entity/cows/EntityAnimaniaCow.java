package com.animania.addons.farm.common.entity.cows;

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
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.LootTable;

 



public class EntityAnimaniaCow extends Cow implements IAnimaniaAnimalBase, IConvertable
{
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAnimaniaCow.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaCow.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaCow.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaCow.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaCow.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaCow.class, EntityDataSerializers.BOOLEAN);

	protected int happyTimer;
	public int blinkTimer;
	public int eatTimer;
	protected int fedTimer;
	protected int wateredTimer;
	protected int damageTimer;
	public CowType cowType = CowType.FRIESIAN;
	protected boolean mateable = false;
	public EntityGender gender = EntityGender.NONE;
	protected ResourceLocation resourceLocation;
	protected ResourceLocation resourceLocationBlink;
	public int lidCol;
	public GenericAIEatGrassGoal<EntityAnimaniaCow> entityAIEatGrass;

	public EntityAnimaniaCow(EntityType<? extends EntityAnimaniaCow> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() + this.random.nextInt(100);
		this.happyTimer = 60;
		this.blinkTimer = 100 + this.random.nextInt(100);
		this.setPersistenceRequired();
	}

	 
	@Override
	public boolean canEatMycelium()
	{
		return this.cowType == CowType.MOOSHROOM;
	}

	 





	@Override
	protected void registerGoals()
	{
		this.entityAIEatGrass = new GenericAIEatGrassGoal<>(this, 1.0D);

		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(2, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(3, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.25D, stack -> stack.is(ItemTags.SMALL_FLOWERS), false));
		this.goalSelector.addGoal(7, new TemptGoal(this, 1.25D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(8, this.entityAIEatGrass);
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(9, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(FarmConfig.settings.cowBed.get()),
					AnimaniaHelper.getBlock(FarmConfig.settings.cowBed2.get())));
		}
		this.goalSelector.addGoal(10, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F));
		this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(12, new com.animania.common.entity.generic.ai.GenericAIFindSaltLickGoal<>(this, 1.0D));

		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
		if (AnimaniaConfig.gameRules.animalsCanAttackOthers.get())
			this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
	}

	 



	public static AttributeSupplier.Builder createAnimaniaCowAttributes()
	{
		return Cow.createAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.2D);
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
		builder.define(FED, true);
		builder.define(INTERACTED, false);
		builder.define(HANDFED, false);
		builder.define(WATERED, true);
		builder.define(SLEEPING, false);
		builder.define(AGE, 0);
	}

	@Override
	public void aiStep()
	{
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
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		if (this instanceof EntityCalfBase)
			return net.minecraft.world.level.storage.loot.BuiltInLootTables.EMPTY;
		if (this.cowType == CowType.MOOSHROOM)
			return ResourceKey.create(Registries.LOOT_TABLE,
					ResourceLocation.fromNamespaceAndPath(com.animania.Animania.MODID, "entities/cow_mooshroom"));
		return ResourceKey.create(Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath(com.animania.Animania.MODID,
						this.cowType.isPrime() ? "entities/cow_prime" : "entities/cow_regular"));
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		if (this instanceof EntityBullBase bull && bull.getFighting())
			return InteractionResult.SUCCESS;

		ItemStack stack = player.getItemInHand(hand);
		if (!stack.isEmpty() && AnimaniaHelper.isWaterContainer(stack))
			return InteractionResult.SUCCESS;

		if (GenericBehavior.interactCommon(this, player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return super.mobInteract(player, hand);
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
	public Item getSpawnEgg()
	{
		SpawnEggItem egg = SpawnEggItem.byId(this.getType());
		return egg != null ? egg : net.minecraft.world.item.Items.AIR;
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
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(FarmConfig.settings.cowFood.get()));
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
		return this.cowType;
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
		return AGE;
	}

	@Override
	public EntityDataAccessor<Boolean> getSleepingParam()
	{
		return SLEEPING;
	}

	@Override
	@Nullable
	public Cow getBreedOffspring(ServerLevel level, AgeableMob otherParent)
	{
		return null;  
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData)
	{
		return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
	}

	@Override
	public Entity convertToVanilla()
	{
		Cow entity = EntityType.COW.create(this.level());
		if (entity != null)
		{
			entity.setPos(this.getX(), this.getY(), this.getZ());
			if (this.hasCustomName())
				entity.setCustomName(this.getCustomName());
		}
		return entity;
	}
}
