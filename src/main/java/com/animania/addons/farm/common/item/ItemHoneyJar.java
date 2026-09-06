package com.animania.addons.farm.common.item;

import java.util.List;

import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

 



public class ItemHoneyJar extends Item
{
	public ItemHoneyJar(Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);
		if (!player.canEat(AnimaniaConfig.gameRules.eatFoodAnytime.get()))
			return InteractionResultHolder.fail(stack);

		player.startUsingItem(hand);
		return InteractionResultHolder.consume(stack);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity)
	{
		ItemStack result = super.finishUsingItem(stack, level, entity);
		if (!level.isClientSide && entity instanceof Player player)
		{
			if (AnimaniaConfig.gameRules.foodsGiveBonusEffects.get())
				player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
						net.minecraft.world.effect.MobEffects.REGENERATION, 100, 1, false, false));
			if (!player.getAbilities().instabuild)
				AnimaniaHelper.addItem(player, new ItemStack(Items.GLASS_BOTTLE));
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
		if (AnimaniaConfig.gameRules.foodsGiveBonusEffects.get())
			tooltip.add(Component.translatable("tooltip.animania.regeneration_ii_5_seconds").withStyle(ChatFormatting.GREEN));
		if (AnimaniaConfig.gameRules.eatFoodAnytime.get())
			tooltip.add(Component.translatable("tooltip.animania.edible_anytime").withStyle(ChatFormatting.GOLD));
	}
}
