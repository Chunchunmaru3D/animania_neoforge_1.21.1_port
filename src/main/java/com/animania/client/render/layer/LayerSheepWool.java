package com.animania.client.render.layer;

import java.util.function.BiConsumer;

import com.animania.addons.farm.common.entity.sheep.EntityAnimaniaSheep;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.DyeColor;

 













public class LayerSheepWool<T extends EntityAnimaniaSheep, M extends EntityModel<T>> extends RenderLayer<T, M>
{
	private final RenderWoolCallback<M> renderWool;

	public LayerSheepWool(RenderLayerParent<T, M> renderer, RenderWoolCallback<M> renderWool)
	{
		super(renderer);
		this.renderWool = renderWool;
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity,
			float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	{
		if (entity.isInvisible() || entity.getSheared() || !entity.isDyeable())
			return;

		int color;

		 
		 
		 
		 
		if (entity.hasCustomName() && "jeb_".equals(entity.getCustomName().getString()))
		{
			int colorCount = DyeColor.values().length;
			int i = entity.tickCount / 25 + entity.getId();
			int k = i % colorCount;
			int l = (i + 1) % colorCount;
			float q = ((float) (entity.tickCount % 25) + partialTick) / 25.0F;
			 
			 
			int c1 = DyeColor.byId(k).getTextureDiffuseColor();
			int c2 = DyeColor.byId(l).getTextureDiffuseColor();
			int r = (int) (((c1 >> 16) & 0xFF) * (1.0F - q) + ((c2 >> 16) & 0xFF) * q);
			int g = (int) (((c1 >> 8) & 0xFF) * (1.0F - q) + ((c2 >> 8) & 0xFF) * q);
			int b = (int) ((c1 & 0xFF) * (1.0F - q) + (c2 & 0xFF) * q);
			color = FastColor.ARGB32.color(255, r, g, b);
		}
		else
		{
			DyeColor dye = entity.getDyeColor();
			if (dye == DyeColor.WHITE)
				return;  
			int rgb = dye.getTextureDiffuseColor();
			color = FastColor.ARGB32.color(255, (rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF);
		}

		ResourceLocation texture = entity.getResourceLocation();
		VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(texture));
		this.renderWool.render(this.getParentModel(), poseStack, consumer, packedLight,
				net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY, color);
	}

	@FunctionalInterface
	public interface RenderWoolCallback<M>
	{
		void render(M model, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color);
	}
}
