package com.animania.addons.farm.common.entity.chickens;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class ChickenPlymouthRock
{
	public static class EntityChickPlymouthRock extends EntityChickBase
	{
		public EntityChickPlymouthRock(EntityType<? extends EntityChickPlymouthRock> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.PLYMOUTH_ROCK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_specked.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chick_blink_left.png");
			this.lidCol = 0xD2D7E2;
		}
	}

	public static class EntityRoosterPlymouthRock extends EntityRoosterBase
	{
		public EntityRoosterPlymouthRock(EntityType<? extends EntityRoosterPlymouthRock> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.PLYMOUTH_ROCK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/rooster_specked.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0xA29497;
		}
	}

	public static class EntityHenPlymouthRock extends EntityHenBase
	{
		public EntityHenPlymouthRock(EntityType<? extends EntityHenPlymouthRock> entityType, Level level)
		{
			super(entityType, level);
			this.type = ChickenType.PLYMOUTH_ROCK;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/hen_specked.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/chickens/chicken_blink_left.png");
			this.lidCol = 0xA29497;
		}
	}
}
