package com.animania.addons.farm.common.entity.chickens;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class ChickenWyandotte
{
	public static class EntityChickWyandotte extends EntityChickBase
	{
		public EntityChickWyandotte(EntityType<? extends EntityChickWyandotte> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.WYANDOTTE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_brown.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_blink_left.png");
			this.lidCol = 0x492A1E;
		}
	}

	public static class EntityRoosterWyandotte extends EntityRoosterBase
	{
		public EntityRoosterWyandotte(EntityType<? extends EntityRoosterWyandotte> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.WYANDOTTE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/rooster_brown.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0x362018;
		}
	}

	public static class EntityHenWyandotte extends EntityHenBase
	{
		public EntityHenWyandotte(EntityType<? extends EntityHenWyandotte> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.WYANDOTTE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/hen_brown.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0x362018;
		}
	}
}
