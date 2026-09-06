package com.animania.addons.extra.common.entity.rodents.rabbits;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class RabbitLop
{
	private static final int PRIMARY = 13948116;
	private static final int SECONDARY = 8741209;
	private static final int[] EYE_COLORS = { 0x404040, 0x816D60, 0xD0A675, 0x7F6C5B, 0xF6F4F4, 0xF6F4F4, 0xF6F4F4 };

	public static class EntityRabbitKitLop extends EntityRabbitKitBase
	{
		public EntityRabbitKitLop(EntityType<? extends EntityRabbitKitLop> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.LOP;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/kit_lop.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 7; }
		@Override public int getEyeColorForVariant(int variant) { return EYE_COLORS[Math.floorMod(variant, EYE_COLORS.length)]; }
	}

	public static class EntityRabbitBuckLop extends EntityRabbitBuckBase
	{
		public EntityRabbitBuckLop(EntityType<? extends EntityRabbitBuckLop> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.LOP;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/buck_lop.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 7; }
		@Override public int getEyeColorForVariant(int variant) { return EYE_COLORS[Math.floorMod(variant, EYE_COLORS.length)]; }
	}

	public static class EntityRabbitDoeLop extends EntityRabbitDoeBase
	{
		public EntityRabbitDoeLop(EntityType<? extends EntityRabbitDoeLop> entityType, Level level)
		{
			super(entityType, level);
			this.type = RabbitType.LOP;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rabbits/doe_lop.png");
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }

		@Override public int getVariantCount() { return 7; }
		@Override public int getEyeColorForVariant(int variant) { return EYE_COLORS[Math.floorMod(variant, EYE_COLORS.length)]; }
	}
}
