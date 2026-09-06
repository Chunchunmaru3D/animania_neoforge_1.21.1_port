package com.animania.addons.catsdogs.common.entity.felids;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CatRagdoll
{
	private static final int PRIMARY = 13948116;
	private static final int SECONDARY = 8741209;

	public static class EntityKittenRagdoll extends EntityKittenBase
	{
		public EntityKittenRagdoll(EntityType<? extends EntityKittenRagdoll> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.RAGDOLL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/kitten_ragdoll.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityTomRagdoll extends EntityTomBase
	{
		public EntityTomRagdoll(EntityType<? extends EntityTomRagdoll> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.RAGDOLL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/tom_ragdoll.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityQueenRagdoll extends EntityQueenBase
	{
		public EntityQueenRagdoll(EntityType<? extends EntityQueenRagdoll> entityType, Level level)
		{
			super(entityType, level);
			this.type = CatType.RAGDOLL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/queen_ragdoll.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
