package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CatOcelot
{
	private static final int PRIMARY = 11633487;
	private static final int SECONDARY = 4995106;

	public static class EntityKittenOcelot extends EntityKittenBase
	{
		public EntityKittenOcelot(EntityType<? extends EntityKittenOcelot> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.OCELOT;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_ocelot.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomOcelot extends EntityTomBase
	{
		public EntityTomOcelot(EntityType<? extends EntityTomOcelot> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.OCELOT;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_ocelot.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenOcelot extends EntityQueenBase
	{
		public EntityQueenOcelot(EntityType<? extends EntityQueenOcelot> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.OCELOT;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_ocelot.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
