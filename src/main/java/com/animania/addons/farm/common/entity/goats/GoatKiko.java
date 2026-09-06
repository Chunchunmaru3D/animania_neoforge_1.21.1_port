package com.animania.addons.farm.common.entity.goats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class GoatKiko
{
	private static final int PRIMARY = 3549475;
	private static final int SECONDARY = 8802872;

	public static class EntityKidKiko extends EntityKidBase
	{
		public EntityKidKiko(EntityType<? extends EntityKidKiko> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.KIKO;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/kid_kiko.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x694330;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBuckKiko extends EntityBuckBase
	{
		public EntityBuckKiko(EntityType<? extends EntityBuckKiko> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.KIKO;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_kiko.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x694330;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityDoeKiko extends EntityDoeBase
	{
		public EntityDoeKiko(EntityType<? extends EntityDoeKiko> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.KIKO;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/doe_kiko.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x694330;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
