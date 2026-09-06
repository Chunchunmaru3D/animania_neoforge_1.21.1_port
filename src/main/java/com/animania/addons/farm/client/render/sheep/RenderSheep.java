package com.animania.addons.farm.client.render.sheep;

import com.animania.Animania;
import com.animania.addons.farm.client.model.sheep.ModelDorperSheep;
import com.animania.addons.farm.client.model.sheep.ModelDorsetEwe;
import com.animania.addons.farm.client.model.sheep.ModelDorsetRam;
import com.animania.addons.farm.client.model.sheep.ModelFriesianSheep;
import com.animania.addons.farm.client.model.sheep.ModelJacobSheep;
import com.animania.addons.farm.client.model.sheep.ModelMerinoEwe;
import com.animania.addons.farm.client.model.sheep.ModelMerinoRam;
import com.animania.addons.farm.client.model.sheep.ModelSuffolkEwe;
import com.animania.addons.farm.client.model.sheep.ModelSuffolkRam;
import com.animania.addons.farm.common.entity.sheep.EntityAnimaniaSheep;
import com.animania.addons.farm.common.entity.sheep.EntityLambBase;
import com.animania.client.render.layer.LayerBlinkingSheep;
import com.animania.client.render.layer.LayerSheepWool;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 





public class RenderSheep
{
	public static final ModelLayerLocation DORPER_LAYER = layer("dorper");
	public static final ModelLayerLocation DORSET_EWE_LAYER = layer("dorset_ewe");
	public static final ModelLayerLocation DORSET_RAM_LAYER = layer("dorset_ram");
	public static final ModelLayerLocation FRIESIAN_LAYER = layer("friesian");
	public static final ModelLayerLocation JACOB_LAYER = layer("jacob");
	public static final ModelLayerLocation MERINO_EWE_LAYER = layer("merino_ewe");
	public static final ModelLayerLocation MERINO_RAM_LAYER = layer("merino_ram");
	public static final ModelLayerLocation SUFFOLK_EWE_LAYER = layer("suffolk_ewe");
	public static final ModelLayerLocation SUFFOLK_RAM_LAYER = layer("suffolk_ram");

	private static ModelLayerLocation layer(String name)
	{
		return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, name), "main");
	}

	public static abstract class RenderSheepBase<T extends EntityAnimaniaSheep, M extends EntityModel<T>> extends MobRenderer<T, M>
	{
		private final float breedScale;

		public RenderSheepBase(EntityRendererProvider.Context context, M model, float shadowRadius,
				LayerSheepWool.RenderWoolCallback<M> renderWool, float breedScale)
		{
			super(context, model, shadowRadius);
			this.breedScale = breedScale;
			this.addLayer(new LayerBlinkingSheep<>(this));
			this.addLayer(new LayerSheepWool<>(this, renderWool));
		}

		@Override
		public ResourceLocation getTextureLocation(T entity)
		{
			return entity.getResourceLocation();
		}

		@Override
		protected void scale(T entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick)
		{
			poseStack.scale(this.breedScale, this.breedScale, this.breedScale);
			applySleepingPose(entity, poseStack, this.sleepingHeightOffset(entity));
			super.scale(entity, poseStack, partialTick);
		}

		 




		protected float sleepingHeightOffset(T entity)
		{
			return 1.05F;
		}

		private static void applySleepingPose(EntityAnimaniaSheep entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float heightOffset)
		{
			if (entity.getSleeping())
			{
				float sleepTimer = entity.getSleepTimer();
				poseStack.translate(-0.25F, entity.getBbHeight() - heightOffset - sleepTimer, -0.25F);
				poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(6.0F));
			}
		}
	}

	 
	 
	 

	public static class RenderDorper<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelDorperSheep<T>>
	{
		public RenderDorper(EntityRendererProvider.Context context, float breedScale)
		{
			super(context, new ModelDorperSheep<>(context.bakeLayer(DORPER_LAYER)), 0.5F, ModelDorperSheep::renderWool, breedScale);
		}

		@Override
		protected float sleepingHeightOffset(T entity)
		{
			 
			 
			 
			return entity.getEntityGender() == com.animania.api.data.EntityGender.MALE ? 1.05F : 0.85F;
		}
	}

	public static class RenderDorsetEwe<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelDorsetEwe<T>>
	{
		public RenderDorsetEwe(EntityRendererProvider.Context context)
		{
			super(context, new ModelDorsetEwe<>(context.bakeLayer(DORSET_EWE_LAYER)), 0.5F, ModelDorsetEwe::renderWool, 0.58F);
		}
	}

	public static class RenderDorsetRam<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelDorsetRam<T>>
	{
		public RenderDorsetRam(EntityRendererProvider.Context context)
		{
			super(context, new ModelDorsetRam<>(context.bakeLayer(DORSET_RAM_LAYER)), 0.5F, ModelDorsetRam::renderWool, 0.62F);
		}
	}

	public static class RenderFriesian<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelFriesianSheep<T>>
	{
		public RenderFriesian(EntityRendererProvider.Context context, float breedScale)
		{
			super(context, new ModelFriesianSheep<>(context.bakeLayer(FRIESIAN_LAYER)), 0.5F, ModelFriesianSheep::renderWool, breedScale);
		}
	}

	public static class RenderJacob<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelJacobSheep<T>>
	{
		public RenderJacob(EntityRendererProvider.Context context, float breedScale)
		{
			super(context, new ModelJacobSheep<>(context.bakeLayer(JACOB_LAYER)), 0.5F, ModelJacobSheep::renderWool, breedScale);
		}
	}

	public static class RenderMerinoEwe<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelMerinoEwe<T>>
	{
		public RenderMerinoEwe(EntityRendererProvider.Context context)
		{
			super(context, new ModelMerinoEwe<>(context.bakeLayer(MERINO_EWE_LAYER)), 0.5F, ModelMerinoEwe::renderWool, 0.53F);
		}
	}

	public static class RenderMerinoRam<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelMerinoRam<T>>
	{
		public RenderMerinoRam(EntityRendererProvider.Context context)
		{
			super(context, new ModelMerinoRam<>(context.bakeLayer(MERINO_RAM_LAYER)), 0.5F, ModelMerinoRam::renderWool, 0.56F);
		}
	}

	public static class RenderSuffolkEwe<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelSuffolkEwe<T>>
	{
		public RenderSuffolkEwe(EntityRendererProvider.Context context)
		{
			super(context, new ModelSuffolkEwe<>(context.bakeLayer(SUFFOLK_EWE_LAYER)), 0.5F, ModelSuffolkEwe::renderWool, 0.64F);
		}
	}

	public static class RenderSuffolkRam<T extends EntityAnimaniaSheep> extends RenderSheepBase<T, ModelSuffolkRam<T>>
	{
		public RenderSuffolkRam(EntityRendererProvider.Context context)
		{
			super(context, new ModelSuffolkRam<>(context.bakeLayer(SUFFOLK_RAM_LAYER)), 0.5F, ModelSuffolkRam::renderWool, 0.68F);
		}
	}

	 
	 
	 
	 
	 

	public static abstract class RenderLambBase<T extends EntityLambBase, M extends EntityModel<T>> extends RenderSheepBase<T, M>
	{
		private final float base;

		public RenderLambBase(EntityRendererProvider.Context context, M model, LayerSheepWool.RenderWoolCallback<M> renderWool, float base)
		{
			super(context, model, 0.3F, renderWool, 1.0F);
			this.base = base;
		}

		@Override
		protected void scale(T entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = this.base + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			 
			 
			if (entity.getSleeping())
			{
				float sleepTimer = entity.getSleepTimer();
				poseStack.translate(-0.25F, entity.getBbHeight() - 0.45F - sleepTimer, -0.25F);
				poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(6.0F));
			}
		}
	}

	public static class RenderLambDorper<T extends EntityLambBase> extends RenderLambBase<T, ModelDorperSheep<T>>
	{
		public RenderLambDorper(EntityRendererProvider.Context context)
		{
			super(context, new ModelDorperSheep<>(context.bakeLayer(DORPER_LAYER)), ModelDorperSheep::renderWool, 0.30F);
		}
	}

	public static class RenderLambDorset<T extends EntityLambBase> extends RenderLambBase<T, ModelDorsetEwe<T>>
	{
		public RenderLambDorset(EntityRendererProvider.Context context)
		{
			super(context, new ModelDorsetEwe<>(context.bakeLayer(DORSET_EWE_LAYER)), ModelDorsetEwe::renderWool, 0.30F);
		}
	}

	public static class RenderLambFriesian<T extends EntityLambBase> extends RenderLambBase<T, ModelFriesianSheep<T>>
	{
		public RenderLambFriesian(EntityRendererProvider.Context context)
		{
			super(context, new ModelFriesianSheep<>(context.bakeLayer(FRIESIAN_LAYER)), ModelFriesianSheep::renderWool, 0.33F);
		}
	}

	public static class RenderLambJacob<T extends EntityLambBase> extends RenderLambBase<T, ModelJacobSheep<T>>
	{
		public RenderLambJacob(EntityRendererProvider.Context context)
		{
			super(context, new ModelJacobSheep<>(context.bakeLayer(JACOB_LAYER)), ModelJacobSheep::renderWool, 0.22F);
		}
	}

	public static class RenderLambMerino<T extends EntityLambBase> extends RenderLambBase<T, ModelMerinoEwe<T>>
	{
		public RenderLambMerino(EntityRendererProvider.Context context)
		{
			super(context, new ModelMerinoEwe<>(context.bakeLayer(MERINO_EWE_LAYER)), ModelMerinoEwe::renderWool, 0.24F);
		}
	}

	public static class RenderLambSuffolk<T extends EntityLambBase> extends RenderLambBase<T, ModelSuffolkEwe<T>>
	{
		public RenderLambSuffolk(EntityRendererProvider.Context context)
		{
			super(context, new ModelSuffolkEwe<>(context.bakeLayer(SUFFOLK_EWE_LAYER)), ModelSuffolkEwe::renderWool, 0.32F);
		}

		@Override
		protected void scale(T entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick)
		{
			 
			 
			poseStack.scale(0.32F, 0.32F, 0.32F);
			if (entity.getSleeping())
			{
				float sleepTimer = entity.getSleepTimer();
				poseStack.translate(-0.25F, entity.getBbHeight() - 0.45F - sleepTimer, -0.25F);
				poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(6.0F));
			}
		}
	}
}
