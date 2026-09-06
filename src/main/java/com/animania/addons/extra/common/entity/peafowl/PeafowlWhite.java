package com.animania.addons.extra.common.entity.peafowl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PeafowlWhite
{
	public static class EntityPeachickWhite extends EntityPeachickBase
	{
		public EntityPeachickWhite(EntityType<? extends EntityPeachickWhite> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.WHITE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blink.png");
			this.lidCol = 0xF2F2F2;
		}
	}

	public static class EntityPeacockWhite extends EntityPeacockBase
	{
		public EntityPeacockWhite(EntityType<? extends EntityPeacockWhite> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.WHITE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_white_blink.png");
			this.lidCol = 0xF2F2F2;
		}
	}

	public static class EntityPeafowlWhite extends EntityPeafowlBase
	{
		public EntityPeafowlWhite(EntityType<? extends EntityPeafowlWhite> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.WHITE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_white.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blink.png");
			this.lidCol = 0xF2F2F2;
		}
	}
}
