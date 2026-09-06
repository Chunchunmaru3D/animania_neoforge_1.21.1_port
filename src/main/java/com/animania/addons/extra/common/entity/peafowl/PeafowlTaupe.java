package com.animania.addons.extra.common.entity.peafowl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PeafowlTaupe
{
	public static class EntityPeachickTaupe extends EntityPeachickBase
	{
		public EntityPeachickTaupe(EntityType<? extends EntityPeachickTaupe> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.TAUPE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_taupe.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blink.png");
			this.lidCol = 0x8B7B6E;
		}
	}

	public static class EntityPeacockTaupe extends EntityPeacockBase
	{
		public EntityPeacockTaupe(EntityType<? extends EntityPeacockTaupe> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.TAUPE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_taupe.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_taupe_blink.png");
			this.lidCol = 0x8B7B6E;
		}
	}

	public static class EntityPeafowlTaupe extends EntityPeafowlBase
	{
		public EntityPeafowlTaupe(EntityType<? extends EntityPeafowlTaupe> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.TAUPE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_taupe.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blink.png");
			this.lidCol = 0x8B7B6E;
		}
	}
}
