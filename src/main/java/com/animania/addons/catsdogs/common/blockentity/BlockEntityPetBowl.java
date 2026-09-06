package com.animania.addons.catsdogs.common.blockentity;

import java.util.Set;

import javax.annotation.Nullable;

import com.animania.addons.catsdogs.CatsDogsBlocks;
import com.animania.addons.catsdogs.common.block.BlockPetBowl;
import com.animania.api.interfaces.IFoodProviderTE;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.ItemStackHandler;

 



public class BlockEntityPetBowl extends BlockEntity implements IFoodProviderTE
{
	public static final int CAPACITY_MB = 1000;
	public static final int FOOD_SLOT_LIMIT = 3;

	private final ItemStackHandler itemHandler = new ItemStackHandler(1)
	{
		@Override
		protected void onContentsChanged(int slot)
		{
			BlockEntityPetBowl.this.setChangedAndSync();
		}

		@Override
		public int getSlotLimit(int slot)
		{
			return FOOD_SLOT_LIMIT;
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack)
		{
			return BlockPetBowl.isFoodItem(stack) && BlockEntityPetBowl.this.fluidTank.isEmpty();
		}
	};

	private final FluidTank fluidTank = new FluidTank(CAPACITY_MB)
	{
		@Override
		protected void onContentsChanged()
		{
			BlockEntityPetBowl.this.setChangedAndSync();
		}

		@Override
		public boolean isFluidValid(FluidStack stack)
		{
			return stack.getFluid() == Fluids.WATER && BlockEntityPetBowl.this.itemHandler.getStackInSlot(0).isEmpty();
		}
	};

	public BlockEntityPetBowl(BlockPos pos, BlockState state)
	{
		super(CatsDogsBlocks.PET_BOWL_BLOCK_ENTITY.get(), pos, state);
	}

	public ItemStackHandler getItemHandler()
	{
		return this.itemHandler;
	}

	public FluidTank getFluidTank()
	{
		return this.fluidTank;
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
		tag.put("Fluid", this.fluidTank.writeToNBT(registries, new CompoundTag()));
	}

	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.loadAdditional(tag, registries);
		this.itemHandler.deserializeNBT(registries, tag.getCompound("Items"));
		this.fluidTank.readFromNBT(registries, tag.getCompound("Fluid"));
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

	@Override
	public boolean canConsume(Set<ItemStack> foodItems, Fluid[] fluids)
	{
		if (fluids == null)
			return this.canConsume((FluidStack) null, foodItems);
		for (Fluid fluid : fluids)
			if (this.canConsume(new FluidStack(fluid, 1), foodItems))
				return true;
		return false;
	}

	@Override
	public boolean canConsume(@Nullable FluidStack fluid, @Nullable Set<ItemStack> foodItems)
	{
		ItemStack food = this.itemHandler.getStackInSlot(0);
		if (foodItems != null && !food.isEmpty())
			return AnimaniaHelper.containsItemStack(foodItems, food);
		return fluid != null && !this.fluidTank.isEmpty() && this.fluidTank.getFluid().getFluid() == fluid.getFluid();
	}

	@Override
	public void consumeSolidOrLiquid(int liquidAmount, int itemAmount)
	{
		if (!this.itemHandler.getStackInSlot(0).isEmpty())
			this.consumeSolid(itemAmount);
		else if (!this.fluidTank.isEmpty())
			this.consumeLiquid(liquidAmount);
	}

	@Override
	public void consumeSolid(int amount)
	{
		this.itemHandler.extractItem(0, amount, false);
	}

	@Override
	public void consumeLiquid(int amount)
	{
		this.fluidTank.drain(amount, FluidAction.EXECUTE);
	}
}
