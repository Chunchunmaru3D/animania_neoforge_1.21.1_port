package com.animania.addons.catsdogs.client.render.dogs;

import com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric;
import com.animania.addons.catsdogs.common.entity.canids.DogLabrador.EntityFemaleLabrador;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

 
public final class RenderDogLabrador<T extends EntityAnimaniaDog> extends RenderDogGeneric<T> {
	private static final ResourceLocation GLORIA=ResourceLocation.fromNamespaceAndPath("animania","textures/entity/dogs/gloria.png");
	public RenderDogLabrador(EntityRendererProvider.Context context,ModelDogGeneric<T> model,float scale){super(context,model,scale);}
	@Override public ResourceLocation getTextureLocation(T entity){
		if(entity instanceof EntityFemaleLabrador&&entity.getName().getString().equalsIgnoreCase("Gloria"))return GLORIA;
		return ResourceLocation.fromNamespaceAndPath("animania","textures/entity/dogs/labrador"+entity.getCoatVariant()+".png");
	}
}
