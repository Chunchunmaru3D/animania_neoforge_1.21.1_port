package com.animania.addons.farm.common.entity.pullables;

import javax.annotation.Nullable;

import com.animania.addons.farm.FarmItems;
import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.phys.Vec3;

 






public class EntityTiller extends EntityPullableBase
{
	protected static final EntityDataAccessor<Boolean> HAS_CHEST = SynchedEntityData.defineId(EntityTiller.class, EntityDataSerializers.BOOLEAN);

	 








	private final SimpleContainer chest = new SimpleContainer(27);
	private BlockPos lastPosMiddle;
	private BlockPos lastPosRight;
	private BlockPos lastPosLeft;
	private float damageTaken;
	private int timeSinceHit;

	public EntityTiller(EntityType<? extends EntityTiller> entityType, Level level)
	{
		super(entityType, level);
	}

	@Override
	protected int getPullerTypeFor(Entity candidate)
	{
		if (candidate instanceof EntityAnimaniaHorse)
			return 1;
		if (candidate instanceof EntityAnimaniaCow)
			return 3;
		return super.getPullerTypeFor(candidate);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(HAS_CHEST, true);
	}

	public boolean hasChest()
	{
		return this.entityData.get(HAS_CHEST);
	}

	public SimpleContainer getChestInventory()
	{
		return this.chest;
	}

	@Override
	public void tick()
	{
		super.tick();
		if (this.timeSinceHit > 0)
			this.timeSinceHit--;
		this.damageTaken *= 0.98F;

		if (!this.level().isClientSide && this.isPulled() && this.puller != null
				&& (this.puller instanceof EntityAnimaniaHorse || this.puller instanceof EntityAnimaniaCow))
		{
			Player player = this.level().getNearestPlayer(this.getX(), this.getY(), this.getZ(), 20, false);

			Vec3 up = new Vec3(0, 1, 0);
			Vec3 forward = new Vec3(1, 0, 0).yRot((float) Math.toRadians(this.getYRot())).normalize();
			Vec3 right = up.cross(forward).normalize();

			Vec3 posvec = new Vec3(this.blockPosition().below().getX() + 0.5, this.blockPosition().below().getY(), this.blockPosition().below().getZ() + 0.5);

			BlockPos middle = BlockPos.containing(posvec);
			BlockPos rightPos = BlockPos.containing(posvec.add(right));
			BlockPos leftPos = BlockPos.containing(posvec.subtract(right));
			if (!middle.equals(this.lastPosMiddle))
				tillGround(middle, player);
			if (!rightPos.equals(this.lastPosRight))
				tillGround(rightPos, player);
			if (!leftPos.equals(this.lastPosLeft))
				tillGround(leftPos, player);
			this.lastPosMiddle = middle;
			this.lastPosRight = rightPos;
			this.lastPosLeft = leftPos;
		}
	}

	 








	private void tillGround(BlockPos pos, @Nullable Player player)
	{
		BlockState state = this.level().getBlockState(pos);
		 
		 
		 
		if (!(state.getBlock() instanceof GrassBlock) && !(state.getBlock() instanceof FarmBlock) && !state.is(BlockTags.DIRT))
			return;

		this.level().setBlockAndUpdate(pos, Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7));

		BlockState above = this.level().getBlockState(pos.above());
		if (above.getBlock() instanceof TallGrassBlock || above.getBlock() instanceof DoublePlantBlock)
		{
			this.level().destroyBlock(pos.above(), false);
		}
		else if (above.getBlock() instanceof CropBlock)
		{
			 
		}
		else
		{
			for (int i = 0; i < this.chest.getContainerSize(); i++)
			{
				ItemStack seeds = this.chest.getItem(i);
				 
				 
				 
				if (!seeds.isEmpty() && seeds.getItem() instanceof ItemNameBlockItem seedItem
						&& seedItem.getBlock() instanceof CropBlock)
				{
					this.level().setBlockAndUpdate(pos.above(), seedItem.getBlock().defaultBlockState());
					if (player == null || !player.getAbilities().instabuild)
						seeds.shrink(1);
					break;
				}
			}
		}
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (player.isShiftKeyDown())
		{
			if (!this.level().isClientSide && player instanceof net.minecraft.server.level.ServerPlayer serverPlayer)
			{
				serverPlayer.openMenu(new net.minecraft.world.SimpleMenuProvider(
						(id, inv, p) -> net.minecraft.world.inventory.ChestMenu.threeRows(id, inv, this.chest),
						net.minecraft.network.chat.Component.translatable("container.animania.tiller")));
			}
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}

		if (this.handleHitchInteract(player, hand))
			return InteractionResult.sidedSuccess(this.level().isClientSide);

		return InteractionResult.PASS;
	}

	@Override
	public boolean hurt(DamageSource source, float amount)
	{
		if (this.isInvulnerableTo(source))
			return false;
		if (this.level().isClientSide || this.isRemoved())
			return true;

		this.timeSinceHit = 10;
		this.damageTaken += amount * 10.0F;
		this.markHurt();

		boolean creative = source.getEntity() instanceof Player p && p.getAbilities().instabuild;
		if (creative || this.damageTaken > 40.0F)
		{
			if (!creative && this.level().getGameRules().getBoolean(net.minecraft.world.level.GameRules.RULE_DOENTITYDROPS))
			{
				this.spawnAtLocation(new ItemStack(FarmItems.ITEM_TILLER.get()));
				Containers.dropContents(this.level(), this, this.chest);
				this.spawnAtLocation(new ItemStack(Items.CHEST));
			}
			this.discard();
		}
		return true;
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		if (tag.contains("Items"))
			net.minecraft.world.ContainerHelper.loadAllItems(tag, this.chest.getItems(), this.registryAccess());
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		net.minecraft.world.ContainerHelper.saveAllItems(tag, this.chest.getItems(), this.registryAccess());
	}

	@Override
	public boolean isPickable()
	{
		return !this.isRemoved();
	}
}
