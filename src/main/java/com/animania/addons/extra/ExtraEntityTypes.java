package com.animania.addons.extra;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.amphibians.EntityAmphibian;
import com.animania.addons.extra.common.entity.amphibians.EntityDartFrogs;
import com.animania.addons.extra.common.entity.amphibians.EntityFrogs;
import com.animania.addons.extra.common.entity.amphibians.EntityToad;
import com.animania.addons.extra.common.entity.peafowl.EntityAnimaniaPeacock;
import com.animania.addons.extra.common.entity.peafowl.EntityPeachickBase;
import com.animania.addons.extra.common.entity.peafowl.EntityPeacockBase;
import com.animania.addons.extra.common.entity.peafowl.EntityPeafowlBase;
import com.animania.addons.extra.common.entity.peafowl.PeafowlBlue.EntityPeachickBlue;
import com.animania.addons.extra.common.entity.peafowl.PeafowlBlue.EntityPeacockBlue;
import com.animania.addons.extra.common.entity.peafowl.PeafowlBlue.EntityPeafowlBlue;
import com.animania.addons.extra.common.entity.peafowl.PeafowlCharcoal.EntityPeachickCharcoal;
import com.animania.addons.extra.common.entity.peafowl.PeafowlCharcoal.EntityPeacockCharcoal;
import com.animania.addons.extra.common.entity.peafowl.PeafowlCharcoal.EntityPeafowlCharcoal;
import com.animania.addons.extra.common.entity.peafowl.PeafowlOpal.EntityPeachickOpal;
import com.animania.addons.extra.common.entity.peafowl.PeafowlOpal.EntityPeacockOpal;
import com.animania.addons.extra.common.entity.peafowl.PeafowlOpal.EntityPeafowlOpal;
import com.animania.addons.extra.common.entity.peafowl.PeafowlPeach.EntityPeachickPeach;
import com.animania.addons.extra.common.entity.peafowl.PeafowlPeach.EntityPeacockPeach;
import com.animania.addons.extra.common.entity.peafowl.PeafowlPeach.EntityPeafowlPeach;
import com.animania.addons.extra.common.entity.peafowl.PeafowlPurple.EntityPeachickPurple;
import com.animania.addons.extra.common.entity.peafowl.PeafowlPurple.EntityPeacockPurple;
import com.animania.addons.extra.common.entity.peafowl.PeafowlPurple.EntityPeafowlPurple;
import com.animania.addons.extra.common.entity.peafowl.PeafowlTaupe.EntityPeachickTaupe;
import com.animania.addons.extra.common.entity.peafowl.PeafowlTaupe.EntityPeacockTaupe;
import com.animania.addons.extra.common.entity.peafowl.PeafowlTaupe.EntityPeafowlTaupe;
import com.animania.addons.extra.common.entity.peafowl.PeafowlWhite.EntityPeachickWhite;
import com.animania.addons.extra.common.entity.peafowl.PeafowlWhite.EntityPeacockWhite;
import com.animania.addons.extra.common.entity.peafowl.PeafowlWhite.EntityPeafowlWhite;
import com.animania.addons.extra.common.entity.rodents.EntityFerretBase;
import com.animania.addons.extra.common.entity.rodents.EntityFerretGrey;
import com.animania.addons.extra.common.entity.rodents.EntityFerretWhite;
import com.animania.addons.extra.common.entity.rodents.EntityHamster;
import com.animania.addons.extra.common.entity.rodents.EntityHedgehog;
import com.animania.addons.extra.common.entity.rodents.EntityHedgehogAlbino;
import com.animania.addons.extra.common.entity.rodents.EntityHedgehogBase;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityRabbitBuckBase;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityRabbitDoeBase;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityRabbitKitBase;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitChinchilla.EntityRabbitBuckChinchilla;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitChinchilla.EntityRabbitDoeChinchilla;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitChinchilla.EntityRabbitKitChinchilla;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitCottonail.EntityRabbitBuckCottontail;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitCottonail.EntityRabbitDoeCottontail;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitCottonail.EntityRabbitKitCottontail;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitDutch.EntityRabbitBuckDutch;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitDutch.EntityRabbitDoeDutch;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitDutch.EntityRabbitKitDutch;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitHavana.EntityRabbitBuckHavana;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitHavana.EntityRabbitDoeHavana;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitHavana.EntityRabbitKitHavana;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitJack.EntityRabbitBuckJack;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitJack.EntityRabbitDoeJack;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitJack.EntityRabbitKitJack;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitLop.EntityRabbitBuckLop;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitLop.EntityRabbitDoeLop;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitLop.EntityRabbitKitLop;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitNewZealand.EntityRabbitBuckNewZealand;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitNewZealand.EntityRabbitDoeNewZealand;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitNewZealand.EntityRabbitKitNewZealand;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitRex.EntityRabbitBuckRex;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitRex.EntityRabbitDoeRex;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitRex.EntityRabbitKitRex;

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

 



public class ExtraEntityTypes
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Animania.MODID);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityFrogs>> FROG = registerAmphibian("frog", EntityFrogs::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityDartFrogs>> DART_FROG = registerAmphibian("dart_frog", EntityDartFrogs::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityToad>> TOAD = registerAmphibian("toad", EntityToad::new);

	 
	 
	 

	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeacockBlue>> PEACOCK_BLUE = registerPeacockMale("peacock_blue", EntityPeacockBlue::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeafowlBlue>> PEAFOWL_BLUE = registerPeacockFemale("peafowl_blue", EntityPeafowlBlue::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeachickBlue>> PEACHICK_BLUE = registerPeacockChild("peachick_blue", EntityPeachickBlue::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeacockWhite>> PEACOCK_WHITE = registerPeacockMale("peacock_white", EntityPeacockWhite::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeafowlWhite>> PEAFOWL_WHITE = registerPeacockFemale("peafowl_white", EntityPeafowlWhite::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeachickWhite>> PEACHICK_WHITE = registerPeacockChild("peachick_white", EntityPeachickWhite::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeacockTaupe>> PEACOCK_TAUPE = registerPeacockMale("peacock_taupe", EntityPeacockTaupe::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeafowlTaupe>> PEAFOWL_TAUPE = registerPeacockFemale("peafowl_taupe", EntityPeafowlTaupe::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeachickTaupe>> PEACHICK_TAUPE = registerPeacockChild("peachick_taupe", EntityPeachickTaupe::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeacockPurple>> PEACOCK_PURPLE = registerPeacockMale("peacock_purple", EntityPeacockPurple::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeafowlPurple>> PEAFOWL_PURPLE = registerPeacockFemale("peafowl_purple", EntityPeafowlPurple::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeachickPurple>> PEACHICK_PURPLE = registerPeacockChild("peachick_purple", EntityPeachickPurple::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeacockPeach>> PEACOCK_PEACH = registerPeacockMale("peacock_peach", EntityPeacockPeach::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeafowlPeach>> PEAFOWL_PEACH = registerPeacockFemale("peafowl_peach", EntityPeafowlPeach::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeachickPeach>> PEACHICK_PEACH = registerPeacockChild("peachick_peach", EntityPeachickPeach::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeacockOpal>> PEACOCK_OPAL = registerPeacockMale("peacock_opal", EntityPeacockOpal::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeafowlOpal>> PEAFOWL_OPAL = registerPeacockFemale("peafowl_opal", EntityPeafowlOpal::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeachickOpal>> PEACHICK_OPAL = registerPeacockChild("peachick_opal", EntityPeachickOpal::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeacockCharcoal>> PEACOCK_CHARCOAL = registerPeacockMale("peacock_charcoal", EntityPeacockCharcoal::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeafowlCharcoal>> PEAFOWL_CHARCOAL = registerPeacockFemale("peafowl_charcoal", EntityPeafowlCharcoal::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityPeachickCharcoal>> PEACHICK_CHARCOAL = registerPeacockChild("peachick_charcoal", EntityPeachickCharcoal::new);

	 
	 

	public static final DeferredHolder<EntityType<?>, EntityType<EntityFerretGrey>> FERRET_GREY = registerFerret("ferret_grey", EntityFerretGrey::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFerretWhite>> FERRET_WHITE = registerFerret("ferret_white", EntityFerretWhite::new);

	private static <T extends EntityFerretBase> DeferredHolder<EntityType<?>, EntityType<T>> registerFerret(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.75F, 0.4F)
				.build(name));
	}

	 
	 

	public static final DeferredHolder<EntityType<?>, EntityType<EntityHamster>> HAMSTER = ENTITY_TYPES.register("hamster",
			() -> EntityType.Builder.of(EntityHamster::new, MobCategory.CREATURE)
					.sized(0.5F, 0.3F)
					.build("hamster"));

	 
	 

	public static final DeferredHolder<EntityType<?>, EntityType<EntityHedgehog>> HEDGEHOG = registerHedgehog("hedgehog", EntityHedgehog::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityHedgehogAlbino>> HEDGEHOG_ALBINO = registerHedgehog("hedgehog_albino", EntityHedgehogAlbino::new);

	private static <T extends EntityHedgehogBase> DeferredHolder<EntityType<?>, EntityType<T>> registerHedgehog(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.5F, 0.5F)
				.build(name));
	}

	 
	 
	 

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckLop>> RABBIT_BUCK_LOP = registerRabbit("rabbit_buck_lop", EntityRabbitBuckLop::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeLop>> RABBIT_DOE_LOP = registerRabbit("rabbit_doe_lop", EntityRabbitDoeLop::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitLop>> RABBIT_KIT_LOP = registerRabbit("rabbit_kit_lop", EntityRabbitKitLop::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckRex>> RABBIT_BUCK_REX = registerRabbit("rabbit_buck_rex", EntityRabbitBuckRex::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeRex>> RABBIT_DOE_REX = registerRabbit("rabbit_doe_rex", EntityRabbitDoeRex::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitRex>> RABBIT_KIT_REX = registerRabbit("rabbit_kit_rex", EntityRabbitKitRex::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckDutch>> RABBIT_BUCK_DUTCH = registerRabbit("rabbit_buck_dutch", EntityRabbitBuckDutch::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeDutch>> RABBIT_DOE_DUTCH = registerRabbit("rabbit_doe_dutch", EntityRabbitDoeDutch::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitDutch>> RABBIT_KIT_DUTCH = registerRabbit("rabbit_kit_dutch", EntityRabbitKitDutch::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckHavana>> RABBIT_BUCK_HAVANA = registerRabbit("rabbit_buck_havana", EntityRabbitBuckHavana::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeHavana>> RABBIT_DOE_HAVANA = registerRabbit("rabbit_doe_havana", EntityRabbitDoeHavana::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitHavana>> RABBIT_KIT_HAVANA = registerRabbit("rabbit_kit_havana", EntityRabbitKitHavana::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckNewZealand>> RABBIT_BUCK_NEW_ZEALAND = registerRabbit("rabbit_buck_new_zealand", EntityRabbitBuckNewZealand::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeNewZealand>> RABBIT_DOE_NEW_ZEALAND = registerRabbit("rabbit_doe_new_zealand", EntityRabbitDoeNewZealand::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitNewZealand>> RABBIT_KIT_NEW_ZEALAND = registerRabbit("rabbit_kit_new_zealand", EntityRabbitKitNewZealand::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckJack>> RABBIT_BUCK_JACK = registerRabbit("rabbit_buck_jack", EntityRabbitBuckJack::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeJack>> RABBIT_DOE_JACK = registerRabbit("rabbit_doe_jack", EntityRabbitDoeJack::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitJack>> RABBIT_KIT_JACK = registerRabbit("rabbit_kit_jack", EntityRabbitKitJack::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckCottontail>> RABBIT_BUCK_COTTONTAIL = registerRabbit("rabbit_buck_cottontail", EntityRabbitBuckCottontail::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeCottontail>> RABBIT_DOE_COTTONTAIL = registerRabbit("rabbit_doe_cottontail", EntityRabbitDoeCottontail::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitCottontail>> RABBIT_KIT_COTTONTAIL = registerRabbit("rabbit_kit_cottontail", EntityRabbitKitCottontail::new);

	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitBuckChinchilla>> RABBIT_BUCK_CHINCHILLA = registerRabbit("rabbit_buck_chinchilla", EntityRabbitBuckChinchilla::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitDoeChinchilla>> RABBIT_DOE_CHINCHILLA = registerRabbit("rabbit_doe_chinchilla", EntityRabbitDoeChinchilla::new);
	public static final DeferredHolder<EntityType<?>, EntityType<EntityRabbitKitChinchilla>> RABBIT_KIT_CHINCHILLA = registerRabbit("rabbit_kit_chinchilla", EntityRabbitKitChinchilla::new);

	private static <T extends com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit> DeferredHolder<EntityType<?>, EntityType<T>> registerRabbit(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.7F, 0.6F)
				.build(name));
	}

	private static <T extends EntityAmphibian> DeferredHolder<EntityType<?>, EntityType<T>> registerAmphibian(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.3F, 0.3F)
				.build(name));
	}

	private static <T extends EntityPeacockBase> DeferredHolder<EntityType<?>, EntityType<T>> registerPeacockMale(String name, EntityType.EntityFactory<T> factory)
	{
		return registerPeafowl(name, factory, 0.8F, 1.6F);
	}

	private static <T extends EntityPeafowlBase> DeferredHolder<EntityType<?>, EntityType<T>> registerPeacockFemale(String name, EntityType.EntityFactory<T> factory)
	{
		return registerPeafowl(name, factory, 0.6F, 1.2F);
	}

	private static <T extends EntityPeachickBase> DeferredHolder<EntityType<?>, EntityType<T>> registerPeacockChild(String name, EntityType.EntityFactory<T> factory)
	{
		return registerPeafowl(name, factory, 1.4F, 1.6F);
	}

	private static <T extends EntityAnimaniaPeacock> DeferredHolder<EntityType<?>, EntityType<T>> registerPeafowl(String name, EntityType.EntityFactory<T> factory, float width, float height)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(width, height)
				.build(name));
	}

	public static void registerAttributes(EntityAttributeCreationEvent event)
	{
		event.put(FROG.get(), EntityAmphibian.createAttributes().build());
		event.put(DART_FROG.get(), EntityAmphibian.createAttributes().build());
		event.put(TOAD.get(), EntityAmphibian.createAttributes().build());

		event.put(PEACOCK_BLUE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEAFOWL_BLUE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACHICK_BLUE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACOCK_WHITE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEAFOWL_WHITE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACHICK_WHITE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACOCK_TAUPE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEAFOWL_TAUPE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACHICK_TAUPE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACOCK_PURPLE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEAFOWL_PURPLE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACHICK_PURPLE.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACOCK_PEACH.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEAFOWL_PEACH.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACHICK_PEACH.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACOCK_OPAL.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEAFOWL_OPAL.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACHICK_OPAL.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACOCK_CHARCOAL.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEAFOWL_CHARCOAL.get(), EntityAnimaniaPeacock.createAttributes().build());
		event.put(PEACHICK_CHARCOAL.get(), EntityAnimaniaPeacock.createAttributes().build());

		event.put(FERRET_GREY.get(), EntityFerretBase.createAttributes().build());
		event.put(FERRET_WHITE.get(), EntityFerretBase.createAttributes().build());

		event.put(HAMSTER.get(), EntityHamster.createAttributes().build());

		event.put(HEDGEHOG.get(), EntityHedgehogBase.createAttributes().build());
		event.put(HEDGEHOG_ALBINO.get(), EntityHedgehogBase.createAttributes().build());

		event.put(RABBIT_BUCK_LOP.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_LOP.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_LOP.get(), EntityRabbitKitBase.createKitAttributes().build());

		event.put(RABBIT_BUCK_REX.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_REX.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_REX.get(), EntityRabbitKitBase.createKitAttributes().build());

		event.put(RABBIT_BUCK_DUTCH.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_DUTCH.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_DUTCH.get(), EntityRabbitKitBase.createKitAttributes().build());

		event.put(RABBIT_BUCK_HAVANA.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_HAVANA.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_HAVANA.get(), EntityRabbitKitBase.createKitAttributes().build());

		event.put(RABBIT_BUCK_NEW_ZEALAND.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_NEW_ZEALAND.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_NEW_ZEALAND.get(), EntityRabbitKitBase.createKitAttributes().build());

		event.put(RABBIT_BUCK_JACK.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_JACK.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_JACK.get(), EntityRabbitKitBase.createKitAttributes().build());

		event.put(RABBIT_BUCK_COTTONTAIL.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_COTTONTAIL.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_COTTONTAIL.get(), EntityRabbitKitBase.createKitAttributes().build());

		event.put(RABBIT_BUCK_CHINCHILLA.get(), EntityRabbitBuckBase.createBuckAttributes().build());
		event.put(RABBIT_DOE_CHINCHILLA.get(), EntityRabbitDoeBase.createDoeAttributes().build());
		event.put(RABBIT_KIT_CHINCHILLA.get(), EntityRabbitKitBase.createKitAttributes().build());
	}

	public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event)
	{
		registerGroundSpawn(event, FROG.get());
		registerGroundSpawn(event, DART_FROG.get());
		registerGroundSpawn(event, TOAD.get());

		registerGroundSpawn(event, PEACOCK_BLUE.get());
		registerGroundSpawn(event, PEAFOWL_BLUE.get());
		registerGroundSpawn(event, PEACHICK_BLUE.get());
		registerGroundSpawn(event, PEACOCK_WHITE.get());
		registerGroundSpawn(event, PEAFOWL_WHITE.get());
		registerGroundSpawn(event, PEACHICK_WHITE.get());
		registerGroundSpawn(event, PEACOCK_TAUPE.get());
		registerGroundSpawn(event, PEAFOWL_TAUPE.get());
		registerGroundSpawn(event, PEACHICK_TAUPE.get());
		registerGroundSpawn(event, PEACOCK_PURPLE.get());
		registerGroundSpawn(event, PEAFOWL_PURPLE.get());
		registerGroundSpawn(event, PEACHICK_PURPLE.get());
		registerGroundSpawn(event, PEACOCK_PEACH.get());
		registerGroundSpawn(event, PEAFOWL_PEACH.get());
		registerGroundSpawn(event, PEACHICK_PEACH.get());
		registerGroundSpawn(event, PEACOCK_OPAL.get());
		registerGroundSpawn(event, PEAFOWL_OPAL.get());
		registerGroundSpawn(event, PEACHICK_OPAL.get());
		registerGroundSpawn(event, PEACOCK_CHARCOAL.get());
		registerGroundSpawn(event, PEAFOWL_CHARCOAL.get());
		registerGroundSpawn(event, PEACHICK_CHARCOAL.get());

		registerGroundSpawn(event, FERRET_GREY.get());
		registerGroundSpawn(event, FERRET_WHITE.get());

		registerGroundSpawn(event, HAMSTER.get());

		registerGroundSpawn(event, HEDGEHOG.get());
		registerGroundSpawn(event, HEDGEHOG_ALBINO.get());

		registerGroundSpawn(event, RABBIT_BUCK_LOP.get());
		registerGroundSpawn(event, RABBIT_DOE_LOP.get());
		registerGroundSpawn(event, RABBIT_BUCK_REX.get());
		registerGroundSpawn(event, RABBIT_DOE_REX.get());
		registerGroundSpawn(event, RABBIT_BUCK_DUTCH.get());
		registerGroundSpawn(event, RABBIT_DOE_DUTCH.get());
		registerGroundSpawn(event, RABBIT_BUCK_HAVANA.get());
		registerGroundSpawn(event, RABBIT_DOE_HAVANA.get());
		registerGroundSpawn(event, RABBIT_BUCK_NEW_ZEALAND.get());
		registerGroundSpawn(event, RABBIT_DOE_NEW_ZEALAND.get());
		registerGroundSpawn(event, RABBIT_BUCK_JACK.get());
		registerGroundSpawn(event, RABBIT_DOE_JACK.get());
		registerGroundSpawn(event, RABBIT_BUCK_COTTONTAIL.get());
		registerGroundSpawn(event, RABBIT_DOE_COTTONTAIL.get());
		registerGroundSpawn(event, RABBIT_BUCK_CHINCHILLA.get());
		registerGroundSpawn(event, RABBIT_DOE_CHINCHILLA.get());
	}

	private static <T extends Animal> void registerGroundSpawn(RegisterSpawnPlacementsEvent event, EntityType<T> type)
	{
		event.register(type, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	private ExtraEntityTypes()
	{
	}
}
