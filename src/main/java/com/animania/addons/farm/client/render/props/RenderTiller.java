package com.animania.addons.farm.client.render.props;

import com.animania.Animania;
import com.animania.addons.farm.client.model.props.ModelTiller;
import com.animania.addons.farm.common.entity.pullables.EntityTiller;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

 


public class RenderTiller<T extends EntityTiller> extends EntityRenderer<T>
{
	public static final ModelLayerLocation TILLER_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "tiller"), "main");

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/tiller.png");

	private final ModelTiller<T> model;

	public RenderTiller(EntityRendererProvider.Context context)
	{
		super(context);
		this.model = new ModelTiller<>(context.bakeLayer(TILLER_LAYER));
		this.shadowRadius = 0.6F;
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		return TEXTURE;
	}

	@Override
	public void render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
	{
		poseStack.pushPose();
		poseStack.translate(0.0D, 1.5D, 0.0D);
		poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180.0F - entityYaw));

		double yPulling = entity.puller == null ? entity.getY() : entity.puller.getY();
		float difference = (float) (yPulling - entity.getY());
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(25.0F * difference));

		poseStack.scale(-1.0F, -1.0F, 1.0F);

		this.model.setupAnim(entity, 0F, 0F, entity.tickCount + partialTicks, 0F, 0F);
		VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(entity)));
		this.model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, -1);

		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}
}
