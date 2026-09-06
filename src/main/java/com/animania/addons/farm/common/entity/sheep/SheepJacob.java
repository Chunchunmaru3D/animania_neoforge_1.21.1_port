package com.animania.addons.farm.common.entity.sheep;

import java.util.ArrayList;
import java.util.List;

import com.animania.addons.farm.FarmItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

 



public class SheepJacob
{
	private static ResourceLocation adultTex(boolean sheared)
	{
		return ResourceLocation.fromNamespaceAndPath("animania",
				"textures/entity/sheep/sheep_jacob" + (sheared ? "_sheared" : "") + ".png");
	}

	private static List<ItemStack> woolDrops(EntityAnimaniaSheep sheep)
	{
		int i = 1 + sheep.getRandom().nextInt(2);
		return List.of(new ItemStack(FarmItems.WOOL_JACOB.get(), i));
	}

	public static class EntityRamJacob extends EntityRamBase
	{
		public EntityRamJacob(EntityType<? extends EntityRamJacob> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.JACOB;
			this.resourceLocation = adultTex(false);
			this.resourceLocationSheared = adultTex(true);
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_blink_left.png");
			this.lidCol = 0x353535;
		}

		@Override
		public int getPrimaryEggColor() { return 15921647; }

		@Override
		public int getSecondaryEggColor() { return 2368548; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityEweJacob extends EntityEweBase
	{
		public EntityEweJacob(EntityType<? extends EntityEweJacob> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.JACOB;
			this.resourceLocation = adultTex(false);
			this.resourceLocationSheared = adultTex(true);
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_blink_left.png");
			this.lidCol = 0x353535;
		}

		@Override
		public int getPrimaryEggColor() { return 15921647; }

		@Override
		public int getSecondaryEggColor() { return 2368548; }

		@Override
		protected List<ItemStack> getWoolDrops() { return woolDrops(this); }
	}

	public static class EntityLambJacob extends EntityLambBase
	{
		public EntityLambJacob(EntityType<? extends EntityLambJacob> entityType, Level level)
		{
			super(entityType, level);
			this.sheepType = SheepType.JACOB;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_jacob_lamb.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/sheep/sheep_blink_left.png");
			this.lidCol = 0x353535;
		}

		@Override
		public int getPrimaryEggColor() { return 15921647; }

		@Override
		public int getSecondaryEggColor() { return 2368548; }
	}
}
