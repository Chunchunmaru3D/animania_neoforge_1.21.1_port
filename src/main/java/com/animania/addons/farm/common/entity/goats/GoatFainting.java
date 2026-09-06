package com.animania.addons.farm.common.entity.goats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class GoatFainting
{
	private static final int PRIMARY = 1250067;
	private static final int SECONDARY = 14803425;

	public static class EntityKidFainting extends EntityKidBase
	{
		public EntityKidFainting(EntityType<? extends EntityKidFainting> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.FAINTING;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/kid_fainting.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x6B6968;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBuckFainting extends EntityBuckBase
	{
		public EntityBuckFainting(EntityType<? extends EntityBuckFainting> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.FAINTING;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_fainting.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x6B6968;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityDoeFainting extends EntityDoeBase
	{
		public EntityDoeFainting(EntityType<? extends EntityDoeFainting> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.FAINTING;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/doe_fainting.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x6B6968;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
