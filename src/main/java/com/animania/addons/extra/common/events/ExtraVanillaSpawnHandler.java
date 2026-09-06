package com.animania.addons.extra.common.events;

import java.util.List;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit;
import com.animania.addons.extra.config.ExtraConfig;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;

 







@EventBusSubscriber(modid = Animania.MODID)
public class ExtraVanillaSpawnHandler
{
	@SubscribeEvent
	public static void onFinalizeSpawn(FinalizeSpawnEvent event)
	{
		if (event.getSpawnType() != MobSpawnType.NATURAL)
			return;

		Mob entity = event.getEntity();
		ServerLevel level = event.getLevel().getLevel();
		EntityType<?> type = entity.getType();

		if (type == EntityType.RABBIT && !entity.hasCustomName() && !(entity instanceof EntityAnimaniaRabbit)
				&& ExtraConfig.settings.replaceVanillaRabbits.get())
		{
			event.setSpawnCancelled(true);
			return;
		}

		if (entity instanceof EntityAnimaniaRabbit)
		{
			BlockPos pos = BlockPos.containing(event.getX(), event.getY(), event.getZ());
			List<EntityAnimaniaRabbit> others = AnimaniaHelper.getEntitiesInRange(EntityAnimaniaRabbit.class, 32.0D, level, pos);
			if (others.size() > ExtraConfig.settings.spawnLimitRabbits.get())
				event.setSpawnCancelled(true);
		}
	}
}
