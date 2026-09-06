package com.animania.compat.jade;

import com.animania.api.interfaces.IAnimaniaAnimalBase;
import com.animania.api.interfaces.IGendered;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

 








public enum AnimalStatusProvider implements IEntityComponentProvider
{
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip tooltip, EntityAccessor accessor, IPluginConfig config)
	{
		Entity entity = accessor.getEntity();
		if (!(entity instanceof IAnimaniaAnimalBase animal))
			return;

		boolean fed = animal.getFed();
		boolean watered = animal.getWatered();

		tooltip.add(Component.translatable("jade.animania.fed",
				Component.translatable(fed ? "jade.animania.yes" : "jade.animania.no")
						.withStyle(fed ? ChatFormatting.GREEN : ChatFormatting.RED)));
		tooltip.add(Component.translatable("jade.animania.watered",
				Component.translatable(watered ? "jade.animania.yes" : "jade.animania.no")
						.withStyle(watered ? ChatFormatting.GREEN : ChatFormatting.RED)));

		if (entity instanceof IGendered gendered)
			tooltip.add(Component.translatable("jade.animania.gender", gendered.getEntityGender().toString()));

		if (animal.getSleeping())
			tooltip.add(Component.translatable("jade.animania.sleeping").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public ResourceLocation getUid()
	{
		return AnimaniaJadePlugin.ANIMAL_STATUS_UID;
	}
}
