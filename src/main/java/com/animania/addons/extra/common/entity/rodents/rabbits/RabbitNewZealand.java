package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class RabbitNewZealand
{
	private static final int PRIMARY = 15921906;
	private static final int SECONDARY = 13554152;
	private static final int EYE_COLOR = 0xF4F2F2;

	public static class EntityRabbitKitNewZealand extends EntityRabbitKitBase
	{
		public EntityRabbitKitNewZealand(EntityType<? extends EntityRabbitKitNewZealand> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.NEW_ZEALAND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_new_zealand.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitBuckNewZealand extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckNewZealand(EntityType<? extends EntityRabbitBuckNewZealand> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.NEW_ZEALAND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_new_zealand.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitDoeNewZealand extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeNewZealand(EntityType<? extends EntityRabbitDoeNewZealand> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.NEW_ZEALAND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_new_zealand.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}
}
