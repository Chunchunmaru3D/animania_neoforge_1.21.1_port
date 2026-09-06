package com.animania.addons.extra.common.entity.amphibians;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

 









public class EntityDartFrogs extends EntityAmphibian
{
	private static final EntityDataAccessor<Integer> FROGS_TYPE = SynchedEntityData.defineId(EntityDartFrogs.class, EntityDataSerializers.INT);

	public int poisonTimer;

	public EntityDartFrogs(EntityType<? extends EntityDartFrogs> type, Level level)
	{
		super(type, level, true);
		this.poisonTimer = 2;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(FROGS_TYPE, this.random.nextInt(3));
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return false;
	}

	public int getFrogsType()
	{
		return this.entityData.get(FROGS_TYPE);
	}

	public void setFrogsType(int frogsId)
	{
		this.entityData.set(FROGS_TYPE, frogsId);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound)
	{
		super.addAdditionalSaveData(compound);
		compound.putInt("FrogsType", this.getFrogsType());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound)
	{
		super.readAdditionalSaveData(compound);
		this.setFrogsType(compound.getInt("FrogsType"));
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (!stack.isEmpty() && stack.is(Items.ARROW) && this.poisonTimer <= 1)
		{
			this.poisonTimer = 800;
			this.playSound(SoundEvents.MAGMA_CUBE_SQUISH, 0.2F, 1.8F);

			ItemStack tipped = new ItemStack(Items.TIPPED_ARROW);
			tipped.set(net.minecraft.core.component.DataComponents.POTION_CONTENTS, new PotionContents(Potions.POISON));
			stack.shrink(1);

			if (stack.getCount() == 0)
			{
				player.setItemInHand(hand, tipped);
			}
			else if (!player.getInventory().add(tipped))
			{
				player.drop(tipped, false);
			}

			return InteractionResult.SUCCESS;
		}

		return super.mobInteract(player, hand);
	}

	@Override
	protected void doPush(Entity entityIn)
	{
		if (entityIn instanceof Player player)
			player.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1, false, false));

		super.doPush(entityIn);
	}

	@Override
	public void aiStep()
	{
		if (this.poisonTimer > 1)
			this.poisonTimer--;

		super.aiStep();
	}

	 
	@Override
	protected SoundEvent getAmbientSound()
	{
		int chooser = this.random.nextInt(5);

		if (chooser == 0)
			return com.animania.addons.farm.FarmSounds.DART_FROG_LIVING_1.get();
		else if (chooser == 1)
			return com.animania.addons.farm.FarmSounds.DART_FROG_LIVING_2.get();
		else if (chooser == 2)
			return com.animania.addons.farm.FarmSounds.DART_FROG_LIVING_3.get();
		else if (chooser == 3)
			return com.animania.addons.farm.FarmSounds.DART_FROG_LIVING_4.get();
		else
			return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return null;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return null;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn)
	{
		this.playSound(SoundEvents.CHICKEN_STEP, 0.04F, 1.1F);
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	public boolean usesEggColor()
	{
		return false;
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 0;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 0;
	}

	@Override
	public AnimaniaType getAnimalType()
	{
		return AmphibianType.DART_FROG;
	}

	@Override
	public EntityGender getEntityGender()
	{
		return EntityGender.NONE;
	}
}
