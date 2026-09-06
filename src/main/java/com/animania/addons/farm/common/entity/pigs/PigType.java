package com.animania.addons.farm.common.entity.pigs;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum PigType implements AnimaniaType
{
	DUROC(true, () -> FarmEntityTypes.HOG_DUROC.get(), () -> FarmEntityTypes.SOW_DUROC.get(), () -> FarmEntityTypes.PIGLET_DUROC.get()),
	HAMPSHIRE(true, () -> FarmEntityTypes.HOG_HAMPSHIRE.get(), () -> FarmEntityTypes.SOW_HAMPSHIRE.get(), () -> FarmEntityTypes.PIGLET_HAMPSHIRE.get()),
	LARGE_BLACK(true, () -> FarmEntityTypes.HOG_LARGE_BLACK.get(), () -> FarmEntityTypes.SOW_LARGE_BLACK.get(), () -> FarmEntityTypes.PIGLET_LARGE_BLACK.get()),
	LARGE_WHITE(false, () -> FarmEntityTypes.HOG_LARGE_WHITE.get(), () -> FarmEntityTypes.SOW_LARGE_WHITE.get(), () -> FarmEntityTypes.PIGLET_LARGE_WHITE.get()),
	OLD_SPOT(true, () -> FarmEntityTypes.HOG_OLD_SPOT.get(), () -> FarmEntityTypes.SOW_OLD_SPOT.get(), () -> FarmEntityTypes.PIGLET_OLD_SPOT.get()),
	YORKSHIRE(false, () -> FarmEntityTypes.HOG_YORKSHIRE.get(), () -> FarmEntityTypes.SOW_YORKSHIRE.get(), () -> FarmEntityTypes.PIGLET_YORKSHIRE.get());

	private final boolean isPrime;
	private final Supplier<EntityType<? extends EntityHogBase>> male;
	private final Supplier<EntityType<? extends EntitySowBase>> female;
	private final Supplier<EntityType<? extends EntityPigletBase>> child;

	@SuppressWarnings("unchecked")
	PigType(boolean isPrime, Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.isPrime = isPrime;
		this.male = () -> (EntityType<? extends EntityHogBase>) male.get();
		this.female = () -> (EntityType<? extends EntitySowBase>) female.get();
		this.child = () -> (EntityType<? extends EntityPigletBase>) child.get();
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
		return "animania:pig";
	}

	public static PigType breed(PigType male, PigType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
