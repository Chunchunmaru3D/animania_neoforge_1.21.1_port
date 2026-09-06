package com.animania.addons.extra.config;

import java.util.List;

import net.neoforged.neoforge.common.ModConfigSpec;

 





public final class ExtraConfig
{
	public static final ModConfigSpec SPEC;
	public static final Settings settings;

	public static class Settings
	{
		public final ModConfigSpec.ConfigValue<List<? extends String>> peacockFood;
		public final ModConfigSpec.ConfigValue<String> peacockBed;
		public final ModConfigSpec.ConfigValue<String> peacockBed2;
		public final ModConfigSpec.BooleanValue spawnAnimaniaPeacocks;
		public final ModConfigSpec.IntValue spawnProbabilityPeacocks;
		public final ModConfigSpec.IntValue spawnLimitPeacocks;

		public final ModConfigSpec.BooleanValue replaceVanillaRabbits;
		public final ModConfigSpec.IntValue spawnLimitRabbits;

		public final ModConfigSpec.ConfigValue<List<? extends String>> ferretFood;
		public final ModConfigSpec.ConfigValue<String> ferretBed;
		public final ModConfigSpec.ConfigValue<String> ferretBed2;

		public final ModConfigSpec.ConfigValue<List<? extends String>> hamsterFood;
		public final ModConfigSpec.ConfigValue<String> hamsterBed;
		public final ModConfigSpec.ConfigValue<String> hamsterBed2;

		public final ModConfigSpec.IntValue hamsterWheelCapacity;
		public final ModConfigSpec.IntValue hamsterWheelRFGeneration;
		public final ModConfigSpec.IntValue hamsterWheelUseTime;

		public final ModConfigSpec.ConfigValue<List<? extends String>> hedgehogFood;
		public final ModConfigSpec.ConfigValue<String> hedgehogBed;
		public final ModConfigSpec.ConfigValue<String> hedgehogBed2;

		public final ModConfigSpec.ConfigValue<List<? extends String>> rabbitFood;
		public final ModConfigSpec.ConfigValue<String> rabbitBed;
		public final ModConfigSpec.ConfigValue<String> rabbitBed2;

		Settings(ModConfigSpec.Builder builder)
		{
			builder.push("peafowl");
			this.peacockFood = builder.comment("Items peafowl can be tempted/bred with")
					.defineListAllowEmpty("peacockFood",
							List.of("minecraft:wheat_seeds", "minecraft:melon_seeds", "minecraft:beetroot_seeds", "minecraft:pumpkin_seeds"),
							o -> o instanceof String);
			this.peacockBed = builder.comment("Block peafowl sleep on").define("peacockBed", "animania:block_straw");
			this.peacockBed2 = builder.comment("Backup block peafowl sleep on").define("peacockBed2", "minecraft:short_grass");
			this.spawnAnimaniaPeacocks = builder.comment("Whether Animania peafowl spawn naturally").define("spawnAnimaniaPeacocks", true);
			this.spawnProbabilityPeacocks = builder.comment("Relative spawn weight for peafowl").defineInRange("spawnProbabilityPeacocks", 8, 0, Integer.MAX_VALUE);
			this.spawnLimitPeacocks = builder.comment("Max peafowl per spawn cluster check").defineInRange("spawnLimitPeacocks", 40, 1, Integer.MAX_VALUE);
			builder.pop();

			builder.push("ferret");
			this.ferretFood = builder.comment("Items ferrets can be tempted/tamed with")
					.defineListAllowEmpty("ferretFood", List.of("minecraft:egg", "minecraft:rabbit"), o -> o instanceof String);
			this.ferretBed = builder.comment("Block ferrets sleep on").define("ferretBed", "animania:block_straw");
			this.ferretBed2 = builder.comment("Backup block ferrets sleep on").define("ferretBed2", "minecraft:short_grass");
			builder.pop();

			builder.push("hamster");
			this.hamsterFood = builder.comment("Items hamsters can be tempted/tamed with")
					.defineListAllowEmpty("hamsterFood", List.of("minecraft:wheat_seeds", "minecraft:melon_seeds", "minecraft:pumpkin_seeds"), o -> o instanceof String);
			this.hamsterBed = builder.comment("Block hamsters sleep on").define("hamsterBed", "animania:block_straw");
			this.hamsterBed2 = builder.comment("Backup block hamsters sleep on").define("hamsterBed2", "minecraft:short_grass");
			this.hamsterWheelCapacity = builder.comment("Hamster wheel: energy storage capacity (FE)").defineInRange("hamsterWheelCapacity", 200000, 0, Integer.MAX_VALUE);
			this.hamsterWheelRFGeneration = builder.comment("Hamster wheel: energy generated per tick while a hamster is running (FE)").defineInRange("hamsterWheelRFGeneration", 20, 0, Integer.MAX_VALUE);
			this.hamsterWheelUseTime = builder.comment("Hamster wheel: ticks between each unit of food consumed").defineInRange("hamsterWheelUseTime", 2000, 1, Integer.MAX_VALUE);
			builder.pop();

			builder.push("hedgehog");
			this.hedgehogFood = builder.comment("Items hedgehogs can be tempted/tamed with")
					.defineListAllowEmpty("hedgehogFood", List.of("minecraft:egg"), o -> o instanceof String);
			this.hedgehogBed = builder.comment("Block hedgehogs sleep on").define("hedgehogBed", "animania:block_straw");
			this.hedgehogBed2 = builder.comment("Backup block hedgehogs sleep on").define("hedgehogBed2", "minecraft:short_grass");
			builder.pop();

			builder.push("rabbit");
			this.rabbitFood = builder.comment("Items rabbits can be tempted/bred with")
					.defineListAllowEmpty("rabbitFood", List.of("minecraft:carrot", "minecraft:golden_carrot", "minecraft:dandelion"), o -> o instanceof String);
			this.rabbitBed = builder.comment("Block rabbits sleep on").define("rabbitBed", "animania:block_straw");
			this.rabbitBed2 = builder.comment("Backup block rabbits sleep on").define("rabbitBed2", "minecraft:short_grass");
			builder.pop();

			 
			 
			 
			builder.push("vanillaReplacement");
			this.replaceVanillaRabbits = builder.comment("Deny natural spawns of vanilla rabbits so Animania breeds take their place")
					.define("replaceVanillaRabbits", true);
			this.spawnLimitRabbits = builder.comment("Max Animania rabbits within range before further natural spawns are denied")
					.defineInRange("spawnLimitRabbits", 8, 1, Integer.MAX_VALUE);
			builder.pop();
		}
	}

	static
	{
		ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
		settings = new Settings(builder);
		SPEC = builder.build();
	}

	private ExtraConfig()
	{
	}
}
