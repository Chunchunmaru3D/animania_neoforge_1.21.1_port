package com.animania.addons.farm.common.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

 



public class ItemMilkBottle extends Item
{
	public ItemMilkBottle(Properties properties)
	{
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity)
	{
		ItemStack result = super.finishUsingItem(stack, level, entity);
		if (!level.isClientSide && entity instanceof Player player)
		{
			player.removeAllEffects();
			if (!player.getAbilities().instabuild)
				player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
		}
		return result;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack)
	{
		return UseAnim.DRINK;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add(Component.translatable("tooltip.animania.remove_all_effects").withStyle(ChatFormatting.GREEN));
	}
}
