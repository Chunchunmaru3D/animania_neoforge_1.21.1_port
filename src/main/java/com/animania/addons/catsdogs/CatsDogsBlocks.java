package com.animania.addons.catsdogs;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.catsdogs.common.block.BlockProp;
import com.animania.addons.catsdogs.common.block.BlockPetBowl;
import com.animania.addons.catsdogs.common.blockentity.BlockEntityProp;
import com.animania.addons.catsdogs.common.blockentity.BlockEntityPetBowl;
import com.animania.addons.catsdogs.common.blockentity.BlockEntityProp.PropType;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

 








public class CatsDogsBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Animania.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
			DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Animania.MODID);

	 
	public static final DeferredBlock<BlockProp> CAT_BED_1 = BLOCKS.registerBlock("cat_bed_1",
			p -> new BlockProp(p, Block.box(2, 0, 2, 14, 1, 14)),
			BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(1.0F, 0.8F).noOcclusion());

	 
	public static final DeferredBlock<BlockProp> CAT_BED_2 = BLOCKS.registerBlock("cat_bed_2",
			p -> new BlockProp(p, Block.box(2, 0, 2, 14, 2, 14)),
			BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(1.0F, 0.8F).noOcclusion());

	 
	public static final DeferredBlock<BlockProp> CAT_TOWER = BLOCKS.registerBlock("cat_tower",
			p -> new BlockProp(p, Block.box(0, 0, 0, 16, 24, 16)),
			BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.4F, 0.8F).noOcclusion());

	 
	public static final DeferredBlock<BlockProp> DOG_HOUSE = BLOCKS.registerBlock("dog_house",
			p -> new BlockProp(p, Block.box(0, 0, 0, 16, 16, 16)),
			BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.5F, 1.4F).noOcclusion());

	 
	public static final DeferredBlock<BlockProp> DOG_PILLOW = BLOCKS.registerBlock("dog_pillow",
			p -> new BlockProp(p, Block.box(1, 0, 1, 15, 1, 15)),
			BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(1.0F, 0.8F).noOcclusion());

	 
	public static final DeferredBlock<BlockProp> LITTER_BOX = BLOCKS.registerBlock("litter_box",
			p -> new BlockProp(p, Block.box(1, 0, 1, 15, 3, 15)),
			BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.STONE).strength(1.5F, 0.8F).noOcclusion());

	public static final DeferredBlock<BlockPetBowl> PET_BOWL = BLOCKS.registerBlock("pet_bowl",
			BlockPetBowl::new,
			BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.2F, 1.5F).noOcclusion().dynamicShape());

	public static final DeferredItem<BlockItem> CAT_BED_1_ITEM = ITEMS.registerSimpleBlockItem(CAT_BED_1);
	public static final DeferredItem<BlockItem> CAT_BED_2_ITEM = ITEMS.registerSimpleBlockItem(CAT_BED_2);
	public static final DeferredItem<BlockItem> CAT_TOWER_ITEM = ITEMS.registerSimpleBlockItem(CAT_TOWER);
	public static final DeferredItem<BlockItem> DOG_HOUSE_ITEM = ITEMS.registerSimpleBlockItem(DOG_HOUSE);
	public static final DeferredItem<BlockItem> DOG_PILLOW_ITEM = ITEMS.registerSimpleBlockItem(DOG_PILLOW);
	public static final DeferredItem<BlockItem> LITTER_BOX_ITEM = ITEMS.registerSimpleBlockItem(LITTER_BOX);
	public static final DeferredItem<BlockItem> PET_BOWL_ITEM = ITEMS.registerSimpleBlockItem(PET_BOWL);

	public static final Supplier<BlockEntityType<BlockEntityProp>> PROP_BLOCK_ENTITY =
			BLOCK_ENTITY_TYPES.register("prop",
					() -> BlockEntityType.Builder.of(BlockEntityProp::new,
							CAT_BED_1.get(), CAT_BED_2.get(), CAT_TOWER.get(), DOG_HOUSE.get(), DOG_PILLOW.get(), LITTER_BOX.get())
							.build(null));

	public static final Supplier<BlockEntityType<BlockEntityPetBowl>> PET_BOWL_BLOCK_ENTITY =
			BLOCK_ENTITY_TYPES.register("pet_bowl", () -> BlockEntityType.Builder.of(BlockEntityPetBowl::new, PET_BOWL.get()).build(null));

	private CatsDogsBlocks()
	{
	}

	public static void register(IEventBus modEventBus)
	{
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		BLOCK_ENTITY_TYPES.register(modEventBus);
	}

	 
	public static PropType propTypeOf(Block block)
	{
		if (block == CAT_BED_1.get()) return PropType.CAT_BED_1;
		if (block == CAT_BED_2.get()) return PropType.CAT_BED_2;
		if (block == CAT_TOWER.get()) return PropType.CAT_TOWER;
		if (block == DOG_HOUSE.get()) return PropType.DOG_HOUSE;
		if (block == DOG_PILLOW.get()) return PropType.DOG_PILLOW;
		if (block == LITTER_BOX.get()) return PropType.LITTER_BOX;
		return null;
	}
}
