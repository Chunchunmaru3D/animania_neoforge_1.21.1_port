package com.animania.config;

import net.neoforged.neoforge.common.ModConfigSpec;

 








public final class AnimaniaConfig
{
	public static final ModConfigSpec SPEC;

	public static final CareAndFeeding careAndFeeding;
	public static final GameRules gameRules;

	public static class CareAndFeeding
	{
		public final ModConfigSpec.IntValue feedTimer;
		public final ModConfigSpec.IntValue waterTimer;
		public final ModConfigSpec.IntValue laidTimer;
		public final ModConfigSpec.IntValue featherTimer;
		public final ModConfigSpec.IntValue starvationTimer;
		public final ModConfigSpec.IntValue gestationTimer;
		public final ModConfigSpec.IntValue childGrowthTick;
		public final ModConfigSpec.IntValue playTimer;
		public final ModConfigSpec.IntValue woolRegrowthTimer;
		public final ModConfigSpec.DoubleValue animalLossChance;
		public final ModConfigSpec.DoubleValue birthMultipleChance;
		public final ModConfigSpec.IntValue saltLickTick;
		public final ModConfigSpec.IntValue saltLickMaxUses;
		public final ModConfigSpec.IntValue eggHatchChance;
		public final ModConfigSpec.IntValue entityBreedingLimit;

		CareAndFeeding(ModConfigSpec.Builder builder)
		{
			builder.push("careAndFeeding");
			this.feedTimer = builder.comment("Number of ticks before animals get hungry").defineInRange("feedTimer", 24000, 0, Integer.MAX_VALUE);
			this.waterTimer = builder.comment("Number of ticks before animals get thirsty").defineInRange("waterTimer", 24000, 0, Integer.MAX_VALUE);
			this.laidTimer = builder.comment("Number of ticks between egg laying").defineInRange("laidTimer", 12000, 0, Integer.MAX_VALUE);
			this.featherTimer = builder.comment("Number of ticks between feather drops").defineInRange("featherTimer", 36000, 0, Integer.MAX_VALUE);
			this.starvationTimer = builder.comment("Ticks of starvation before damage is applied").defineInRange("starvationTimer", 23000, 0, Integer.MAX_VALUE);
			this.gestationTimer = builder.comment("Gestation length in ticks").defineInRange("gestationTimer", 28000, 0, Integer.MAX_VALUE);
			this.childGrowthTick = builder.comment("Ticks per child growth step").defineInRange("childGrowthTick", 200, 1, Integer.MAX_VALUE);
			this.playTimer = builder.comment("Ticks before a pig is considered bored again after playing in mud").defineInRange("playTimer", 24000, 0, Integer.MAX_VALUE);
			this.woolRegrowthTimer = builder.comment("Ticks before a sheared sheep/goat regrows wool").defineInRange("woolRegrowthTimer", 8000, 0, Integer.MAX_VALUE);
			this.animalLossChance = builder.comment("Chance to lose baby if mother is starving").defineInRange("animalLossChance", 0.15D, 0D, 1D);
			this.birthMultipleChance = builder.comment("Chance of multiple births").defineInRange("birthMultipleChance", 0.05D, 0D, 1D);
			this.saltLickTick = builder.comment("Minimum ticks between an animal checking for a salt lick").defineInRange("saltLickTick", 8000, 0, Integer.MAX_VALUE);
			this.saltLickMaxUses = builder.comment("Number of times a salt lick can be used before it's depleted").defineInRange("saltLickMaxUses", 200, 1, Integer.MAX_VALUE);
			this.eggHatchChance = builder.comment("1 in N chance per random tick that a nest egg hatches when a rooster is nearby").defineInRange("eggHatchChance", 200, 1, Integer.MAX_VALUE);
			this.entityBreedingLimit = builder.comment("Max nearby chickens before nest eggs stop hatching").defineInRange("entityBreedingLimit", 15, 1, Integer.MAX_VALUE);
			builder.pop();
		}
	}

	public static class GameRules
	{
		public final ModConfigSpec.BooleanValue ambianceMode;
		public final ModConfigSpec.BooleanValue animalsStarve;
		public final ModConfigSpec.BooleanValue animalsSleep;
		public final ModConfigSpec.BooleanValue showUnhappyParticles;
		public final ModConfigSpec.BooleanValue requireAnimalInteractionForAI;
		public final ModConfigSpec.BooleanValue birdsDropFeathers;
		public final ModConfigSpec.BooleanValue animalsCanAttackOthers;
		public final ModConfigSpec.BooleanValue spawnAnimaniaChickens;
		public final ModConfigSpec.BooleanValue replaceVanillaAnimals;
		public final ModConfigSpec.BooleanValue showParts;
		public final ModConfigSpec.ConfigValue<java.util.List<? extends String>> troughFood;
		public final ModConfigSpec.BooleanValue allowTroughAutomation;
		public final ModConfigSpec.BooleanValue foodsGiveBonusEffects;
		public final ModConfigSpec.BooleanValue eatFoodAnytime;

		GameRules(ModConfigSpec.Builder builder)
		{
			builder.push("gameRules");
			this.ambianceMode = builder.comment("Animals never get hungry/thirsty (decorative mode)").define("ambianceMode", false);
			this.animalsStarve = builder.comment("Animals take damage when starving").define("animalsStarve", true);
			this.animalsSleep = builder.comment("Animals sleep at night").define("animalsSleep", true);
			this.showUnhappyParticles = builder.comment("Show smoke particles when animals are unhappy").define("showUnhappyParticles", true);
			this.requireAnimalInteractionForAI = builder.comment("Hunger/thirst only after first interaction").define("requireAnimalInteractionForAI", false);
			this.birdsDropFeathers = builder.comment("Chickens periodically drop feathers").define("birdsDropFeathers", true);
			this.animalsCanAttackOthers = builder.comment("Animals can attack other creatures").define("animalsCanAttackOthers", true);
			this.spawnAnimaniaChickens = builder.comment("Animania chickens spawn naturally").define("spawnAnimaniaChickens", true);
			this.replaceVanillaAnimals = builder.comment("Convert vanilla animals to Animania breeds on spawn").define("replaceVanillaAnimals", false);
			this.showParts = builder.comment("Render animal anatomical parts (bulls, boars, etc.)").define("showParts", true);
			this.troughFood = builder.comment("Items that can be placed in a trough for animals to eat").defineListAllowEmpty("troughFood",
					java.util.List.of("minecraft:wheat", "minecraft:carrot", "minecraft:potato", "minecraft:beetroot", "minecraft:hay_block"),
					o -> o instanceof String);
			this.allowTroughAutomation = builder.comment("Allow hoppers/pipes to insert into and extract from troughs")
					.define("allowTroughAutomation", true);
			this.foodsGiveBonusEffects = builder.comment("Some Animania foods (e.g. cheese) grant a short potion effect when eaten")
					.define("foodsGiveBonusEffects", true);
			this.eatFoodAnytime = builder.comment("Allow the Animania honey bottle to be consumed even when the player is not hungry")
					.define("eatFoodAnytime", true);
			builder.pop();
		}
	}

	static
	{
		ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
		careAndFeeding = new CareAndFeeding(builder);
		gameRules = new GameRules(builder);
		SPEC = builder.build();
	}

	private AnimaniaConfig()
	{
	}
}
