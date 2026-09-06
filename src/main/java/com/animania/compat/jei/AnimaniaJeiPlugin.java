package com.animania.compat.jei;

import com.animania.Animania;
import com.animania.addons.farm.FarmBlocks;
import com.animania.common.blocks.CommonBlocks;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

 



















@JeiPlugin
public class AnimaniaJeiPlugin implements IModPlugin
{
	private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "jei_plugin");

	@Override
	public ResourceLocation getPluginUid()
	{
		return UID;
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration)
	{
		registration.addIngredientInfo(new ItemStack(FarmBlocks.CHEESE_MOLD.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.animania.cheese_mold.info"));

		registration.addIngredientInfo(new ItemStack(CommonBlocks.BLOCK_TROUGH.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.animania.trough.info"));

		registration.addIngredientInfo(new ItemStack(CommonBlocks.BLOCK_NEST.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.animania.nest.info"));

		registration.addIngredientInfo(new ItemStack(FarmBlocks.HIVE.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.animania.hive.info"));
	}
}
