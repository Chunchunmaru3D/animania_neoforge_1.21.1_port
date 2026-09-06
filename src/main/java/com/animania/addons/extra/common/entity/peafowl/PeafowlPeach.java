package com.animania.addons.extra.common.entity.peafowl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class PeafowlPeach
{
	public static class EntityPeachickPeach extends EntityPeachickBase
	{
		public EntityPeachickPeach(EntityType<? extends EntityPeachickPeach> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.PEACH;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_peach.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peachick_blink.png");
			this.lidCol = 0xE8A87C;
		}
	}

	public static class EntityPeacockPeach extends EntityPeacockBase
	{
		public EntityPeacockPeach(EntityType<? extends EntityPeacockPeach> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.PEACH;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_peach.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peacock_peach_blink.png");
			this.lidCol = 0xE8A87C;
		}
	}

	public static class EntityPeafowlPeach extends EntityPeafowlBase
	{
		public EntityPeafowlPeach(EntityType<? extends EntityPeafowlPeach> entityType, Level level)
		{
			super(entityType, level);
			this.type = PeacockType.PEACH;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_peach.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/peacocks/peahen_blink.png");
			this.lidCol = 0xE8A87C;
		}
	}
}
