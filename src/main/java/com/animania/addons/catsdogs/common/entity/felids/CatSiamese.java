package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CatSiamese
{
	private static final int PRIMARY = 0xBE9474;
	private static final int SECONDARY = 0x372A20;

	public static class EntityKittenSiamese extends EntityKittenBase
	{
		public EntityKittenSiamese(EntityType<? extends EntityKittenSiamese> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.SIAMESE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_siamese.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomSiamese extends EntityTomBase
	{
		public EntityTomSiamese(EntityType<? extends EntityTomSiamese> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.SIAMESE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_siamese.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenSiamese extends EntityQueenBase
	{
		public EntityQueenSiamese(EntityType<? extends EntityQueenSiamese> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.SIAMESE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_siamese.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
