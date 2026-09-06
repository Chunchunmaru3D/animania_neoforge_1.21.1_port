package com.animania.addons.farm.common.item.handler;

import com.animania.common.fluids.CommonFluids;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

 






public final class HoneyJarFluidHandler implements IFluidHandlerItem
{
	public static final int CAPACITY_MB = 1000;
	private static final String HONEY_AMOUNT_KEY = "HoneyAmount";

	private ItemStack container;
	private final Item honeyJarItem;

	public HoneyJarFluidHandler(ItemStack container)
	{
		this.container = container;
		this.honeyJarItem = container.getItem();
	}

	@Override
	public ItemStack getContainer()
	{
		return this.container;
	}

	@Override
	public int getTanks()
	{
		return 1;
	}

	@Override
	public FluidStack getFluidInTank(int tank)
	{
		if (tank != 0 || this.container.getCount() != 1)
			return FluidStack.EMPTY;

		int amount = this.getAmount();
		return amount == 0 ? FluidStack.EMPTY : new FluidStack(CommonFluids.HONEY_SOURCE.get(), amount);
	}

	@Override
	public int getTankCapacity(int tank)
	{
		return tank == 0 ? CAPACITY_MB : 0;
	}

	@Override
	public boolean isFluidValid(int tank, FluidStack stack)
	{
		return tank == 0 && isHoney(stack);
	}

	@Override
	public int fill(FluidStack resource, IFluidHandler.FluidAction action)
	{
		if (!this.container.is(this.honeyJarItem) || this.container.getCount() != 1 || !isHoney(resource))
			return 0;

		int filled = Math.min(CAPACITY_MB - this.getAmount(), resource.getAmount());
		if (filled > 0 && action.execute())
			this.setAmount(this.getAmount() + filled);
		return filled;
	}

	@Override
	public FluidStack drain(FluidStack resource, IFluidHandler.FluidAction action)
	{
		if (!isHoney(resource))
			return FluidStack.EMPTY;
		return this.drain(resource.getAmount(), action);
	}

	@Override
	public FluidStack drain(int maxDrain, IFluidHandler.FluidAction action)
	{
		if (!this.container.is(this.honeyJarItem) || this.container.getCount() != 1 || maxDrain <= 0)
			return FluidStack.EMPTY;

		int drained = Math.min(this.getAmount(), maxDrain);
		if (drained == 0)
			return FluidStack.EMPTY;

		if (action.execute())
		{
			int remaining = this.getAmount() - drained;
			if (remaining == 0)
				this.container = new ItemStack(Items.GLASS_BOTTLE);
			else
				this.setAmount(remaining);
		}

		return new FluidStack(CommonFluids.HONEY_SOURCE.get(), drained);
	}

	private int getAmount()
	{
		if (!this.container.is(this.honeyJarItem))
			return 0;
		CustomData data = this.container.get(DataComponents.CUSTOM_DATA);
		if (data == null || !data.contains(HONEY_AMOUNT_KEY))
			return CAPACITY_MB;
		return Math.clamp(data.copyTag().getInt(HONEY_AMOUNT_KEY), 0, CAPACITY_MB);
	}

	private void setAmount(int amount)
	{
		CustomData current = this.container.get(DataComponents.CUSTOM_DATA);
		CompoundTag data = current == null ? new CompoundTag() : current.copyTag();
		data.putInt(HONEY_AMOUNT_KEY, Math.clamp(amount, 0, CAPACITY_MB));
		this.container.set(DataComponents.CUSTOM_DATA, CustomData.of(data));
	}

	private static boolean isHoney(FluidStack stack)
	{
		return !stack.isEmpty() && (stack.is(CommonFluids.HONEY_SOURCE.get()) || stack.is(CommonFluids.HONEY_FLOWING.get()));
	}
}
