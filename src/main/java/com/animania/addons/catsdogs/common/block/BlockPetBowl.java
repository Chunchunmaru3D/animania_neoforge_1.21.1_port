package com.animania.addons.catsdogs.common.block;

import javax.annotation.Nullable;

import com.animania.addons.catsdogs.common.blockentity.BlockEntityPetBowl;
import com.animania.addons.catsdogs.config.CatsDogsConfig;
import com.animania.api.interfaces.IFoodProviderBlock;
import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

 
public class BlockPetBowl extends Block implements EntityBlock, IFoodProviderBlock
{
	private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 4, 12);

	public BlockPetBowl(BlockBehaviour.Properties properties)
	{
		super(properties);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return SHAPE;
	}

	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return SHAPE;
	}

	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity)
	{
		if (level.isClientSide || !(entity instanceof ItemEntity itemEntity)
				|| !(level.getBlockEntity(pos) instanceof BlockEntityPetBowl bowl))
			return;

		ItemStack stack = itemEntity.getItem();
		if (isFoodItem(stack) && bowl.getFluidTank().isEmpty())
		{
			ItemStack remainder = bowl.getItemHandler().insertItem(0, stack.copyWithCount(1), false);
			if (remainder.isEmpty())
				stack.shrink(1);
		}
		else if (stack.is(Items.WATER_BUCKET) && bowl.getItemHandler().getStackInSlot(0).isEmpty() && bowl.getFluidTank().isEmpty())
		{
			bowl.getFluidTank().fill(new net.neoforged.neoforge.fluids.FluidStack(Fluids.WATER, BlockEntityPetBowl.CAPACITY_MB),
					net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE);
			itemEntity.setItem(new ItemStack(Items.BUCKET));
			level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 0.6F, 0.8F);
		}
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult hitResult)
	{
		if (!(level.getBlockEntity(pos) instanceof BlockEntityPetBowl bowl))
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

		if (isFoodItem(heldItem) && bowl.getFluidTank().isEmpty())
		{
			ItemStack remainder = bowl.getItemHandler().insertItem(0, heldItem.copyWithCount(1), false);
			if (remainder.isEmpty())
			{
				if (!player.getAbilities().instabuild)
					heldItem.shrink(1);
				return ItemInteractionResult.sidedSuccess(level.isClientSide);
			}
		}

		if (heldItem.is(Items.WATER_BUCKET) && bowl.getItemHandler().getStackInSlot(0).isEmpty() && bowl.getFluidTank().isEmpty())
		{
			bowl.getFluidTank().fill(new net.neoforged.neoforge.fluids.FluidStack(Fluids.WATER, BlockEntityPetBowl.CAPACITY_MB),
					net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE);
			if (!player.getAbilities().instabuild)
				replaceHeldContainer(player, hand, heldItem, new ItemStack(Items.BUCKET));
			level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.PLAYERS, 0.6F, 0.8F);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		if (heldItem.is(Items.BUCKET) && bowl.getFluidTank().getFluidAmount() >= BlockEntityPetBowl.CAPACITY_MB)
		{
			bowl.getFluidTank().drain(BlockEntityPetBowl.CAPACITY_MB, net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE);
			if (!player.getAbilities().instabuild)
				replaceHeldContainer(player, hand, heldItem, new ItemStack(Items.WATER_BUCKET));
			level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.PLAYERS, 0.6F, 0.8F);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
	{
		if (level.getBlockEntity(pos) instanceof BlockEntityPetBowl bowl && !bowl.getItemHandler().getStackInSlot(0).isEmpty())
		{
			AnimaniaHelper.addItem(player, bowl.getItemHandler().extractItem(0, 1, false));
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston)
	{
		if (state.getBlock() != newState.getBlock() && level.getBlockEntity(pos) instanceof BlockEntityPetBowl bowl)
			Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), bowl.getItemHandler().getStackInSlot(0));
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
		if (!(level.getBlockEntity(pos) instanceof BlockEntityPetBowl bowl))
			return 0;
		if (!bowl.getItemHandler().getStackInSlot(0).isEmpty())
			return net.neoforged.neoforge.items.ItemHandlerHelper.calcRedstoneFromInventory(bowl.getItemHandler());
		return bowl.getFluidTank().getFluidAmount() * 15 / BlockEntityPetBowl.CAPACITY_MB;
	}

	@Override
	@Nullable
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlockEntityPetBowl(pos, state);
	}

	public static boolean isFoodItem(ItemStack stack)
	{
		if (stack.isEmpty())
			return false;
		for (ItemStack configured : AnimaniaHelper.getItemStackArray(CatsDogsConfig.settings.petBowlFood.get()))
			if (configured.is(stack.getItem()))
				return true;
		return false;
	}

	private static void replaceHeldContainer(Player player, InteractionHand hand, ItemStack held, ItemStack replacement)
	{
		held.shrink(1);
		if (held.isEmpty())
			player.setItemInHand(hand, replacement);
		else
			AnimaniaHelper.addItem(player, replacement);
	}
}
