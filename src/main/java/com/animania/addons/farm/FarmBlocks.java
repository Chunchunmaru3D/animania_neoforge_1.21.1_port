package com.animania.addons.farm;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.common.block.BlockCheese;
import com.animania.addons.farm.common.block.BlockCheeseMold;
import com.animania.addons.farm.common.block.BlockHive;
import com.animania.addons.farm.common.blockentity.BlockEntityCheeseMold;
import com.animania.addons.farm.common.blockentity.BlockEntityHive;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

 





public class FarmBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Animania.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
			DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Animania.MODID);

	 
	 
	 
	private static DeferredBlock<Block> wool(String id, MapColor color)
	{
		return BLOCKS.registerBlock(id, Block::new, BlockBehaviour.Properties.of()
				.mapColor(color).sound(SoundType.WOOL).strength(0.8F));
	}

	public static final DeferredBlock<Block> WOOL_DORSET_NATURAL = wool("wool_dorset_natural", MapColor.COLOR_BROWN);
	public static final DeferredBlock<Block> WOOL_FRIESIAN_1 = wool("wool_friesian_1", MapColor.COLOR_BLACK);
	public static final DeferredBlock<Block> WOOL_FRIESIAN_2 = wool("wool_friesian_2", MapColor.COLOR_BROWN);
	public static final DeferredBlock<Block> WOOL_JACOB = wool("wool_jacob", MapColor.SNOW);
	public static final DeferredBlock<Block> WOOL_MERINO_NATURAL = wool("wool_merino_natural", MapColor.SNOW);
	public static final DeferredBlock<Block> WOOL_MERINO_BROWN = wool("wool_merino_brown", MapColor.COLOR_BROWN);
	public static final DeferredBlock<Block> WOOL_SUFFOLK_NATURAL = wool("wool_suffolk_natural", MapColor.COLOR_BROWN);

	public static final DeferredItem<BlockItem> WOOL_DORSET_NATURAL_ITEM = ITEMS.registerSimpleBlockItem(WOOL_DORSET_NATURAL);
	public static final DeferredItem<BlockItem> WOOL_FRIESIAN_1_ITEM = ITEMS.registerSimpleBlockItem(WOOL_FRIESIAN_1);
	public static final DeferredItem<BlockItem> WOOL_FRIESIAN_2_ITEM = ITEMS.registerSimpleBlockItem(WOOL_FRIESIAN_2);
	public static final DeferredItem<BlockItem> WOOL_JACOB_ITEM = ITEMS.registerSimpleBlockItem(WOOL_JACOB);
	public static final DeferredItem<BlockItem> WOOL_MERINO_NATURAL_ITEM = ITEMS.registerSimpleBlockItem(WOOL_MERINO_NATURAL);
	public static final DeferredItem<BlockItem> WOOL_MERINO_BROWN_ITEM = ITEMS.registerSimpleBlockItem(WOOL_MERINO_BROWN);
	public static final DeferredItem<BlockItem> WOOL_SUFFOLK_NATURAL_ITEM = ITEMS.registerSimpleBlockItem(WOOL_SUFFOLK_NATURAL);

	public static final DeferredBlock<BlockCheeseMold> CHEESE_MOLD = BLOCKS.registerBlock("cheese_mold",
			BlockCheeseMold::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.WOOD)
					.sound(SoundType.WOOD)
					.strength(0.9F, 1.2F)
					.noOcclusion());

	public static final DeferredItem<BlockItem> CHEESE_MOLD_ITEM =
			ITEMS.registerSimpleBlockItem(CHEESE_MOLD);

	public static final Supplier<BlockEntityType<BlockEntityCheeseMold>> CHEESE_MOLD_BLOCK_ENTITY =
			BLOCK_ENTITY_TYPES.register("cheese_mold",
					() -> BlockEntityType.Builder.of(BlockEntityCheeseMold::new, CHEESE_MOLD.get()).build(null));

	 

	private static BlockBehaviour.Properties cheeseProperties()
	{
		return BlockBehaviour.Properties.of()
				.mapColor(MapColor.COLOR_YELLOW)
				.sound(SoundType.WOOL)
				.strength(0.6F)
				.noOcclusion()
				 
				 
				 
				.pushReaction(PushReaction.DESTROY);
	}

	public static final DeferredBlock<BlockCheese> CHEESE_WHEEL_FRIESIAN = BLOCKS.registerBlock("cheese_friesian",
			properties -> new BlockCheese(properties, BlockCheese.CheeseKind.FRIESIAN), cheeseProperties());
	public static final DeferredBlock<BlockCheese> CHEESE_WHEEL_HOLSTEIN = BLOCKS.registerBlock("cheese_holstein",
			properties -> new BlockCheese(properties, BlockCheese.CheeseKind.HOLSTEIN), cheeseProperties());
	public static final DeferredBlock<BlockCheese> CHEESE_WHEEL_JERSEY = BLOCKS.registerBlock("cheese_jersey",
			properties -> new BlockCheese(properties, BlockCheese.CheeseKind.JERSEY), cheeseProperties());
	public static final DeferredBlock<BlockCheese> CHEESE_WHEEL_SHEEP = BLOCKS.registerBlock("cheese_sheep",
			properties -> new BlockCheese(properties, BlockCheese.CheeseKind.SHEEP), cheeseProperties());
	public static final DeferredBlock<BlockCheese> CHEESE_WHEEL_GOAT = BLOCKS.registerBlock("cheese_goat",
			properties -> new BlockCheese(properties, BlockCheese.CheeseKind.GOAT), cheeseProperties());

	public static final DeferredItem<BlockItem> CHEESE_WHEEL_FRIESIAN_ITEM = ITEMS.registerSimpleBlockItem(CHEESE_WHEEL_FRIESIAN);
	public static final DeferredItem<BlockItem> CHEESE_WHEEL_HOLSTEIN_ITEM = ITEMS.registerSimpleBlockItem(CHEESE_WHEEL_HOLSTEIN);
	public static final DeferredItem<BlockItem> CHEESE_WHEEL_JERSEY_ITEM = ITEMS.registerSimpleBlockItem(CHEESE_WHEEL_JERSEY);
	public static final DeferredItem<BlockItem> CHEESE_WHEEL_SHEEP_ITEM = ITEMS.registerSimpleBlockItem(CHEESE_WHEEL_SHEEP);
	public static final DeferredItem<BlockItem> CHEESE_WHEEL_GOAT_ITEM = ITEMS.registerSimpleBlockItem(CHEESE_WHEEL_GOAT);

	 

	public static final DeferredBlock<BlockHive> HIVE = BLOCKS.registerBlock("block_hive",
			properties -> new BlockHive(properties, false),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_YELLOW)
					.sound(SoundType.WOOD)
					.strength(1.3F, 0.3F)
					.noOcclusion());

	public static final DeferredBlock<BlockHive> WILD_HIVE = BLOCKS.registerBlock("block_wild_hive",
			properties -> new BlockHive(properties, true),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_YELLOW)
					.sound(SoundType.CROP)
					.strength(1.3F, 0.3F)
					.noOcclusion());

	public static final DeferredItem<BlockItem> HIVE_ITEM = ITEMS.registerSimpleBlockItem(HIVE);
	public static final DeferredItem<BlockItem> WILD_HIVE_ITEM = ITEMS.registerSimpleBlockItem(WILD_HIVE);

	public static final Supplier<BlockEntityType<BlockEntityHive>> HIVE_BLOCK_ENTITY =
			BLOCK_ENTITY_TYPES.register("block_hive",
					() -> BlockEntityType.Builder.of(BlockEntityHive::new, HIVE.get(), WILD_HIVE.get())
							.build(null));

	private FarmBlocks()
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
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHEESE_MOLD_BLOCK_ENTITY.get(),
				(be, side) -> be.getItemHandler());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, CHEESE_MOLD_BLOCK_ENTITY.get(),
				(be, side) -> be.getContent().isFinished() ? null : be.getFluidTank());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, HIVE_BLOCK_ENTITY.get(),
				(be, side) -> be.getFluidTank());
	}
}
