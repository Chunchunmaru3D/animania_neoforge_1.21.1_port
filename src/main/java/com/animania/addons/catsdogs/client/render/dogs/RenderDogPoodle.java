package com.animania.addons.catsdogs.client.render.dogs;

import com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

 
public final class RenderDogPoodle<T extends EntityAnimaniaDog> extends RenderDogGeneric<T> {
	public RenderDogPoodle(EntityRendererProvider.Context context,ModelDogGeneric<T> model,float scale){super(context,model,scale);}
	@Override public ResourceLocation getTextureLocation(T entity){return ResourceLocation.fromNamespaceAndPath("animania","textures/entity/dogs/poodle"+entity.getCoatVariant()+".png");}
}
