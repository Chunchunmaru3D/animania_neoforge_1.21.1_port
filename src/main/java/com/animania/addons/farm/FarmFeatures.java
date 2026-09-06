package com.animania.addons.farm;

import com.animania.Animania;
import com.animania.addons.farm.common.worldgen.WildHiveFeature;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

 



public class FarmFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Animania.MODID);

	public static final DeferredHolder<Feature<?>, WildHiveFeature> WILD_HIVE_FEATURE = FEATURES.register("wild_hive",
			() -> new WildHiveFeature(NoneFeatureConfiguration.CODEC));

	private FarmFeatures()
	{
	}

	public static void register(IEventBus modEventBus)
	{
		FEATURES.register(modEventBus);
	}
}
