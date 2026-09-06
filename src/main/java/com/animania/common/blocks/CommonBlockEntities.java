package com.animania.common.blocks;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.common.blockentity.BlockEntityNest;
import com.animania.common.blockentity.BlockEntitySaltLick;
import com.animania.common.blockentity.BlockEntityTrough;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

 


public class CommonBlockEntities
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
			DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Animania.MODID);

	public static final Supplier<BlockEntityType<BlockEntityTrough>> TROUGH = BLOCK_ENTITY_TYPES.register("block_trough",
			() -> BlockEntityType.Builder.of(BlockEntityTrough::new, CommonBlocks.BLOCK_TROUGH.get()).build(null));

	public static final Supplier<BlockEntityType<BlockEntityNest>> NEST = BLOCK_ENTITY_TYPES.register("block_nest",
			() -> BlockEntityType.Builder.of(BlockEntityNest::new, CommonBlocks.BLOCK_NEST.get()).build(null));

	public static final Supplier<BlockEntityType<BlockEntitySaltLick>> SALT_LICK = BLOCK_ENTITY_TYPES.register("block_salt_lick",
			() -> BlockEntityType.Builder.of(BlockEntitySaltLick::new, CommonBlocks.BLOCK_SALT_LICK.get()).build(null));

	private CommonBlockEntities()
	{
	}

	public static void register(IEventBus modEventBus)
	{
		BLOCK_ENTITY_TYPES.register(modEventBus);
	}
}
