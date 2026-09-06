package com.animania.common.recipes;

import com.animania.addons.farm.FarmItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

 
public class MilkBottleRecipe extends CustomRecipe
{
	public MilkBottleRecipe(CraftingBookCategory category)
	{
		super(category);
	}

	@Override
	public boolean matches(CraftingInput input, Level level)
	{
		if (input.ingredientCount() != 5)
			return false;
		int milk = 0;
		int bottles = 0;
		for (ItemStack stack : input.items())
		{
			if (stack.isEmpty()) continue;
			if (isMilk(stack)) milk++;
			else if (stack.is(Items.GLASS_BOTTLE)) bottles++;
			else return false;
		}
		return milk == 1 && bottles == 4;
	}

	@Override public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) { return new ItemStack(FarmItems.MILK_BOTTLE.get(), 4); }
	@Override public boolean canCraftInDimensions(int width, int height) { return width * height >= 5; }

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInput input)
	{
		NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);
		for (int i = 0; i < input.size(); i++)
			if (isMilk(input.getItem(i)))
				remaining.set(i, new ItemStack(Items.BUCKET));
		return remaining;
	}

	@Override public RecipeSerializer<?> getSerializer() { return CommonRecipeSerializers.MILK_BOTTLE.get(); }

	static boolean isMilk(ItemStack stack)
	{
		return stack.is(Items.MILK_BUCKET) || stack.is(FarmItems.SHEEP_MILK_BUCKET.get()) || stack.is(FarmItems.GOAT_MILK_BUCKET.get())
				|| stack.is(com.animania.common.fluids.CommonFluids.MILK_FRIESIAN_BUCKET.get())
				|| stack.is(com.animania.common.fluids.CommonFluids.MILK_HOLSTEIN_BUCKET.get())
				|| stack.is(com.animania.common.fluids.CommonFluids.MILK_JERSEY_BUCKET.get());
	}
}
