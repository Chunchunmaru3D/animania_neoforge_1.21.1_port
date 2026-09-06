package com.animania.addons.farm.common.entity.cows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CowAngus
{
	private static final int PRIMARY = 3028024;
	private static final int SECONDARY = 2304560;

	public static class EntityCalfAngus extends EntityCalfBase
	{
		public EntityCalfAngus(EntityType<? extends EntityCalfAngus> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.ANGUS;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_angus.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullAngus extends EntityBullBase
	{
		public EntityBullAngus(EntityType<? extends EntityBullAngus> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.ANGUS;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_angus.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowAngus extends EntityCowBase
	{
		public EntityCowAngus(EntityType<? extends EntityCowAngus> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.ANGUS;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_angus.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
