package com.animania.addons.extra.common.entity.peafowl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PeafowlOpal
{
	public static class EntityPeachickOpal extends EntityPeachickBase
	{
		public EntityPeachickOpal(EntityType<? extends EntityPeachickOpal> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.OPAL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_opal.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blink.png");
			this.lidCol = 0xA8C4C4;
		}
	}

	public static class EntityPeacockOpal extends EntityPeacockBase
	{
		public EntityPeacockOpal(EntityType<? extends EntityPeacockOpal> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.OPAL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_opal.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_opal_blink.png");
			this.lidCol = 0xA8C4C4;
		}
	}

	public static class EntityPeafowlOpal extends EntityPeafowlBase
	{
		public EntityPeafowlOpal(EntityType<? extends EntityPeafowlOpal> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.OPAL;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_opal.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blink.png");
			this.lidCol = 0xA8C4C4;
		}
	}
}
