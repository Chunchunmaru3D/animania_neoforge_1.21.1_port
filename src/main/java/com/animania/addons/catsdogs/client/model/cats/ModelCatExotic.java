package com.animania.addons.catsdogs.client.model.cats;

import java.util.HashMap;
import java.util.Map;

import com.leviathanstudio.craftstudio.client.model.CSModelBaker;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public class ModelCatExotic
{
	private static final int TEX_W = 128, TEX_H = 64;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition body = addPart(root, "body", 38, 44, -3.0F, -4.5F, -5.5F, 6, 9, 11,
				0.0F, 14.0F, -4.0F, 0.0F, 1.0F, -0.0F, 2.0F, 0.0F, 0.0F);
		PartDefinition lowerBody = addPart(body, "lower_body", 78, 43, -3.5F, -4.5F, -5.5F, 7, 9, 11,
				0.0F, -1.0F, 3.0F, 0.0F, 1.0F, 6.0F, -2.5295F, 0.0F, 0.0F);
		PartDefinition tail = addPart(lowerBody, "tail", 44, 16, -1.0F, -1.5F, -4.5F, 2, 3, 9,
				0.0F, -3.0F, 5.0F, 0.0F, 1.0F, 3.0F, -50.1436F, 0.0F, 0.0F);
		PartDefinition tail2 = addPart(tail, "tail2", 71, 27, -1.0F, -1.5F, -2.5F, 2, 3, 5,
				0.0F, 0.0F, 3.0F, 0.0F, -0.0F, 3.0F, 12.4354F, 0.0F, 0.0F);
		addPart(tail2, "tail3", 61, 5, -1.0F, -1.5F, -3.5F, 2, 3, 7,
				0.0F, 0.0F, 1.5F, 0.0F, -0.0F, 3.0F, 15.567F, 0.0F, 0.0F);
		PartDefinition backLegR1 = addPart(lowerBody, "back_leg_r1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				-4.0F, -4.0F, 2.0F, 0.0F, 4.5F, 0.5F, -0.0001F, 0.0F, 0.0F);
		addPart(backLegR1, "back_leg_r2", 18, 35, -1.0F, -5.0F, -1.5F, 2, 10, 3,
				0.0F, 1.0F, 1.0F, 0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition backLegL1 = addPart(lowerBody, "back_leg_l1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				4.0F, -4.0F, 2.0F, 0.0F, 4.5F, 0.5F, -0.0001F, 0.0F, 0.0F);
		addPart(backLegL1, "back_leg_l2", 18, 35, -1.0F, -5.0F, -1.5F, 2, 10, 3,
				0.0F, 1.0F, 1.0F, -0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition neck1 = addPart(body, "neck1", 14, 21, -2.5F, -3.0F, -3.5F, 5, 6, 7,
				0.0F, 1.0F, -2.0F, 0.0F, -0.0F, -5.0F, -40.0314F, 0.0F, 0.0F);
		PartDefinition headBase = addPart(neck1, "head_base", 89, 14, -3.0F, -3.5F, -2.5F, 6, 7, 5,
				0.0F, -2.0F, -2.0F, 0.0F, 1.0F, -3.0F, 44.3332F, 0.0F, 0.0F);
		PartDefinition headFront = addPart(headBase, "head_front", 0, 12, -2.0F, -1.0F, -2.5F, 4, 2, 5,
				0.0F, 3.0F, 2.0F, 0.0F, -1.0F, -2.9F, -10.7079F, 0.0F, 0.0F);
		PartDefinition headSlope = addPart(headFront, "head_slope", 37, 11, -1.0F, -1.0F, -2.5F, 2, 2, 5,
				0.0F, -2.0F, 3.0F, 0.0F, -1.0F, -2.9F, 20.1241F, 0.0F, 0.0F);
		addPart(headSlope, "nose", 10, 0, -0.5F, -0.5F, -0.5F, 1, 1, 1,
				0.0F, -0.7F, -1.5F, 0.0F, 0.6F, -0.8F, -10.1283F, 0.0F, 0.0F);
		addPart(headBase, "jaw", 1, 21, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				0.0F, 2.4F, -0.0F, 0.0F, -0.2F, -1.0F, -0.5632F, 0.0F, 0.0F);
		PartDefinition cheekR = addPart(headBase, "cheek_r", 32, 41, -1.5F, -3.0F, -1.5F, 3, 6, 3,
				-1.0F, 0.5F, 1.0F, -2.0F, -0.6F, -1.0F, 0.0F, -9.58F, -7.0F);
		addPart(cheekR, "cheek_r2", 32, 35, -1.5F, -2.0F, -1.0F, 3, 4, 2,
				1.0F, 0.6F, 1.5F, -2.0F, -0.6F, -1.0F, 0.0F, -13.754F, 0.0F);
		PartDefinition cheekL = addPart(headBase, "cheek_l", 32, 41, -1.5F, -3.0F, -1.5F, 3, 6, 3,
				1.0F, 0.5F, 1.0F, 2.0F, -0.6F, -1.0F, 0.0F, 9.58F, 7.0F);
		addPart(cheekL, "cheek_l2", 32, 35, -1.5F, -2.0F, -1.0F, 3, 4, 2,
				-1.0F, 0.6F, 1.5F, 2.0F, -0.6F, -1.0F, 0.0F, 13.7541F, 0.0001F);
		PartDefinition earR = addPart(headBase, "ear_r", 4, 4, -1.5F, -0.5F, -1.5F, 3, 1, 3,
				-2.0F, -2.0F, -0.0F, -0.5F, -0.6F, -1.0F, -59.1696F, 83.6302F, -67.213F);
		addPart(earR, "ear_r2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -2.5F, 0.0F, -0.6F, 1.0F, 9.0F, 0.0F, 0.0F);
		PartDefinition earL = addPart(headBase, "ear_l", 4, 4, -1.5F, -0.5F, -1.5F, 3, 1, 3,
				2.0F, -2.0F, -0.0F, 0.5F, -0.6F, -1.0F, -59.1696F, -83.6301F, 67.2131F);
		addPart(earL, "ear_l2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -2.5F, 0.0F, -0.6F, 1.0F, 9.0F, 0.0F, 0.0F);
		PartDefinition legR1 = addPart(body, "leg_r1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				-3.0F, -4.5F, -3.0F, 0.0F, 4.0F, -0.0F, -2.0F, 0.0F, 0.0F);
		addPart(legR1, "leg_r2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 2.0F, 0.2F, 0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);
		PartDefinition legL1 = addPart(body, "leg_l1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				3.0F, -4.5F, -3.0F, 0.0F, 4.0F, -0.0F, -2.0F, 0.0F, 0.0F);
		addPart(legL1, "leg_l2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 2.0F, 0.2F, -0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);

		return LayerDefinition.create(mesh, TEX_W, TEX_H);
	}

	public static final Map<String, CatPartPose> BASELINE = buildBaseline();

	private static Map<String, CatPartPose> buildBaseline()
	{
		Map<String, CatPartPose> m = new HashMap<>();
		m.put("body", new CatPartPose(0.0F, 14.0F, -4.0F, 0.03490658503988659F, 0.0F, 0.0F));
		m.put("lower_body", new CatPartPose(0.0F, -1.0F, 3.0F, -0.04414810342919657F, 0.0F, 0.0F));
		m.put("tail", new CatPartPose(0.0F, -3.0F, 5.0F, -0.8751709188030287F, 0.0F, 0.0F));
		m.put("tail2", new CatPartPose(0.0F, 0.0F, 3.0F, 0.21703867380250286F, 0.0F, 0.0F));
		m.put("tail3", new CatPartPose(0.0F, 0.0F, 1.5F, 0.2716954046579573F, 0.0F, 0.0F));
		m.put("back_leg_r1", new CatPartPose(-4.0F, -4.0F, 2.0F, -1.7453292519943296E-6F, 0.0F, 0.0F));
		m.put("back_leg_r2", new CatPartPose(0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("back_leg_l1", new CatPartPose(4.0F, -4.0F, 2.0F, -1.7453292519943296E-6F, 0.0F, 0.0F));
		m.put("back_leg_l2", new CatPartPose(0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("neck1", new CatPartPose(0.0F, 1.0F, -2.0F, -0.698679734182858F, 0.0F, 0.0F));
		m.put("head_base", new CatPartPose(0.0F, -2.0F, -2.0F, 0.77376030794515F, 0.0F, 0.0F));
		m.put("head_front", new CatPartPose(0.0F, 3.0F, 2.0F, -0.18688811097430083F, 0.0F, 0.0F));
		m.put("head_slope", new CatPartPose(0.0F, -2.0F, 3.0F, 0.35123180400059084F, 0.0F, 0.0F));
		m.put("nose", new CatPartPose(0.0F, -0.7F, -1.5F, -0.17677218262974168F, 0.0F, 0.0F));
		m.put("jaw", new CatPartPose(0.0F, 2.4F, -0.0F, -0.009829694347232064F, 0.0F, 0.0F));
		m.put("cheek_r", new CatPartPose(-1.0F, 0.5F, 1.0F, 0.0F, -0.16720254234105678F, -0.12217304763960307F));
		m.put("cheek_r2", new CatPartPose(1.0F, 0.6F, 1.5F, 0.0F, -0.24005258531930007F, 0.0F));
		m.put("cheek_l", new CatPartPose(1.0F, 0.5F, 1.0F, 0.0F, 0.16720254234105678F, 0.12217304763960307F));
		m.put("cheek_l2", new CatPartPose(-1.0F, 0.6F, 1.5F, 0.0F, 0.24005433064855206F, 1.7453292519943296E-6F));
		m.put("ear_r", new CatPartPose(-2.0F, -2.0F, -0.0F, -1.0327043370880369F, 1.4596223441013618F, -1.1730881501429486F));
		m.put("ear_r2", new CatPartPose(0.0F, 0.6F, -2.5F, 0.15707963267948966F, 0.0F, 0.0F));
		m.put("ear_l", new CatPartPose(2.0F, -2.0F, -0.0F, -1.0327043370880369F, -1.4596205987721098F, 1.1730898954722007F));
		m.put("ear_l2", new CatPartPose(0.0F, 0.6F, -2.5F, 0.15707963267948966F, 0.0F, 0.0F));
		m.put("leg_r1", new CatPartPose(-3.0F, -4.5F, -3.0F, -0.03490658503988659F, 0.0F, 0.0F));
		m.put("leg_r2", new CatPartPose(0.0F, 2.0F, 0.2F, 0.0F, 0.0F, 0.0F));
		m.put("leg_l1", new CatPartPose(3.0F, -4.5F, -3.0F, -0.03490658503988659F, 0.0F, 0.0F));
		m.put("leg_l2", new CatPartPose(0.0F, 2.0F, 0.2F, 0.0F, 0.0F, 0.0F));
		return m;
	}

	private static PartDefinition addPart(PartDefinition parent, String name, int texX, int texY,
			float boxX, float boxY, float boxZ, int dx, int dy, int dz,
			float posX, float posY, float posZ, float offX, float offY, float offZ,
			float rotXdeg, float rotYdeg, float rotZdeg)
	{
		float[] r = CSModelBaker.convertRotationOrder(rotXdeg, rotYdeg, rotZdeg);
		PartDefinition outer = parent.addOrReplaceChild(name, CubeListBuilder.create(),
				PartPose.offsetAndRotation(posX, posY, posZ, r[0], r[1], r[2]));
		CubeListBuilder cube = CubeListBuilder.create().texOffs(texX, texY).addBox(boxX, boxY, boxZ, dx, dy, dz);
		return outer.addOrReplaceChild(name + CSModelBaker.BOX_SUFFIX, cube, PartPose.offset(offX, offY, offZ));
	}
}
