package com.animania.addons.extra.common.entity.rodents;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.extra.ExtraEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum HedgehogType implements AnimaniaType
{
	NORMAL(() -> ExtraEntityTypes.HEDGEHOG.get()),
	ALBINO(() -> ExtraEntityTypes.HEDGEHOG_ALBINO.get());

	private final Supplier<EntityType<? extends EntityHedgehogBase>> male;

	HedgehogType(Supplier<EntityType<? extends EntityHedgehogBase>> male)
	{
		this.male = male;
	}

	@Override
	public LivingEntity getMale(Level level)
	{
		return this.male.get().create(level);
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
		return Animania.MODID + ":hedgehog";
	}
}
