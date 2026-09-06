package com.animania.addons.extra.common.entity.peafowl;

import java.util.List;

import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.blocks.BlockNest;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;

 




public final class ExtraNestHatching
{
	public static void register()
	{
		BlockNest.addHatchCallback(ExtraNestHatching::tryHatch);
	}

	private static void tryHatch(ServerLevel level, BlockPos pos, BlockEntityNest nest, RandomSource random)
	{
		String breedId = nest.getBreedId();
		if (breedId == null)
			return;

		PeacockType birdType;
		try
		{
			birdType = PeacockType.valueOf(breedId);
		}
		catch (IllegalArgumentException ex)
		{
			return;
		}

		List<EntityPeacockBase> males = AnimaniaHelper.getEntitiesInRange(EntityPeacockBase.class, 3, level, pos);
		if (males.isEmpty())
			return;

		List<EntityAnimaniaPeacock> nearby = AnimaniaHelper.getEntitiesInRange(EntityAnimaniaPeacock.class, 15, level, pos);
		if (nearby.size() >= AnimaniaConfig.careAndFeeding.entityBreedingLimit.get())
			return;

		int hatchChance = AnimaniaConfig.careAndFeeding.eggHatchChance.get();

		for (EntityPeacockBase male : males)
		{
			if (random.nextInt(hatchChance) != 0)
				continue;

			PeacockType childType = PeacockType.breed(birdType, male.type);

			if (!(childType.getChild(level) instanceof EntityPeachickBase chick))
				continue;

			chick.setPos(pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5);
			AnimaniaHelper.spawnEntity(level, chick);
			nest.hatchOneEgg();
			break;
		}
	}

	private ExtraNestHatching()
	{
	}
}
