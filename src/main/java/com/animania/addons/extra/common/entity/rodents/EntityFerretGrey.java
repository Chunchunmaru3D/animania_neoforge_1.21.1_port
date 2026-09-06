package com.animania.addons.extra.common.entity.rodents;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 


public class EntityFerretGrey extends EntityFerretBase
{
	public EntityFerretGrey(EntityType<? extends EntityFerretGrey> entityType, Level level)
	{
		super(entityType, level);
		this.type = FerretType.GREY;
		this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/rodents/ferret_grey.png");
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 13948116;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 8741209;
	}
}
