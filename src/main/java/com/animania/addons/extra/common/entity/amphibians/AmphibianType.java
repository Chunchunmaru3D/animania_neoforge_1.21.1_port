package com.animania.addons.extra.common.entity.amphibians;

import java.util.function.Function;

import com.animania.Animania;
import com.animania.addons.extra.ExtraEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 









public enum AmphibianType implements AnimaniaType
{
	FROG(level -> new EntityFrogs(ExtraEntityTypes.FROG.get(), level)),
	DART_FROG(level -> new EntityDartFrogs(ExtraEntityTypes.DART_FROG.get(), level)),
	TOAD(level -> new EntityToad(ExtraEntityTypes.TOAD.get(), level));

	private final Function<Level, LivingEntity> factory;

	AmphibianType(Function<Level, LivingEntity> factory)
	{
		this.factory = factory;
	}

	@Override
	public LivingEntity getMale(Level level)
	{
		return this.factory.apply(level);
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
		return Animania.MODID + ":amphibians";
	}
}
