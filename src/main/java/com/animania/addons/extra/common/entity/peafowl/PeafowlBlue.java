package com.animania.addons.extra.common.entity.peafowl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PeafowlBlue
{
	public static class EntityPeachickBlue extends EntityPeachickBase
	{
		public EntityPeachickBlue(EntityType<? extends EntityPeachickBlue> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.BLUE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blue.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blink.png");
			this.lidCol = 0x3C6E9E;
		}
	}

	public static class EntityPeacockBlue extends EntityPeacockBase
	{
		public EntityPeacockBlue(EntityType<? extends EntityPeacockBlue> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.BLUE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_blue.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_blue_blink.png");
			this.lidCol = 0x3C6E9E;
		}
	}

	public static class EntityPeafowlBlue extends EntityPeafowlBase
	{
		public EntityPeafowlBlue(EntityType<? extends EntityPeafowlBlue> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.BLUE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blue.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blink.png");
			this.lidCol = 0x3C6E9E;
		}
	}
}
