package com.animania.addons.extra.common.blockentity;

import javax.annotation.Nullable;

import com.animania.addons.extra.ExtraBlocks;
import com.animania.addons.extra.ExtraItems;
import com.animania.addons.extra.common.entity.rodents.EntityHamster;
import com.animania.addons.extra.config.ExtraConfig;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;

 




























public class BlockEntityHamsterWheel extends BlockEntity
{
	private CompoundTag hamsterTag = new CompoundTag();
	private int timer;

	private final ItemStackHandler itemHandler = new ItemStackHandler(1)
	{
		@Override
		protected void onContentsChanged(int slot)
		{
			BlockEntityHamsterWheel.this.setChangedAndSync();
		}

		@Override
		public int getSlotLimit(int slot)
		{
			return 16;
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack)
		{
			return stack.is(ExtraItems.HAMSTER_FOOD.get());
		}
	};

	private final EnergyStorage energyStorage = new EnergyStorage(ExtraConfig.settings.hamsterWheelCapacity.get())
	{
		@Override
		public int receiveEnergy(int maxReceive, boolean simulate)
		{
			int received = super.receiveEnergy(maxReceive, simulate);
			if (received > 0 && !simulate)
				BlockEntityHamsterWheel.this.setChangedAndSync();
			return received;
		}

		@Override
		public int extractEnergy(int maxExtract, boolean simulate)
		{
			int extracted = super.extractEnergy(maxExtract, simulate);
			if (extracted > 0 && !simulate)
				BlockEntityHamsterWheel.this.setChangedAndSync();
			return extracted;
		}
	};

	public BlockEntityHamsterWheel(BlockPos pos, BlockState state)
	{
		super(ExtraBlocks.HAMSTER_WHEEL_BLOCK_ENTITY.get(), pos, state);
	}

	public boolean isRunning()
	{
		return !this.hamsterTag.isEmpty();
	}

	public ItemStackHandler getItemHandler()
	{
		return this.itemHandler;
	}

	public EnergyStorage getEnergyStorage()
	{
		return this.energyStorage;
	}

	 
	public boolean insertHamster(CompoundTag tag)
	{
		if (this.isRunning())
			return false;
		this.hamsterTag = tag.copy();
		this.timer = 0;
		this.setChangedAndSync();
		return true;
	}

	public void ejectHamster()
	{
		if (this.hamsterTag.isEmpty() || this.level == null || this.level.isClientSide || !(this.level instanceof ServerLevel serverLevel))
		{
			this.hamsterTag = new CompoundTag();
			return;
		}

		BlockPos dropPos = findPositionForHamster();
		if (dropPos != null)
		{
			CompoundTag tag = this.hamsterTag;
			Entity released = EntityType.loadEntityRecursive(tag, serverLevel, e ->
			{
				e.moveTo(dropPos.getX() + 0.5, dropPos.getY(), dropPos.getZ() + 0.5, e.getYRot(), e.getXRot());
				return e;
			});
			if (released instanceof EntityHamster hamster)
			{
				hamster.setFed(false);
				AnimaniaHelper.spawnEntity(serverLevel, hamster);
				hamster.playSound(SoundEvents.ITEM_PICKUP, 1.0F, (serverLevel.getRandom().nextFloat() - serverLevel.getRandom().nextFloat()) * 0.2F + 1.0F);
			}
		}
		else
		{
			 
			 
			 
			 
			this.level.playSound(null, this.worldPosition, SoundEvents.ITEM_BREAK, SoundSource.AMBIENT, 1.0F, 1.0F);
		}

		this.hamsterTag = new CompoundTag();
		this.setChangedAndSync();
	}

	@Nullable
	private BlockPos findPositionForHamster()
	{
		if (this.level == null)
			return null;
		for (Direction direction : Direction.values())
		{
			BlockPos candidate = this.worldPosition.relative(direction);
			BlockState state = this.level.getBlockState(candidate);
			if (state.getBlock() != ExtraBlocks.HAMSTER_WHEEL.get()
					&& state.getCollisionShape(this.level, candidate).isEmpty())
				return candidate;
		}
		return null;
	}

	public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, BlockEntityHamsterWheel wheel)
	{
		if (wheel.isRunning())
		{
			wheel.energyStorage.receiveEnergy(ExtraConfig.settings.hamsterWheelRFGeneration.get(), false);
			wheel.timer++;
		}

		if (wheel.timer >= ExtraConfig.settings.hamsterWheelUseTime.get())
		{
			ItemStack food = wheel.itemHandler.getStackInSlot(0);
			if (!food.isEmpty())
			{
				wheel.itemHandler.extractItem(0, 1, false);
			}
			else
			{
				wheel.ejectHamster();
			}
			wheel.timer = 0;
			wheel.setChangedAndSync();
		}
	}

	private void setChangedAndSync()
	{
		this.setChanged();
		if (this.level != null && !this.level.isClientSide)
			this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
	}

	@Override
	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.saveAdditional(tag, registries);
		tag.put("Hamster", this.hamsterTag);
		tag.putInt("Timer", this.timer);
		tag.put("Items", this.itemHandler.serializeNBT(registries));
		tag.putInt("Energy", this.energyStorage.getEnergyStored());
	}

	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.loadAdditional(tag, registries);
		this.hamsterTag = tag.getCompound("Hamster");
		this.timer = tag.getInt("Timer");
		this.itemHandler.deserializeNBT(registries, tag.getCompound("Items"));
		this.energyStorage.receiveEnergy(tag.getInt("Energy"), false);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries)
	{
		return this.saveWithoutMetadata(registries);
	}

	@Nullable
	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket()
	{
		return ClientboundBlockEntityDataPacket.create(this);
	}
}
