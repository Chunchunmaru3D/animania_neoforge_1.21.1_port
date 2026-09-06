package com.animania.common.recipes;

import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.common.fluids.CommonFluids;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

 




public class SlopRecipe extends CustomRecipe
{
	public SlopRecipe(CraftingBookCategory category)
	{
		super(category);
	}

	@Override
	public boolean matches(CraftingInput input, Level level)
	{
		if (input.ingredientCount() != 3)
			return false;

		int pigFood = 0;
		int milk = 0;
		for (ItemStack stack : input.items())
		{
			if (stack.isEmpty())
				continue;
			if (isPigFood(stack))
				pigFood++;
			else if (isMilkBucket(stack))
				milk++;
			else
				return false;
		}
		return pigFood == 2 && milk == 1;
	}

	@Override
	public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries)
	{
		return new ItemStack(CommonFluids.SLOP_BUCKET.get());
	}

	@Override
	public boolean canCraftInDimensions(int width, int height)
	{
		return width * height >= 3;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInput input)
	{
		 
		return NonNullList.withSize(input.size(), ItemStack.EMPTY);
	}

	@Override
	public RecipeSerializer<?> getSerializer()
	{
		return CommonRecipeSerializers.SLOP.get();
	}

	private static boolean isPigFood(ItemStack stack)
	{
		for (ItemStack food : AnimaniaHelper.getItemStackArray(FarmConfig.settings.pigFood.get()))
		{
			if (food.is(stack.getItem()))
				return true;
		}
		return false;
	}

	private static boolean isMilkBucket(ItemStack stack)
	{
		return stack.is(Items.MILK_BUCKET)
				|| stack.is(FarmItems.SHEEP_MILK_BUCKET.get())
				|| stack.is(FarmItems.GOAT_MILK_BUCKET.get())
				|| stack.is(com.animania.common.fluids.CommonFluids.MILK_FRIESIAN_BUCKET.get())
				|| stack.is(com.animania.common.fluids.CommonFluids.MILK_HOLSTEIN_BUCKET.get())
				|| stack.is(com.animania.common.fluids.CommonFluids.MILK_JERSEY_BUCKET.get());
	}
}
