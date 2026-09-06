package com.animania.addons.extra.common.entity.peafowl;

import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.extra.ExtraEntityTypes;
import com.animania.addons.extra.ExtraItems;
import com.animania.api.interfaces.AnimaniaType;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

 









public enum PeacockType implements AnimaniaType
{
	BLUE(true, () -> ExtraEntityTypes.PEACOCK_BLUE.get(), () -> ExtraEntityTypes.PEAFOWL_BLUE.get(), () -> ExtraEntityTypes.PEACHICK_BLUE.get(),
			() -> ExtraItems.PEACOCK_FEATHER_BLUE.get(), () -> ExtraItems.PEACOCK_EGG_BLUE.get()),
	WHITE(true, () -> ExtraEntityTypes.PEACOCK_WHITE.get(), () -> ExtraEntityTypes.PEAFOWL_WHITE.get(), () -> ExtraEntityTypes.PEACHICK_WHITE.get(),
			() -> ExtraItems.PEACOCK_FEATHER_WHITE.get(), () -> ExtraItems.PEACOCK_EGG_WHITE.get()),
	TAUPE(false, () -> ExtraEntityTypes.PEACOCK_TAUPE.get(), () -> ExtraEntityTypes.PEAFOWL_TAUPE.get(), () -> ExtraEntityTypes.PEACHICK_TAUPE.get(),
			() -> ExtraItems.PEACOCK_FEATHER_TAUPE.get(), () -> ExtraItems.PEACOCK_EGG_WHITE.get()),
	PURPLE(true, () -> ExtraEntityTypes.PEACOCK_PURPLE.get(), () -> ExtraEntityTypes.PEAFOWL_PURPLE.get(), () -> ExtraEntityTypes.PEACHICK_PURPLE.get(),
			() -> ExtraItems.PEACOCK_FEATHER_PURPLE.get(), () -> ExtraItems.PEACOCK_EGG_WHITE.get()),
	PEACH(true, () -> ExtraEntityTypes.PEACOCK_PEACH.get(), () -> ExtraEntityTypes.PEAFOWL_PEACH.get(), () -> ExtraEntityTypes.PEACHICK_PEACH.get(),
			() -> ExtraItems.PEACOCK_FEATHER_PEACH.get(), () -> ExtraItems.PEACOCK_EGG_WHITE.get()),
	OPAL(false, () -> ExtraEntityTypes.PEACOCK_OPAL.get(), () -> ExtraEntityTypes.PEAFOWL_OPAL.get(), () -> ExtraEntityTypes.PEACHICK_OPAL.get(),
			() -> ExtraItems.PEACOCK_FEATHER_OPAL.get(), () -> ExtraItems.PEACOCK_EGG_WHITE.get()),
	CHARCOAL(false, () -> ExtraEntityTypes.PEACOCK_CHARCOAL.get(), () -> ExtraEntityTypes.PEAFOWL_CHARCOAL.get(), () -> ExtraEntityTypes.PEACHICK_CHARCOAL.get(),
			() -> ExtraItems.PEACOCK_FEATHER_CHARCOAL.get(), () -> ExtraItems.PEACOCK_EGG_WHITE.get());

	private final boolean prime;
	private final Supplier<EntityType<? extends EntityPeacockBase>> male;
	private final Supplier<EntityType<? extends EntityPeafowlBase>> female;
	private final Supplier<EntityType<? extends EntityPeachickBase>> child;
	private final Supplier<Item> feather;
	private final Supplier<Item> eggItem;

	@SuppressWarnings("unchecked")
	PeacockType(boolean prime, Supplier<EntityType<?>> male, Supplier<EntityType<?>> female, Supplier<EntityType<?>> child, Supplier<Item> feather, Supplier<Item> eggItem)
	{
		this.prime = prime;
		this.male = () -> (EntityType<? extends EntityPeacockBase>) male.get();
		this.female = () -> (EntityType<? extends EntityPeafowlBase>) female.get();
		this.child = () -> (EntityType<? extends EntityPeachickBase>) child.get();
		this.feather = feather;
		this.eggItem = eggItem;
	}

	public Item getFeather()
	{
		return this.feather.get();
	}

	public Item getEggItem()
	{
		return this.eggItem.get();
	}

	public boolean isPrime()
	{
		return this.prime;
	}

	@Override
	public LivingEntity getMale(Level level)
	{
		return this.male.get().create(level);
	}

	@Override
	public LivingEntity getFemale(Level level)
	{
		return this.female.get().create(level);
	}

	@Override
	public LivingEntity getChild(Level level)
	{
		return this.child.get().create(level);
	}

	@Override
	public String getTypeName()
	{
		return Animania.MODID + ":peacock";
	}

	public static PeacockType breed(PeacockType mother, PeacockType father)
	{
		return Animania.RANDOM.nextBoolean() ? mother : father;
	}
}
