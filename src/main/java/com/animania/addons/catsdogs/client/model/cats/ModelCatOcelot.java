package com.animania.addons.catsdogs.client.model.cats;

import java.util.HashMap;
import java.util.Map;

import com.leviathanstudio.craftstudio.client.model.CSModelBaker;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 













public class ModelCatOcelot
{
	private static final int TEX_W = 128, TEX_H = 64;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition body = addPart(root, "body", 38, 44, -3.0F, -4.5F, -5.5F, 6, 9, 11,
				0.0F, 11.5F, -4.0F, 0.0F, 1.0F, -0.0F, -1.0F, 0.0F, 0.0F);
		PartDefinition lowerBody = addPart(body, "lower_body", 76, 43, -3.5F, -4.0F, -6.5F, 7, 8, 13,
				0.0F, -1.0F, 5.0F, 0.0F, 1.0F, 5.5F, 3.0F, 0.0F, 0.0F);
		PartDefinition tail = addPart(lowerBody, "tail", 43, 15, -1.0F, -1.5F, -5.0F, 2, 3, 10,
				0.0F, -3.0F, 6.0F, 0.0F, 1.0F, 4.0F, -50.0F, 0.0F, 0.0F);
		PartDefinition tail2 = addPart(tail, "tail2", 70, 26, -1.0F, -1.5F, -3.0F, 2, 3, 6,
				0.0F, 0.0F, 4.0F, 0.0F, -0.0F, 2.0F, 12.0F, 0.0F, 0.0F);
		addPart(tail2, "tail3", 60, 4, -1.0F, -1.5F, -4.0F, 2, 3, 8,
				0.0F, 0.0F, 2.0001F, 0.0F, -0.0F, 4.0F, 12.0F, 0.0F, 0.0F);
		PartDefinition backLegR1 = addPart(lowerBody, "back_leg_r1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				-4.0F, -4.0F, 3.0F, 0.0F, 4.5F, 0.5F, -2.0F, 0.0F, 0.0F);
		addPart(backLegR1, "back_leg_r2", 18, 35, -1.0F, -6.0F, -1.5F, 2, 12, 3,
				0.0F, 2.5F, 1.0F, 0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition backLegL1 = addPart(lowerBody, "back_leg_l1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				4.0F, -4.0F, 3.0F, 0.0F, 4.5F, 0.5F, -2.0F, 0.0F, 0.0F);
		addPart(backLegL1, "back_leg_l2", 18, 35, -1.0F, -6.0F, -1.5F, 2, 12, 3,
				0.0F, 2.5F, 1.0F, -0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition neck1 = addPart(body, "neck1", 12, 19, -2.5F, -2.5F, -4.5F, 5, 5, 9,
				0.0F, -2.0F, -4.0F, 0.0F, 1.0F, -3.0F, -34.6208F, 0.0F, 0.0F);
		PartDefinition headBase = addPart(neck1, "head_base", 89, 14, -3.0F, -2.5F, -2.5F, 6, 5, 5,
				0.0F, -1.5F, -3.0F, 0.0F, 0.5F, -3.0F, 59.7518F, 0.0F, 0.0F);
		PartDefinition headFront = addPart(headBase, "head_front", 0, 12, -2.0F, -1.0F, -2.5F, 4, 2, 5,
				0.0F, 1.7F, 0.2F, 0.0F, -1.0F, -2.9F, -4.7208F, 0.0F, 0.0F);
		PartDefinition headSlope = addPart(headFront, "head_slope", 32, 12, -1.0F, -1.0F, -2.5F, 2, 2, 5,
				0.0F, -1.4F, 4.5F, 0.0F, -1.0F, -4.0F, 15.2973F, 0.0F, 0.0F);
		addPart(headSlope, "nose", 10, 0, -0.5F, -0.5F, -0.5F, 1, 1, 1,
				0.0F, -0.657F, -1.6634F, 0.0F, 0.6F, -0.8F, -22.4998F, 0.0F, 0.0F);
		addPart(headBase, "jaw", 1, 21, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				0.0F, 2.0F, -2.0F, 0.0F, -0.2F, -1.0F, -9.5028F, 0.0F, 0.0F);
		PartDefinition earR = addPart(headBase, "ear_r", 4, 4, -1.5F, -0.5F, -1.5F, 3, 1, 3,
				2.0F, -1.8F, 0.7F, 0.5F, -0.6F, -0.5F, -52.3963F, -129.7067F, 98.2346F);
		addPart(earR, "ear_r2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -1.8F, 0.0F, -0.6F, -0.0F, 20.0F, 0.0F, 0.0F);
		PartDefinition earL = addPart(headBase, "ear_l", 4, 4, -1.5F, -0.5F, -1.5F, 3, 1, 3,
				-2.0F, -1.8F, 0.7F, -0.5F, -0.6F, -0.5F, -52.3963F, 129.7068F, -98.2345F);
		addPart(earL, "ear_l2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -1.8F, 0.0F, -0.6F, -0.0F, 20.0F, 0.0F, 0.0F);
		 
		PartDefinition legR1 = addPart(body, "leg_r1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				-3.0F, -4.5F, -3.0F, 0.0F, 4.0F, -0.0F, 1.0F, 0.0F, 0.0F);
		addPart(legR1, "leg_r2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 4.8F, 0.1F, 0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);
		PartDefinition legL1 = addPart(body, "leg_l1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				3.0F, -4.5F, -3.0F, 0.0F, 4.0F, -0.0F, 1.0F, 0.0F, 0.0F);
		addPart(legL1, "leg_l2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 4.8F, 0.1F, -0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);

		return LayerDefinition.create(mesh, TEX_W, TEX_H);
	}

	public static final Map<String, CatPartPose> BASELINE = buildBaseline();

	private static Map<String, CatPartPose> buildBaseline()
	{
		Map<String, CatPartPose> m = new HashMap<>();
		m.put("body", new CatPartPose(0.0F, 11.5F, -4.0F, -0.017453292519943295F, 0.0F, 0.0F));
		m.put("lower_body", new CatPartPose(0.0F, -1.0F, 5.0F, 0.05235987755982989F, 0.0F, 0.0F));
		m.put("tail", new CatPartPose(0.0F, -3.0F, 6.0F, -0.8726646259971648F, 0.0F, 0.0F));
		m.put("tail2", new CatPartPose(0.0F, 0.0F, 4.0F, 0.20943951023931956F, 0.0F, 0.0F));
		m.put("tail3", new CatPartPose(0.0F, 0.0F, 2.0001F, 0.20943951023931956F, 0.0F, 0.0F));
		m.put("back_leg_r1", new CatPartPose(-4.0F, -4.0F, 3.0F, -0.03490658503988659F, 0.0F, 0.0F));
		m.put("back_leg_r2", new CatPartPose(0.0F, 2.5F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("back_leg_l1", new CatPartPose(4.0F, -4.0F, 3.0F, -0.03490658503988659F, 0.0F, 0.0F));
		m.put("back_leg_l2", new CatPartPose(0.0F, 2.5F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("neck1", new CatPartPose(0.0F, -2.0F, -4.0F, -0.6042469496744529F, 0.0F, 0.0F));
		m.put("head_base", new CatPartPose(0.0F, -1.5F, -3.0F, 1.0428656439931479F, 0.0F, 0.0F));
		m.put("head_front", new CatPartPose(0.0F, 1.7F, 0.2F, -0.08239350332814831F, 0.0F, 0.0F));
		m.put("head_slope", new CatPartPose(0.0F, -1.4F, 4.5F, 0.2669882516653286F, 0.0F, 0.0F));
		m.put("nose", new CatPartPose(0.0F, -0.657F, -1.6634F, -0.39269559104022017F, 0.0F, 0.0F));
		m.put("jaw", new CatPartPose(0.0F, 2.0F, -2.0F, -0.16585514815851715F, 0.0F, 0.0F));
		m.put("ear_r", new CatPartPose(2.0F, -1.8F, 0.7F, -0.9144879508627048F, -2.263808976896529F, 1.7145172093796217F));
		m.put("ear_r2", new CatPartPose(0.0F, 0.6F, -1.8F, 0.3490658503988659F, 0.0F, 0.0F));
		m.put("ear_l", new CatPartPose(-2.0F, -1.8F, 0.7F, -0.9144879508627048F, 2.263810722225781F, -1.7145154640503697F));
		m.put("ear_l2", new CatPartPose(0.0F, 0.6F, -1.8F, 0.3490658503988659F, 0.0F, 0.0F));
		m.put("leg_r1", new CatPartPose(-3.0F, -4.5F, -3.0F, 0.017453292519943295F, 0.0F, 0.0F));
		m.put("leg_r2", new CatPartPose(0.0F, 4.8F, 0.1F, 0.0F, 0.0F, 0.0F));
		m.put("leg_l1", new CatPartPose(3.0F, -4.5F, -3.0F, 0.017453292519943295F, 0.0F, 0.0F));
		m.put("leg_l2", new CatPartPose(0.0F, 4.8F, 0.1F, 0.0F, 0.0F, 0.0F));
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
