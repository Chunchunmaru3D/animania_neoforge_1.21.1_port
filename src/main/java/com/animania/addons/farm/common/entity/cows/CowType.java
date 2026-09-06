package com.animania.addons.farm.common.entity.cows;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum CowType implements AnimaniaType
{
	ANGUS(true, () -> FarmEntityTypes.BULL_ANGUS.get(), () -> FarmEntityTypes.COW_ANGUS.get(), () -> FarmEntityTypes.CALF_ANGUS.get()),
	FRIESIAN(false, () -> FarmEntityTypes.BULL_FRIESIAN.get(), () -> FarmEntityTypes.COW_FRIESIAN.get(), () -> FarmEntityTypes.CALF_FRIESIAN.get()),
	HEREFORD(true, () -> FarmEntityTypes.BULL_HEREFORD.get(), () -> FarmEntityTypes.COW_HEREFORD.get(), () -> FarmEntityTypes.CALF_HEREFORD.get()),
	HOLSTEIN(false, () -> FarmEntityTypes.BULL_HOLSTEIN.get(), () -> FarmEntityTypes.COW_HOLSTEIN.get(), () -> FarmEntityTypes.CALF_HOLSTEIN.get()),
	LONGHORN(true, () -> FarmEntityTypes.BULL_LONGHORN.get(), () -> FarmEntityTypes.COW_LONGHORN.get(), () -> FarmEntityTypes.CALF_LONGHORN.get()),
	HIGHLAND(true, () -> FarmEntityTypes.BULL_HIGHLAND.get(), () -> FarmEntityTypes.COW_HIGHLAND.get(), () -> FarmEntityTypes.CALF_HIGHLAND.get()),
	JERSEY(true, () -> FarmEntityTypes.BULL_JERSEY.get(), () -> FarmEntityTypes.COW_JERSEY.get(), () -> FarmEntityTypes.CALF_JERSEY.get()),
	MOOSHROOM(true, () -> FarmEntityTypes.BULL_MOOSHROOM.get(), () -> FarmEntityTypes.COW_MOOSHROOM.get(), () -> FarmEntityTypes.CALF_MOOSHROOM.get());

	private final boolean isPrime;
	private final Supplier<EntityType<? extends EntityBullBase>> male;
	private final Supplier<EntityType<? extends EntityCowBase>> female;
	private final Supplier<EntityType<? extends EntityCalfBase>> child;

	@SuppressWarnings("unchecked")
	CowType(boolean isPrime, Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.isPrime = isPrime;
		this.male = () -> (EntityType<? extends EntityBullBase>) male.get();
		this.female = () -> (EntityType<? extends EntityCowBase>) female.get();
		this.child = () -> (EntityType<? extends EntityCalfBase>) child.get();
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
		return "animania:cow";
	}

	public static CowType breed(CowType male, CowType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
