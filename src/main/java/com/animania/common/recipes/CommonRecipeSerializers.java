package com.animania.common.recipes;

import com.animania.Animania;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

 
public final class CommonRecipeSerializers
{
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
			DeferredRegister.create(Registries.RECIPE_SERIALIZER, Animania.MODID);

	 
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SlopRecipe>> SLOP =
			SERIALIZERS.register("slop", () -> new SimpleCraftingRecipeSerializer<>(SlopRecipe::new));

	 
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CuttingRecipe>> CUTTING =
			SERIALIZERS.register("cutting", () -> new SimpleCraftingRecipeSerializer<>(CuttingRecipe::new));

	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MilkBottleRecipe>> MILK_BOTTLE =
			SERIALIZERS.register("milk_bottle", () -> new SimpleCraftingRecipeSerializer<>(MilkBottleRecipe::new));

	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<HoneyBottleRecipe>> HONEY_BOTTLE =
			SERIALIZERS.register("honey_bottle", () -> new SimpleCraftingRecipeSerializer<>(HoneyBottleRecipe::new));

	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MilkConversionRecipe>> MILK_CONVERSION =
			SERIALIZERS.register("milk_conversion", () -> new SimpleCraftingRecipeSerializer<>(MilkConversionRecipe::new));

	private CommonRecipeSerializers()
	{
	}

	public static void register(IEventBus modEventBus)
	{
		SERIALIZERS.register(modEventBus);
	}
}
