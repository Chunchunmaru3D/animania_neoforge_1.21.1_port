package com.animania.addons.extra.common.entity.rodents;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class EntityHedgehogAlbino extends EntityHedgehogBase
{
	public EntityHedgehogAlbino(EntityType<? extends EntityHedgehogAlbino> entityType, Level level)
	{
		super(entityType, level);
		this.type = HedgehogType.ALBINO;
		this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rodents/hedgehog_albino.png");
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 12369084;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 16777215;
	}
}
