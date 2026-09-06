package com.animania.addons.farm.common.entity.sheep;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

 



public class SheepDorper
{
	private static ResourceLocation tex(boolean sheared)
	{
		return ResourceLocation.fromNamespaceAndPath("animania",
				"textures/entity/sheep/sheep_dorper" + (sheared ? "_sheared" : "") + ".png");
	}

	private static void applyTextures(EntityAnimaniaSheep sheep)
	{
		sheep.resourceLocation = tex(false);
		sheep.resourceLocationSheared = tex(true);
		sheep.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_blink_left.png");
		sheep.lidCol = 0x222222;
	}

	public static class EntityRamDorper extends EntityRamBase
	{
		public EntityRamDorper(EntityType<? extends EntityRamDorper> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.DORPER;
			applyTextures(this);
		}

		@Override
		public int getPrimaryEggColor() { return 15987699; }

		@Override
		public int getSecondaryEggColor() { return 13552319; }

		@Override
		public boolean isDyeable() { return true; }

		@Override
		protected List<ItemStack> getWoolDrops()
		{
			int i = 1 + this.random.nextInt(2);
			List<ItemStack> drops = new ArrayList<>();
			drops.add(new ItemStack(woolItemFor(this.getDyeColor()), i));
			return drops;
		}
	}

	public static class EntityEweDorper extends EntityEweBase
	{
		public EntityEweDorper(EntityType<? extends EntityEweDorper> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.DORPER;
			applyTextures(this);
		}

		@Override
		public int getPrimaryEggColor() { return 15987699; }

		@Override
		public int getSecondaryEggColor() { return 1776411; }

		@Override
		public boolean isDyeable() { return true; }

		@Override
		protected List<ItemStack> getWoolDrops()
		{
			int i = 1 + this.random.nextInt(2);
			List<ItemStack> drops = new ArrayList<>();
			drops.add(new ItemStack(woolItemFor(this.getDyeColor()), i));
			return drops;
		}
	}

	public static class EntityLambDorper extends EntityLambBase
	{
		public EntityLambDorper(EntityType<? extends EntityLambDorper> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.DORPER;
			applyTextures(this);
		}

		@Override
		public int getPrimaryEggColor() { return 15987699; }

		@Override
		public int getSecondaryEggColor() { return 13552319; }
	}
}
