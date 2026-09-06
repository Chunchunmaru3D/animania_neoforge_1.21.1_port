package com.animania.addons.catsdogs.client.render.dogs;

import com.animania.Animania;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogGeneric;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogDachshund;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogCorgi;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogChihuahua;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogPomeranian;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogBloodhound;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogCollie;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogFox;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogGermanShepherd;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogGreatDane;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogGreyhound;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogHusky;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogLabrador;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogPoodle;
import com.animania.addons.catsdogs.client.model.dogs.ModelDogWolf;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

 




public class RenderDogs
{
	public static final ModelLayerLocation PUG_LAYER = layer("dog_pug");
	public static final ModelLayerLocation POMERANIAN_LAYER = layer("dog_pomeranian");
	public static final ModelLayerLocation DACHSHUND_LAYER = layer("dog_dachshund");
	public static final ModelLayerLocation CORGI_LAYER = layer("dog_corgi");
	public static final ModelLayerLocation CHIHUAHUA_LAYER = layer("dog_chihuahua");
	public static final ModelLayerLocation BLOODHOUND_LAYER = layer("dog_bloodhound");
	public static final ModelLayerLocation COLLIE_LAYER = layer("dog_collie");
	public static final ModelLayerLocation FOX_LAYER = layer("dog_fox");
	public static final ModelLayerLocation GERMAN_SHEPHERD_LAYER = layer("dog_german_shepherd");
	public static final ModelLayerLocation GREAT_DANE_LAYER = layer("dog_great_dane");
	public static final ModelLayerLocation GREYHOUND_LAYER = layer("dog_greyhound");
	public static final ModelLayerLocation HUSKY_LAYER = layer("dog_husky");
	public static final ModelLayerLocation LABRADOR_LAYER = layer("dog_labrador");
	public static final ModelLayerLocation POODLE_LAYER = layer("dog_poodle");
	public static final ModelLayerLocation WOLF_LAYER = layer("dog_wolf");

	private static ModelLayerLocation layer(String name)
	{
		return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Animania.MODID, name), "main");
	}

	public static LayerDefinition createPugLayer()
	{
		return com.animania.addons.catsdogs.client.model.dogs.ModelDogPug.createBodyLayer();
	}

	public static LayerDefinition createPomeranianLayer()
	{
		return ModelDogPomeranian.createBodyLayer();
	}

	public static LayerDefinition createDachshundLayer()
	{
		return ModelDogDachshund.createBodyLayer();
	}

	public static LayerDefinition createCorgiLayer()
	{
		return ModelDogCorgi.createBodyLayer();
	}

	public static LayerDefinition createChihuahuaLayer() { return ModelDogChihuahua.createBodyLayer(); }

	public static LayerDefinition createBloodhoundLayer() { return ModelDogBloodhound.createBodyLayer(); }

	public static LayerDefinition createCollieLayer() { return ModelDogCollie.createBodyLayer(); }

	public static LayerDefinition createFoxLayer() { return ModelDogFox.createBodyLayer(); }

	public static LayerDefinition createGermanShepherdLayer() { return ModelDogGermanShepherd.createBodyLayer(); }

	public static LayerDefinition createGreatDaneLayer() { return ModelDogGreatDane.createBodyLayer(); }

	public static LayerDefinition createGreyhoundLayer() { return ModelDogGreyhound.createBodyLayer(); }

	public static LayerDefinition createHuskyLayer() { return ModelDogHusky.createBodyLayer(); }

	public static LayerDefinition createLabradorLayer() { return ModelDogLabrador.createBodyLayer(); }

	public static LayerDefinition createPoodleLayer() { return ModelDogPoodle.createBodyLayer(); }

	public static LayerDefinition createWolfLayer() { return ModelDogWolf.createBodyLayer(); }

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createPomeranianModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(POMERANIAN_LAYER), "body", ModelDogPomeranian.BASELINE,
				ModelDogPomeranian.SLEEP_TARGET, ModelDogPomeranian.SIT_POSE_X, ModelDogPomeranian.SIT_BODY_Y,
				ModelDogPomeranian.SIT_BODY_Z, ModelDogPomeranian.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createDachshundModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(DACHSHUND_LAYER), "body", ModelDogDachshund.BASELINE,
				ModelDogDachshund.SLEEP_TARGET, ModelDogDachshund.SIT_POSE_X, ModelDogDachshund.SIT_BODY_Y,
				ModelDogDachshund.SIT_BODY_Z, ModelDogDachshund.HEAD_TRACK_OFFSET, ModelDogDachshund.SIT_POSE);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createCorgiModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(CORGI_LAYER), "body", ModelDogCorgi.BASELINE,
				ModelDogCorgi.SLEEP_TARGET, ModelDogCorgi.SIT_POSE_X, ModelDogCorgi.SIT_BODY_Y,
				ModelDogCorgi.SIT_BODY_Z, ModelDogCorgi.HEAD_TRACK_OFFSET, java.util.Map.of(), true);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createChihuahuaModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(CHIHUAHUA_LAYER), "body", ModelDogChihuahua.BASELINE,
				ModelDogChihuahua.SLEEP_TARGET, ModelDogChihuahua.SIT_POSE_X, ModelDogChihuahua.SIT_BODY_Y,
				ModelDogChihuahua.SIT_BODY_Z, ModelDogChihuahua.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createBloodhoundModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(BLOODHOUND_LAYER), "body", ModelDogBloodhound.BASELINE,
				ModelDogBloodhound.SLEEP_TARGET, ModelDogBloodhound.SIT_POSE_X, ModelDogBloodhound.SIT_BODY_Y,
				ModelDogBloodhound.SIT_BODY_Z, ModelDogBloodhound.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createCollieModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(COLLIE_LAYER), "body", ModelDogCollie.BASELINE,
				ModelDogCollie.SLEEP_TARGET, ModelDogCollie.SIT_POSE_X, ModelDogCollie.SIT_BODY_Y,
				ModelDogCollie.SIT_BODY_Z, ModelDogCollie.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createFoxModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(FOX_LAYER), "body", ModelDogFox.BASELINE,
				ModelDogFox.SLEEP_TARGET, ModelDogFox.SIT_POSE_X, ModelDogFox.SIT_BODY_Y,
				ModelDogFox.SIT_BODY_Z, ModelDogFox.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createGermanShepherdModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(GERMAN_SHEPHERD_LAYER), "body", ModelDogGermanShepherd.BASELINE,
				ModelDogGermanShepherd.SLEEP_TARGET, ModelDogGermanShepherd.SIT_POSE_X,
				ModelDogGermanShepherd.SIT_BODY_Y, ModelDogGermanShepherd.SIT_BODY_Z,
				ModelDogGermanShepherd.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createGreatDaneModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(GREAT_DANE_LAYER), "body", ModelDogGreatDane.BASELINE,
				ModelDogGreatDane.SLEEP_TARGET, ModelDogGreatDane.SIT_POSE_X, ModelDogGreatDane.SIT_BODY_Y,
				ModelDogGreatDane.SIT_BODY_Z, ModelDogGreatDane.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createGreyhoundModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(GREYHOUND_LAYER), "body", ModelDogGreyhound.BASELINE,
				ModelDogGreyhound.SLEEP_TARGET, ModelDogGreyhound.SIT_POSE_X, ModelDogGreyhound.SIT_BODY_Y,
				ModelDogGreyhound.SIT_BODY_Z, ModelDogGreyhound.HEAD_TRACK_OFFSET, ModelDogGreyhound.SIT_POSE, false, true);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createHuskyModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(HUSKY_LAYER), "body", ModelDogHusky.BASELINE,
				ModelDogHusky.SLEEP_TARGET, ModelDogHusky.SIT_POSE_X, ModelDogHusky.SIT_BODY_Y,
				ModelDogHusky.SIT_BODY_Z, ModelDogHusky.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createLabradorModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(LABRADOR_LAYER), "body", ModelDogLabrador.BASELINE,
				ModelDogLabrador.SLEEP_TARGET, ModelDogLabrador.SIT_POSE_X, ModelDogLabrador.SIT_BODY_Y,
				ModelDogLabrador.SIT_BODY_Z, ModelDogLabrador.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createPoodleModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(POODLE_LAYER), "body", ModelDogPoodle.BASELINE,
				ModelDogPoodle.SLEEP_TARGET, ModelDogPoodle.SIT_POSE_X, ModelDogPoodle.SIT_BODY_Y,
				ModelDogPoodle.SIT_BODY_Z, ModelDogPoodle.HEAD_TRACK_OFFSET);
	}

	public static <T extends EntityAnimaniaDog> ModelDogGeneric<T> createWolfModel(EntityRendererProvider.Context context)
	{
		return new ModelDogGeneric<>(context.bakeLayer(WOLF_LAYER), "body", ModelDogWolf.BASELINE,
				ModelDogWolf.SLEEP_TARGET, ModelDogWolf.SIT_POSE_X, ModelDogWolf.SIT_BODY_Y,
				ModelDogWolf.SIT_BODY_Z, ModelDogWolf.HEAD_TRACK_OFFSET);
	}
}
