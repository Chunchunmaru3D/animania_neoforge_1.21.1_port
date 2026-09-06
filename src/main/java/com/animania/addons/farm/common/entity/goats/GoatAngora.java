package com.animania.addons.farm.common.entity.goats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 



public class GoatAngora
{
	private static final int PRIMARY = 13814191;
	private static final int SECONDARY = 16776179;

	public static class EntityKidAngora extends EntityKidBase
	{
		public EntityKidAngora(EntityType<? extends EntityKidAngora> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.ANGORA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/kid_angora.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/angora_blink_left.png");
			this.lidCol = 0xCAC4B7;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBuckAngora extends EntityBuckBase
	{
		public EntityBuckAngora(EntityType<? extends EntityBuckAngora> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.ANGORA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_angora.png");
			this.resourceLocationSheared = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_angora_sheared.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/angora_blink_left.png");
			this.lidCol = 0xCAC4B7;
		}

		@Override
		protected boolean isShearable() { return true; }

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityDoeAngora extends EntityDoeBase
	{
		public EntityDoeAngora(EntityType<? extends EntityDoeAngora> entityType, Level level)
		{
			super(entityType, level);
			this.goatType = GoatType.ANGORA;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/doe_angora.png");
			 
			 
			 
			 
			 
			this.resourceLocationSheared = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/buck_angora_sheared.png");
			 
			 
			 
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/goats/angora_blink_left.png");
			this.lidCol = 0xCAC4B7;
		}

		@Override
		protected boolean isShearable() { return true; }

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
