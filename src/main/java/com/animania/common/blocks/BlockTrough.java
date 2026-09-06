package com.animania.common.blocks;

import java.util.Locale;

import javax.annotation.Nullable;

import com.animania.api.interfaces.IFoodProviderBlock;
import com.animania.common.blockentity.BlockEntityTrough;
import com.animania.common.fluids.CommonFluids;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.items.ItemHandlerHelper;

 






















public class BlockTrough extends Block implements EntityBlock, IFoodProviderBlock
{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<TroughPart> PART = EnumProperty.create("part", TroughPart.class);

	 
	public static final int CAPACITY_MB = BlockEntityTrough.CAPACITY_MB;

	private static final VoxelShape SHAPE_ALONG_X = Block.box(0.0, 0.0, 4.0, 16.0, 4.8, 12.0);
	private static final VoxelShape SHAPE_ALONG_Z = Block.box(4.0, 0.0, 0.0, 12.0, 4.8, 16.0);

	public BlockTrough(BlockBehaviour.Properties properties)
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(FACING, Direction.NORTH)
				.setValue(PART, TroughPart.MAIN));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
	{
		builder.add(FACING, PART);
	}

	 

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return state.getValue(FACING).getAxis() == Direction.Axis.Z ? SHAPE_ALONG_X : SHAPE_ALONG_Z;
	}

	 

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context)
	{
		Direction facing = context.getHorizontalDirection().getOpposite();
		BlockPos extensionPos = context.getClickedPos().relative(facing.getClockWise());
		Level level = context.getLevel();

		if (!level.getBlockState(extensionPos).canBeReplaced(context))
			return null;

		return this.defaultBlockState().setValue(FACING, facing).setValue(PART, TroughPart.MAIN);
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
	{
		BlockPos extensionPos = pos.relative(state.getValue(FACING).getClockWise());
		level.setBlock(extensionPos, state.setValue(PART, TroughPart.EXTENSION), 3);
	}

	private static BlockPos getConnectedPos(BlockState state, BlockPos pos)
	{
		Direction offset = state.getValue(PART) == TroughPart.MAIN
				? state.getValue(FACING).getClockWise()
				: state.getValue(FACING).getCounterClockWise();
		return pos.relative(offset);
	}

	public static BlockPos getMainPos(BlockState state, BlockPos pos)
	{
		return state.getValue(PART) == TroughPart.MAIN ? pos : getConnectedPos(state, pos);
	}

	@Override
	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
	{
		if (state.getValue(PART) == TroughPart.EXTENSION)
		{
			BlockPos mainPos = getConnectedPos(state, pos);
			BlockState mainState = level.getBlockState(mainPos);
			return mainState.is(this) && mainState.getValue(PART) == TroughPart.MAIN;
		}

		BlockPos below = pos.below();
		return level.getBlockState(below).isFaceSturdy(level, below, Direction.UP);
	}

	@Override
	protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos)
	{
		if (direction == Direction.DOWN && !this.canSurvive(state, level, pos))
			return Blocks.AIR.defaultBlockState();

		return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston)
	{
		if (state.getBlock() != newState.getBlock())
		{
			if (state.getValue(PART) == TroughPart.MAIN && level.getBlockEntity(pos) instanceof BlockEntityTrough te)
			{
				ItemStack stack = te.getItemHandler().getStackInSlot(0);
				if (!stack.isEmpty())
					net.minecraft.world.Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), stack);
			}

			BlockPos connected = getConnectedPos(state, pos);
			BlockState connectedState = level.getBlockState(connected);
			if (connectedState.is(this) && connectedState.getValue(PART) != state.getValue(PART))
				level.removeBlock(connected, movedByPiston);
		}

		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	 

	@Override
	@Nullable
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return state.getValue(PART) == TroughPart.MAIN ? new BlockEntityTrough(pos, state) : null;
	}

	 

	@Override
	protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, net.minecraft.world.entity.player.Player player,
			InteractionHand hand, BlockHitResult hitResult)
	{
		BlockPos mainPos = getMainPos(state, pos);
		if (!(level.getBlockEntity(mainPos) instanceof BlockEntityTrough te))
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

		 
		if (!heldItem.isEmpty() && isTroughFood(heldItem) && te.getFluidTank().isEmpty())
		{
			ItemStack existing = te.getItemHandler().getStackInSlot(0);
			if (existing.isEmpty() || existing.getCount() < BlockEntityTrough.FOOD_SLOT_LIMIT)
			{
				ItemStack remainder = te.getItemHandler().insertItem(0, heldItem.copyWithCount(1), false);
				if (remainder.isEmpty() && !player.getAbilities().instabuild)
					heldItem.shrink(1);

				level.updateNeighborsAt(mainPos, this);
				return ItemInteractionResult.sidedSuccess(level.isClientSide);
			}
		}

		 
		Fluid bucketFluid = getBucketFluid(heldItem);
		if (bucketFluid != null && te.getItemHandler().getStackInSlot(0).isEmpty()
				&& (te.getFluidTank().isEmpty()
						|| (isSameTroughFluid(te.getFluidTank().getFluid().getFluid(), bucketFluid)
								&& te.getFluidTank().getFluidAmount() < CAPACITY_MB)))
		{
			int missing = CAPACITY_MB - te.getFluidTank().getFluidAmount();
			te.getFluidTank().fill(new FluidStack(bucketFluid, missing), FluidAction.EXECUTE);
			level.playSound(null, pos, bucketFluid == Fluids.WATER ? SoundEvents.BUCKET_EMPTY : SoundEvents.SLIME_BLOCK_PLACE,
					SoundSource.BLOCKS, 0.6F, 0.8F);

			if (!player.getAbilities().instabuild)
				replaceHeldContainer(player, hand, heldItem, new ItemStack(Items.BUCKET));

			level.updateNeighborsAt(mainPos, this);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		 
		Fluid containedFluid = te.getFluidTank().getFluid().getFluid();
		ItemStack filledBucket = getFilledBucket(containedFluid);
		if (heldItem.is(Items.BUCKET) && !filledBucket.isEmpty() && te.getFluidTank().getFluidAmount() >= 1000)
		{
			te.getFluidTank().drain(1000, FluidAction.EXECUTE);
			level.playSound(null, pos, containedFluid == Fluids.WATER ? SoundEvents.BUCKET_FILL : SoundEvents.SLIME_BLOCK_FALL,
					SoundSource.BLOCKS, 0.6F, 0.8F);

			if (!player.getAbilities().instabuild)
				replaceHeldContainer(player, hand, heldItem, filledBucket);

			level.updateNeighborsAt(mainPos, this);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, net.minecraft.world.entity.player.Player player, BlockHitResult hitResult)
	{
		BlockPos mainPos = getMainPos(state, pos);
		if (!(level.getBlockEntity(mainPos) instanceof BlockEntityTrough te))
			return InteractionResult.PASS;

		ItemStack existing = te.getItemHandler().getStackInSlot(0);
		if (!existing.isEmpty())
		{
			ItemStack extracted = te.getItemHandler().extractItem(0, 1, false);
			AnimaniaHelper.addItem(player, extracted);
			level.updateNeighborsAt(mainPos, this);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}

	private static void replaceHeldContainer(net.minecraft.world.entity.player.Player player, InteractionHand hand, ItemStack heldItem, ItemStack replacement)
	{
		heldItem.shrink(1);
		if (heldItem.isEmpty())
			player.setItemInHand(hand, replacement);
		else if (!player.getInventory().add(replacement))
			player.drop(replacement, false);
	}

	@Nullable
	private static Fluid getBucketFluid(ItemStack stack)
	{
		if (stack.is(Items.WATER_BUCKET))
			return Fluids.WATER;
		if (stack.is(CommonFluids.SLOP_BUCKET.get()))
			return CommonFluids.SLOP_SOURCE.get();
		return null;
	}

	private static boolean isSameTroughFluid(Fluid first, Fluid second)
	{
		if (first == second)
			return true;
		return (first == CommonFluids.SLOP_SOURCE.get() || first == CommonFluids.SLOP_FLOWING.get())
				&& (second == CommonFluids.SLOP_SOURCE.get() || second == CommonFluids.SLOP_FLOWING.get());
	}

	private static ItemStack getFilledBucket(Fluid fluid)
	{
		if (fluid == Fluids.WATER)
			return new ItemStack(Items.WATER_BUCKET);
		if (fluid == CommonFluids.SLOP_SOURCE.get() || fluid == CommonFluids.SLOP_FLOWING.get())
			return new ItemStack(CommonFluids.SLOP_BUCKET.get());
		return ItemStack.EMPTY;
	}

	 

	@Override
	protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
	{
		if (state.getValue(PART) != TroughPart.MAIN || !level.isRaining())
			return;

		if (!(level.getBlockEntity(pos) instanceof BlockEntityTrough te))
			return;

		if (!te.getItemHandler().getStackInSlot(0).isEmpty())
			return;

		if (!level.canSeeSky(pos.above()))
			return;

		if (level.getBiome(pos).value().getBaseTemperature() < 0.15F)
			return;

		boolean canFillWater = te.getFluidTank().isEmpty()
				|| (te.getFluidTank().getFluid().getFluid() == Fluids.WATER && te.getFluidTank().getFluidAmount() < CAPACITY_MB);
		if (canFillWater)
			te.getFluidTank().fill(new FluidStack(Fluids.WATER, Math.min(100, CAPACITY_MB - te.getFluidTank().getFluidAmount())), FluidAction.EXECUTE);
	}

	 

	@Override
	protected boolean hasAnalogOutputSignal(BlockState state)
	{
		return true;
	}

	@Override
	protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos)
	{
		BlockPos mainPos = getMainPos(state, pos);
		if (!(level.getBlockEntity(mainPos) instanceof BlockEntityTrough te))
			return 0;

		ItemStack stack = te.getItemHandler().getStackInSlot(0);
		if (!stack.isEmpty())
			return ItemHandlerHelper.calcRedstoneFromInventory(te.getItemHandler());

		if (!te.getFluidTank().isEmpty())
			return te.getFluidTank().getFluidAmount() * 15 / te.getFluidTank().getCapacity();

		return 0;
	}

	 

	public static boolean isTroughFood(ItemStack stack)
	{
		if (stack.isEmpty())
			return false;

		ItemStack[] configured = AnimaniaHelper.getItemStackArray(AnimaniaConfig.gameRules.troughFood.get());
		for (ItemStack candidate : configured)
		{
			if (candidate.is(stack.getItem()))
				return true;
		}

		return false;
	}

	public enum TroughPart implements StringRepresentable
	{
		MAIN, EXTENSION;

		@Override
		public String getSerializedName()
		{
			return this.name().toLowerCase(Locale.ROOT);
		}
	}
}
