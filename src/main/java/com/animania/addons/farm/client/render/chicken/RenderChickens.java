package com.animania.addons.farm.client.render.chicken;

import com.animania.Animania;
import com.animania.addons.farm.client.model.chicken.ModelChick;
import com.animania.addons.farm.client.model.chicken.ModelHen;
import com.animania.addons.farm.client.model.chicken.ModelRooster;
import com.animania.addons.farm.common.entity.chickens.EntityAnimaniaChicken;
import com.animania.addons.farm.common.entity.chickens.EntityChickBase;
import com.animania.addons.farm.common.entity.chickens.EntityHenBase;
import com.animania.addons.farm.common.entity.chickens.EntityRoosterBase;
import com.animania.client.render.layer.LayerBlinking;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

 





public class RenderChickens
{
	public static final ModelLayerLocation HEN_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "hen"), "main");
	public static final ModelLayerLocation ROOSTER_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "rooster"), "main");
	public static final ModelLayerLocation CHICK_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "chick"), "main");

	 


	private static void applySleepingPose(EntityAnimaniaChicken entity, PoseStack poseStack)
	{
		if (entity.getSleeping())
			poseStack.translate(-0.25F, 0.35F, -0.25F);
	}

	 


	public static abstract class RenderChickenBase<T extends EntityAnimaniaChicken, M extends EntityModel<T>> extends MobRenderer<T, M>
	{
		public RenderChickenBase(EntityRendererProvider.Context context, M model, float shadowRadius)
		{
			super(context, model, shadowRadius);
			this.addLayer(new LayerBlinking<>(this));
		}

		@Override
		public ResourceLocation getTextureLocation(T entity)
		{
			return entity.getResourceLocation();
		}

		@Override
		protected float getBob(T entity, float partialTicks)
		{
			float f = Mth.lerp(partialTicks, entity.oFlap, entity.flap);
			float f1 = Mth.lerp(partialTicks, entity.oFlapSpeed, entity.flapSpeed);
			return (Mth.sin(f) + 1.0F) * f1;
		}
	}

	public static class RenderHen<T extends EntityHenBase> extends RenderChickenBase<T, ModelHen<T>>
	{
		public RenderHen(EntityRendererProvider.Context context)
		{
			super(context, new ModelHen<>(context.bakeLayer(HEN_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.9F, 0.9F, 0.9F);
			applySleepingPose(entity, poseStack);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderRooster<T extends EntityRoosterBase> extends RenderChickenBase<T, ModelRooster<T>>
	{
		private static final ResourceLocation DUCKTONIO = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/chickens/rooster_antonio.png");

		public RenderRooster(EntityRendererProvider.Context context)
		{
			super(context, new ModelRooster<>(context.bakeLayer(ROOSTER_LAYER)), 0.32F);
		}

		@Override
		public ResourceLocation getTextureLocation(T entity)
		{
			 
			if (entity.hasCustomName() && "Ducktonio".equals(entity.getCustomName().getString()))
				return DUCKTONIO;
			return super.getTextureLocation(entity);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			if (entity.hasCustomName() && "Ducktonio".equals(entity.getCustomName().getString()))
				poseStack.scale(1.5F, 1.5F, 1.5F);
			applySleepingPose(entity, poseStack);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderChick<T extends EntityChickBase> extends RenderChickenBase<T, ModelChick<T>>
	{
		public RenderChick(EntityRendererProvider.Context context)
		{
			super(context, new ModelChick<>(context.bakeLayer(CHICK_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			 
			float age = entity.getEntityAge();
			float scale = 1.0F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			super.scale(entity, poseStack, partialTick);
		}
	}
}
