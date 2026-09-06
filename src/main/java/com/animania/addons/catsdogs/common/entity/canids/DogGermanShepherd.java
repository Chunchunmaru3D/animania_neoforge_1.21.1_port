package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogGermanShepherd
{
	private static final int PRIMARY = -8300224;
	private static final int SECONDARY = -14478321;

	public static class EntityPuppyGermanShepherd extends EntityPuppyBase
	{
		public EntityPuppyGermanShepherd(EntityType<? extends EntityPuppyGermanShepherd> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GERMAN_SHEPHERD;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_german_shepherd.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleGermanShepherd extends EntityMaleDogBase
	{
		public EntityMaleGermanShepherd(EntityType<? extends EntityMaleGermanShepherd> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GERMAN_SHEPHERD;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_german_shepherd.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleGermanShepherd extends EntityFemaleDogBase
	{
		public EntityFemaleGermanShepherd(EntityType<? extends EntityFemaleGermanShepherd> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GERMAN_SHEPHERD;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_german_shepherd.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
