package com.animania.client.render.layer;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.rodents.EntityHamster;
import com.animania.addons.extra.common.item.ItemHamsterBall;
import com.animania.client.model.placeholder.ModelHamster;
import com.animania.client.model.placeholder.ModelHamsterBall;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;

 
public class LayerHamsterBall extends RenderLayer<EntityHamster, ModelHamster<EntityHamster>>
{
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID,
			"textures/entity/rodents/hamster_ball.png");
	private static final float[][] COLORS = {
			{ .1F, .1F, .1F }, { 1.0F, 0.0F, 0.0F }, { .4F, .49F, .2F }, { .6F, .49F, .2F },
			{ .2F, .5F, 1.0F }, { .5F, .25F, .7F }, { .28F, .5F, .6F }, { .6F, .6F, .6F },
			{ .3F, .3F, .3F }, { .95F, .5F, .65F }, { .5F, .8F, .01F }, { 1.0F, 1.0F, 0.0F },
			{ .4F, .6F, .847F }, { .7F, .3F, .85F }, { .85F, .5F, .2F }, { 1.0F, 1.0F, 1.0F }
	};

	private final ModelHamsterBall ball;

	public LayerHamsterBall(RenderLayerParent<EntityHamster, ModelHamster<EntityHamster>> parent, ModelHamsterBall ball)
	{
		super(parent);
		this.ball = ball;
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource buffers, int packedLight, EntityHamster hamster,
			float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	{
		if (!hamster.isInBall() || hamster.isInvisible())
			return;

		int ballColor = hamster.getBallColor();
		float[] rgb = ballColor == ItemHamsterBall.CLEAR_COLOR ? COLORS[15] : COLORS[Math.floorMod(ballColor, COLORS.length)];
		int color = FastColor.ARGB32.color(255, (int) (rgb[0] * 255.0F), (int) (rgb[1] * 255.0F), (int) (rgb[2] * 255.0F));
		VertexConsumer consumer = buffers.getBuffer(RenderType.entityTranslucent(TEXTURE));

		poseStack.pushPose();
		poseStack.translate(0.0F, 1.0F, 0.0F);
		poseStack.mulPose(Axis.XP.rotationDegrees((int) limbSwing * 20.0F));
		poseStack.translate(-0.1F, -1.9F, 0.0F);
		poseStack.scale(1.7F, 1.7F, 1.7F);
		this.ball.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, color);
		poseStack.popPose();
	}
}
