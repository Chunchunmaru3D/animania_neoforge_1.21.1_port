package com.animania.addons.farm.common.entity.cows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class CowJersey
{
	private static final int PRIMARY = 12089918;
	private static final int SECONDARY = 16775643;

	public static class EntityCalfJersey extends EntityCalfBase
	{
		public EntityCalfJersey(EntityType<? extends EntityCalfJersey> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.JERSEY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_jersey.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullJersey extends EntityBullBase
	{
		public EntityBullJersey(EntityType<? extends EntityBullJersey> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.JERSEY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_jersey.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowJersey extends EntityCowBase
	{
		public EntityCowJersey(EntityType<? extends EntityCowJersey> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.JERSEY;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_jersey.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
