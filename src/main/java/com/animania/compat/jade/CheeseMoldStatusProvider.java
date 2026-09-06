package com.animania.compat.jade;

import com.animania.addons.farm.common.blockentity.BlockEntityCheeseMold;
import com.animania.addons.farm.config.FarmConfig;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CheeseMoldStatusProvider implements IBlockComponentProvider
{
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config)
	{
		if (!(accessor.getBlockEntity() instanceof BlockEntityCheeseMold mold))
			return;

		BlockEntityCheeseMold.MoldContent content = mold.getContent();

		if (content.isFinished())
			tooltip.add(Component.translatable("jade.animania.mold_ready", content.getSerializedName()).withStyle(ChatFormatting.GREEN));
		else if (content.isAging())
		{
			int percent = (int) (((float) mold.getProgress() / (float) FarmConfig.settings.cheeseMaturityTime.get()) * 100);
			tooltip.add(Component.translatable("jade.animania.mold_aging", content.getSerializedName(), percent));
		}
		else
			tooltip.add(Component.translatable("jade.animania.mold_empty").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public ResourceLocation getUid()
	{
		return AnimaniaJadePlugin.CHEESE_MOLD_STATUS_UID;
	}
}
