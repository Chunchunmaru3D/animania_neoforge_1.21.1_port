package com.animania.addons.farm.client.render.horses;

import com.animania.addons.farm.client.model.horse.ModelDraftHorseFoal;
import com.animania.addons.farm.client.model.horse.ModelDraftHorseMare;
import com.animania.addons.farm.client.model.horse.ModelDraftHorseStallion;
import com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse;
import com.animania.addons.farm.common.entity.horses.EntityFoalBase;
import com.animania.addons.farm.common.entity.horses.EntityMareBase;
import com.animania.addons.farm.common.entity.horses.EntityStallionBase;
import com.animania.client.render.layer.LayerBlinkingHorse;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 













public class RenderHorses
{
	public static final net.minecraft.client.model.geom.ModelLayerLocation MARE_DRAFT_LAYER = layer("mare_draft");
	public static final net.minecraft.client.model.geom.ModelLayerLocation STALLION_DRAFT_LAYER = layer("stallion_draft");
	public static final net.minecraft.client.model.geom.ModelLayerLocation FOAL_DRAFT_LAYER = layer("foal_draft");

	private static net.minecraft.client.model.geom.ModelLayerLocation layer(String name)
	{
		return new net.minecraft.client.model.geom.ModelLayerLocation(
				ResourceLocation.fromNamespaceAndPath(com.animania.Animania.MODID, name), "main");
	}

	public static abstract class RenderHorseBase<T extends EntityAnimaniaHorse, M extends EntityModel<T>> extends MobRenderer<T, M>
	{
		public RenderHorseBase(EntityRendererProvider.Context context, M model, float shadowRadius)
		{
			super(context, model, shadowRadius);
			this.addLayer(new LayerBlinkingHorse<>(this));
		}

		@Override
		public ResourceLocation getTextureLocation(T entity)
		{
			return entity.getResourceLocation();
		}

		 



		protected void applySleepingPose(T entity, PoseStack poseStack, float heightOffset)
		{
			if (entity.getSleeping())
			{
				float sleepTimer = entity.getSleepTimer();
				poseStack.translate(-0.25F, entity.getBbHeight() - heightOffset - sleepTimer, -0.25F);
				poseStack.mulPose(Axis.ZP.rotationDegrees(6.0F));
			}
		}
	}

	public static class RenderMareDraftHorse<T extends EntityMareBase> extends RenderHorseBase<T, ModelDraftHorseMare<T>>
	{
		public RenderMareDraftHorse(EntityRendererProvider.Context context)
		{
			super(context, new ModelDraftHorseMare<>(context.bakeLayer(MARE_DRAFT_LAYER)), 0.8F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.72F, 0.72F, 0.72F);
			applySleepingPose(entity, poseStack, 1.95F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderStallionDraftHorse<T extends EntityStallionBase> extends RenderHorseBase<T, ModelDraftHorseStallion<T>>
	{
		public RenderStallionDraftHorse(EntityRendererProvider.Context context)
		{
			super(context, new ModelDraftHorseStallion<>(context.bakeLayer(STALLION_DRAFT_LAYER)), 0.8F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.85F, 0.85F, 0.85F);
			applySleepingPose(entity, poseStack, 1.95F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderFoalDraftHorse<T extends EntityFoalBase> extends RenderHorseBase<T, ModelDraftHorseFoal<T>>
	{
		public RenderFoalDraftHorse(EntityRendererProvider.Context context)
		{
			super(context, new ModelDraftHorseFoal<>(context.bakeLayer(FOAL_DRAFT_LAYER)), 0.4F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.4F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			applySleepingPose(entity, poseStack, 1.25F);
			super.scale(entity, poseStack, partialTick);
		}
	}
}
