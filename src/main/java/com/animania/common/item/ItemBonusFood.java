package com.animania.common.item;

import com.animania.config.AnimaniaConfig;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

 
public class ItemBonusFood extends Item
{
	private final MobEffectInstance[] bonusEffects;

	public ItemBonusFood(Properties properties, MobEffectInstance... bonusEffects)
	{
		super(properties);
		this.bonusEffects = bonusEffects;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity)
	{
		ItemStack result = super.finishUsingItem(stack, level, entity);
		if (!level.isClientSide && AnimaniaConfig.gameRules.foodsGiveBonusEffects.get())
			for (MobEffectInstance bonusEffect : this.bonusEffects)
				entity.addEffect(new MobEffectInstance(bonusEffect));
		return result;
	}
}
