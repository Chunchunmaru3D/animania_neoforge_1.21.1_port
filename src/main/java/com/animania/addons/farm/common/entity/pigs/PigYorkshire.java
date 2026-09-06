package com.animania.addons.farm.common.entity.pigs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PigYorkshire
{
	private static final int PRIMARY = 15845576;
	private static final int SECONDARY = 15117998;

	public static class EntityPigletYorkshire extends EntityPigletBase
	{
		public EntityPigletYorkshire(EntityType<? extends EntityPigletYorkshire> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.YORKSHIRE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_yorkshire.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_blink_left.png");
			this.lidCol = 0xe07f7d;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityHogYorkshire extends EntityHogBase
	{
		public EntityHogYorkshire(EntityType<? extends EntityHogYorkshire> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.YORKSHIRE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hog_yorkshire.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0xe07f7d;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntitySowYorkshire extends EntitySowBase
	{
		public EntitySowYorkshire(EntityType<? extends EntitySowYorkshire> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.YORKSHIRE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/sow_yorkshire.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0xe07f7d;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
