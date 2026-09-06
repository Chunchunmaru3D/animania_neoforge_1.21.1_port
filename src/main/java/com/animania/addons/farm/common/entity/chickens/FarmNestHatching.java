package com.animania.addons.farm.common.entity.chickens;

import java.util.List;

import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.blocks.BlockNest;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;

 










public final class FarmNestHatching
{
	public static void register()
	{
		BlockNest.addHatchCallback(FarmNestHatching::tryHatch);
	}

	private static void tryHatch(ServerLevel level, BlockPos pos, BlockEntityNest nest, RandomSource random)
	{
		String breedId = nest.getBreedId();
		if (breedId == null)
			return;

		ChickenType birdType;
		try
		{
			birdType = ChickenType.valueOf(breedId);
		}
		catch (IllegalArgumentException ex)
		{
			return;
		}

		List<EntityRoosterBase> roosters = AnimaniaHelper.getEntitiesInRange(EntityRoosterBase.class, 3, level, pos);
		if (roosters.isEmpty())
			return;

		List<EntityAnimaniaChicken> nearbyChickens = AnimaniaHelper.getEntitiesInRange(EntityAnimaniaChicken.class, 15, level, pos);
		if (nearbyChickens.size() >= AnimaniaConfig.careAndFeeding.entityBreedingLimit.get())
			return;

		int hatchChance = AnimaniaConfig.careAndFeeding.eggHatchChance.get();

		for (EntityRoosterBase rooster : roosters)
		{
			if (random.nextInt(hatchChance) != 0)
				continue;

			ChickenType chickType = ChickenType.breed(rooster.type, birdType);

			if (!(chickType.getChild(level) instanceof EntityChickBase chick))
				continue;

			chick.setPos(pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5);
			AnimaniaHelper.spawnEntity(level, chick);
			nest.hatchOneEgg();
			break;
		}
	}

	private FarmNestHatching()
	{
	}
}
