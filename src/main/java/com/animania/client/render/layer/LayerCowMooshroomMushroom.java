package com.animania.client.render.layer;

import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.level.block.Blocks;

 





















public class LayerCowMooshroomMushroom<T extends EntityAnimaniaCow, M extends EntityModel<T>> extends RenderLayer<T, M>
{
	public LayerCowMooshroomMushroom(RenderLayerParent<T, M> renderer)
	{
		super(renderer);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity,
			float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	{
		 
		 
		 
		if (entity.cowType != com.animania.addons.farm.common.entity.cows.CowType.MOOSHROOM
				|| entity.isBaby() || entity.isInvisible())
			return;

		 
		 
		 
		float firstMushroomYOffset = entity instanceof com.animania.addons.farm.common.entity.cows.EntityBullBase ? 0.15F : 0.25F;

		var blockRenderer = Minecraft.getInstance().getBlockRenderer();
		var mushroomState = Blocks.RED_MUSHROOM.defaultBlockState();
		int overlay = net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

		 
		 
		 
		RenderSystem.enableCull();
		org.lwjgl.opengl.GL11C.glCullFace(org.lwjgl.opengl.GL11C.GL_FRONT);
		poseStack.pushPose();
		poseStack.scale(1.0F, -1.0F, 1.0F);
		poseStack.translate(0.2F, firstMushroomYOffset, 0.5F);
		poseStack.mulPose(Axis.YP.rotationDegrees(42.0F));

		poseStack.pushPose();
		 
		 
		 
		poseStack.scale(0.5F, 0.5F, 0.5F);
		poseStack.translate(-1.0F, -1.0F, 1.0F);
		blockRenderer.renderSingleBlock(mushroomState, poseStack, bufferSource, packedLight, overlay);
		poseStack.popPose();

		poseStack.pushPose();
		poseStack.translate(0.1F, 0.0F, -0.6F);
		poseStack.mulPose(Axis.YP.rotationDegrees(42.0F));
		poseStack.scale(0.5F, 0.5F, 0.5F);
		poseStack.translate(-1.0F, -1.0F, 1.0F);
		blockRenderer.renderSingleBlock(mushroomState, poseStack, bufferSource, packedLight, overlay);
		poseStack.popPose();

		poseStack.popPose();

		poseStack.pushPose();
		poseStack.scale(1.0F, -1.0F, 1.0F);
		poseStack.translate(0.0F, 0.3F, -0.2F);
		poseStack.mulPose(Axis.YP.rotationDegrees(12.0F));
		poseStack.scale(0.5F, 0.5F, 0.5F);
		poseStack.translate(-1.0F, -1.0F, 1.0F);
		blockRenderer.renderSingleBlock(mushroomState, poseStack, bufferSource, packedLight, overlay);
		poseStack.popPose();
		org.lwjgl.opengl.GL11C.glCullFace(org.lwjgl.opengl.GL11C.GL_BACK);
		RenderSystem.disableCull();
	}
}
