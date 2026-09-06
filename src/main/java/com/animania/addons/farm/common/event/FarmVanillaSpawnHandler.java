package com.animania.addons.farm.common.event;

import java.util.List;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.chickens.EntityAnimaniaChicken;
import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.animania.addons.farm.common.entity.goats.EntityAnimaniaGoat;
import com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse;
import com.animania.addons.farm.common.entity.pigs.EntityAnimaniaPig;
import com.animania.addons.farm.common.entity.sheep.EntityAnimaniaSheep;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;

 
















@EventBusSubscriber(modid = Animania.MODID)
public class FarmVanillaSpawnHandler
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
		{
			 
		}
		else if ((type == EntityType.COW || entity instanceof MushroomCow) && !(entity instanceof EntityAnimaniaCow)
				&& FarmConfig.settings.replaceVanillaCows.get())
		{
			event.setSpawnCancelled(true);
			return;
		}
		else if (type == EntityType.PIG && !(entity instanceof EntityAnimaniaPig) && FarmConfig.settings.replaceVanillaPigs.get())
		{
			event.setSpawnCancelled(true);
			return;
		}
		else if (type == EntityType.CHICKEN && !(entity instanceof EntityAnimaniaChicken) && FarmConfig.settings.replaceVanillaChickens.get())
		{
			event.setSpawnCancelled(true);
			return;
		}
		else if (type == EntityType.SHEEP && !(entity instanceof EntityAnimaniaSheep) && !(entity instanceof EntityAnimaniaGoat)
				&& FarmConfig.settings.replaceVanillaSheep.get())
		{
			 
			 
			event.setSpawnCancelled(true);
			return;
		}
		else if (type == EntityType.HORSE && !(entity instanceof EntityAnimaniaHorse) && FarmConfig.settings.replaceVanillaHorses.get())
		{
			event.setSpawnCancelled(true);
			return;
		}

		 
		BlockPos pos = BlockPos.containing(event.getX(), event.getY(), event.getZ());
		if (entity instanceof EntityAnimaniaCow && checkDensity(EntityAnimaniaCow.class, level, pos, FarmConfig.settings.spawnLimitCows.get()))
			event.setSpawnCancelled(true);
		else if (entity instanceof EntityAnimaniaPig && checkDensity(EntityAnimaniaPig.class, level, pos, FarmConfig.settings.spawnLimitPigs.get()))
			event.setSpawnCancelled(true);
		else if (entity instanceof EntityAnimaniaChicken && checkDensity(EntityAnimaniaChicken.class, level, pos, FarmConfig.settings.spawnLimitChickens.get()))
			event.setSpawnCancelled(true);
		else if (entity instanceof EntityAnimaniaGoat && checkDensity(EntityAnimaniaGoat.class, level, pos, FarmConfig.settings.spawnLimitGoats.get()))
			event.setSpawnCancelled(true);
		else if (entity instanceof EntityAnimaniaSheep && checkDensity(EntityAnimaniaSheep.class, level, pos, FarmConfig.settings.spawnLimitSheep.get()))
			event.setSpawnCancelled(true);
		else if (entity instanceof EntityAnimaniaHorse && checkDensity(EntityAnimaniaHorse.class, level, pos, FarmConfig.settings.spawnLimitHorses.get()))
			event.setSpawnCancelled(true);
	}

	private static <T extends Mob> boolean checkDensity(Class<T> type, Level level, BlockPos pos, int limit)
	{
		List<T> others = AnimaniaHelper.getEntitiesInRange(type, 32.0D, level, pos);
		return others.size() > limit;
	}
}
