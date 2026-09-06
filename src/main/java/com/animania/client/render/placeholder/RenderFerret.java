package com.animania.client.render.placeholder;

import java.util.function.Function;

import com.animania.Animania;
import com.animania.client.model.placeholder.ModelFerret;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class RenderFerret<T extends Mob> extends MobRenderer<T, ModelFerret<T>>
{
	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "ferret"), "main");

	private final Function<T, ResourceLocation> textureResolver;

	public RenderFerret(EntityRendererProvider.Context context, Function<T, ResourceLocation> textureResolver)
	{
		super(context, new ModelFerret<>(context.bakeLayer(LAYER)), 0.3F);
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
		poseStack.scale(0.5F, 0.5F, 0.5F);
	}
}
