package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogGreyhound
{
	private static final int PRIMARY = -7578572;
	private static final int SECONDARY = -15987708;

	public static class EntityPuppyGreyhound extends EntityPuppyBase
	{
		public EntityPuppyGreyhound(EntityType<? extends EntityPuppyGreyhound> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GREYHOUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_greyhound.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleGreyhound extends EntityMaleDogBase
	{
		public EntityMaleGreyhound(EntityType<? extends EntityMaleGreyhound> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GREYHOUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_greyhound.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleGreyhound extends EntityFemaleDogBase
	{
		public EntityFemaleGreyhound(EntityType<? extends EntityFemaleGreyhound> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.GREYHOUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_greyhound.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
