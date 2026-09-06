package com.animania.addons.catsdogs.common.event;

import java.util.List;

import com.animania.Animania;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import com.animania.addons.catsdogs.common.entity.felids.EntityAnimaniaCat;
import com.animania.addons.catsdogs.config.CatsDogsConfig;
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
public class CatsDogsVanillaSpawnHandler
{
	@SubscribeEvent
	public static void onFinalizeSpawn(FinalizeSpawnEvent event)
	{
		if (event.getSpawnType() != MobSpawnType.NATURAL)
			return;

		Mob entity = event.getEntity();
		ServerLevel level = event.getLevel().getLevel();
		EntityType<?> type = entity.getType();

		if (entity.hasCustomName())
			return;

		if (type == EntityType.WOLF && !(entity instanceof EntityAnimaniaDog) && CatsDogsConfig.settings.replaceVanillaWolves.get())
		{
			event.setSpawnCancelled(true);
			return;
		}
		if (type == EntityType.OCELOT && !(entity instanceof EntityAnimaniaCat) && CatsDogsConfig.settings.replaceVanillaOcelots.get())
		{
			event.setSpawnCancelled(true);
			return;
		}

		BlockPos pos = BlockPos.containing(event.getX(), event.getY(), event.getZ());
		if (entity instanceof EntityAnimaniaDog)
		{
			List<EntityAnimaniaDog> others = AnimaniaHelper.getEntitiesInRange(EntityAnimaniaDog.class, 32.0D, level, pos);
			if (others.size() > CatsDogsConfig.settings.spawnLimitDogs.get())
				event.setSpawnCancelled(true);
		}
		else if (entity instanceof EntityAnimaniaCat)
		{
			List<EntityAnimaniaCat> others = AnimaniaHelper.getEntitiesInRange(EntityAnimaniaCat.class, 32.0D, level, pos);
			if (others.size() > CatsDogsConfig.settings.spawnLimitCats.get())
				event.setSpawnCancelled(true);
		}
	}
}
