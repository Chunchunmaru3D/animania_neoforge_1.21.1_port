package com.animania.client.render.placeholder;

import java.util.function.Function;

import com.animania.Animania;
import com.animania.client.model.placeholder.ModelFrog;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

 




public class RenderFrog<T extends Mob> extends MobRenderer<T, ModelFrog<T>>
{
	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "frog"), "main");

	private final Function<T, ResourceLocation> textureResolver;

	public RenderFrog(EntityRendererProvider.Context context, Function<T, ResourceLocation> textureResolver)
	{
		super(context, new ModelFrog<>(context.bakeLayer(LAYER)), 0.2F);
		this.textureResolver = textureResolver;
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		return this.textureResolver.apply(entity);
	}

	 





	@Override
	protected void scale(T entity, PoseStack poseStack, float partialTickTime)
	{
		float base;
		if (entity instanceof com.animania.addons.extra.common.entity.amphibians.EntityDartFrogs)
		{
			base = 0.2F;
		}
		else if (entity.hasCustomName() && "Pepe".equals(entity.getName().getString()))
		{
			base = 0.5F;
		}
		else
		{
			base = 0.3F;
		}
		poseStack.scale(base, base, base);

		if (entity instanceof com.animania.addons.extra.common.entity.amphibians.EntityAmphibian amphibian)
		{
			float f1 = 1.2F;
			float f2 = (amphibian.prevSquishFactor + (amphibian.squishFactor - amphibian.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
			float f3 = 1.0F / (f2 + 1.0F);
			poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
		}
	}
}
