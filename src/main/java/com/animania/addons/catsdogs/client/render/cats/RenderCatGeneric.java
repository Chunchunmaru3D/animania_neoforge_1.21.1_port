package com.animania.addons.catsdogs.client.render.cats;

import com.animania.addons.catsdogs.client.model.cats.ModelCatGeneric;
import com.animania.addons.catsdogs.common.entity.felids.CatType;
import com.animania.addons.catsdogs.common.entity.felids.EntityAnimaniaCat;
import com.animania.api.interfaces.IChild;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 













public class RenderCatGeneric<T extends EntityAnimaniaCat> extends MobRenderer<T, ModelCatGeneric<T>>
{
	private final float breedScale;

	public RenderCatGeneric(EntityRendererProvider.Context context, ModelCatGeneric<T> model, float breedScale)
	{
		super(context, model, breedScale / 2F);
		this.breedScale = breedScale;
		this.addLayer(new LayerBlinkingCat<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		String texture = switch (entity.type)
		{
			case AMERICAN_SHORTHAIR -> "american_shorthair";
			case ASIATIC -> "asiatic";
			case EXOTIC -> "exotic";
			case NORWEGIAN -> "norwegian";
			case OCELOT -> "ocelot";
			case RAGDOLL -> "ragdoll";
			case SIAMESE -> "siamese";
			case TABBY -> "tabby";
		};
		return ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/cats/" + texture + ".png");
	}

	@Override
	protected void scale(T entity, PoseStack poseStack, float partialTick)
	{
		float effectiveScale = this.breedScale;

		if (entity instanceof IChild child)
		{
			float age = child.getEntityAge();
			double dividend = 0.85 / (0.8 * this.breedScale);
			effectiveScale = this.breedScale + (float) (age / dividend);
			this.shadowRadius = (this.breedScale + age) / 2F;
		}
		else
		{
			this.shadowRadius = this.breedScale / 2F;
		}

		if (entity.getSleeping())
		{
			this.shadowRadius = 0F;
			float sleepTimer = entity.getSleepTimer();
			if (sleepTimer > -0.55F)
				sleepTimer -= 0.01F;
			entity.setSleepTimer(sleepTimer);

			poseStack.translate(-0.25D, entity.getBbHeight() - 2D - sleepTimer, -0.25D);
			poseStack.mulPose(Axis.ZP.rotationDegrees(6.0F));
			poseStack.translate(0D, 0.6D, 0D);
			if (entity instanceof IChild)
				poseStack.translate(0D, 0.4D, 0D);
		}

		poseStack.scale(effectiveScale, effectiveScale, effectiveScale);
	}
}
