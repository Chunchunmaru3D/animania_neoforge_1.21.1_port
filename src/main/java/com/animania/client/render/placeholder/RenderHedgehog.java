package com.animania.client.render.placeholder;

import java.util.function.Function;

import com.animania.Animania;
import com.animania.client.model.placeholder.ModelHedgehog;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class RenderHedgehog<T extends Mob> extends MobRenderer<T, ModelHedgehog<T>>
{
	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "hedgehog"), "main");

	private final Function<T, ResourceLocation> textureResolver;

	public RenderHedgehog(EntityRendererProvider.Context context, Function<T, ResourceLocation> textureResolver)
	{
		super(context, new ModelHedgehog<>(context.bakeLayer(LAYER)), 0.25F);
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
		poseStack.scale(0.6F, 0.6F, 0.6F);
	}
}
