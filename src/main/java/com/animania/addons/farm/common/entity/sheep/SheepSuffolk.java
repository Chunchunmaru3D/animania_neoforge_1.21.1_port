package com.animania.addons.farm.common.entity.sheep;

import java.util.ArrayList;
import java.util.List;

import com.animania.addons.farm.FarmItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

 



public class SheepSuffolk
{
	private static ResourceLocation tex(String colorGender, boolean sheared)
	{
		return ResourceLocation.fromNamespaceAndPath("animania",
				"textures/entity/sheep/sheep_suffolk_" + colorGender + (sheared ? "_sheared" : "") + ".png");
	}

	private static void applyTextures(EntityAnimaniaSheep sheep, String genderSuffix)
	{
		String color = sheep.getColorNumber() == 0 ? "white" : "brown";
		sheep.resourceLocation = tex(color + "_" + genderSuffix, false);
		sheep.resourceLocationSheared = tex(color + "_" + genderSuffix, true);
		sheep.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_blink_left.png");
		sheep.lidCol = 0x1D1D1D;
	}

	private static List<ItemStack> woolDrops(EntityAnimaniaSheep sheep)
	{
		int i = 1 + sheep.getRandom().nextInt(2);
		List<ItemStack> drops = new ArrayList<>();
		if (sheep.getColorNumber() == 0)
			drops.add(new ItemStack(EntityAnimaniaSheep.woolItemFor(sheep.getDyeColor()), i));
		else
			drops.add(new ItemStack(FarmItems.WOOL_SUFFOLK_NATURAL.get(), i));
		return drops;
	}

	public static class EntityRamSuffolk extends EntityRamBase
	{
		public EntityRamSuffolk(EntityType<? extends EntityRamSuffolk> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.SUFFOLK;
			applyTextures(this, "ram");
		}

		@Override
		protected int getColorVariantCount() { return 2; }

		@Override
		public int getPrimaryEggColor() { return 2757652; }

		@Override
		public int getSecondaryEggColor() { return 4336416; }

		@Override
		public boolean isDyeable() { return this.getColorNumber() == 0; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityEweSuffolk extends EntityEweBase
	{
		public EntityEweSuffolk(EntityType<? extends EntityEweSuffolk> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.SUFFOLK;
			applyTextures(this, "ewe");
		}

		@Override
		protected int getColorVariantCount() { return 2; }

		@Override
		public int getPrimaryEggColor() { return 2757652; }

		@Override
		public int getSecondaryEggColor() { return 4336416; }

		@Override
		public boolean isDyeable() { return this.getColorNumber() == 0; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityLambSuffolk extends EntityLambBase
	{
		public EntityLambSuffolk(EntityType<? extends EntityLambSuffolk> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.SUFFOLK;
			applyTextures(this, "ewe");
		}

		@Override
		protected int getColorVariantCount() { return 2; }

		@Override
		public int getPrimaryEggColor() { return 2757652; }

		@Override
		public int getSecondaryEggColor() { return 4336416; }
	}
}
