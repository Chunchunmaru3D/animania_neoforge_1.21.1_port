package com.animania.addons.catsdogs.client.render.cats;

import com.animania.Animania;
import com.animania.addons.catsdogs.client.model.cats.ModelCatTabby;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

 











public class RenderCats
{
	public static final ModelLayerLocation TABBY_LAYER = layer("cat_tabby");
	public static final ModelLayerLocation AMERICAN_SHORTHAIR_LAYER = layer("cat_american_shorthair");
	public static final ModelLayerLocation ASIATIC_LAYER = layer("cat_asiatic");
	public static final ModelLayerLocation EXOTIC_LAYER = layer("cat_exotic");
	public static final ModelLayerLocation OCELOT_LAYER = layer("cat_ocelot");
	public static final ModelLayerLocation RAGDOLL_LAYER = layer("cat_ragdoll");
	public static final ModelLayerLocation SIAMESE_LAYER = layer("cat_siamese");

	private static ModelLayerLocation layer(String name)
	{
		return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, name), "main");
	}

	public static LayerDefinition createTabbyLayer()
	{
		return ModelCatTabby.createBodyLayer();
	}

	public static LayerDefinition createAmericanShorthairLayer()
	{
		return com.animania.addons.catsdogs.client.model.cats.ModelCatAmericanShorthair.createBodyLayer();
	}

	public static LayerDefinition createAsiaticLayer()
	{
		return com.animania.addons.catsdogs.client.model.cats.ModelCatAsiatic.createBodyLayer();
	}

	public static LayerDefinition createExoticLayer()
	{
		return com.animania.addons.catsdogs.client.model.cats.ModelCatExotic.createBodyLayer();
	}

	public static LayerDefinition createOcelotLayer()
	{
		return com.animania.addons.catsdogs.client.model.cats.ModelCatOcelot.createBodyLayer();
	}

	 
	public static LayerDefinition createRagdollLayer()
	{
		return com.animania.addons.catsdogs.client.model.cats.ModelCatRagdoll.createBodyLayer();
	}

	public static LayerDefinition createSiameseLayer()
	{
		return com.animania.addons.catsdogs.client.model.cats.ModelCatSiamese.createBodyLayer();
	}
}

