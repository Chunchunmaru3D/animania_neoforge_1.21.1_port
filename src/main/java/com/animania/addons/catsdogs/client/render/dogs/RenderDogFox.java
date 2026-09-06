package com.animania.addons.catsdogs.client.render.dogs;

import com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric;
import com.animania.addons.catsdogs.common.entity.canids.DogFox.EntityFemaleFox;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import com.animania.api.interfaces.IChild;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 
public final class RenderDogFox<T extends EntityAnimaniaDog> extends MobRenderer<T, ModelDogGeneric<T>>
{
	private static final ResourceLocation FOX = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/fox.png");
	private static final ResourceLocation RAZZ_FOX = ResourceLocation.fromNamespaceAndPath("animania", "textures/entity/dogs/razz_fox.png");

	public RenderDogFox(EntityRendererProvider.Context context, ModelDogGeneric<T> model)
	{
		super(context, model, .5F);
		this.addLayer(new LayerBlinkingDog<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		return entity.getName().getString().equalsIgnoreCase("razz") ? RAZZ_FOX : FOX;
	}

	@Override
	protected void scale(T entity, PoseStack poseStack, float partialTick)
	{
		if (entity instanceof EntityFemaleFox)
			poseStack.scale(.9F, .9F, .9F);
		if (entity instanceof IChild child)
		{
			float scale = .5F + child.getEntityAge() / (float) (.85D / (.9D - .5D));
			poseStack.scale(scale, scale, scale);
		}

		if (entity.getSleeping())
		{
			this.shadowRadius = 0F;
			float timer = entity.getSleepTimer();
			if (timer > -.55F)
				timer -= .01F;
			entity.setSleepTimer(timer);
			poseStack.translate(-.25F, entity.getBbHeight() - 1.45F - timer, -.25F);
			poseStack.mulPose(Axis.ZP.rotationDegrees(6F));
			poseStack.translate(0, -.3F, 0);
		}
		else
		{
			this.shadowRadius = .5F;
		}
		poseStack.translate(0, .1F, 0);
	}
}
