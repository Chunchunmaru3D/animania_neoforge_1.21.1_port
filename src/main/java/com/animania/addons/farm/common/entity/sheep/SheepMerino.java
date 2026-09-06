package com.animania.addons.farm.common.entity.sheep;

import java.util.ArrayList;
import java.util.List;

import com.animania.addons.farm.FarmItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

 





public class SheepMerino
{
	private static ResourceLocation tex(String colorGender, boolean sheared)
	{
		return ResourceLocation.fromNamespaceAndPath("animania",
				"textures/entity/sheep/sheep_merino_" + colorGender + (sheared ? "_sheared" : "") + ".png");
	}

	private static void applyTextures(EntityAnimaniaSheep sheep, String genderSuffix)
	{
		String color = sheep.getColorNumber() == 0 ? "white" : "brown";
		sheep.resourceLocation = tex(color + "_" + genderSuffix, false);
		sheep.resourceLocationSheared = tex(color + "_" + genderSuffix, true);
		sheep.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_blink_left.png");
		 
		sheep.lidCol = sheep.getColorNumber() == 0 ? 0xEDEDED : 0x232323;
	}

	private static List<ItemStack> woolDrops(EntityAnimaniaSheep sheep)
	{
		int i = 1 + sheep.getRandom().nextInt(2);
		List<ItemStack> drops = new ArrayList<>();
		if (sheep.getColorNumber() == 0)
		{
			if (sheep.getDyeColor() == DyeColor.WHITE)
				drops.add(new ItemStack(FarmItems.WOOL_MERINO_NATURAL.get(), i));
			else
				drops.add(new ItemStack(EntityAnimaniaSheep.woolItemFor(sheep.getDyeColor()), i));
		}
		else
		{
			drops.add(new ItemStack(FarmItems.WOOL_MERINO_BROWN.get(), i));
		}
		return drops;
	}

	public static class EntityRamMerino extends EntityRamBase
	{
		public EntityRamMerino(EntityType<? extends EntityRamMerino> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.MERINO;
			applyTextures(this, "ram");
		}

		@Override
		protected int getColorVariantCount() { return 2; }

		@Override
		public int getPrimaryEggColor() { return 11904114; }

		@Override
		public int getSecondaryEggColor() { return 15526109; }

		@Override
		public boolean isDyeable() { return this.getColorNumber() == 0; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityEweMerino extends EntityEweBase
	{
		public EntityEweMerino(EntityType<? extends EntityEweMerino> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.MERINO;
			applyTextures(this, "ewe");
		}

		@Override
		protected int getColorVariantCount() { return 2; }

		@Override
		public int getPrimaryEggColor() { return 11904114; }

		@Override
		public int getSecondaryEggColor() { return 15526109; }

		@Override
		public boolean isDyeable() { return this.getColorNumber() == 0; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityLambMerino extends EntityLambBase
	{
		public EntityLambMerino(EntityType<? extends EntityLambMerino> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.MERINO;
			applyTextures(this, "ewe");
		}

		@Override
		protected int getColorVariantCount() { return 2; }

		@Override
		public int getPrimaryEggColor() { return 11904114; }

		@Override
		public int getSecondaryEggColor() { return 15526109; }
	}
}
