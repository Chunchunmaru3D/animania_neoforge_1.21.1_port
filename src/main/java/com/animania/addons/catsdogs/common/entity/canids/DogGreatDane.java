package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogGreatDane
{
	private static final int PRIMARY = -8300224;
	private static final int SECONDARY = -14412785;

	public static class EntityPuppyGreatDane extends EntityPuppyBase
	{
		public EntityPuppyGreatDane(EntityType<? extends EntityPuppyGreatDane> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GREAT_DANE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_great_dane.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleGreatDane extends EntityMaleDogBase
	{
		public EntityMaleGreatDane(EntityType<? extends EntityMaleGreatDane> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GREAT_DANE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_great_dane.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleGreatDane extends EntityFemaleDogBase
	{
		public EntityFemaleGreatDane(EntityType<? extends EntityFemaleGreatDane> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GREAT_DANE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_great_dane.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
