package com.animania.addons.farm.client.render.pig;

import com.animania.Animania;
import com.animania.addons.farm.client.model.pig.ModelHog;
import com.animania.addons.farm.client.model.pig.ModelHogHampshire;
import com.animania.addons.farm.client.model.pig.ModelHogLargeBlack;
import com.animania.addons.farm.client.model.pig.ModelPiglet;
import com.animania.addons.farm.client.model.pig.ModelPigletHampshire;
import com.animania.addons.farm.client.model.pig.ModelSow;
import com.animania.addons.farm.client.model.pig.ModelSowHampshire;
import com.animania.addons.farm.client.model.pig.ModelSowLargeBlack;
import com.animania.addons.farm.common.entity.pigs.EntityAnimaniaPig;
import com.animania.addons.farm.common.entity.pigs.EntityHogBase;
import com.animania.addons.farm.common.entity.pigs.EntityPigletBase;
import com.animania.addons.farm.common.entity.pigs.EntitySowBase;
import com.animania.client.render.layer.LayerBlinkingPig;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 












public class RenderPigs
{
	public static final ModelLayerLocation SOW_LAYER = layer("sow");
	public static final ModelLayerLocation SOW_HAMPSHIRE_LAYER = layer("sow_hampshire");
	public static final ModelLayerLocation SOW_LARGE_BLACK_LAYER = layer("sow_large_black");
	public static final ModelLayerLocation HOG_LAYER = layer("hog");
	public static final ModelLayerLocation HOG_HAMPSHIRE_LAYER = layer("hog_hampshire");
	public static final ModelLayerLocation HOG_LARGE_BLACK_LAYER = layer("hog_large_black");
	public static final ModelLayerLocation PIGLET_LAYER = layer("piglet");
	public static final ModelLayerLocation PIGLET_HAMPSHIRE_LAYER = layer("piglet_hampshire");

	private static ModelLayerLocation layer(String name)
	{
		return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, name), "main");
	}

	public static abstract class RenderPigBase<T extends EntityAnimaniaPig, M extends EntityModel<T>> extends MobRenderer<T, M>
	{
		public RenderPigBase(EntityRendererProvider.Context context, M model, float shadowRadius)
		{
			super(context, model, shadowRadius);
			this.addLayer(new LayerBlinkingPig<>(this));
		}

		@Override
		public ResourceLocation getTextureLocation(T entity)
		{
			return entity.getMuddy() ? entity.getMuddyResourceLocation() : entity.getResourceLocation();
		}

		 


		protected void applySleepingPose(T entity, PoseStack poseStack)
		{
			if (entity.getSleeping())
			{
				poseStack.translate(0.0F, entity.getBbHeight() - 1.25F, 0.0F);
				poseStack.mulPose(Axis.ZP.rotationDegrees(86.0F));
			}
		}
	}

	 

	public static abstract class RenderSowBase<T extends EntitySowBase, M extends EntityModel<T>> extends RenderPigBase<T, M>
	{
		private final float breedScale;

		public RenderSowBase(EntityRendererProvider.Context context, M model, float breedScale)
		{
			super(context, model, 0.5F);
			this.breedScale = breedScale;
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(this.breedScale, this.breedScale, this.breedScale);
			applySleepingPose(entity, poseStack);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderSow<T extends EntitySowBase> extends RenderSowBase<T, ModelSow<T>>
	{
		public RenderSow(EntityRendererProvider.Context context, float breedScale)
		{
			super(context, new ModelSow<>(context.bakeLayer(SOW_LAYER)), breedScale);
		}
	}

	public static class RenderSowHampshire<T extends EntitySowBase> extends RenderSowBase<T, ModelSowHampshire<T>>
	{
		public RenderSowHampshire(EntityRendererProvider.Context context)
		{
			super(context, new ModelSowHampshire<>(context.bakeLayer(SOW_HAMPSHIRE_LAYER)), 1.02F);
		}
	}

	public static class RenderSowLargeBlack<T extends EntitySowBase> extends RenderSowBase<T, ModelSowLargeBlack<T>>
	{
		public RenderSowLargeBlack(EntityRendererProvider.Context context)
		{
			super(context, new ModelSowLargeBlack<>(context.bakeLayer(SOW_LARGE_BLACK_LAYER)), 1.14F);
		}
	}

	 

	public static abstract class RenderHogBase<T extends EntityHogBase, M extends EntityModel<T>> extends RenderPigBase<T, M>
	{
		private final float breedScale;

		public RenderHogBase(EntityRendererProvider.Context context, M model, float breedScale)
		{
			super(context, model, 0.5F);
			this.breedScale = breedScale;
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(this.breedScale, this.breedScale, this.breedScale);
			applySleepingPose(entity, poseStack);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderHog<T extends EntityHogBase> extends RenderHogBase<T, ModelHog<T>>
	{
		public RenderHog(EntityRendererProvider.Context context, float breedScale)
		{
			super(context, new ModelHog<>(context.bakeLayer(HOG_LAYER)), breedScale);
		}
	}

	public static class RenderHogHampshire<T extends EntityHogBase> extends RenderHogBase<T, ModelHogHampshire<T>>
	{
		public RenderHogHampshire(EntityRendererProvider.Context context)
		{
			super(context, new ModelHogHampshire<>(context.bakeLayer(HOG_HAMPSHIRE_LAYER)), 1.12F);
		}
	}

	public static class RenderHogLargeBlack<T extends EntityHogBase> extends RenderHogBase<T, ModelHogLargeBlack<T>>
	{
		public RenderHogLargeBlack(EntityRendererProvider.Context context)
		{
			super(context, new ModelHogLargeBlack<>(context.bakeLayer(HOG_LARGE_BLACK_LAYER)), 1.20F);
		}
	}

	 

	public static abstract class RenderPigletBase<T extends EntityPigletBase, M extends EntityModel<T>> extends RenderPigBase<T, M>
	{
		private final float breedBase;

		public RenderPigletBase(EntityRendererProvider.Context context, M model, float breedBase)
		{
			super(context, model, 0.3F);
			this.breedBase = breedBase;
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			 
			float age = entity.getEntityAge();
			float scale = this.breedBase + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);

			if (entity.getSleeping())
			{
				poseStack.translate(0.0F, entity.getBbHeight() - 0.70F + age * 0.1F, 0.0F);
				poseStack.mulPose(Axis.ZP.rotationDegrees(86.0F));
			}

			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderPiglet<T extends EntityPigletBase> extends RenderPigletBase<T, ModelPiglet<T>>
	{
		public RenderPiglet(EntityRendererProvider.Context context, float breedBase)
		{
			super(context, new ModelPiglet<>(context.bakeLayer(PIGLET_LAYER)), breedBase);
		}
	}

	public static class RenderPigletHampshire<T extends EntityPigletBase> extends RenderPigletBase<T, ModelPigletHampshire<T>>
	{
		public RenderPigletHampshire(EntityRendererProvider.Context context)
		{
			super(context, new ModelPigletHampshire<>(context.bakeLayer(PIGLET_HAMPSHIRE_LAYER)), 1.12F);
		}
	}
}
