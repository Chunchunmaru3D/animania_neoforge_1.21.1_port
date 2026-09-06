package com.animania.addons.farm.common.worldgen;

import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.common.block.BlockHive;
import com.animania.addons.farm.config.FarmConfig;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

 

















public class WildHiveFeature extends Feature<NoneFeatureConfiguration>
{
	public WildHiveFeature(Codec<NoneFeatureConfiguration> codec)
	{
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
	{
		if (!FarmConfig.settings.hiveSpawning.get())
			return false;

		WorldGenLevel level = context.level();
		RandomSource random = context.random();
		BlockPos origin = context.origin();

		int frequency = Math.max(0, Math.min(10, FarmConfig.settings.hiveSpawningFrequency.get()));
		if (random.nextInt(200) >= frequency)
			return false;

		BlockPos.MutableBlockPos logCursor = new BlockPos.MutableBlockPos();
		for (int dx = -7; dx < 7; dx++)
		{
			for (int dy = 1; dy < 4; dy++)
			{
				for (int dz = -7; dz < 7; dz++)
				{
					logCursor.setWithOffset(origin, dx, dy, dz);
					if (!level.getBlockState(logCursor).is(BlockTags.LOGS))
						continue;

					if (hasNearbyHive(level, logCursor))
						return false;

					Direction side = Direction.Plane.HORIZONTAL.getRandomDirection(random);
					BlockPos hivePos = logCursor.relative(side);
					if (!level.getBlockState(hivePos).isAir())
						continue;

					level.setBlock(hivePos, FarmBlocks.WILD_HIVE.get().defaultBlockState().setValue(BlockHive.FACING, side), 3);
					return true;
				}
			}
		}

		return false;
	}

	private static boolean hasNearbyHive(WorldGenLevel level, BlockPos center)
	{
		BlockPos.MutableBlockPos cursor = new BlockPos.MutableBlockPos();
		for (int dx = -3; dx < 3; dx++)
		{
			for (int dy = 1; dy < 4; dy++)
			{
				for (int dz = -3; dz < 3; dz++)
				{
					cursor.setWithOffset(center, dx, dy, dz);
					if (level.getBlockState(cursor).is(FarmBlocks.HIVE.get()) || level.getBlockState(cursor).is(FarmBlocks.WILD_HIVE.get()))
						return true;
				}
			}
		}
		return false;
	}
}
