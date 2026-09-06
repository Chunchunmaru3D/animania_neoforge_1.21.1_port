package com.animania.client;

import com.animania.Animania;
import com.animania.addons.extra.ExtraItems;
import com.animania.addons.extra.common.item.ItemHamsterBall;
import com.animania.common.fluids.CommonFluids;
import net.minecraft.resources.ResourceLocation;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.addons.farm.client.model.chicken.ModelChick;
import com.animania.addons.farm.client.model.chicken.ModelHen;
import com.animania.addons.farm.client.model.chicken.ModelRooster;
import com.animania.addons.farm.client.model.cow.ModelBull;
import com.animania.addons.farm.client.model.cow.ModelBullAngus;
import com.animania.addons.farm.client.model.cow.ModelBullHereford;
import com.animania.addons.farm.client.model.cow.ModelBullLonghorn;
import com.animania.addons.farm.client.model.cow.ModelCalf;
import com.animania.addons.farm.client.model.cow.ModelCalfAngus;
import com.animania.addons.farm.client.model.cow.ModelCalfLonghorn;
import com.animania.addons.farm.client.model.cow.ModelCow;
import com.animania.addons.farm.client.model.cow.ModelCowAngus;
import com.animania.addons.farm.client.model.cow.ModelCowLonghorn;
import com.animania.addons.farm.client.model.pig.ModelHog;
import com.animania.addons.farm.client.model.pig.ModelHogHampshire;
import com.animania.addons.farm.client.model.pig.ModelHogLargeBlack;
import com.animania.addons.farm.client.model.pig.ModelPiglet;
import com.animania.addons.farm.client.model.pig.ModelPigletHampshire;
import com.animania.addons.farm.client.model.sheep.ModelDorperSheep;
import com.animania.addons.farm.client.model.sheep.ModelDorsetEwe;
import com.animania.addons.farm.client.model.sheep.ModelDorsetRam;
import com.animania.addons.farm.client.model.sheep.ModelFriesianSheep;
import com.animania.addons.farm.client.model.sheep.ModelJacobSheep;
import com.animania.addons.farm.client.model.sheep.ModelMerinoEwe;
import com.animania.addons.farm.client.model.sheep.ModelMerinoRam;
import com.animania.addons.farm.client.model.sheep.ModelSuffolkEwe;
import com.animania.addons.farm.client.model.sheep.ModelSuffolkRam;
import com.animania.addons.farm.client.render.sheep.RenderSheep;
import com.animania.addons.farm.client.model.goats.ModelBuckAlpine;
import com.animania.addons.farm.client.model.goats.ModelDoeAlpine;
import com.animania.addons.farm.client.model.goats.ModelKidAlpine;
import com.animania.addons.farm.client.model.goats.ModelBuckAngora;
import com.animania.addons.farm.client.model.goats.ModelDoeAngora;
import com.animania.addons.farm.client.model.goats.ModelKidAngora;
import com.animania.addons.farm.client.model.goats.ModelBuckFainting;
import com.animania.addons.farm.client.model.goats.ModelDoeFainting;
import com.animania.addons.farm.client.model.goats.ModelKidFainting;
import com.animania.addons.farm.client.model.goats.ModelBuckKiko;
import com.animania.addons.farm.client.model.goats.ModelDoeKiko;
import com.animania.addons.farm.client.model.goats.ModelKidKiko;
import com.animania.addons.farm.client.model.goats.ModelBuckKinder;
import com.animania.addons.farm.client.model.goats.ModelDoeKinder;
import com.animania.addons.farm.client.model.goats.ModelKidKinder;
import com.animania.addons.farm.client.model.goats.ModelBuckNigerianDwarf;
import com.animania.addons.farm.client.model.goats.ModelDoeNigerianDwarf;
import com.animania.addons.farm.client.model.goats.ModelKidNigerianDwarf;
import com.animania.addons.farm.client.model.goats.ModelBuckPygmy;
import com.animania.addons.farm.client.model.horse.ModelDraftHorseFoal;
import com.animania.addons.farm.client.model.horse.ModelDraftHorseMare;
import com.animania.addons.farm.client.model.horse.ModelDraftHorseStallion;
import com.animania.addons.farm.client.model.goats.ModelDoePygmy;
import com.animania.addons.farm.client.model.goats.ModelKidPygmy;
import com.animania.addons.farm.client.render.goats.RenderGoats;
import com.animania.addons.farm.client.render.horses.RenderHorses;
import com.animania.addons.farm.client.model.props.ModelCart;
import com.animania.addons.farm.client.model.props.ModelCartChest;
import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.client.render.blockentity.BlockEntityHiveRenderer;
import com.animania.addons.farm.client.render.props.RenderCart;
import com.animania.addons.farm.client.model.props.ModelTiller;
import com.animania.addons.farm.client.render.props.RenderTiller;
import com.animania.addons.farm.client.model.props.ModelWagon;
import com.animania.addons.farm.client.render.props.RenderWagon;
import com.animania.addons.farm.client.model.pig.ModelSow;
import com.animania.addons.farm.client.model.pig.ModelSowHampshire;
import com.animania.addons.farm.client.model.pig.ModelSowLargeBlack;
import com.animania.addons.farm.client.render.pig.RenderPigs;
import com.animania.addons.farm.client.render.chicken.RenderChickens;
import com.animania.addons.farm.client.render.cow.RenderCows;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

 



@EventBusSubscriber(modid = Animania.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimaniaClient
{
	@SubscribeEvent
	public static void registerItemColors(RegisterColorHandlersEvent.Item event)
	{
		event.register((stack, tintIndex) -> tintIndex == 0
				? ItemHamsterBall.getTint(((ItemHamsterBall) stack.getItem()).getColor(stack))
				: 0xFFFFFF, ExtraItems.HAMSTER_BALL_COLORED.get());
	}

	@SubscribeEvent
	public static void registerFluidExtensions(RegisterClientExtensionsEvent event)
	{
		registerFluidExtension(event, "slop", CommonFluids.SLOP_TYPE);
		registerFluidExtension(event, "milk_friesian", CommonFluids.MILK_FRIESIAN_TYPE);
		registerFluidExtension(event, "milk_holstein", CommonFluids.MILK_HOLSTEIN_TYPE);
		registerFluidExtension(event, "milk_jersey", CommonFluids.MILK_JERSEY_TYPE);
		registerFluidExtension(event, "milk_sheep", CommonFluids.MILK_SHEEP_TYPE);
		registerFluidExtension(event, "milk_goat", CommonFluids.MILK_GOAT_TYPE);
		registerFluidExtension(event, "honey", CommonFluids.HONEY_TYPE);
	}

	private static void registerFluidExtension(RegisterClientExtensionsEvent event, String name,
			net.neoforged.neoforge.registries.DeferredHolder<net.neoforged.neoforge.fluids.FluidType,
					net.neoforged.neoforge.fluids.FluidType> type)
	{
		event.registerFluidType(new IClientFluidTypeExtensions()
		{
			@Override
			public ResourceLocation getStillTexture()
			{
				return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "block/" + name + "_still");
			}

			@Override
			public ResourceLocation getFlowingTexture()
			{
				return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "block/" + name + "_flow");
			}
		}, type);
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderHamster.BALL_LAYER,
				com.animania.client.model.placeholder.ModelHamsterBall::createBodyLayer);
		event.registerLayerDefinition(RenderChickens.HEN_LAYER, ModelHen::createBodyLayer);
		event.registerLayerDefinition(RenderChickens.ROOSTER_LAYER, ModelRooster::createBodyLayer);
		event.registerLayerDefinition(RenderChickens.CHICK_LAYER, ModelChick::createBodyLayer);
		event.registerLayerDefinition(RenderCows.COW_LAYER, ModelCow::createBodyLayer);
		event.registerLayerDefinition(RenderCows.COW_ANGUS_LAYER, ModelCowAngus::createBodyLayer);
		event.registerLayerDefinition(RenderCows.COW_LONGHORN_LAYER, ModelCowLonghorn::createBodyLayer);
		event.registerLayerDefinition(RenderCows.BULL_LAYER, ModelBull::createBodyLayer);
		event.registerLayerDefinition(RenderCows.BULL_ANGUS_LAYER, ModelBullAngus::createBodyLayer);
		event.registerLayerDefinition(RenderCows.BULL_HEREFORD_LAYER, ModelBullHereford::createBodyLayer);
		event.registerLayerDefinition(RenderCows.BULL_LONGHORN_LAYER, ModelBullLonghorn::createBodyLayer);
		event.registerLayerDefinition(RenderCows.CALF_LAYER, ModelCalf::createBodyLayer);
		event.registerLayerDefinition(RenderCows.CALF_ANGUS_LAYER, ModelCalfAngus::createBodyLayer);
		event.registerLayerDefinition(RenderCows.CALF_LONGHORN_LAYER, ModelCalfLonghorn::createBodyLayer);

		event.registerLayerDefinition(RenderPigs.SOW_LAYER, ModelSow::createBodyLayer);
		event.registerLayerDefinition(RenderPigs.SOW_HAMPSHIRE_LAYER, ModelSowHampshire::createBodyLayer);
		event.registerLayerDefinition(RenderPigs.SOW_LARGE_BLACK_LAYER, ModelSowLargeBlack::createBodyLayer);
		event.registerLayerDefinition(RenderPigs.HOG_LAYER, ModelHog::createBodyLayer);
		event.registerLayerDefinition(RenderPigs.HOG_HAMPSHIRE_LAYER, ModelHogHampshire::createBodyLayer);
		event.registerLayerDefinition(RenderPigs.HOG_LARGE_BLACK_LAYER, ModelHogLargeBlack::createBodyLayer);
		event.registerLayerDefinition(RenderPigs.PIGLET_LAYER, ModelPiglet::createBodyLayer);
		event.registerLayerDefinition(RenderPigs.PIGLET_HAMPSHIRE_LAYER, ModelPigletHampshire::createBodyLayer);

		event.registerLayerDefinition(RenderSheep.DORPER_LAYER, ModelDorperSheep::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.DORSET_EWE_LAYER, ModelDorsetEwe::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.DORSET_RAM_LAYER, ModelDorsetRam::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.FRIESIAN_LAYER, ModelFriesianSheep::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.JACOB_LAYER, ModelJacobSheep::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.MERINO_EWE_LAYER, ModelMerinoEwe::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.MERINO_RAM_LAYER, ModelMerinoRam::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.SUFFOLK_EWE_LAYER, ModelSuffolkEwe::createBodyLayer);
		event.registerLayerDefinition(RenderSheep.SUFFOLK_RAM_LAYER, ModelSuffolkRam::createBodyLayer);

		event.registerLayerDefinition(RenderGoats.DOE_ALPINE_LAYER, ModelDoeAlpine::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.BUCK_ALPINE_LAYER, ModelBuckAlpine::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.KID_ALPINE_LAYER, ModelKidAlpine::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.DOE_ANGORA_LAYER, ModelDoeAngora::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.BUCK_ANGORA_LAYER, ModelBuckAngora::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.KID_ANGORA_LAYER, ModelKidAngora::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.DOE_FAINTING_LAYER, ModelDoeFainting::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.BUCK_FAINTING_LAYER, ModelBuckFainting::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.KID_FAINTING_LAYER, ModelKidFainting::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.DOE_KIKO_LAYER, ModelDoeKiko::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.BUCK_KIKO_LAYER, ModelBuckKiko::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.KID_KIKO_LAYER, ModelKidKiko::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.DOE_KINDER_LAYER, ModelDoeKinder::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.BUCK_KINDER_LAYER, ModelBuckKinder::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.KID_KINDER_LAYER, ModelKidKinder::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.DOE_NIGERIAN_DWARF_LAYER, ModelDoeNigerianDwarf::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.BUCK_NIGERIAN_DWARF_LAYER, ModelBuckNigerianDwarf::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.KID_NIGERIAN_DWARF_LAYER, ModelKidNigerianDwarf::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.DOE_PYGMY_LAYER, ModelDoePygmy::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.BUCK_PYGMY_LAYER, ModelBuckPygmy::createBodyLayer);
		event.registerLayerDefinition(RenderGoats.KID_PYGMY_LAYER, ModelKidPygmy::createBodyLayer);

		event.registerLayerDefinition(RenderHorses.MARE_DRAFT_LAYER, ModelDraftHorseMare::createBodyLayer);
		event.registerLayerDefinition(RenderHorses.STALLION_DRAFT_LAYER, ModelDraftHorseStallion::createBodyLayer);
		event.registerLayerDefinition(RenderHorses.FOAL_DRAFT_LAYER, ModelDraftHorseFoal::createBodyLayer);

		event.registerLayerDefinition(RenderCart.CART_LAYER, ModelCart::createBodyLayer);
		event.registerLayerDefinition(RenderCart.CART_CHEST_LAYER, ModelCartChest::createBodyLayer);
		event.registerLayerDefinition(RenderTiller.TILLER_LAYER, ModelTiller::createBodyLayer);
		event.registerLayerDefinition(RenderWagon.WAGON_LAYER, ModelWagon::createBodyLayer);

		 
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderPeacock.LAYER, com.animania.client.model.placeholder.ModelPeacock::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderPeahen.LAYER, com.animania.client.model.placeholder.ModelPeafowl::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderPeachick.LAYER, com.animania.client.model.placeholder.ModelPeachick::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderFrog.LAYER, com.animania.client.model.placeholder.ModelFrog::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderToad.LAYER, com.animania.client.model.placeholder.ModelToad::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderFerret.LAYER, com.animania.client.model.placeholder.ModelFerret::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderHamster.LAYER, com.animania.client.model.placeholder.ModelHamster::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.placeholder.RenderHedgehog.LAYER, com.animania.client.model.placeholder.ModelHedgehog::createBodyLayer);

		 
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.cats.RenderCats.TABBY_LAYER,
				com.animania.addons.catsdogs.client.render.cats.RenderCats::createTabbyLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.cats.RenderCats.AMERICAN_SHORTHAIR_LAYER,
				com.animania.addons.catsdogs.client.render.cats.RenderCats::createAmericanShorthairLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.cats.RenderCats.ASIATIC_LAYER,
				com.animania.addons.catsdogs.client.render.cats.RenderCats::createAsiaticLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.cats.RenderCats.EXOTIC_LAYER,
				com.animania.addons.catsdogs.client.render.cats.RenderCats::createExoticLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.cats.RenderCats.OCELOT_LAYER,
				com.animania.addons.catsdogs.client.render.cats.RenderCats::createOcelotLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.cats.RenderCats.RAGDOLL_LAYER,
				com.animania.addons.catsdogs.client.render.cats.RenderCats::createRagdollLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.cats.RenderCats.SIAMESE_LAYER,
				com.animania.addons.catsdogs.client.render.cats.RenderCats::createSiameseLayer);

		 
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.PUG_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createPugLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.POMERANIAN_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createPomeranianLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.DACHSHUND_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createDachshundLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.CORGI_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createCorgiLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.CHIHUAHUA_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createChihuahuaLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.BLOODHOUND_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createBloodhoundLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.COLLIE_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createCollieLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.FOX_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createFoxLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.GERMAN_SHEPHERD_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createGermanShepherdLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.GREAT_DANE_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createGreatDaneLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.GREYHOUND_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createGreyhoundLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.HUSKY_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createHuskyLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.LABRADOR_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createLabradorLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.POODLE_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createPoodleLayer);
		event.registerLayerDefinition(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.WOLF_LAYER,
				com.animania.addons.catsdogs.client.render.dogs.RenderDogs::createWolfLayer);

		 
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitLop.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitLop::createBodyLayer);
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitRex.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitRex::createBodyLayer);
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitDutch.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitDutch::createBodyLayer);
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitHavana.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitHavana::createBodyLayer);
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitNewZealand.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitNewZealand::createBodyLayer);
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitJack.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitJack::createBodyLayer);
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitCottontail.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitCottontail::createBodyLayer);
		event.registerLayerDefinition(com.animania.addons.extra.client.render.rabbits.RenderRabbitChinchilla.LAYER,
				com.animania.addons.extra.client.model.rabbits.ModelRabbitChinchilla::createBodyLayer);
		event.registerLayerDefinition(com.animania.client.render.blockentity.BlockEntityTroughRenderer.MODEL_LAYER,
				com.animania.client.model.block.ModelTrough::createLayer);
		event.registerLayerDefinition(com.animania.client.render.blockentity.BlockEntityTroughRenderer.FOOD_LAYER,
				com.animania.client.model.block.ModelTrough::createFoodLayer);
		event.registerLayerDefinition(com.animania.client.render.blockentity.BlockEntityNestRenderer.MODEL_LAYER,
				com.animania.client.model.block.ModelNest::createLayer);
		event.registerLayerDefinition(com.animania.client.render.blockentity.BlockEntitySaltLickRenderer.MODEL_LAYER,
				com.animania.client.model.block.ModelSaltLick::createLayer);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event)
	{
		 
		event.registerEntityRenderer(FarmEntityTypes.HEN_LEGHORN.get(), RenderChickens.RenderHen::new);
		event.registerEntityRenderer(FarmEntityTypes.HEN_ORPINGTON.get(), RenderChickens.RenderHen::new);
		event.registerEntityRenderer(FarmEntityTypes.HEN_PLYMOUTH_ROCK.get(), RenderChickens.RenderHen::new);
		event.registerEntityRenderer(FarmEntityTypes.HEN_RHODE_ISLAND_RED.get(), RenderChickens.RenderHen::new);
		event.registerEntityRenderer(FarmEntityTypes.HEN_WYANDOTTE.get(), RenderChickens.RenderHen::new);

		 
		event.registerEntityRenderer(FarmEntityTypes.ROOSTER_LEGHORN.get(), RenderChickens.RenderRooster::new);
		event.registerEntityRenderer(FarmEntityTypes.ROOSTER_ORPINGTON.get(), RenderChickens.RenderRooster::new);
		event.registerEntityRenderer(FarmEntityTypes.ROOSTER_PLYMOUTH_ROCK.get(), RenderChickens.RenderRooster::new);
		event.registerEntityRenderer(FarmEntityTypes.ROOSTER_RHODE_ISLAND_RED.get(), RenderChickens.RenderRooster::new);
		event.registerEntityRenderer(FarmEntityTypes.ROOSTER_WYANDOTTE.get(), RenderChickens.RenderRooster::new);

		 
		event.registerEntityRenderer(FarmEntityTypes.CHICK_LEGHORN.get(), RenderChickens.RenderChick::new);
		event.registerEntityRenderer(FarmEntityTypes.CHICK_ORPINGTON.get(), RenderChickens.RenderChick::new);
		event.registerEntityRenderer(FarmEntityTypes.CHICK_PLYMOUTH_ROCK.get(), RenderChickens.RenderChick::new);
		event.registerEntityRenderer(FarmEntityTypes.CHICK_RHODE_ISLAND_RED.get(), RenderChickens.RenderChick::new);
		event.registerEntityRenderer(FarmEntityTypes.CHICK_WYANDOTTE.get(), RenderChickens.RenderChick::new);

		 
		event.registerEntityRenderer(FarmEntityTypes.COW_ANGUS.get(), RenderCows.RenderCowAngus::new);
		event.registerEntityRenderer(FarmEntityTypes.COW_LONGHORN.get(), RenderCows.RenderCowLonghorn::new);
		event.registerEntityRenderer(FarmEntityTypes.COW_FRIESIAN.get(), ctx -> new RenderCows.RenderCow<>(ctx, 1.24F));
		event.registerEntityRenderer(FarmEntityTypes.COW_HEREFORD.get(), ctx -> new RenderCows.RenderCow<>(ctx, 1.34F));
		event.registerEntityRenderer(FarmEntityTypes.COW_HIGHLAND.get(), ctx -> new RenderCows.RenderCow<>(ctx, 1.44F));
		event.registerEntityRenderer(FarmEntityTypes.COW_HOLSTEIN.get(), ctx -> new RenderCows.RenderCow<>(ctx, 1.24F));
		event.registerEntityRenderer(FarmEntityTypes.COW_JERSEY.get(), ctx -> new RenderCows.RenderCow<>(ctx, 1.34F));
		event.registerEntityRenderer(FarmEntityTypes.COW_MOOSHROOM.get(), ctx -> new RenderCows.RenderCow<>(ctx, 1.34F));

		 
		event.registerEntityRenderer(FarmEntityTypes.BULL_ANGUS.get(), RenderCows.RenderBullAngus::new);
		event.registerEntityRenderer(FarmEntityTypes.BULL_HEREFORD.get(), RenderCows.RenderBullHereford::new);
		event.registerEntityRenderer(FarmEntityTypes.BULL_LONGHORN.get(), RenderCows.RenderBullLonghorn::new);
		event.registerEntityRenderer(FarmEntityTypes.BULL_FRIESIAN.get(), ctx -> new RenderCows.RenderBull<>(ctx, 1.3F));
		event.registerEntityRenderer(FarmEntityTypes.BULL_HIGHLAND.get(), ctx -> new RenderCows.RenderBull<>(ctx, 1.5F));
		event.registerEntityRenderer(FarmEntityTypes.BULL_HOLSTEIN.get(), ctx -> new RenderCows.RenderBull<>(ctx, 1.3F));
		event.registerEntityRenderer(FarmEntityTypes.BULL_JERSEY.get(), ctx -> new RenderCows.RenderBull<>(ctx, 1.4F));
		event.registerEntityRenderer(FarmEntityTypes.BULL_MOOSHROOM.get(), ctx -> new RenderCows.RenderBull<>(ctx, 1.34F));

		 
		event.registerEntityRenderer(FarmEntityTypes.CALF_ANGUS.get(), RenderCows.RenderCalfAngus::new);
		event.registerEntityRenderer(FarmEntityTypes.CALF_LONGHORN.get(), RenderCows.RenderCalfLonghorn::new);
		event.registerEntityRenderer(FarmEntityTypes.CALF_FRIESIAN.get(), RenderCows.RenderCalf::new);
		event.registerEntityRenderer(FarmEntityTypes.CALF_HEREFORD.get(), RenderCows.RenderCalf::new);
		event.registerEntityRenderer(FarmEntityTypes.CALF_HIGHLAND.get(), RenderCows.RenderCalf::new);
		event.registerEntityRenderer(FarmEntityTypes.CALF_HOLSTEIN.get(), RenderCows.RenderCalf::new);
		event.registerEntityRenderer(FarmEntityTypes.CALF_JERSEY.get(), RenderCows.RenderCalf::new);
		event.registerEntityRenderer(FarmEntityTypes.CALF_MOOSHROOM.get(), RenderCows.RenderCalf::new);

		 
		event.registerEntityRenderer(FarmEntityTypes.SOW_HAMPSHIRE.get(), RenderPigs.RenderSowHampshire::new);
		event.registerEntityRenderer(FarmEntityTypes.HOG_HAMPSHIRE.get(), RenderPigs.RenderHogHampshire::new);
		event.registerEntityRenderer(FarmEntityTypes.PIGLET_HAMPSHIRE.get(), RenderPigs.RenderPigletHampshire::new);

		event.registerEntityRenderer(FarmEntityTypes.SOW_LARGE_BLACK.get(), RenderPigs.RenderSowLargeBlack::new);
		event.registerEntityRenderer(FarmEntityTypes.HOG_LARGE_BLACK.get(), RenderPigs.RenderHogLargeBlack::new);
		event.registerEntityRenderer(FarmEntityTypes.PIGLET_LARGE_BLACK.get(), ctx -> new RenderPigs.RenderPiglet<>(ctx, 1.14F));

		event.registerEntityRenderer(FarmEntityTypes.SOW_DUROC.get(), ctx -> new RenderPigs.RenderSow<>(ctx, 1.06F));
		event.registerEntityRenderer(FarmEntityTypes.HOG_DUROC.get(), ctx -> new RenderPigs.RenderHog<>(ctx, 1.18F));
		event.registerEntityRenderer(FarmEntityTypes.PIGLET_DUROC.get(), ctx -> new RenderPigs.RenderPiglet<>(ctx, 1.0F));

		event.registerEntityRenderer(FarmEntityTypes.SOW_LARGE_WHITE.get(), ctx -> new RenderPigs.RenderSow<>(ctx, 1.08F));
		event.registerEntityRenderer(FarmEntityTypes.HOG_LARGE_WHITE.get(), ctx -> new RenderPigs.RenderHog<>(ctx, 1.16F));
		event.registerEntityRenderer(FarmEntityTypes.PIGLET_LARGE_WHITE.get(), ctx -> new RenderPigs.RenderPiglet<>(ctx, 1.12F));

		event.registerEntityRenderer(FarmEntityTypes.SOW_OLD_SPOT.get(), ctx -> new RenderPigs.RenderSow<>(ctx, 1.12F));
		event.registerEntityRenderer(FarmEntityTypes.HOG_OLD_SPOT.get(), ctx -> new RenderPigs.RenderHog<>(ctx, 1.19F));
		event.registerEntityRenderer(FarmEntityTypes.PIGLET_OLD_SPOT.get(), ctx -> new RenderPigs.RenderPiglet<>(ctx, 1.1F));

		event.registerEntityRenderer(FarmEntityTypes.SOW_YORKSHIRE.get(), ctx -> new RenderPigs.RenderSow<>(ctx, 1.0F));
		event.registerEntityRenderer(FarmEntityTypes.HOG_YORKSHIRE.get(), ctx -> new RenderPigs.RenderHog<>(ctx, 1.10F));
		event.registerEntityRenderer(FarmEntityTypes.PIGLET_YORKSHIRE.get(), ctx -> new RenderPigs.RenderPiglet<>(ctx, 1.0F));

		 
		event.registerEntityRenderer(FarmEntityTypes.EWE_DORPER.get(), ctx -> new RenderSheep.RenderDorper<>(ctx, 0.60F));
		event.registerEntityRenderer(FarmEntityTypes.RAM_DORPER.get(), ctx -> new RenderSheep.RenderDorper<>(ctx, 0.68F));
		event.registerEntityRenderer(FarmEntityTypes.LAMB_DORPER.get(), RenderSheep.RenderLambDorper::new);

		event.registerEntityRenderer(FarmEntityTypes.EWE_DORSET.get(), RenderSheep.RenderDorsetEwe::new);
		event.registerEntityRenderer(FarmEntityTypes.RAM_DORSET.get(), RenderSheep.RenderDorsetRam::new);
		event.registerEntityRenderer(FarmEntityTypes.LAMB_DORSET.get(), RenderSheep.RenderLambDorset::new);

		event.registerEntityRenderer(FarmEntityTypes.EWE_FRIESIAN.get(), ctx -> new RenderSheep.RenderFriesian<>(ctx, 0.61F));
		event.registerEntityRenderer(FarmEntityTypes.RAM_FRIESIAN.get(), ctx -> new RenderSheep.RenderFriesian<>(ctx, 0.65F));
		event.registerEntityRenderer(FarmEntityTypes.LAMB_FRIESIAN.get(), RenderSheep.RenderLambFriesian::new);

		event.registerEntityRenderer(FarmEntityTypes.EWE_JACOB.get(), ctx -> new RenderSheep.RenderJacob<>(ctx, 0.48F));
		event.registerEntityRenderer(FarmEntityTypes.RAM_JACOB.get(), ctx -> new RenderSheep.RenderJacob<>(ctx, 0.52F));
		event.registerEntityRenderer(FarmEntityTypes.LAMB_JACOB.get(), RenderSheep.RenderLambJacob::new);

		event.registerEntityRenderer(FarmEntityTypes.EWE_MERINO.get(), RenderSheep.RenderMerinoEwe::new);
		event.registerEntityRenderer(FarmEntityTypes.RAM_MERINO.get(), RenderSheep.RenderMerinoRam::new);
		event.registerEntityRenderer(FarmEntityTypes.LAMB_MERINO.get(), RenderSheep.RenderLambMerino::new);

		event.registerEntityRenderer(FarmEntityTypes.EWE_SUFFOLK.get(), RenderSheep.RenderSuffolkEwe::new);
		event.registerEntityRenderer(FarmEntityTypes.RAM_SUFFOLK.get(), RenderSheep.RenderSuffolkRam::new);
		event.registerEntityRenderer(FarmEntityTypes.LAMB_SUFFOLK.get(), RenderSheep.RenderLambSuffolk::new);

		 
		event.registerEntityRenderer(FarmEntityTypes.DOE_ALPINE.get(), RenderGoats.RenderDoeAlpine::new);
		event.registerEntityRenderer(FarmEntityTypes.BUCK_ALPINE.get(), RenderGoats.RenderBuckAlpine::new);
		event.registerEntityRenderer(FarmEntityTypes.KID_ALPINE.get(), RenderGoats.RenderKidAlpine::new);
		event.registerEntityRenderer(FarmEntityTypes.DOE_ANGORA.get(), RenderGoats.RenderDoeAngora::new);
		event.registerEntityRenderer(FarmEntityTypes.BUCK_ANGORA.get(), RenderGoats.RenderBuckAngora::new);
		event.registerEntityRenderer(FarmEntityTypes.KID_ANGORA.get(), RenderGoats.RenderKidAngora::new);
		event.registerEntityRenderer(FarmEntityTypes.DOE_FAINTING.get(), RenderGoats.RenderDoeFainting::new);
		event.registerEntityRenderer(FarmEntityTypes.BUCK_FAINTING.get(), RenderGoats.RenderBuckFainting::new);
		event.registerEntityRenderer(FarmEntityTypes.KID_FAINTING.get(), RenderGoats.RenderKidFainting::new);
		event.registerEntityRenderer(FarmEntityTypes.DOE_KIKO.get(), RenderGoats.RenderDoeKiko::new);
		event.registerEntityRenderer(FarmEntityTypes.BUCK_KIKO.get(), RenderGoats.RenderBuckKiko::new);
		event.registerEntityRenderer(FarmEntityTypes.KID_KIKO.get(), RenderGoats.RenderKidKiko::new);
		event.registerEntityRenderer(FarmEntityTypes.DOE_KINDER.get(), RenderGoats.RenderDoeKinder::new);
		event.registerEntityRenderer(FarmEntityTypes.BUCK_KINDER.get(), RenderGoats.RenderBuckKinder::new);
		event.registerEntityRenderer(FarmEntityTypes.KID_KINDER.get(), RenderGoats.RenderKidKinder::new);
		event.registerEntityRenderer(FarmEntityTypes.DOE_NIGERIAN_DWARF.get(), RenderGoats.RenderDoeNigerianDwarf::new);
		event.registerEntityRenderer(FarmEntityTypes.BUCK_NIGERIAN_DWARF.get(), RenderGoats.RenderBuckNigerianDwarf::new);
		event.registerEntityRenderer(FarmEntityTypes.KID_NIGERIAN_DWARF.get(), RenderGoats.RenderKidNigerianDwarf::new);
		event.registerEntityRenderer(FarmEntityTypes.DOE_PYGMY.get(), RenderGoats.RenderDoePygmy::new);
		event.registerEntityRenderer(FarmEntityTypes.BUCK_PYGMY.get(), RenderGoats.RenderBuckPygmy::new);
		event.registerEntityRenderer(FarmEntityTypes.KID_PYGMY.get(), RenderGoats.RenderKidPygmy::new);

		event.registerEntityRenderer(FarmEntityTypes.MARE_DRAFT.get(), RenderHorses.RenderMareDraftHorse::new);
		event.registerEntityRenderer(FarmEntityTypes.STALLION_DRAFT.get(), RenderHorses.RenderStallionDraftHorse::new);
		event.registerEntityRenderer(FarmEntityTypes.FOAL_DRAFT.get(), RenderHorses.RenderFoalDraftHorse::new);

		event.registerEntityRenderer(FarmEntityTypes.CART.get(), RenderCart::new);
		event.registerEntityRenderer(FarmEntityTypes.TILLER.get(), RenderTiller::new);
		event.registerEntityRenderer(FarmEntityTypes.WAGON.get(), RenderWagon::new);
		event.registerBlockEntityRenderer(FarmBlocks.HIVE_BLOCK_ENTITY.get(), BlockEntityHiveRenderer::new);
		event.registerBlockEntityRenderer(com.animania.addons.extra.ExtraBlocks.HAMSTER_WHEEL_BLOCK_ENTITY.get(),
				com.animania.addons.extra.client.render.blockentity.BlockEntityHamsterWheelRenderer::new);
		event.registerBlockEntityRenderer(com.animania.addons.catsdogs.CatsDogsBlocks.PROP_BLOCK_ENTITY.get(),
				com.animania.addons.catsdogs.client.render.blockentity.BlockEntityPropRenderer::new);
		event.registerBlockEntityRenderer(com.animania.addons.catsdogs.CatsDogsBlocks.PET_BOWL_BLOCK_ENTITY.get(),
				com.animania.addons.catsdogs.client.render.blockentity.BlockEntityPetBowlRenderer::new);
		event.registerBlockEntityRenderer(com.animania.common.blocks.CommonBlockEntities.TROUGH.get(),
				com.animania.client.render.blockentity.BlockEntityTroughRenderer::new);
		event.registerBlockEntityRenderer(com.animania.common.blocks.CommonBlockEntities.NEST.get(),
				com.animania.client.render.blockentity.BlockEntityNestRenderer::new);
		event.registerBlockEntityRenderer(com.animania.common.blocks.CommonBlockEntities.SALT_LICK.get(),
				com.animania.client.render.blockentity.BlockEntitySaltLickRenderer::new);

		 
		registerAmphibianRenderers(event);
		registerPeafowlRenderers(event);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.FERRET_GREY.get(),
				ctx -> new com.animania.client.render.placeholder.RenderFerret<>(ctx,
						com.animania.addons.extra.common.entity.rodents.EntityFerretBase::getResourceLocation));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.FERRET_WHITE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderFerret<>(ctx,
						com.animania.addons.extra.common.entity.rodents.EntityFerretBase::getResourceLocation));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.HAMSTER.get(),
				com.animania.client.render.placeholder.RenderHamster::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.HEDGEHOG.get(),
				ctx -> new com.animania.client.render.placeholder.RenderHedgehog<>(ctx,
						com.animania.addons.extra.common.entity.rodents.EntityHedgehogBase::getResourceLocation));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.HEDGEHOG_ALBINO.get(),
				ctx -> new com.animania.client.render.placeholder.RenderHedgehog<>(ctx,
						com.animania.addons.extra.common.entity.rodents.EntityHedgehogBase::getResourceLocation));

		 
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_LOP.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitLop::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_LOP.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitLop::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_LOP.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitLop::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_REX.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitRex::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_REX.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitRex::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_REX.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitRex::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_DUTCH.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitDutch::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_DUTCH.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitDutch::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_DUTCH.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitDutch::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_HAVANA.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitHavana::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_HAVANA.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitHavana::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_HAVANA.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitHavana::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_NEW_ZEALAND.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitNewZealand::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_NEW_ZEALAND.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitNewZealand::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_NEW_ZEALAND.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitNewZealand::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_JACK.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitJack::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_JACK.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitJack::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_JACK.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitJack::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_COTTONTAIL.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitCottontail::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_COTTONTAIL.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitCottontail::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_COTTONTAIL.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitCottontail::new);

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_BUCK_CHINCHILLA.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitChinchilla::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_DOE_CHINCHILLA.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitChinchilla::new);
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.RABBIT_KIT_CHINCHILLA.get(), com.animania.addons.extra.client.render.rabbits.RenderRabbitChinchilla::new);

		 
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_BLOODHOUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createBloodhoundModel(ctx), 1F, 0, -.1D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_BLOODHOUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createBloodhoundModel(ctx), .9F, 0, -.1D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_BLOODHOUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createBloodhoundModel(ctx), .5F, 0, -.1D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_CHIHUAHUA.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createChihuahuaModel(ctx), .6F, 0, .1D, -.5D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_CHIHUAHUA.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createChihuahuaModel(ctx), .5F, 0, .1D, -.5D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_CHIHUAHUA.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createChihuahuaModel(ctx), .3F, 0, .1D, -.5D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_COLLIE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createCollieModel(ctx), 1F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_COLLIE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createCollieModel(ctx), .9F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_COLLIE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createCollieModel(ctx), .5F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_CORGI.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createCorgiModel(ctx), 1F, 0, -.05D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_CORGI.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createCorgiModel(ctx), .9F, 0, -.05D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_CORGI.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createCorgiModel(ctx), .5F, 0, -.05D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_DACHSHUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createDachshundModel(ctx), 1.2F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_DACHSHUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createDachshundModel(ctx), 1.1F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_DACHSHUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createDachshundModel(ctx), .6F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_FOX.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogFox<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createFoxModel(ctx)));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_FOX.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogFox<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createFoxModel(ctx)));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_FOX.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogFox<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createFoxModel(ctx)));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_GERMAN_SHEPHERD.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGermanShepherdModel(ctx), 1F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_GERMAN_SHEPHERD.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGermanShepherdModel(ctx), .9F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_GERMAN_SHEPHERD.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGermanShepherdModel(ctx), .5F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_GREAT_DANE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGreatDaneModel(ctx), 1F, 0, -.1D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_GREAT_DANE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGreatDaneModel(ctx), .9F, 0, -.1D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_GREAT_DANE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGreatDaneModel(ctx), .5F, 0, -.1D, 0));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_GREYHOUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGreyhoundModel(ctx), .8F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_GREYHOUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGreyhoundModel(ctx), .7F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_GREYHOUND.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createGreyhoundModel(ctx), .4F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_HUSKY.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createHuskyModel(ctx), 1F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_HUSKY.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createHuskyModel(ctx), .9F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_HUSKY.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createHuskyModel(ctx), .5F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_LABRADOR.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogLabrador<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createLabradorModel(ctx), 1F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_LABRADOR.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogLabrador<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createLabradorModel(ctx), .9F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_LABRADOR.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogLabrador<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createLabradorModel(ctx), .5F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_POMERANIAN.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createPomeranianModel(ctx), .6F, 0, 0, -.5D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_POMERANIAN.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createPomeranianModel(ctx), .5F, 0, 0, -.5D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_POMERANIAN.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createPomeranianModel(ctx), .3F, 0, 0, -.25D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_POODLE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogPoodle<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createPoodleModel(ctx), 1F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_POODLE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogPoodle<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createPoodleModel(ctx), .9F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_POODLE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogPoodle<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createPoodleModel(ctx), .5F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_PUG.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityMalePug>(ctx,
						new com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric<com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityMalePug>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.PUG_LAYER), "body",
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.BASELINE,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SLEEP_TARGET,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_POSE_X,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_BODY_Y,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_BODY_Z,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.HEAD_TRACK_OFFSET),
						0.8F, 0D, 0D, -0.5D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_PUG.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityFemalePug>(ctx,
						new com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric<com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityFemalePug>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.PUG_LAYER), "body",
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.BASELINE,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SLEEP_TARGET,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_POSE_X,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_BODY_Y,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_BODY_Z,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.HEAD_TRACK_OFFSET),
						0.7F, 0D, 0D, -0.5D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_PUG.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogGeneric<com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityPuppyPug>(ctx,
						new com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric<com.animania.addons.catsdogs.common.entity.canids.DogPug.EntityPuppyPug>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.dogs.RenderDogs.PUG_LAYER), "body",
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.BASELINE,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SLEEP_TARGET,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_POSE_X,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_BODY_Y,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.SIT_BODY_Z,
								com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.HEAD_TRACK_OFFSET),
						0.4F, 0D, 0D, -0.25D));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_MALE_WOLF.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogWolf<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createWolfModel(ctx), 1F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_FEMALE_WOLF.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogWolf<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createWolfModel(ctx), .9F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.DOG_PUPPY_WOLF.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.dogs.RenderDogWolf<>(ctx,
						com.animania.addons.catsdogs.client.render.dogs.RenderDogs.createWolfModel(ctx), .5F));

		 
		 
		 
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_AMERICAN_SHORTHAIR.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.AMERICAN_SHORTHAIR_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatAmericanShorthair.BASELINE),
						0.65F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_AMERICAN_SHORTHAIR.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.AMERICAN_SHORTHAIR_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatAmericanShorthair.BASELINE),
						0.635F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_AMERICAN_SHORTHAIR.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.AMERICAN_SHORTHAIR_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatAmericanShorthair.BASELINE),
						0.3F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_ASIATIC.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.ASIATIC_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatAsiatic.BASELINE),
						0.78F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_ASIATIC.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.ASIATIC_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatAsiatic.BASELINE),
						0.765F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_ASIATIC.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.ASIATIC_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatAsiatic.BASELINE),
						0.35F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_EXOTIC.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.EXOTIC_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatExotic.BASELINE),
						0.60F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_EXOTIC.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.EXOTIC_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatExotic.BASELINE),
						0.585F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_EXOTIC.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.EXOTIC_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatExotic.BASELINE),
						0.3F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_NORWEGIAN.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.RAGDOLL_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatRagdoll.BASELINE),
						0.59F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_NORWEGIAN.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.RAGDOLL_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatRagdoll.BASELINE),
						0.575F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_NORWEGIAN.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.RAGDOLL_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatRagdoll.BASELINE),
						0.3F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_OCELOT.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.OCELOT_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatOcelot.BASELINE),
						0.85F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_OCELOT.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.OCELOT_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatOcelot.BASELINE),
						0.82F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_OCELOT.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.OCELOT_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatOcelot.BASELINE),
						0.3F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_RAGDOLL.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.RAGDOLL_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatRagdoll.BASELINE),
						0.67F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_RAGDOLL.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.RAGDOLL_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatRagdoll.BASELINE),
						0.655F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_RAGDOLL.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.RAGDOLL_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatRagdoll.BASELINE),
						0.3F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_SIAMESE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.SIAMESE_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatSiamese.BASELINE),
						0.57F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_SIAMESE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.SIAMESE_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatSiamese.BASELINE),
						0.555F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_SIAMESE.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.SIAMESE_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatSiamese.BASELINE),
						0.3F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_TOM_TABBY.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityTomBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.TABBY_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatTabby.BASELINE),
						0.70F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_QUEEN_TABBY.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityQueenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.TABBY_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatTabby.BASELINE),
						0.68F));
		event.registerEntityRenderer(com.animania.addons.catsdogs.CatsDogsEntityTypes.CAT_KITTEN_TABBY.get(), ctx ->
				new com.animania.addons.catsdogs.client.render.cats.RenderCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(ctx,
						new com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric<com.animania.addons.catsdogs.common.entity.felids.EntityKittenBase>(
								ctx.bakeLayer(com.animania.addons.catsdogs.client.render.cats.RenderCats.TABBY_LAYER),
								com.animania.addons.catsdogs.client.model.cats.ModelCatTabby.BASELINE),
						0.3F));
	}

	 




	private static void registerAmphibianRenderers(EntityRenderersEvent.RegisterRenderers event)
	{
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.FROG.get(),
				ctx -> new com.animania.client.render.placeholder.RenderFrog<>(ctx,
						e -> {
							if (e.hasCustomName() && "Pepe".equals(e.getName().getString()))
								return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/amphibians/pepe_frog.png");
							if (e.hasCustomName() && "me_irl".equalsIgnoreCase(e.getName().getString())
									&& java.time.LocalDate.now().getDayOfWeek() == java.time.DayOfWeek.WEDNESDAY)
								return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/amphibians/frog_white.png");
							return ResourceLocation.fromNamespaceAndPath(Animania.MODID,
									"textures/entity/amphibians/frog_" + ((com.animania.addons.extra.common.entity.amphibians.EntityFrogs) e).getFrogsType() + ".png");
						}));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.DART_FROG.get(),
				ctx -> new com.animania.client.render.placeholder.RenderFrog<>(ctx,
						e -> ResourceLocation.fromNamespaceAndPath(Animania.MODID,
								"textures/entity/amphibians/dart_frog_" + ((com.animania.addons.extra.common.entity.amphibians.EntityDartFrogs) e).getFrogsType() + ".png")));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.TOAD.get(),
				ctx -> new com.animania.client.render.placeholder.RenderToad<>(ctx,
						e -> ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/amphibians/toad.png")));
	}

	 



	private static void registerPeafowlRenderers(EntityRenderersEvent.RegisterRenderers event)
	{
		java.util.function.Function<com.animania.addons.extra.common.entity.peafowl.EntityAnimaniaPeacock, ResourceLocation> texture =
				com.animania.addons.extra.common.entity.peafowl.EntityAnimaniaPeacock::getResourceLocation;

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACOCK_BLUE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeacock<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEAFOWL_BLUE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeahen<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACHICK_BLUE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeachick<>(ctx, texture));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACOCK_WHITE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeacock<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEAFOWL_WHITE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeahen<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACHICK_WHITE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeachick<>(ctx, texture));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACOCK_TAUPE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeacock<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEAFOWL_TAUPE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeahen<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACHICK_TAUPE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeachick<>(ctx, texture));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACOCK_PURPLE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeacock<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEAFOWL_PURPLE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeahen<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACHICK_PURPLE.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeachick<>(ctx, texture));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACOCK_PEACH.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeacock<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEAFOWL_PEACH.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeahen<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACHICK_PEACH.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeachick<>(ctx, texture));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACOCK_OPAL.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeacock<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEAFOWL_OPAL.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeahen<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACHICK_OPAL.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeachick<>(ctx, texture));

		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACOCK_CHARCOAL.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeacock<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEAFOWL_CHARCOAL.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeahen<>(ctx, texture));
		event.registerEntityRenderer(com.animania.addons.extra.ExtraEntityTypes.PEACHICK_CHARCOAL.get(),
				ctx -> new com.animania.client.render.placeholder.RenderPeachick<>(ctx, texture));
	}
}
