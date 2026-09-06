package com.animania.addons.farm.config;

import java.util.List;

import net.neoforged.neoforge.common.ModConfigSpec;

 



public final class FarmConfig
{
	public static final ModConfigSpec SPEC;
	public static final Settings settings;

	public static class Settings
	{
		public final ModConfigSpec.ConfigValue<List<? extends String>> chickenFood;
		public final ModConfigSpec.ConfigValue<String> chickenBed;
		public final ModConfigSpec.ConfigValue<String> chickenBed2;
		public final ModConfigSpec.BooleanValue chickensDropEggs;
		public final ModConfigSpec.BooleanValue roostersFight;
		public final ModConfigSpec.BooleanValue allowEggThrowing;

		public final ModConfigSpec.ConfigValue<List<? extends String>> cowFood;
		public final ModConfigSpec.ConfigValue<String> cowBed;
		public final ModConfigSpec.ConfigValue<String> cowBed2;
		public final ModConfigSpec.BooleanValue cowsMilkableAtSpawn;

		public final ModConfigSpec.ConfigValue<List<? extends String>> pigFood;
		public final ModConfigSpec.ConfigValue<String> pigBed;
		public final ModConfigSpec.ConfigValue<String> pigBed2;
		public final ModConfigSpec.ConfigValue<String> pigMud;

		public final ModConfigSpec.ConfigValue<List<? extends String>> sheepFood;
		public final ModConfigSpec.ConfigValue<String> sheepBed;
		public final ModConfigSpec.ConfigValue<String> sheepBed2;

		public final ModConfigSpec.ConfigValue<List<? extends String>> goatFood;
		public final ModConfigSpec.ConfigValue<String> goatBed;
		public final ModConfigSpec.ConfigValue<String> goatBed2;

		public final ModConfigSpec.ConfigValue<List<? extends String>> horseFood;
		public final ModConfigSpec.ConfigValue<String> horseBed;
		public final ModConfigSpec.ConfigValue<String> horseBed2;
		public final ModConfigSpec.BooleanValue sleepAllowedWagon;

		public final ModConfigSpec.IntValue cheeseMaturityTime;
		public final ModConfigSpec.BooleanValue disableSaltCreation;
		public final ModConfigSpec.IntValue saltCreationAmount;

		public final ModConfigSpec.ConfigValue<List<? extends String>> hiveValidBiomeTags;
		public final ModConfigSpec.IntValue hivePlayermadeHoneyRate;
		public final ModConfigSpec.IntValue hiveWildHoneyRate;
		public final ModConfigSpec.IntValue hiveStingChance;
		public final ModConfigSpec.BooleanValue hiveSpawning;
		public final ModConfigSpec.IntValue hiveSpawningFrequency;

		public final ModConfigSpec.BooleanValue replaceVanillaCows;
		public final ModConfigSpec.BooleanValue replaceVanillaPigs;
		public final ModConfigSpec.BooleanValue replaceVanillaChickens;
		public final ModConfigSpec.BooleanValue replaceVanillaSheep;
		public final ModConfigSpec.BooleanValue replaceVanillaHorses;
		public final ModConfigSpec.IntValue spawnLimitCows;
		public final ModConfigSpec.IntValue spawnLimitPigs;
		public final ModConfigSpec.IntValue spawnLimitChickens;
		public final ModConfigSpec.IntValue spawnLimitSheep;
		public final ModConfigSpec.IntValue spawnLimitGoats;
		public final ModConfigSpec.IntValue spawnLimitHorses;

		Settings(ModConfigSpec.Builder builder)
		{
			builder.push("chickens");
			this.chickenFood = builder.comment("Items chickens can eat").defineListAllowEmpty("chickenFood",
					List.of("minecraft:wheat_seeds", "minecraft:melon_seeds", "minecraft:pumpkin_seeds", "minecraft:beetroot_seeds", "minecraft:torchflower_seeds", "minecraft:pitcher_pod"),
					o -> o instanceof String);
			this.chickenBed = builder.comment("Block chickens sleep on").define("chickenBed", "animania:block_straw");
			this.chickenBed2 = builder.comment(
					"Alternate block chickens sleep on. Original default was minecraft:grass " +
					"(renamed to minecraft:short_grass in 1.20.3+).")
					.define("chickenBed2", "minecraft:short_grass");
			this.chickensDropEggs = builder.comment("Hens lay eggs").define("chickensDropEggs", true);
			this.roostersFight = builder.comment("Roosters fight each other").define("roostersFight", true);
			this.allowEggThrowing = builder.comment("Allow throwing eggs (vanilla and brown)").define("allowEggThrowing", false);
			builder.pop();

			builder.push("cows");
			this.cowFood = builder.comment("Items cows can eat").defineListAllowEmpty("cowFood",
					List.of("minecraft:wheat", "minecraft:hay_block"),
					o -> o instanceof String);
			this.cowBed = builder.comment("Block cows sleep on").define("cowBed", "animania:block_straw");
			this.cowBed2 = builder.comment("Alternate block cows sleep on").define("cowBed2", "minecraft:dirt");
			this.cowsMilkableAtSpawn = builder.comment("Cows can be milked immediately after spawning").define("cowsMilkableAtSpawn", false);
			builder.pop();

			builder.push("pigs");
			this.pigFood = builder.comment("Items pigs can eat").defineListAllowEmpty("pigFood",
					List.of("minecraft:carrot", "minecraft:beetroot", "minecraft:potato", "minecraft:poisonous_potato", "minecraft:bread"),
					o -> o instanceof String);
			this.pigBed = builder.comment("Block pigs sleep on").define("pigBed", "animania:block_straw");
			this.pigBed2 = builder.comment("Alternate block pigs sleep on").define("pigBed2", "minecraft:dirt");
			this.pigMud = builder.comment("Block pigs play/wallow in").define("pigMud", "animania:block_mud");
			builder.pop();

			builder.push("sheep");
			this.sheepFood = builder.comment("Items sheep can eat (original also included HarvestCraft grains, not available here)").defineListAllowEmpty("sheepFood",
					List.of("minecraft:wheat"),
					o -> o instanceof String);
			this.sheepBed = builder.comment("Block sheep sleep on").define("sheepBed", "animania:block_straw");
			this.sheepBed2 = builder.comment(
					"Alternate block sheep sleep on. Original default was minecraft:grass " +
					"(renamed to minecraft:short_grass in 1.20.3+).")
					.define("sheepBed2", "minecraft:short_grass");
			builder.pop();

			builder.push("goats");
			this.goatFood = builder.comment("Items goats can eat (original also included HarvestCraft/SimpleCorn items, not available here)").defineListAllowEmpty("goatFood",
					List.of("minecraft:wheat", "minecraft:string", "minecraft:stick", "minecraft:apple"),
					o -> o instanceof String);
			this.goatBed = builder.comment("Block goats sleep on").define("goatBed", "animania:block_straw");
			this.goatBed2 = builder.comment(
					"Alternate block goats sleep on. Original default was minecraft:grass " +
					"(renamed to minecraft:short_grass in 1.20.3+).")
					.define("goatBed2", "minecraft:short_grass");
			builder.pop();

			builder.push("horses");
			this.horseFood = builder.comment("Items horses can eat (original also included HarvestCraft grains, not available here)").defineListAllowEmpty("horseFood",
					List.of("minecraft:wheat", "minecraft:apple", "minecraft:carrot"),
					o -> o instanceof String);
			this.horseBed = builder.comment("Block horses sleep on").define("horseBed", "animania:block_straw");
			this.horseBed2 = builder.comment(
					"Alternate block horses sleep on. Original default was minecraft:grass " +
					"(renamed to minecraft:short_grass in 1.20.3+).")
					.define("horseBed2", "minecraft:short_grass");
			builder.pop();

			builder.push("pullables");
			this.sleepAllowedWagon = builder.comment("Whether players can sleep in a wagon (like a bed) to skip the night")
					.define("sleepAllowedWagon", true);
			builder.pop();

			builder.push("cheese");
			this.cheeseMaturityTime = builder.comment("Ticks for milk/water to age into cheese/salt in a cheese mold")
					.defineInRange("cheeseMaturityTime", 24000, 1, Integer.MAX_VALUE);
			this.disableSaltCreation = builder.comment("Disable aging water into salt in a cheese mold")
					.define("disableSaltCreation", false);
			this.saltCreationAmount = builder.comment("Salt produced per batch of aged water")
					.defineInRange("saltCreationAmount", 16, 1, Integer.MAX_VALUE);
			builder.pop();

			builder.push("hive");
			this.hiveValidBiomeTags = builder.comment(
					"Biome tags a hive must be in to slowly produce honey (original used BiomeDictionary types PLAINS/FOREST/JUNGLE/SAVANNA/MESA/SWAMP; " +
					"vanilla 1.21.1 only ships is_forest/is_jungle/is_savanna/is_badlands as biome tags, there is no vanilla plains/swamp tag)")
					.defineListAllowEmpty("hiveValidBiomeTags",
							List.of("minecraft:is_forest", "minecraft:is_jungle", "minecraft:is_savanna", "minecraft:is_badlands"),
							o -> o instanceof String);
			this.hivePlayermadeHoneyRate = builder.comment("Base ticks between honey production ticks for a player-placed hive")
					.defineInRange("hivePlayermadeHoneyRate", 6000, 1, Integer.MAX_VALUE);
			this.hiveWildHoneyRate = builder.comment("Base ticks between honey production ticks for a naturally-generated wild hive")
					.defineInRange("hiveWildHoneyRate", 3000, 1, Integer.MAX_VALUE);
			this.hiveStingChance = builder.comment("1-in-N chance per check for a wild hive to sting a nearby player")
					.defineInRange("hiveStingChance", 3, 1, Integer.MAX_VALUE);
			this.hiveSpawning = builder.comment("Whether wild hives generate naturally near trees").define("hiveSpawning", true);
			this.hiveSpawningFrequency = builder.comment("Roughly out of 200 per tree checked, how often a wild hive spawns (0-10, as in the original)")
					.defineInRange("hiveSpawningFrequency", 3, 0, 10);
			builder.pop();

			 
			 
			 
			 
			 
			 
			builder.push("vanillaReplacement");
			this.replaceVanillaCows = builder.comment("Deny natural spawns of vanilla cows/mooshrooms so Animania breeds take their place")
					.define("replaceVanillaCows", true);
			this.replaceVanillaPigs = builder.comment("Deny natural spawns of vanilla pigs so Animania breeds take their place")
					.define("replaceVanillaPigs", true);
			this.replaceVanillaChickens = builder.comment("Deny natural spawns of vanilla chickens so Animania breeds take their place")
					.define("replaceVanillaChickens", true);
			this.replaceVanillaSheep = builder.comment("Deny natural spawns of vanilla sheep so Animania breeds take their place")
					.define("replaceVanillaSheep", true);
			this.replaceVanillaHorses = builder.comment("Deny natural spawns of vanilla horses so Animania breeds take their place")
					.define("replaceVanillaHorses", true);
			this.spawnLimitCows = builder.comment("Max Animania cows/bulls within range before further natural spawns are denied")
					.defineInRange("spawnLimitCows", 8, 1, Integer.MAX_VALUE);
			this.spawnLimitPigs = builder.comment("Max Animania pigs within range before further natural spawns are denied")
					.defineInRange("spawnLimitPigs", 8, 1, Integer.MAX_VALUE);
			this.spawnLimitChickens = builder.comment("Max Animania chickens within range before further natural spawns are denied")
					.defineInRange("spawnLimitChickens", 8, 1, Integer.MAX_VALUE);
			this.spawnLimitSheep = builder.comment("Max Animania sheep within range before further natural spawns are denied")
					.defineInRange("spawnLimitSheep", 8, 1, Integer.MAX_VALUE);
			this.spawnLimitGoats = builder.comment("Max Animania goats within range before further natural spawns are denied")
					.defineInRange("spawnLimitGoats", 8, 1, Integer.MAX_VALUE);
			this.spawnLimitHorses = builder.comment("Max Animania horses within range before further natural spawns are denied")
					.defineInRange("spawnLimitHorses", 8, 1, Integer.MAX_VALUE);
			builder.pop();
		}
	}

	static
	{
		ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
		settings = new Settings(builder);
		SPEC = builder.build();
	}

	private FarmConfig()
	{
	}
}
