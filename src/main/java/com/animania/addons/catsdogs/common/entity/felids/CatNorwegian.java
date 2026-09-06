package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CatNorwegian
{
	private static final int PRIMARY = 3878181;
	private static final int SECONDARY = 9992290;

	public static class EntityKittenNorwegian extends EntityKittenBase
	{
		public EntityKittenNorwegian(EntityType<? extends EntityKittenNorwegian> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.NORWEGIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_norwegian.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomNorwegian extends EntityTomBase
	{
		public EntityTomNorwegian(EntityType<? extends EntityTomNorwegian> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.NORWEGIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_norwegian.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenNorwegian extends EntityQueenBase
	{
		public EntityQueenNorwegian(EntityType<? extends EntityQueenNorwegian> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.NORWEGIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_norwegian.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
