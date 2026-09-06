package com.animania.client.render.layer;

import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;

 



public class LayerBlinkingCow<T extends EntityAnimaniaCow, M extends EntityModel<T>> extends RenderLayer<T, M>
{
	public LayerBlinkingCow(RenderLayerParent<T, M> renderer)
	{
		super(renderer);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity,
			float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	{
		if (entity.isInvisible())
			return;

		int blinkTimer = entity.getBlinkTimer();
		if (blinkTimer >= 7 || blinkTimer < 0)
			return;

		ResourceLocation left = entity.getResourceLocationBlink();
		if (left == null)
			return;

		ResourceLocation right = ResourceLocation.fromNamespaceAndPath(left.getNamespace(),
				left.getPath().replace("_left", "_right"));

		int color = FastColor.ARGB32.opaque(entity.lidCol);

		renderLid(poseStack, bufferSource, packedLight, left, color);
		renderLid(poseStack, bufferSource, packedLight, right, color);
	}

	private void renderLid(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ResourceLocation texture, int color)
	{
		VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(texture));
		this.getParentModel().renderToBuffer(poseStack, consumer, packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY, color);
	}
}
