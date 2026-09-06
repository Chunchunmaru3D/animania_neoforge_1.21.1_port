package com.animania.addons.farm.common.event;

import com.animania.Animania;
import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.config.FarmConfig;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

 










@EventBusSubscriber(modid = Animania.MODID)
public class EggThrowHandler
{
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event)
	{
		Player player = event.getEntity();
		ItemStack stack = player.getItemInHand(event.getHand());

		if (stack.isEmpty())
			return;

		boolean isEgg = stack.is(Items.EGG) || stack.is(FarmItems.BROWN_EGG.get());
		if (isEgg && !FarmConfig.settings.allowEggThrowing.get())
			event.setCanceled(true);
	}
}
