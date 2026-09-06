package com.animania.addons.catsdogs;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.catsdogs.common.entity.canids.DogType;
import com.animania.addons.catsdogs.common.entity.felids.CatType;
import com.animania.common.item.ItemRandomAnimalEgg;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

 



public class CatsDogsItems
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Animania.MODID);

	public static final DeferredItem<ItemRandomAnimalEgg> DOG_RANDOM_SPAWN_EGG = randomEgg("dog_random", DogType.values());
	public static final DeferredItem<ItemRandomAnimalEgg> CAT_RANDOM_SPAWN_EGG = randomEgg("cat_random", CatType.values());

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_BLOODHOUND_SPAWN_EGG = spawnEgg("dog_male_bloodhound", () -> CatsDogsEntityTypes.DOG_MALE_BLOODHOUND.get(), -5938636, -13689844);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_BLOODHOUND_SPAWN_EGG = spawnEgg("dog_female_bloodhound", () -> CatsDogsEntityTypes.DOG_FEMALE_BLOODHOUND.get(), -5938636, -13689844);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_BLOODHOUND_SPAWN_EGG = spawnEgg("dog_puppy_bloodhound", () -> CatsDogsEntityTypes.DOG_PUPPY_BLOODHOUND.get(), -5938636, -13689844);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_CHIHUAHUA_SPAWN_EGG = spawnEgg("dog_male_chihuahua", () -> CatsDogsEntityTypes.DOG_MALE_CHIHUAHUA.get(), -593428, -16382716);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_CHIHUAHUA_SPAWN_EGG = spawnEgg("dog_female_chihuahua", () -> CatsDogsEntityTypes.DOG_FEMALE_CHIHUAHUA.get(), -593428, -16382716);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_CHIHUAHUA_SPAWN_EGG = spawnEgg("dog_puppy_chihuahua", () -> CatsDogsEntityTypes.DOG_PUPPY_CHIHUAHUA.get(), -593428, -16382716);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_COLLIE_SPAWN_EGG = spawnEgg("dog_male_collie", () -> CatsDogsEntityTypes.DOG_MALE_COLLIE.get(), -12570587, -197380);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_COLLIE_SPAWN_EGG = spawnEgg("dog_female_collie", () -> CatsDogsEntityTypes.DOG_FEMALE_COLLIE.get(), -12570587, -197380);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_COLLIE_SPAWN_EGG = spawnEgg("dog_puppy_collie", () -> CatsDogsEntityTypes.DOG_PUPPY_COLLIE.get(), -12570587, -197380);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_CORGI_SPAWN_EGG = spawnEgg("dog_male_corgi", () -> CatsDogsEntityTypes.DOG_MALE_CORGI.get(), -263173, -2987202);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_CORGI_SPAWN_EGG = spawnEgg("dog_female_corgi", () -> CatsDogsEntityTypes.DOG_FEMALE_CORGI.get(), -263173, -2987202);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_CORGI_SPAWN_EGG = spawnEgg("dog_puppy_corgi", () -> CatsDogsEntityTypes.DOG_PUPPY_CORGI.get(), -263173, -2987202);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_DACHSHUND_SPAWN_EGG = spawnEgg("dog_male_dachshund", () -> CatsDogsEntityTypes.DOG_MALE_DACHSHUND.get(), -197380, -15988473);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_DACHSHUND_SPAWN_EGG = spawnEgg("dog_female_dachshund", () -> CatsDogsEntityTypes.DOG_FEMALE_DACHSHUND.get(), -197380, -15988473);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_DACHSHUND_SPAWN_EGG = spawnEgg("dog_puppy_dachshund", () -> CatsDogsEntityTypes.DOG_PUPPY_DACHSHUND.get(), -197380, -15988473);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_FOX_SPAWN_EGG = spawnEgg("dog_male_fox", () -> CatsDogsEntityTypes.DOG_MALE_FOX.get(), -5415620, -13946603);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_FOX_SPAWN_EGG = spawnEgg("dog_female_fox", () -> CatsDogsEntityTypes.DOG_FEMALE_FOX.get(), -5415620, -13946603);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_FOX_SPAWN_EGG = spawnEgg("dog_puppy_fox", () -> CatsDogsEntityTypes.DOG_PUPPY_FOX.get(), -5415620, -13946603);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_GERMAN_SHEPHERD_SPAWN_EGG = spawnEgg("dog_male_german_shepherd", () -> CatsDogsEntityTypes.DOG_MALE_GERMAN_SHEPHERD.get(), -8300224, -14478321);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_GERMAN_SHEPHERD_SPAWN_EGG = spawnEgg("dog_female_german_shepherd", () -> CatsDogsEntityTypes.DOG_FEMALE_GERMAN_SHEPHERD.get(), -8300224, -14478321);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_GERMAN_SHEPHERD_SPAWN_EGG = spawnEgg("dog_puppy_german_shepherd", () -> CatsDogsEntityTypes.DOG_PUPPY_GERMAN_SHEPHERD.get(), -8300224, -14478321);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_GREAT_DANE_SPAWN_EGG = spawnEgg("dog_male_great_dane", () -> CatsDogsEntityTypes.DOG_MALE_GREAT_DANE.get(), -8300224, -14412785);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_GREAT_DANE_SPAWN_EGG = spawnEgg("dog_female_great_dane", () -> CatsDogsEntityTypes.DOG_FEMALE_GREAT_DANE.get(), -8300224, -14412785);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_GREAT_DANE_SPAWN_EGG = spawnEgg("dog_puppy_great_dane", () -> CatsDogsEntityTypes.DOG_PUPPY_GREAT_DANE.get(), -8300224, -14412785);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_GREYHOUND_SPAWN_EGG = spawnEgg("dog_male_greyhound", () -> CatsDogsEntityTypes.DOG_MALE_GREYHOUND.get(), -7578572, -15987708);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_GREYHOUND_SPAWN_EGG = spawnEgg("dog_female_greyhound", () -> CatsDogsEntityTypes.DOG_FEMALE_GREYHOUND.get(), -7578572, -15987708);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_GREYHOUND_SPAWN_EGG = spawnEgg("dog_puppy_greyhound", () -> CatsDogsEntityTypes.DOG_PUPPY_GREYHOUND.get(), -7578572, -15987708);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_HUSKY_SPAWN_EGG = spawnEgg("dog_male_husky", () -> CatsDogsEntityTypes.DOG_MALE_HUSKY.get(), -14606304, -1118482);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_HUSKY_SPAWN_EGG = spawnEgg("dog_female_husky", () -> CatsDogsEntityTypes.DOG_FEMALE_HUSKY.get(), -14606304, -1118482);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_HUSKY_SPAWN_EGG = spawnEgg("dog_puppy_husky", () -> CatsDogsEntityTypes.DOG_PUPPY_HUSKY.get(), -14606304, -1118482);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_LABRADOR_SPAWN_EGG = spawnEgg("dog_male_labrador", () -> CatsDogsEntityTypes.DOG_MALE_LABRADOR.get(), 6699050, 4009472);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_LABRADOR_SPAWN_EGG = spawnEgg("dog_female_labrador", () -> CatsDogsEntityTypes.DOG_FEMALE_LABRADOR.get(), 6699050, 4009472);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_LABRADOR_SPAWN_EGG = spawnEgg("dog_puppy_labrador", () -> CatsDogsEntityTypes.DOG_PUPPY_LABRADOR.get(), 6699050, 4009472);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_POMERANIAN_SPAWN_EGG = spawnEgg("dog_male_pomeranian", () -> CatsDogsEntityTypes.DOG_MALE_POMERANIAN.get(), -197380, -13884380);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_POMERANIAN_SPAWN_EGG = spawnEgg("dog_female_pomeranian", () -> CatsDogsEntityTypes.DOG_FEMALE_POMERANIAN.get(), -197380, -13884380);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_POMERANIAN_SPAWN_EGG = spawnEgg("dog_puppy_pomeranian", () -> CatsDogsEntityTypes.DOG_PUPPY_POMERANIAN.get(), -197380, -13884380);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_POODLE_SPAWN_EGG = spawnEgg("dog_male_poodle", () -> CatsDogsEntityTypes.DOG_MALE_POODLE.get(), -658707, -5537189);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_POODLE_SPAWN_EGG = spawnEgg("dog_female_poodle", () -> CatsDogsEntityTypes.DOG_FEMALE_POODLE.get(), -658707, -5537189);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_POODLE_SPAWN_EGG = spawnEgg("dog_puppy_poodle", () -> CatsDogsEntityTypes.DOG_PUPPY_POODLE.get(), -658707, -5537189);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_PUG_SPAWN_EGG = spawnEgg("dog_male_pug", () -> CatsDogsEntityTypes.DOG_MALE_PUG.get(), -1514529, -13026238);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_PUG_SPAWN_EGG = spawnEgg("dog_female_pug", () -> CatsDogsEntityTypes.DOG_FEMALE_PUG.get(), -1514529, -13026238);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_PUG_SPAWN_EGG = spawnEgg("dog_puppy_pug", () -> CatsDogsEntityTypes.DOG_PUPPY_PUG.get(), -1514529, -13026238);

	public static final DeferredItem<DeferredSpawnEggItem> DOG_MALE_WOLF_SPAWN_EGG = spawnEgg("dog_male_wolf", () -> CatsDogsEntityTypes.DOG_MALE_WOLF.get(), 12228048, 12683020);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_FEMALE_WOLF_SPAWN_EGG = spawnEgg("dog_female_wolf", () -> CatsDogsEntityTypes.DOG_FEMALE_WOLF.get(), 12228048, 12683020);
	public static final DeferredItem<DeferredSpawnEggItem> DOG_PUPPY_WOLF_SPAWN_EGG = spawnEgg("dog_puppy_wolf", () -> CatsDogsEntityTypes.DOG_PUPPY_WOLF.get(), 12228048, 12683020);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_AMERICAN_SHORTHAIR_SPAWN_EGG = spawnEgg("cat_tom_american_shorthair", () -> CatsDogsEntityTypes.CAT_TOM_AMERICAN_SHORTHAIR.get(), 7434609, 0);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_AMERICAN_SHORTHAIR_SPAWN_EGG = spawnEgg("cat_queen_american_shorthair", () -> CatsDogsEntityTypes.CAT_QUEEN_AMERICAN_SHORTHAIR.get(), 7434609, 0);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_AMERICAN_SHORTHAIR_SPAWN_EGG = spawnEgg("cat_kitten_american_shorthair", () -> CatsDogsEntityTypes.CAT_KITTEN_AMERICAN_SHORTHAIR.get(), 7434609, 0);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_ASIATIC_SPAWN_EGG = spawnEgg("cat_tom_asiatic", () -> CatsDogsEntityTypes.CAT_TOM_ASIATIC.get(), 8152144, 3684408);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_ASIATIC_SPAWN_EGG = spawnEgg("cat_queen_asiatic", () -> CatsDogsEntityTypes.CAT_QUEEN_ASIATIC.get(), 8152144, 3684408);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_ASIATIC_SPAWN_EGG = spawnEgg("cat_kitten_asiatic", () -> CatsDogsEntityTypes.CAT_KITTEN_ASIATIC.get(), 8152144, 3684408);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_EXOTIC_SPAWN_EGG = spawnEgg("cat_tom_exotic", () -> CatsDogsEntityTypes.CAT_TOM_EXOTIC.get(), 11426596, 14129778);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_EXOTIC_SPAWN_EGG = spawnEgg("cat_queen_exotic", () -> CatsDogsEntityTypes.CAT_QUEEN_EXOTIC.get(), 11426596, 14129778);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_EXOTIC_SPAWN_EGG = spawnEgg("cat_kitten_exotic", () -> CatsDogsEntityTypes.CAT_KITTEN_EXOTIC.get(), 11426596, 14129778);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_NORWEGIAN_SPAWN_EGG = spawnEgg("cat_tom_norwegian", () -> CatsDogsEntityTypes.CAT_TOM_NORWEGIAN.get(), 3878181, 9992290);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_NORWEGIAN_SPAWN_EGG = spawnEgg("cat_queen_norwegian", () -> CatsDogsEntityTypes.CAT_QUEEN_NORWEGIAN.get(), 3878181, 9992290);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_NORWEGIAN_SPAWN_EGG = spawnEgg("cat_kitten_norwegian", () -> CatsDogsEntityTypes.CAT_KITTEN_NORWEGIAN.get(), 3878181, 9992290);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_OCELOT_SPAWN_EGG = spawnEgg("cat_tom_ocelot", () -> CatsDogsEntityTypes.CAT_TOM_OCELOT.get(), 11633487, 4995106);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_OCELOT_SPAWN_EGG = spawnEgg("cat_queen_ocelot", () -> CatsDogsEntityTypes.CAT_QUEEN_OCELOT.get(), 11633487, 4995106);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_OCELOT_SPAWN_EGG = spawnEgg("cat_kitten_ocelot", () -> CatsDogsEntityTypes.CAT_KITTEN_OCELOT.get(), 11633487, 4995106);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_RAGDOLL_SPAWN_EGG = spawnEgg("cat_tom_ragdoll", () -> CatsDogsEntityTypes.CAT_TOM_RAGDOLL.get(), 13948116, 8741209);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_RAGDOLL_SPAWN_EGG = spawnEgg("cat_queen_ragdoll", () -> CatsDogsEntityTypes.CAT_QUEEN_RAGDOLL.get(), 13948116, 8741209);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_RAGDOLL_SPAWN_EGG = spawnEgg("cat_kitten_ragdoll", () -> CatsDogsEntityTypes.CAT_KITTEN_RAGDOLL.get(), 13948116, 8741209);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_SIAMESE_SPAWN_EGG = spawnEgg("cat_tom_siamese", () -> CatsDogsEntityTypes.CAT_TOM_SIAMESE.get(), 12489844, 3615264);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_SIAMESE_SPAWN_EGG = spawnEgg("cat_queen_siamese", () -> CatsDogsEntityTypes.CAT_QUEEN_SIAMESE.get(), 12489844, 3615264);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_SIAMESE_SPAWN_EGG = spawnEgg("cat_kitten_siamese", () -> CatsDogsEntityTypes.CAT_KITTEN_SIAMESE.get(), 12489844, 3615264);

	public static final DeferredItem<DeferredSpawnEggItem> CAT_TOM_TABBY_SPAWN_EGG = spawnEgg("cat_tom_tabby", () -> CatsDogsEntityTypes.CAT_TOM_TABBY.get(), 4272939, 4075560);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_QUEEN_TABBY_SPAWN_EGG = spawnEgg("cat_queen_tabby", () -> CatsDogsEntityTypes.CAT_QUEEN_TABBY.get(), 4272939, 4075560);
	public static final DeferredItem<DeferredSpawnEggItem> CAT_KITTEN_TABBY_SPAWN_EGG = spawnEgg("cat_kitten_tabby", () -> CatsDogsEntityTypes.CAT_KITTEN_TABBY.get(), 4272939, 4075560);

	private static DeferredItem<DeferredSpawnEggItem> spawnEgg(String entityName, Supplier<EntityType<? extends Mob>> type, int primaryColor, int secondaryColor)
	{
		return ITEMS.register(entityName + "_spawn_egg",
				() -> new DeferredSpawnEggItem(type, primaryColor, secondaryColor, new net.minecraft.world.item.Item.Properties()));
	}

	private static DeferredItem<ItemRandomAnimalEgg> randomEgg(String name, com.animania.api.interfaces.AnimaniaType[] types)
	{
		return ITEMS.register(name + "_spawn_egg", () -> new ItemRandomAnimalEgg(types, "item.animania." + name + "_spawn_egg", new net.minecraft.world.item.Item.Properties()));
	}

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ANIMANIA_CATSDOGS_TAB = CREATIVE_TABS.register("animania_catsdogs",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.animania_catsdogs"))
					.icon(() -> DOG_MALE_LABRADOR_SPAWN_EGG.get().getDefaultInstance())
					.displayItems((params, output) ->
					{
						output.accept(DOG_RANDOM_SPAWN_EGG.get());
						output.accept(CAT_RANDOM_SPAWN_EGG.get());
						ITEMS.getEntries().forEach(holder ->
						{
							if (holder.get() instanceof DeferredSpawnEggItem)
								output.accept(holder.get());
						});
					})
					.build());

	private CatsDogsItems()
	{
	}

	public static void register(IEventBus modEventBus)
	{
		ITEMS.register(modEventBus);
		CREATIVE_TABS.register(modEventBus);
	}
}
