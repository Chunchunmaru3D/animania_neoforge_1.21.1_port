package com.animania.addons.farm.common.entity.pullables;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse;
import com.animania.addons.farm.common.entity.pigs.EntityAnimaniaPig;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

 





public class EntityCart extends EntityPullableBase
{
	protected static final EntityDataAccessor<Boolean> HAS_CHEST = SynchedEntityData.defineId(EntityCart.class, EntityDataSerializers.BOOLEAN);

	private SimpleContainer chest = new SimpleContainer(36);
	private float damageTaken;
	private int timeSinceHit;

	public EntityCart(EntityType<? extends EntityCart> entityType, Level level)
	{
		super(entityType, level);
	}

	@Override
	protected int getPullerTypeFor(Entity candidate)
	{
		if (candidate instanceof EntityAnimaniaHorse)
			return 1;
		if (candidate instanceof EntityAnimaniaPig)
			return 3;
		return super.getPullerTypeFor(candidate);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(HAS_CHEST, false);
	}

	public boolean hasChest()
	{
		return this.entityData.get(HAS_CHEST);
	}

	public void setHasChest(boolean hasChest)
	{
		this.entityData.set(HAS_CHEST, hasChest);
	}

	public SimpleContainer getChestInventory()
	{
		return this.chest;
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		 
		if (player.isShiftKeyDown())
		{
			if (this.hasChest())
			{
				if (!this.level().isClientSide && player instanceof net.minecraft.server.level.ServerPlayer serverPlayer)
				{
					serverPlayer.openMenu(new net.minecraft.world.SimpleMenuProvider(
							 
							 
							 
							(id, inv, p) -> new net.minecraft.world.inventory.ChestMenu(
									net.minecraft.world.inventory.MenuType.GENERIC_9x4, id, inv, this.chest, 4),
							net.minecraft.network.chat.Component.translatable("container.animania.cart")));
				}
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			}
			else if (stack.getItem() != Items.CHEST && player.getVehicle() != this)
			{
				player.startRiding(this);
				if (this.puller == player)
				{
					this.detachPuller();
				}
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			}
			return InteractionResult.PASS;
		}

		 
		if (stack.getItem() == Items.CHEST && !this.hasChest() && !this.isVehicle())
		{
			this.setHasChest(true);
			if (!player.getAbilities().instabuild)
				stack.shrink(1);
			if (!this.level().isClientSide)
				this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.CHEST_LOCKED, SoundSource.PLAYERS, 0.7F, 1.0F);
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		if (this.handleHitchInteract(player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return InteractionResult.PASS;
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
				this.spawnAtLocation(new ItemStack(FarmItems.ITEM_CART.get()));
				if (this.hasChest())
				{
					Containers.dropContents(this.level(), this, this.chest);
					this.spawnAtLocation(new ItemStack(Items.CHEST));
				}
			}
			this.discard();
		}
		return true;
	}

	@Override
	public void tick()
	{
		super.tick();
		if (this.timeSinceHit > 0)
			this.timeSinceHit--;
		this.damageTaken *= 0.98F;
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setHasChest(tag.getBoolean("HasChest"));
		this.chest = new SimpleContainer(36);
		if (this.hasChest() && tag.contains("Items"))
		{
			net.minecraft.world.ContainerHelper.loadAllItems(tag, this.chest.getItems(), this.registryAccess());
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putBoolean("HasChest", this.hasChest());
		if (this.hasChest())
		{
			net.minecraft.world.ContainerHelper.saveAllItems(tag, this.chest.getItems(), this.registryAccess());
		}
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger()
	{
		 
		 
		return this.getFirstPassenger() instanceof LivingEntity living ? living : null;
	}

	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float partialTick)
	{
		 
		 
		return new Vec3(0.0D, 0.62D, 0.0D);
	}

	@Override
	public boolean isPickable()
	{
		return !this.isRemoved();
	}
}
