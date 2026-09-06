package com.animania.addons.farm.common.block;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.common.blockentity.BlockEntityHive;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

 











public class BlockHive extends Block implements EntityBlock
{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	private final boolean wild;

	public BlockHive(BlockBehaviour.Properties properties, boolean wild)
	{
		super(properties);
		this.wild = wild;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
	{
		builder.add(FACING);
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context)
	{
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	@Nullable
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlockEntityHive(pos, state);
	}

	@Override
	@Nullable
	@SuppressWarnings("unchecked")
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type)
	{
		if (level.isClientSide || type != FarmBlocks.HIVE_BLOCK_ENTITY.get())
			return null;

		boolean isWild = this.wild;
		BlockEntityTicker<BlockEntityHive> ticker = (lvl, pos, st, be) -> BlockEntityHive.serverTick((ServerLevel) lvl, pos, st, be, isWild);
		return (BlockEntityTicker<T>) ticker;
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult hitResult)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntityHive hive))
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

		if (heldItem.is(Items.GLASS_BOTTLE) && hive.tryExtract())
		{
			if (!player.getAbilities().instabuild)
				replaceHeldContainer(player, hand, heldItem, FarmItems.honeyJarStack());

			level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 0.6F, 0.8F);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		if (heldItem.is(Items.BUCKET) && hive.tryExtract())
		{
			if (!player.getAbilities().instabuild)
				replaceHeldContainer(player, hand, heldItem, new ItemStack(FarmItems.HONEY_BUCKET.get()));

			level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 0.6F, 0.8F);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntityHive hive))
			return InteractionResult.PASS;

		if (!level.isClientSide && player.isShiftKeyDown())
			player.displayClientMessage(Component.literal("Honey stored: " + hive.getHoneyAmount() + "mB"), true);

		return InteractionResult.SUCCESS;
	}

	private static void replaceHeldContainer(Player player, InteractionHand hand, ItemStack heldItem, ItemStack replacement)
	{
		heldItem.shrink(1);
		if (heldItem.isEmpty())
			player.setItemInHand(hand, replacement);
		else if (!player.getInventory().add(replacement))
			player.drop(replacement, false);
	}
}
