package com.animania.common.loottables;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.sheep.EntityAnimaniaSheep;
import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IFoodEating;
import com.animania.api.interfaces.IGendered;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.NumberProviders;
import net.neoforged.neoforge.registries.DeferredRegister;

 






public final class AnimaniaLootTables
{
	public static final DeferredRegister<LootItemConditionType> CONDITION_TYPES =
			DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, Animania.MODID);
	public static final DeferredRegister<LootItemFunctionType<?>> FUNCTION_TYPES =
			DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, Animania.MODID);

	public static final Supplier<LootItemConditionType> ANIMAL_STATUS = CONDITION_TYPES.register("animal_status",
			() -> new LootItemConditionType(AnimalStatusCondition.CODEC));
	public static final Supplier<LootItemFunctionType<AddMoreFunction>> ADD_MORE = FUNCTION_TYPES.register("add_more",
			() -> new LootItemFunctionType<>(AddMoreFunction.CODEC));
	public static final Supplier<LootItemFunctionType<WoolColorFunction>> WOOL_COLOR = FUNCTION_TYPES.register("wool_color",
			() -> new LootItemFunctionType<>(WoolColorFunction.CODEC));

	private AnimaniaLootTables()
	{
	}

	 
	public record AnimalStatusCondition(Optional<Boolean> fed, Optional<Boolean> watered, Optional<Boolean> male) implements LootItemCondition
	{
		public static final MapCodec<AnimalStatusCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
				Codec.BOOL.optionalFieldOf("fed").forGetter(AnimalStatusCondition::fed),
				Codec.BOOL.optionalFieldOf("watered").forGetter(AnimalStatusCondition::watered),
				Codec.BOOL.optionalFieldOf("male").forGetter(AnimalStatusCondition::male)
		).apply(instance, AnimalStatusCondition::new));

		@Override
		public boolean test(LootContext context)
		{
			Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
			if (entity == null)
				return false;

			if (this.fed.isPresent() && (!(entity instanceof IFoodEating eating) || eating.getFed() != this.fed.get()))
				return false;
			if (this.watered.isPresent() && (!(entity instanceof IFoodEating eating) || eating.getWatered() != this.watered.get()))
				return false;
			return this.male.isEmpty() || (entity instanceof IGendered gendered
					&& (gendered.getEntityGender() == EntityGender.MALE) == this.male.get());
		}

		@Override
		public Set<LootContextParam<?>> getReferencedContextParams()
		{
			return Set.of(LootContextParams.THIS_ENTITY);
		}

		@Override
		public LootItemConditionType getType()
		{
			return ANIMAL_STATUS.get();
		}
	}

	 
	public static final class AddMoreFunction extends LootItemConditionalFunction
	{
		public static final MapCodec<AddMoreFunction> CODEC = RecordCodecBuilder.mapCodec(instance -> commonFields(instance).and(
				NumberProviders.CODEC.fieldOf("count").forGetter(function -> function.count)
		).apply(instance, AddMoreFunction::new));

		private final NumberProvider count;

		public AddMoreFunction(List<LootItemCondition> conditions, NumberProvider count)
		{
			super(conditions);
			this.count = count;
		}

		@Override
		protected ItemStack run(ItemStack stack, LootContext context)
		{
			stack.grow(Math.round(this.count.getFloat(context)));
			return stack;
		}

		@Override
		public LootItemFunctionType<AddMoreFunction> getType()
		{
			return ADD_MORE.get();
		}
	}

	 
	public static final class WoolColorFunction extends LootItemConditionalFunction
	{
		public static final MapCodec<WoolColorFunction> CODEC = RecordCodecBuilder.mapCodec(instance ->
				commonFields(instance).apply(instance, WoolColorFunction::new));

		public WoolColorFunction(List<LootItemCondition> conditions)
		{
			super(conditions);
		}

		@Override
		protected ItemStack run(ItemStack stack, LootContext context)
		{
			Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
			return entity instanceof EntityAnimaniaSheep sheep ? sheep.getDeathWoolDrop() : stack;
		}

		@Override
		public LootItemFunctionType<WoolColorFunction> getType()
		{
			return WOOL_COLOR.get();
		}
	}
}
