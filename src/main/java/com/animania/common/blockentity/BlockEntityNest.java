package com.animania.common.blockentity;

import javax.annotation.Nullable;

import com.animania.common.blocks.CommonBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

 












public class BlockEntityNest extends BlockEntity
{
	public static final int SLOT_LIMIT = 3;

	 




	@Nullable
	private String breedId;

	private final ItemStackHandler itemHandler = new ItemStackHandler(1)
	{
		@Override
		protected void onContentsChanged(int slot)
		{
			if (this.getStackInSlot(0).isEmpty())
				BlockEntityNest.this.breedId = null;

			BlockEntityNest.this.setChangedAndSync();
		}

		@Override
		public int getSlotLimit(int slot)
		{
			return SLOT_LIMIT;
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack)
		{
			ItemStack existing = this.getStackInSlot(0);
			return existing.isEmpty() || existing.is(stack.getItem());
		}
	};

	public BlockEntityNest(BlockPos pos, BlockState state)
	{
		super(CommonBlockEntities.NEST.get(), pos, state);
	}

	public ItemStackHandler getItemHandler()
	{
		return this.itemHandler;
	}

	@Nullable
	public String getBreedId()
	{
		return this.breedId;
	}

	 
	public boolean layEgg(Item eggItem, @Nullable String breedId)
	{
		ItemStack existing = this.itemHandler.getStackInSlot(0);
		if (!existing.isEmpty() && (!existing.is(eggItem) || existing.getCount() >= SLOT_LIMIT))
			return false;

		if (!existing.isEmpty() && this.breedId != null && breedId != null && !this.breedId.equals(breedId))
			return false;

		ItemStack remainder = this.itemHandler.insertItem(0, new ItemStack(eggItem, 1), false);
		if (!remainder.isEmpty())
			return false;

		this.breedId = breedId;
		return true;
	}

	 
	public ItemStack hatchOneEgg()
	{
		return this.itemHandler.extractItem(0, 1, false);
	}

	public boolean hasRoomFor(Item eggItem, @Nullable String breedId)
	{
		ItemStack existing = this.itemHandler.getStackInSlot(0);
		if (existing.isEmpty())
			return true;
		if (!existing.is(eggItem) || existing.getCount() >= SLOT_LIMIT)
			return false;
		return this.breedId == null || breedId == null || this.breedId.equals(breedId);
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
		tag.put("Items", this.itemHandler.serializeNBT(registries));
		if (this.breedId != null)
			tag.putString("BreedId", this.breedId);
	}

	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.loadAdditional(tag, registries);
		this.itemHandler.deserializeNBT(registries, tag.getCompound("Items"));
		this.breedId = tag.contains("BreedId") ? tag.getString("BreedId") : null;
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
