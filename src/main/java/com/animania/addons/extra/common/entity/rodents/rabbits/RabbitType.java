package com.animania.addons.extra.common.entity.rodents.rabbits;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.extra.ExtraEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 




public enum RabbitType implements AnimaniaType
{
	LOP(false, () -> ExtraEntityTypes.RABBIT_BUCK_LOP.get(), () -> ExtraEntityTypes.RABBIT_DOE_LOP.get(), () -> ExtraEntityTypes.RABBIT_KIT_LOP.get()),
	REX(true, () -> ExtraEntityTypes.RABBIT_BUCK_REX.get(), () -> ExtraEntityTypes.RABBIT_DOE_REX.get(), () -> ExtraEntityTypes.RABBIT_KIT_REX.get()),
	DUTCH(false, () -> ExtraEntityTypes.RABBIT_BUCK_DUTCH.get(), () -> ExtraEntityTypes.RABBIT_DOE_DUTCH.get(), () -> ExtraEntityTypes.RABBIT_KIT_DUTCH.get()),
	HAVANA(false, () -> ExtraEntityTypes.RABBIT_BUCK_HAVANA.get(), () -> ExtraEntityTypes.RABBIT_DOE_HAVANA.get(), () -> ExtraEntityTypes.RABBIT_KIT_HAVANA.get()),
	NEW_ZEALAND(true, () -> ExtraEntityTypes.RABBIT_BUCK_NEW_ZEALAND.get(), () -> ExtraEntityTypes.RABBIT_DOE_NEW_ZEALAND.get(), () -> ExtraEntityTypes.RABBIT_KIT_NEW_ZEALAND.get()),
	JACK(false, () -> ExtraEntityTypes.RABBIT_BUCK_JACK.get(), () -> ExtraEntityTypes.RABBIT_DOE_JACK.get(), () -> ExtraEntityTypes.RABBIT_KIT_JACK.get()),
	COTTONTAIL(false, () -> ExtraEntityTypes.RABBIT_BUCK_COTTONTAIL.get(), () -> ExtraEntityTypes.RABBIT_DOE_COTTONTAIL.get(), () -> ExtraEntityTypes.RABBIT_KIT_COTTONTAIL.get()),
	CHINCHILLA(true, () -> ExtraEntityTypes.RABBIT_BUCK_CHINCHILLA.get(), () -> ExtraEntityTypes.RABBIT_DOE_CHINCHILLA.get(), () -> ExtraEntityTypes.RABBIT_KIT_CHINCHILLA.get());

	private final boolean isPrime;
	private final Supplier<EntityType<? extends EntityRabbitBuckBase>> male;
	private final Supplier<EntityType<? extends EntityRabbitDoeBase>> female;
	private final Supplier<EntityType<? extends EntityRabbitKitBase>> child;

	@SuppressWarnings("unchecked")
	RabbitType(boolean isPrime, Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.isPrime = isPrime;
		this.male = () -> (EntityType<? extends EntityRabbitBuckBase>) male.get();
		this.female = () -> (EntityType<? extends EntityRabbitDoeBase>) female.get();
		this.child = () -> (EntityType<? extends EntityRabbitKitBase>) child.get();
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
		return Animania.MODID + ":rabbit";
	}

	public static RabbitType breed(RabbitType male, RabbitType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
