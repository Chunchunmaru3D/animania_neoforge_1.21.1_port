package com.animania.addons.farm.client.render.goats;

import com.animania.Animania;
import com.animania.addons.farm.client.model.goats.ModelBuckAlpine;
import com.animania.addons.farm.client.model.goats.ModelDoeAlpine;
import com.animania.addons.farm.client.model.goats.ModelKidAlpine;
import com.animania.addons.farm.client.model.goats.ModelBuckAngora;
import com.animania.addons.farm.client.model.goats.ModelDoeAngora;
import com.animania.addons.farm.client.model.goats.ModelKidAngora;
import com.animania.addons.farm.client.model.goats.ModelBuckFainting;
import com.animania.addons.farm.client.model.goats.ModelDoeFainting;
import com.animania.addons.farm.client.model.goats.ModelKidFainting;
import com.animania.addons.farm.client.model.goats.ModelBuckKiko;
import com.animania.addons.farm.client.model.goats.ModelDoeKiko;
import com.animania.addons.farm.client.model.goats.ModelKidKiko;
import com.animania.addons.farm.client.model.goats.ModelBuckKinder;
import com.animania.addons.farm.client.model.goats.ModelDoeKinder;
import com.animania.addons.farm.client.model.goats.ModelKidKinder;
import com.animania.addons.farm.client.model.goats.ModelBuckNigerianDwarf;
import com.animania.addons.farm.client.model.goats.ModelDoeNigerianDwarf;
import com.animania.addons.farm.client.model.goats.ModelKidNigerianDwarf;
import com.animania.addons.farm.client.model.goats.ModelBuckPygmy;
import com.animania.addons.farm.client.model.goats.ModelDoePygmy;
import com.animania.addons.farm.client.model.goats.ModelKidPygmy;
import com.animania.addons.farm.common.entity.goats.EntityAnimaniaGoat;
import com.animania.addons.farm.common.entity.goats.EntityBuckBase;
import com.animania.addons.farm.common.entity.goats.EntityDoeBase;
import com.animania.addons.farm.common.entity.goats.EntityKidBase;
import com.animania.client.render.layer.LayerBlinkingGoat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 











public class RenderGoats
{
	public static final ModelLayerLocation DOE_ALPINE_LAYER = layer("doe_alpine");
	public static final ModelLayerLocation BUCK_ALPINE_LAYER = layer("buck_alpine");
	public static final ModelLayerLocation KID_ALPINE_LAYER = layer("kid_alpine");
	public static final ModelLayerLocation DOE_ANGORA_LAYER = layer("doe_angora");
	public static final ModelLayerLocation BUCK_ANGORA_LAYER = layer("buck_angora");
	public static final ModelLayerLocation KID_ANGORA_LAYER = layer("kid_angora");
	public static final ModelLayerLocation DOE_FAINTING_LAYER = layer("doe_fainting");
	public static final ModelLayerLocation BUCK_FAINTING_LAYER = layer("buck_fainting");
	public static final ModelLayerLocation KID_FAINTING_LAYER = layer("kid_fainting");
	public static final ModelLayerLocation DOE_KIKO_LAYER = layer("doe_kiko");
	public static final ModelLayerLocation BUCK_KIKO_LAYER = layer("buck_kiko");
	public static final ModelLayerLocation KID_KIKO_LAYER = layer("kid_kiko");
	public static final ModelLayerLocation DOE_KINDER_LAYER = layer("doe_kinder");
	public static final ModelLayerLocation BUCK_KINDER_LAYER = layer("buck_kinder");
	public static final ModelLayerLocation KID_KINDER_LAYER = layer("kid_kinder");
	public static final ModelLayerLocation DOE_NIGERIAN_DWARF_LAYER = layer("doe_nigerian_dwarf");
	public static final ModelLayerLocation BUCK_NIGERIAN_DWARF_LAYER = layer("buck_nigerian_dwarf");
	public static final ModelLayerLocation KID_NIGERIAN_DWARF_LAYER = layer("kid_nigerian_dwarf");
	public static final ModelLayerLocation DOE_PYGMY_LAYER = layer("doe_pygmy");
	public static final ModelLayerLocation BUCK_PYGMY_LAYER = layer("buck_pygmy");
	public static final ModelLayerLocation KID_PYGMY_LAYER = layer("kid_pygmy");

	private static ModelLayerLocation layer(String name)
	{
		return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, name), "main");
	}

	public static abstract class RenderGoatBase<T extends EntityAnimaniaGoat, M extends EntityModel<T>> extends MobRenderer<T, M>
	{
		public RenderGoatBase(EntityRendererProvider.Context context, M model, float shadowRadius)
		{
			super(context, model, shadowRadius);
			this.addLayer(new LayerBlinkingGoat<>(this));
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

		 





		protected boolean applyFaintingPose(T entity, PoseStack poseStack, float tipHeightOffset)
		{
			if (!entity.getSleeping() && entity.getSpooked() && entity.getSpookedTimer() < 0.94F && entity.getSpookedTimer() > 0.06F)
			{
				poseStack.translate(0.0F, entity.getBbHeight() - tipHeightOffset, 0.0F);
				poseStack.mulPose(Axis.ZP.rotationDegrees(86.0F));
				return true;
			}
			return false;
		}
	}

	 

	public static class RenderDoeAlpine<T extends EntityDoeBase> extends RenderGoatBase<T, ModelDoeAlpine<T>>
	{
		public RenderDoeAlpine(EntityRendererProvider.Context context)
		{
			super(context, new ModelDoeAlpine<>(context.bakeLayer(DOE_ALPINE_LAYER)), 0.5F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.6F, 0.6F, 0.6F);
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderBuckAlpine<T extends EntityBuckBase> extends RenderGoatBase<T, ModelBuckAlpine<T>>
	{
		public RenderBuckAlpine(EntityRendererProvider.Context context)
		{
			super(context, new ModelBuckAlpine<>(context.bakeLayer(BUCK_ALPINE_LAYER)), 0.5F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.67F, 0.67F, 0.67F);
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	 

	public static class RenderKidAlpine<T extends EntityKidBase> extends RenderGoatBase<T, ModelKidAlpine<T>>
	{
		public RenderKidAlpine(EntityRendererProvider.Context context)
		{
			super(context, new ModelKidAlpine<>(context.bakeLayer(KID_ALPINE_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.33F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			applySleepingPose(entity, poseStack, 0.5F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	 

	public static class RenderDoeAngora<T extends EntityDoeBase> extends RenderGoatBase<T, ModelDoeAngora<T>>
	{
		public RenderDoeAngora(EntityRendererProvider.Context context)
		{
			super(context, new ModelDoeAngora<>(context.bakeLayer(DOE_ANGORA_LAYER)), 0.5F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.58F, 0.58F, 0.58F);
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderBuckAngora<T extends EntityBuckBase> extends RenderGoatBase<T, ModelBuckAngora<T>>
	{
		public RenderBuckAngora(EntityRendererProvider.Context context)
		{
			super(context, new ModelBuckAngora<>(context.bakeLayer(BUCK_ANGORA_LAYER)), 0.5F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.64F, 0.64F, 0.64F);
			 
			 
			 
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderKidAngora<T extends EntityKidBase> extends RenderGoatBase<T, ModelKidAngora<T>>
	{
		public RenderKidAngora(EntityRendererProvider.Context context)
		{
			super(context, new ModelKidAngora<>(context.bakeLayer(KID_ANGORA_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.30F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			applySleepingPose(entity, poseStack, 0.5F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	 
	 
	 
	 
	 
	 

	public static class RenderDoeFainting<T extends EntityDoeBase> extends RenderGoatBase<T, ModelDoeFainting<T>>
	{
		public RenderDoeFainting(EntityRendererProvider.Context context)
		{
			super(context, new ModelDoeFainting<>(context.bakeLayer(DOE_FAINTING_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.4F, 0.4F, 0.4F);
			boolean fainted = applyFaintingPose(entity, poseStack, 1.5F);
			poseStack.translate(0.0F, 0.0F, -0.5F);
			if (!fainted)
				poseStack.translate(0.0F, 0.0F, -0.5F);
			applySleepingPose(entity, poseStack, 1.10F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderBuckFainting<T extends EntityBuckBase> extends RenderGoatBase<T, ModelBuckFainting<T>>
	{
		public RenderBuckFainting(EntityRendererProvider.Context context)
		{
			super(context, new ModelBuckFainting<>(context.bakeLayer(BUCK_FAINTING_LAYER)), 0.35F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.42F, 0.42F, 0.42F);
			boolean fainted = applyFaintingPose(entity, poseStack, 1.5F);
			if (!fainted)
				poseStack.translate(0.0F, 0.0F, -0.5F);
			applySleepingPose(entity, poseStack, 1.10F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderKidFainting<T extends EntityKidBase> extends RenderGoatBase<T, ModelKidFainting<T>>
	{
		public RenderKidFainting(EntityRendererProvider.Context context)
		{
			super(context, new ModelKidFainting<>(context.bakeLayer(KID_FAINTING_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.21F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			poseStack.translate(0.0F, 0.0F, -0.5F);
			boolean fainted = applyFaintingPose(entity, poseStack, 1.5F);
			if (!fainted)
				poseStack.translate(0.0F, 0.0F, -0.5F);
			applySleepingPose(entity, poseStack, 0.5F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	 
	 
	 
	 

	public static class RenderDoeKiko<T extends EntityDoeBase> extends RenderGoatBase<T, ModelDoeKiko<T>>
	{
		public RenderDoeKiko(EntityRendererProvider.Context context)
		{
			super(context, new ModelDoeKiko<>(context.bakeLayer(DOE_KIKO_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.42F, 0.42F, 0.42F);
			applySleepingPose(entity, poseStack, 1.10F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderBuckKiko<T extends EntityBuckBase> extends RenderGoatBase<T, ModelBuckKiko<T>>
	{
		public RenderBuckKiko(EntityRendererProvider.Context context)
		{
			super(context, new ModelBuckKiko<>(context.bakeLayer(BUCK_KIKO_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.45F, 0.45F, 0.45F);
			applySleepingPose(entity, poseStack, 1.10F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderKidKiko<T extends EntityKidBase> extends RenderGoatBase<T, ModelKidKiko<T>>
	{
		public RenderKidKiko(EntityRendererProvider.Context context)
		{
			super(context, new ModelKidKiko<>(context.bakeLayer(KID_KIKO_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.25F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			applySleepingPose(entity, poseStack, 0.5F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	 
	 
	 
	 

	public static class RenderDoeKinder<T extends EntityDoeBase> extends RenderGoatBase<T, ModelDoeKinder<T>>
	{
		public RenderDoeKinder(EntityRendererProvider.Context context)
		{
			super(context, new ModelDoeKinder<>(context.bakeLayer(DOE_KINDER_LAYER)), 0.4F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.48F, 0.48F, 0.48F);
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderBuckKinder<T extends EntityBuckBase> extends RenderGoatBase<T, ModelBuckKinder<T>>
	{
		public RenderBuckKinder(EntityRendererProvider.Context context)
		{
			super(context, new ModelBuckKinder<>(context.bakeLayer(BUCK_KINDER_LAYER)), 0.4F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.52F, 0.52F, 0.52F);
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderKidKinder<T extends EntityKidBase> extends RenderGoatBase<T, ModelKidKinder<T>>
	{
		public RenderKidKinder(EntityRendererProvider.Context context)
		{
			super(context, new ModelKidKinder<>(context.bakeLayer(KID_KINDER_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.27F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			applySleepingPose(entity, poseStack, 0.5F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	 
	 
	 
	 

	public static class RenderDoeNigerianDwarf<T extends EntityDoeBase> extends RenderGoatBase<T, ModelDoeNigerianDwarf<T>>
	{
		public RenderDoeNigerianDwarf(EntityRendererProvider.Context context)
		{
			super(context, new ModelDoeNigerianDwarf<>(context.bakeLayer(DOE_NIGERIAN_DWARF_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.42F, 0.42F, 0.42F);
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderBuckNigerianDwarf<T extends EntityBuckBase> extends RenderGoatBase<T, ModelBuckNigerianDwarf<T>>
	{
		public RenderBuckNigerianDwarf(EntityRendererProvider.Context context)
		{
			super(context, new ModelBuckNigerianDwarf<>(context.bakeLayer(BUCK_NIGERIAN_DWARF_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.45F, 0.45F, 0.45F);
			applySleepingPose(entity, poseStack, 1.45F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderKidNigerianDwarf<T extends EntityKidBase> extends RenderGoatBase<T, ModelKidNigerianDwarf<T>>
	{
		public RenderKidNigerianDwarf(EntityRendererProvider.Context context)
		{
			super(context, new ModelKidNigerianDwarf<>(context.bakeLayer(KID_NIGERIAN_DWARF_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.24F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			applySleepingPose(entity, poseStack, 0.5F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	 

	public static class RenderDoePygmy<T extends EntityDoeBase> extends RenderGoatBase<T, ModelDoePygmy<T>>
	{
		public RenderDoePygmy(EntityRendererProvider.Context context)
		{
			super(context, new ModelDoePygmy<>(context.bakeLayer(DOE_PYGMY_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.42F, 0.42F, 0.42F);
			applySleepingPose(entity, poseStack, 1.10F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderBuckPygmy<T extends EntityBuckBase> extends RenderGoatBase<T, ModelBuckPygmy<T>>
	{
		public RenderBuckPygmy(EntityRendererProvider.Context context)
		{
			super(context, new ModelBuckPygmy<>(context.bakeLayer(BUCK_PYGMY_LAYER)), 0.3F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			poseStack.scale(0.45F, 0.45F, 0.45F);
			applySleepingPose(entity, poseStack, 1.10F);
			super.scale(entity, poseStack, partialTick);
		}
	}

	public static class RenderKidPygmy<T extends EntityKidBase> extends RenderGoatBase<T, ModelKidPygmy<T>>
	{
		public RenderKidPygmy(EntityRendererProvider.Context context)
		{
			super(context, new ModelKidPygmy<>(context.bakeLayer(KID_PYGMY_LAYER)), 0.2F);
		}

		@Override
		protected void scale(T entity, PoseStack poseStack, float partialTick)
		{
			float age = entity.getEntityAge();
			float scale = 0.24F + age / entity.getSizeDividend();
			poseStack.scale(scale, scale, scale);
			applySleepingPose(entity, poseStack, 0.5F);
			super.scale(entity, poseStack, partialTick);
		}
	}
}
