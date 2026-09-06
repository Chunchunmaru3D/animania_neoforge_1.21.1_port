package com.animania.client.render.blockentity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.animania.Animania;
import com.animania.client.model.block.ModelTrough;
import com.animania.common.blockentity.BlockEntityTrough;
import com.animania.common.blocks.BlockTrough;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.SpriteCoordinateExpander;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.state.BlockState;

 
public class BlockEntityTroughRenderer implements BlockEntityRenderer<BlockEntityTrough>
{
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "block_trough"), "main");
	public static final ModelLayerLocation FOOD_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "block_trough"), "food");
	private static final ResourceLocation TROUGH_TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID,
			"textures/entity/tileentities/block_trough.png");
	private static final ResourceLocation WATER_SPRITE = ResourceLocation.withDefaultNamespace("block/water_still");
	private static final ResourceLocation SLOP_SPRITE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "block/slop_still");
	private static final ResourceLocation WHEAT_TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/tileentities/wheat.png");

	private final ModelTrough model;
	private final ModelPart foodPile;
	private final Map<ResourceLocation, Integer> foodColors = new HashMap<>();

	public BlockEntityTroughRenderer(BlockEntityRendererProvider.Context context)
	{
		this.model = new ModelTrough(context.bakeLayer(MODEL_LAYER));
		this.foodPile = context.bakeLayer(FOOD_LAYER);
	}

	@Override
	public void render(BlockEntityTrough trough, float partialTick, PoseStack poseStack, MultiBufferSource buffers, int light, int overlay)
	{
		BlockState state = trough.getBlockState();
		Direction facing = state.hasProperty(BlockTrough.FACING) ? state.getValue(BlockTrough.FACING) : Direction.NORTH;

		poseStack.pushPose();
		applySourceTransform(poseStack, facing);
		this.model.renderBase(poseStack, buffers.getBuffer(RenderType.entityCutout(TROUGH_TEXTURE)), light, overlay);

		ItemStack food = trough.getItemHandler().getStackInSlot(0);
		if (!food.isEmpty())
			renderFood(food, poseStack, buffers, light, overlay);
		else if (!trough.getFluidTank().isEmpty())
			renderLiquid(trough, poseStack, buffers, light, overlay);

		poseStack.popPose();
	}

	 
	private static void applySourceTransform(PoseStack poseStack, Direction facing)
	{
		switch (facing)
		{
			case SOUTH -> { poseStack.translate(-.5D, 1.5D, .5D); poseStack.mulPose(Axis.YP.rotationDegrees(180)); }
			case WEST -> { poseStack.translate(.5D, 1.5D, -.5D); poseStack.mulPose(Axis.YP.rotationDegrees(90)); }
			case EAST -> { poseStack.translate(.5D, 1.5D, 1.5D); poseStack.mulPose(Axis.YP.rotationDegrees(270)); }
			default -> poseStack.translate(1.5D, 1.5D, .5D);  
		}
		poseStack.scale(-1, -1, 1);
	}

	private void renderFood(ItemStack food, PoseStack poseStack, MultiBufferSource buffers, int light, int overlay)
	{
		int count = Math.min(food.getCount(), BlockEntityTrough.FOOD_SLOT_LIMIT);
		TextureAtlasSprite sprite = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getItemModel(food).getParticleIcon();
		int argb = food.is(net.minecraft.world.item.Items.WHEAT) ? 0xFFA07C59 : this.foodColors.computeIfAbsent(
				sprite.contents().name(), BlockEntityTroughRenderer::getAverageColor);
		 
		this.model.renderFeed(poseStack, buffers.getBuffer(RenderType.entityCutout(TROUGH_TEXTURE)), light, overlay, count, argb);
		 
		boolean wheat = food.is(net.minecraft.world.item.Items.WHEAT);
		if (wheat)
		{
			ModelTrough.renderFood(this.foodPile, poseStack, buffers.getBuffer(RenderType.entityCutout(WHEAT_TEXTURE)),
					light, overlay, count, 0xFFFFFFFF);
		}
		else
		{
			ModelTrough.renderFood(this.foodPile, poseStack, new SpriteCoordinateExpander(
					buffers.getBuffer(RenderType.entityCutout(InventoryMenu.BLOCK_ATLAS)), sprite), light, overlay, count, 0xFFFFFFFF);
		}
	}

	 
	private static int getAverageColor(ResourceLocation sprite)
	{
		ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(sprite.getNamespace(), "textures/" + sprite.getPath() + ".png");
		try (var input = Minecraft.getInstance().getResourceManager().open(texture); NativeImage image = NativeImage.read(input))
		{
			double red = 0, green = 0, blue = 0;
			int pixels = image.getWidth() * image.getHeight();
			for (int x = 0; x < image.getWidth(); x++)
				for (int y = 0; y < image.getHeight(); y++)
				{
					double alpha = (image.getLuminanceOrAlpha(x, y) & 0xFF) / 255D;
					red += (image.getRedOrLuminance(x, y) & 0xFF) * alpha;
					green += (image.getGreenOrLuminance(x, y) & 0xFF) * alpha;
					blue += (image.getBlueOrLuminance(x, y) & 0xFF) * alpha;
				}
			return brightenThreeTimes((int) red / pixels, (int) green / pixels, (int) blue / pixels);
		}
		catch (IOException ignored)
		{
			 
			return 0xFF050505;
		}
	}

	private static int brightenThreeTimes(int red, int green, int blue)
	{
		for (int i = 0; i < 3; i++)
		{
			if (red == 0 && green == 0 && blue == 0)
				red = green = blue = 3;
			else
			{
				if (red > 0 && red < 3) red = 3;
				if (green > 0 && green < 3) green = 3;
				if (blue > 0 && blue < 3) blue = 3;
				red = Math.min((int) (red / .7F), 255);
				green = Math.min((int) (green / .7F), 255);
				blue = Math.min((int) (blue / .7F), 255);
			}
		}
		return 0xFF000000 | red << 16 | green << 8 | blue;
	}

	private void renderLiquid(BlockEntityTrough trough, PoseStack poseStack, MultiBufferSource buffers, int light, int overlay)
	{
		Fluid fluid = trough.getFluidTank().getFluid().getFluid();
		ResourceLocation spriteId = fluid == Fluids.WATER ? WATER_SPRITE : SLOP_SPRITE;
		TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(spriteId);

		 
		poseStack.pushPose();
		poseStack.translate(.4D, 1D + .3122D * (1D - trough.getFluidTank().getFluidAmount() / (double) BlockEntityTrough.CAPACITY_MB), -.3D);
		poseStack.mulPose(Axis.XP.rotationDegrees(90));
		var buffer = new SpriteCoordinateExpander(buffers.getBuffer(RenderType.entityTranslucent(InventoryMenu.BLOCK_ATLAS)), sprite);
		drawFluidQuad(buffer, poseStack, 0, 0, .6F, 1F, light, overlay);
		drawFluidQuad(buffer, poseStack, -.8F, 0, .6F, .8F, light, overlay);
		poseStack.popPose();
	}

	private static void drawFluidQuad(com.mojang.blaze3d.vertex.VertexConsumer buffer, PoseStack poseStack,
			float x, float y, float height, float width, int light, int overlay)
	{
		var pose = poseStack.last();
		float u = 16F * width;
		float v = 16F * height;
		buffer.addVertex(pose.pose(), x, y, 0).setColor(255, 255, 255, 255).setUv(u, v).setOverlay(overlay).setLight(light).setNormal(pose, 0, 0, 1);
		buffer.addVertex(pose.pose(), x + width, y, 0).setColor(255, 255, 255, 255).setUv(0, v).setOverlay(overlay).setLight(light).setNormal(pose, 0, 0, 1);
		buffer.addVertex(pose.pose(), x + width, y + height, 0).setColor(255, 255, 255, 255).setUv(0, 0).setOverlay(overlay).setLight(light).setNormal(pose, 0, 0, 1);
		buffer.addVertex(pose.pose(), x, y + height, 0).setColor(255, 255, 255, 255).setUv(u, 0).setOverlay(overlay).setLight(light).setNormal(pose, 0, 0, 1);
	}
}
