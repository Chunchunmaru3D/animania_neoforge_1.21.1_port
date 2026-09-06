package com.animania.addons.catsdogs;

import com.animania.Animania;
import com.animania.addons.catsdogs.common.entity.canids.DogBloodhound.EntityFemaleBloodhound;
import com.animania.addons.catsdogs.common.entity.canids.DogBloodhound.EntityMaleBloodhound;
import com.animania.addons.catsdogs.common.entity.canids.DogBloodhound.EntityPuppyBloodhound;
import com.animania.addons.catsdogs.common.entity.canids.DogChihuahua.EntityFemaleChihuahua;
import com.animania.addons.catsdogs.common.entity.canids.DogChihuahua.EntityMaleChihuahua;
import com.animania.addons.catsdogs.common.entity.canids.DogChihuahua.EntityPuppyChihuahua;
import com.animania.addons.catsdogs.common.entity.canids.DogCollie.EntityFemaleCollie;
import com.animania.addons.catsdogs.common.entity.canids.DogCollie.EntityMaleCollie;
import com.animania.addons.catsdogs.common.entity.canids.DogCollie.EntityPuppyCollie;
import com.animania.addons.catsdogs.common.entity.canids.DogCorgi.EntityFemaleCorgi;
import com.animania.addons.catsdogs.common.entity.canids.DogCorgi.EntityMaleCorgi;
import com.animania.addons.catsdogs.common.entity.canids.DogCorgi.EntityPuppyCorgi;
import com.animania.addons.catsdogs.common.entity.canids.DogDachshund.EntityFemaleDachshund;
import com.animania.addons.catsdogs.common.entity.canids.DogDachshund.EntityMaleDachshund;
import com.animania.addons.catsdogs.common.entity.canids.DogDachshund.EntityPuppyDachshund;
import com.animania.addons.catsdogs.common.entity.canids.DogFox.EntityFemaleFox;
import com.animania.addons.catsdogs.common.entity.canids.DogFox.EntityMaleFox;
import com.animania.addons.catsdogs.common.entity.canids.DogFox.EntityPuppyFox;
import com.animania.addons.catsdogs.common.entity.canids.DogGermanShepherd.EntityFemaleGermanShepherd;
import com.animania.addons.catsdogs.common.entity.canids.DogGermanShepherd.EntityMaleGermanShepherd;
import com.animania.addons.catsdogs.common.entity.canids.DogGermanShepherd.EntityPuppyGermanShepherd;
import com.animania.addons.catsdogs.common.entity.canids.DogGreatDane.EntityFemaleGreatDane;
import com.animania.addons.catsdogs.common.entity.canids.DogGreatDane.EntityMaleGreatDane;
import com.animania.addons.catsdogs.common.entity.canids.DogGreatDane.EntityPuppyGreatDane;
import com.animania.addons.catsdogs.common.entity.canids.DogGreyhound.EntityFemaleGreyhound;
import com.animania.addons.catsdogs.common.entity.canids.DogGreyhound.EntityMaleGreyhound;
import com.animania.addons.catsdogs.common.entity.canids.DogGreyhound.EntityPuppyGreyhound;
import com.animania.addons.catsdogs.common.entity.canids.DogHusky.EntityFemaleHusky;
import com.animania.addons.catsdogs.common.entity.canids.DogHusky.EntityMaleHusky;
import com.animania.addons.catsdogs.common.entity.canids.DogHusky.EntityPuppyHusky;
import com.animania.addons.catsdogs.common.entity.canids.DogLabrador.EntityFemaleLabrador;
import com.animania.addons.catsdogs.common.entity.canids.DogLabrador.EntityMaleLabrador;
import com.animania.addons.catsdogs.common.entity.canids.DogLabrador.EntityPuppyLabrador;
import com.animania.addons.catsdogs.common.entity.canids.DogPomeranian.EntityFemalePomeranian;
import com.animania.addons.catsdogs.common.entity.canids.DogPomeranian.EntityMalePomeranian;
import com.animania.addons.catsdogs.common.entity.canids.DogPomeranian.EntityPuppyPomeranian;
import com.animania.addons.catsdogs.common.entity.canids.DogPoodle.EntityFemalePoodle;
import com.animania.addons.catsdogs.common.entity.canids.DogPoodle.EntityMalePoodle;
import com.animania.addons.catsdogs.common.entity.canids.DogPoodle.EntityPuppyPoodle;
import com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityFemalePug;
import com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityMalePug;
import com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityPuppyPug;
import com.animania.addons.catsdogs.common.entity.canids.DogWolf.EntityFemaleWolf;
import com.animania.addons.catsdogs.common.entity.canids.DogWolf.EntityMaleWolf;
import com.animania.addons.catsdogs.common.entity.canids.DogWolf.EntityPuppyWolf;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import com.animania.addons.catsdogs.common.entity.canids.EntityFemaleDogBase;
import com.animania.addons.catsdogs.common.entity.canids.EntityMaleDogBase;
import com.animania.addons.catsdogs.common.entity.canids.EntityPuppyBase;
import com.animania.addons.catsdogs.common.entity.felids.CatAmericanShorthair.EntityKittenAmericanShorthair;
import com.animania.addons.catsdogs.common.entity.felids.CatAmericanShorthair.EntityQueenAmericanShorthair;
import com.animania.addons.catsdogs.common.entity.felids.CatAmericanShorthair.EntityTomAmericanShorthair;
import com.animania.addons.catsdogs.common.entity.felids.CatAsiatic.EntityKittenAsiatic;
import com.animania.addons.catsdogs.common.entity.felids.CatAsiatic.EntityQueenAsiatic;
import com.animania.addons.catsdogs.common.entity.felids.CatAsiatic.EntityTomAsiatic;
import com.animania.addons.catsdogs.common.entity.felids.CatExotic.EntityKittenExotic;
import com.animania.addons.catsdogs.common.entity.felids.CatExotic.EntityQueenExotic;
import com.animania.addons.catsdogs.common.entity.felids.CatExotic.EntityTomExotic;
import com.animania.addons.catsdogs.common.entity.felids.CatNorwegian.EntityKittenNorwegian;
import com.animania.addons.catsdogs.common.entity.felids.CatNorwegian.EntityQueenNorwegian;
import com.animania.addons.catsdogs.common.entity.felids.CatNorwegian.EntityTomNorwegian;
import com.animania.addons.catsdogs.common.entity.felids.CatOcelot.EntityKittenOcelot;
import com.animania.addons.catsdogs.common.entity.felids.CatOcelot.EntityQueenOcelot;
import com.animania.addons.catsdogs.common.entity.felids.CatOcelot.EntityTomOcelot;
import com.animania.addons.catsdogs.common.entity.felids.CatRagdoll.EntityKittenRagdoll;
import com.animania.addons.catsdogs.common.entity.felids.CatRagdoll.EntityQueenRagdoll;
import com.animania.addons.catsdogs.common.entity.felids.CatRagdoll.EntityTomRagdoll;
import com.animania.addons.catsdogs.common.entity.felids.CatSiamese.EntityKittenSiamese;
import com.animania.addons.catsdogs.common.entity.felids.CatSiamese.EntityQueenSiamese;
import com.animania.addons.catsdogs.common.entity.felids.CatSiamese.EntityTomSiamese;
import com.animania.addons.catsdogs.common.entity.felids.CatTabby.EntityKittenTabby;
import com.animania.addons.catsdogs.common.entity.felids.CatTabby.EntityQueenTabby;
import com.animania.addons.catsdogs.common.entity.felids.CatTabby.EntityTomTabby;
import com.animania.addons.catsdogs.common.entity.felids.EntityAnimaniaCat;
import com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase;
import com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase;
import com.animania.addons.catsdogs.common.entity.felids.EntityTomBase;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

 



public class CatsDogsEntityTypes
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Animania.MODID);

	 

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleBloodhound>> DOG_MALE_BLOODHOUND = registerDog("dog_male_bloodhound", EntityMaleBloodhound::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleBloodhound>> DOG_FEMALE_BLOODHOUND = registerDog("dog_female_bloodhound", EntityFemaleBloodhound::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyBloodhound>> DOG_PUPPY_BLOODHOUND = registerDog("dog_puppy_bloodhound", EntityPuppyBloodhound::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleChihuahua>> DOG_MALE_CHIHUAHUA = registerDog("dog_male_chihuahua", EntityMaleChihuahua::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleChihuahua>> DOG_FEMALE_CHIHUAHUA = registerDog("dog_female_chihuahua", EntityFemaleChihuahua::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyChihuahua>> DOG_PUPPY_CHIHUAHUA = registerDog("dog_puppy_chihuahua", EntityPuppyChihuahua::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleCollie>> DOG_MALE_COLLIE = registerDog("dog_male_collie", EntityMaleCollie::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleCollie>> DOG_FEMALE_COLLIE = registerDog("dog_female_collie", EntityFemaleCollie::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyCollie>> DOG_PUPPY_COLLIE = registerDog("dog_puppy_collie", EntityPuppyCollie::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleCorgi>> DOG_MALE_CORGI = registerDog("dog_male_corgi", EntityMaleCorgi::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleCorgi>> DOG_FEMALE_CORGI = registerDog("dog_female_corgi", EntityFemaleCorgi::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyCorgi>> DOG_PUPPY_CORGI = registerDog("dog_puppy_corgi", EntityPuppyCorgi::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleDachshund>> DOG_MALE_DACHSHUND = registerDog("dog_male_dachshund", EntityMaleDachshund::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleDachshund>> DOG_FEMALE_DACHSHUND = registerDog("dog_female_dachshund", EntityFemaleDachshund::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyDachshund>> DOG_PUPPY_DACHSHUND = registerDog("dog_puppy_dachshund", EntityPuppyDachshund::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleFox>> DOG_MALE_FOX = registerDog("dog_male_fox", EntityMaleFox::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleFox>> DOG_FEMALE_FOX = registerDog("dog_female_fox", EntityFemaleFox::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyFox>> DOG_PUPPY_FOX = registerDog("dog_puppy_fox", EntityPuppyFox::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleGermanShepherd>> DOG_MALE_GERMAN_SHEPHERD = registerDog("dog_male_german_shepherd", EntityMaleGermanShepherd::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleGermanShepherd>> DOG_FEMALE_GERMAN_SHEPHERD = registerDog("dog_female_german_shepherd", EntityFemaleGermanShepherd::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyGermanShepherd>> DOG_PUPPY_GERMAN_SHEPHERD = registerDog("dog_puppy_german_shepherd", EntityPuppyGermanShepherd::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleGreatDane>> DOG_MALE_GREAT_DANE = registerDog("dog_male_great_dane", EntityMaleGreatDane::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleGreatDane>> DOG_FEMALE_GREAT_DANE = registerDog("dog_female_great_dane", EntityFemaleGreatDane::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyGreatDane>> DOG_PUPPY_GREAT_DANE = registerDog("dog_puppy_great_dane", EntityPuppyGreatDane::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleGreyhound>> DOG_MALE_GREYHOUND = registerDog("dog_male_greyhound", EntityMaleGreyhound::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleGreyhound>> DOG_FEMALE_GREYHOUND = registerDog("dog_female_greyhound", EntityFemaleGreyhound::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyGreyhound>> DOG_PUPPY_GREYHOUND = registerDog("dog_puppy_greyhound", EntityPuppyGreyhound::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleHusky>> DOG_MALE_HUSKY = registerDog("dog_male_husky", EntityMaleHusky::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleHusky>> DOG_FEMALE_HUSKY = registerDog("dog_female_husky", EntityFemaleHusky::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyHusky>> DOG_PUPPY_HUSKY = registerDog("dog_puppy_husky", EntityPuppyHusky::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleLabrador>> DOG_MALE_LABRADOR = registerDog("dog_male_labrador", EntityMaleLabrador::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleLabrador>> DOG_FEMALE_LABRADOR = registerDog("dog_female_labrador", EntityFemaleLabrador::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyLabrador>> DOG_PUPPY_LABRADOR = registerDog("dog_puppy_labrador", EntityPuppyLabrador::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMalePomeranian>> DOG_MALE_POMERANIAN = registerDog("dog_male_pomeranian", EntityMalePomeranian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemalePomeranian>> DOG_FEMALE_POMERANIAN = registerDog("dog_female_pomeranian", EntityFemalePomeranian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyPomeranian>> DOG_PUPPY_POMERANIAN = registerDog("dog_puppy_pomeranian", EntityPuppyPomeranian::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMalePoodle>> DOG_MALE_POODLE = registerDog("dog_male_poodle", EntityMalePoodle::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemalePoodle>> DOG_FEMALE_POODLE = registerDog("dog_female_poodle", EntityFemalePoodle::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyPoodle>> DOG_PUPPY_POODLE = registerDog("dog_puppy_poodle", EntityPuppyPoodle::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMalePug>> DOG_MALE_PUG = registerDog("dog_male_pug", EntityMalePug::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemalePug>> DOG_FEMALE_PUG = registerDog("dog_female_pug", EntityFemalePug::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyPug>> DOG_PUPPY_PUG = registerDog("dog_puppy_pug", EntityPuppyPug::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityMaleWolf>> DOG_MALE_WOLF = registerDog("dog_male_wolf", EntityMaleWolf::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFemaleWolf>> DOG_FEMALE_WOLF = registerDog("dog_female_wolf", EntityFemaleWolf::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPuppyWolf>> DOG_PUPPY_WOLF = registerDog("dog_puppy_wolf", EntityPuppyWolf::new);

	private static <T extends EntityAnimaniaDog> DeferredHolder<EntityType<?>, EntityType<T>> registerDog(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.6F, 0.85F)
				.build(name));
	}

	 

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomAmericanShorthair>> CAT_TOM_AMERICAN_SHORTHAIR = registerCat("cat_tom_american_shorthair", EntityTomAmericanShorthair::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenAmericanShorthair>> CAT_QUEEN_AMERICAN_SHORTHAIR = registerCat("cat_queen_american_shorthair", EntityQueenAmericanShorthair::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenAmericanShorthair>> CAT_KITTEN_AMERICAN_SHORTHAIR = registerCat("cat_kitten_american_shorthair", EntityKittenAmericanShorthair::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomAsiatic>> CAT_TOM_ASIATIC = registerCat("cat_tom_asiatic", EntityTomAsiatic::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenAsiatic>> CAT_QUEEN_ASIATIC = registerCat("cat_queen_asiatic", EntityQueenAsiatic::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenAsiatic>> CAT_KITTEN_ASIATIC = registerCat("cat_kitten_asiatic", EntityKittenAsiatic::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomExotic>> CAT_TOM_EXOTIC = registerCat("cat_tom_exotic", EntityTomExotic::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenExotic>> CAT_QUEEN_EXOTIC = registerCat("cat_queen_exotic", EntityQueenExotic::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenExotic>> CAT_KITTEN_EXOTIC = registerCat("cat_kitten_exotic", EntityKittenExotic::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomNorwegian>> CAT_TOM_NORWEGIAN = registerCat("cat_tom_norwegian", EntityTomNorwegian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenNorwegian>> CAT_QUEEN_NORWEGIAN = registerCat("cat_queen_norwegian", EntityQueenNorwegian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenNorwegian>> CAT_KITTEN_NORWEGIAN = registerCat("cat_kitten_norwegian", EntityKittenNorwegian::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomOcelot>> CAT_TOM_OCELOT = registerCat("cat_tom_ocelot", EntityTomOcelot::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenOcelot>> CAT_QUEEN_OCELOT = registerCat("cat_queen_ocelot", EntityQueenOcelot::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenOcelot>> CAT_KITTEN_OCELOT = registerCat("cat_kitten_ocelot", EntityKittenOcelot::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomRagdoll>> CAT_TOM_RAGDOLL = registerCat("cat_tom_ragdoll", EntityTomRagdoll::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenRagdoll>> CAT_QUEEN_RAGDOLL = registerCat("cat_queen_ragdoll", EntityQueenRagdoll::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenRagdoll>> CAT_KITTEN_RAGDOLL = registerCat("cat_kitten_ragdoll", EntityKittenRagdoll::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomSiamese>> CAT_TOM_SIAMESE = registerCat("cat_tom_siamese", EntityTomSiamese::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenSiamese>> CAT_QUEEN_SIAMESE = registerCat("cat_queen_siamese", EntityQueenSiamese::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenSiamese>> CAT_KITTEN_SIAMESE = registerCat("cat_kitten_siamese", EntityKittenSiamese::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityTomTabby>> CAT_TOM_TABBY = registerCat("cat_tom_tabby", EntityTomTabby::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityQueenTabby>> CAT_QUEEN_TABBY = registerCat("cat_queen_tabby", EntityQueenTabby::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityKittenTabby>> CAT_KITTEN_TABBY = registerCat("cat_kitten_tabby", EntityKittenTabby::new);

	private static <T extends EntityAnimaniaCat> DeferredHolder<EntityType<?>, EntityType<T>> registerCat(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.6F, 0.7F)
				.build(name));
	}

	public static void registerAttributes(EntityAttributeCreationEvent event)
	{
		event.put(DOG_MALE_BLOODHOUND.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_BLOODHOUND.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_BLOODHOUND.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_CHIHUAHUA.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_CHIHUAHUA.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_CHIHUAHUA.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_COLLIE.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_COLLIE.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_COLLIE.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_CORGI.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_CORGI.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_CORGI.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_DACHSHUND.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_DACHSHUND.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_DACHSHUND.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_FOX.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_FOX.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_FOX.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_GERMAN_SHEPHERD.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_GERMAN_SHEPHERD.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_GERMAN_SHEPHERD.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_GREAT_DANE.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_GREAT_DANE.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_GREAT_DANE.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_GREYHOUND.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_GREYHOUND.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_GREYHOUND.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_HUSKY.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_HUSKY.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_HUSKY.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_LABRADOR.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_LABRADOR.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_LABRADOR.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_POMERANIAN.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_POMERANIAN.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_POMERANIAN.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_POODLE.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_POODLE.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_POODLE.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_PUG.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_PUG.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_PUG.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(DOG_MALE_WOLF.get(), EntityMaleDogBase.createMaleAttributes().build());
		event.put(DOG_FEMALE_WOLF.get(), EntityFemaleDogBase.createFemaleAttributes().build());
		event.put(DOG_PUPPY_WOLF.get(), EntityPuppyBase.createPuppyAttributes().build());

		event.put(CAT_TOM_AMERICAN_SHORTHAIR.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_AMERICAN_SHORTHAIR.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_AMERICAN_SHORTHAIR.get(), EntityKittenBase.createKittenAttributes().build());

		event.put(CAT_TOM_ASIATIC.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_ASIATIC.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_ASIATIC.get(), EntityKittenBase.createKittenAttributes().build());

		event.put(CAT_TOM_EXOTIC.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_EXOTIC.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_EXOTIC.get(), EntityKittenBase.createKittenAttributes().build());

		event.put(CAT_TOM_NORWEGIAN.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_NORWEGIAN.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_NORWEGIAN.get(), EntityKittenBase.createKittenAttributes().build());

		event.put(CAT_TOM_OCELOT.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_OCELOT.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_OCELOT.get(), EntityKittenBase.createKittenAttributes().build());

		event.put(CAT_TOM_RAGDOLL.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_RAGDOLL.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_RAGDOLL.get(), EntityKittenBase.createKittenAttributes().build());

		event.put(CAT_TOM_SIAMESE.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_SIAMESE.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_SIAMESE.get(), EntityKittenBase.createKittenAttributes().build());

		event.put(CAT_TOM_TABBY.get(), EntityTomBase.createTomAttributes().build());
		event.put(CAT_QUEEN_TABBY.get(), EntityQueenBase.createQueenAttributes().build());
		event.put(CAT_KITTEN_TABBY.get(), EntityKittenBase.createKittenAttributes().build());

	}

	public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event)
	{
		registerGroundSpawn(event, DOG_MALE_BLOODHOUND.get());
		registerGroundSpawn(event, DOG_FEMALE_BLOODHOUND.get());
		registerGroundSpawn(event, DOG_MALE_CHIHUAHUA.get());
		registerGroundSpawn(event, DOG_FEMALE_CHIHUAHUA.get());
		registerGroundSpawn(event, DOG_MALE_COLLIE.get());
		registerGroundSpawn(event, DOG_FEMALE_COLLIE.get());
		registerGroundSpawn(event, DOG_MALE_CORGI.get());
		registerGroundSpawn(event, DOG_FEMALE_CORGI.get());
		registerGroundSpawn(event, DOG_MALE_DACHSHUND.get());
		registerGroundSpawn(event, DOG_FEMALE_DACHSHUND.get());
		registerGroundSpawn(event, DOG_MALE_FOX.get());
		registerGroundSpawn(event, DOG_FEMALE_FOX.get());
		registerGroundSpawn(event, DOG_MALE_GERMAN_SHEPHERD.get());
		registerGroundSpawn(event, DOG_FEMALE_GERMAN_SHEPHERD.get());
		registerGroundSpawn(event, DOG_MALE_GREAT_DANE.get());
		registerGroundSpawn(event, DOG_FEMALE_GREAT_DANE.get());
		registerGroundSpawn(event, DOG_MALE_GREYHOUND.get());
		registerGroundSpawn(event, DOG_FEMALE_GREYHOUND.get());
		registerGroundSpawn(event, DOG_MALE_HUSKY.get());
		registerGroundSpawn(event, DOG_FEMALE_HUSKY.get());
		registerGroundSpawn(event, DOG_MALE_LABRADOR.get());
		registerGroundSpawn(event, DOG_FEMALE_LABRADOR.get());
		registerGroundSpawn(event, DOG_MALE_POMERANIAN.get());
		registerGroundSpawn(event, DOG_FEMALE_POMERANIAN.get());
		registerGroundSpawn(event, DOG_MALE_POODLE.get());
		registerGroundSpawn(event, DOG_FEMALE_POODLE.get());
		registerGroundSpawn(event, DOG_MALE_PUG.get());
		registerGroundSpawn(event, DOG_FEMALE_PUG.get());
		registerGroundSpawn(event, DOG_MALE_WOLF.get());
		registerGroundSpawn(event, DOG_FEMALE_WOLF.get());

		registerGroundSpawn(event, CAT_TOM_AMERICAN_SHORTHAIR.get());
		registerGroundSpawn(event, CAT_QUEEN_AMERICAN_SHORTHAIR.get());
		registerGroundSpawn(event, CAT_TOM_ASIATIC.get());
		registerGroundSpawn(event, CAT_QUEEN_ASIATIC.get());
		registerGroundSpawn(event, CAT_TOM_EXOTIC.get());
		registerGroundSpawn(event, CAT_QUEEN_EXOTIC.get());
		registerGroundSpawn(event, CAT_TOM_NORWEGIAN.get());
		registerGroundSpawn(event, CAT_QUEEN_NORWEGIAN.get());
		registerGroundSpawn(event, CAT_TOM_OCELOT.get());
		registerGroundSpawn(event, CAT_QUEEN_OCELOT.get());
		registerGroundSpawn(event, CAT_TOM_RAGDOLL.get());
		registerGroundSpawn(event, CAT_QUEEN_RAGDOLL.get());
		registerGroundSpawn(event, CAT_TOM_SIAMESE.get());
		registerGroundSpawn(event, CAT_QUEEN_SIAMESE.get());
		registerGroundSpawn(event, CAT_TOM_TABBY.get());
		registerGroundSpawn(event, CAT_QUEEN_TABBY.get());
	}

	private static <T extends Animal> void registerGroundSpawn(RegisterSpawnPlacementsEvent event, EntityType<T> type)
	{
		event.register(type, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	private CatsDogsEntityTypes()
	{
	}
}
