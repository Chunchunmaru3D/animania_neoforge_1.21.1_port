package com.animania.addons.farm.common.blockentity;

import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.common.block.BlockCheeseMold;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.common.fluids.CommonFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.Locale;

import javax.annotation.Nullable;

 








public class BlockEntityCheeseMold extends BlockEntity
{
	public static final int CAPACITY_MB = 1000;
	public enum MoldContent implements StringRepresentable
	{
		EMPTY, MILK_FRIESIAN, MILK_HOLSTEIN, MILK_JERSEY, MILK_SHEEP, MILK_GOAT, WATER,
		CHEESE_FRIESIAN, CHEESE_HOLSTEIN, CHEESE_JERSEY, CHEESE_SHEEP, CHEESE_GOAT, SALT;

		public boolean isAging()
		{
			return this == MILK_FRIESIAN || this == MILK_HOLSTEIN || this == MILK_JERSEY
					|| this == MILK_SHEEP || this == MILK_GOAT || this == WATER;
		}

		public boolean isFinished()
		{
			return this == CHEESE_FRIESIAN || this == CHEESE_HOLSTEIN || this == CHEESE_JERSEY
					|| this == CHEESE_SHEEP || this == CHEESE_GOAT || this == SALT;
		}

		@Override
		public String getSerializedName()
		{
			return this.name().toLowerCase(Locale.ROOT);
		}
	}

	private MoldContent content = MoldContent.EMPTY;
	private int progress;
	private final ItemStackHandler itemHandler = new ItemStackHandler(1)
	{
		@Override
		protected void onContentsChanged(int slot)
		{
			BlockEntityCheeseMold.this.setChangedAndSync();
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack)
		{
			return false;
		}

		@Override
		public int getSlotLimit(int slot)
		{
			return 1;
		}
	};
	private final FluidTank fluidTank = new FluidTank(CAPACITY_MB)
	{
		@Override
		protected void onContentsChanged()
		{
			BlockEntityCheeseMold.this.onFluidChanged();
		}

		@Override
		public boolean isFluidValid(FluidStack stack)
		{
			return BlockEntityCheeseMold.this.itemHandler.getStackInSlot(0).isEmpty()
					&& !BlockEntityCheeseMold.this.content.isFinished()
					&& contentForFluid(stack.getFluid()) != null;
		}
	};

	public BlockEntityCheeseMold(BlockPos pos, BlockState state)
	{
		super(FarmBlocks.CHEESE_MOLD_BLOCK_ENTITY.get(), pos, state);
	}

	public MoldContent getContent()
	{
		return this.content;
	}

	public int getProgress()
	{
		return this.progress;
	}

	 
	public FluidTank getFluidTank()
	{
		return this.fluidTank;
	}

	 
	public ItemStackHandler getItemHandler()
	{
		return this.itemHandler;
	}

	 



	public boolean tryFill(ItemStack heldItem)
	{
		if (this.content != MoldContent.EMPTY)
			return false;

		Fluid fluid = fluidForBucket(heldItem.getItem());
		if (fluid == null)
			return false;

		return this.fluidTank.fill(new FluidStack(fluid, CAPACITY_MB), FluidAction.EXECUTE) == CAPACITY_MB;
	}

	 
	@Nullable
	public ItemStack tryTakeResult()
	{
		if (!this.content.isFinished())
			return null;

		ItemStack result = this.itemHandler.extractItem(0, 64, false);
		if (result.isEmpty())
			return null;
		this.content = MoldContent.EMPTY;
		this.progress = 0;
		this.setChangedAndSync();
		return result;
	}

	private static Fluid fluidForBucket(Item item)
	{
		if (item == CommonFluids.MILK_FRIESIAN_BUCKET.get())
			return CommonFluids.MILK_FRIESIAN_SOURCE.get();
		if (item == CommonFluids.MILK_HOLSTEIN_BUCKET.get())
			return CommonFluids.MILK_HOLSTEIN_SOURCE.get();
		if (item == CommonFluids.MILK_JERSEY_BUCKET.get())
			return CommonFluids.MILK_JERSEY_SOURCE.get();
		if (item == CommonFluids.MILK_SHEEP_BUCKET.get())
			return CommonFluids.MILK_SHEEP_SOURCE.get();
		if (item == CommonFluids.MILK_GOAT_BUCKET.get())
			return CommonFluids.MILK_GOAT_SOURCE.get();
		if (item == Items.WATER_BUCKET && !FarmConfig.settings.disableSaltCreation.get())
			return Fluids.WATER;
		return null;
	}

	@Nullable
	private static MoldContent contentForFluid(Fluid fluid)
	{
		if (isFluid(fluid, CommonFluids.MILK_FRIESIAN_SOURCE.get(), CommonFluids.MILK_FRIESIAN_FLOWING.get())) return MoldContent.MILK_FRIESIAN;
		if (isFluid(fluid, CommonFluids.MILK_HOLSTEIN_SOURCE.get(), CommonFluids.MILK_HOLSTEIN_FLOWING.get())) return MoldContent.MILK_HOLSTEIN;
		if (isFluid(fluid, CommonFluids.MILK_JERSEY_SOURCE.get(), CommonFluids.MILK_JERSEY_FLOWING.get())) return MoldContent.MILK_JERSEY;
		if (isFluid(fluid, CommonFluids.MILK_SHEEP_SOURCE.get(), CommonFluids.MILK_SHEEP_FLOWING.get())) return MoldContent.MILK_SHEEP;
		if (isFluid(fluid, CommonFluids.MILK_GOAT_SOURCE.get(), CommonFluids.MILK_GOAT_FLOWING.get())) return MoldContent.MILK_GOAT;
		if (fluid == Fluids.WATER && !FarmConfig.settings.disableSaltCreation.get()) return MoldContent.WATER;
		return null;
	}

	private static boolean isFluid(Fluid value, Fluid source, Fluid flowing)
	{
		return value == source || value == flowing;
	}

	@Nullable
	private static Fluid fluidForContent(MoldContent content)
	{
		return switch (content)
		{
			case MILK_FRIESIAN -> CommonFluids.MILK_FRIESIAN_SOURCE.get();
			case MILK_HOLSTEIN -> CommonFluids.MILK_HOLSTEIN_SOURCE.get();
			case MILK_JERSEY -> CommonFluids.MILK_JERSEY_SOURCE.get();
			case MILK_SHEEP -> CommonFluids.MILK_SHEEP_SOURCE.get();
			case MILK_GOAT -> CommonFluids.MILK_GOAT_SOURCE.get();
			case WATER -> Fluids.WATER;
			default -> null;
		};
	}

	private static ItemStack resultStack(MoldContent content)
	{
		return switch (content)
		{
			case CHEESE_FRIESIAN -> new ItemStack(FarmBlocks.CHEESE_WHEEL_FRIESIAN_ITEM.get());
			case CHEESE_HOLSTEIN -> new ItemStack(FarmBlocks.CHEESE_WHEEL_HOLSTEIN_ITEM.get());
			case CHEESE_JERSEY -> new ItemStack(FarmBlocks.CHEESE_WHEEL_JERSEY_ITEM.get());
			case CHEESE_SHEEP -> new ItemStack(FarmBlocks.CHEESE_WHEEL_SHEEP_ITEM.get());
			case CHEESE_GOAT -> new ItemStack(FarmBlocks.CHEESE_WHEEL_GOAT_ITEM.get());
			case SALT -> new ItemStack(FarmItems.SALT.get(), FarmConfig.settings.saltCreationAmount.get());
			default -> ItemStack.EMPTY;
		};
	}

	private static MoldContent agedResultOf(MoldContent aging)
	{
		return switch (aging)
		{
			case MILK_FRIESIAN -> MoldContent.CHEESE_FRIESIAN;
			case MILK_HOLSTEIN -> MoldContent.CHEESE_HOLSTEIN;
			case MILK_JERSEY -> MoldContent.CHEESE_JERSEY;
			case MILK_SHEEP -> MoldContent.CHEESE_SHEEP;
			case MILK_GOAT -> MoldContent.CHEESE_GOAT;
			case WATER -> MoldContent.SALT;
			default -> MoldContent.EMPTY;
		};
	}

	public static void serverTick(Level level, BlockPos pos, BlockState state, BlockEntityCheeseMold mold)
	{
		if (level.isClientSide || !mold.content.isAging() || mold.fluidTank.getFluidAmount() < CAPACITY_MB)
			return;

		mold.progress++;
		mold.setChanged();

		if (mold.progress >= FarmConfig.settings.cheeseMaturityTime.get())
		{
			MoldContent finished = agedResultOf(mold.content);
			ItemStack result = resultStack(finished);
			mold.fluidTank.drain(CAPACITY_MB, FluidAction.EXECUTE);
			mold.itemHandler.setStackInSlot(0, result);
			mold.content = finished;
			mold.progress = 0;
			mold.setChangedAndSync();
		}
	}

	private static MoldContent contentByName(String name)
	{
		for (MoldContent value : MoldContent.values())
		{
			if (value.getSerializedName().equals(name))
				return value;
		}
		return MoldContent.EMPTY;
	}

	private void setChangedAndSync()
	{
		this.setChanged();
		if (this.level != null && !this.level.isClientSide)
		{
			BlockState current = this.getBlockState();
			if (current.getValue(BlockCheeseMold.CONTENT) != this.content)
				this.level.setBlock(this.worldPosition, current.setValue(BlockCheeseMold.CONTENT, this.content), 3);
			else
				this.level.sendBlockUpdated(this.worldPosition, current, current, 3);
		}
	}

	private void onFluidChanged()
	{
		if (!this.content.isFinished())
		{
			MoldContent fluidContent = this.fluidTank.isEmpty() ? MoldContent.EMPTY : contentForFluid(this.fluidTank.getFluid().getFluid());
			if (fluidContent == null)
				fluidContent = MoldContent.EMPTY;
			if (fluidContent != this.content)
			{
				this.content = fluidContent;
				this.progress = 0;
			}
		}
		this.setChangedAndSync();
	}

	@Override
	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.saveAdditional(tag, registries);
		tag.putString("Content", this.content.getSerializedName());
		tag.putInt("Progress", this.progress);
		tag.put("Fluid", this.fluidTank.writeToNBT(registries, new CompoundTag()));
		tag.put("Items", this.itemHandler.serializeNBT(registries));
	}

	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.loadAdditional(tag, registries);
		this.content = contentByName(tag.getString("Content"));
		this.progress = tag.getInt("Progress");
		if (tag.contains("Items"))
			this.itemHandler.deserializeNBT(registries, tag.getCompound("Items"));
		else if (this.content.isFinished())
			this.itemHandler.setStackInSlot(0, resultStack(this.content));
		if (tag.contains("Fluid"))
			this.fluidTank.readFromNBT(registries, tag.getCompound("Fluid"));
		else
		{
			Fluid legacyFluid = fluidForContent(this.content);
			if (legacyFluid != null)
				this.fluidTank.setFluid(new FluidStack(legacyFluid, CAPACITY_MB));
		}
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
