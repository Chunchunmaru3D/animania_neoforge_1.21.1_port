package com.animania.addons.extra.client.render.rabbits;

import com.animania.Animania;
import com.animania.addons.extra.client.model.rabbits.ModelRabbitJack;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityRabbitBuckBase;
import com.animania.addons.extra.common.entity.rodents.rabbits.EntityRabbitKitBase;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

 
public class RenderRabbitJack<T extends EntityAnimaniaRabbit> extends MobRenderer<T, ModelRabbitJack<T>>
{
	public static final ModelLayerLocation LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "rabbit_jack"), "main");
	private static final ResourceLocation TEXTURE = texture("rabbit_jack");
	private static final ResourceLocation KILLER = texture("rabbit_killer");

	public RenderRabbitJack(EntityRendererProvider.Context context)
	{
		super(context, new ModelRabbitJack<>(context.bakeLayer(LAYER)), .25F);
		this.addLayer(new LayerBlinkingRabbit<>(this));
	}

	private static ResourceLocation texture(String name)
	{
		return ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/rabbits/" + name + ".png");
	}

	@Override
	public ResourceLocation getTextureLocation(T rabbit) { return isKiller(rabbit) ? KILLER : TEXTURE; }

	@Override
	protected void scale(T rabbit, PoseStack poseStack, float partialTick)
	{
		float scale;
		if (rabbit instanceof EntityRabbitKitBase kit)
			scale = .32F + kit.getEntityAge() / kit.getSizeDividend();
		else if (isKiller(rabbit))
			scale = .7F;
		else
			scale = rabbit instanceof EntityRabbitBuckBase ? .56F : .57F;

		poseStack.scale(scale, scale, scale);
		poseStack.translate(0, 0, -.5D);
		if (rabbit.getSleeping())
		{
			this.shadowRadius = 0;
			poseStack.translate(-.25D, rabbit instanceof EntityRabbitKitBase ? .1D : .25D, -.25D);
		}
		else this.shadowRadius = .25F;
	}

	private static boolean isKiller(EntityAnimaniaRabbit rabbit)
	{
		return !(rabbit instanceof EntityRabbitKitBase) && rabbit.hasCustomName()
				&& rabbit.getCustomName().getString().trim().equals("Killer");
	}
}
