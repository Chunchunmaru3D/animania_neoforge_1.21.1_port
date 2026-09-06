package com.animania.api.interfaces;

import java.util.Optional;
import java.util.UUID;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

 




public interface IAnimaniaAnimal
{
	AnimaniaType getAnimalType();

	 
	 
	 

	default boolean getBoolFromDataManager(EntityDataAccessor<Boolean> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key);
		}
		catch (Exception e)
		{
			return false;
		}
	}

	default byte getByteFromDataManager(EntityDataAccessor<Byte> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	default int getIntFromDataManager(EntityDataAccessor<Integer> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	default float getFloatFromDataManager(EntityDataAccessor<Float> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	default String getStringFromDataManager(EntityDataAccessor<String> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	default UUID getUUIDFromDataManager(EntityDataAccessor<Optional<UUID>> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key).orElse(null);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	default ItemStack getItemStackFromDataManager(EntityDataAccessor<ItemStack> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key);
		}
		catch (Exception e)
		{
			return ItemStack.EMPTY;
		}
	}

	default BlockPos getBlockPosFromDataManager(EntityDataAccessor<Optional<BlockPos>> key)
	{
		try
		{
			return ((Entity) this).getEntityData().get(key).orElse(null);
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
