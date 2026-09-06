package com.animania.common.recipes;

import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.FarmItems;
import com.animania.common.blocks.CommonBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

 
public class CuttingRecipe extends CustomRecipe
{
	public CuttingRecipe(CraftingBookCategory category)
	{
		super(category);
	}

	@Override
	public boolean matches(CraftingInput input, Level level)
	{
		if (input.ingredientCount() != 2)
			return false;

		boolean knife = false;
		boolean cuttable = false;
		for (ItemStack stack : input.items())
		{
			if (stack.isEmpty())
				continue;
			if (stack.is(FarmItems.CARVING_KNIFE.get()) && stack.getDamageValue() < stack.getMaxDamage())
				knife = true;
			else if (!cuttable && !resultFor(stack).isEmpty())
				cuttable = true;
			else
				return false;
		}
		return knife && cuttable;
	}

	@Override
	public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries)
	{
		for (ItemStack stack : input.items())
		{
			ItemStack result = resultFor(stack);
			if (!result.isEmpty())
				return result;
		}
		return ItemStack.EMPTY;
	}

	@Override public boolean canCraftInDimensions(int width, int height) { return width * height >= 2; }

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInput input)
	{
		NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);
		for (int i = 0; i < input.size(); i++)
		{
			ItemStack stack = input.getItem(i);
			if (stack.is(FarmItems.CARVING_KNIFE.get()))
			{
				ItemStack knife = stack.copy();
				knife.setDamageValue(knife.getDamageValue() + 1);
				if (knife.getDamageValue() < knife.getMaxDamage())
					remaining.set(i, knife);
			}
		}
		return remaining;
	}

	@Override public RecipeSerializer<?> getSerializer() { return CommonRecipeSerializers.CUTTING.get(); }

	private static ItemStack resultFor(ItemStack input)
	{
		if (input.is(FarmItems.RAW_PRIME_BEEF.get())) return new ItemStack(FarmItems.RAW_PRIME_STEAK.get(), 4);
		if (input.is(FarmItems.RAW_PRIME_PORK.get())) return new ItemStack(FarmItems.RAW_PRIME_BACON.get(), 4);
		if (input.is(FarmBlocks.CHEESE_WHEEL_FRIESIAN_ITEM.get())) return new ItemStack(FarmItems.FRIESIAN_CHEESE_WEDGE.get(), 4);
		if (input.is(FarmBlocks.CHEESE_WHEEL_HOLSTEIN_ITEM.get())) return new ItemStack(FarmItems.HOLSTEIN_CHEESE_WEDGE.get(), 4);
		if (input.is(FarmBlocks.CHEESE_WHEEL_JERSEY_ITEM.get())) return new ItemStack(FarmItems.JERSEY_CHEESE_WEDGE.get(), 4);
		if (input.is(FarmBlocks.CHEESE_WHEEL_SHEEP_ITEM.get())) return new ItemStack(FarmItems.SHEEP_CHEESE_WEDGE.get(), 4);
		if (input.is(FarmBlocks.CHEESE_WHEEL_GOAT_ITEM.get())) return new ItemStack(FarmItems.GOAT_CHEESE_WEDGE.get(), 4);
		if (input.is(Items.WHEAT)) return new ItemStack(CommonBlocks.BLOCK_STRAW_ITEM.get());
		return ItemStack.EMPTY;
	}
}
