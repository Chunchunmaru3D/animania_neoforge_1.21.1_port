package com.animania.addons.farm.common.entity.goats;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum GoatType implements AnimaniaType
{
	ALPINE(true, () -> FarmEntityTypes.BUCK_ALPINE.get(), () -> FarmEntityTypes.DOE_ALPINE.get(), () -> FarmEntityTypes.KID_ALPINE.get()),
	ANGORA(false, () -> FarmEntityTypes.BUCK_ANGORA.get(), () -> FarmEntityTypes.DOE_ANGORA.get(), () -> FarmEntityTypes.KID_ANGORA.get()),
	FAINTING(false, () -> FarmEntityTypes.BUCK_FAINTING.get(), () -> FarmEntityTypes.DOE_FAINTING.get(), () -> FarmEntityTypes.KID_FAINTING.get()),
	KIKO(true, () -> FarmEntityTypes.BUCK_KIKO.get(), () -> FarmEntityTypes.DOE_KIKO.get(), () -> FarmEntityTypes.KID_KIKO.get()),
	KINDER(false, () -> FarmEntityTypes.BUCK_KINDER.get(), () -> FarmEntityTypes.DOE_KINDER.get(), () -> FarmEntityTypes.KID_KINDER.get()),
	NIGERIAN_DWARF(false, () -> FarmEntityTypes.BUCK_NIGERIAN_DWARF.get(), () -> FarmEntityTypes.DOE_NIGERIAN_DWARF.get(), () -> FarmEntityTypes.KID_NIGERIAN_DWARF.get()),
	PYGMY(true, () -> FarmEntityTypes.BUCK_PYGMY.get(), () -> FarmEntityTypes.DOE_PYGMY.get(), () -> FarmEntityTypes.KID_PYGMY.get());

	private final boolean isPrime;
	private final Supplier<EntityType<? extends EntityBuckBase>> male;
	private final Supplier<EntityType<? extends EntityDoeBase>> female;
	private final Supplier<EntityType<? extends EntityKidBase>> child;

	@SuppressWarnings("unchecked")
	GoatType(boolean isPrime, Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.isPrime = isPrime;
		this.male = () -> (EntityType<? extends EntityBuckBase>) male.get();
		this.female = () -> (EntityType<? extends EntityDoeBase>) female.get();
		this.child = () -> (EntityType<? extends EntityKidBase>) child.get();
	}

	public boolean isPrime()
	{
		return this.isPrime;
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
		return "animania:goat";
	}

	public static GoatType breed(GoatType male, GoatType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
