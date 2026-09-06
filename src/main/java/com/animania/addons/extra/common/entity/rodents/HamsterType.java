package com.animania.addons.extra.common.entity.rodents;

import com.animania.Animania;
import com.animania.addons.extra.ExtraEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum HamsterType implements AnimaniaType
{
	STANDARD;

	@Override
	public LivingEntity getMale(Level level)
	{
		return ExtraEntityTypes.HAMSTER.get().create(level);
	}

	@Override
	public LivingEntity getFemale(Level level)
	{
		return null;
	}

	@Override
	public LivingEntity getChild(Level level)
	{
		return null;
	}

	@Override
	public String getTypeName()
	{
		return Animania.MODID + ":hamster";
	}
}
