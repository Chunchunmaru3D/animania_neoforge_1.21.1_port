package com.animania.addons.catsdogs.config;

import java.util.List;

import net.neoforged.neoforge.common.ModConfigSpec;

 






public final class CatsDogsConfig
{
	public static final ModConfigSpec SPEC;
	public static final Settings settings;

	public static class Settings
	{
		public final ModConfigSpec.ConfigValue<List<? extends String>> catFood;
		public final ModConfigSpec.ConfigValue<String> catBed;
		public final ModConfigSpec.ConfigValue<String> catBed2;
		public final ModConfigSpec.IntValue spawnLimitCats;
		public final ModConfigSpec.IntValue spawnProbabilityCats;
		public final ModConfigSpec.BooleanValue spawnAnimaniaCats;

		public final ModConfigSpec.ConfigValue<List<? extends String>> dogFood;
		public final ModConfigSpec.ConfigValue<String> dogBed;
		public final ModConfigSpec.ConfigValue<String> dogBed2;
		public final ModConfigSpec.ConfigValue<List<? extends String>> petBowlFood;
		public final ModConfigSpec.IntValue spawnLimitDogs;
		public final ModConfigSpec.IntValue spawnProbabilityDogs;
		public final ModConfigSpec.BooleanValue spawnAnimaniaDogs;

		public final ModConfigSpec.BooleanValue replaceVanillaWolves;
		public final ModConfigSpec.BooleanValue replaceVanillaOcelots;

		Settings(ModConfigSpec.Builder builder)
		{
			builder.push("cat");
			this.catFood = builder.comment("Items cats can be tempted/tamed with").defineListAllowEmpty("catFood", List.of("minecraft:cod", "minecraft:salmon"), o -> o instanceof String);
			this.catBed = builder.comment("Block cats sleep on").define("catBed", "animania:block_straw");
			this.catBed2 = builder.comment("Backup block cats sleep on").define("catBed2", "minecraft:short_grass");
			this.spawnLimitCats = builder.comment("Max cats per spawn cluster check").defineInRange("spawnLimitCats", 20, 1, Integer.MAX_VALUE);
			this.spawnProbabilityCats = builder.comment("Relative spawn weight for cats").defineInRange("spawnProbabilityCats", 4, 0, Integer.MAX_VALUE);
			this.spawnAnimaniaCats = builder.comment("Whether Animania cats spawn naturally").define("spawnAnimaniaCats", true);
			builder.pop();

			builder.push("dog");
			this.dogFood = builder.comment("Items dogs can be tempted/tamed with").defineListAllowEmpty("dogFood", List.of("minecraft:beef", "minecraft:porkchop", "minecraft:chicken"), o -> o instanceof String);
			this.dogBed = builder.comment("Block dogs sleep on").define("dogBed", "animania:block_straw");
			this.dogBed2 = builder.comment("Backup block dogs sleep on").define("dogBed2", "minecraft:short_grass");
			this.petBowlFood = builder.comment("Items accepted by the pet bowl")
					.defineListAllowEmpty("petBowlFood", List.of("minecraft:cod", "minecraft:salmon", "minecraft:beef", "animania:hamster_food"), o -> o instanceof String);
			this.spawnLimitDogs = builder.comment("Max dogs per spawn cluster check").defineInRange("spawnLimitDogs", 20, 1, Integer.MAX_VALUE);
			this.spawnProbabilityDogs = builder.comment("Relative spawn weight for dogs").defineInRange("spawnProbabilityDogs", 5, 0, Integer.MAX_VALUE);
			this.spawnAnimaniaDogs = builder.comment("Whether Animania dogs spawn naturally").define("spawnAnimaniaDogs", true);
			builder.pop();

			 
			 
			 
			builder.push("vanillaReplacement");
			this.replaceVanillaWolves = builder.comment("Deny natural spawns of vanilla wolves so the Animania wild female wolf takes their place")
					.define("replaceVanillaWolves", true);
			this.replaceVanillaOcelots = builder.comment("Deny natural spawns of vanilla ocelots so the Animania queen ocelot takes their place")
					.define("replaceVanillaOcelots", true);
			builder.pop();
		}
	}

	static
	{
		ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
		settings = new Settings(builder);
		SPEC = builder.build();
	}

	private CatsDogsConfig()
	{
	}
}
