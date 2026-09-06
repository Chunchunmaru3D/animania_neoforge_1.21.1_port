package com.animania.addons.farm.common.entity.goats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class GoatPygmy
{
	private static final int PRIMARY = 4145731;
	private static final int SECONDARY = 9475221;

	public static class EntityKidPygmy extends EntityKidBase
	{
		public EntityKidPygmy(EntityType<? extends EntityKidPygmy> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.PYGMY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/kid_pygmy.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x2B2E2E;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBuckPygmy extends EntityBuckBase
	{
		public EntityBuckPygmy(EntityType<? extends EntityBuckPygmy> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.PYGMY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_pygmy.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x2B2E2E;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityDoePygmy extends EntityDoeBase
	{
		public EntityDoePygmy(EntityType<? extends EntityDoePygmy> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.PYGMY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/doe_pygmy.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x2B2E2E;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
