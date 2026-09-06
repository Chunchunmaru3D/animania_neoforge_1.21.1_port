package com.animania.addons.catsdogs.client.model.cats;

import java.util.HashMap;
import java.util.Map;

import com.leviathanstudio.craftstudio.client.model.CSModelBaker;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 









public class ModelCatAmericanShorthair
{
	private static final int TEX_W = 128, TEX_H = 64;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition body = addPart(root, "body", 38, 44, -3.0F, -4.5F, -5.5F, 6, 9, 11,
				0.0F, 11.0F, -4.0F, 0.0F, 1.0F, -0.0F, 0.0F, 0.0F, 0.0F);
		PartDefinition lowerBody = addPart(body, "lower_body", 77, 42, -3.5F, -4.5F, -6.0F, 7, 9, 12,
				0.0F, -1.1F, 4.0F, 0.0F, 1.0F, 6.0F, -2.5295F, 0.0F, 0.0F);
		PartDefinition tail = addPart(lowerBody, "tail", 44, 16, -1.0F, -1.5F, -4.5F, 2, 3, 9,
				0.0F, -2.8F, 6.2F, 0.0F, 1.0F, 3.0F, -57.5296F, 0.0F, 0.0F);
		PartDefinition tail2 = addPart(tail, "tail2", 71, 27, -1.0F, -1.5F, -2.5F, 2, 3, 5,
				0.0F, 0.0F, 3.0F, 0.0F, -0.0F, 3.0F, 12.4354F, 0.0F, 0.0F);
		addPart(tail2, "tail3", 61, 5, -1.0F, -1.5F, -3.5F, 2, 3, 7,
				0.0F, 0.0F, 1.5F, 0.0F, -0.0F, 3.0F, 33.172F, 0.0F, 0.0F);
		PartDefinition backLegR1 = addPart(lowerBody, "back_leg_r1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				-4.0F, -3.9F, 3.0F, 0.0F, 4.5F, 0.5F, 2.9482F, 0.0F, 0.0F);
		addPart(backLegR1, "back_leg_r2", 18, 35, -1.0F, -5.5F, -1.5F, 2, 11, 3,
				0.0F, 2.0F, 1.0F, 0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition backLegL1 = addPart(lowerBody, "back_leg_l1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				4.0F, -3.9F, 3.0F, 0.0F, 4.5F, 0.5F, 2.12F, 0.0F, 0.0F);
		addPart(backLegL1, "back_leg_l2", 18, 35, -1.0F, -5.5F, -1.5F, 2, 11, 3,
				0.0F, 2.0F, 1.0F, -0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition neck1 = addPart(body, "neck1", 13, 20, -2.5F, -3.0F, -4.0F, 5, 6, 8,
				0.0F, 1.0F, -2.0F, 0.0F, -0.0F, -5.0F, -44.0449F, 0.0F, 0.0F);
		PartDefinition headBase = addPart(neck1, "head_base", 89, 14, -3.0F, -3.0F, -2.5F, 6, 6, 5,
				0.0F, -2.0F, -3.0F, 0.0F, 1.0F, -3.0F, 47.21F, 0.0F, 0.0F);
		PartDefinition headFront = addPart(headBase, "head_front", 0, 12, -2.0F, -1.0F, -2.5F, 4, 2, 5,
				0.0F, 1.3F, 1.4F, 0.0F, -1.0F, -2.9F, 12.1F, 0.0F, 0.0F);
		PartDefinition headSlope = addPart(headFront, "head_slope", 37, 11, -1.0F, -1.0F, -2.5F, 2, 2, 5,
				0.0F, -1.5F, 3.0F, 0.0F, -1.0F, -2.9F, 25.6072F, 0.0F, 0.0F);
		addPart(headSlope, "nose", 10, 0, -0.5F, -0.5F, -0.5F, 1, 1, 1,
				0.0F, -0.6F, -1.5F, 0.0F, 0.6F, -0.8F, -16.731F, 0.0F, 0.0F);
		addPart(headBase, "jaw", 1, 21, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				0.0F, 2.6F, -1.8F, 0.0F, -0.2F, -0.0F, -2.4901F, 0.0F, 0.0F);
		PartDefinition cheekR = addPart(headBase, "cheek_r", 32, 41, -1.5F, -2.5F, -1.5F, 3, 5, 3,
				-0.4F, 0.5F, 1.0F, -2.0F, -0.6F, -1.0F, 0.49F, -5.57F, -6.98F);
		addPart(cheekR, "cheek_r2", 32, 36, -1.5F, -1.5F, -1.0F, 3, 3, 2,
				1.0F, 0.6F, 1.5F, -2.0F, -0.6F, -1.0F, 0.0F, -13.754F, 0.0F);
		PartDefinition cheekL = addPart(headBase, "cheek_l", 32, 41, -1.5F, -2.5F, -1.5F, 3, 5, 3,
				0.4F, 0.5F, 1.0F, 2.0F, -0.6F, -1.0F, 0.49F, 5.5701F, 6.98F);
		addPart(cheekL, "cheek_l2", 32, 36, -1.5F, -1.5F, -1.0F, 3, 3, 2,
				-1.0F, 0.6F, 1.5F, 2.0F, -0.6F, -1.0F, 0.0F, 13.7541F, 0.0001F);
		PartDefinition earR = addPart(headBase, "ear_r", 3, 3, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				-2.5F, -2.0F, 0.7F, -0.5F, -0.6F, -0.5F, -63.59F, 61.45F, -47.1399F);
		addPart(earR, "ear_r2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -2.2F, 0.0F, -0.6F, -0.0F, 8.0F, 0.0F, 0.0F);
		PartDefinition earL = addPart(headBase, "ear_l", 3, 3, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				2.5F, -2.0F, 0.7F, 0.5F, -0.6F, -0.5F, -63.59F, -61.45F, 47.14F);
		addPart(earL, "ear_l2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -2.2F, 0.0F, -0.6F, -0.0F, 8.0F, 0.0F, 0.0F);
		PartDefinition legR1 = addPart(body, "leg_r1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				-3.0F, -4.5F, -3.0F, 0.0F, 4.0F, -0.0F, 0.0F, 0.0F, 0.0F);
		addPart(legR1, "leg_r2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 4.0F, 0.2F, 0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);
		PartDefinition legL1 = addPart(body, "leg_l1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				3.0F, -4.5F, -3.0F, 0.0F, 4.0F, -0.0F, 0.0F, 0.0F, 0.0F);
		addPart(legL1, "leg_l2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 4.0F, 0.2F, -0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);

		return LayerDefinition.create(mesh, TEX_W, TEX_H);
	}

	public static final Map<String, CatPartPose> BASELINE = buildBaseline();

	private static Map<String, CatPartPose> buildBaseline()
	{
		Map<String, CatPartPose> m = new HashMap<>();
		m.put("body", new CatPartPose(0.0F, 11.0F, -4.0F, 0.0F, 0.0F, 0.0F));
		m.put("lower_body", new CatPartPose(0.0F, -1.1F, 4.0F, -0.04414810342919657F, 0.0F, 0.0F));
		m.put("tail", new CatPartPose(0.0F, -2.8F, 6.2F, -1.0040809373553299F, 0.0F, 0.0F));
		m.put("tail2", new CatPartPose(0.0F, 0.0F, 3.0F, 0.21703867380250286F, 0.0F, 0.0F));
		m.put("tail3", new CatPartPose(0.0F, 0.0F, 1.5F, 0.578960619471559F, 0.0F, 0.0F));
		m.put("back_leg_r1", new CatPartPose(-4.0F, -3.9F, 3.0F, 0.05145579700729682F, 0.0F, 0.0F));
		m.put("back_leg_r2", new CatPartPose(0.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("back_leg_l1", new CatPartPose(4.0F, -3.9F, 3.0F, 0.03700098014227979F, 0.0F, 0.0F));
		m.put("back_leg_l2", new CatPartPose(0.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("neck1", new CatPartPose(0.0F, 1.0F, -2.0F, -0.7687285237116505F, 0.0F, 0.0F));
		m.put("head_base", new CatPartPose(0.0F, -2.0F, -3.0F, 0.823969939866523F, 0.0F, 0.0F));
		m.put("head_front", new CatPartPose(0.0F, 1.3F, 1.4F, 0.21118483949131386F, 0.0F, 0.0F));
		m.put("head_slope", new CatPartPose(0.0F, -1.5F, 3.0F, 0.44692995221669196F, 0.0F, 0.0F));
		m.put("nose", new CatPartPose(0.0F, -0.6F, -1.5F, -0.2920110371511713F, 0.0F, 0.0F));
		m.put("jaw", new CatPartPose(0.0F, 2.6F, -1.8F, -0.0434604437039108F, 0.0F, 0.0F));
		m.put("cheek_r", new CatPartPose(-0.4F, 0.5F, 1.0F, 0.008552113334772215F, -0.09721483933608416F, -0.12182398178920421F));
		m.put("cheek_r2", new CatPartPose(1.0F, 0.6F, 1.5F, 0.0F, -0.24005258531930007F, 0.0F));
		m.put("cheek_l", new CatPartPose(0.4F, 0.5F, 1.0F, 0.008552113334772215F, 0.09721658466533616F, 0.12182398178920421F));
		m.put("cheek_l2", new CatPartPose(-1.0F, 0.6F, 1.5F, 0.0F, 0.24005433064855206F, 1.7453292519943296E-6F));
		m.put("ear_r", new CatPartPose(-2.5F, -2.0F, 0.7F, -1.1098548713431942F, 1.0725048253505156F, -0.8227464640608749F));
		m.put("ear_r2", new CatPartPose(0.0F, 0.6F, -2.2F, 0.13962634015954636F, 0.0F, 0.0F));
		m.put("ear_l", new CatPartPose(2.5F, -2.0F, 0.7F, -1.1098548713431942F, -1.0725048253505156F, 0.8227482093901269F));
		m.put("ear_l2", new CatPartPose(0.0F, 0.6F, -2.2F, 0.13962634015954636F, 0.0F, 0.0F));
		m.put("leg_r1", new CatPartPose(-3.0F, -4.5F, -3.0F, 0.0F, 0.0F, 0.0F));
		m.put("leg_r2", new CatPartPose(0.0F, 4.0F, 0.2F, 0.0F, 0.0F, 0.0F));
		m.put("leg_l1", new CatPartPose(3.0F, -4.5F, -3.0F, 0.0F, 0.0F, 0.0F));
		m.put("leg_l2", new CatPartPose(0.0F, 4.0F, 0.2F, 0.0F, 0.0F, 0.0F));
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
