package com.animania.addons.farm;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.chickens.ChickenLeghorn;
import com.animania.addons.farm.common.entity.chickens.ChickenOrpington;
import com.animania.addons.farm.common.entity.chickens.ChickenPlymouthRock;
import com.animania.addons.farm.common.entity.chickens.ChickenRhodeIslandRed;
import com.animania.addons.farm.common.entity.chickens.ChickenWyandotte;
import com.animania.addons.farm.common.entity.chickens.EntityAnimaniaChicken;
import com.animania.addons.farm.common.entity.chickens.EntityChickBase;
import com.animania.addons.farm.common.entity.chickens.EntityHenBase;
import com.animania.addons.farm.common.entity.chickens.EntityRoosterBase;
import com.animania.addons.farm.common.entity.cows.CowAngus;
import com.animania.addons.farm.common.entity.cows.CowFriesian;
import com.animania.addons.farm.common.entity.cows.CowHereford;
import com.animania.addons.farm.common.entity.cows.CowHighland;
import com.animania.addons.farm.common.entity.cows.CowHolstein;
import com.animania.addons.farm.common.entity.cows.CowJersey;
import com.animania.addons.farm.common.entity.cows.CowLonghorn;
import com.animania.addons.farm.common.entity.cows.CowMooshroom;
import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.animania.addons.farm.common.entity.cows.EntityBullBase;
import com.animania.addons.farm.common.entity.cows.EntityCalfBase;
import com.animania.addons.farm.common.entity.cows.EntityCowBase;
import com.animania.addons.farm.common.entity.pigs.EntityAnimaniaPig;
import com.animania.addons.farm.common.entity.pigs.EntityHogBase;
import com.animania.addons.farm.common.entity.pigs.EntityPigletBase;
import com.animania.addons.farm.common.entity.pigs.EntitySowBase;
import com.animania.addons.farm.common.entity.pigs.PigDuroc;
import com.animania.addons.farm.common.entity.pigs.PigHampshire;
import com.animania.addons.farm.common.entity.pigs.PigLargeBlack;
import com.animania.addons.farm.common.entity.pigs.PigLargeWhite;
import com.animania.addons.farm.common.entity.pigs.PigOldSpot;
import com.animania.addons.farm.common.entity.pigs.PigYorkshire;
import com.animania.addons.farm.common.entity.sheep.EntityAnimaniaSheep;
import com.animania.addons.farm.common.entity.sheep.EntityEweBase;
import com.animania.addons.farm.common.entity.sheep.EntityLambBase;
import com.animania.addons.farm.common.entity.sheep.EntityRamBase;
import com.animania.addons.farm.common.entity.sheep.SheepDorper;
import com.animania.addons.farm.common.entity.sheep.SheepDorset;
import com.animania.addons.farm.common.entity.sheep.SheepFriesian;
import com.animania.addons.farm.common.entity.sheep.SheepJacob;
import com.animania.addons.farm.common.entity.sheep.SheepMerino;
import com.animania.addons.farm.common.entity.sheep.SheepSuffolk;
import com.animania.addons.farm.common.entity.goats.EntityBuckBase;
import com.animania.addons.farm.common.entity.goats.EntityDoeBase;
import com.animania.addons.farm.common.entity.goats.EntityKidBase;
import com.animania.addons.farm.common.entity.goats.GoatAlpine;
import com.animania.addons.farm.common.entity.goats.GoatAngora;
import com.animania.addons.farm.common.entity.goats.GoatFainting;
import com.animania.addons.farm.common.entity.goats.GoatKiko;
import com.animania.addons.farm.common.entity.goats.GoatKinder;
import com.animania.addons.farm.common.entity.goats.GoatNigerianDwarf;
import com.animania.addons.farm.common.entity.goats.GoatPygmy;
import com.animania.addons.farm.common.entity.horses.EntityFoalBase;
import com.animania.addons.farm.common.entity.horses.EntityMareBase;
import com.animania.addons.farm.common.entity.horses.EntityStallionBase;
import com.animania.addons.farm.common.entity.horses.HorseDraft;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

 





public class FarmEntityTypes
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Animania.MODID);

	 
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenLeghorn.EntityHenLeghorn>> HEN_LEGHORN =
			registerHen("hen_leghorn", ChickenLeghorn.EntityHenLeghorn::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenLeghorn.EntityRoosterLeghorn>> ROOSTER_LEGHORN =
			registerRooster("rooster_leghorn", ChickenLeghorn.EntityRoosterLeghorn::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenLeghorn.EntityChickLeghorn>> CHICK_LEGHORN =
			registerChick("chick_leghorn", ChickenLeghorn.EntityChickLeghorn::new);

	 
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenOrpington.EntityHenOrpington>> HEN_ORPINGTON =
			registerHen("hen_orpington", ChickenOrpington.EntityHenOrpington::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenOrpington.EntityRoosterOrpington>> ROOSTER_ORPINGTON =
			registerRooster("rooster_orpington", ChickenOrpington.EntityRoosterOrpington::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenOrpington.EntityChickOrpington>> CHICK_ORPINGTON =
			registerChick("chick_orpington", ChickenOrpington.EntityChickOrpington::new);

	 
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenPlymouthRock.EntityHenPlymouthRock>> HEN_PLYMOUTH_ROCK =
			registerHen("hen_plymouth_rock", ChickenPlymouthRock.EntityHenPlymouthRock::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenPlymouthRock.EntityRoosterPlymouthRock>> ROOSTER_PLYMOUTH_ROCK =
			registerRooster("rooster_plymouth_rock", ChickenPlymouthRock.EntityRoosterPlymouthRock::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenPlymouthRock.EntityChickPlymouthRock>> CHICK_PLYMOUTH_ROCK =
			registerChick("chick_plymouth_rock", ChickenPlymouthRock.EntityChickPlymouthRock::new);

	 
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenRhodeIslandRed.EntityHenRhodeIslandRed>> HEN_RHODE_ISLAND_RED =
			registerHen("hen_rhode_island_red", ChickenRhodeIslandRed.EntityHenRhodeIslandRed::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenRhodeIslandRed.EntityRoosterRhodeIslandRed>> ROOSTER_RHODE_ISLAND_RED =
			registerRooster("rooster_rhode_island_red", ChickenRhodeIslandRed.EntityRoosterRhodeIslandRed::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenRhodeIslandRed.EntityChickRhodeIslandRed>> CHICK_RHODE_ISLAND_RED =
			registerChick("chick_rhode_island_red", ChickenRhodeIslandRed.EntityChickRhodeIslandRed::new);

	 
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenWyandotte.EntityHenWyandotte>> HEN_WYANDOTTE =
			registerHen("hen_wyandotte", ChickenWyandotte.EntityHenWyandotte::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenWyandotte.EntityRoosterWyandotte>> ROOSTER_WYANDOTTE =
			registerRooster("rooster_wyandotte", ChickenWyandotte.EntityRoosterWyandotte::new);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenWyandotte.EntityChickWyandotte>> CHICK_WYANDOTTE =
			registerChick("chick_wyandotte", ChickenWyandotte.EntityChickWyandotte::new);

	 

	public static final DeferredHolder<EntityType<?>, EntityType<CowAngus.EntityCowAngus>> COW_ANGUS = registerCow("cow_angus", CowAngus.EntityCowAngus::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowAngus.EntityBullAngus>> BULL_ANGUS = registerBull("bull_angus", CowAngus.EntityBullAngus::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowAngus.EntityCalfAngus>> CALF_ANGUS = registerCalf("calf_angus", CowAngus.EntityCalfAngus::new);

	public static final DeferredHolder<EntityType<?>, EntityType<CowFriesian.EntityCowFriesian>> COW_FRIESIAN = registerCow("cow_friesian", CowFriesian.EntityCowFriesian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowFriesian.EntityBullFriesian>> BULL_FRIESIAN = registerBull("bull_friesian", CowFriesian.EntityBullFriesian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowFriesian.EntityCalfFriesian>> CALF_FRIESIAN = registerCalf("calf_friesian", CowFriesian.EntityCalfFriesian::new);

	public static final DeferredHolder<EntityType<?>, EntityType<CowHereford.EntityCowHereford>> COW_HEREFORD = registerCow("cow_hereford", CowHereford.EntityCowHereford::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowHereford.EntityBullHereford>> BULL_HEREFORD = registerBull("bull_hereford", CowHereford.EntityBullHereford::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowHereford.EntityCalfHereford>> CALF_HEREFORD = registerCalf("calf_hereford", CowHereford.EntityCalfHereford::new);

	public static final DeferredHolder<EntityType<?>, EntityType<CowHighland.EntityCowHighland>> COW_HIGHLAND = registerCow("cow_highland", CowHighland.EntityCowHighland::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowHighland.EntityBullHighland>> BULL_HIGHLAND = registerBull("bull_highland", CowHighland.EntityBullHighland::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowHighland.EntityCalfHighland>> CALF_HIGHLAND = registerCalf("calf_highland", CowHighland.EntityCalfHighland::new);

	public static final DeferredHolder<EntityType<?>, EntityType<CowHolstein.EntityCowHolstein>> COW_HOLSTEIN = registerCow("cow_holstein", CowHolstein.EntityCowHolstein::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowHolstein.EntityBullHolstein>> BULL_HOLSTEIN = registerBull("bull_holstein", CowHolstein.EntityBullHolstein::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowHolstein.EntityCalfHolstein>> CALF_HOLSTEIN = registerCalf("calf_holstein", CowHolstein.EntityCalfHolstein::new);

	public static final DeferredHolder<EntityType<?>, EntityType<CowJersey.EntityCowJersey>> COW_JERSEY = registerCow("cow_jersey", CowJersey.EntityCowJersey::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowJersey.EntityBullJersey>> BULL_JERSEY = registerBull("bull_jersey", CowJersey.EntityBullJersey::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowJersey.EntityCalfJersey>> CALF_JERSEY = registerCalf("calf_jersey", CowJersey.EntityCalfJersey::new);

	public static final DeferredHolder<EntityType<?>, EntityType<CowLonghorn.EntityCowLonghorn>> COW_LONGHORN = registerCow("cow_longhorn", CowLonghorn.EntityCowLonghorn::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowLonghorn.EntityBullLonghorn>> BULL_LONGHORN = registerBull("bull_longhorn", CowLonghorn.EntityBullLonghorn::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowLonghorn.EntityCalfLonghorn>> CALF_LONGHORN = registerCalf("calf_longhorn", CowLonghorn.EntityCalfLonghorn::new);

	public static final DeferredHolder<EntityType<?>, EntityType<CowMooshroom.EntityCowMooshroom>> COW_MOOSHROOM = registerCow("cow_mooshroom", CowMooshroom.EntityCowMooshroom::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowMooshroom.EntityBullMooshroom>> BULL_MOOSHROOM = registerBull("bull_mooshroom", CowMooshroom.EntityBullMooshroom::new);
	public static final DeferredHolder<EntityType<?>, EntityType<CowMooshroom.EntityCalfMooshroom>> CALF_MOOSHROOM = registerCalf("calf_mooshroom", CowMooshroom.EntityCalfMooshroom::new);

	 

	public static final DeferredHolder<EntityType<?>, EntityType<PigDuroc.EntitySowDuroc>> SOW_DUROC = registerSow("sow_duroc", PigDuroc.EntitySowDuroc::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigDuroc.EntityHogDuroc>> HOG_DUROC = registerHog("hog_duroc", PigDuroc.EntityHogDuroc::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigDuroc.EntityPigletDuroc>> PIGLET_DUROC = registerPiglet("piglet_duroc", PigDuroc.EntityPigletDuroc::new);

	public static final DeferredHolder<EntityType<?>, EntityType<PigHampshire.EntitySowHampshire>> SOW_HAMPSHIRE = registerSow("sow_hampshire", PigHampshire.EntitySowHampshire::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigHampshire.EntityHogHampshire>> HOG_HAMPSHIRE = registerHog("hog_hampshire", PigHampshire.EntityHogHampshire::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigHampshire.EntityPigletHampshire>> PIGLET_HAMPSHIRE = registerPiglet("piglet_hampshire", PigHampshire.EntityPigletHampshire::new);

	public static final DeferredHolder<EntityType<?>, EntityType<PigLargeBlack.EntitySowLargeBlack>> SOW_LARGE_BLACK = registerSow("sow_large_black", PigLargeBlack.EntitySowLargeBlack::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigLargeBlack.EntityHogLargeBlack>> HOG_LARGE_BLACK = registerHog("hog_large_black", PigLargeBlack.EntityHogLargeBlack::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigLargeBlack.EntityPigletLargeBlack>> PIGLET_LARGE_BLACK = registerPiglet("piglet_large_black", PigLargeBlack.EntityPigletLargeBlack::new);

	public static final DeferredHolder<EntityType<?>, EntityType<PigLargeWhite.EntitySowLargeWhite>> SOW_LARGE_WHITE = registerSow("sow_large_white", PigLargeWhite.EntitySowLargeWhite::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigLargeWhite.EntityHogLargeWhite>> HOG_LARGE_WHITE = registerHog("hog_large_white", PigLargeWhite.EntityHogLargeWhite::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigLargeWhite.EntityPigletLargeWhite>> PIGLET_LARGE_WHITE = registerPiglet("piglet_large_white", PigLargeWhite.EntityPigletLargeWhite::new);

	public static final DeferredHolder<EntityType<?>, EntityType<PigOldSpot.EntitySowOldSpot>> SOW_OLD_SPOT = registerSow("sow_old_spot", PigOldSpot.EntitySowOldSpot::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigOldSpot.EntityHogOldSpot>> HOG_OLD_SPOT = registerHog("hog_old_spot", PigOldSpot.EntityHogOldSpot::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigOldSpot.EntityPigletOldSpot>> PIGLET_OLD_SPOT = registerPiglet("piglet_old_spot", PigOldSpot.EntityPigletOldSpot::new);

	public static final DeferredHolder<EntityType<?>, EntityType<PigYorkshire.EntitySowYorkshire>> SOW_YORKSHIRE = registerSow("sow_yorkshire", PigYorkshire.EntitySowYorkshire::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigYorkshire.EntityHogYorkshire>> HOG_YORKSHIRE = registerHog("hog_yorkshire", PigYorkshire.EntityHogYorkshire::new);
	public static final DeferredHolder<EntityType<?>, EntityType<PigYorkshire.EntityPigletYorkshire>> PIGLET_YORKSHIRE = registerPiglet("piglet_yorkshire", PigYorkshire.EntityPigletYorkshire::new);

	 

	public static final DeferredHolder<EntityType<?>, EntityType<SheepDorper.EntityEweDorper>> EWE_DORPER = registerEwe("ewe_dorper", SheepDorper.EntityEweDorper::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepDorper.EntityRamDorper>> RAM_DORPER = registerRam("ram_dorper", SheepDorper.EntityRamDorper::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepDorper.EntityLambDorper>> LAMB_DORPER = registerLamb("lamb_dorper", SheepDorper.EntityLambDorper::new);

	public static final DeferredHolder<EntityType<?>, EntityType<SheepDorset.EntityEweDorset>> EWE_DORSET = registerEwe("ewe_dorset", SheepDorset.EntityEweDorset::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepDorset.EntityRamDorset>> RAM_DORSET = registerRam("ram_dorset", SheepDorset.EntityRamDorset::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepDorset.EntityLambDorset>> LAMB_DORSET = registerLamb("lamb_dorset", SheepDorset.EntityLambDorset::new);

	public static final DeferredHolder<EntityType<?>, EntityType<SheepFriesian.EntityEweFriesian>> EWE_FRIESIAN = registerEwe("ewe_friesian", SheepFriesian.EntityEweFriesian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepFriesian.EntityRamFriesian>> RAM_FRIESIAN = registerRam("ram_friesian", SheepFriesian.EntityRamFriesian::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepFriesian.EntityLambFriesian>> LAMB_FRIESIAN = registerLamb("lamb_friesian", SheepFriesian.EntityLambFriesian::new);

	public static final DeferredHolder<EntityType<?>, EntityType<SheepJacob.EntityEweJacob>> EWE_JACOB = registerEwe("ewe_jacob", SheepJacob.EntityEweJacob::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepJacob.EntityRamJacob>> RAM_JACOB = registerRam("ram_jacob", SheepJacob.EntityRamJacob::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepJacob.EntityLambJacob>> LAMB_JACOB = registerLamb("lamb_jacob", SheepJacob.EntityLambJacob::new);

	public static final DeferredHolder<EntityType<?>, EntityType<SheepMerino.EntityEweMerino>> EWE_MERINO = registerEwe("ewe_merino", SheepMerino.EntityEweMerino::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepMerino.EntityRamMerino>> RAM_MERINO = registerRam("ram_merino", SheepMerino.EntityRamMerino::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepMerino.EntityLambMerino>> LAMB_MERINO = registerLamb("lamb_merino", SheepMerino.EntityLambMerino::new);

	public static final DeferredHolder<EntityType<?>, EntityType<SheepSuffolk.EntityEweSuffolk>> EWE_SUFFOLK = registerEwe("ewe_suffolk", SheepSuffolk.EntityEweSuffolk::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepSuffolk.EntityRamSuffolk>> RAM_SUFFOLK = registerRam("ram_suffolk", SheepSuffolk.EntityRamSuffolk::new);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepSuffolk.EntityLambSuffolk>> LAMB_SUFFOLK = registerLamb("lamb_suffolk", SheepSuffolk.EntityLambSuffolk::new);

	 

	public static final DeferredHolder<EntityType<?>, EntityType<GoatAlpine.EntityDoeAlpine>> DOE_ALPINE = registerDoe("doe_alpine", GoatAlpine.EntityDoeAlpine::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatAlpine.EntityBuckAlpine>> BUCK_ALPINE = registerBuck("buck_alpine", GoatAlpine.EntityBuckAlpine::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatAlpine.EntityKidAlpine>> KID_ALPINE = registerKid("kid_alpine", GoatAlpine.EntityKidAlpine::new);

	public static final DeferredHolder<EntityType<?>, EntityType<GoatAngora.EntityDoeAngora>> DOE_ANGORA = registerDoe("doe_angora", GoatAngora.EntityDoeAngora::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatAngora.EntityBuckAngora>> BUCK_ANGORA = registerBuck("buck_angora", GoatAngora.EntityBuckAngora::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatAngora.EntityKidAngora>> KID_ANGORA = registerKid("kid_angora", GoatAngora.EntityKidAngora::new);

	public static final DeferredHolder<EntityType<?>, EntityType<GoatFainting.EntityDoeFainting>> DOE_FAINTING = registerDoe("doe_fainting", GoatFainting.EntityDoeFainting::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatFainting.EntityBuckFainting>> BUCK_FAINTING = registerBuck("buck_fainting", GoatFainting.EntityBuckFainting::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatFainting.EntityKidFainting>> KID_FAINTING = registerKid("kid_fainting", GoatFainting.EntityKidFainting::new);

	public static final DeferredHolder<EntityType<?>, EntityType<GoatKiko.EntityDoeKiko>> DOE_KIKO = registerDoe("doe_kiko", GoatKiko.EntityDoeKiko::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatKiko.EntityBuckKiko>> BUCK_KIKO = registerBuck("buck_kiko", GoatKiko.EntityBuckKiko::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatKiko.EntityKidKiko>> KID_KIKO = registerKid("kid_kiko", GoatKiko.EntityKidKiko::new);

	public static final DeferredHolder<EntityType<?>, EntityType<GoatKinder.EntityDoeKinder>> DOE_KINDER = registerDoe("doe_kinder", GoatKinder.EntityDoeKinder::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatKinder.EntityBuckKinder>> BUCK_KINDER = registerBuck("buck_kinder", GoatKinder.EntityBuckKinder::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatKinder.EntityKidKinder>> KID_KINDER = registerKid("kid_kinder", GoatKinder.EntityKidKinder::new);

	public static final DeferredHolder<EntityType<?>, EntityType<GoatNigerianDwarf.EntityDoeNigerianDwarf>> DOE_NIGERIAN_DWARF = registerDoe("doe_nigerian_dwarf", GoatNigerianDwarf.EntityDoeNigerianDwarf::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatNigerianDwarf.EntityBuckNigerianDwarf>> BUCK_NIGERIAN_DWARF = registerBuck("buck_nigerian_dwarf", GoatNigerianDwarf.EntityBuckNigerianDwarf::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatNigerianDwarf.EntityKidNigerianDwarf>> KID_NIGERIAN_DWARF = registerKid("kid_nigerian_dwarf", GoatNigerianDwarf.EntityKidNigerianDwarf::new);

	public static final DeferredHolder<EntityType<?>, EntityType<GoatPygmy.EntityDoePygmy>> DOE_PYGMY = registerDoe("doe_pygmy", GoatPygmy.EntityDoePygmy::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatPygmy.EntityBuckPygmy>> BUCK_PYGMY = registerBuck("buck_pygmy", GoatPygmy.EntityBuckPygmy::new);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatPygmy.EntityKidPygmy>> KID_PYGMY = registerKid("kid_pygmy", GoatPygmy.EntityKidPygmy::new);

	 

	public static final DeferredHolder<EntityType<?>, EntityType<HorseDraft.EntityMareDraftHorse>> MARE_DRAFT = registerMare("mare_draft", HorseDraft.EntityMareDraftHorse::new);
	public static final DeferredHolder<EntityType<?>, EntityType<HorseDraft.EntityStallionDraftHorse>> STALLION_DRAFT = registerStallion("stallion_draft", HorseDraft.EntityStallionDraftHorse::new);
	public static final DeferredHolder<EntityType<?>, EntityType<HorseDraft.EntityFoalDraftHorse>> FOAL_DRAFT = registerFoal("foal_draft", HorseDraft.EntityFoalDraftHorse::new);

	 

	public static final DeferredHolder<EntityType<?>, EntityType<com.animania.addons.farm.common.entity.pullables.EntityCart>> CART =
			ENTITY_TYPES.register("cart", () -> EntityType.Builder.<com.animania.addons.farm.common.entity.pullables.EntityCart>of(
					com.animania.addons.farm.common.entity.pullables.EntityCart::new, MobCategory.MISC)
					.sized(2.0F, 1.2F).build("cart"));

	public static final DeferredHolder<EntityType<?>, EntityType<com.animania.addons.farm.common.entity.pullables.EntityTiller>> TILLER =
			ENTITY_TYPES.register("tiller", () -> EntityType.Builder.<com.animania.addons.farm.common.entity.pullables.EntityTiller>of(
					com.animania.addons.farm.common.entity.pullables.EntityTiller::new, MobCategory.MISC)
					.sized(2.0F, 1.2F).build("tiller"));

	public static final DeferredHolder<EntityType<?>, EntityType<com.animania.addons.farm.common.entity.pullables.EntityWagon>> WAGON =
			ENTITY_TYPES.register("wagon", () -> EntityType.Builder.<com.animania.addons.farm.common.entity.pullables.EntityWagon>of(
					com.animania.addons.farm.common.entity.pullables.EntityWagon::new, MobCategory.MISC)
					.sized(2.5F, 1.2F).build("wagon"));

	 

	private static <T extends EntityHenBase> DeferredHolder<EntityType<?>, EntityType<T>> registerHen(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.5F, 0.7F).build(name));
	}

	private static <T extends EntityRoosterBase> DeferredHolder<EntityType<?>, EntityType<T>> registerRooster(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.6F, 0.8F).build(name));
	}

	private static <T extends EntityChickBase> DeferredHolder<EntityType<?>, EntityType<T>> registerChick(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.35F, 0.4F).build(name));
	}

	 
	 
	 

	private static <T extends EntityCowBase> DeferredHolder<EntityType<?>, EntityType<T>> registerCow(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.4F, 1.8F).build(name));
	}

	private static <T extends EntityBullBase> DeferredHolder<EntityType<?>, EntityType<T>> registerBull(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.6F, 1.8F).build(name));
	}

	private static <T extends EntityCalfBase> DeferredHolder<EntityType<?>, EntityType<T>> registerCalf(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.9F, 1.3F).build(name));
	}

	 
	 
	 

	private static <T extends EntitySowBase> DeferredHolder<EntityType<?>, EntityType<T>> registerSow(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.1F, 1.0F).build(name));
	}

	private static <T extends EntityHogBase> DeferredHolder<EntityType<?>, EntityType<T>> registerHog(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.0F, 1.0F).build(name));
	}

	private static <T extends EntityPigletBase> DeferredHolder<EntityType<?>, EntityType<T>> registerPiglet(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.6F, 0.6F).build(name));
	}

	 
	 

	private static <T extends EntityEweBase> DeferredHolder<EntityType<?>, EntityType<T>> registerEwe(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.0F, 1.0F).build(name));
	}

	private static <T extends EntityRamBase> DeferredHolder<EntityType<?>, EntityType<T>> registerRam(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.2F, 1.0F).build(name));
	}

	private static <T extends EntityLambBase> DeferredHolder<EntityType<?>, EntityType<T>> registerLamb(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.6F, 0.6F).build(name));
	}

	 
	 
	 

	private static <T extends EntityDoeBase> DeferredHolder<EntityType<?>, EntityType<T>> registerDoe(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.0F, 1.0F).build(name));
	}

	private static <T extends EntityBuckBase> DeferredHolder<EntityType<?>, EntityType<T>> registerBuck(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.4F, 1.3F).build(name));
	}

	private static <T extends EntityKidBase> DeferredHolder<EntityType<?>, EntityType<T>> registerKid(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.6F, 0.6F).build(name));
	}

	 
	 
	 
	 
	 

	private static <T extends EntityMareBase> DeferredHolder<EntityType<?>, EntityType<T>> registerMare(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.8F, 2.2F).build(name));
	}

	private static <T extends EntityStallionBase> DeferredHolder<EntityType<?>, EntityType<T>> registerStallion(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(1.8F, 2.2F).build(name));
	}

	private static <T extends EntityFoalBase> DeferredHolder<EntityType<?>, EntityType<T>> registerFoal(String name, EntityType.EntityFactory<T> factory)
	{
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE)
				.sized(0.9F, 1.4F).build(name));
	}

	 



	public static void registerAttributes(EntityAttributeCreationEvent event)
	{
		 
		event.put(HEN_LEGHORN.get(), EntityHenBase.createHenAttributes().build());
		event.put(HEN_ORPINGTON.get(), EntityHenBase.createHenAttributes().build());
		event.put(HEN_PLYMOUTH_ROCK.get(), EntityHenBase.createHenAttributes().build());
		event.put(HEN_RHODE_ISLAND_RED.get(), EntityHenBase.createHenAttributes().build());
		event.put(HEN_WYANDOTTE.get(), EntityHenBase.createHenAttributes().build());

		 
		event.put(ROOSTER_LEGHORN.get(), EntityRoosterBase.createRoosterAttributes().build());
		event.put(ROOSTER_ORPINGTON.get(), EntityRoosterBase.createRoosterAttributes().build());
		event.put(ROOSTER_PLYMOUTH_ROCK.get(), EntityRoosterBase.createRoosterAttributes().build());
		event.put(ROOSTER_RHODE_ISLAND_RED.get(), EntityRoosterBase.createRoosterAttributes().build());
		event.put(ROOSTER_WYANDOTTE.get(), EntityRoosterBase.createRoosterAttributes().build());

		 
		event.put(CHICK_LEGHORN.get(), EntityAnimaniaChicken.createAnimaniaChickenAttributes().build());
		event.put(CHICK_ORPINGTON.get(), EntityAnimaniaChicken.createAnimaniaChickenAttributes().build());
		event.put(CHICK_PLYMOUTH_ROCK.get(), EntityAnimaniaChicken.createAnimaniaChickenAttributes().build());
		event.put(CHICK_RHODE_ISLAND_RED.get(), EntityAnimaniaChicken.createAnimaniaChickenAttributes().build());
		event.put(CHICK_WYANDOTTE.get(), EntityAnimaniaChicken.createAnimaniaChickenAttributes().build());

		 
		for (var cow : new DeferredHolder[] { COW_ANGUS, COW_FRIESIAN, COW_HEREFORD, COW_HIGHLAND, COW_HOLSTEIN, COW_JERSEY, COW_LONGHORN, COW_MOOSHROOM })
			event.put((EntityType) cow.get(), EntityCowBase.createCowAttributes().build());
		for (var bull : new DeferredHolder[] { BULL_ANGUS, BULL_FRIESIAN, BULL_HEREFORD, BULL_HIGHLAND, BULL_HOLSTEIN, BULL_JERSEY, BULL_LONGHORN, BULL_MOOSHROOM })
			event.put((EntityType) bull.get(), EntityBullBase.createBullAttributes().build());
		for (var calf : new DeferredHolder[] { CALF_ANGUS, CALF_FRIESIAN, CALF_HEREFORD, CALF_HIGHLAND, CALF_HOLSTEIN, CALF_JERSEY, CALF_LONGHORN, CALF_MOOSHROOM })
			event.put((EntityType) calf.get(), EntityCalfBase.createCalfAttributes().build());

		 
		for (var sow : new DeferredHolder[] { SOW_DUROC, SOW_HAMPSHIRE, SOW_LARGE_BLACK, SOW_LARGE_WHITE, SOW_OLD_SPOT, SOW_YORKSHIRE })
			event.put((EntityType) sow.get(), EntitySowBase.createSowAttributes().build());
		for (var hog : new DeferredHolder[] { HOG_DUROC, HOG_HAMPSHIRE, HOG_LARGE_BLACK, HOG_LARGE_WHITE, HOG_OLD_SPOT, HOG_YORKSHIRE })
			event.put((EntityType) hog.get(), EntityHogBase.createHogAttributes().build());
		for (var piglet : new DeferredHolder[] { PIGLET_DUROC, PIGLET_HAMPSHIRE, PIGLET_LARGE_BLACK, PIGLET_LARGE_WHITE, PIGLET_OLD_SPOT, PIGLET_YORKSHIRE })
			event.put((EntityType) piglet.get(), EntityPigletBase.createPigletAttributes().build());

		 
		for (var ewe : new DeferredHolder[] { EWE_DORPER, EWE_DORSET, EWE_FRIESIAN, EWE_JACOB, EWE_MERINO, EWE_SUFFOLK })
			event.put((EntityType) ewe.get(), EntityEweBase.createEweAttributes().build());
		for (var ram : new DeferredHolder[] { RAM_DORPER, RAM_DORSET, RAM_FRIESIAN, RAM_JACOB, RAM_MERINO, RAM_SUFFOLK })
			event.put((EntityType) ram.get(), EntityRamBase.createRamAttributes().build());
		for (var lamb : new DeferredHolder[] { LAMB_DORPER, LAMB_DORSET, LAMB_FRIESIAN, LAMB_JACOB, LAMB_MERINO, LAMB_SUFFOLK })
			event.put((EntityType) lamb.get(), EntityLambBase.createLambAttributes().build());

		 
		for (var doe : new DeferredHolder[] { DOE_ALPINE, DOE_ANGORA, DOE_FAINTING, DOE_KIKO, DOE_KINDER, DOE_NIGERIAN_DWARF, DOE_PYGMY })
			event.put((EntityType) doe.get(), EntityDoeBase.createDoeAttributes().build());
		for (var buck : new DeferredHolder[] { BUCK_ALPINE, BUCK_ANGORA, BUCK_FAINTING, BUCK_KIKO, BUCK_KINDER, BUCK_NIGERIAN_DWARF, BUCK_PYGMY })
			event.put((EntityType) buck.get(), EntityBuckBase.createBuckAttributes().build());
		for (var kid : new DeferredHolder[] { KID_ALPINE, KID_ANGORA, KID_FAINTING, KID_KIKO, KID_KINDER, KID_NIGERIAN_DWARF, KID_PYGMY })
			event.put((EntityType) kid.get(), EntityKidBase.createKidAttributes().build());

		 
		event.put(MARE_DRAFT.get(), EntityMareBase.createMareAttributes().build());
		event.put(STALLION_DRAFT.get(), EntityStallionBase.createStallionAttributes().build());
		event.put(FOAL_DRAFT.get(), EntityFoalBase.createFoalAttributes().build());
	}

	 



	public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event)
	{
		registerGroundSpawn(event, HEN_LEGHORN.get());
		registerGroundSpawn(event, ROOSTER_LEGHORN.get());
		registerGroundSpawn(event, HEN_ORPINGTON.get());
		registerGroundSpawn(event, ROOSTER_ORPINGTON.get());
		registerGroundSpawn(event, HEN_PLYMOUTH_ROCK.get());
		registerGroundSpawn(event, ROOSTER_PLYMOUTH_ROCK.get());
		registerGroundSpawn(event, HEN_RHODE_ISLAND_RED.get());
		registerGroundSpawn(event, ROOSTER_RHODE_ISLAND_RED.get());
		registerGroundSpawn(event, HEN_WYANDOTTE.get());
		registerGroundSpawn(event, ROOSTER_WYANDOTTE.get());

		 
		 
		 
		 
		registerGroundSpawn(event, COW_ANGUS.get());
		registerGroundSpawn(event, COW_FRIESIAN.get());
		registerGroundSpawn(event, COW_HEREFORD.get());
		registerGroundSpawn(event, COW_HIGHLAND.get());
		registerGroundSpawn(event, COW_HOLSTEIN.get());
		registerGroundSpawn(event, COW_JERSEY.get());
		registerGroundSpawn(event, COW_LONGHORN.get());
		registerGroundSpawn(event, BULL_ANGUS.get());
		registerGroundSpawn(event, BULL_FRIESIAN.get());
		registerGroundSpawn(event, BULL_HEREFORD.get());
		registerGroundSpawn(event, BULL_HIGHLAND.get());
		registerGroundSpawn(event, BULL_HOLSTEIN.get());
		registerGroundSpawn(event, BULL_JERSEY.get());
		registerGroundSpawn(event, BULL_LONGHORN.get());

		 
		registerGroundSpawn(event, SOW_DUROC.get());
		registerGroundSpawn(event, HOG_DUROC.get());
		registerGroundSpawn(event, SOW_HAMPSHIRE.get());
		registerGroundSpawn(event, HOG_HAMPSHIRE.get());
		registerGroundSpawn(event, SOW_LARGE_BLACK.get());
		registerGroundSpawn(event, HOG_LARGE_BLACK.get());
		registerGroundSpawn(event, SOW_LARGE_WHITE.get());
		registerGroundSpawn(event, HOG_LARGE_WHITE.get());
		registerGroundSpawn(event, SOW_OLD_SPOT.get());
		registerGroundSpawn(event, HOG_OLD_SPOT.get());
		registerGroundSpawn(event, SOW_YORKSHIRE.get());
		registerGroundSpawn(event, HOG_YORKSHIRE.get());

		 
		registerGroundSpawn(event, EWE_DORPER.get());
		registerGroundSpawn(event, RAM_DORPER.get());
		registerGroundSpawn(event, EWE_DORSET.get());
		registerGroundSpawn(event, RAM_DORSET.get());
		registerGroundSpawn(event, EWE_FRIESIAN.get());
		registerGroundSpawn(event, RAM_FRIESIAN.get());
		registerGroundSpawn(event, EWE_JACOB.get());
		registerGroundSpawn(event, RAM_JACOB.get());
		registerGroundSpawn(event, EWE_MERINO.get());
		registerGroundSpawn(event, RAM_MERINO.get());
		registerGroundSpawn(event, EWE_SUFFOLK.get());
		registerGroundSpawn(event, RAM_SUFFOLK.get());

		 
		registerGroundSpawn(event, DOE_ALPINE.get());
		registerGroundSpawn(event, BUCK_ALPINE.get());
		registerGroundSpawn(event, DOE_ANGORA.get());
		registerGroundSpawn(event, BUCK_ANGORA.get());
		registerGroundSpawn(event, DOE_FAINTING.get());
		registerGroundSpawn(event, BUCK_FAINTING.get());
		registerGroundSpawn(event, DOE_KIKO.get());
		registerGroundSpawn(event, BUCK_KIKO.get());
		registerGroundSpawn(event, DOE_KINDER.get());
		registerGroundSpawn(event, BUCK_KINDER.get());
		registerGroundSpawn(event, DOE_NIGERIAN_DWARF.get());
		registerGroundSpawn(event, BUCK_NIGERIAN_DWARF.get());
		registerGroundSpawn(event, DOE_PYGMY.get());
		registerGroundSpawn(event, BUCK_PYGMY.get());

		 
		registerGroundSpawn(event, MARE_DRAFT.get());
		registerGroundSpawn(event, STALLION_DRAFT.get());
	}

	private static <T extends Animal> void registerGroundSpawn(RegisterSpawnPlacementsEvent event, EntityType<T> type)
	{
		event.register(type, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}
}
