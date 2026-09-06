package com.animania.addons.catsdogs.client.render.cats;

import com.animania.addons.catsdogs.common.entity.felids.EntityAnimaniaCat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;

 
public class LayerBlinkingCat<T extends EntityAnimaniaCat, M extends EntityModel<T>> extends RenderLayer<T, M>
{
	public LayerBlinkingCat(RenderLayerParent<T, M> renderer)
	{
		super(renderer);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity,
			float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	{
		if (entity.isInvisible() || entity.getBlinkTimer() < 0 || entity.getBlinkTimer() >= 7)
			return;

		ResourceLocation left = entity.getBlinkTexture();
		ResourceLocation right = ResourceLocation.fromNamespaceAndPath(left.getNamespace(), left.getPath().replace("_left", "_right"));
		int color = FastColor.ARGB32.opaque(entity.getLidColor());
		renderLid(poseStack, bufferSource, packedLight, left, color);
		renderLid(poseStack, bufferSource, packedLight, right, color);
	}

	private void renderLid(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ResourceLocation texture, int color)
	{
		VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(texture));
		this.getParentModel().renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, color);
	}
}
