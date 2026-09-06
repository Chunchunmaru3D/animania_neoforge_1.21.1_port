package com.animania.common.item;

import java.util.List;

import com.animania.Animania;
import com.animania.addons.farm.FarmSounds;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;
import com.animania.api.interfaces.IFoodEating;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

 




public class ItemRandomAnimalEgg extends Item
{
	private final AnimaniaType[] types;
	private final String descriptionId;

	public ItemRandomAnimalEgg(AnimaniaType[] types, String descriptionId, Properties properties)
	{
		super(properties.stacksTo(64));
		this.types = types.clone();
		this.descriptionId = descriptionId;
	}

	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		Level level = context.getLevel();
		if (level.isClientSide)
			return InteractionResult.SUCCESS;

		if (this.types.length == 0)
			return InteractionResult.FAIL;

		Direction face = context.getClickedFace() != null ? context.getClickedFace() : Direction.UP;
		BlockPos pos = context.getClickedPos().relative(face);
		AnimaniaType type = this.types[Animania.RANDOM.nextInt(this.types.length)];
		LivingEntity entity = EntityGender.getEntity(type, EntityGender.RANDOM, level);
		if (entity == null)
			return InteractionResult.FAIL;

		entity.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D,
				Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);
		entity.yBodyRot = entity.getYRot();
		entity.setYHeadRot(entity.getYRot());

		ItemStack stack = context.getItemInHand();
		if (stack.has(DataComponents.CUSTOM_NAME))
			entity.setCustomName(stack.getHoverName());

		if (entity instanceof IFoodEating foodEating)
			foodEating.setInteracted(true);

		Player player = context.getPlayer();
		if (player != null && !player.getAbilities().instabuild)
			stack.shrink(1);

		double soundX = player != null ? player.getX() : entity.getX();
		double soundY = player != null ? player.getY() : entity.getY();
		double soundZ = player != null ? player.getZ() : entity.getZ();
		level.playSound(null, soundX, soundY, soundZ, FarmSounds.COMBO.get(), SoundSource.PLAYERS, 0.8F,
				((Animania.RANDOM.nextFloat() - Animania.RANDOM.nextFloat()) * 0.2F + 1.0F) / 0.8F);
		level.addFreshEntity(entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public String getDescriptionId(ItemStack stack)
	{
		return this.descriptionId;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add(Component.translatable("tooltip.animania.random_egg_spawn").withStyle(ChatFormatting.GOLD)
				.append(Component.literal(" ").append(Component.translatable("tooltip.animania.random_egg_use").withStyle(ChatFormatting.DARK_GRAY))));
	}
}
