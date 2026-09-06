package com.animania.addons.extra.common.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.DyeColor;

 



public class ItemHamsterBall extends Item
{
	public static final int CLEAR_COLOR = 16;
	private static final String COLOR_KEY = "BallColor";
	private static final int[] COLORS = {
			0x1A1A1A, 0xFF0000, 0x667D33, 0x997D33, 0x3380FF, 0x8040B3, 0x478099, 0x999999,
			0x4D4D4D, 0xF280A6, 0x80CC03, 0xFFFF00, 0x6699D8, 0xB34DD9, 0xD98033, 0xFFFFFF
	};
	private final boolean coloured;

	public ItemHamsterBall(boolean coloured, Properties properties)
	{
		super(properties.stacksTo(1));
		this.coloured = coloured;
	}

	public static ItemStack colouredStack(Item item, int color)
	{
		ItemStack stack = new ItemStack(item);
		setColor(stack, color);
		return stack;
	}

	public static void setColor(ItemStack stack, int color)
	{
		CompoundTag tag = new CompoundTag();
		tag.putInt(COLOR_KEY, Math.floorMod(color, DyeColor.values().length));
		stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
	}

	public int getColor(ItemStack stack)
	{
		if (!this.coloured)
			return CLEAR_COLOR;

		CustomData data = stack.get(DataComponents.CUSTOM_DATA);
		return data != null && data.contains(COLOR_KEY)
				? Math.floorMod(data.copyTag().getInt(COLOR_KEY), DyeColor.values().length)
				: DyeColor.BLACK.getId();
	}

	public static int getTint(int color)
	{
		return color == CLEAR_COLOR ? 0xFFFFFF : COLORS[Math.floorMod(color, COLORS.length)];
	}

	@Override
	public String getDescriptionId(ItemStack stack)
	{
		if (!this.coloured)
			return "item.animania.hamster_ball_clear";
		return "item.animania.hamster_ball_" + DyeColor.byId(this.getColor(stack)).getName();
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add(Component.translatable("tooltip.animania.hamster_ball_1").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD));
		tooltip.add(Component.translatable("tooltip.animania.hamster_ball_2").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD));
	}
}
