package com.animania.compat.jade;

import com.animania.common.blockentity.BlockEntityNest;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum NestStatusProvider implements IBlockComponentProvider
{
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config)
	{
		if (!(accessor.getBlockEntity() instanceof BlockEntityNest nest))
			return;

		ItemStack stack = nest.getItemHandler().getStackInSlot(0);
		if (stack.isEmpty())
			tooltip.add(Component.translatable("jade.animania.nest_empty").withStyle(ChatFormatting.GRAY));
		else
			tooltip.add(Component.translatable("jade.animania.nest_egg", stack.getCount(), stack.getHoverName()));
	}

	@Override
	public ResourceLocation getUid()
	{
		return AnimaniaJadePlugin.NEST_STATUS_UID;
	}
}
