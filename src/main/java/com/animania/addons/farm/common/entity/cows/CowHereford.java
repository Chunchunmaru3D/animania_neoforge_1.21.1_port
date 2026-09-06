package com.animania.addons.farm.common.entity.cows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CowHereford
{
	private static final int PRIMARY = 4461056;
	private static final int SECONDARY = 15987699;

	public static class EntityCalfHereford extends EntityCalfBase
	{
		public EntityCalfHereford(EntityType<? extends EntityCalfHereford> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HEREFORD;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_hereford.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullHereford extends EntityBullBase
	{
		public EntityBullHereford(EntityType<? extends EntityBullHereford> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HEREFORD;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_hereford.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowHereford extends EntityCowBase
	{
		public EntityCowHereford(EntityType<? extends EntityCowHereford> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HEREFORD;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_hereford.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
