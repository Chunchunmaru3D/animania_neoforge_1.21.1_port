package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogBloodhound
{
	private ModelDogBloodhound() {}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartDefinition body = part(root, "body", 71, 43, -4, -5, -5.5F, 8, 10, 11, 0, 8, -5, 0, .6F, -1.5F);
		PartDefinition legL1 = part(body, "leg_l1", 0, 54, -1, -3.5F, -1.5F, 2, 7, 3, 3.3F, 0, -2, 0, 3, 0);
		PartDefinition legL2 = part(legL1, "leg_l2", 11, 52, -1, -5, -1, 2, 10, 2, 0, 2.5F, 1, -.01F, 5, -.6F);
		part(legL2, "toes_l", 12, 61, -1, -.5F, -.5F, 2, 1, 1, 0, -3, .6F, 0, 7.5F, -1.5F);
		PartDefinition lowerBody = part(body, "lower_body", 29, 24, -3, -4.5F, -6.5F, 6, 9, 13, 0, -1, 6, 0, .8F, 5);
		PartDefinition tail = part(lowerBody, "tail", 51, 13, -1, -1.5F, -3, 2, 3, 6, 0, -3, 7, 0, 2, 2);
		PartDefinition tail2 = part(tail, "tail2", 68, 24, -1, -1, -4, 2, 2, 8, 0, -1, 4, 0, 1, 2.5F);
		part(tail2, "tail3", 66, 10, -.5F, -1, -1, 1, 2, 2, 0, 0, 3, 0, 0, 2);
		PartDefinition backLegL1 = part(lowerBody, "back_leg_l1", 20, 51, -1, -4.5F, -2, 2, 9, 4, 2.5F, -2.5F, 3, 0, 5, .5F);
		PartDefinition backLegL2 = part(backLegL1, "back_leg_l2", 4, 39, -1, -6.5F, -1, 2, 13, 2, 0, 2, .5F, -.01F, 5, .7F);
		part(backLegL2, "back_toe_l", 5, 49, -1, -.5F, -.5F, 2, 1, 1, .01F, -2.5F, -.7F, -.01F, 8.5F, -.4F);
		PartDefinition backLegR1 = part(lowerBody, "back_leg_r1", 20, 51, -1, -4.5F, -2, 2, 9, 4, -2.5F, -2.5F, 3, 0, 5, .5F);
		PartDefinition backLegR2 = part(backLegR1, "back_leg_r2", 0, 39, -1, -6.5F, -1, 2, 13, 2, 0, 2, .5F, .01F, 5, .7F);
		part(backLegR2, "back_toe_r", 5, 49, -1, -.5F, -.5F, 2, 1, 1, 0, -2.5F, -.7F, -.01F, 8.5F, -.4F);
		PartDefinition neck = part(body, "neck1", 3, 16, -2.5F, -3.5F, -6, 5, 7, 12, 0, -2.5F, -3, 0, 2, -1);
		PartDefinition headBase = part(neck, "head_base", 101, 27, -3.5F, -3.5F, -3, 7, 7, 6, 0, -1, -6.4F, 0, .49F, -1);
		PartDefinition headFront = part(headBase, "head_front", 106, 3, -2, -1.5F, -3.5F, 4, 3, 7, 0, 2, -1, 0, -.4F, -2.9F);
		part(headFront, "nose", 98, 17, -1, -.5F, -.5F, 2, 1, 1, 0, -1.6F, -2.5F, 0, .6F, -.8F);
		part(headFront, "gowl_l", 109, 16, -.5F, -2, -2, 1, 4, 4, -2, 1.2338F, 1.928F, 0, -.4F, -2.9F);
		part(headFront, "gowl_r", 109, 16, -.5F, -2, -2, 1, 4, 4, 2, 1.2338F, 1.928F, 0, -.4F, -2.9F);
		part(headBase, "jaw", 86, 4, -1, -.5F, -3, 2, 1, 6, 0, 2.5F, -1, 0, -.2F, -2.9F);
		PartDefinition earR = part(headBase, "ear_r", 67, 12, -2.5F, -.5F, -5.5F, 5, 1, 11, -3.5F, 1, -.5F, -.5F, -.6F, -1.7F);
		part(earR, "ear_r2", 78, 21, -2, -.5F, -.5F, 4, 1, 1, .2705F, .5822F, -4.2955F, -.5F, -.6F, -1.7F);
		PartDefinition earL = part(headBase, "ear_l", 67, 12, -2.5F, -.5F, -5.5F, 5, 1, 11, 3.5F, 1, -.4999F, .5F, -.6F, -1.7F);
		part(earL, "ear_l2", 78, 21, -2, -.5F, -.5F, 4, 1, 1, -.2706F, .5822F, -4.2955F, .5F, -.6F, -1.7F);
		part(headBase, "head_top", 103, 29, -2.5F, -3.5F, -2, 5, 7, 4, 0, -.4899F, 1, 0, 0, -1);
		PartDefinition legR1 = part(body, "leg_r1", 0, 54, -1, -3.5F, -1.5F, 2, 7, 3, -3.3F, 0, -2, 0, 3, 0);
		PartDefinition legR2 = part(legR1, "leg_r2", 11, 51, -1, -5.5F, -1, 2, 11, 2, 0, 2, 1, .12F, 5, -.6F);
		part(legR2, "toes_r", 12, 61, -1, -.5F, -.5F, 2, 1, 1, -.12F, -2.5F, .6F, .12F, 7.5F, -1.5F);
		return LayerDefinition.create(mesh, 128, 64);
	}

	public static final Map<String, DogPartPose> BASELINE = poses(false);
	public static final Map<String, DogPartPose> SLEEP_TARGET = poses(true);
	public static final Map<String, Float> SIT_POSE_X = Map.of(
			"body", -.10049954898833749F, "leg_l1", -.4374388517443468F,
			"lower_body", -.68513423385813F, "tail", .7665852593902014F,
			"tail2", .458307753610443F, "back_leg_l1", -.43039993887105366F,
			"back_leg_r1", -.4596010425861708F, "head_base", 1.1523920358728F,
			"leg_r1", -.4434654736514832F);
	public static final float SIT_BODY_Y = 12F, SIT_BODY_Z = -5F, HEAD_TRACK_OFFSET = -1F;

	private static Map<String, DogPartPose> poses(boolean sleep)
	{
		Map<String, DogPartPose> p = new HashMap<>();
		put(p, "body", 0, sleep ? 21 : 8, -5, sleep ? .24093921257931322F : 0, 0, 0);
		put(p, "leg_l1", 3.3F, 0, -2, sleep ? -1.5503759745465628F : 0, sleep ? -.3215908773139712F : 0, sleep ? .21734934240935785F : 0);
		put(p, "leg_l2", 0, 2.5F, 1, 0, sleep ? -.36083809620356766F : 0, sleep ? .2121360439336508F : 0);
		put(p, "toes_l", 0, -3, .6F, 0, 0, 0);
		put(p, "lower_body", 0, -1, 6, sleep ? -.4014100199954278F : 0, sleep ? .737762892122767F : 0, sleep ? -.18757402537033457F : 0);
		put(p, "tail", 0, -3, sleep ? 5 : 7, sleep ? -.19028626702793378F : -.8730119465183116F, sleep ? .5352191777580771F : 0, sleep ? .15578110771600587F : 0);
		put(p, "tail2", 0, -1, sleep ? 3 : 4, sleep ? -.030538025922144784F : .17864841157563557F, sleep ? .8290610652945904F : 0, sleep ? .2372164252848093F : 0);
		put(p, "tail3", 0, 0, sleep ? 3.3F : 3, sleep ? .11862479327029861F : .3103387396263637F, 0, 0);
		put(p, "back_leg_l1", sleep ? -2.5F : 2.5F, sleep ? -2 : -2.5F, 3, sleep ? -1.1373455523913567F : 0, sleep ? -.004394739056521722F : 0, sleep ? .2506397525618977F : 0);
		put(p, "back_leg_l2", 0, sleep ? 2.5F : 2, .5F, 0, 0, sleep ? -.3993330781855546F : 0);
		put(p, "back_toe_l", .01F, -2.5F, -.7F, 0, 0, 0);
		put(p, "back_leg_r1", sleep ? 2.5F : -2.5F, sleep ? -2 : -2.5F, 3, sleep ? -.9829519814306865F : 0, sleep ? .15209846299429786F : 0, sleep ? -.6296746515467583F : 0);
		put(p, "back_leg_r2", 0, sleep ? 2.5F : 2, .5F, 0, 0, 0);
		put(p, "back_toe_r", 0, -2.5F, -.7F, 0, 0, 0);
		put(p, "neck1", 0, sleep ? -2 : -2.5F, sleep ? -4 : -3, sleep ? -.3867108570351316F : -1.0096398110229319F, 0, sleep ? .27705007480307586F : 0);
		put(p, "head_base", 0, sleep ? -1.3F : -1, sleep ? -5 : -6.4F, sleep ? .5040039640861586F : 1.1054147537261205F, sleep ? -.2476849101382713F : 0, sleep ? -.46416507858013595F : 0);
		put(p, "head_front", 0, sleep ? 1.2F : 2, sleep ? -.5F : -1, sleep ? -.17280330391070658F : -.03422939729011279F, 0, 0);
		put(p, "nose", 0, sleep ? -1 : -1.6F, -2.5F, -.091106186954104F, 0, 0);
		put(p, "gowl_l", -2, 1.2338F, 1.928F, 0, 0, 0); put(p, "gowl_r", 2, 1.2338F, 1.928F, 0, 0, 0);
		put(p, "jaw", 0, 2.5F, sleep ? -.5F : -1, sleep ? -.2525770680316114F : -.07672118325916674F, 0, 0);
		put(p, "ear_r", -3.5F, 1, -.5F, 1.5324287538483052F, -.14514332592510046F, -1.6484931491059283F);
		put(p, "ear_r2", .2705F, .5822F, -4.2955F, -1.7453292519943296E-6F, 0, 1.7453292519943296E-6F);
		put(p, "ear_l", 3.5F, 1, -.4999F, 1.5324235178605492F, .14514507125435244F, 1.6484914037766762F);
		put(p, "ear_l2", -.2706F, .5822F, -4.2955F, -1.7453292519943296E-6F, 1.7453292519943296E-6F, 0);
		put(p, "head_top", 0, -.4899F, 1, 0, 0, 0);
		put(p, "leg_r1", -3.3F, 0, -2, sleep ? -1.5566190172809469F : 0, 0, 0);
		put(p, "leg_r2", 0, sleep ? 2.5F : 2, 1, 0, 0, 0);
		put(p, "toes_r", -.12F, -2.5F, .6F, 0, 0, 0);
		if (sleep)
		{
			offset(p, "body", 0, .6F, -1.5F); offset(p, "leg_l1", 0, 3, 0); offset(p, "leg_l2", -.01F, 3.5F, -.6F);
			offset(p, "toes_l", 0, 7.5F, -1.5F); offset(p, "lower_body", 0, .8F, 5); offset(p, "tail", 0, 0, 3);
			offset(p, "tail2", 0, 1, 2.5F); offset(p, "tail3", 0, 0, 2); offset(p, "back_leg_l1", 0, 4, .5F);
			offset(p, "back_leg_l2", .01F, 3.5F, .7F); offset(p, "back_toe_l", -.01F, 8.5F, -.4F);
			offset(p, "back_leg_r1", 0, 4, .5F); offset(p, "back_leg_r2", -.01F, 3.5F, .7F);
			offset(p, "back_toe_r", -.01F, 8.5F, -.4F); offset(p, "neck1", 0, 2, -1); offset(p, "head_base", 0, .49F, -1.8F);
			offset(p, "head_front", 0, -.4F, -2.9F); offset(p, "nose", 0, .6F, -.8F); offset(p, "jaw", 0, -.2F, -2.9F);
			offset(p, "ear_r", -.5F, -.6F, -1.7F); offset(p, "ear_r2", -.5F, -.6F, -1.7F);
			offset(p, "ear_l", .5F, -.6F, -1.7F); offset(p, "ear_l2", .5F, -.6F, -1.7F);
			offset(p, "leg_r1", 0, 3, 0); offset(p, "leg_r2", .12F, 3.5F, -.6F); offset(p, "toes_r", .12F, 7.5F, -1.5F);
		}
		return p;
	}

	private static void put(Map<String, DogPartPose> p, String name, float x, float y, float z, float rx, float ry, float rz)
	{
		p.put(name, new DogPartPose(x, y, z, rx, ry, rz));
	}

	private static void offset(Map<String, DogPartPose> p, String name, float x, float y, float z)
	{
		DogPartPose pose = p.get(name);
		p.put(name, new DogPartPose(pose.px(), pose.py(), pose.pz(), pose.rx(), pose.ry(), pose.rz(), x, y, z));
	}

	private static PartDefinition part(PartDefinition parent, String name, int u, int v,
			float x, float y, float z, int dx, int dy, int dz, float px, float py, float pz, float ox, float oy, float oz)
	{
		PartDefinition outer = parent.addOrReplaceChild(name, CubeListBuilder.create(), PartPose.offset(px, py, pz));
		return outer.addOrReplaceChild(name + "_box", CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, dx, dy, dz), PartPose.offset(ox, oy, oz));
	}
}
