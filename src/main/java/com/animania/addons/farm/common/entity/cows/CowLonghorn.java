package com.animania.addons.farm.common.entity.cows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CowLonghorn
{
	private static final int PRIMARY = 16763795;
	private static final int SECONDARY = 11227168;

	public static class EntityCalfLonghorn extends EntityCalfBase
	{
		public EntityCalfLonghorn(EntityType<? extends EntityCalfLonghorn> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.LONGHORN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_longhorn.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullLonghorn extends EntityBullBase
	{
		public EntityBullLonghorn(EntityType<? extends EntityBullLonghorn> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.LONGHORN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_longhorn.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowLonghorn extends EntityCowBase
	{
		public EntityCowLonghorn(EntityType<? extends EntityCowLonghorn> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.LONGHORN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_longhorn.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
