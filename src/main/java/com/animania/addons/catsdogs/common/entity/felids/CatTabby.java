package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CatTabby
{
	private static final int PRIMARY = 0x41332B;
	private static final int SECONDARY = 0x3E3028;

	public static class EntityKittenTabby extends EntityKittenBase
	{
		public EntityKittenTabby(EntityType<? extends EntityKittenTabby> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.TABBY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_tabby.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomTabby extends EntityTomBase
	{
		public EntityTomTabby(EntityType<? extends EntityTomTabby> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.TABBY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_tabby.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenTabby extends EntityQueenBase
	{
		public EntityQueenTabby(EntityType<? extends EntityQueenTabby> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.TABBY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_tabby.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
