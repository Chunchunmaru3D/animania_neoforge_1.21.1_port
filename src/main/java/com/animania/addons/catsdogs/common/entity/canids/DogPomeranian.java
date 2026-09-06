package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogPomeranian
{
	private static final int PRIMARY = -197380;
	private static final int SECONDARY = -13884380;

	public static class EntityPuppyPomeranian extends EntityPuppyBase
	{
		public EntityPuppyPomeranian(EntityType<? extends EntityPuppyPomeranian> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.POMERANIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/pomeranian.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMalePomeranian extends EntityMaleDogBase
	{
		public EntityMalePomeranian(EntityType<? extends EntityMalePomeranian> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.POMERANIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/pomeranian.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemalePomeranian extends EntityFemaleDogBase
	{
		public EntityFemalePomeranian(EntityType<? extends EntityFemalePomeranian> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.POMERANIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/pomeranian.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
