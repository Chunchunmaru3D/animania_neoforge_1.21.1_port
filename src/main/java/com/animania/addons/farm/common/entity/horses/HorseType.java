package com.animania.addons.farm.common.entity.horses;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 




public enum HorseType implements AnimaniaType
{
	DRAFT(() -> FarmEntityTypes.STALLION_DRAFT.get(), () -> FarmEntityTypes.MARE_DRAFT.get(), () -> FarmEntityTypes.FOAL_DRAFT.get());

	private final Supplier<EntityType<? extends EntityStallionBase>> male;
	private final Supplier<EntityType<? extends EntityMareBase>> female;
	private final Supplier<EntityType<? extends EntityFoalBase>> child;

	@SuppressWarnings("unchecked")
	HorseType(Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.male = () -> (EntityType<? extends EntityStallionBase>) male.get();
		this.female = () -> (EntityType<? extends EntityMareBase>) female.get();
		this.child = () -> (EntityType<? extends EntityFoalBase>) child.get();
	}

	@Override
	public LivingEntity getMale(Level level)
	{
		return this.male.get().create(level);
	}

	@Override
	public LivingEntity getFemale(Level level)
	{
		return this.female.get().create(level);
	}

	@Override
	public LivingEntity getChild(Level level)
	{
		return this.child.get().create(level);
	}

	@Override
	public String getTypeName()
	{
		return "animania:horse";
	}

	public static HorseType breed(HorseType male, HorseType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
