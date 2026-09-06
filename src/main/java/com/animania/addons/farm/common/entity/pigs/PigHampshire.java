package com.animania.addons.farm.common.entity.pigs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PigHampshire
{
	private static final int PRIMARY = 5327691;
	private static final int SECONDARY = 13684944;

	public static class EntityPigletHampshire extends EntityPigletBase
	{
		public EntityPigletHampshire(EntityType<? extends EntityPigletHampshire> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.HAMPSHIRE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_hampshire.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_blink_left.png");
			this.lidCol = 0x3a3333;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityHogHampshire extends EntityHogBase
	{
		public EntityHogHampshire(EntityType<? extends EntityHogHampshire> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.HAMPSHIRE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hog_hampshire.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hampshire_blink_left.png");
			this.lidCol = 0x3a3333;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntitySowHampshire extends EntitySowBase
	{
		public EntitySowHampshire(EntityType<? extends EntitySowHampshire> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.HAMPSHIRE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/sow_hampshire.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hampshire_blink_left.png");
			this.lidCol = 0x3a3333;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
