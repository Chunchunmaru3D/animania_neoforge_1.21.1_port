package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class DogWolf
{
	private static final int PRIMARY = -4409680;
	private static final int SECONDARY = -13488852;

	public static class EntityPuppyWolf extends EntityPuppyBase
	{
		public EntityPuppyWolf(EntityType<? extends EntityPuppyWolf> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.WOLF;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/puppy_wolf.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 8; }
		@Override public int getEyeColorForVariant(int variant) { return switch (variant) { case 0 -> 0x524E48; case 1 -> 0xD9D9D9; case 2, 3 -> 0x2A2725; case 4 -> 0x71533F; case 5 -> 0x9D8C76; case 6 -> 0x9A9389; default -> 0xCECECD; }; }
	}

	public static class EntityMaleWolf extends EntityMaleDogBase
	{
		public EntityMaleWolf(EntityType<? extends EntityMaleWolf> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.WOLF;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/male_wolf.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 8; }
		@Override public int getEyeColorForVariant(int variant) { return switch (variant) { case 0 -> 0x524E48; case 1 -> 0xD9D9D9; case 2, 3 -> 0x2A2725; case 4 -> 0x71533F; case 5 -> 0x9D8C76; case 6 -> 0x9A9389; default -> 0xCECECD; }; }
	}

	public static class EntityFemaleWolf extends EntityFemaleDogBase
	{
		public EntityFemaleWolf(EntityType<? extends EntityFemaleWolf> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.WOLF;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/female_wolf.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 8; }
		@Override public int getEyeColorForVariant(int variant) { return switch (variant) { case 0 -> 0x524E48; case 1 -> 0xD9D9D9; case 2, 3 -> 0x2A2725; case 4 -> 0x71533F; case 5 -> 0x9D8C76; case 6 -> 0x9A9389; default -> 0xCECECD; }; }
	}
}
