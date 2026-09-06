package com.animania.addons.farm.common.blockentity;

import java.util.List;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.config.FarmConfig;
import com.animania.common.fluids.CommonFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

 















public class BlockEntityHive extends BlockEntity
{
	public static final int CAPACITY_MB = 5000;
	private static final int EXTRACTION_AMOUNT = 1000;

	private int nextHoney = 400;
	private final FluidTank fluidTank = new FluidTank(CAPACITY_MB)
	{
		@Override
		protected void onContentsChanged()
		{
			BlockEntityHive.this.setChangedAndSync();
		}

		@Override
		public boolean isFluidValid(FluidStack stack)
		{
			return stack.getFluid() == CommonFluids.HONEY_SOURCE.get()
					|| stack.getFluid() == CommonFluids.HONEY_FLOWING.get();
		}
	};

	public BlockEntityHive(BlockPos pos, BlockState state)
	{
		super(FarmBlocks.HIVE_BLOCK_ENTITY.get(), pos, state);
	}

	public int getHoneyAmount()
	{
		return this.fluidTank.getFluidAmount();
	}

	 
	public FluidTank getFluidTank()
	{
		return this.fluidTank;
	}

	public boolean tryExtract()
	{
		if (this.fluidTank.getFluidAmount() < EXTRACTION_AMOUNT)
			return false;

		return this.fluidTank.drain(EXTRACTION_AMOUNT, FluidAction.EXECUTE).getAmount() == EXTRACTION_AMOUNT;
	}

	private void setChangedAndSync()
	{
		this.setChanged();
		if (this.level != null && !this.level.isClientSide)
			this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
	}

	public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, BlockEntityHive hive, boolean wild)
	{
		hive.nextHoney--;
		if (hive.nextHoney < 1)
		{
			if (isValidBiome(level, pos))
			{
				int room = CAPACITY_MB - hive.fluidTank.getFluidAmount();
				int fillAmount = Math.min(25, room);
				if (fillAmount > 0)
					hive.fluidTank.fill(new FluidStack(CommonFluids.HONEY_SOURCE.get(), fillAmount), FluidAction.EXECUTE);
			}

			int base = wild ? FarmConfig.settings.hiveWildHoneyRate.get() : FarmConfig.settings.hivePlayermadeHoneyRate.get();
			hive.nextHoney = base + level.getRandom().nextInt(100);
		}

		if (wild && level.getRandom().nextInt(10) == 0)
		{
			RandomSource random = level.getRandom();
			List<Player> nearby = level.getEntitiesOfClass(Player.class, new AABB(pos).inflate(2.0));
			for (Player player : nearby)
			{
				if (random.nextInt(FarmConfig.settings.hiveStingChance.get()) == 0)
				{
					DamageSource sting = level.damageSources().generic();
					player.hurt(sting, 2.5F);
				}
			}
		}
	}

	private static boolean isValidBiome(ServerLevel level, BlockPos pos)
	{
		for (String id : FarmConfig.settings.hiveValidBiomeTags.get())
		{
			ResourceLocation location = ResourceLocation.tryParse(id);
			if (location == null)
				continue;

			TagKey<Biome> tag = TagKey.create(Registries.BIOME, location);
			if (level.getBiome(pos).is(tag))
				return true;
		}
		return false;
	}

	@Override
	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.saveAdditional(tag, registries);
		tag.put("Fluid", this.fluidTank.writeToNBT(registries, new CompoundTag()));
		tag.putInt("NextHoney", this.nextHoney);
	}

	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
	{
		super.loadAdditional(tag, registries);
		if (tag.contains("Fluid"))
			this.fluidTank.readFromNBT(registries, tag.getCompound("Fluid"));
		else if (tag.contains("Honey"))
			this.fluidTank.setFluid(new FluidStack(CommonFluids.HONEY_SOURCE.get(), tag.getInt("Honey")));
		this.nextHoney = tag.getInt("NextHoney");
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
