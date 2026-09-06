package com.animania.addons.extra.common.entity.peafowl;

import java.util.Set;

import javax.annotation.Nullable;

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
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

 

















public class EntityAnimaniaPeacock extends Animal implements IAnimaniaAnimalBase
{
	protected static final EntityDataAccessor<Boolean> FED = SynchedEntityData.defineId(EntityAnimaniaPeacock.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> WATERED = SynchedEntityData.defineId(EntityAnimaniaPeacock.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAnimaniaPeacock.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(EntityAnimaniaPeacock.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HANDFED = SynchedEntityData.defineId(EntityAnimaniaPeacock.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> INTERACTED = SynchedEntityData.defineId(EntityAnimaniaPeacock.class, EntityDataSerializers.BOOLEAN);

	protected ResourceLocation resourceLocation;
	protected ResourceLocation resourceLocationBlink;

	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 1.0F;

	private int fedTimer;
	protected int wateredTimer;
	protected int happyTimer;
	public int blinkTimer;
	private int featherTimer;
	protected int damageTimer;
	public PeacockType type = PeacockType.BLUE;
	public EntityGender gender = EntityGender.NONE;
	public int lidCol;

	public EntityAnimaniaPeacock(EntityType<? extends EntityAnimaniaPeacock> entityType, Level level)
	{
		super(entityType, level);
		this.fedTimer = AnimaniaConfig.careAndFeeding.feedTimer.get() * 2 + this.random.nextInt(100);
		this.wateredTimer = AnimaniaConfig.careAndFeeding.waterTimer.get() * 2 + this.random.nextInt(100);
		this.happyTimer = 60;
		this.blinkTimer = 80 + this.random.nextInt(80);
		this.featherTimer = AnimaniaConfig.careAndFeeding.featherTimer.get();
		this.setPersistenceRequired();
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new FloatGoal(this));
		if (!AnimaniaConfig.gameRules.ambianceMode.get())
		{
			this.goalSelector.addGoal(1, new GenericAIFindWaterGoal<>(this, 1.0D));
			this.goalSelector.addGoal(1, new GenericAIFindFoodGoal<>(this, 1.0D, false));
		}
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, stack -> AnimaniaHelper.containsItemStack(this.getFoodItems(), stack), false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new GenericAIWatchClosestGoal<>(this, Player.class, 6.0F)
		{
			@Override
			protected boolean isWatchSuppressed()
			{
				 
				return !EntityAnimaniaPeacock.this.level().isDay() || EntityAnimaniaPeacock.this.getSleeping();
			}
		});
		if (AnimaniaConfig.gameRules.animalsSleep.get())
		{
			this.goalSelector.addGoal(6, new GenericAISleepGoal<>(this, 0.8,
					AnimaniaHelper.getBlock(ExtraConfig.settings.peacockBed.get()),
					AnimaniaHelper.getBlock(ExtraConfig.settings.peacockBed2.get())));
		}
		this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
		if (AnimaniaConfig.gameRules.animalsCanAttackOthers.get())
		{
			this.goalSelector.addGoal(8, new LeapAtTargetGoal(this, 0.2F));
			this.goalSelector.addGoal(9, new MeleeAttackGoal(this, 1.0D, true));
		}
		this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return Animal.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 7.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.ATTACK_DAMAGE, 1.5D);
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
	public boolean doHurtTarget(Entity entityIn)
	{
		boolean flag = entityIn.hurt(this.level().damageSources().mobAttack(this), 2.0F);

		 

		if (entityIn instanceof com.animania.addons.extra.common.entity.amphibians.EntityAmphibian)
			this.setFed(true);

		if (entityIn instanceof Player)
			((LivingEntity) entityIn).knockback(1, this.getX() - entityIn.getX(), this.getZ() - entityIn.getZ());

		return flag;
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
		builder.define(HANDFED, false);
		builder.define(WATERED, true);
		builder.define(AGE, 0);
		builder.define(SLEEPING, false);
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

		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = this.destPos + ((this.onGround() || this.isPassenger()) ? -1 : 4) * 0.3F;
		this.destPos = net.minecraft.util.Mth.clamp(this.destPos, 0.0F, 1.0F);

		if (!this.onGround() && !this.isPassenger() && this.wingRotDelta < 1.0F)
			this.wingRotDelta = 1.0F;

		this.wingRotDelta *= 0.9F;

		if (!this.onGround() && !this.isPassenger() && this.getDeltaMovement().y < 0.0D)
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.6, 1.0));

		this.wingRotation += this.wingRotDelta * 2.0F;

		if (this instanceof EntityPeacockBase && AnimaniaConfig.gameRules.birdsDropFeathers.get())
		{
			this.featherTimer--;
			if (this.featherTimer <= 0)
			{
				this.featherTimer = AnimaniaConfig.careAndFeeding.featherTimer.get();
				Item feather = this.type.getFeather();

				if (!this.level().isClientSide)
					this.spawnAtLocation(feather, 1);
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
				com.animania.addons.farm.FarmSounds.PEACOCK_1.get(), com.animania.addons.farm.FarmSounds.PEACOCK_2.get(),
				com.animania.addons.farm.FarmSounds.PEACOCK_3.get(), com.animania.addons.farm.FarmSounds.PEACOCK_4.get(),
				com.animania.addons.farm.FarmSounds.PEACOCK_5.get(), com.animania.addons.farm.FarmSounds.PEACOCK_7.get(),
				com.animania.addons.farm.FarmSounds.PEACOCK_8.get(), com.animania.addons.farm.FarmSounds.PEACOCK_9.get(),
				com.animania.addons.farm.FarmSounds.PEACOCK_10.get());
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return com.animania.common.entity.generic.GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.PEACOCK_HURT_1.get(), com.animania.addons.farm.FarmSounds.PEACOCK_HURT_2.get());
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound()
	{
		return com.animania.common.entity.generic.GenericBehavior.getRandomSound(
				com.animania.addons.farm.FarmSounds.PEACOCK_HURT_1.get(), com.animania.addons.farm.FarmSounds.PEACOCK_HURT_2.get());
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state)
	{
		this.playSound(net.minecraft.sounds.SoundEvents.CHICKEN_STEP, 0.05F, 1.0F);
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
	protected net.minecraft.resources.ResourceKey<net.minecraft.world.level.storage.loot.LootTable> getDefaultLootTable()
	{
		 
		return net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.LOOT_TABLE,
				ResourceLocation.fromNamespaceAndPath(com.animania.Animania.MODID,
						"entities/peacocks/peacock_" + this.type.name().toLowerCase(java.util.Locale.ROOT)));
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
		return Sets.newHashSet(AnimaniaHelper.getItemStackArray(ExtraConfig.settings.peacockFood.get()));
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
