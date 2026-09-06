package com.animania.addons.catsdogs.common.entity.canids;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.catsdogs.CatsDogsEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum DogType implements AnimaniaType
{
	BLOODHOUND(() -> CatsDogsEntityTypes.DOG_MALE_BLOODHOUND.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_BLOODHOUND.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_BLOODHOUND.get()),
	CHIHUAHUA(() -> CatsDogsEntityTypes.DOG_MALE_CHIHUAHUA.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_CHIHUAHUA.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_CHIHUAHUA.get()),
	COLLIE(() -> CatsDogsEntityTypes.DOG_MALE_COLLIE.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_COLLIE.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_COLLIE.get()),
	CORGI(() -> CatsDogsEntityTypes.DOG_MALE_CORGI.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_CORGI.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_CORGI.get()),
	DACHSHUND(() -> CatsDogsEntityTypes.DOG_MALE_DACHSHUND.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_DACHSHUND.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_DACHSHUND.get()),
	FOX(() -> CatsDogsEntityTypes.DOG_MALE_FOX.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_FOX.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_FOX.get()),
	GERMAN_SHEPHERD(() -> CatsDogsEntityTypes.DOG_MALE_GERMAN_SHEPHERD.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_GERMAN_SHEPHERD.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_GERMAN_SHEPHERD.get()),
	GREAT_DANE(() -> CatsDogsEntityTypes.DOG_MALE_GREAT_DANE.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_GREAT_DANE.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_GREAT_DANE.get()),
	GREYHOUND(() -> CatsDogsEntityTypes.DOG_MALE_GREYHOUND.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_GREYHOUND.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_GREYHOUND.get()),
	HUSKY(() -> CatsDogsEntityTypes.DOG_MALE_HUSKY.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_HUSKY.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_HUSKY.get()),
	LABRADOR(() -> CatsDogsEntityTypes.DOG_MALE_LABRADOR.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_LABRADOR.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_LABRADOR.get()),
	POMERANIAN(() -> CatsDogsEntityTypes.DOG_MALE_POMERANIAN.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_POMERANIAN.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_POMERANIAN.get()),
	POODLE(() -> CatsDogsEntityTypes.DOG_MALE_POODLE.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_POODLE.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_POODLE.get()),
	PUG(() -> CatsDogsEntityTypes.DOG_MALE_PUG.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_PUG.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_PUG.get()),
	WOLF(() -> CatsDogsEntityTypes.DOG_MALE_WOLF.get(), () -> CatsDogsEntityTypes.DOG_FEMALE_WOLF.get(), () -> CatsDogsEntityTypes.DOG_PUPPY_WOLF.get());

	private final Supplier<EntityType<? extends EntityMaleDogBase>> male;
	private final Supplier<EntityType<? extends EntityFemaleDogBase>> female;
	private final Supplier<EntityType<? extends EntityPuppyBase>> child;

	@SuppressWarnings("unchecked")
	DogType(Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.male = () -> (EntityType<? extends EntityMaleDogBase>) male.get();
		this.female = () -> (EntityType<? extends EntityFemaleDogBase>) female.get();
		this.child = () -> (EntityType<? extends EntityPuppyBase>) child.get();
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
		return Animania.MODID + ":dog";
	}

	public static DogType breed(DogType male, DogType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
