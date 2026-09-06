package com.animania.addons.farm.common.entity.pigs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PigLargeBlack
{
	private static final int PRIMARY = 8417906;
	private static final int SECONDARY = 5326149;

	public static class EntityPigletLargeBlack extends EntityPigletBase
	{
		public EntityPigletLargeBlack(EntityType<? extends EntityPigletLargeBlack> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.LARGE_BLACK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_large_black.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_blink_left.png");
			this.lidCol = 0x3a3333;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityHogLargeBlack extends EntityHogBase
	{
		public EntityHogLargeBlack(EntityType<? extends EntityHogLargeBlack> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.LARGE_BLACK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hog_large_black.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0x3a3333;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntitySowLargeBlack extends EntitySowBase
	{
		public EntitySowLargeBlack(EntityType<? extends EntitySowLargeBlack> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.LARGE_BLACK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/sow_large_black.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0x3a3333;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
