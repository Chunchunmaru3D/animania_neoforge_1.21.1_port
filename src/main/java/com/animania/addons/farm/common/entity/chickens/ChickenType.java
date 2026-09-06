package com.animania.addons.farm.common.entity.chickens;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 






public enum ChickenType implements AnimaniaType
{
	LEGHORN(false, () -> FarmEntityTypes.ROOSTER_LEGHORN.get(), () -> FarmEntityTypes.HEN_LEGHORN.get(), () -> FarmEntityTypes.CHICK_LEGHORN.get()),
	ORPINGTON(true, () -> FarmEntityTypes.ROOSTER_ORPINGTON.get(), () -> FarmEntityTypes.HEN_ORPINGTON.get(), () -> FarmEntityTypes.CHICK_ORPINGTON.get()),
	PLYMOUTH_ROCK(true, () -> FarmEntityTypes.ROOSTER_PLYMOUTH_ROCK.get(), () -> FarmEntityTypes.HEN_PLYMOUTH_ROCK.get(), () -> FarmEntityTypes.CHICK_PLYMOUTH_ROCK.get()),
	RHODE_ISLAND_RED(true, () -> FarmEntityTypes.ROOSTER_RHODE_ISLAND_RED.get(), () -> FarmEntityTypes.HEN_RHODE_ISLAND_RED.get(), () -> FarmEntityTypes.CHICK_RHODE_ISLAND_RED.get()),
	WYANDOTTE(true, () -> FarmEntityTypes.ROOSTER_WYANDOTTE.get(), () -> FarmEntityTypes.HEN_WYANDOTTE.get(), () -> FarmEntityTypes.CHICK_WYANDOTTE.get());

	private final boolean isPrime;
	private final Supplier<EntityType<? extends EntityRoosterBase>> male;
	private final Supplier<EntityType<? extends EntityHenBase>> female;
	private final Supplier<EntityType<? extends EntityChickBase>> child;

	@SuppressWarnings("unchecked")
	ChickenType(boolean isPrime, Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.isPrime = isPrime;
		this.male = () -> (EntityType<? extends EntityRoosterBase>) male.get();
		this.female = () -> (EntityType<? extends EntityHenBase>) female.get();
		this.child = () -> (EntityType<? extends EntityChickBase>) child.get();
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
		return "animania:chicken";
	}

	 


	public static ChickenType breed(ChickenType mother, ChickenType father)
	{
		return Animania.RANDOM.nextBoolean() ? mother : father;
	}
}
