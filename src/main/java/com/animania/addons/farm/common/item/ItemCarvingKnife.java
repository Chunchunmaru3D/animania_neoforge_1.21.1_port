package com.animania.addons.farm.common.item;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

 
public class ItemCarvingKnife extends SwordItem
{
	private static final Tier CARVING_KNIFE_TIER = new Tier()
	{
		@Override public int getUses() { return 100; }
		@Override public float getSpeed() { return Tiers.IRON.getSpeed(); }
		@Override public float getAttackDamageBonus() { return Tiers.IRON.getAttackDamageBonus(); }
		@Override public TagKey<Block> getIncorrectBlocksForDrops() { return Tiers.IRON.getIncorrectBlocksForDrops(); }
		@Override public int getEnchantmentValue() { return Tiers.IRON.getEnchantmentValue(); }
		@Override public Ingredient getRepairIngredient() { return Tiers.IRON.getRepairIngredient(); }
	};

	public ItemCarvingKnife(Properties properties)
	{
		super(CARVING_KNIFE_TIER, properties);
	}

	@Override public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) { return false; }
	@Override public boolean isRepairable(ItemStack stack) { return false; }

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add(Component.translatable("item.animania.carving_knife.desc").withStyle(net.minecraft.ChatFormatting.GOLD));
	}
}
