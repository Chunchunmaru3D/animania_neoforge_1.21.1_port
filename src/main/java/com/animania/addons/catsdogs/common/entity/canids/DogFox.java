package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogFox
{
	private static final int PRIMARY = -5415620;
	private static final int SECONDARY = -13946603;

	public static class EntityPuppyFox extends EntityPuppyBase
	{
		public EntityPuppyFox(EntityType<? extends EntityPuppyFox> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.FOX;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_fox.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleFox extends EntityMaleDogBase
	{
		public EntityMaleFox(EntityType<? extends EntityMaleFox> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.FOX;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_fox.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleFox extends EntityFemaleDogBase
	{
		public EntityFemaleFox(EntityType<? extends EntityFemaleFox> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.FOX;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_fox.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
