package com.animania.compat.jade;

import com.animania.addons.farm.common.blockentity.BlockEntityHive;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum HiveStatusProvider implements IBlockComponentProvider
{
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config)
	{
		if (!(accessor.getBlockEntity() instanceof BlockEntityHive hive))
			return;

		tooltip.add(Component.translatable("jade.animania.hive_honey", hive.getHoneyAmount(), BlockEntityHive.CAPACITY_MB));
	}

	@Override
	public ResourceLocation getUid()
	{
		return AnimaniaJadePlugin.HIVE_STATUS_UID;
	}
}
