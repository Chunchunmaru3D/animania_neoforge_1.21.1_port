package com.animania.addons.catsdogs.common.entity.felids;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.catsdogs.CatsDogsEntityTypes;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

 


public enum CatType implements AnimaniaType
{
	AMERICAN_SHORTHAIR(() -> CatsDogsEntityTypes.CAT_TOM_AMERICAN_SHORTHAIR.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_AMERICAN_SHORTHAIR.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_AMERICAN_SHORTHAIR.get()),
	ASIATIC(() -> CatsDogsEntityTypes.CAT_TOM_ASIATIC.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_ASIATIC.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_ASIATIC.get()),
	EXOTIC(() -> CatsDogsEntityTypes.CAT_TOM_EXOTIC.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_EXOTIC.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_EXOTIC.get()),
	NORWEGIAN(() -> CatsDogsEntityTypes.CAT_TOM_NORWEGIAN.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_NORWEGIAN.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_NORWEGIAN.get()),
	OCELOT(() -> CatsDogsEntityTypes.CAT_TOM_OCELOT.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_OCELOT.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_OCELOT.get()),
	RAGDOLL(() -> CatsDogsEntityTypes.CAT_TOM_RAGDOLL.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_RAGDOLL.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_RAGDOLL.get()),
	SIAMESE(() -> CatsDogsEntityTypes.CAT_TOM_SIAMESE.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_SIAMESE.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_SIAMESE.get()),
	TABBY(() -> CatsDogsEntityTypes.CAT_TOM_TABBY.get(), () -> CatsDogsEntityTypes.CAT_QUEEN_TABBY.get(), () -> CatsDogsEntityTypes.CAT_KITTEN_TABBY.get());

	private final Supplier<EntityType<? extends EntityTomBase>> male;
	private final Supplier<EntityType<? extends EntityQueenBase>> female;
	private final Supplier<EntityType<? extends EntityKittenBase>> child;

	@SuppressWarnings("unchecked")
	CatType(Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child)
	{
		this.male = () -> (EntityType<? extends EntityTomBase>) male.get();
		this.female = () -> (EntityType<? extends EntityQueenBase>) female.get();
		this.child = () -> (EntityType<? extends EntityKittenBase>) child.get();
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
		return Animania.MODID + ":cat";
	}

	public static CatType breed(CatType male, CatType female)
	{
		return Animania.RANDOM.nextBoolean() ? male : female;
	}
}
