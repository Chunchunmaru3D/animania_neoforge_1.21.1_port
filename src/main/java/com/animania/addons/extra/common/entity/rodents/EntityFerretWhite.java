package com.animania.addons.extra.common.entity.rodents;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class EntityFerretWhite extends EntityFerretBase
{
	public EntityFerretWhite(EntityType<? extends EntityFerretWhite> entityType, Level level)
	{
		super(entityType, level);
		this.type = FerretType.WHITE;
		this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rodents/ferret_white.png");
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 15921906;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 13554152;
	}
}
