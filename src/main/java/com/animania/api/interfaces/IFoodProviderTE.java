package com.animania.api.interfaces;

import java.util.Set;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

 








public interface IFoodProviderTE
{
	boolean canConsume(Set<ItemStack> foodItems, Fluid[] fluids);

	boolean canConsume(FluidStack fluid, Set<ItemStack> foodItems);

	void consumeSolidOrLiquid(int liquidAmount, int itemAmount);

	void consumeSolid(int amount);

	void consumeLiquid(int amount);
}
