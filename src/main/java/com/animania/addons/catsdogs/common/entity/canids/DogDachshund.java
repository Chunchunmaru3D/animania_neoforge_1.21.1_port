package com.animania.addons.catsdogs.common.entity.canids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogDachshund
{
	private static final int PRIMARY = -197380;
	private static final int SECONDARY = -15988473;

	public static class EntityPuppyDachshund extends EntityPuppyBase
	{
		public EntityPuppyDachshund(EntityType<? extends EntityPuppyDachshund> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.DACHSHUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/dachshund.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMaleDachshund extends EntityMaleDogBase
	{
		public EntityMaleDachshund(EntityType<? extends EntityMaleDachshund> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.DACHSHUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/dachshund.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityFemaleDachshund extends EntityFemaleDogBase
	{
		public EntityFemaleDachshund(EntityType<? extends EntityFemaleDachshund> entityType, Level level)
		{
			super(entityType, level);
			this.type = DogType.DACHSHUND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/dachshund.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
