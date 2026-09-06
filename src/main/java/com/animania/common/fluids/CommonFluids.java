package com.animania.common.fluids;

import com.animania.Animania;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

 



public final class CommonFluids
{
	public static final DeferredRegister<FluidType> FLUID_TYPES =
			DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Animania.MODID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Animania.MODID);
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Animania.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Animania.MODID);

	 
	public static final DeferredHolder<FluidType, FluidType> SLOP_TYPE = FLUID_TYPES.register("slop", () ->
			new FluidType(FluidType.Properties.create()
					.descriptionId("fluid_type.animania.slop")
					.density(3000)
					.viscosity(7000)
					.sound(SoundActions.BUCKET_EMPTY, SoundEvents.SLIME_BLOCK_PLACE)
					.sound(SoundActions.BUCKET_FILL, SoundEvents.SLIME_BLOCK_FALL)));

	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SLOP_SOURCE =
			FLUIDS.register("slop", () -> new BaseFlowingFluid.Source(createSlopProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> SLOP_FLOWING =
			FLUIDS.register("flowing_slop", () -> new BaseFlowingFluid.Flowing(createSlopProperties()));

	public static final DeferredBlock<LiquidBlock> SLOP_BLOCK = BLOCKS.register("slop",
			() -> new LiquidBlock(SLOP_SOURCE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).noLootTable()));
	public static final DeferredItem<BucketItem> SLOP_BUCKET = ITEMS.register("slop_bucket",
			() -> new BucketItem(SLOP_SOURCE.get(), new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

	 




	public static final DeferredHolder<FluidType, FluidType> MILK_FRIESIAN_TYPE = fluidType("milk_friesian", 1000, 1000);
	public static final DeferredHolder<FluidType, FluidType> MILK_HOLSTEIN_TYPE = fluidType("milk_holstein", 1000, 1000);
	public static final DeferredHolder<FluidType, FluidType> MILK_JERSEY_TYPE = fluidType("milk_jersey", 1000, 1000);
	public static final DeferredHolder<FluidType, FluidType> MILK_SHEEP_TYPE = fluidType("milk_sheep", 1000, 1000);
	public static final DeferredHolder<FluidType, FluidType> MILK_GOAT_TYPE = fluidType("milk_goat", 1000, 1000);
	public static final DeferredHolder<FluidType, FluidType> HONEY_TYPE = fluidType("honey", 1400, 3000);

	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MILK_FRIESIAN_SOURCE =
			FLUIDS.register("milk_friesian", () -> new BaseFlowingFluid.Source(milkFriesianProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MILK_FRIESIAN_FLOWING =
			FLUIDS.register("flowing_milk_friesian", () -> new BaseFlowingFluid.Flowing(milkFriesianProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MILK_HOLSTEIN_SOURCE =
			FLUIDS.register("milk_holstein", () -> new BaseFlowingFluid.Source(milkHolsteinProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MILK_HOLSTEIN_FLOWING =
			FLUIDS.register("flowing_milk_holstein", () -> new BaseFlowingFluid.Flowing(milkHolsteinProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MILK_JERSEY_SOURCE =
			FLUIDS.register("milk_jersey", () -> new BaseFlowingFluid.Source(milkJerseyProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MILK_JERSEY_FLOWING =
			FLUIDS.register("flowing_milk_jersey", () -> new BaseFlowingFluid.Flowing(milkJerseyProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MILK_SHEEP_SOURCE =
			FLUIDS.register("milk_sheep", () -> new BaseFlowingFluid.Source(milkSheepProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MILK_SHEEP_FLOWING =
			FLUIDS.register("flowing_milk_sheep", () -> new BaseFlowingFluid.Flowing(milkSheepProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MILK_GOAT_SOURCE =
			FLUIDS.register("milk_goat", () -> new BaseFlowingFluid.Source(milkGoatProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MILK_GOAT_FLOWING =
			FLUIDS.register("flowing_milk_goat", () -> new BaseFlowingFluid.Flowing(milkGoatProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> HONEY_SOURCE =
			FLUIDS.register("honey", () -> new BaseFlowingFluid.Source(honeyProperties()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> HONEY_FLOWING =
			FLUIDS.register("flowing_honey", () -> new BaseFlowingFluid.Flowing(honeyProperties()));

	public static final DeferredBlock<LiquidBlock> MILK_FRIESIAN_BLOCK = liquidBlock("milk_friesian", MILK_FRIESIAN_SOURCE, MapColor.SNOW);
	public static final DeferredBlock<LiquidBlock> MILK_HOLSTEIN_BLOCK = liquidBlock("milk_holstein", MILK_HOLSTEIN_SOURCE, MapColor.SNOW);
	public static final DeferredBlock<LiquidBlock> MILK_JERSEY_BLOCK = liquidBlock("milk_jersey", MILK_JERSEY_SOURCE, MapColor.SNOW);
	public static final DeferredBlock<LiquidBlock> MILK_SHEEP_BLOCK = liquidBlock("milk_sheep", MILK_SHEEP_SOURCE, MapColor.SNOW);
	public static final DeferredBlock<LiquidBlock> MILK_GOAT_BLOCK = liquidBlock("milk_goat", MILK_GOAT_SOURCE, MapColor.SNOW);
	public static final DeferredBlock<LiquidBlock> HONEY_BLOCK = liquidBlock("honey", HONEY_SOURCE, MapColor.COLOR_YELLOW);

	public static final DeferredItem<BucketItem> MILK_FRIESIAN_BUCKET = bucket("friesian_milk_bucket", MILK_FRIESIAN_SOURCE);
	public static final DeferredItem<BucketItem> MILK_HOLSTEIN_BUCKET = bucket("holstein_milk_bucket", MILK_HOLSTEIN_SOURCE);
	public static final DeferredItem<BucketItem> MILK_JERSEY_BUCKET = bucket("jersey_milk_bucket", MILK_JERSEY_SOURCE);
	public static final DeferredItem<BucketItem> MILK_SHEEP_BUCKET = bucket("sheep_milk_bucket", MILK_SHEEP_SOURCE);
	public static final DeferredItem<BucketItem> MILK_GOAT_BUCKET = bucket("goat_milk_bucket", MILK_GOAT_SOURCE);
	public static final DeferredItem<BucketItem> HONEY_BUCKET = bucket("honey_bucket", HONEY_SOURCE);

	private CommonFluids()
	{
	}

	private static BaseFlowingFluid.Properties createSlopProperties()
	{
		return new BaseFlowingFluid.Properties(SLOP_TYPE, () -> SLOP_SOURCE.get(), () -> SLOP_FLOWING.get())
				.block(() -> SLOP_BLOCK.get())
				.bucket(() -> SLOP_BUCKET.get())
				.slopeFindDistance(4)
				.levelDecreasePerBlock(1)
				.explosionResistance(100.0F)
				.tickRate(20);
	}

	private static DeferredHolder<FluidType, FluidType> fluidType(String name, int density, int viscosity)
	{
		return FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()
				.descriptionId("fluid_type.animania." + name).density(density).viscosity(viscosity)));
	}

	private static DeferredBlock<LiquidBlock> liquidBlock(String name,
			DeferredHolder<Fluid, BaseFlowingFluid.Source> source, MapColor color)
	{
		return BLOCKS.register(name, () -> new LiquidBlock(source.get(),
				BlockBehaviour.Properties.of().mapColor(color).noLootTable()));
	}

	private static DeferredItem<BucketItem> bucket(String name, DeferredHolder<Fluid, BaseFlowingFluid.Source> source)
	{
		return ITEMS.register(name, () -> new BucketItem(source.get(),
				new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
	}

	private static BaseFlowingFluid.Properties fluidProperties(DeferredHolder<FluidType, FluidType> type,
			java.util.function.Supplier<? extends Fluid> source, java.util.function.Supplier<? extends Fluid> flowing,
			java.util.function.Supplier<? extends LiquidBlock> block, java.util.function.Supplier<? extends BucketItem> bucket,
			int tickRate, int slopeFindDistance)
	{
		return new BaseFlowingFluid.Properties(type, source, flowing).block(block).bucket(bucket)
				.slopeFindDistance(slopeFindDistance).levelDecreasePerBlock(1).explosionResistance(100.0F).tickRate(tickRate);
	}

	private static BaseFlowingFluid.Properties milkFriesianProperties() { return fluidProperties(MILK_FRIESIAN_TYPE, MILK_FRIESIAN_SOURCE, MILK_FRIESIAN_FLOWING, MILK_FRIESIAN_BLOCK, MILK_FRIESIAN_BUCKET, 5, 4); }
	private static BaseFlowingFluid.Properties milkHolsteinProperties() { return fluidProperties(MILK_HOLSTEIN_TYPE, MILK_HOLSTEIN_SOURCE, MILK_HOLSTEIN_FLOWING, MILK_HOLSTEIN_BLOCK, MILK_HOLSTEIN_BUCKET, 5, 4); }
	private static BaseFlowingFluid.Properties milkJerseyProperties() { return fluidProperties(MILK_JERSEY_TYPE, MILK_JERSEY_SOURCE, MILK_JERSEY_FLOWING, MILK_JERSEY_BLOCK, MILK_JERSEY_BUCKET, 5, 4); }
	private static BaseFlowingFluid.Properties milkSheepProperties() { return fluidProperties(MILK_SHEEP_TYPE, MILK_SHEEP_SOURCE, MILK_SHEEP_FLOWING, MILK_SHEEP_BLOCK, MILK_SHEEP_BUCKET, 5, 4); }
	private static BaseFlowingFluid.Properties milkGoatProperties() { return fluidProperties(MILK_GOAT_TYPE, MILK_GOAT_SOURCE, MILK_GOAT_FLOWING, MILK_GOAT_BLOCK, MILK_GOAT_BUCKET, 5, 4); }
	private static BaseFlowingFluid.Properties honeyProperties() { return fluidProperties(HONEY_TYPE, HONEY_SOURCE, HONEY_FLOWING, HONEY_BLOCK, HONEY_BUCKET, 10, 2); }

	public static void register(IEventBus modEventBus)
	{
		FLUID_TYPES.register(modEventBus);
		FLUIDS.register(modEventBus);
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
	}
}
