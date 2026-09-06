package com.animania.addons.farm.common.entity.horses;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 




public class HorseDraft
{
	private static final int PRIMARY = 8600606;
	private static final int SECONDARY = 12829635;

	public static class EntityFoalDraftHorse extends EntityFoalBase
	{
		public EntityFoalDraftHorse(EntityType<? extends EntityFoalDraftHorse> entityType, Level level)
		{
			super(entityType, level);
			this.horseType = HorseType.DRAFT;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityStallionDraftHorse extends EntityStallionBase
	{
		public EntityStallionDraftHorse(EntityType<? extends EntityStallionDraftHorse> entityType, Level level)
		{
			super(entityType, level);
			this.horseType = HorseType.DRAFT;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityMareDraftHorse extends EntityMareBase
	{
		public EntityMareDraftHorse(EntityType<? extends EntityMareDraftHorse> entityType, Level level)
		{
			super(entityType, level);
			this.horseType = HorseType.DRAFT;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
