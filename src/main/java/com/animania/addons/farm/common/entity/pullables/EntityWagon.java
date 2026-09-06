package com.animania.addons.farm.common.entity.pullables;

import java.util.List;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmItems;
import com.mojang.datafixers.util.Either;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

 


















public class EntityWagon extends EntityPullableBase
{
	protected static final EntityDataAccessor<Boolean> HAS_CHEST = SynchedEntityData.defineId(EntityWagon.class, EntityDataSerializers.BOOLEAN);

	private SimpleContainer chest = new SimpleContainer(54);
	private float damageTaken;
	private int timeSinceHit;
	private int rideCooldown;

	 
	public int blinkTimer;

	public EntityWagon(EntityType<? extends EntityWagon> entityType, Level level)
	{
		super(entityType, level);
	}

	@Override
	protected int getPullerTypeFor(Entity candidate)
	{
		return candidate instanceof com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse ? 1
				: super.getPullerTypeFor(candidate);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(HAS_CHEST, true);
	}

	public SimpleContainer getChestInventory()
	{
		return this.chest;
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand)
	{
		if (player.isShiftKeyDown())
		{
			if (!this.level().isClientSide && player instanceof net.minecraft.server.level.ServerPlayer serverPlayer)
			{
				serverPlayer.openMenu(new net.minecraft.world.SimpleMenuProvider(
						 
						 
						(id, inv, p) -> new net.minecraft.world.inventory.ChestMenu(
								net.minecraft.world.inventory.MenuType.GENERIC_9x6, id, inv, this.chest, 6),
						Component.translatable("container.animania.wagon")));
			}
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		ItemStack stack = player.getItemInHand(hand);

		 
		 
		 
		 
		 
		if (stack.isEmpty() && player.getVehicle() == null && this.rideCooldown <= 0
				&& com.animania.addons.farm.config.FarmConfig.settings.sleepAllowedWagon.get())
		{
			Either<Player.BedSleepingProblem, net.minecraft.util.Unit> result = player.startSleepInBed(this.blockPosition());
			if (result.right().isPresent())
			{
				if (!this.level().isClientSide)
				{
					player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 1, false, false));
					 
					 
					if (player instanceof net.minecraft.server.level.ServerPlayer serverPlayer)
						serverPlayer.setRespawnPosition(this.level().dimension(), this.blockPosition(), this.getYRot(), true, false);
				}
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			}
			 
			 
			Component message = result.left().map(Player.BedSleepingProblem::getMessage).orElse(null);
			if (message != null && result.left().get() != Player.BedSleepingProblem.NOT_POSSIBLE_NOW)
				player.displayClientMessage(message, true);
		}

		 
		 
		 
		if (stack.isEmpty() && this.handleHitchInteract(player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		if (stack.isEmpty() && player.getVehicle() != this && this.getPassengers().size() < 2)
		{
			player.startRiding(this);
			this.rideCooldown = 20;
			if (this.puller == player)
			{
				this.detachPuller();
			}
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		return InteractionResult.PASS;
	}

	@Override
	public void tick()
	{
		super.tick();
		if (this.timeSinceHit > 0)
			this.timeSinceHit--;
		if (this.rideCooldown > 0)
			this.rideCooldown--;
		this.damageTaken *= 0.98F;

		 
		 
		 
		if (this.blinkTimer > -1)
			this.blinkTimer--;
		else
			this.blinkTimer = 100 + this.random.nextInt(100);
	}

	 




	@Override
	protected void positionRider(Entity passenger, Entity.MoveFunction moveFunction)
	{
		if (!this.hasPassenger(passenger))
			return;

		float f = 0.0F;
		 
		 
		double yOffset = 0.7D;
		if (passenger instanceof Player)
			yOffset = 1.55D;

		List<Entity> passengers = this.getPassengers();
		if (passengers.size() > 1)
		{
			int i = passengers.indexOf(passenger);
			f = i == 0 ? 0.2F : -0.6F;
			if (passenger instanceof Animal)
				f += 0.2F;
		}
		if (passenger instanceof Player)
			f += 1.8F;

		Vec3 vec3 = new Vec3(f, 0.0D, 0.0D).yRot(-this.getYRot() * Mth.DEG_TO_RAD - (float) (Math.PI / 2));
		moveFunction.accept(passenger, this.getX() + vec3.x, this.getY() + yOffset, this.getZ() + vec3.z);
	}

	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float partialTick)
	{
		 
		 
		return new Vec3(0.0D, 0.7D, 0.0D);
	}

	@Override
	public boolean hurt(DamageSource source, float amount)
	{
		if (this.isInvulnerableTo(source))
			return false;
		if (this.level().isClientSide || this.isRemoved())
			return true;

		this.timeSinceHit = 10;
		this.damageTaken += amount * 10.0F;
		this.markHurt();

		boolean creative = source.getEntity() instanceof Player p && p.getAbilities().instabuild;
		if (creative || this.damageTaken > 40.0F)
		{
			if (!creative && this.level().getGameRules().getBoolean(net.minecraft.world.level.GameRules.RULE_DOENTITYDROPS))
			{
				this.spawnAtLocation(new ItemStack(FarmItems.ITEM_WAGON.get()));
				Containers.dropContents(this.level(), this, this.chest);
				this.spawnAtLocation(new ItemStack(Items.CHEST));
			}
			this.discard();
		}
		return true;
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.chest = new SimpleContainer(54);
		if (tag.contains("Items"))
			net.minecraft.world.ContainerHelper.loadAllItems(tag, this.chest.getItems(), this.registryAccess());
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		net.minecraft.world.ContainerHelper.saveAllItems(tag, this.chest.getItems(), this.registryAccess());
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger()
	{
		 
		return this.getFirstPassenger() instanceof LivingEntity living ? living : null;
	}

	@Override
	public boolean isPickable()
	{
		return !this.isRemoved();
	}
}
