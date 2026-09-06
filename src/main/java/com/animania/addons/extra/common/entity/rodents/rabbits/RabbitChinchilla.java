package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class RabbitChinchilla
{
	private static final int PRIMARY = 10197915;
	private static final int SECONDARY = 6710886;
	private static final int EYE_COLOR = 0x9E9E9E;

	public static class EntityRabbitKitChinchilla extends EntityRabbitKitBase
	{
		public EntityRabbitKitChinchilla(EntityType<? extends EntityRabbitKitChinchilla> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.CHINCHILLA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_chinchilla.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitBuckChinchilla extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckChinchilla(EntityType<? extends EntityRabbitBuckChinchilla> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.CHINCHILLA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_chinchilla.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitDoeChinchilla extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeChinchilla(EntityType<? extends EntityRabbitDoeChinchilla> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.CHINCHILLA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_chinchilla.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}
}
