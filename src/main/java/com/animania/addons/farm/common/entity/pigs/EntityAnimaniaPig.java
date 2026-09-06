package com.animania.addons.farm.common.entity.pigs;

import java.util.Set;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.addons.farm.FarmItems;
import com.animania.common.fluids.CommonFluids;
import com.animania.addons.farm.FarmSounds;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;
import com.animania.api.interfaces.IAnimaniaAnimalBase;
import com.animania.api.interfaces.IConvertable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.common.entity.generic.ai.GenericAIEatGrassGoal;
import com.animania.common.entity.generic.ai.GenericAIFindFoodGoal;
import com.animania.common.entity.generic.ai.GenericAIFindMudGoal;
import com.animania.common.entity.generic.ai.GenericAIFindWaterGoal;
import com.animania.common.entity.generic.ai.GenericAIPigSnuffleGoal;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;

 






public class EntityAnimaniaPig extends Pig implements IAnimaniaAnimalBase, IConvertable
{
	protected static final EntityDataAccessor<Boolean> MUDDY = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Float> MUDTIMER = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.FLOAT);
	protected static final EntityDataAccessor<Float> SPLASHTIMER = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.FLOAT);
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> PLAYED = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaPig.class, EntityDataSerializers.BOOLEAN);

	public int eatTimer;
	public GenericAIPigSnuffleGoal entityAIEatGrass;
	protected int fedTimer;
	protected int wateredTimer;
	protected int playedTimer;
	protected int happyTimer;
	public int blinkTimer;
	protected int damageTimer;
	public PigType pigType = PigType.YORKSHIRE;
	public EntityGender gender = EntityGender.NONE;
	protected ResourceLocation resourceLocation;
	protected ResourceLocation resourceLocationBlink;
	public int lidCol;

	public EntityAnimaniaPig(EntityType<? extends EntityAnimaniaPig> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() + this.random.nextInt(100);
		this.playedTimer = AnimaniaConfig.careAndFeeding.playTimer.get() + this.random.nextInt(100);
		this.happyTimer = 60;
		this.blinkTimer = 80 + this.random.nextInt(80);
		this.setPersistenceRequired();
	}

	public static AttributeSupplier.Builder createAnimaniaPigAttributes()
	{
		return Pig.createAttributes();
	}

	@Override
	protected void registerGoals()
	{
		this.entityAIEatGrass = new GenericAIPigSnuffleGoal(this, AnimaniaHelper.getBlock(FarmConfig.settings.pigMud.get()));

		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new GenericAIFindMudGoal(this, 1.2D, AnimaniaHelper.getBlock(FarmConfig.settings.pigMud.get())));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(3, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(3, new GenericAIFindFoodGoal<>(this, 1.0D, true));
		}
		this.goalSelector.addGoal(4, new PanicGoal(this, 1.5D));
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(8, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(FarmConfig.settings.pigBed.get()),
					AnimaniaHelper.getBlock(FarmConfig.settings.pigBed2.get())));
		}
		this.goalSelector.addGoal(9, new TemptGoal(this, 1.2D, stack -> stack.is(Items.CARROT_ON_A_STICK), false));
		this.goalSelector.addGoal(10, new TemptGoal(this, 1.2D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(10, new TemptGoal(this, 1.2D, stack -> stack.is(CommonFluids.SLOP_BUCKET.get()), false));
		this.goalSelector.addGoal(11, this.entityAIEatGrass);
		this.goalSelector.addGoal(13, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F)
		{
			@Override
			protected boolean isWatchSuppressed()
			{
				 
				 
				return super.isWatchSuppressed() || EntityAnimaniaPig.this.getMuddy();
			}
		});
		this.goalSelector.addGoal(15, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(16, new com.animania.common.entity.generic.ai.GenericAIFindSaltLickGoal<>(this, 1.0D));

		this.targetSelector.addGoal(16, new HurtByTargetGoal(this));
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		this.level().broadcastEntityEvent(this, (byte) 18);
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

		if (this.playedTimer > -1 && !AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.playedTimer--;
			if (this.playedTimer == 0)
				this.setPlayed(false);
		}

		if (this.getMudTimer() > 0.0F)
		{
			this.setPlayed(true);
			this.playedTimer = AnimaniaConfig.careAndFeeding.playTimer.get() + this.random.nextInt(100);
		}

		BlockPos currentPos = this.blockPosition();
		boolean onMud = this.level().getBlockState(currentPos).getBlock() == AnimaniaHelper.getBlock(FarmConfig.settings.pigMud.get());

		if (onMud)
			this.addEffect(new net.minecraft.world.effect.MobEffectInstance(net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN, 2, 4, false, false));

		 
		 
		 
		if (onMud && !this.getMuddy())
		{
			this.setMuddy(true);
			this.setMudTimer(1.0F);
			this.setSplashTimer(1.0F);
		}
		else if (this.isInWaterOrRain() && this.getMuddy() && !onMud)
		{
			this.setMuddy(false);
			this.setMudTimer(0.0F);
			this.setSplashTimer(0.0F);
		}
		else if (onMud)
		{
			float splashTimer = this.getSplashTimer() - 0.045F;
			this.setSplashTimer(splashTimer);
			if (splashTimer <= 0.0F)
			{
				this.setMuddy(true);
				this.setMudTimer(1.0F);
			}
		}
		else if (this.getMudTimer() > 0)
		{
			this.setMuddy(false);
			if (Animania.RANDOM.nextInt(3) < 1)
				this.setMudTimer(this.getMudTimer() - 0.0025F);
		}

		super.aiStep();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(MUDDY, false);
		builder.define(MUDTIMER, 0.0F);
		builder.define(SPLASHTIMER, 0.0F);
		builder.define(FED, true);
		builder.define(HANDFED, false);
		builder.define(WATERED, true);
		builder.define(PLAYED, true);
		builder.define(AGE, 0);
		builder.define(SLEEPING, false);
		builder.define(INTERACTED, false);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		GenericBehavior.writeCommonNBT(tag, this);
		tag.putBoolean("Muddy", this.getMuddy());
		tag.putFloat("MudTimer", this.getMudTimer());
		tag.putFloat("SplashTimer", this.getSplashTimer());
		tag.putBoolean("Played", this.getPlayed());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		GenericBehavior.readCommonNBT(tag, this);
		this.setMuddy(tag.getBoolean("Muddy"));
		this.setMudTimer(tag.getFloat("MudTimer"));
		this.setSplashTimer(tag.getFloat("SplashTimer"));
		this.setPlayed(tag.getBoolean("Played"));
	}

	@Override
	public EntityDataAccessor<Integer> getAgeParam()
	{
		return AGE;
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (!stack.isEmpty() && stack.is(CommonFluids.SLOP_BUCKET.get()) && !this.getSleeping())
		{
			if (!player.getAbilities().instabuild)
			{
				stack.shrink(1);
				AnimaniaHelper.addItem(player, new ItemStack(Items.BUCKET));
			}

			this.eatTimer = 40;
			if (this.entityAIEatGrass != null)
				this.entityAIEatGrass.start();
			this.setHandFed(true);
			this.setSlopFed(true);
			this.setInLove(player);
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		if (GenericBehavior.interactCommon(this, player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return super.mobInteract(player, hand);
	}

	@Override
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		if (this instanceof EntityPigletBase)
			return net.minecraft.world.level.storage.loot.BuiltInLootTables.EMPTY;
		return ResourceKey.create(Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath(Animania.MODID,
						this.pigType.isPrime() ? "entities/pig_prime" : "entities/pig_regular"));
	}

	public ResourceLocation getResourceLocation()
	{
		return this.resourceLocation;
	}

	 



	public ResourceLocation getMuddyResourceLocation()
	{
		if (this instanceof EntityPigletBase)
			return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/pigs/piglet_muddy.png");
		if (this.pigType == PigType.HAMPSHIRE)
			return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/pigs/pig_muddy_hampshire.png");
		return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/pigs/pig_muddy.png");
	}

	public ResourceLocation getResourceLocationBlink()
	{
		return this.resourceLocationBlink;
	}

	@Override
	public EntityDataAccessor<Boolean> getFedParam()
	{
		return FED;
	}

	public void setSlopFed(boolean fed)
	{
		if (fed)
		{
			this.entityData.set(FED, true);
			this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() * 2 + this.random.nextInt(100);
		}
		else
		{
			this.entityData.set(FED, false);
		}
	}

	public boolean getPlayed()
	{
		return this.getBoolFromDataManager(PLAYED);
	}

	public void setPlayed(boolean played)
	{
		if (played)
		{
			this.entityData.set(PLAYED, true);
			this.playedTimer = AnimaniaConfig.careAndFeeding.playTimer.get() + this.random.nextInt(100);
		}
		else
		{
			this.entityData.set(PLAYED, false);
		}
	}

	@Override
	public EntityDataAccessor<Boolean> getWateredParam()
	{
		return WATERED;
	}

	public boolean getMuddy()
	{
		return this.getBoolFromDataManager(MUDDY);
	}

	public void setMuddy(boolean muddy)
	{
		this.entityData.set(MUDDY, muddy);
	}

	public Float getMudTimer()
	{
		return this.getFloatFromDataManager(MUDTIMER);
	}

	public void setMudTimer(Float timer)
	{
		this.entityData.set(MUDTIMER, timer);
	}

	public Float getSplashTimer()
	{
		return this.getFloatFromDataManager(SPLASHTIMER);
	}

	public void setSplashTimer(Float timer)
	{
		this.entityData.set(SPLASHTIMER, timer);
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
	public void setCustomSleepingPos(BlockPos pos)
	{
	}

	@Override
	public BlockPos getCustomSleepingPos()
	{
		return null;
	}

	@Override
	public Set<ItemStack> getFoodItems()
	{
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(FarmConfig.settings.pigFood.get()));
	}

	@Override
	public net.minecraft.world.level.material.Fluid[] getFoodFluids()
	{
		return new net.minecraft.world.level.material.Fluid[] { CommonFluids.SLOP_SOURCE.get(), CommonFluids.SLOP_FLOWING.get() };
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return !stack.isEmpty() && (AnimaniaHelper.containsItemStack(this.getFoodItems(), stack) || stack.is(CommonFluids.SLOP_BUCKET.get()));
	}

	@Override
	public void setLiquidFed(boolean liquidFed)
	{
		this.setSlopFed(liquidFed);
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
	public EntityDataAccessor<Boolean> getInteractedParam()
	{
		return INTERACTED;
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
	public EntityDataAccessor<Boolean> getHandFedParam()
	{
		return HANDFED;
	}

	@Override
	public EntityDataAccessor<Boolean> getSleepingParam()
	{
		return SLEEPING;
	}

	@Override
	public AnimaniaType getAnimalType()
	{
		return this.pigType;
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
	@Nullable
	public Pig getBreedOffspring(ServerLevel level, AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public Entity convertToVanilla()
	{
		Pig entity = EntityType.PIG.create(this.level());
		if (entity != null)
		{
			entity.setPos(this.getX(), this.getY(), this.getZ());
			if (this.hasCustomName())
				entity.setCustomName(this.getCustomName());
		}
		return entity;
	}
}
