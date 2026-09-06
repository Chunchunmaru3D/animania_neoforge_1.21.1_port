package com.animania.addons.extra.common.entity.peafowl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PeafowlPurple
{
	public static class EntityPeachickPurple extends EntityPeachickBase
	{
		public EntityPeachickPurple(EntityType<? extends EntityPeachickPurple> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.PURPLE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_purple.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blink.png");
			this.lidCol = 0x6A3E82;
		}
	}

	public static class EntityPeacockPurple extends EntityPeacockBase
	{
		public EntityPeacockPurple(EntityType<? extends EntityPeacockPurple> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.PURPLE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_purple.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_purple_blink.png");
			this.lidCol = 0x6A3E82;
		}
	}

	public static class EntityPeafowlPurple extends EntityPeafowlBase
	{
		public EntityPeafowlPurple(EntityType<? extends EntityPeafowlPurple> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.PURPLE;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_purple.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blink.png");
			this.lidCol = 0x6A3E82;
		}
	}
}
