package com.animania.client.render.placeholder;

import java.util.function.Function;

import com.animania.Animania;
import com.animania.addons.extra.common.entity.peafowl.EntityAnimaniaPeacock;
import com.animania.client.model.placeholder.ModelPeachick;
import com.animania.common.blocks.CommonBlocks;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

 
public class RenderPeachick<T extends EntityAnimaniaPeacock> extends MobRenderer<T, ModelPeachick<T>>
{
	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, "peachick"), "main");

	private final Function<? super T, ResourceLocation> textureResolver;

	public RenderPeachick(EntityRendererProvider.Context context, Function<? super T, ResourceLocation> textureResolver)
	{
		super(context, new ModelPeachick<>(context.bakeLayer(LAYER)), 0.15F);
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
	protected void scale(T entity, PoseStack poseStack, float partialTickTime)
	{
		float base = 0.3F;
		if (entity instanceof com.animania.addons.extra.common.entity.peafowl.EntityPeachickBase peachick
				&& entity instanceof com.animania.api.interfaces.IChild child)
		{
			base += child.getEntityAge() / peachick.getSizeDividend();
		}
		poseStack.scale(base, base, base);
		if (entity.getSleeping() || entity.level().getBlockState(entity.blockPosition()).is(CommonBlocks.BLOCK_NEST.get()))
		{
			poseStack.translate(-0.25F, 0.35F, -0.25F);
			this.shadowRadius = 0.0F;
		}
		else
			this.shadowRadius = 0.3F;
	}
}
