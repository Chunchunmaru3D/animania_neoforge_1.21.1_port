package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CatAsiatic
{
	private static final int PRIMARY = 8152144;
	private static final int SECONDARY = 3684408;

	public static class EntityKittenAsiatic extends EntityKittenBase
	{
		public EntityKittenAsiatic(EntityType<? extends EntityKittenAsiatic> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.ASIATIC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_asiatic.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomAsiatic extends EntityTomBase
	{
		public EntityTomAsiatic(EntityType<? extends EntityTomAsiatic> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.ASIATIC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_asiatic.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenAsiatic extends EntityQueenBase
	{
		public EntityQueenAsiatic(EntityType<? extends EntityQueenAsiatic> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.ASIATIC;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_asiatic.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
