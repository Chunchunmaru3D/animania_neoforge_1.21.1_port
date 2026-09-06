package com.animania;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.animania.addons.catsdogs.CatsDogsEntityTypes;
import com.animania.addons.catsdogs.CatsDogsItems;
import com.animania.addons.catsdogs.config.CatsDogsConfig;
import com.animania.addons.extra.ExtraEntityTypes;
import com.animania.addons.extra.ExtraItems;
import com.animania.addons.extra.common.pocket.PocketAttachments;
import com.animania.addons.extra.config.ExtraConfig;
import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.FarmEntityTypes;
import com.animania.addons.farm.FarmFeatures;
import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.FarmSounds;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.common.blocks.CommonBlockEntities;
import com.animania.common.blocks.CommonBlocks;
import com.animania.common.fluids.CommonFluids;
import com.animania.common.loottables.AnimaniaLootTables;
import com.animania.common.recipes.CommonRecipeSerializers;
import com.animania.config.AnimaniaConfig;

import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

 










@Mod(Animania.MODID)
public class Animania
{
	public static final String MODID = "animania";
	public static final String NAME = "Animania";
	public static final Logger LOGGER = LogManager.getFormatterLogger(NAME);
	public static final Random RANDOM = new Random();

	public Animania(IEventBus modEventBus, ModContainer modContainer)
	{
		 
		FarmSounds.SOUNDS.register(modEventBus);
		CommonFluids.register(modEventBus);
		CommonRecipeSerializers.register(modEventBus);
		AnimaniaLootTables.CONDITION_TYPES.register(modEventBus);
		AnimaniaLootTables.FUNCTION_TYPES.register(modEventBus);
		FarmEntityTypes.ENTITY_TYPES.register(modEventBus);
		FarmItems.ITEMS.register(modEventBus);
		FarmItems.CREATIVE_TABS.register(modEventBus);
		modEventBus.addListener(FarmItems::registerCapabilities);
		CommonBlocks.register(modEventBus);
		CommonBlockEntities.register(modEventBus);
		FarmBlocks.register(modEventBus);
		modEventBus.addListener(FarmBlocks::registerCapabilities);
		FarmFeatures.register(modEventBus);
		modEventBus.addListener(CommonBlocks::registerCapabilities);
		com.animania.addons.farm.common.entity.chickens.FarmNestHatching.register();
		com.animania.addons.extra.common.entity.peafowl.ExtraNestHatching.register();

		ExtraEntityTypes.ENTITY_TYPES.register(modEventBus);
		ExtraItems.register(modEventBus);
		com.animania.addons.extra.ExtraBlocks.register(modEventBus);
		modEventBus.addListener(com.animania.addons.extra.ExtraBlocks::registerCapabilities);
		CatsDogsEntityTypes.ENTITY_TYPES.register(modEventBus);
		CatsDogsItems.register(modEventBus);
		com.animania.addons.catsdogs.CatsDogsBlocks.register(modEventBus);
		PocketAttachments.ATTACHMENT_TYPES.register(modEventBus);

		 
		modEventBus.addListener(FarmEntityTypes::registerAttributes);
		modEventBus.addListener(FarmEntityTypes::registerSpawnPlacements);
		modEventBus.addListener(ExtraEntityTypes::registerAttributes);
		modEventBus.addListener(ExtraEntityTypes::registerSpawnPlacements);
		modEventBus.addListener(CatsDogsEntityTypes::registerAttributes);
		modEventBus.addListener(CatsDogsEntityTypes::registerSpawnPlacements);

		 
		modContainer.registerConfig(ModConfig.Type.COMMON, AnimaniaConfig.SPEC, "animania-common.toml");
		modContainer.registerConfig(ModConfig.Type.COMMON, FarmConfig.SPEC, "animania-farm.toml");
		modContainer.registerConfig(ModConfig.Type.COMMON, ExtraConfig.SPEC, "animania-extra.toml");
		modContainer.registerConfig(ModConfig.Type.COMMON, CatsDogsConfig.SPEC, "animania-catsdogs.toml");

		modEventBus.addListener(Animania::commonSetup);
	}

	 







	private static void commonSetup(FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			FireBlock fire = (FireBlock) Blocks.FIRE;
			fire.setFlammable(CommonBlocks.BLOCK_STRAW.get(), 60, 20);
		});
	}
}
