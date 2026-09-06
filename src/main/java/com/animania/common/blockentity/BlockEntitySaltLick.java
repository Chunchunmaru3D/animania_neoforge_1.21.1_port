package com.animania.common.blockentity;

import javax.annotation.Nullable;

import com.animania.common.blocks.CommonBlockEntities;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

 
public class BlockEntitySaltLick extends BlockEntity
{
	private int usesLeft;

	public BlockEntitySaltLick(BlockPos pos, BlockState state)
	{
		super(CommonBlockEntities.SALT_LICK.get(), pos, state);
		this.usesLeft = AnimaniaConfig.careAndFeeding.saltLickMaxUses.get();
	}

	public int getUsesLeft()
	{
		return this.usesLeft;
	}

	public double getFractionRemaining()
	{
		int max = Math.max(1, AnimaniaConfig.careAndFeeding.saltLickMaxUses.get());
		return Math.max(0.0, Math.min(1.0, (double) this.usesLeft / (double) max));
	}

	 
	public void setUsesLeft(int usesLeft)
	{
		int max = Math.max(1, AnimaniaConfig.careAndFeeding.saltLickMaxUses.get());
		this.usesLeft = Math.max(0, Math.min(max, usesLeft));
		this.setChanged();
		if (this.level != null && !this.level.isClientSide)
			this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
	}

	 



	public boolean consumeUse()
	{
		this.usesLeft--;
		this.setChanged();

		if (this.level != null && !this.level.isClientSide)
			this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);

		return this.usesLeft <= 0;
	}

	@Override
	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.saveAdditional(tag, registries);
		tag.putInt("UsesLeft", this.usesLeft);
	}

	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.loadAdditional(tag, registries);
		this.usesLeft = tag.getInt("UsesLeft");
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries)
	{
		return this.saveWithoutMetadata(registries);
	}

	@Nullable
	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket()
	{
		return ClientboundBlockEntityDataPacket.create(this);
	}
}
