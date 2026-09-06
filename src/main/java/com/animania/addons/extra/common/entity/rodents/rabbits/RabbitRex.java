package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class RabbitRex
{
	private static final int PRIMARY = 9139310;
	private static final int SECONDARY = 7565694;
	private static final int EYE_COLOR = 0x574133;

	public static class EntityRabbitKitRex extends EntityRabbitKitBase
	{
		public EntityRabbitKitRex(EntityType<? extends EntityRabbitKitRex> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.REX;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_rex.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitBuckRex extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckRex(EntityType<? extends EntityRabbitBuckRex> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.REX;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_rex.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitDoeRex extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeRex(EntityType<? extends EntityRabbitDoeRex> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.REX;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_rex.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}
}
