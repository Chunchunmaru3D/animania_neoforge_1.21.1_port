package com.animania.addons.farm.common.entity.sheep;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum SheepType implements AnimaniaType
{
	DORPER(true, () -> FarmEntityTypes.RAM_DORPER.get(), () -> FarmEntityTypes.EWE_DORPER.get(), () -> FarmEntityTypes.LAMB_DORPER.get()),
	DORSET(true, () -> FarmEntityTypes.RAM_DORSET.get(), () -> FarmEntityTypes.EWE_DORSET.get(), () -> FarmEntityTypes.LAMB_DORSET.get()),
	FRIESIAN(false, () -> FarmEntityTypes.RAM_FRIESIAN.get(), () -> FarmEntityTypes.EWE_FRIESIAN.get(), () -> FarmEntityTypes.LAMB_FRIESIAN.get()),
	JACOB(false, () -> FarmEntityTypes.RAM_JACOB.get(), () -> FarmEntityTypes.EWE_JACOB.get(), () -> FarmEntityTypes.LAMB_JACOB.get()),
	MERINO(false, () -> FarmEntityTypes.RAM_MERINO.get(), () -> FarmEntityTypes.EWE_MERINO.get(), () -> FarmEntityTypes.LAMB_MERINO.get()),
	SUFFOLK(true, () -> FarmEntityTypes.RAM_SUFFOLK.get(), () -> FarmEntityTypes.EWE_SUFFOLK.get(), () -> FarmEntityTypes.LAMB_SUFFOLK.get());

	private final boolean isPrime;
	private final Supplier<EntityType<? extends EntityRamBase>> male;
	private final Supplier<EntityType<? extends EntityEweBase>> female;
	private final Supplier<EntityType<? extends EntityLambBase>> child;

	@SuppressWarnings("unchecked")
	SheepType(boolean isPrime, Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.isPrime = isPrime;
		this.male = () -> (EntityType<? extends EntityRamBase>) male.get();
		this.female = () -> (EntityType<? extends EntityEweBase>) female.get();
		this.child = () -> (EntityType<? extends EntityLambBase>) child.get();
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
		return "animania:sheep";
	}

	public static SheepType breed(SheepType male, SheepType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
