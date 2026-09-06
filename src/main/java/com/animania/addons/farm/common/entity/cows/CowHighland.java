package com.animania.addons.farm.common.entity.cows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CowHighland
{
	private static final int PRIMARY = 8340777;
	private static final int SECONDARY = 2760475;

	public static class EntityCalfHighland extends EntityCalfBase
	{
		public EntityCalfHighland(EntityType<? extends EntityCalfHighland> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HIGHLAND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_highland.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullHighland extends EntityBullBase
	{
		public EntityBullHighland(EntityType<? extends EntityBullHighland> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HIGHLAND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_highland.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowHighland extends EntityCowBase
	{
		public EntityCowHighland(EntityType<? extends EntityCowHighland> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.HIGHLAND;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_highland.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
