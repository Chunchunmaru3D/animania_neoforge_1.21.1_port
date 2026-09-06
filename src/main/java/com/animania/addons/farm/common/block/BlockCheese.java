package com.animania.addons.farm.common.block;

import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

 

















public class BlockCheese extends Block
{
	public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 3);

	 
	private static final VoxelShape[] SHAPE_BY_BITES = new VoxelShape[] {
			Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0),
			Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0),
			Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 8.0),
			Block.box(1.0, 0.0, 1.0, 8.0, 8.0, 8.0)
	};

	public enum CheeseKind
	{
		FRIESIAN, HOLSTEIN, JERSEY, SHEEP, GOAT
	}

	private final CheeseKind kind;

	public BlockCheese(BlockBehaviour.Properties properties, CheeseKind kind)
	{
		super(properties);
		this.kind = kind;
		this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
	{
		builder.add(BITES);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
	{
		return SHAPE_BY_BITES[state.getValue(BITES)];
	}

	@Override
	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
	{
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
	protected boolean hasAnalogOutputSignal(BlockState state)
	{
		return true;
	}

	@Override
	protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos)
	{
		return 4 - state.getValue(BITES);
	}

	 






	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
	{
		if (!player.canEat(false))
			return InteractionResult.PASS;

		if (!level.isClientSide)
		{
			if (AnimaniaConfig.gameRules.foodsGiveBonusEffects.get())
				player.addEffect(this.bonusEffect());

			player.getFoodData().eat(2, 1.2F);

			int bites = state.getValue(BITES);
			if (bites < 3)
				level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
			else
				level.removeBlock(pos, false);
		}

		return InteractionResult.SUCCESS;
	}

	private MobEffectInstance bonusEffect()
	{
		return switch (this.kind)
		{
			case GOAT -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0, false, false);
			case SHEEP -> new MobEffectInstance(MobEffects.HEAL, 10, 0, false, false);
			case FRIESIAN, HOLSTEIN, JERSEY -> new MobEffectInstance(MobEffects.HEAL, 1, 1, false, false);
		};
	}
}
