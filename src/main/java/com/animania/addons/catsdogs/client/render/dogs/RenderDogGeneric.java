package com.animania.addons.catsdogs.client.render.dogs;

import com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import com.animania.api.interfaces.IChild;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 















public class RenderDogGeneric<T extends EntityAnimaniaDog> extends MobRenderer<T, ModelDogGeneric<T>>
{
	private final float breedScale;
	private final double offsetX, offsetY, offsetZ;

	public RenderDogGeneric(EntityRendererProvider.Context context, ModelDogGeneric<T> model, float breedScale)
	{
		this(context, model, breedScale, 0, 0, 0);
	}

	public RenderDogGeneric(EntityRendererProvider.Context context, ModelDogGeneric<T> model, float breedScale,
			double offsetX, double offsetY, double offsetZ)
	{
		super(context, model, breedScale / 2F);
		this.addLayer(new LayerBlinkingDog<>(this));
		this.breedScale = breedScale;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.offsetZ = offsetZ;
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		ResourceLocation loc = entity.getResourceLocation();
		if (loc == null)
			loc = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/pug.png");
		if (entity.getVariantCount() <= 0)
			return loc;
		String path = loc.getPath();
		String stem = path.endsWith(".png") ? path.substring(0, path.length() - 4) : path;
		return loc.withPath(stem + entity.getCoatVariant() + ".png");
	}

	@Override
	protected void scale(T entity, PoseStack poseStack, float partialTick)
	{
		if (this.offsetX != 0 || this.offsetY != 0 || this.offsetZ != 0)
			poseStack.translate(this.offsetX, this.offsetY, this.offsetZ);

		float effectiveScale = this.breedScale;
		if (entity instanceof IChild child)
		{
			float age = child.getEntityAge();
			double dividend = 0.85 / (0.8 * this.breedScale);
			effectiveScale = this.breedScale + (float) (age / dividend);
		}

		if (entity.getSleeping())
		{
			this.shadowRadius = 0F;
			float sleepTimer = entity.getSleepTimer();
			if (sleepTimer > -0.55F)
				sleepTimer -= 0.01F;
			entity.setSleepTimer(sleepTimer);
			poseStack.translate(0D, -0.1D, 0D);
		}
		else
		{
			this.shadowRadius = this.breedScale / 2F;
		}

		poseStack.scale(effectiveScale, effectiveScale, effectiveScale);
	}
}
