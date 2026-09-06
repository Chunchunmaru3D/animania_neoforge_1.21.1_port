package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogChihuahua
{
	private static final int PRIMARY = -593428;
	private static final int SECONDARY = -16382716;

	public static class EntityPuppyChihuahua extends EntityPuppyBase
	{
		public EntityPuppyChihuahua(EntityType<? extends EntityPuppyChihuahua> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.CHIHUAHUA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/chihuahua.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 2; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0x8E5C2B : 0xE5DAD3; }
	}

	public static class EntityMaleChihuahua extends EntityMaleDogBase
	{
		public EntityMaleChihuahua(EntityType<? extends EntityMaleChihuahua> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.CHIHUAHUA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/chihuahua.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 2; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0x8E5C2B : 0xE5DAD3; }
	}

	public static class EntityFemaleChihuahua extends EntityFemaleDogBase
	{
		public EntityFemaleChihuahua(EntityType<? extends EntityFemaleChihuahua> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.CHIHUAHUA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/chihuahua.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 2; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0x8E5C2B : 0xE5DAD3; }
	}
}
