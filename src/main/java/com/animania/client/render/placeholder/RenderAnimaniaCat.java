package com.animania.client.render.placeholder;

import com.animania.addons.catsdogs.common.entity.felids.EntityAnimaniaCat;

import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cat;

 



public class RenderAnimaniaCat extends CatRenderer
{
	public RenderAnimaniaCat(EntityRendererProvider.Context context)
	{
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(Cat entity)
	{
		if (entity instanceof EntityAnimaniaCat cat && cat.getResourceLocation() != null)
			return cat.getResourceLocation();

		return super.getTextureLocation(entity);
	}
}
