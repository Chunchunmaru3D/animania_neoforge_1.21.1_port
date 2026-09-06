package com.animania.addons.farm.common.entity.chickens;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class ChickenLeghorn
{
	public static class EntityChickLeghorn extends EntityChickBase
	{
		public EntityChickLeghorn(EntityType<? extends EntityChickLeghorn> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.LEGHORN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_blink_left.png");
			this.lidCol = 0xFACA65;
		}
	}

	public static class EntityRoosterLeghorn extends EntityRoosterBase
	{
		public EntityRoosterLeghorn(EntityType<? extends EntityRoosterLeghorn> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.LEGHORN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/rooster_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}
	}

	public static class EntityHenLeghorn extends EntityHenBase
	{
		public EntityHenLeghorn(EntityType<? extends EntityHenLeghorn> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.LEGHORN;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/hen_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}
	}
}
