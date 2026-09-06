package com.animania.addons.farm.common.entity.goats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class GoatKinder
{
	private static final int PRIMARY = 13811120;
	private static final int SECONDARY = 9263679;

	public static class EntityKidKinder extends EntityKidBase
	{
		public EntityKidKinder(EntityType<? extends EntityKidKinder> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.KINDER;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/kid_kinder.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x6F4935;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBuckKinder extends EntityBuckBase
	{
		public EntityBuckKinder(EntityType<? extends EntityBuckKinder> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.KINDER;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_kinder.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x6F4935;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityDoeKinder extends EntityDoeBase
	{
		public EntityDoeKinder(EntityType<? extends EntityDoeKinder> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.KINDER;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/doe_kinder.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/goats_blink_left.png");
			this.lidCol = 0x6F4935;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
