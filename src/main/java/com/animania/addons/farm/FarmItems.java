package com.animania.addons.farm;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.common.item.ItemCarvingKnife;
import com.animania.addons.farm.common.item.ItemHoneyJar;
import com.animania.addons.farm.common.item.ItemMilkBottle;
import com.animania.addons.farm.common.item.ItemRidingCrop;
import com.animania.addons.farm.common.item.handler.HoneyJarFluidHandler;
import com.animania.addons.farm.common.entity.chickens.ChickenType;
import com.animania.addons.farm.common.entity.cows.CowType;
import com.animania.addons.farm.common.entity.goats.GoatType;
import com.animania.addons.farm.common.entity.pigs.PigType;
import com.animania.addons.farm.common.entity.sheep.SheepType;
import com.animania.common.item.ItemBonusFood;
import com.animania.common.item.ItemRandomAnimalEgg;
import com.animania.common.fluids.CommonFluids;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

 






public class FarmItems
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Animania.MODID);

	 

	public static final FoodProperties RAW_PRIME_CHICKEN_FOOD = new FoodProperties.Builder()
			.nutrition(3).saturationModifier(0.4F).build();

	public static final FoodProperties COOKED_PRIME_CHICKEN_FOOD = new FoodProperties.Builder()
			.nutrition(8).saturationModifier(0.8F).build();

	public static final DeferredItem<Item> RAW_PRIME_CHICKEN = ITEMS.registerSimpleItem("raw_prime_chicken",
			new Item.Properties().food(RAW_PRIME_CHICKEN_FOOD));

	public static final DeferredItem<Item> COOKED_PRIME_CHICKEN = ITEMS.registerSimpleItem("cooked_prime_chicken",
			new Item.Properties().food(COOKED_PRIME_CHICKEN_FOOD));

	public static final FoodProperties RAW_PRIME_BEEF_FOOD = new FoodProperties.Builder()
			.nutrition(4).saturationModifier(0.3F).build();

	public static final FoodProperties COOKED_PRIME_BEEF_FOOD = new FoodProperties.Builder()
			.nutrition(9).saturationModifier(0.9F).build();

	public static final DeferredItem<Item> RAW_PRIME_BEEF = ITEMS.registerSimpleItem("raw_prime_beef",
			new Item.Properties().food(RAW_PRIME_BEEF_FOOD));

	public static final DeferredItem<Item> COOKED_PRIME_BEEF = ITEMS.registerSimpleItem("cooked_prime_beef",
			new Item.Properties().food(COOKED_PRIME_BEEF_FOOD));

	 
	public static final FoodProperties RAW_CUT_FOOD = new FoodProperties.Builder()
			.nutrition(1).saturationModifier(1.0F).build();
	public static final FoodProperties CHEESE_WEDGE_FOOD = new FoodProperties.Builder()
			.nutrition(3).saturationModifier(0.9F).build();

	public static final DeferredItem<ItemCarvingKnife> CARVING_KNIFE = ITEMS.register("carving_knife",
			() -> new ItemCarvingKnife(new Item.Properties()));
	public static final DeferredItem<ItemRidingCrop> RIDING_CROP = ITEMS.register("riding_crop",
			() -> new ItemRidingCrop(new Item.Properties().stacksTo(1).durability(100)));
	public static final DeferredItem<ItemBonusFood> RAW_PRIME_STEAK = ITEMS.register("raw_prime_steak",
			() -> new ItemBonusFood(new Item.Properties().food(RAW_CUT_FOOD), new MobEffectInstance(MobEffects.CONFUSION, 200, 3, false, false)));
	public static final DeferredItem<ItemBonusFood> COOKED_PRIME_STEAK = ITEMS.register("cooked_prime_steak",
			() -> new ItemBonusFood(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.5F).build()), new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false)));
	public static final DeferredItem<ItemBonusFood> RAW_PRIME_BACON = ITEMS.register("raw_prime_bacon",
			() -> new ItemBonusFood(new Item.Properties().food(RAW_CUT_FOOD), new MobEffectInstance(MobEffects.CONFUSION, 200, 3, false, false)));
	public static final DeferredItem<ItemBonusFood> COOKED_PRIME_BACON = ITEMS.register("cooked_prime_bacon",
			() -> new ItemBonusFood(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.5F).build()), new MobEffectInstance(MobEffects.ABSORPTION, 1800, 0, false, false)));
	public static final DeferredItem<ItemBonusFood> HOLSTEIN_CHEESE_WEDGE = ITEMS.register("holstein_cheese_wedge",
			() -> new ItemBonusFood(new Item.Properties().food(CHEESE_WEDGE_FOOD), new MobEffectInstance(MobEffects.HEAL, 1, 1, false, false)));
	public static final DeferredItem<ItemBonusFood> FRIESIAN_CHEESE_WEDGE = ITEMS.register("friesian_cheese_wedge",
			() -> new ItemBonusFood(new Item.Properties().food(CHEESE_WEDGE_FOOD), new MobEffectInstance(MobEffects.HEAL, 1, 1, false, false)));
	public static final DeferredItem<ItemBonusFood> JERSEY_CHEESE_WEDGE = ITEMS.register("jersey_cheese_wedge",
			() -> new ItemBonusFood(new Item.Properties().food(CHEESE_WEDGE_FOOD), new MobEffectInstance(MobEffects.HEAL, 1, 1, false, false)));
	public static final DeferredItem<ItemBonusFood> SHEEP_CHEESE_WEDGE = ITEMS.register("sheep_cheese_wedge",
			() -> new ItemBonusFood(new Item.Properties().food(CHEESE_WEDGE_FOOD), new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false)));
	public static final DeferredItem<ItemBonusFood> GOAT_CHEESE_WEDGE = ITEMS.register("goat_cheese_wedge",
			() -> new ItemBonusFood(new Item.Properties().food(CHEESE_WEDGE_FOOD), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0, false, false)));

	public static final FoodProperties MILK_BOTTLE_FOOD = new FoodProperties.Builder()
			.nutrition(4).saturationModifier(1.0F).alwaysEdible().build();
	public static final DeferredItem<ItemMilkBottle> MILK_BOTTLE = ITEMS.register("milk_bottle",
			() -> new ItemMilkBottle(new Item.Properties().food(MILK_BOTTLE_FOOD).stacksTo(4).craftRemainder(Items.GLASS_BOTTLE)));

	public static final DeferredItem<Item> PLAIN_OMELETTE = ITEMS.registerSimpleItem("plain_omelette",
			new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build()));
	public static final DeferredItem<ItemBonusFood> CHEESE_OMELETTE = ITEMS.register("cheese_omelette",
			() -> new ItemBonusFood(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.7F).build()), new MobEffectInstance(MobEffects.HEAL, 1, 1, false, false)));
	public static final DeferredItem<ItemBonusFood> BACON_OMELETTE = ITEMS.register("bacon_omelette",
			() -> new ItemBonusFood(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.7F).build()), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0, false, false)));
	public static final DeferredItem<ItemBonusFood> TRUFFLE_OMELETTE = ITEMS.register("truffle_omelette",
			() -> new ItemBonusFood(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.8F).build()), new MobEffectInstance(MobEffects.REGENERATION, 600, 1, false, false)));
	public static final DeferredItem<ItemBonusFood> SUPER_OMELETTE = ITEMS.register("super_omelette",
			() -> new ItemBonusFood(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.9F).build()),
					new MobEffectInstance(MobEffects.REGENERATION, 600, 1, false, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0, false, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1, false, false)));
	public static final DeferredItem<ItemBonusFood> TRUFFLE_SOUP = ITEMS.register("truffle_soup",
			() -> new ItemBonusFood(new Item.Properties().stacksTo(1).craftRemainder(Items.BOWL)
					.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.6F).alwaysEdible().usingConvertsTo(Items.BOWL).build()),
					new MobEffectInstance(MobEffects.REGENERATION, 1200, 1, false, false)));
	public static final DeferredItem<ItemBonusFood> CHOCOLATE_TRUFFLE = ITEMS.register("chocolate_truffle",
			() -> new ItemBonusFood(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.7F).build()),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 3, false, false)));

	 
	 
	 

	public static final DeferredItem<DeferredSpawnEggItem> HEN_LEGHORN_SPAWN_EGG = spawnEgg("hen_leghorn", () -> FarmEntityTypes.HEN_LEGHORN.get(), 15724527, 14869218);
	public static final DeferredItem<DeferredSpawnEggItem> ROOSTER_LEGHORN_SPAWN_EGG = spawnEgg("rooster_leghorn", () -> FarmEntityTypes.ROOSTER_LEGHORN.get(), 15724527, 14869218);
	public static final DeferredItem<DeferredSpawnEggItem> CHICK_LEGHORN_SPAWN_EGG = spawnEgg("chick_leghorn", () -> FarmEntityTypes.CHICK_LEGHORN.get(), 15724527, 14869218);

	public static final DeferredItem<DeferredSpawnEggItem> HEN_ORPINGTON_SPAWN_EGG = spawnEgg("hen_orpington", () -> FarmEntityTypes.HEN_ORPINGTON.get(), 15980429, 13270563);
	public static final DeferredItem<DeferredSpawnEggItem> ROOSTER_ORPINGTON_SPAWN_EGG = spawnEgg("rooster_orpington", () -> FarmEntityTypes.ROOSTER_ORPINGTON.get(), 15980429, 13270563);
	public static final DeferredItem<DeferredSpawnEggItem> CHICK_ORPINGTON_SPAWN_EGG = spawnEgg("chick_orpington", () -> FarmEntityTypes.CHICK_ORPINGTON.get(), 15980429, 13270563);

	public static final DeferredItem<DeferredSpawnEggItem> HEN_PLYMOUTH_ROCK_SPAWN_EGG = spawnEgg("hen_plymouth_rock", () -> FarmEntityTypes.HEN_PLYMOUTH_ROCK.get(), 13683925, 9735826);
	public static final DeferredItem<DeferredSpawnEggItem> ROOSTER_PLYMOUTH_ROCK_SPAWN_EGG = spawnEgg("rooster_plymouth_rock", () -> FarmEntityTypes.ROOSTER_PLYMOUTH_ROCK.get(), 13683925, 9735826);
	public static final DeferredItem<DeferredSpawnEggItem> CHICK_PLYMOUTH_ROCK_SPAWN_EGG = spawnEgg("chick_plymouth_rock", () -> FarmEntityTypes.CHICK_PLYMOUTH_ROCK.get(), 13683925, 9735826);

	public static final DeferredItem<DeferredSpawnEggItem> HEN_RHODE_ISLAND_RED_SPAWN_EGG = spawnEgg("hen_rhode_island_red", () -> FarmEntityTypes.HEN_RHODE_ISLAND_RED.get(), 13668724, 12480342);
	public static final DeferredItem<DeferredSpawnEggItem> ROOSTER_RHODE_ISLAND_RED_SPAWN_EGG = spawnEgg("rooster_rhode_island_red", () -> FarmEntityTypes.ROOSTER_RHODE_ISLAND_RED.get(), 13668724, 12480342);
	public static final DeferredItem<DeferredSpawnEggItem> CHICK_RHODE_ISLAND_RED_SPAWN_EGG = spawnEgg("chick_rhode_island_red", () -> FarmEntityTypes.CHICK_RHODE_ISLAND_RED.get(), 13668724, 12480342);

	public static final DeferredItem<DeferredSpawnEggItem> HEN_WYANDOTTE_SPAWN_EGG = spawnEgg("hen_wyandotte", () -> FarmEntityTypes.HEN_WYANDOTTE.get(), 8219743, 5129532);
	public static final DeferredItem<DeferredSpawnEggItem> ROOSTER_WYANDOTTE_SPAWN_EGG = spawnEgg("rooster_wyandotte", () -> FarmEntityTypes.ROOSTER_WYANDOTTE.get(), 8219743, 5129532);
	public static final DeferredItem<DeferredSpawnEggItem> CHICK_WYANDOTTE_SPAWN_EGG = spawnEgg("chick_wyandotte", () -> FarmEntityTypes.CHICK_WYANDOTTE.get(), 8219743, 5129532);

	 
	 
	 

	public static final DeferredItem<DeferredSpawnEggItem> COW_ANGUS_SPAWN_EGG = spawnEgg("cow_angus", () -> FarmEntityTypes.COW_ANGUS.get(), 3028024, 2304560);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_ANGUS_SPAWN_EGG = spawnEgg("bull_angus", () -> FarmEntityTypes.BULL_ANGUS.get(), 3028024, 2304560);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_ANGUS_SPAWN_EGG = spawnEgg("calf_angus", () -> FarmEntityTypes.CALF_ANGUS.get(), 3028024, 2304560);

	public static final DeferredItem<DeferredSpawnEggItem> COW_FRIESIAN_SPAWN_EGG = spawnEgg("cow_friesian", () -> FarmEntityTypes.COW_FRIESIAN.get(), 15987699, 3944229);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_FRIESIAN_SPAWN_EGG = spawnEgg("bull_friesian", () -> FarmEntityTypes.BULL_FRIESIAN.get(), 15987699, 3944229);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_FRIESIAN_SPAWN_EGG = spawnEgg("calf_friesian", () -> FarmEntityTypes.CALF_FRIESIAN.get(), 15987699, 3944229);

	public static final DeferredItem<DeferredSpawnEggItem> COW_HEREFORD_SPAWN_EGG = spawnEgg("cow_hereford", () -> FarmEntityTypes.COW_HEREFORD.get(), 4461056, 15987699);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_HEREFORD_SPAWN_EGG = spawnEgg("bull_hereford", () -> FarmEntityTypes.BULL_HEREFORD.get(), 4461056, 15987699);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_HEREFORD_SPAWN_EGG = spawnEgg("calf_hereford", () -> FarmEntityTypes.CALF_HEREFORD.get(), 4461056, 15987699);

	public static final DeferredItem<DeferredSpawnEggItem> COW_HIGHLAND_SPAWN_EGG = spawnEgg("cow_highland", () -> FarmEntityTypes.COW_HIGHLAND.get(), 8340777, 2760475);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_HIGHLAND_SPAWN_EGG = spawnEgg("bull_highland", () -> FarmEntityTypes.BULL_HIGHLAND.get(), 8340777, 2760475);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_HIGHLAND_SPAWN_EGG = spawnEgg("calf_highland", () -> FarmEntityTypes.CALF_HIGHLAND.get(), 8340777, 2760475);

	public static final DeferredItem<DeferredSpawnEggItem> COW_HOLSTEIN_SPAWN_EGG = spawnEgg("cow_holstein", () -> FarmEntityTypes.COW_HOLSTEIN.get(), 15987699, 2236962);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_HOLSTEIN_SPAWN_EGG = spawnEgg("bull_holstein", () -> FarmEntityTypes.BULL_HOLSTEIN.get(), 15987699, 2236962);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_HOLSTEIN_SPAWN_EGG = spawnEgg("calf_holstein", () -> FarmEntityTypes.CALF_HOLSTEIN.get(), 15987699, 2236962);

	public static final DeferredItem<DeferredSpawnEggItem> COW_JERSEY_SPAWN_EGG = spawnEgg("cow_jersey", () -> FarmEntityTypes.COW_JERSEY.get(), 12089918, 16775643);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_JERSEY_SPAWN_EGG = spawnEgg("bull_jersey", () -> FarmEntityTypes.BULL_JERSEY.get(), 12089918, 16775643);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_JERSEY_SPAWN_EGG = spawnEgg("calf_jersey", () -> FarmEntityTypes.CALF_JERSEY.get(), 12089918, 16775643);

	public static final DeferredItem<DeferredSpawnEggItem> COW_LONGHORN_SPAWN_EGG = spawnEgg("cow_longhorn", () -> FarmEntityTypes.COW_LONGHORN.get(), 16763795, 11227168);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_LONGHORN_SPAWN_EGG = spawnEgg("bull_longhorn", () -> FarmEntityTypes.BULL_LONGHORN.get(), 16763795, 11227168);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_LONGHORN_SPAWN_EGG = spawnEgg("calf_longhorn", () -> FarmEntityTypes.CALF_LONGHORN.get(), 16763795, 11227168);

	public static final DeferredItem<DeferredSpawnEggItem> COW_MOOSHROOM_SPAWN_EGG = spawnEgg("cow_mooshroom", () -> FarmEntityTypes.COW_MOOSHROOM.get(), 12325394, 12627887);
	public static final DeferredItem<DeferredSpawnEggItem> BULL_MOOSHROOM_SPAWN_EGG = spawnEgg("bull_mooshroom", () -> FarmEntityTypes.BULL_MOOSHROOM.get(), 12325394, 12627887);
	public static final DeferredItem<DeferredSpawnEggItem> CALF_MOOSHROOM_SPAWN_EGG = spawnEgg("calf_mooshroom", () -> FarmEntityTypes.CALF_MOOSHROOM.get(), 12325394, 12627887);

	 

	public static final FoodProperties RAW_PRIME_PORK_FOOD = new FoodProperties.Builder()
			.nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties COOKED_PRIME_PORK_FOOD = new FoodProperties.Builder()
			.nutrition(8).saturationModifier(0.8F).build();
	public static final FoodProperties TRUFFLE_FOOD = new FoodProperties.Builder()
			.nutrition(2).saturationModifier(0.7F).build();

	public static final DeferredItem<Item> RAW_PRIME_PORK = ITEMS.registerSimpleItem("raw_prime_pork",
			new Item.Properties().food(RAW_PRIME_PORK_FOOD));
	public static final DeferredItem<Item> COOKED_PRIME_PORK = ITEMS.registerSimpleItem("cooked_prime_pork",
			new Item.Properties().food(COOKED_PRIME_PORK_FOOD));
	public static final DeferredItem<Item> TRUFFLE = ITEMS.registerSimpleItem("truffle",
			new Item.Properties().food(TRUFFLE_FOOD));

	 
	 
	 
	 

	public static final Supplier<Item> WOOL_DORSET_NATURAL = () -> FarmBlocks.WOOL_DORSET_NATURAL_ITEM.get();
	public static final Supplier<Item> WOOL_FRIESIAN_1 = () -> FarmBlocks.WOOL_FRIESIAN_1_ITEM.get();
	public static final Supplier<Item> WOOL_FRIESIAN_2 = () -> FarmBlocks.WOOL_FRIESIAN_2_ITEM.get();
	public static final Supplier<Item> WOOL_JACOB = () -> FarmBlocks.WOOL_JACOB_ITEM.get();
	public static final Supplier<Item> WOOL_MERINO_NATURAL = () -> FarmBlocks.WOOL_MERINO_NATURAL_ITEM.get();
	public static final Supplier<Item> WOOL_MERINO_BROWN = () -> FarmBlocks.WOOL_MERINO_BROWN_ITEM.get();
	public static final Supplier<Item> WOOL_SUFFOLK_NATURAL = () -> FarmBlocks.WOOL_SUFFOLK_NATURAL_ITEM.get();

	 


	public static final DeferredItem<net.minecraft.world.item.BucketItem> SHEEP_MILK_BUCKET = CommonFluids.MILK_SHEEP_BUCKET;

	 

	public static final FoodProperties RAW_PRIME_CHEVON_FOOD = new FoodProperties.Builder()
			.nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties COOKED_PRIME_CHEVON_FOOD = new FoodProperties.Builder()
			.nutrition(8).saturationModifier(0.8F).build();
	public static final FoodProperties RAW_CHEVON_FOOD = new FoodProperties.Builder()
			.nutrition(2).saturationModifier(0.3F).build();
	public static final FoodProperties COOKED_CHEVON_FOOD = new FoodProperties.Builder()
			.nutrition(6).saturationModifier(0.6F).build();

	public static final DeferredItem<Item> RAW_PRIME_CHEVON = ITEMS.registerSimpleItem("raw_prime_chevon",
			new Item.Properties().food(RAW_PRIME_CHEVON_FOOD));
	public static final DeferredItem<Item> COOKED_PRIME_CHEVON = ITEMS.registerSimpleItem("cooked_prime_chevon",
			new Item.Properties().food(COOKED_PRIME_CHEVON_FOOD));
	public static final DeferredItem<Item> RAW_CHEVON = ITEMS.registerSimpleItem("raw_chevon",
			new Item.Properties().food(RAW_CHEVON_FOOD));
	public static final DeferredItem<Item> COOKED_CHEVON = ITEMS.registerSimpleItem("cooked_chevon",
			new Item.Properties().food(COOKED_CHEVON_FOOD));

	public static final DeferredItem<net.minecraft.world.item.BucketItem> GOAT_MILK_BUCKET = CommonFluids.MILK_GOAT_BUCKET;

	public static final FoodProperties RAW_HORSE_FOOD = new FoodProperties.Builder()
			.nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties COOKED_HORSE_FOOD = new FoodProperties.Builder()
			.nutrition(8).saturationModifier(0.8F).build();
	public static final DeferredItem<Item> RAW_HORSE = ITEMS.registerSimpleItem("raw_horse",
			new Item.Properties().food(RAW_HORSE_FOOD));
	public static final DeferredItem<Item> COOKED_HORSE = ITEMS.registerSimpleItem("cooked_horse",
			new Item.Properties().food(COOKED_HORSE_FOOD));

	public static final DeferredItem<com.animania.addons.farm.common.item.ItemCart> ITEM_CART = ITEMS.register("item_cart",
			() -> new com.animania.addons.farm.common.item.ItemCart(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<com.animania.addons.farm.common.item.ItemTiller> ITEM_TILLER = ITEMS.register("item_tiller",
			() -> new com.animania.addons.farm.common.item.ItemTiller(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<com.animania.addons.farm.common.item.ItemWagon> ITEM_WAGON = ITEMS.register("item_wagon",
			() -> new com.animania.addons.farm.common.item.ItemWagon(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<Item> WHEEL = ITEMS.registerSimpleItem("wheel", new Item.Properties());

	 

	 
	public static final DeferredItem<Item> SALT = ITEMS.registerSimpleItem("salt", new Item.Properties());

	 






	 

	public static final FoodProperties HONEY_JAR_FOOD = new FoodProperties.Builder()
			.nutrition(10).saturationModifier(1.5F).build();

	 
	public static final DeferredItem<ItemHoneyJar> HONEY_JAR = ITEMS.register("honey_jar",
			() -> new ItemHoneyJar(new Item.Properties().food(HONEY_JAR_FOOD).stacksTo(4).craftRemainder(Items.GLASS_BOTTLE)));

	 
	public static final DeferredItem<net.minecraft.world.item.BucketItem> HONEY_BUCKET = CommonFluids.HONEY_BUCKET;

	 
	public static final DeferredItem<Item> BROWN_EGG = ITEMS.registerSimpleItem("brown_egg", new Item.Properties().stacksTo(16));

	public static final DeferredItem<DeferredSpawnEggItem> SOW_DUROC_SPAWN_EGG = spawnEgg("sow_duroc", () -> FarmEntityTypes.SOW_DUROC.get(), 9399147, 6896443);
	public static final DeferredItem<DeferredSpawnEggItem> HOG_DUROC_SPAWN_EGG = spawnEgg("hog_duroc", () -> FarmEntityTypes.HOG_DUROC.get(), 9399147, 6896443);
	public static final DeferredItem<DeferredSpawnEggItem> PIGLET_DUROC_SPAWN_EGG = spawnEgg("piglet_duroc", () -> FarmEntityTypes.PIGLET_DUROC.get(), 9399147, 6896443);

	public static final DeferredItem<DeferredSpawnEggItem> SOW_HAMPSHIRE_SPAWN_EGG = spawnEgg("sow_hampshire", () -> FarmEntityTypes.SOW_HAMPSHIRE.get(), 5327691, 13684944);
	public static final DeferredItem<DeferredSpawnEggItem> HOG_HAMPSHIRE_SPAWN_EGG = spawnEgg("hog_hampshire", () -> FarmEntityTypes.HOG_HAMPSHIRE.get(), 5327691, 13684944);
	public static final DeferredItem<DeferredSpawnEggItem> PIGLET_HAMPSHIRE_SPAWN_EGG = spawnEgg("piglet_hampshire", () -> FarmEntityTypes.PIGLET_HAMPSHIRE.get(), 5327691, 13684944);

	public static final DeferredItem<DeferredSpawnEggItem> SOW_LARGE_BLACK_SPAWN_EGG = spawnEgg("sow_large_black", () -> FarmEntityTypes.SOW_LARGE_BLACK.get(), 8417906, 5326149);
	public static final DeferredItem<DeferredSpawnEggItem> HOG_LARGE_BLACK_SPAWN_EGG = spawnEgg("hog_large_black", () -> FarmEntityTypes.HOG_LARGE_BLACK.get(), 8417906, 5326149);
	public static final DeferredItem<DeferredSpawnEggItem> PIGLET_LARGE_BLACK_SPAWN_EGG = spawnEgg("piglet_large_black", () -> FarmEntityTypes.PIGLET_LARGE_BLACK.get(), 8417906, 5326149);

	public static final DeferredItem<DeferredSpawnEggItem> SOW_LARGE_WHITE_SPAWN_EGG = spawnEgg("sow_large_white", () -> FarmEntityTypes.SOW_LARGE_WHITE.get(), 15061714, 13876669);
	public static final DeferredItem<DeferredSpawnEggItem> HOG_LARGE_WHITE_SPAWN_EGG = spawnEgg("hog_large_white", () -> FarmEntityTypes.HOG_LARGE_WHITE.get(), 15061714, 13876669);
	public static final DeferredItem<DeferredSpawnEggItem> PIGLET_LARGE_WHITE_SPAWN_EGG = spawnEgg("piglet_large_white", () -> FarmEntityTypes.PIGLET_LARGE_WHITE.get(), 15061714, 13876669);

	public static final DeferredItem<DeferredSpawnEggItem> SOW_OLD_SPOT_SPAWN_EGG = spawnEgg("sow_old_spot", () -> FarmEntityTypes.SOW_OLD_SPOT.get(), 15845576, 9859698);
	public static final DeferredItem<DeferredSpawnEggItem> HOG_OLD_SPOT_SPAWN_EGG = spawnEgg("hog_old_spot", () -> FarmEntityTypes.HOG_OLD_SPOT.get(), 15845576, 9859698);
	public static final DeferredItem<DeferredSpawnEggItem> PIGLET_OLD_SPOT_SPAWN_EGG = spawnEgg("piglet_old_spot", () -> FarmEntityTypes.PIGLET_OLD_SPOT.get(), 15845576, 9859698);

	public static final DeferredItem<DeferredSpawnEggItem> SOW_YORKSHIRE_SPAWN_EGG = spawnEgg("sow_yorkshire", () -> FarmEntityTypes.SOW_YORKSHIRE.get(), 15845576, 15117998);
	public static final DeferredItem<DeferredSpawnEggItem> HOG_YORKSHIRE_SPAWN_EGG = spawnEgg("hog_yorkshire", () -> FarmEntityTypes.HOG_YORKSHIRE.get(), 15845576, 15117998);
	public static final DeferredItem<DeferredSpawnEggItem> PIGLET_YORKSHIRE_SPAWN_EGG = spawnEgg("piglet_yorkshire", () -> FarmEntityTypes.PIGLET_YORKSHIRE.get(), 15845576, 15117998);

	 

	public static final FoodProperties RAW_PRIME_LAMB_FOOD = new FoodProperties.Builder()
			.nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties COOKED_PRIME_LAMB_FOOD = new FoodProperties.Builder()
			.nutrition(8).saturationModifier(0.8F).build();

	public static final DeferredItem<Item> RAW_PRIME_LAMB = ITEMS.registerSimpleItem("raw_prime_lamb",
			new Item.Properties().food(RAW_PRIME_LAMB_FOOD));
	public static final DeferredItem<Item> COOKED_PRIME_LAMB = ITEMS.registerSimpleItem("cooked_prime_lamb",
			new Item.Properties().food(COOKED_PRIME_LAMB_FOOD));

	public static final DeferredItem<DeferredSpawnEggItem> EWE_DORPER_SPAWN_EGG = spawnEgg("ewe_dorper", () -> FarmEntityTypes.EWE_DORPER.get(), 15987699, 13552319);
	public static final DeferredItem<DeferredSpawnEggItem> RAM_DORPER_SPAWN_EGG = spawnEgg("ram_dorper", () -> FarmEntityTypes.RAM_DORPER.get(), 15987699, 13552319);
	public static final DeferredItem<DeferredSpawnEggItem> LAMB_DORPER_SPAWN_EGG = spawnEgg("lamb_dorper", () -> FarmEntityTypes.LAMB_DORPER.get(), 15987699, 13552319);

	public static final DeferredItem<DeferredSpawnEggItem> EWE_DORSET_SPAWN_EGG = spawnEgg("ewe_dorset", () -> FarmEntityTypes.EWE_DORSET.get(), 4863280, 15790320);
	public static final DeferredItem<DeferredSpawnEggItem> RAM_DORSET_SPAWN_EGG = spawnEgg("ram_dorset", () -> FarmEntityTypes.RAM_DORSET.get(), 4863280, 15790320);
	public static final DeferredItem<DeferredSpawnEggItem> LAMB_DORSET_SPAWN_EGG = spawnEgg("lamb_dorset", () -> FarmEntityTypes.LAMB_DORSET.get(), 4863280, 15790320);

	public static final DeferredItem<DeferredSpawnEggItem> EWE_FRIESIAN_SPAWN_EGG = spawnEgg("ewe_friesian", () -> FarmEntityTypes.EWE_FRIESIAN.get(), 2039583, 4013373);
	public static final DeferredItem<DeferredSpawnEggItem> RAM_FRIESIAN_SPAWN_EGG = spawnEgg("ram_friesian", () -> FarmEntityTypes.RAM_FRIESIAN.get(), 2039583, 4013373);
	public static final DeferredItem<DeferredSpawnEggItem> LAMB_FRIESIAN_SPAWN_EGG = spawnEgg("lamb_friesian", () -> FarmEntityTypes.LAMB_FRIESIAN.get(), 2039583, 4013373);

	public static final DeferredItem<DeferredSpawnEggItem> EWE_JACOB_SPAWN_EGG = spawnEgg("ewe_jacob", () -> FarmEntityTypes.EWE_JACOB.get(), 15921647, 2368548);
	public static final DeferredItem<DeferredSpawnEggItem> RAM_JACOB_SPAWN_EGG = spawnEgg("ram_jacob", () -> FarmEntityTypes.RAM_JACOB.get(), 15921647, 2368548);
	public static final DeferredItem<DeferredSpawnEggItem> LAMB_JACOB_SPAWN_EGG = spawnEgg("lamb_jacob", () -> FarmEntityTypes.LAMB_JACOB.get(), 15921647, 2368548);

	public static final DeferredItem<DeferredSpawnEggItem> EWE_MERINO_SPAWN_EGG = spawnEgg("ewe_merino", () -> FarmEntityTypes.EWE_MERINO.get(), 11904114, 15526109);
	public static final DeferredItem<DeferredSpawnEggItem> RAM_MERINO_SPAWN_EGG = spawnEgg("ram_merino", () -> FarmEntityTypes.RAM_MERINO.get(), 11904114, 15526109);
	public static final DeferredItem<DeferredSpawnEggItem> LAMB_MERINO_SPAWN_EGG = spawnEgg("lamb_merino", () -> FarmEntityTypes.LAMB_MERINO.get(), 11904114, 15526109);

	public static final DeferredItem<DeferredSpawnEggItem> EWE_SUFFOLK_SPAWN_EGG = spawnEgg("ewe_suffolk", () -> FarmEntityTypes.EWE_SUFFOLK.get(), 2757652, 4336416);
	public static final DeferredItem<DeferredSpawnEggItem> RAM_SUFFOLK_SPAWN_EGG = spawnEgg("ram_suffolk", () -> FarmEntityTypes.RAM_SUFFOLK.get(), 2757652, 4336416);
	public static final DeferredItem<DeferredSpawnEggItem> LAMB_SUFFOLK_SPAWN_EGG = spawnEgg("lamb_suffolk", () -> FarmEntityTypes.LAMB_SUFFOLK.get(), 2757652, 4336416);

	 

	public static final DeferredItem<DeferredSpawnEggItem> DOE_ALPINE_SPAWN_EGG = spawnEgg("doe_alpine", () -> FarmEntityTypes.DOE_ALPINE.get(), 14867928, 8281676);
	public static final DeferredItem<DeferredSpawnEggItem> BUCK_ALPINE_SPAWN_EGG = spawnEgg("buck_alpine", () -> FarmEntityTypes.BUCK_ALPINE.get(), 14867928, 8281676);
	public static final DeferredItem<DeferredSpawnEggItem> KID_ALPINE_SPAWN_EGG = spawnEgg("kid_alpine", () -> FarmEntityTypes.KID_ALPINE.get(), 14867928, 8281676);

	public static final DeferredItem<DeferredSpawnEggItem> DOE_ANGORA_SPAWN_EGG = spawnEgg("doe_angora", () -> FarmEntityTypes.DOE_ANGORA.get(), 13814191, 16776179);
	public static final DeferredItem<DeferredSpawnEggItem> BUCK_ANGORA_SPAWN_EGG = spawnEgg("buck_angora", () -> FarmEntityTypes.BUCK_ANGORA.get(), 13814191, 16776179);
	public static final DeferredItem<DeferredSpawnEggItem> KID_ANGORA_SPAWN_EGG = spawnEgg("kid_angora", () -> FarmEntityTypes.KID_ANGORA.get(), 13814191, 16776179);

	public static final DeferredItem<DeferredSpawnEggItem> DOE_FAINTING_SPAWN_EGG = spawnEgg("doe_fainting", () -> FarmEntityTypes.DOE_FAINTING.get(), 1250067, 14803425);
	public static final DeferredItem<DeferredSpawnEggItem> BUCK_FAINTING_SPAWN_EGG = spawnEgg("buck_fainting", () -> FarmEntityTypes.BUCK_FAINTING.get(), 1250067, 14803425);
	public static final DeferredItem<DeferredSpawnEggItem> KID_FAINTING_SPAWN_EGG = spawnEgg("kid_fainting", () -> FarmEntityTypes.KID_FAINTING.get(), 1250067, 14803425);

	public static final DeferredItem<DeferredSpawnEggItem> DOE_KIKO_SPAWN_EGG = spawnEgg("doe_kiko", () -> FarmEntityTypes.DOE_KIKO.get(), 3549475, 8802872);
	public static final DeferredItem<DeferredSpawnEggItem> BUCK_KIKO_SPAWN_EGG = spawnEgg("buck_kiko", () -> FarmEntityTypes.BUCK_KIKO.get(), 3549475, 8802872);
	public static final DeferredItem<DeferredSpawnEggItem> KID_KIKO_SPAWN_EGG = spawnEgg("kid_kiko", () -> FarmEntityTypes.KID_KIKO.get(), 3549475, 8802872);

	public static final DeferredItem<DeferredSpawnEggItem> DOE_KINDER_SPAWN_EGG = spawnEgg("doe_kinder", () -> FarmEntityTypes.DOE_KINDER.get(), 13811120, 9263679);
	public static final DeferredItem<DeferredSpawnEggItem> BUCK_KINDER_SPAWN_EGG = spawnEgg("buck_kinder", () -> FarmEntityTypes.BUCK_KINDER.get(), 13811120, 9263679);
	public static final DeferredItem<DeferredSpawnEggItem> KID_KINDER_SPAWN_EGG = spawnEgg("kid_kinder", () -> FarmEntityTypes.KID_KINDER.get(), 13811120, 9263679);

	public static final DeferredItem<DeferredSpawnEggItem> DOE_NIGERIAN_DWARF_SPAWN_EGG = spawnEgg("doe_nigerian_dwarf", () -> FarmEntityTypes.DOE_NIGERIAN_DWARF.get(), 2697513, 8343350);
	public static final DeferredItem<DeferredSpawnEggItem> BUCK_NIGERIAN_DWARF_SPAWN_EGG = spawnEgg("buck_nigerian_dwarf", () -> FarmEntityTypes.BUCK_NIGERIAN_DWARF.get(), 2697513, 8343350);
	public static final DeferredItem<DeferredSpawnEggItem> KID_NIGERIAN_DWARF_SPAWN_EGG = spawnEgg("kid_nigerian_dwarf", () -> FarmEntityTypes.KID_NIGERIAN_DWARF.get(), 2697513, 8343350);

	public static final DeferredItem<DeferredSpawnEggItem> DOE_PYGMY_SPAWN_EGG = spawnEgg("doe_pygmy", () -> FarmEntityTypes.DOE_PYGMY.get(), 4145731, 9475221);
	public static final DeferredItem<DeferredSpawnEggItem> BUCK_PYGMY_SPAWN_EGG = spawnEgg("buck_pygmy", () -> FarmEntityTypes.BUCK_PYGMY.get(), 4145731, 9475221);
	public static final DeferredItem<DeferredSpawnEggItem> KID_PYGMY_SPAWN_EGG = spawnEgg("kid_pygmy", () -> FarmEntityTypes.KID_PYGMY.get(), 4145731, 9475221);

	public static final DeferredItem<DeferredSpawnEggItem> MARE_DRAFT_SPAWN_EGG = spawnEgg("mare_draft", () -> FarmEntityTypes.MARE_DRAFT.get(), 8600606, 12829635);
	public static final DeferredItem<DeferredSpawnEggItem> STALLION_DRAFT_SPAWN_EGG = spawnEgg("stallion_draft", () -> FarmEntityTypes.STALLION_DRAFT.get(), 8600606, 12829635);
	public static final DeferredItem<DeferredSpawnEggItem> FOAL_DRAFT_SPAWN_EGG = spawnEgg("foal_draft", () -> FarmEntityTypes.FOAL_DRAFT.get(), 8600606, 12829635);

	 
	public static final DeferredItem<ItemRandomAnimalEgg> COW_RANDOM_SPAWN_EGG = randomEgg("cow_random", CowType.values());
	public static final DeferredItem<ItemRandomAnimalEgg> PIG_RANDOM_SPAWN_EGG = randomEgg("pig_random", PigType.values());
	public static final DeferredItem<ItemRandomAnimalEgg> CHICKEN_RANDOM_SPAWN_EGG = randomEgg("chicken_random", ChickenType.values());
	public static final DeferredItem<ItemRandomAnimalEgg> GOAT_RANDOM_SPAWN_EGG = randomEgg("goat_random", GoatType.values());
	public static final DeferredItem<ItemRandomAnimalEgg> SHEEP_RANDOM_SPAWN_EGG = randomEgg("sheep_random", SheepType.values());

	private static DeferredItem<DeferredSpawnEggItem> spawnEgg(String entityName, java.util.function.Supplier<net.minecraft.world.entity.EntityType<? extends net.minecraft.world.entity.Mob>> type, int primaryColor, int secondaryColor)
	{
		return ITEMS.register(entityName + "_spawn_egg",
				() -> new DeferredSpawnEggItem(type, primaryColor, secondaryColor, new Item.Properties()));
	}

	private static DeferredItem<ItemRandomAnimalEgg> randomEgg(String name, com.animania.api.interfaces.AnimaniaType[] types)
	{
		return ITEMS.register(name + "_spawn_egg", () -> new ItemRandomAnimalEgg(types, "item.animania." + name + "_spawn_egg", new Item.Properties()));
	}

	 

	 
	public static ItemStack honeyJarStack()
	{
		return new ItemStack(HONEY_JAR.get());
	}

	 
	public static void registerCapabilities(RegisterCapabilitiesEvent event)
	{
		event.registerItem(Capabilities.FluidHandler.ITEM,
				(stack, context) -> new HoneyJarFluidHandler(stack), HONEY_JAR.get());
	}

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ANIMANIA_TAB = CREATIVE_TABS.register("animania",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.animania"))
					.icon(() -> new ItemStack(HEN_LEGHORN_SPAWN_EGG.get()))
					.displayItems((parameters, output) ->
					{
						output.accept(RAW_PRIME_CHICKEN.get());
						output.accept(COOKED_PRIME_CHICKEN.get());
						output.accept(RAW_PRIME_BEEF.get());
						output.accept(COOKED_PRIME_BEEF.get());
						output.accept(CARVING_KNIFE.get());
						output.accept(RIDING_CROP.get());
						output.accept(RAW_PRIME_STEAK.get());
						output.accept(COOKED_PRIME_STEAK.get());
						output.accept(RAW_PRIME_BACON.get());
						output.accept(COOKED_PRIME_BACON.get());
						output.accept(HOLSTEIN_CHEESE_WEDGE.get());
						output.accept(FRIESIAN_CHEESE_WEDGE.get());
						output.accept(JERSEY_CHEESE_WEDGE.get());
						output.accept(SHEEP_CHEESE_WEDGE.get());
						output.accept(GOAT_CHEESE_WEDGE.get());
						output.accept(MILK_BOTTLE.get());
						output.accept(PLAIN_OMELETTE.get());
						output.accept(CHEESE_OMELETTE.get());
						output.accept(BACON_OMELETTE.get());
						output.accept(TRUFFLE_OMELETTE.get());
						output.accept(SUPER_OMELETTE.get());
						output.accept(TRUFFLE_SOUP.get());
						output.accept(CHOCOLATE_TRUFFLE.get());
						output.accept(RAW_PRIME_PORK.get());
						output.accept(COOKED_PRIME_PORK.get());
						output.accept(TRUFFLE.get());
						output.accept(CommonFluids.SLOP_BUCKET.get());
						output.accept(WOOL_DORSET_NATURAL.get());
						output.accept(WOOL_FRIESIAN_1.get());
						output.accept(WOOL_FRIESIAN_2.get());
						output.accept(WOOL_JACOB.get());
						output.accept(WOOL_MERINO_NATURAL.get());
						output.accept(WOOL_MERINO_BROWN.get());
						output.accept(WOOL_SUFFOLK_NATURAL.get());
						output.accept(CommonFluids.MILK_FRIESIAN_BUCKET.get());
						output.accept(CommonFluids.MILK_HOLSTEIN_BUCKET.get());
						output.accept(CommonFluids.MILK_JERSEY_BUCKET.get());
						output.accept(SHEEP_MILK_BUCKET.get());
						output.accept(RAW_PRIME_LAMB.get());
						output.accept(COOKED_PRIME_LAMB.get());
						output.accept(RAW_PRIME_CHEVON.get());
						output.accept(COOKED_PRIME_CHEVON.get());
						output.accept(RAW_CHEVON.get());
						output.accept(COOKED_CHEVON.get());
						output.accept(GOAT_MILK_BUCKET.get());
					output.accept(RAW_HORSE.get());
					output.accept(COOKED_HORSE.get());
					output.accept(ITEM_CART.get());
					output.accept(ITEM_TILLER.get());
					output.accept(ITEM_WAGON.get());
					output.accept(WHEEL.get());
					output.accept(BROWN_EGG.get());
					output.accept(com.animania.common.blocks.CommonBlocks.BLOCK_STRAW_ITEM.get());
					output.accept(com.animania.common.blocks.CommonBlocks.BLOCK_TROUGH_ITEM.get());
					output.accept(SALT.get());
					output.accept(com.animania.addons.farm.FarmBlocks.CHEESE_WHEEL_FRIESIAN_ITEM.get());
					output.accept(com.animania.addons.farm.FarmBlocks.CHEESE_WHEEL_HOLSTEIN_ITEM.get());
					output.accept(com.animania.addons.farm.FarmBlocks.CHEESE_WHEEL_JERSEY_ITEM.get());
					output.accept(com.animania.addons.farm.FarmBlocks.CHEESE_WHEEL_SHEEP_ITEM.get());
					output.accept(com.animania.addons.farm.FarmBlocks.CHEESE_WHEEL_GOAT_ITEM.get());
					output.accept(com.animania.addons.farm.FarmBlocks.CHEESE_MOLD_ITEM.get());
					output.accept(HONEY_JAR.get());
					output.accept(HONEY_BUCKET.get());
					output.accept(com.animania.addons.farm.FarmBlocks.HIVE_ITEM.get());
					output.accept(com.animania.addons.farm.FarmBlocks.WILD_HIVE_ITEM.get());
					output.accept(com.animania.common.blocks.CommonBlocks.BLOCK_NEST_ITEM.get());
						output.accept(com.animania.common.blocks.CommonBlocks.BLOCK_SALT_LICK_ITEM.get());
						output.accept(COW_RANDOM_SPAWN_EGG.get());
						output.accept(PIG_RANDOM_SPAWN_EGG.get());
						output.accept(CHICKEN_RANDOM_SPAWN_EGG.get());
						output.accept(GOAT_RANDOM_SPAWN_EGG.get());
						output.accept(SHEEP_RANDOM_SPAWN_EGG.get());
						ITEMS.getEntries().forEach(holder ->
						{
							if (holder.get() instanceof DeferredSpawnEggItem)
								output.accept(holder.get());
						});
					})
					.build());
}
