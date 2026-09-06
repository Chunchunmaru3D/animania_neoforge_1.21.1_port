package com.animania.addons.farm.common.item;

import com.animania.Animania;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.addons.farm.FarmSounds;
import com.animania.addons.farm.common.entity.pullables.EntityCart;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

 



public class ItemCart extends Item
{
	public ItemCart(Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos().relative(context.getClickedFace() != null ? context.getClickedFace() : Direction.UP);
		Player player = context.getPlayer();

		if (level.isClientSide)
			return InteractionResult.SUCCESS;

		EntityCart entity = FarmEntityTypes.CART.get().create(level);
		if (entity == null)
			return InteractionResult.FAIL;

		entity.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5,
				Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);

		var stack = context.getItemInHand();
		if (stack.has(net.minecraft.core.component.DataComponents.CUSTOM_NAME))
			entity.setCustomName(stack.getHoverName());

		if (player != null && !player.getAbilities().instabuild)
			stack.shrink(1);

		double soundX = player != null ? player.getX() : pos.getX() + 0.5D;
		double soundY = player != null ? player.getY() : pos.getY();
		double soundZ = player != null ? player.getZ() : pos.getZ() + 0.5D;
		level.playSound(null, soundX, soundY, soundZ, FarmSounds.COMBO.get(), SoundSource.PLAYERS, 0.8F,
				((Animania.RANDOM.nextFloat() - Animania.RANDOM.nextFloat()) * 0.2F + 1.0F) / 0.8F);
		level.addFreshEntity(entity);
		return InteractionResult.SUCCESS;
	}
}
