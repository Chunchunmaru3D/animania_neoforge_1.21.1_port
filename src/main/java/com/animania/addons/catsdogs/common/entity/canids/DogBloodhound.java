package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogBloodhound
{
	private static final int PRIMARY = -5938636;
	private static final int SECONDARY = -13689844;

	public static class EntityPuppyBloodhound extends EntityPuppyBase
	{
		public EntityPuppyBloodhound(EntityType<? extends EntityPuppyBloodhound> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.BLOODHOUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_bloodhound.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleBloodhound extends EntityMaleDogBase
	{
		public EntityMaleBloodhound(EntityType<? extends EntityMaleBloodhound> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.BLOODHOUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_bloodhound.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleBloodhound extends EntityFemaleDogBase
	{
		public EntityFemaleBloodhound(EntityType<? extends EntityFemaleBloodhound> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.BLOODHOUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_bloodhound.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
