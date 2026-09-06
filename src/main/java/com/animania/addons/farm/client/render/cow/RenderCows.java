package com.animania.addons.farm.client.render.cow;

import com.animania.Animania;
import com.animania.addons.farm.client.model.cow.ModelBull;
import com.animania.addons.farm.client.model.cow.ModelBullAngus;
import com.animania.addons.farm.client.model.cow.ModelBullHereford;
import com.animania.addons.farm.client.model.cow.ModelBullLonghorn;
import com.animania.addons.farm.client.model.cow.ModelCalf;
import com.animania.addons.farm.client.model.cow.ModelCalfAngus;
import com.animania.addons.farm.client.model.cow.ModelCalfLonghorn;
import com.animania.addons.farm.client.model.cow.ModelCow;
import com.animania.addons.farm.client.model.cow.ModelCowAngus;
import com.animania.addons.farm.client.model.cow.ModelCowLonghorn;
import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.animania.addons.farm.common.entity.cows.EntityBullBase;
import com.animania.addons.farm.common.entity.cows.EntityCalfBase;
import com.animania.addons.farm.common.entity.cows.EntityCowBase;
import com.animania.client.render.layer.LayerBlinkingCow;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 













public class RenderCows
{
	public static final ModelLayerLocation COW_LAYER = layer("cow");
	public static final ModelLayerLocation COW_ANGUS_LAYER = layer("cow_angus");
	public static final ModelLayerLocation COW_LONGHORN_LAYER = layer("cow_longhorn");
	public static final ModelLayerLocation BULL_LAYER = layer("bull");
	public static final ModelLayerLocation BULL_ANGUS_LAYER = layer("bull_angus");
	public static final ModelLayerLocation BULL_HEREFORD_LAYER = layer("bull_hereford");
	public static final ModelLayerLocation BULL_LONGHORN_LAYER = layer("bull_longhorn");
	public static final ModelLayerLocation CALF_LAYER = layer("calf");
	public static final ModelLayerLocation CALF_ANGUS_LAYER = layer("calf_angus");
	public static final ModelLayerLocation CALF_LONGHORN_LAYER = layer("calf_longhorn");

	private static ModelLayerLocation layer(String name)
	{
		return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, name), "main");
	}

	public static abstract class RenderCowBase<T extends EntityAnimaniaCow, M extends EntityModel<T>> extends MobRenderer<T, M>
	{
		private final float breedScale;

		public RenderCowBase(EntityRendererProvider.Context context, M model, float shadowRadius, float breedScale)
		{
			super(context, model, shadowRadius);
			this.breedScale = breedScale;
			this.addLayer(new LayerBlinkingCow<>(this));
			 
			 
			this.addLayer(new com.animania.client.render.layer.LayerCowMooshroomMushroom<>(this));
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
			applySleepingPose(entity, poseStack, this.sleepingHeightOffset());
			super.scale(entity, poseStack, partialTick);
		}

		 





		protected float sleepingHeightOffset()
		{
			return 1.85F;
		}

		private static void applySleepingPose(EntityAnimaniaCow entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float heightOffset)
		{
			if (entity.getSleeping())
			{
				float sleepTimer = entity.getSleepTimer();
				poseStack.translate(-0.25F, entity.getBbHeight() - heightOffset - sleepTimer, -0.25F);
				poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(6.0F));
			}
		}
	}

	 
	 
	 
	 

	public static class RenderCow<T extends EntityCowBase> extends RenderCowBase<T, ModelCow<T>>
	{
		public RenderCow(EntityRendererProvider.Context context, float breedScale)
		{
			super(context, new ModelCow<>(context.bakeLayer(COW_LAYER)), 0.7F, breedScale);
		}
	}

	public static class RenderCowAngus<T extends EntityCowBase> extends RenderCowBase<T, ModelCowAngus<T>>
	{
		public RenderCowAngus(EntityRendererProvider.Context context)
		{
			super(context, new ModelCowAngus<>(context.bakeLayer(COW_ANGUS_LAYER)), 0.7F, 1.34F);
		}
	}

	public static class RenderCowLonghorn<T extends EntityCowBase> extends RenderCowBase<T, ModelCowLonghorn<T>>
	{
		public RenderCowLonghorn(EntityRendererProvider.Context context)
		{
			super(context, new ModelCowLonghorn<>(context.bakeLayer(COW_LONGHORN_LAYER)), 0.7F, 1.44F);
		}
	}

	 
	 

	public static class RenderBull<T extends EntityBullBase> extends RenderCowBase<T, ModelBull<T>>
	{
		public RenderBull(EntityRendererProvider.Context context, float breedScale)
		{
			super(context, new ModelBull<>(context.bakeLayer(BULL_LAYER)), 0.8F, breedScale);
		}
	}

	public static class RenderBullAngus<T extends EntityBullBase> extends RenderCowBase<T, ModelBullAngus<T>>
	{
		public RenderBullAngus(EntityRendererProvider.Context context)
		{
			super(context, new ModelBullAngus<>(context.bakeLayer(BULL_ANGUS_LAYER)), 0.8F, 1.4F);
		}
	}

	public static class RenderBullHereford<T extends EntityBullBase> extends RenderCowBase<T, ModelBullHereford<T>>
	{
		public RenderBullHereford(EntityRendererProvider.Context context)
		{
			super(context, new ModelBullHereford<>(context.bakeLayer(BULL_HEREFORD_LAYER)), 0.8F, 1.4F);
		}
	}

	public static class RenderBullLonghorn<T extends EntityBullBase> extends RenderCowBase<T, ModelBullLonghorn<T>>
	{
		public RenderBullLonghorn(EntityRendererProvider.Context context)
		{
			super(context, new ModelBullLonghorn<>(context.bakeLayer(BULL_LONGHORN_LAYER)), 0.8F, 1.5F);
		}
	}

	 

	public static abstract class RenderCalfBase<T extends EntityCalfBase, M extends EntityModel<T>> extends RenderCowBase<T, M>
	{
		public RenderCalfBase(EntityRendererProvider.Context context, M model)
		{
			super(context, model, 0.4F, 1.0F);
		}

		@Override
		protected float sleepingHeightOffset()
		{
			return 1.15F;
		}

		@Override
		protected void scale(T entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick)
		{
			 
			 
			 
			float age = entity.getEntityAge();
			float scale = 1.0F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderCalf<T extends EntityCalfBase> extends RenderCalfBase<T, ModelCalf<T>>
	{
		public RenderCalf(EntityRendererProvider.Context context)
		{
			super(context, new ModelCalf<>(context.bakeLayer(CALF_LAYER)));
		}
	}

	public static class RenderCalfAngus<T extends EntityCalfBase> extends RenderCalfBase<T, ModelCalfAngus<T>>
	{
		public RenderCalfAngus(EntityRendererProvider.Context context)
		{
			super(context, new ModelCalfAngus<>(context.bakeLayer(CALF_ANGUS_LAYER)));
		}
	}

	public static class RenderCalfLonghorn<T extends EntityCalfBase> extends RenderCalfBase<T, ModelCalfLonghorn<T>>
	{
		public RenderCalfLonghorn(EntityRendererProvider.Context context)
		{
			super(context, new ModelCalfLonghorn<>(context.bakeLayer(CALF_LONGHORN_LAYER)));
		}
	}
}
