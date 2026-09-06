package com.animania.common.blocks;

import com.animania.Animania;
import com.animania.common.blockentity.BlockEntityTrough;
import com.animania.config.AnimaniaConfig;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

 







public class CommonBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Animania.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);

	public static final DeferredBlock<BlockStraw> BLOCK_STRAW = BLOCKS.registerBlock("block_straw",
			BlockStraw::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.SAND)
					.sound(SoundType.CROP)
					.noCollission()
					.noOcclusion()
					.instabreak()
					.pushReaction(PushReaction.DESTROY));

	public static final DeferredItem<BlockItem> BLOCK_STRAW_ITEM =
			ITEMS.registerSimpleBlockItem(BLOCK_STRAW);

	public static final DeferredBlock<BlockMud> BLOCK_MUD = BLOCKS.registerBlock("block_mud",
			BlockMud::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.DIRT)
					.sound(SoundType.SLIME_BLOCK)
					.strength(1.0F, 1.0F)
					.noOcclusion());

	public static final DeferredItem<BlockItem> BLOCK_MUD_ITEM =
			ITEMS.registerSimpleBlockItem(BLOCK_MUD);

	public static final DeferredBlock<BlockTrough> BLOCK_TROUGH = BLOCKS.registerBlock("block_trough",
			BlockTrough::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.WOOD)
					.sound(SoundType.WOOD)
					.strength(2.0F)
					.noOcclusion()
					.randomTicks()
					.pushReaction(PushReaction.BLOCK));

	public static final DeferredItem<BlockItem> BLOCK_TROUGH_ITEM =
			ITEMS.registerSimpleBlockItem(BLOCK_TROUGH);

	public static final DeferredBlock<BlockNest> BLOCK_NEST = BLOCKS.registerBlock("block_nest",
			BlockNest::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.SAND)
					.sound(SoundType.CROP)
					.strength(0.5F)
					.noCollission()
					.noOcclusion()
					.randomTicks());

	public static final DeferredItem<BlockItem> BLOCK_NEST_ITEM =
			ITEMS.registerSimpleBlockItem(BLOCK_NEST);

	public static final DeferredBlock<BlockSaltLick> BLOCK_SALT_LICK = BLOCKS.registerBlock("block_salt_lick",
			BlockSaltLick::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.SNOW)
					.sound(SoundType.STONE)
					.strength(1.2F, 1.7F)
					.noOcclusion()
					.dynamicShape());

	public static final DeferredItem<BlockItem> BLOCK_SALT_LICK_ITEM =
			ITEMS.register("block_salt_lick", () -> new BlockItem(BLOCK_SALT_LICK.get(),
					 
					new Item.Properties().durability(AnimaniaConfig.careAndFeeding.saltLickMaxUses.getDefault())));

	private CommonBlocks()
	{
	}

	 
	public static void register(IEventBus modEventBus)
	{
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
	}

	 





	public static void registerCapabilities(RegisterCapabilitiesEvent event)
	{
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CommonBlockEntities.TROUGH.get(),
				(te, side) -> AnimaniaConfig.gameRules.allowTroughAutomation.get() && te.getFluidTank().isEmpty() ? te.getItemHandler() : null);

		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, CommonBlockEntities.TROUGH.get(),
				(te, side) -> AnimaniaConfig.gameRules.allowTroughAutomation.get() && te.getItemHandler().getStackInSlot(0).isEmpty() ? te.getFluidTank() : null);

		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CommonBlockEntities.NEST.get(),
				(te, side) -> te.getItemHandler());
	}
}
