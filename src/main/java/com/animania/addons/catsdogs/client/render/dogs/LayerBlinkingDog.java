package com.animania.addons.catsdogs.client.render.dogs;

import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
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

 
final class LayerBlinkingDog<T extends EntityAnimaniaDog, M extends EntityModel<T>> extends RenderLayer<T, M>
{
	LayerBlinkingDog(RenderLayerParent<T, M> renderer) { super(renderer); }

	@Override
	public void render(PoseStack poseStack, MultiBufferSource buffers, int light, T dog, float limbSwing,
			float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	{
		boolean timedBlink = dog.getBlinkTimer() >= 0 && dog.getBlinkTimer() < 7;
		long time = dog.level().getDayTime() % 23999L;
		float sleepTimer = dog.getSleepTimer();
		boolean sleepBlink = dog.getSleeping() && time < 23250L
				&& (sleepTimer == -100F || sleepTimer == 0F || sleepTimer <= -.55F);
		if (dog.isInvisible() || (!timedBlink && !sleepBlink)) return;

		 
		 
		String blink = switch (dog.type)
		{
			case BLOODHOUND -> "blood_hound";
			case COLLIE, GERMAN_SHEPHERD, GREAT_DANE, HUSKY, LABRADOR, WOLF -> "collie";
			default -> dog.type.name().toLowerCase(java.util.Locale.ROOT);
		};
		ResourceLocation texture = ResourceLocation.fromNamespaceAndPath("animania",
				"textures/entity/dogs/blink_" + blink + ".png");
		VertexConsumer consumer = buffers.getBuffer(RenderType.entityTranslucent(texture));
		int color = dog.getBlinkColor();
		if (dog.type.name().equals("FOX") && dog.getName().getString().equalsIgnoreCase("razz"))
			color = 0xA81348;
		this.getParentModel().renderToBuffer(poseStack, consumer, light, OverlayTexture.NO_OVERLAY,
				FastColor.ARGB32.opaque(color));
	}
}
