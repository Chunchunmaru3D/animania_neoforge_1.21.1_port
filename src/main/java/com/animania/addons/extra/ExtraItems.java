package com.animania.addons.extra;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.peafowl.PeacockType;
import com.animania.addons.extra.common.entity.rodents.rabbits.RabbitType;
import com.animania.addons.extra.common.item.ItemHamsterBall;
import com.animania.common.item.ItemBonusFood;
import com.animania.common.item.ItemRandomAnimalEgg;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

 




public class ExtraItems
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Animania.MODID);

	public static final DeferredItem<DeferredSpawnEggItem> FROG_SPAWN_EGG = spawnEgg("frog", () -> ExtraEntityTypes.FROG.get(), 1860371, 1793554);
	public static final DeferredItem<DeferredSpawnEggItem> DART_FROG_SPAWN_EGG = spawnEgg("dart_frog", () -> ExtraEntityTypes.DART_FROG.get(), 15521330, 986895);
	public static final DeferredItem<DeferredSpawnEggItem> TOAD_SPAWN_EGG = spawnEgg("toad", () -> ExtraEntityTypes.TOAD.get(), 13868916, 5650205);
	public static final DeferredItem<ItemRandomAnimalEgg> PEACOCK_RANDOM_SPAWN_EGG = randomEgg("peacock_random", PeacockType.values());
	public static final DeferredItem<ItemRandomAnimalEgg> RABBIT_RANDOM_SPAWN_EGG = randomEgg("rabbit_random", RabbitType.values());

	 

	public static final DeferredItem<Item> PEACOCK_EGG_BLUE = ITEMS.registerSimpleItem("peacock_egg_blue", new Item.Properties().stacksTo(16));
	public static final DeferredItem<Item> PEACOCK_EGG_WHITE = ITEMS.registerSimpleItem("peacock_egg_white", new Item.Properties().stacksTo(16));

	 

	public static final DeferredItem<Item> HAMSTER_FOOD = ITEMS.registerSimpleItem("hamster_food", new Item.Properties());
	public static final DeferredItem<ItemHamsterBall> HAMSTER_BALL_CLEAR = ITEMS.register("hamster_ball_clear",
			() -> new ItemHamsterBall(false, new Item.Properties()));
	public static final DeferredItem<ItemHamsterBall> HAMSTER_BALL_COLORED = ITEMS.register("hamster_ball_colored",
			() -> new ItemHamsterBall(true, new Item.Properties()));

	 
	private static final FoodProperties RAW_CUT_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(1.0F).build();
	public static final DeferredItem<ItemBonusFood> RAW_PRIME_RABBIT = rawFood("raw_prime_rabbit");
	public static final DeferredItem<ItemBonusFood> COOKED_PRIME_RABBIT = food("cooked_prime_rabbit", 8, 0.5F,
			new MobEffectInstance(MobEffects.JUMP, 600, 3, false, false));
	public static final DeferredItem<ItemBonusFood> RAW_FROG_LEGS = rawFood("raw_frog_legs");
	public static final DeferredItem<ItemBonusFood> COOKED_FROG_LEGS = food("cooked_frog_legs", 7, 0.5F,
			new MobEffectInstance(MobEffects.JUMP, 1200, 2, false, false));
	public static final DeferredItem<ItemBonusFood> RAW_PEACOCK = rawFood("raw_peacock");
	public static final DeferredItem<ItemBonusFood> COOKED_PEACOCK = food("cooked_peacock", 6, 0.5F,
			new MobEffectInstance(MobEffects.LUCK, 600, 0, false, false));
	public static final DeferredItem<ItemBonusFood> RAW_PRIME_PEACOCK = rawFood("raw_prime_peacock");
	public static final DeferredItem<ItemBonusFood> COOKED_PRIME_PEACOCK = food("cooked_prime_peacock", 9, 0.5F,
			new MobEffectInstance(MobEffects.LUCK, 1200, 1, false, false));

	 

	public static final DeferredItem<Item> PEACOCK_FEATHER_BLUE = ITEMS.registerSimpleItem("peacock_feather_blue", new Item.Properties());
	public static final DeferredItem<Item> PEACOCK_FEATHER_WHITE = ITEMS.registerSimpleItem("peacock_feather_white", new Item.Properties());
	public static final DeferredItem<Item> PEACOCK_FEATHER_TAUPE = ITEMS.registerSimpleItem("peacock_feather_taupe", new Item.Properties());
	public static final DeferredItem<Item> PEACOCK_FEATHER_PURPLE = ITEMS.registerSimpleItem("peacock_feather_purple", new Item.Properties());
	public static final DeferredItem<Item> PEACOCK_FEATHER_PEACH = ITEMS.registerSimpleItem("peacock_feather_peach", new Item.Properties());
	public static final DeferredItem<Item> PEACOCK_FEATHER_OPAL = ITEMS.registerSimpleItem("peacock_feather_opal", new Item.Properties());
	public static final DeferredItem<Item> PEACOCK_FEATHER_CHARCOAL = ITEMS.registerSimpleItem("peacock_feather_charcoal", new Item.Properties());

	 

	public static final DeferredItem<DeferredSpawnEggItem> PEACOCK_BLUE_SPAWN_EGG = spawnEgg("peacock_blue", () -> ExtraEntityTypes.PEACOCK_BLUE.get(), 2088263, 3487232);
	public static final DeferredItem<DeferredSpawnEggItem> PEAFOWL_BLUE_SPAWN_EGG = spawnEgg("peafowl_blue", () -> ExtraEntityTypes.PEAFOWL_BLUE.get(), 2088263, 3487232);
	public static final DeferredItem<DeferredSpawnEggItem> PEACHICK_BLUE_SPAWN_EGG = spawnEgg("peachick_blue", () -> ExtraEntityTypes.PEACHICK_BLUE.get(), 2088263, 3487232);

	public static final DeferredItem<DeferredSpawnEggItem> PEACOCK_WHITE_SPAWN_EGG = spawnEgg("peacock_white", () -> ExtraEntityTypes.PEACOCK_WHITE.get(), 15921906, 13554152);
	public static final DeferredItem<DeferredSpawnEggItem> PEAFOWL_WHITE_SPAWN_EGG = spawnEgg("peafowl_white", () -> ExtraEntityTypes.PEAFOWL_WHITE.get(), 15921906, 13554152);
	public static final DeferredItem<DeferredSpawnEggItem> PEACHICK_WHITE_SPAWN_EGG = spawnEgg("peachick_white", () -> ExtraEntityTypes.PEACHICK_WHITE.get(), 15921906, 13554152);

	public static final DeferredItem<DeferredSpawnEggItem> PEACOCK_TAUPE_SPAWN_EGG = spawnEgg("peacock_taupe", () -> ExtraEntityTypes.PEACOCK_TAUPE.get(), 9139310, 7565694);
	public static final DeferredItem<DeferredSpawnEggItem> PEAFOWL_TAUPE_SPAWN_EGG = spawnEgg("peafowl_taupe", () -> ExtraEntityTypes.PEAFOWL_TAUPE.get(), 9139310, 7565694);
	public static final DeferredItem<DeferredSpawnEggItem> PEACHICK_TAUPE_SPAWN_EGG = spawnEgg("peachick_taupe", () -> ExtraEntityTypes.PEACHICK_TAUPE.get(), 9139310, 7565694);

	public static final DeferredItem<DeferredSpawnEggItem> PEACOCK_PURPLE_SPAWN_EGG = spawnEgg("peacock_purple", () -> ExtraEntityTypes.PEACOCK_PURPLE.get(), 6979202, 4587138);
	public static final DeferredItem<DeferredSpawnEggItem> PEAFOWL_PURPLE_SPAWN_EGG = spawnEgg("peafowl_purple", () -> ExtraEntityTypes.PEAFOWL_PURPLE.get(), 6979202, 4587138);
	public static final DeferredItem<DeferredSpawnEggItem> PEACHICK_PURPLE_SPAWN_EGG = spawnEgg("peachick_purple", () -> ExtraEntityTypes.PEACHICK_PURPLE.get(), 6979202, 4587138);

	public static final DeferredItem<DeferredSpawnEggItem> PEACOCK_PEACH_SPAWN_EGG = spawnEgg("peacock_peach", () -> ExtraEntityTypes.PEACOCK_PEACH.get(), 15238012, 12888183);
	public static final DeferredItem<DeferredSpawnEggItem> PEAFOWL_PEACH_SPAWN_EGG = spawnEgg("peafowl_peach", () -> ExtraEntityTypes.PEAFOWL_PEACH.get(), 15238012, 12888183);
	public static final DeferredItem<DeferredSpawnEggItem> PEACHICK_PEACH_SPAWN_EGG = spawnEgg("peachick_peach", () -> ExtraEntityTypes.PEACHICK_PEACH.get(), 15238012, 12888183);

	public static final DeferredItem<DeferredSpawnEggItem> PEACOCK_OPAL_SPAWN_EGG = spawnEgg("peacock_opal", () -> ExtraEntityTypes.PEACOCK_OPAL.get(), 11060164, 8438212);
	public static final DeferredItem<DeferredSpawnEggItem> PEAFOWL_OPAL_SPAWN_EGG = spawnEgg("peafowl_opal", () -> ExtraEntityTypes.PEAFOWL_OPAL.get(), 11060164, 8438212);
	public static final DeferredItem<DeferredSpawnEggItem> PEACHICK_OPAL_SPAWN_EGG = spawnEgg("peachick_opal", () -> ExtraEntityTypes.PEACHICK_OPAL.get(), 11060164, 8438212);

	public static final DeferredItem<DeferredSpawnEggItem> PEACOCK_CHARCOAL_SPAWN_EGG = spawnEgg("peacock_charcoal", () -> ExtraEntityTypes.PEACOCK_CHARCOAL.get(), 3815994, 1710618);
	public static final DeferredItem<DeferredSpawnEggItem> PEAFOWL_CHARCOAL_SPAWN_EGG = spawnEgg("peafowl_charcoal", () -> ExtraEntityTypes.PEAFOWL_CHARCOAL.get(), 3815994, 1710618);
	public static final DeferredItem<DeferredSpawnEggItem> PEACHICK_CHARCOAL_SPAWN_EGG = spawnEgg("peachick_charcoal", () -> ExtraEntityTypes.PEACHICK_CHARCOAL.get(), 3815994, 1710618);

	 

	public static final DeferredItem<DeferredSpawnEggItem> FERRET_GREY_SPAWN_EGG = spawnEgg("ferret_grey", () -> ExtraEntityTypes.FERRET_GREY.get(), 13948116, 8741209);
	public static final DeferredItem<DeferredSpawnEggItem> FERRET_WHITE_SPAWN_EGG = spawnEgg("ferret_white", () -> ExtraEntityTypes.FERRET_WHITE.get(), 15921906, 13554152);

	 

	public static final DeferredItem<DeferredSpawnEggItem> HAMSTER_SPAWN_EGG = spawnEgg("hamster", () -> ExtraEntityTypes.HAMSTER.get(), 14603464, 14317391);

	 

	public static final DeferredItem<DeferredSpawnEggItem> HEDGEHOG_SPAWN_EGG = spawnEgg("hedgehog", () -> ExtraEntityTypes.HEDGEHOG.get(), 10451558, 14337943);
	public static final DeferredItem<DeferredSpawnEggItem> HEDGEHOG_ALBINO_SPAWN_EGG = spawnEgg("hedgehog_albino", () -> ExtraEntityTypes.HEDGEHOG_ALBINO.get(), 12369084, 16777215);

	 

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_LOP_SPAWN_EGG = spawnEgg("rabbit_buck_lop", () -> ExtraEntityTypes.RABBIT_BUCK_LOP.get(), 13948116, 8741209);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_LOP_SPAWN_EGG = spawnEgg("rabbit_doe_lop", () -> ExtraEntityTypes.RABBIT_DOE_LOP.get(), 13948116, 8741209);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_LOP_SPAWN_EGG = spawnEgg("rabbit_kit_lop", () -> ExtraEntityTypes.RABBIT_KIT_LOP.get(), 13948116, 8741209);

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_REX_SPAWN_EGG = spawnEgg("rabbit_buck_rex", () -> ExtraEntityTypes.RABBIT_BUCK_REX.get(), 9139310, 7565694);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_REX_SPAWN_EGG = spawnEgg("rabbit_doe_rex", () -> ExtraEntityTypes.RABBIT_DOE_REX.get(), 9139310, 7565694);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_REX_SPAWN_EGG = spawnEgg("rabbit_kit_rex", () -> ExtraEntityTypes.RABBIT_KIT_REX.get(), 9139310, 7565694);

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_DUTCH_SPAWN_EGG = spawnEgg("rabbit_buck_dutch", () -> ExtraEntityTypes.RABBIT_BUCK_DUTCH.get(), 3815994, 15921906);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_DUTCH_SPAWN_EGG = spawnEgg("rabbit_doe_dutch", () -> ExtraEntityTypes.RABBIT_DOE_DUTCH.get(), 3815994, 15921906);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_DUTCH_SPAWN_EGG = spawnEgg("rabbit_kit_dutch", () -> ExtraEntityTypes.RABBIT_KIT_DUTCH.get(), 3815994, 15921906);

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_HAVANA_SPAWN_EGG = spawnEgg("rabbit_buck_havana", () -> ExtraEntityTypes.RABBIT_BUCK_HAVANA.get(), 6045214, 3618403);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_HAVANA_SPAWN_EGG = spawnEgg("rabbit_doe_havana", () -> ExtraEntityTypes.RABBIT_DOE_HAVANA.get(), 6045214, 3618403);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_HAVANA_SPAWN_EGG = spawnEgg("rabbit_kit_havana", () -> ExtraEntityTypes.RABBIT_KIT_HAVANA.get(), 6045214, 3618403);

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_NEW_ZEALAND_SPAWN_EGG = spawnEgg("rabbit_buck_new_zealand", () -> ExtraEntityTypes.RABBIT_BUCK_NEW_ZEALAND.get(), 15921906, 13554152);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_NEW_ZEALAND_SPAWN_EGG = spawnEgg("rabbit_doe_new_zealand", () -> ExtraEntityTypes.RABBIT_DOE_NEW_ZEALAND.get(), 15921906, 13554152);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_NEW_ZEALAND_SPAWN_EGG = spawnEgg("rabbit_kit_new_zealand", () -> ExtraEntityTypes.RABBIT_KIT_NEW_ZEALAND.get(), 15921906, 13554152);

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_JACK_SPAWN_EGG = spawnEgg("rabbit_buck_jack", () -> ExtraEntityTypes.RABBIT_BUCK_JACK.get(), 11828069, 8940772);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_JACK_SPAWN_EGG = spawnEgg("rabbit_doe_jack", () -> ExtraEntityTypes.RABBIT_DOE_JACK.get(), 11828069, 8940772);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_JACK_SPAWN_EGG = spawnEgg("rabbit_kit_jack", () -> ExtraEntityTypes.RABBIT_KIT_JACK.get(), 11828069, 8940772);

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_COTTONTAIL_SPAWN_EGG = spawnEgg("rabbit_buck_cottontail", () -> ExtraEntityTypes.RABBIT_BUCK_COTTONTAIL.get(), 10851765, 7889402);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_COTTONTAIL_SPAWN_EGG = spawnEgg("rabbit_doe_cottontail", () -> ExtraEntityTypes.RABBIT_DOE_COTTONTAIL.get(), 10851765, 7889402);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_COTTONTAIL_SPAWN_EGG = spawnEgg("rabbit_kit_cottontail", () -> ExtraEntityTypes.RABBIT_KIT_COTTONTAIL.get(), 10851765, 7889402);

	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_BUCK_CHINCHILLA_SPAWN_EGG = spawnEgg("rabbit_buck_chinchilla", () -> ExtraEntityTypes.RABBIT_BUCK_CHINCHILLA.get(), 10197915, 6710886);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_DOE_CHINCHILLA_SPAWN_EGG = spawnEgg("rabbit_doe_chinchilla", () -> ExtraEntityTypes.RABBIT_DOE_CHINCHILLA.get(), 10197915, 6710886);
	public static final DeferredItem<DeferredSpawnEggItem> RABBIT_KIT_CHINCHILLA_SPAWN_EGG = spawnEgg("rabbit_kit_chinchilla", () -> ExtraEntityTypes.RABBIT_KIT_CHINCHILLA.get(), 10197915, 6710886);

	private static DeferredItem<DeferredSpawnEggItem> spawnEgg(String entityName, Supplier<EntityType<? extends Mob>> type, int primaryColor, int secondaryColor)
	{
		return ITEMS.register(entityName + "_spawn_egg",
				() -> new DeferredSpawnEggItem(type, primaryColor, secondaryColor, new Item.Properties()));
	}

	private static DeferredItem<ItemRandomAnimalEgg> randomEgg(String name, com.animania.api.interfaces.AnimaniaType[] types)
	{
		return ITEMS.register(name + "_spawn_egg", () -> new ItemRandomAnimalEgg(types, "item.animania." + name + "_spawn_egg", new Item.Properties()));
	}

	private static DeferredItem<ItemBonusFood> rawFood(String name)
	{
		return ITEMS.register(name, () -> new ItemBonusFood(new Item.Properties().food(RAW_CUT_FOOD),
				new MobEffectInstance(MobEffects.CONFUSION, 200, 3, false, false)));
	}

	private static DeferredItem<ItemBonusFood> food(String name, int nutrition, float saturation, MobEffectInstance effect)
	{
		return ITEMS.register(name, () -> new ItemBonusFood(new Item.Properties().food(
				new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build()), effect));
	}

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ANIMANIA_EXTRA_TAB = CREATIVE_TABS.register("animania_extra",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.animania_extra"))
					.icon(() -> FROG_SPAWN_EGG.get().getDefaultInstance())
					.displayItems((params, output) ->
					{
						output.accept(FROG_SPAWN_EGG.get());
						output.accept(DART_FROG_SPAWN_EGG.get());
						output.accept(TOAD_SPAWN_EGG.get());

						output.accept(PEACOCK_EGG_BLUE.get());
						output.accept(PEACOCK_EGG_WHITE.get());
						output.accept(HAMSTER_FOOD.get());
						output.accept(ExtraBlocks.HAMSTER_WHEEL_ITEM.get());
						output.accept(HAMSTER_BALL_CLEAR.get());
						for (int color = 0; color < 16; color++)
							output.accept(ItemHamsterBall.colouredStack(HAMSTER_BALL_COLORED.get(), color));
						output.accept(RAW_PRIME_RABBIT.get());
						output.accept(COOKED_PRIME_RABBIT.get());
						output.accept(RAW_FROG_LEGS.get());
						output.accept(COOKED_FROG_LEGS.get());
						output.accept(RAW_PEACOCK.get());
						output.accept(COOKED_PEACOCK.get());
						output.accept(RAW_PRIME_PEACOCK.get());
						output.accept(COOKED_PRIME_PEACOCK.get());
						output.accept(PEACOCK_FEATHER_BLUE.get());
						output.accept(PEACOCK_FEATHER_WHITE.get());
						output.accept(PEACOCK_FEATHER_TAUPE.get());
						output.accept(PEACOCK_FEATHER_PURPLE.get());
						output.accept(PEACOCK_FEATHER_PEACH.get());
						output.accept(PEACOCK_FEATHER_OPAL.get());
						output.accept(PEACOCK_FEATHER_CHARCOAL.get());
						output.accept(PEACOCK_RANDOM_SPAWN_EGG.get());
						output.accept(RABBIT_RANDOM_SPAWN_EGG.get());

						ITEMS.getEntries().forEach(holder ->
						{
							if (holder.get() instanceof DeferredSpawnEggItem)
								output.accept(holder.get());
						});
					})
					.build());

	private ExtraItems()
	{
	}

	public static void register(IEventBus modEventBus)
	{
		ITEMS.register(modEventBus);
		CREATIVE_TABS.register(modEventBus);
	}
}
