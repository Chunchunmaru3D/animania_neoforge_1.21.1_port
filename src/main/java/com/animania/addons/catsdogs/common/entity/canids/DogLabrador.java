package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 




public class DogLabrador
{
	private static final int PRIMARY = -4153993;
	private static final int SECONDARY = -12506848;

	public static class EntityPuppyLabrador extends EntityPuppyBase
	{
		public EntityPuppyLabrador(EntityType<? extends EntityPuppyLabrador> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.LABRADOR;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_labrador.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 3; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0xAA7A4C : variant == 1 ? 0x1B1B1B : 0x39211A; }
	}

	public static class EntityMaleLabrador extends EntityMaleDogBase
	{
		public EntityMaleLabrador(EntityType<? extends EntityMaleLabrador> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.LABRADOR;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_labrador.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 3; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0xAA7A4C : variant == 1 ? 0x1B1B1B : 0x39211A; }
	}

	public static class EntityFemaleLabrador extends EntityFemaleDogBase
	{
		public EntityFemaleLabrador(EntityType<? extends EntityFemaleLabrador> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.LABRADOR;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_labrador.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 3; }
		@Override public int getEyeColorForVariant(int variant) { return variant == 0 ? 0xAA7A4C : variant == 1 ? 0x1B1B1B : 0x39211A; }
	}
}
