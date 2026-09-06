package com.animania.addons.farm.common.entity.sheep;

import java.util.ArrayList;
import java.util.List;

import com.animania.addons.farm.FarmItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

 





public class SheepFriesian
{
	private static final String[] COLOR_NAMES = { "black", "white", "brown" };

	private static ResourceLocation tex(String name, boolean sheared)
	{
		return ResourceLocation.fromNamespaceAndPath("animania",
				"textures/entity/sheep/sheep_friesian_" + name + (sheared ? "_sheared" : "") + ".png");
	}

	private static void applyTextures(EntityAnimaniaSheep sheep, boolean isRam)
	{
		String color = COLOR_NAMES[sheep.getColorNumber()];
		String suffix = isRam ? color + "_ram" : color;
		sheep.resourceLocation = tex(suffix, false);
		sheep.resourceLocationSheared = tex(suffix, true);
		sheep.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_blink_left.png");
		 
		 
		sheep.lidCol = new int[] { 0x282828, 0xEDEDED, 0x282828 }[sheep.getColorNumber()];
	}

	private static List<ItemStack> woolDrops(EntityAnimaniaSheep sheep)
	{
		int i = 1 + sheep.getRandom().nextInt(2);
		List<ItemStack> drops = new ArrayList<>();
		switch (sheep.getColorNumber())
		{
			case 0 -> drops.add(new ItemStack(FarmItems.WOOL_FRIESIAN_1.get(), i));
			case 1 -> drops.add(new ItemStack(EntityAnimaniaSheep.woolItemFor(sheep.getDyeColor()), i));
			case 2 -> drops.add(new ItemStack(FarmItems.WOOL_FRIESIAN_2.get(), i));
		}
		return drops;
	}

	public static class EntityRamFriesian extends EntityRamBase
	{
		public EntityRamFriesian(EntityType<? extends EntityRamFriesian> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.FRIESIAN;
			applyTextures(this, true);
		}

		@Override
		protected int getColorVariantCount() { return 3; }

		@Override
		public int getPrimaryEggColor() { return 2039583; }

		@Override
		public int getSecondaryEggColor() { return 4013373; }

		@Override
		public boolean isDyeable() { return this.getColorNumber() == 1; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityEweFriesian extends EntityEweBase
	{
		public EntityEweFriesian(EntityType<? extends EntityEweFriesian> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.FRIESIAN;
			applyTextures(this, false);
		}

		@Override
		protected int getColorVariantCount() { return 3; }

		@Override
		public int getPrimaryEggColor() { return 2039583; }

		@Override
		public int getSecondaryEggColor() { return 4013373; }

		@Override
		public boolean isDyeable() { return this.getColorNumber() == 1; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityLambFriesian extends EntityLambBase
	{
		public EntityLambFriesian(EntityType<? extends EntityLambFriesian> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.FRIESIAN;
			applyTextures(this, false);
		}

		@Override
		protected int getColorVariantCount() { return 3; }

		@Override
		public int getPrimaryEggColor() { return 2039583; }

		@Override
		public int getSecondaryEggColor() { return 4013373; }
	}
}
