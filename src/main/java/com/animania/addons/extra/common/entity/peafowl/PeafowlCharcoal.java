package com.animania.addons.extra.common.entity.peafowl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PeafowlCharcoal
{
	public static class EntityPeachickCharcoal extends EntityPeachickBase
	{
		public EntityPeachickCharcoal(EntityType<? extends EntityPeachickCharcoal> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.CHARCOAL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_charcoal.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blink.png");
			this.lidCol = 0x3A3A3A;
		}
	}

	public static class EntityPeacockCharcoal extends EntityPeacockBase
	{
		public EntityPeacockCharcoal(EntityType<? extends EntityPeacockCharcoal> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.CHARCOAL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_charcoal.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_charcoal_blink.png");
			this.lidCol = 0x3A3A3A;
		}
	}

	public static class EntityPeafowlCharcoal extends EntityPeafowlBase
	{
		public EntityPeafowlCharcoal(EntityType<? extends EntityPeafowlCharcoal> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.CHARCOAL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_charcoal.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blink.png");
			this.lidCol = 0x3A3A3A;
		}
	}
}
