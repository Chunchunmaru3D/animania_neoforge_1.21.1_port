package com.animania.common.recipes;

import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.common.item.handler.HoneyJarFluidHandler;
import com.animania.common.fluids.CommonFluids;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

 



public class HoneyBottleRecipe extends CustomRecipe
{
	public HoneyBottleRecipe(CraftingBookCategory category)
	{
		super(category);
	}

	@Override
	public boolean matches(CraftingInput input, Level level)
	{
		if (input.ingredientCount() != 2)
			return false;

		int bottles = 0;
		int honeyContainers = 0;
		for (ItemStack stack : input.items())
		{
			if (stack.isEmpty())
				continue;
			if (stack.is(Items.GLASS_BOTTLE))
				bottles++;
			else if (containsHoney(stack))
				honeyContainers++;
			else
				return false;
		}
		return bottles == 1 && honeyContainers == 1;
	}

	@Override
	public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries)
	{
		return FarmItems.honeyJarStack();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height)
	{
		return width * height >= 2;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInput input)
	{
		NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);
		for (int i = 0; i < input.size(); i++)
		{
			int slot = i;
			ItemStack stack = input.getItem(i);
			if (!containsHoney(stack))
				continue;
			if (stack.is(CommonFluids.HONEY_BUCKET.get()))
			{
				remaining.set(i, new ItemStack(Items.BUCKET));
				continue;
			}

			FluidUtil.getFluidHandler(stack.copyWithCount(1)).ifPresent(handler -> {
				handler.drain(HoneyJarFluidHandler.CAPACITY_MB, IFluidHandler.FluidAction.EXECUTE);
				remaining.set(slot, handler.getContainer());
			});
		}
		return remaining;
	}

	@Override
	public RecipeSerializer<?> getSerializer()
	{
		return CommonRecipeSerializers.HONEY_BOTTLE.get();
	}

	private static boolean containsHoney(ItemStack stack)
	{
		if (stack.is(CommonFluids.HONEY_BUCKET.get()))
			return true;
		return FluidUtil.getFluidHandler(stack.copyWithCount(1))
				.map(handler -> handler.drain(HoneyJarFluidHandler.CAPACITY_MB, IFluidHandler.FluidAction.SIMULATE))
				.filter(HoneyBottleRecipe::isHoneyAmount)
				.isPresent();
	}

	private static boolean isHoneyAmount(FluidStack stack)
	{
		return stack.getAmount() == HoneyJarFluidHandler.CAPACITY_MB
				&& (stack.is(CommonFluids.HONEY_SOURCE.get()) || stack.is(CommonFluids.HONEY_FLOWING.get()));
	}
}
