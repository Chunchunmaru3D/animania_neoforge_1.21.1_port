package com.animania.compat.jade;

import com.animania.common.blockentity.BlockEntityTrough;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

 






public enum TroughStatusProvider implements IBlockComponentProvider
{
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config)
	{
		if (!(accessor.getBlockEntity() instanceof BlockEntityTrough trough))
			return;

		if (trough.isEmpty())
		{
			tooltip.add(Component.translatable("jade.animania.trough_empty").withStyle(ChatFormatting.GRAY));
			return;
		}

		for (int i = 0; i < trough.getItemHandler().getSlots(); i++)
		{
			ItemStack stack = trough.getItemHandler().getStackInSlot(i);
			if (!stack.isEmpty())
				tooltip.add(Component.translatable("jade.animania.trough_food", stack.getCount(), stack.getHoverName()));
		}

		FluidStack fluidStack = trough.getFluidTank().getFluid();
		if (!fluidStack.isEmpty())
			tooltip.add(Component.translatable("jade.animania.trough_water", fluidStack.getAmount()));
	}

	@Override
	public ResourceLocation getUid()
	{
		return AnimaniaJadePlugin.TROUGH_STATUS_UID;
	}
}
