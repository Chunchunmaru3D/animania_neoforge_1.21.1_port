package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class RabbitHavana
{
	private static final int PRIMARY = 6045214;
	private static final int SECONDARY = 3618403;
	private static final int EYE_COLOR = 0x404040;

	public static class EntityRabbitKitHavana extends EntityRabbitKitBase
	{
		public EntityRabbitKitHavana(EntityType<? extends EntityRabbitKitHavana> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.HAVANA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_havana.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitBuckHavana extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckHavana(EntityType<? extends EntityRabbitBuckHavana> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.HAVANA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_havana.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitDoeHavana extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeHavana(EntityType<? extends EntityRabbitDoeHavana> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.HAVANA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_havana.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}
}
