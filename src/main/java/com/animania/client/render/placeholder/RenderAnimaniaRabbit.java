package com.animania.client.render.placeholder;

import com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Rabbit;

 





public class RenderAnimaniaRabbit extends RabbitRenderer
{
	public RenderAnimaniaRabbit(EntityRendererProvider.Context context)
	{
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(Rabbit entity)
	{
		if (entity instanceof EntityAnimaniaRabbit rabbit && rabbit.getResourceLocation() != null)
			return rabbit.getResourceLocation();

		return super.getTextureLocation(entity);
	}
}
