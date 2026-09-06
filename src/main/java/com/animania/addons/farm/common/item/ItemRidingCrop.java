package com.animania.addons.farm.common.item;

import java.util.List;

import com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

 
public class ItemRidingCrop extends Item
{
	public ItemRidingCrop(Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);
		if (player.getVehicle() instanceof EntityAnimaniaHorse horse
				&& stack.getDamageValue() < stack.getMaxDamage() && horse.boost())
		{
			if (!level.isClientSide && !player.getAbilities().instabuild)
				stack.hurtAndBreak(1, (ServerLevel) level, player, item -> { });
			return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
		}
		return InteractionResultHolder.pass(stack);
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add(Component.translatable("tooltip.animania.riding_crop_1").withStyle(ChatFormatting.GREEN));
		tooltip.add(Component.translatable("tooltip.animania.riding_crop_2").withStyle(ChatFormatting.GREEN));
	}
}
