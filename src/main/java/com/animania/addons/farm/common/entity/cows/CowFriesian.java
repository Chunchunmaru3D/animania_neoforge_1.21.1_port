package com.animania.addons.farm.common.entity.cows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CowFriesian
{
	private static final int PRIMARY = 15987699;
	private static final int SECONDARY = 3944229;

	public static class EntityCalfFriesian extends EntityCalfBase
	{
		public EntityCalfFriesian(EntityType<? extends EntityCalfFriesian> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.FRIESIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_friesian.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullFriesian extends EntityBullBase
	{
		public EntityBullFriesian(EntityType<? extends EntityBullFriesian> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.FRIESIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_friesian.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowFriesian extends EntityCowBase
	{
		public EntityCowFriesian(EntityType<? extends EntityCowFriesian> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.FRIESIAN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_friesian.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
