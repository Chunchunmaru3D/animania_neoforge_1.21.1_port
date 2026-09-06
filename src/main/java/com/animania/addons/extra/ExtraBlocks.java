package com.animania.addons.extra;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.extra.common.block.BlockHamsterWheel;
import com.animania.addons.extra.common.blockentity.BlockEntityHamsterWheel;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

 



public class ExtraBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Animania.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
			DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Animania.MODID);

	public static final DeferredBlock<BlockHamsterWheel> HAMSTER_WHEEL = BLOCKS.registerBlock("block_hamster_wheel",
			BlockHamsterWheel::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.METAL)
					.sound(SoundType.METAL)
					.strength(1.4F, 3.4F)
					.noOcclusion());

	public static final DeferredItem<BlockItem> HAMSTER_WHEEL_ITEM = ITEMS.registerSimpleBlockItem(HAMSTER_WHEEL);

	public static final Supplier<BlockEntityType<BlockEntityHamsterWheel>> HAMSTER_WHEEL_BLOCK_ENTITY =
			BLOCK_ENTITY_TYPES.register("block_hamster_wheel",
					() -> BlockEntityType.Builder.of(BlockEntityHamsterWheel::new, HAMSTER_WHEEL.get())
							.build(null));

	private ExtraBlocks()
	{
	}

	public static void register(IEventBus modEventBus)
	{
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		BLOCK_ENTITY_TYPES.register(modEventBus);
	}

	 




	public static void registerCapabilities(RegisterCapabilitiesEvent event)
	{
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HAMSTER_WHEEL_BLOCK_ENTITY.get(),
				(be, side) -> be.getItemHandler());

		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, HAMSTER_WHEEL_BLOCK_ENTITY.get(),
				(be, side) -> be.getEnergyStorage());
	}
}
