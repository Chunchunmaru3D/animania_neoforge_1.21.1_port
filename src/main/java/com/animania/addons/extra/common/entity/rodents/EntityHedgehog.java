package com.animania.addons.extra.common.entity.rodents;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class EntityHedgehog extends EntityHedgehogBase
{
	public EntityHedgehog(EntityType<? extends EntityHedgehog> entityType, Level level)
	{
		super(entityType, level);
		this.type = HedgehogType.NORMAL;
		this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rodents/hedgehog.png");
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 10451558;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 14337943;
	}
}
