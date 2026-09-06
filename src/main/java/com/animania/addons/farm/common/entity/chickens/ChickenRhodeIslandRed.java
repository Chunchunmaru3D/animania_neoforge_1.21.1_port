package com.animania.addons.farm.common.entity.chickens;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class ChickenRhodeIslandRed
{
	public static class EntityChickRhodeIslandRed extends EntityChickBase
	{
		public EntityChickRhodeIslandRed(EntityType<? extends EntityChickRhodeIslandRed> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.RHODE_ISLAND_RED;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_red.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_blink_left.png");
			this.lidCol = 0xF6C132;
		}
	}

	public static class EntityRoosterRhodeIslandRed extends EntityRoosterBase
	{
		public EntityRoosterRhodeIslandRed(EntityType<? extends EntityRoosterRhodeIslandRed> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.RHODE_ISLAND_RED;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/rooster_red.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0x9F4931;
		}
	}

	public static class EntityHenRhodeIslandRed extends EntityHenBase
	{
		public EntityHenRhodeIslandRed(EntityType<? extends EntityHenRhodeIslandRed> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.RHODE_ISLAND_RED;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/hen_red.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0x9F4931;
		}
	}
}
