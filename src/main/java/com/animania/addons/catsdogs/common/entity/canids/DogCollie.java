package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogCollie
{
	private static final int PRIMARY = -12570587;
	private static final int SECONDARY = -197380;

	public static class EntityPuppyCollie extends EntityPuppyBase
	{
		public EntityPuppyCollie(EntityType<? extends EntityPuppyCollie> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.COLLIE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/collie.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 2; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0x433227 : 0x1B1B1B; }
	}

	public static class EntityMaleCollie extends EntityMaleDogBase
	{
		public EntityMaleCollie(EntityType<? extends EntityMaleCollie> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.COLLIE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/collie.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 2; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0x433227 : 0x1B1B1B; }
	}

	public static class EntityFemaleCollie extends EntityFemaleDogBase
	{
		public EntityFemaleCollie(EntityType<? extends EntityFemaleCollie> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.COLLIE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/collie.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 2; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0x433227 : 0x1B1B1B; }
	}
}
