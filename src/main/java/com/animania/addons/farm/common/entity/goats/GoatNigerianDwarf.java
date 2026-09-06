package com.animania.addons.farm.common.entity.goats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class GoatNigerianDwarf
{
	private static final int PRIMARY = 2697513;
	private static final int SECONDARY = 8343350;

	public static class EntityKidNigerianDwarf extends EntityKidBase
	{
		public EntityKidNigerianDwarf(EntityType<? extends EntityKidNigerianDwarf> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.NIGERIAN_DWARF;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/kid_nigerian.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x404040;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBuckNigerianDwarf extends EntityBuckBase
	{
		public EntityBuckNigerianDwarf(EntityType<? extends EntityBuckNigerianDwarf> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.NIGERIAN_DWARF;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_nigerian.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x404040;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityDoeNigerianDwarf extends EntityDoeBase
	{
		public EntityDoeNigerianDwarf(EntityType<? extends EntityDoeNigerianDwarf> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.NIGERIAN_DWARF;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/doe_nigerian.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x404040;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
