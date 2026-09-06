package com.animania.addons.farm.common.item;

import com.animania.addons.farm.FarmEntityTypes;
import com.animania.addons.farm.common.entity.pullables.EntityWagon;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

 


public class ItemWagon extends Item
{
	public ItemWagon(Properties properties)
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

		EntityWagon entity = FarmEntityTypes.WAGON.get().create(level);
		if (entity == null)
			return InteractionResult.FAIL;

		entity.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5,
				Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);

		var stack = context.getItemInHand();
		if (stack.has(net.minecraft.core.component.DataComponents.CUSTOM_NAME))
			entity.setCustomName(stack.getHoverName());

		if (player != null && !player.getAbilities().instabuild)
			stack.shrink(1);

		level.addFreshEntity(entity);
		return InteractionResult.SUCCESS;
	}
}
