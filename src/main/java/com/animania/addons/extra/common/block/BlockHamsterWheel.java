package com.animania.addons.extra.common.block;

import javax.annotation.Nullable;

import com.animania.addons.extra.ExtraBlocks;
import com.animania.addons.extra.ExtraItems;
import com.animania.addons.extra.common.blockentity.BlockEntityHamsterWheel;
import com.animania.addons.extra.common.entity.rodents.EntityHamster;
import com.animania.addons.extra.common.pocket.PocketAttachments;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

 







public class BlockHamsterWheel extends Block implements EntityBlock
{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public BlockHamsterWheel(BlockBehaviour.Properties properties)
	{
		super(properties);
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
		return new BlockEntityHamsterWheel(pos, state);
	}

	@Override
	@Nullable
	@SuppressWarnings("unchecked")
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type)
	{
		if (level.isClientSide || type != ExtraBlocks.HAMSTER_WHEEL_BLOCK_ENTITY.get())
			return null;
		BlockEntityTicker<BlockEntityHamsterWheel> ticker = (lvl, pos, st, be) -> BlockEntityHamsterWheel.serverTick((ServerLevel) lvl, pos, st, be);
		return (BlockEntityTicker<T>) ticker;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntityHamsterWheel wheel))
			return InteractionResult.PASS;

		if (!wheel.isRunning() && !player.getData(PocketAttachments.POCKET_ANIMAL.get()).isEmpty())
		{
			CompoundTag pocket = player.getData(PocketAttachments.POCKET_ANIMAL.get());

			if (level.isClientSide)
				return InteractionResult.SUCCESS;

			if (level instanceof ServerLevel serverLevel)
			{
				 
				 
				Entity probe = EntityType.loadEntityRecursive(pocket, serverLevel, e -> e);
				if (probe instanceof EntityHamster)
				{
					if (wheel.insertHamster(pocket))
					{
						probe.discard();
						player.setData(PocketAttachments.POCKET_ANIMAL.get(), new CompoundTag());
						player.swing(InteractionHand.MAIN_HAND);
						return InteractionResult.SUCCESS;
					}
				}
				if (probe != null)
					probe.discard();
			}
			return InteractionResult.PASS;
		}

		if (player.isShiftKeyDown())
		{
			if (!level.isClientSide)
			{
				ItemStack food = wheel.getItemHandler().getStackInSlot(0);
				String energyStatus = wheel.getEnergyStorage().getEnergyStored() + "/" + wheel.getEnergyStorage().getMaxEnergyStored() + " FE";
				if (food.isEmpty())
					player.displayClientMessage(Component.literal(energyStatus), true);
				else
					player.displayClientMessage(Component.literal(energyStatus + ", " + food.getCount() + " " + food.getHoverName().getString()), true);
			}
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult hitResult)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntityHamsterWheel wheel))
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

		if (heldItem.is(ExtraItems.HAMSTER_FOOD.get()))
		{
			int before = heldItem.getCount();
			ItemStack remainder = wheel.getItemHandler().insertItem(0, heldItem.copyWithCount(1), false);
			if (remainder.isEmpty() && !player.getAbilities().instabuild)
				heldItem.shrink(1);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston)
	{
		if (state.getBlock() != newState.getBlock() && level.getBlockEntity(pos) instanceof BlockEntityHamsterWheel wheel)
		{
			wheel.ejectHamster();
			ItemStack food = wheel.getItemHandler().getStackInSlot(0);
			if (!food.isEmpty())
				net.minecraft.world.Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), food);
		}
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	protected boolean hasAnalogOutputSignal(BlockState state)
	{
		return true;
	}

	@Override
	protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos)
	{
		return level.getBlockEntity(pos) instanceof BlockEntityHamsterWheel wheel && wheel.isRunning() ? 15 : 0;
	}
}
