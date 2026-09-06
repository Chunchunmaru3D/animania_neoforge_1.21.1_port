package com.animania.addons.farm.common.entity.goats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class GoatAlpine
{
	private static final int PRIMARY = 14867928;
	private static final int SECONDARY = 8281676;

	public static class EntityKidAlpine extends EntityKidBase
	{
		public EntityKidAlpine(EntityType<? extends EntityKidAlpine> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.ALPINE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/kid_alpine.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x83786D;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBuckAlpine extends EntityBuckBase
	{
		public EntityBuckAlpine(EntityType<? extends EntityBuckAlpine> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.ALPINE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_alpine.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x83786D;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityDoeAlpine extends EntityDoeBase
	{
		public EntityDoeAlpine(EntityType<? extends EntityDoeAlpine> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.ALPINE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/doe_alpine.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x83786D;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
