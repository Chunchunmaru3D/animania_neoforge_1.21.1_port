package com.animania.addons.extra.common.entity.amphibians;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

 











public class EntityFrogs extends EntityAmphibian
{
	private static final EntityDataAccessor<Integer> FROGS_TYPE = SynchedEntityData.defineId(EntityFrogs.class, EntityDataSerializers.INT);

	public EntityFrogs(EntityType<? extends EntityFrogs> type, Level level)
	{
		super(type, level, true);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(FROGS_TYPE, this.random.nextInt(2));
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
	protected void registerGoals()
	{
		if (!"Pepe".equals(this.getName().getString()))
		{
			super.registerGoals();
		}
		else
		{
			this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, 0.5F));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0D, true));
			this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
			 
			 
			 
			 
			 
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this,
					com.animania.addons.extra.common.entity.rodents.EntityFerretBase.class, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this,
					com.animania.addons.extra.common.entity.rodents.EntityHedgehogBase.class, true));
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
			this.setHealth(20.0F);
		}
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand)
	{
		ItemStack stack = player.getItemInHand(hand);

		if (!stack.isEmpty() && stack.is(Items.NAME_TAG) && stack.has(DataComponents.CUSTOM_NAME))
		{
			this.setCustomName(stack.get(DataComponents.CUSTOM_NAME));
			if (!player.getAbilities().instabuild)
				stack.shrink(1);

			if ("Pepe".equals(this.getName().getString()))
			{
				this.registerGoals();
				this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
				this.setHealth(20.0F);
			}

			return InteractionResult.SUCCESS;
		}

		return super.mobInteract(player, hand);
	}

	 






	@Override
	protected SoundEvent getAmbientSound()
	{
		int chooser = this.random.nextInt(4);

		if ("Pepe".equals(this.getName().getString()) && 0.1 > this.random.nextDouble())
		{
			this.addEffect(new net.minecraft.world.effect.MobEffectInstance(net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED, 5, 4, true, false));
			return com.animania.addons.farm.FarmSounds.PEPE_REEEE.get();
		}

		if (this.random.nextDouble() < 0.3 && "me_irl".equalsIgnoreCase(this.getName().getString())
				&& java.time.LocalDate.now().getDayOfWeek() == java.time.DayOfWeek.WEDNESDAY)
			return com.animania.addons.farm.FarmSounds.PEPE_OOOOOHH.get();

		if (chooser == 0)
			return com.animania.addons.farm.FarmSounds.FROG_LIVING_1.get();
		else if (chooser == 1)
			return com.animania.addons.farm.FarmSounds.FROG_LIVING_2.get();
		else if (chooser == 2)
			return com.animania.addons.farm.FarmSounds.FROG_LIVING_3.get();
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
	public boolean doHurtTarget(Entity entityIn)
	{
		boolean flag = entityIn.hurt(this.level().damageSources().mobAttack(this), 2.0F);
		entityIn.hurt(this.level().damageSources().mobAttack(this), 2.0F);

		 

		if (entityIn instanceof Player player)
			player.knockback(1, this.getX() - entityIn.getX(), this.getZ() - entityIn.getZ());

		return flag;
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
	public int getPrimaryEggColor()
	{
		return 1860371;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 1793554;
	}

	@Override
	public AnimaniaType getAnimalType()
	{
		return AmphibianType.FROG;
	}

	@Override
	public EntityGender getEntityGender()
	{
		return EntityGender.NONE;
	}
}
