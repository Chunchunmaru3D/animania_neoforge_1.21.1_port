package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CatExotic
{
	private static final int PRIMARY = 11426596;
	private static final int SECONDARY = 14129778;

	public static class EntityKittenExotic extends EntityKittenBase
	{
		public EntityKittenExotic(EntityType<? extends EntityKittenExotic> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.EXOTIC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_exotic.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomExotic extends EntityTomBase
	{
		public EntityTomExotic(EntityType<? extends EntityTomExotic> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.EXOTIC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_exotic.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenExotic extends EntityQueenBase
	{
		public EntityQueenExotic(EntityType<? extends EntityQueenExotic> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.EXOTIC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_exotic.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
