package com.animania.client.render.placeholder;

import java.util.function.Function;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.peafowl.EntityAnimaniaPeacock;
import com.animania.client.model.placeholder.ModelPeacock;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

 
public class RenderPeacock<T extends EntityAnimaniaPeacock> extends MobRenderer<T, ModelPeacock<T>>
{
	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "peacock"), "main");

	private final Function<? super T, ResourceLocation> textureResolver;

	public RenderPeacock(EntityRendererProvider.Context context, Function<? super T, ResourceLocation> textureResolver)
	{
		super(context, new ModelPeacock<>(context.bakeLayer(LAYER)), 0.32F);
		this.textureResolver = textureResolver;
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		return this.textureResolver.apply(entity);
	}

	 
	@Override
	protected float getBob(T entity, float partialTick)
	{
		float flap = entity.oFlap + (entity.wingRotation - entity.oFlap) * partialTick;
		float flapSpeed = entity.oFlapSpeed + (entity.destPos - entity.oFlapSpeed) * partialTick;
		return (Mth.sin(flap) + 1.0F) * flapSpeed;
	}

	@Override
	protected void scale(T entity, PoseStack poseStack, float partialTick)
	{
		if (entity.getSleeping())
		{
			poseStack.translate(-0.25F, 0.45F, -0.45F);
			this.shadowRadius = 0.0F;
		}
		else
			this.shadowRadius = 0.3F;
	}
}
