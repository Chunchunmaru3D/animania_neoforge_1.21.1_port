package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 



public class RabbitCottonail
{
	private static final int PRIMARY = 10851765;
	private static final int SECONDARY = 7889402;
	private static final int EYE_COLOR = 0x896E58;

	public static class EntityRabbitKitCottontail extends EntityRabbitKitBase
	{
		public EntityRabbitKitCottontail(EntityType<? extends EntityRabbitKitCottontail> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.COTTONTAIL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_cottontail.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitBuckCottontail extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckCottontail(EntityType<? extends EntityRabbitBuckCottontail> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.COTTONTAIL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_cottontail.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitDoeCottontail extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeCottontail(EntityType<? extends EntityRabbitDoeCottontail> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.COTTONTAIL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_cottontail.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}
}
