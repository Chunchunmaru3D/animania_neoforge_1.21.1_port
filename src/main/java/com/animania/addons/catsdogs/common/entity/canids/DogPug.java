package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogPug
{
	private static final int PRIMARY = -1514529;
	private static final int SECONDARY = -13026238;

	public static class EntityPuppyPug extends EntityPuppyBase
	{
		public EntityPuppyPug(EntityType<? extends EntityPuppyPug> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.PUG;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/pug.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMalePug extends EntityMaleDogBase
	{
		public EntityMalePug(EntityType<? extends EntityMalePug> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.PUG;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/pug.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemalePug extends EntityFemaleDogBase
	{
		public EntityFemalePug(EntityType<? extends EntityFemalePug> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.PUG;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/pug.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
