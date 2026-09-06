package com.animania.addons.farm.common.entity.pigs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PigLargeWhite
{
	private static final int PRIMARY = 15061714;
	private static final int SECONDARY = 13876669;

	public static class EntityPigletLargeWhite extends EntityPigletBase
	{
		public EntityPigletLargeWhite(EntityType<? extends EntityPigletLargeWhite> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.LARGE_WHITE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_large_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_blink_left.png");
			this.lidCol = 0xc4a8a8;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityHogLargeWhite extends EntityHogBase
	{
		public EntityHogLargeWhite(EntityType<? extends EntityHogLargeWhite> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.LARGE_WHITE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hog_large_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0xc4a8a8;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntitySowLargeWhite extends EntitySowBase
	{
		public EntitySowLargeWhite(EntityType<? extends EntitySowLargeWhite> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.LARGE_WHITE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/sow_large_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0xc4a8a8;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
