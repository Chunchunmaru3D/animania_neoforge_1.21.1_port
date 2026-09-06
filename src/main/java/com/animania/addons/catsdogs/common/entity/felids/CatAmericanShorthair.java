package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CatAmericanShorthair
{
	private static final int PRIMARY = 7434609;
	private static final int SECONDARY = 0;

	public static class EntityKittenAmericanShorthair extends EntityKittenBase
	{
		public EntityKittenAmericanShorthair(EntityType<? extends EntityKittenAmericanShorthair> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.AMERICAN_SHORTHAIR;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_american_shorthair.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomAmericanShorthair extends EntityTomBase
	{
		public EntityTomAmericanShorthair(EntityType<? extends EntityTomAmericanShorthair> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.AMERICAN_SHORTHAIR;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_american_shorthair.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenAmericanShorthair extends EntityQueenBase
	{
		public EntityQueenAmericanShorthair(EntityType<? extends EntityQueenAmericanShorthair> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.AMERICAN_SHORTHAIR;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_american_shorthair.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
