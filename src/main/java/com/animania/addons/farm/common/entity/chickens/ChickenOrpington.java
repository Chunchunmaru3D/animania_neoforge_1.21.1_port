package com.animania.addons.farm.common.entity.chickens;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class ChickenOrpington
{
	public static class EntityChickOrpington extends EntityChickBase
	{
		public EntityChickOrpington(EntityType<? extends EntityChickOrpington> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.ORPINGTON;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_golden.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_blink_left.png");
			this.lidCol = 0xF6C132;
		}
	}

	public static class EntityRoosterOrpington extends EntityRoosterBase
	{
		public EntityRoosterOrpington(EntityType<? extends EntityRoosterOrpington> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.ORPINGTON;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/rooster_golden.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0xCD902F;
		}
	}

	public static class EntityHenOrpington extends EntityHenBase
	{
		public EntityHenOrpington(EntityType<? extends EntityHenOrpington> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.ORPINGTON;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/hen_golden.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0xCD902F;
		}
	}
}
