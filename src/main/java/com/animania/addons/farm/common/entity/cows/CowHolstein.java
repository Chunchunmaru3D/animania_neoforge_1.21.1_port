package com.animania.addons.farm.common.entity.cows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CowHolstein
{
	private static final int PRIMARY = 15987699;
	private static final int SECONDARY = 2236962;

	public static class EntityCalfHolstein extends EntityCalfBase
	{
		public EntityCalfHolstein(EntityType<? extends EntityCalfHolstein> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HOLSTEIN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_holstein.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullHolstein extends EntityBullBase
	{
		public EntityBullHolstein(EntityType<? extends EntityBullHolstein> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HOLSTEIN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_holstein.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowHolstein extends EntityCowBase
	{
		public EntityCowHolstein(EntityType<? extends EntityCowHolstein> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HOLSTEIN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_holstein.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
