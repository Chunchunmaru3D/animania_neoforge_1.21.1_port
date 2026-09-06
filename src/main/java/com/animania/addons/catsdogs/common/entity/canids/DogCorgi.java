package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogCorgi
{
	private static final int PRIMARY = -263173;
	private static final int SECONDARY = -2987202;

	public static class EntityPuppyCorgi extends EntityPuppyBase
	{
		public EntityPuppyCorgi(EntityType<? extends EntityPuppyCorgi> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.CORGI;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/corgi.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleCorgi extends EntityMaleDogBase
	{
		public EntityMaleCorgi(EntityType<? extends EntityMaleCorgi> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.CORGI;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/corgi.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleCorgi extends EntityFemaleDogBase
	{
		public EntityFemaleCorgi(EntityType<? extends EntityFemaleCorgi> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.CORGI;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/corgi.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
