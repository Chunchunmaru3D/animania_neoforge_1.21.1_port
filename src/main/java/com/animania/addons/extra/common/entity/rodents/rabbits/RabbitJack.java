package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class RabbitJack
{
	private static final int PRIMARY = 11828069;
	private static final int SECONDARY = 8940772;
	private static final int EYE_COLOR = 0x938375;

	public static class EntityRabbitKitJack extends EntityRabbitKitBase
	{
		public EntityRabbitKitJack(EntityType<? extends EntityRabbitKitJack> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.JACK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_jack.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitBuckJack extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckJack(EntityType<? extends EntityRabbitBuckJack> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.JACK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_jack.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitDoeJack extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeJack(EntityType<? extends EntityRabbitDoeJack> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.JACK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_jack.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}
}
