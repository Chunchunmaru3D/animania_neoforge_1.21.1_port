package com.animania.addons.farm.common.entity.cows;

import com.animania.common.helper.AnimaniaHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

 












public class CowMooshroom
{
	private static final int PRIMARY = 12325394;
	private static final int SECONDARY = 12627887;

	public static class EntityCalfMooshroom extends EntityCalfBase
	{
		public EntityCalfMooshroom(EntityType<? extends EntityCalfMooshroom> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.MOOSHROOM;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_mooshroom.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/calf_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityBullMooshroom extends EntityBullBase
	{
		public EntityBullMooshroom(EntityType<? extends EntityBullMooshroom> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.MOOSHROOM;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_mooshroom.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/bull_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}

	public static class EntityCowMooshroom extends EntityCowBase
	{
		public EntityCowMooshroom(EntityType<? extends EntityCowMooshroom> entityType, Level level)
		{
			super(entityType, level);
			this.cowType = CowType.MOOSHROOM;
			this.resourceLocation = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_mooshroom.png");
			this.resourceLocationBlink = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cows/cow_blink_left.png");
			this.lidCol = 0xF2F2F2;
		}

		@Override
		public InteractionResult mobInteract(Player player, InteractionHand hand)
		{
			ItemStack stack = player.getItemInHand(hand);

			if (this.getFed() && this.getWatered() && !stack.isEmpty() && this.getHasKids())
			{
				if (stack.is(Items.BOWL))
				{
					if (!this.level().isClientSide)
					{
						if (!player.getAbilities().instabuild)
							stack.shrink(1);
						AnimaniaHelper.addItem(player, new ItemStack(Items.MUSHROOM_STEW));
						this.setWatered(false);
					}
					return InteractionResult.sidedSuccess(this.level().isClientSide);
				}
				else if (stack.is(Items.BUCKET) || stack.is(Items.GLASS_BOTTLE))
				{
					 
					 
					 
					 
					return InteractionResult.sidedSuccess(this.level().isClientSide);
				}
			}

			return super.mobInteract(player, hand);
		}

		@Override
		public int getPrimaryEggColor() { return PRIMARY; }

		@Override
		public int getSecondaryEggColor() { return SECONDARY; }
	}
}
