package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogPoodle
{
	private static final int PRIMARY = -658707;
	private static final int SECONDARY = -5537189;

	public static class EntityPuppyPoodle extends EntityPuppyBase
	{
		public EntityPuppyPoodle(EntityType<? extends EntityPuppyPoodle> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.POODLE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_poodle.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 3; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0xECECEC : variant == 1 ? 0x1D1D1D : 0x874D29; }
	}

	public static class EntityMalePoodle extends EntityMaleDogBase
	{
		public EntityMalePoodle(EntityType<? extends EntityMalePoodle> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.POODLE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_poodle.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 3; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0xECECEC : variant == 1 ? 0x1D1D1D : 0x874D29; }
	}

	public static class EntityFemalePoodle extends EntityFemaleDogBase
	{
		public EntityFemalePoodle(EntityType<? extends EntityFemalePoodle> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.POODLE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_poodle.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 3; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0xECECEC : variant == 1 ? 0x1D1D1D : 0x874D29; }
	}
}
