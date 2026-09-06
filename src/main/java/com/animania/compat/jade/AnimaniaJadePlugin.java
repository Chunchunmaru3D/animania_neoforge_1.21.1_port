package com.animania.compat.jade;

import com.animania.Animania;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Animal;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

 













@WailaPlugin
public class AnimaniaJadePlugin implements IWailaPlugin
{
	public static final ResourceLocation ANIMAL_STATUS_UID = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "animal_status");
	public static final ResourceLocation TROUGH_STATUS_UID = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "trough_status");
	public static final ResourceLocation NEST_STATUS_UID = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "nest_status");
	public static final ResourceLocation HIVE_STATUS_UID = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "hive_status");
	public static final ResourceLocation CHEESE_MOLD_STATUS_UID = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "cheese_mold_status");

	@Override
	public void register(IWailaCommonRegistration registration)
	{
		 
		 
		 
		 
		 
	}

	@Override
	public void registerClient(IWailaClientRegistration registration)
	{
		registration.registerEntityComponent(AnimalStatusProvider.INSTANCE, Animal.class);
		 
		 
		 
		registration.registerBlockComponent(TroughStatusProvider.INSTANCE, com.animania.common.blocks.BlockTrough.class);
		registration.registerBlockComponent(NestStatusProvider.INSTANCE, com.animania.common.blocks.BlockNest.class);
		registration.registerBlockComponent(HiveStatusProvider.INSTANCE, com.animania.addons.farm.common.block.BlockHive.class);
		registration.registerBlockComponent(CheeseMoldStatusProvider.INSTANCE, com.animania.addons.farm.common.block.BlockCheeseMold.class);
	}
}
