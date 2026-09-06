package com.animania.client.render.blockentity;

import com.animania.Animania;
import com.animania.client.model.block.ModelSaltLick;
import com.animania.common.blockentity.BlockEntitySaltLick;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

 
public final class BlockEntitySaltLickRenderer implements BlockEntityRenderer<BlockEntitySaltLick>
{
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "block_salt_lick"), "main");
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID,
			"textures/entity/tileentities/salt_lick.png");

	private final ModelSaltLick model;

	public BlockEntitySaltLickRenderer(BlockEntityRendererProvider.Context context)
	{
		this.model = new ModelSaltLick(context.bakeLayer(MODEL_LAYER));
	}

	@Override
	public void render(BlockEntitySaltLick saltLick, float partialTick, PoseStack poseStack, MultiBufferSource buffers, int light, int overlay)
	{
		poseStack.pushPose();
		 
		poseStack.translate(.5D, 0D, .5D);
		poseStack.scale(-1, -1, 1);
		poseStack.scale(1, (float) saltLick.getFractionRemaining(), 1);
		poseStack.translate(0, -1.5D, 0);
		this.model.render(poseStack, buffers.getBuffer(RenderType.entityCutout(TEXTURE)), light, overlay);
		poseStack.popPose();
	}
}
