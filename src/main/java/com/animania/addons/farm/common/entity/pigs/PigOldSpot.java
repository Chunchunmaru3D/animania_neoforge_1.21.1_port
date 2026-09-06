package com.animania.addons.farm.common.entity.pigs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PigOldSpot
{
	private static final int PRIMARY = 15845576;
	private static final int SECONDARY = 9859698;

	public static class EntityPigletOldSpot extends EntityPigletBase
	{
		public EntityPigletOldSpot(EntityType<? extends EntityPigletOldSpot> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.OLD_SPOT;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_old_spot.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_blink_left.png");
			this.lidCol = 0x514b4b;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityHogOldSpot extends EntityHogBase
	{
		public EntityHogOldSpot(EntityType<? extends EntityHogOldSpot> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.OLD_SPOT;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hog_old_spot.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0x514b4b;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntitySowOldSpot extends EntitySowBase
	{
		public EntitySowOldSpot(EntityType<? extends EntitySowOldSpot> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.OLD_SPOT;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/sow_old_spot.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0x514b4b;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
