package com.animania.addons.farm.client.render.props;

import com.animania.Animania;
import com.animania.addons.farm.client.model.props.ModelWagon;
import com.animania.addons.farm.common.entity.pullables.EntityWagon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

 






public class RenderWagon<T extends EntityWagon> extends EntityRenderer<T>
{
	public static final ModelLayerLocation WAGON_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "wagon"), "main");

	private static final ResourceLocation TEXTURE_1 = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/wagon.png");
	private static final ResourceLocation TEXTURE_2 = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/wagon2.png");
	private static final ResourceLocation TEXTURE_3 = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/wagon3.png");

	private final ModelWagon<T> model;
	private int lastTexture = 1;

	public RenderWagon(EntityRendererProvider.Context context)
	{
		super(context);
		this.model = new ModelWagon<>(context.bakeLayer(WAGON_LAYER));
		this.shadowRadius = 1.5F;
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		long dayTime = entity.level().getDayTime() % 24000L;
		if (dayTime < 13000L)
		{
			this.lastTexture = 1;
			return TEXTURE_1;
		}
		if (entity.blinkTimer == 15)
		{
			int bob = entity.getRandom().nextInt(3);
			this.lastTexture = bob == 0 ? 1 : bob == 2 ? 2 : 3;
		}
		return switch (this.lastTexture)
		{
			case 2 -> TEXTURE_2;
			case 3 -> TEXTURE_3;
			default -> TEXTURE_1;
		};
	}

	@Override
	public void render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
	{
		poseStack.pushPose();
		poseStack.translate(0.0D, 1.6D, 0.0D);
		poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180.0F - entityYaw));

		double yPulling = entity.puller == null ? entity.getY() : entity.puller.getY();
		float difference = (float) (yPulling - entity.getY());
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(15.0F * difference));

		poseStack.scale(-1.0F, -1.0F, 1.0F);

		this.model.setupAnim(entity, 0F, 0F, entity.tickCount + partialTicks, 0F, 0F);
		VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(entity)));
		this.model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, -1);

		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}
}
