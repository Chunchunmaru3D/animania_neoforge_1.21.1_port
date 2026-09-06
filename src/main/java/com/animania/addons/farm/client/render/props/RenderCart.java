package com.animania.addons.farm.client.render.props;

import com.animania.Animania;
import com.animania.addons.farm.client.model.props.ModelCart;
import com.animania.addons.farm.client.model.props.ModelCartChest;
import com.animania.addons.farm.common.entity.pullables.EntityCart;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;

 









public class RenderCart<T extends EntityCart> extends EntityRenderer<T>
{
	public static final ModelLayerLocation CART_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "cart"), "main");
	public static final ModelLayerLocation CART_CHEST_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "cart_chest"), "main");

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/cart.png");
	private static final ResourceLocation TEXTURE_CHEST = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/cart_chest.png");

	private final ModelCart<T> model;
	private final ModelCartChest<T> modelChest;

	public RenderCart(EntityRendererProvider.Context context)
	{
		super(context);
		this.model = new ModelCart<>(context.bakeLayer(CART_LAYER));
		this.modelChest = new ModelCartChest<>(context.bakeLayer(CART_CHEST_LAYER));
		this.shadowRadius = 0.5F;
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		return entity.hasChest() ? TEXTURE_CHEST : TEXTURE;
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

		VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(entity)));
		if (entity.hasChest())
		{
			this.modelChest.setupAnim(entity, 0F, 0F, entity.tickCount + partialTicks, 0F, 0F);
			this.modelChest.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
		}
		else
		{
			this.model.setupAnim(entity, 0F, 0F, entity.tickCount + partialTicks, 0F, 0F);
			this.model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
		}

		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}
}
