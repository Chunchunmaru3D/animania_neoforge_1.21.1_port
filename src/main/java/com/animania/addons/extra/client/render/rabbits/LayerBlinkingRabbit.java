package com.animania.addons.extra.client.render.rabbits;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit;
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

 
final class LayerBlinkingRabbit<T extends EntityAnimaniaRabbit, M extends EntityModel<T>> extends RenderLayer<T, M>
{
	private static final ResourceLocation LEFT = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/rabbits/rabbit_blink_left.png");
	private static final ResourceLocation RIGHT = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/rabbits/rabbit_blink_right.png");

	LayerBlinkingRabbit(RenderLayerParent<T, M> parent) { super(parent); }

	@Override
	public void render(PoseStack poseStack, MultiBufferSource buffers, int light, T rabbit, float limbSwing,
			float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	{
		boolean timedBlink = rabbit.getBlinkTimer() >= 0 && rabbit.getBlinkTimer() < 7;
		long time = rabbit.level().getDayTime() % 23999L;
		boolean sleepBlink = rabbit.getSleeping() && time < 23250L;
		if (rabbit.isInvisible() || (!timedBlink && !sleepBlink)) return;

		int color = FastColor.ARGB32.opaque(rabbit.getEyeColorForVariant(rabbit.getColorNumber()));
		renderLid(poseStack, buffers, light, rabbit, LEFT, color);
		renderLid(poseStack, buffers, light, rabbit, RIGHT, color);
	}

	private void renderLid(PoseStack poseStack, MultiBufferSource buffers, int light, T rabbit, ResourceLocation texture, int color)
	{
		VertexConsumer consumer = buffers.getBuffer(RenderType.entityTranslucent(texture));
		this.getParentModel().renderToBuffer(poseStack, consumer, light, LivingEntityRenderer.getOverlayCoords(rabbit, 0), color);
	}
}
