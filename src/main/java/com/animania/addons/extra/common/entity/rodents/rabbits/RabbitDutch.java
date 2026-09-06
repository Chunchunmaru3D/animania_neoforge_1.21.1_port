package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class RabbitDutch
{
	private static final int PRIMARY = 3815994;
	private static final int SECONDARY = 15921906;
	private static final int EYE_COLOR = 0x404040;

	public static class EntityRabbitKitDutch extends EntityRabbitKitBase
	{
		public EntityRabbitKitDutch(EntityType<? extends EntityRabbitKitDutch> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.DUTCH;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_dutch.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitBuckDutch extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckDutch(EntityType<? extends EntityRabbitBuckDutch> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.DUTCH;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_dutch.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}

	public static class EntityRabbitDoeDutch extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeDutch(EntityType<? extends EntityRabbitDoeDutch> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.DUTCH;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_dutch.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getEyeColorForVariant(int variant) { return EYE_COLOR; }
	}
}
