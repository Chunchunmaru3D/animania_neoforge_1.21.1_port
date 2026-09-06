package com.animania.addons.extra.common.entity.rodents;

import java.util.Set;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.addons.extra.config.ExtraConfig;
import com.animania.addons.extra.ExtraItems;
import com.animania.addons.extra.common.item.ItemHamsterBall;

import com.animania.addons.farm.FarmSounds;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;

 


















public class EntityHamster extends TamableAnimal implements IAnimaniaAnimalBase
{
	private static final String[] HAMSTER_TEXTURES = { "black", "brown", "darkbrown", "darkgray", "gray", "plum", "tarou", "white", "gold" };

	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> COLOR_NUM = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> FOOD_STACK_COUNT = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> STANDING = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IN_BALL = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> BALL_COLOR = SynchedEntityData.defineId(EntityHamster.class, EntityDataSerializers.INT);

	private int fedTimer;
	private int wateredTimer;
	private int happyTimer;
	public int blinkTimer;
	private int damageTimer;
	private int eatCount = 5000;
	private int standCount = 30;
	private ResourceLocation resourceLocation;
	private ResourceLocation resourceLocationBlink;

	public EntityHamster(EntityType<? extends EntityHamster> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() * 4 + this.random.nextInt(200);
		this.happyTimer = 60;
		this.blinkTimer = 70 + this.random.nextInt(70);
		this.setPersistenceRequired();
	}

	 
	@Override
	protected ResourceKey<LootTable> getDefaultLootTable()
	{
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entities/hamster"));
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(2, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(2, new GenericAIFindFoodGoal<>(this, 1.0D, false));
		}
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new TemptGoal(this, 1.2D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(7, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(9, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(ExtraConfig.settings.hamsterBed.get()),
					AnimaniaHelper.getBlock(ExtraConfig.settings.hamsterBed2.get())));
		}
		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return TamableAnimal.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.STEP_HEIGHT, 1.0D);
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

			this.addFoodStack();

			if (this.random.nextInt(3) == 0)
				this.tame(player);
			else
				this.level().broadcastEntityEvent(this, (byte) 6);

			return InteractionResult.SUCCESS;
		}

		if (!this.isInBall() && !this.getSleeping()
				&& (stack.is(ExtraItems.HAMSTER_BALL_COLORED.get()) || stack.is(ExtraItems.HAMSTER_BALL_CLEAR.get())))
		{
			if (!this.level().isClientSide)
			{
				this.setOrderedToSit(false);
				this.setBallColor(stack.is(ExtraItems.HAMSTER_BALL_CLEAR.get()) ? ItemHamsterBall.CLEAR_COLOR
						: ((ItemHamsterBall) stack.getItem()).getColor(stack));
				this.setInBall(true);
				if (!player.getAbilities().instabuild)
					stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		if (this.isInBall() && !this.getSleeping() && stack.isEmpty())
		{
			if (!this.level().isClientSide)
			{
				int color = this.getBallColor();
				this.setInBall(false);
				if (!player.getAbilities().instabuild)
					AnimaniaHelper.addItem(player, this.createBallStack(color));
			}
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		if (this.isTame() && this.isOwnedBy(player) && stack.isEmpty() && player.isShiftKeyDown())
		{
			if (com.animania.addons.extra.common.pocket.PocketCarryHandler.tryCapture(this, player))
				return InteractionResult.SUCCESS;

			this.setOrderedToSit(!this.isOrderedToSit());
			return InteractionResult.SUCCESS;
		}

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
		builder.define(COLOR_NUM, this.random.nextInt(HAMSTER_TEXTURES.length));
		builder.define(FOOD_STACK_COUNT, 0);
		builder.define(STANDING, false);
		builder.define(IN_BALL, false);
		builder.define(BALL_COLOR, ItemHamsterBall.CLEAR_COLOR);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putInt("ColorNumber", this.getColorNumber());
		tag.putInt("FoodStackCount", this.getFoodStackCount());
		tag.putBoolean("InBall", this.isInBall());
		tag.putInt("BallColor", this.getBallColor());
		GenericBehavior.writeCommonNBT(tag, this);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setColorNumber(tag.getInt("ColorNumber"));
		this.setFoodStackCount(tag.getInt("FoodStackCount"));
		this.setInBall(tag.getBoolean("InBall"));
		this.setBallColor(tag.contains("BallColor") ? tag.getInt("BallColor") : ItemHamsterBall.CLEAR_COLOR);
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
		this.resolveTextures();

		if (this.getHealth() < 10.0F)
		{
			this.eatFood();
			this.eatCount = 5000;
		}

		if (!this.isStanding() && !this.isOrderedToSit() && !this.getSleeping())
		{
			if (this.random.nextInt(20) == 0 && this.random.nextInt(20) == 0)
			{
				this.setStanding(true);
				this.standCount = 30;
				this.getNavigation().stop();
			}
		}
		else if (this.isStanding() && this.standCount-- <= 0 && this.random.nextInt(10) == 0)
		{
			this.setStanding(false);
		}

		if (this.getFoodStackCount() > 0)
		{
			if (this.eatCount == 0)
			{
				if (this.random.nextInt(30) == 0 && this.random.nextInt(30) == 0)
				{
					this.eatFood();
					this.eatCount = 5000;
				}
			}
			else
				this.eatCount--;
		}

		if (this.isOrderedToSit() || this.isStanding())
			this.getNavigation().stop();
	}

	private void resolveTextures()
	{
		if (this.resourceLocation == null)
		{
			int color = Math.floorMod(this.getColorNumber(), HAMSTER_TEXTURES.length);
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rodents/hamster_" + HAMSTER_TEXTURES[color] + ".png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rodents/hamster_" + HAMSTER_TEXTURES[color] + "_blink.png");
		}
	}

	public ResourceLocation getResourceLocation()
	{
		this.resolveTextures();
		return this.resourceLocation;
	}

	public ResourceLocation getResourceLocationBlink()
	{
		this.resolveTextures();
		return this.resourceLocationBlink;
	}

	public int getColorNumber()
	{
		return this.entityData.get(COLOR_NUM);
	}

	public void setColorNumber(int color)
	{
		this.entityData.set(COLOR_NUM, color);
	}

	public boolean isStanding()
	{
		return this.entityData.get(STANDING);
	}

	public void setStanding(boolean standing)
	{
		this.entityData.set(STANDING, standing);
	}

	public boolean isInBall()
	{
		return this.entityData.get(IN_BALL);
	}

	public void setInBall(boolean inBall)
	{
		if (this.entityData.get(IN_BALL) == inBall)
			return;
		this.entityData.set(IN_BALL, inBall);
		this.playSound(SoundEvents.ARMOR_EQUIP_GENERIC.value(), 0.3F, inBall ? 1.6F : 1.3F);
	}

	public int getBallColor()
	{
		return this.entityData.get(BALL_COLOR);
	}

	public void setBallColor(int color)
	{
		this.entityData.set(BALL_COLOR, color == ItemHamsterBall.CLEAR_COLOR ? color : Math.floorMod(color, 16));
	}

	private ItemStack createBallStack(int color)
	{
		return color == ItemHamsterBall.CLEAR_COLOR
				? new ItemStack(ExtraItems.HAMSTER_BALL_CLEAR.get())
				: ItemHamsterBall.colouredStack(ExtraItems.HAMSTER_BALL_COLORED.get(), color);
	}

	@Override
	protected void dropCustomDeathLoot(ServerLevel level, DamageSource source, boolean causedByPlayer)
	{
		super.dropCustomDeathLoot(level, source, causedByPlayer);
		if (this.isInBall())
			this.spawnAtLocation(this.createBallStack(this.getBallColor()));
	}

	public int getFoodStackCount()
	{
		return this.entityData.get(FOOD_STACK_COUNT);
	}

	public void setFoodStackCount(int count)
	{
		this.entityData.set(FOOD_STACK_COUNT, count);
	}

	private boolean addFoodStack()
	{
		if (this.getFoodStackCount() != 5)
		{
			this.setFoodStackCount(this.getFoodStackCount() + 1);
			return true;
		}

		this.heal(1.0F);
		return false;
	}

	private boolean eatFood()
	{
		if (this.getFoodStackCount() != 0)
		{
			this.setFoodStackCount(this.getFoodStackCount() - 1);
			this.heal(1.0F);
			return true;
		}
		return false;
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
				FarmSounds.HAMSTER_LIVING_1.get(), FarmSounds.HAMSTER_LIVING_2.get(), FarmSounds.HAMSTER_LIVING_3.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return FarmSounds.HAMSTER_HURT_1.get();
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		 
		return FarmSounds.HAMSTER_HURT_1.get();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state)
	{
		this.playSound(SoundEvents.WOLF_STEP, 0.02F, 1.8F);
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
		return 14603464;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 14317391;
	}

	@Override
	public EntityGender getEntityGender()
	{
		return EntityGender.NONE;
	}

	@Override
	public Set<ItemStack> getFoodItems()
	{
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(ExtraConfig.settings.hamsterFood.get()));
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
		return HamsterType.STANDARD;
	}
}
