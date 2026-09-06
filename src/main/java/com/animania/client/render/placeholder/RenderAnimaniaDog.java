package com.animania.client.render.placeholder;

import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;

 




public class RenderAnimaniaDog extends WolfRenderer
{
	public RenderAnimaniaDog(EntityRendererProvider.Context context)
	{
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(Wolf entity)
	{
		if (entity instanceof EntityAnimaniaDog dog && dog.getResourceLocation() != null)
			return dog.getResourceLocation();

		return super.getTextureLocation(entity);
	}
}
