package com.animania.addons.farm.common.entity.pigs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PigDuroc
{
	private static final int PRIMARY = 9399147;
	private static final int SECONDARY = 6896443;

	public static class EntityPigletDuroc extends EntityPigletBase
	{
		public EntityPigletDuroc(EntityType<? extends EntityPigletDuroc> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.DUROC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_duroc.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/piglet_blink_left.png");
			this.lidCol = 0x421006;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityHogDuroc extends EntityHogBase
	{
		public EntityHogDuroc(EntityType<? extends EntityHogDuroc> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.DUROC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/hog_duroc.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0x421006;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntitySowDuroc extends EntitySowBase
	{
		public EntitySowDuroc(EntityType<? extends EntitySowDuroc> entityType, Level level)
		{
			super(entityType, level);
			this.pigType = PigType.DUROC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/sow_duroc.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/pigs/pig_blink_left.png");
			this.lidCol = 0x421006;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
