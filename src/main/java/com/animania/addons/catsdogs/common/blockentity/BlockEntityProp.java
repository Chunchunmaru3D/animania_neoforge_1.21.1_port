package com.animania.addons.catsdogs.common.blockentity;

import com.animania.addons.catsdogs.CatsDogsBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

 










public class BlockEntityProp extends BlockEntity
{
	public enum PropType
	{
		CAT_BED_1(64, 32),
		CAT_BED_2(64, 32),
		CAT_TOWER(128, 128),
		DOG_HOUSE(64, 64),
		DOG_PILLOW(128, 128),
		LITTER_BOX(64, 64);

		 





		public final int textureWidth;
		public final int textureHeight;

		PropType(int textureWidth, int textureHeight)
		{
			this.textureWidth = textureWidth;
			this.textureHeight = textureHeight;
		}
	}

	private PropType type;

	public BlockEntityProp(BlockPos pos, BlockState state)
	{
		super(CatsDogsBlocks.PROP_BLOCK_ENTITY.get(), pos, state);
	}

	 
	public PropType getPropType()
	{
		if (this.type == null)
		{
			Block block = this.getBlockState().getBlock();
			this.type = CatsDogsBlocks.propTypeOf(block);
		}
		return this.type;
	}
}
