package com.animania.common.helper;

import java.util.List;
import java.util.Set;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

 








public final class AnimaniaHelper
{
	public static <T extends Entity> List<T> getEntitiesInRange(Class<T> filterEntity, double range, Level level, Entity center)
	{
		return level.getEntitiesOfClass(filterEntity, center.getBoundingBox().inflate(range));
	}

	public static <T extends Entity> List<T> getEntitiesInRange(Class<T> filterEntity, double range, Level level, BlockPos pos)
	{
		return level.getEntitiesOfClass(filterEntity, new AABB(pos).inflate(range));
	}

	public static void spawnEntity(Level level, Entity entity)
	{
		if (!level.isClientSide)
			level.addFreshEntity(entity);
	}

	public static ItemStack[] getItemStackArray(List<? extends String> ids)
	{
		return ids.stream()
				.map(id -> BuiltInRegistries.ITEM.getOptional(ResourceLocation.parse(id)))
				.filter(java.util.Optional::isPresent)
				.map(opt -> new ItemStack(opt.get()))
				.toArray(ItemStack[]::new);
	}

	public static Block getBlock(String id)
	{
		return BuiltInRegistries.BLOCK.getOptional(ResourceLocation.parse(id)).orElse(Blocks.AIR);
	}

	public static boolean containsItemStack(Set<ItemStack> set, ItemStack stack)
	{
		for (ItemStack s : set)
			if (!s.isEmpty() && s.is(stack.getItem()))
				return true;
		return false;
	}

	 


	public static boolean isWaterContainer(ItemStack stack)
	{
		if (stack.is(Items.WATER_BUCKET))
			return true;

		if (stack.is(Items.POTION))
		{
			PotionContents contents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
			return contents.is(Potions.WATER);
		}

		return false;
	}

	 


	public static ItemStack emptyContainer(ItemStack stack)
	{
		if (stack.is(Items.WATER_BUCKET))
			return new ItemStack(Items.BUCKET);
		if (stack.is(Items.POTION))
			return new ItemStack(Items.GLASS_BOTTLE);
		return ItemStack.EMPTY;
	}

	public static void addItem(Player player, ItemStack stack)
	{
		if (!player.getInventory().add(stack))
			player.drop(stack, false);
	}

	private AnimaniaHelper()
	{
	}
}
