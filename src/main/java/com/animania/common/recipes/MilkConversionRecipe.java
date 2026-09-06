package com.animania.common.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

 
public class MilkConversionRecipe extends CustomRecipe
{
	public MilkConversionRecipe(CraftingBookCategory category)
	{
		super(category);
	}

	@Override
	public boolean matches(CraftingInput input, Level level)
	{
		return input.ingredientCount() == 1 && input.items().stream().anyMatch(stack ->
				stack.is(com.animania.addons.farm.FarmItems.SHEEP_MILK_BUCKET.get())
						|| stack.is(com.animania.addons.farm.FarmItems.GOAT_MILK_BUCKET.get())
						|| stack.is(com.animania.common.fluids.CommonFluids.MILK_FRIESIAN_BUCKET.get())
						|| stack.is(com.animania.common.fluids.CommonFluids.MILK_HOLSTEIN_BUCKET.get())
						|| stack.is(com.animania.common.fluids.CommonFluids.MILK_JERSEY_BUCKET.get()));
	}

	@Override public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) { return new ItemStack(Items.MILK_BUCKET); }
	@Override public boolean canCraftInDimensions(int width, int height) { return width * height >= 1; }
	@Override public NonNullList<ItemStack> getRemainingItems(CraftingInput input) { return NonNullList.withSize(input.size(), ItemStack.EMPTY); }
	@Override public RecipeSerializer<?> getSerializer() { return CommonRecipeSerializers.MILK_CONVERSION.get(); }
}
