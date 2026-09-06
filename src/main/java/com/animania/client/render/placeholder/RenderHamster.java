package com.animania.client.render.placeholder;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.rodents.EntityHamster;
import com.animania.client.model.placeholder.ModelHamster;
import com.animania.client.model.placeholder.ModelHamsterBall;
import com.animania.client.render.layer.LayerHamsterBall;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderHamster extends MobRenderer<EntityHamster, ModelHamster<EntityHamster>>
{
	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "hamster"), "main");
	public static final ModelLayerLocation BALL_LAYER =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "hamster_ball"), "main");

	public RenderHamster(EntityRendererProvider.Context context)
	{
		super(context, new ModelHamster<>(context.bakeLayer(LAYER)), 0.2F);
		this.addLayer(new LayerHamsterBall(this, new ModelHamsterBall(context.bakeLayer(BALL_LAYER))));
	}

	@Override
	public void render(EntityHamster entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight)
	{
		this.getModel().foodStackCount = entity.getFoodStackCount();
		super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
	}

	 





	@Override
	protected void scale(EntityHamster entity, PoseStack poseStack, float partialTickTime)
	{
		poseStack.scale(0.4F, 0.4F, 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityHamster entity)
	{
		return entity.getResourceLocation();
	}
}
