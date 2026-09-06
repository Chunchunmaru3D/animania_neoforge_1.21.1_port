package com.animania.addons.extra.common.entity.amphibians;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

 




public class EntityToad extends EntityAmphibian
{
	public EntityToad(EntityType<? extends EntityToad> type, Level level)
	{
		super(type, level, true);
	}

	@Override
	public boolean isFood(ItemStack stack)
	{
		return false;
	}

	 
	@Override
	protected SoundEvent getAmbientSound()
	{
		int chooser = this.random.nextInt(5);

		if (chooser == 0)
			return com.animania.addons.farm.FarmSounds.TOAD_LIVING_1.get();
		else if (chooser == 1)
			return com.animania.addons.farm.FarmSounds.TOAD_LIVING_2.get();
		else if (chooser == 2)
			return com.animania.addons.farm.FarmSounds.TOAD_LIVING_3.get();
		else if (chooser == 3)
			return com.animania.addons.farm.FarmSounds.TOAD_LIVING_4.get();
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
		this.playSound(SoundEvents.CHICKEN_STEP, 0.05F, 1.1F);
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 13868916;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 5650205;
	}

	@Override
	public AnimaniaType getAnimalType()
	{
		return AmphibianType.TOAD;
	}

	@Override
	public EntityGender getEntityGender()
	{
		return EntityGender.NONE;
	}
}
