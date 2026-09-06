package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogHusky
{
	private static final int PRIMARY = -14606304;
	private static final int SECONDARY = -1118482;

	public static class EntityPuppyHusky extends EntityPuppyBase
	{
		public EntityPuppyHusky(EntityType<? extends EntityPuppyHusky> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.HUSKY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_husky.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleHusky extends EntityMaleDogBase
	{
		public EntityMaleHusky(EntityType<? extends EntityMaleHusky> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.HUSKY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_husky.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleHusky extends EntityFemaleDogBase
	{
		public EntityFemaleHusky(EntityType<? extends EntityFemaleHusky> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.HUSKY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_husky.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
