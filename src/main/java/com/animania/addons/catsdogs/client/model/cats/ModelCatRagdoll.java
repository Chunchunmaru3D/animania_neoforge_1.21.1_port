package com.animania.addons.catsdogs.client.model.cats;

import java.util.HashMap;
import java.util.Map;

import com.leviathanstudio.craftstudio.client.model.CSModelBaker;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 





public class ModelCatRagdoll
{
	private static final int TEX_W = 128, TEX_H = 64;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition body = addPart(root, "body", 38, 42, -4.5F, -5.0F, -5.5F, 9, 10, 11,
				0.0F, 12.0F, -4.0F, 0.0F, 1.0F, -0.0F, 2.0F, 0.0F, 0.0F);
		PartDefinition lowerBody = addPart(body, "lower_body", 80, 41, -4.0F, -4.5F, -6.5F, 8, 9, 13,
				0.0F, -1.0F, 4.0F, 0.0F, 0.5F, 6.0F, -2.5295F, 0.0F, 0.0F);
		PartDefinition tail = addPart(lowerBody, "tail", 44, 16, -1.5F, -2.0F, -4.5F, 3, 4, 9,
				0.0F, -3.0F, 5.0F, 0.0F, -0.0F, 5.0F, -55.7673F, 0.0F, 0.0F);
		PartDefinition tail2 = addPart(tail, "tail2", 71, 27, -1.5F, -2.0F, -2.5F, 3, 4, 5,
				0.0F, 0.0F, 3.0F, 0.0F, -0.0F, 3.0F, 23.188F, 0.0F, 0.0F);
		PartDefinition tail3 = addPart(tail2, "tail3", 62, 6, -2.0F, -2.5F, -3.0F, 4, 5, 6,
				0.0F, 0.0F, 3.0F, 0.0F, -0.0F, 2.0F, 24.9968F, 0.0F, 0.0F);
		addPart(tail3, "tail4", 57, 5, -1.5F, -2.0F, -1.0F, 3, 4, 2,
				0.0F, -1.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		PartDefinition backLegR1 = addPart(lowerBody, "back_leg_r1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				-4.0F, -4.5F, 3.0F, 0.0F, 4.5F, 0.5F, -0.0001F, 0.0F, 0.0F);
		addPart(backLegR1, "back_leg_r2", 18, 35, -1.0F, -6.0F, -1.5F, 2, 12, 3,
				0.0F, 2.5F, 1.0F, 0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition backLegL1 = addPart(lowerBody, "back_leg_l1", 19, 51, -1.0F, -4.0F, -2.5F, 2, 8, 5,
				4.0F, -4.5F, 3.0F, 0.0F, 4.5F, 0.5F, -0.0001F, 0.0F, 0.0F);
		addPart(backLegL1, "back_leg_l2", 18, 35, -1.0F, -6.0F, -1.5F, 2, 12, 3,
				0.0F, 2.5F, 1.0F, -0.01F, 3.5F, 0.7F, 0.0F, 0.0F, 0.0F);
		PartDefinition neck1 = addPart(body, "neck1", 11, 16, -2.5F, -3.0F, -5.0F, 5, 6, 10,
				0.0F, -3.0F, -5.0F, 0.0F, 1.0F, -2.0F, -49.7411F, 0.0F, 0.0F);
		PartDefinition headBase = addPart(neck1, "head_base", 102, 4, -3.0F, -3.0F, -2.5F, 6, 6, 5,
				0.0F, -1.0F, -1.7F, 0.0F, -1.0F, -3.0F, 59.4938F, 0.0F, 0.0F);
		PartDefinition headFront = addPart(headBase, "head_front", 0, 12, -2.0F, -1.0F, -2.5F, 4, 2, 5,
				0.0F, 1.5F, 1.5F, 0.0F, -1.0F, -2.9F, 4.7749F, 0.0F, 0.0F);
		PartDefinition headSlope = addPart(headFront, "head_slope", 37, 11, -1.0F, -1.0F, -2.5F, 2, 2, 5,
				0.0F, -1.0F, 3.0F, 0.0F, -1.0F, -2.9F, 20.1241F, 0.0F, 0.0F);
		addPart(headSlope, "nose", 10, 0, -0.5F, -0.5F, -0.5F, 1, 1, 1,
				0.0F, -0.7F, -1.5F, 0.0F, 0.6F, -0.8F, -10.1283F, 0.0F, 0.0F);
		addPart(headBase, "jaw", 0, 20, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				0.0F, 2.4F, -0.5F, 0.0F, -0.2F, -1.0F, -0.5632F, 0.0F, 0.0F);
		PartDefinition cheekL = addPart(headBase, "cheek_l", 32, 41, -1.5F, -2.5F, -1.5F, 3, 5, 3,
				1.4F, 1.0F, 2.0F, 2.0F, -0.6F, -1.0F, 2.6613F, 9.9071F, -4.7973F);
		addPart(cheekL, "cheek_l2", 32, 36, -1.5F, -1.5F, -1.0F, 3, 3, 2,
				-1.0F, 0.6F, 1.5F, 2.0F, -0.6F, -1.0F, 0.0F, 13.7541F, 0.0001F);
		PartDefinition cheekR = addPart(headBase, "cheek_r", 32, 41, -1.5F, -2.5F, -1.5F, 3, 5, 3,
				-1.4F, 1.0F, 2.0F, -2.0F, -0.6F, -1.0F, 2.6613F, -9.907F, 4.7974F);
		addPart(cheekR, "cheek_r2", 32, 36, -1.5F, -1.5F, -1.0F, 3, 3, 2,
				1.0F, 0.6F, 1.5F, -2.0F, -0.6F, -1.0F, 0.0F, -13.754F, 0.0F);
		PartDefinition earR = addPart(headBase, "ear_r", 3, 3, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				-2.5F, -2.5F, 0.7001F, -0.5F, -0.6F, -0.5F, -59.1696F, 83.6302F, -82.1078F);
		PartDefinition earR2 = addPart(earR, "ear_r2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -1.7F, 0.0F, -0.6F, -0.5F, 8.6231F, 0.0F, 0.0F);
		addPart(earR2, "ear_r3", 1, 0, -0.5F, -0.5F, -0.5F, 1, 1, 1,
				0.0F, 0.6F, -0.3F, 0.0F, -0.6F, -0.5F, 10.8763F, 0.0001F, 0.0F);
		PartDefinition earL = addPart(headBase, "ear_l", 3, 3, -1.5F, -0.5F, -2.0F, 3, 1, 4,
				2.5F, -2.5F, 0.7001F, 0.5F, -0.6F, -0.5F, -59.1696F, -83.6301F, 82.1079F);
		PartDefinition earL2 = addPart(earL, "ear_l2", 0, 0, -1.0F, -0.5F, -0.5F, 2, 1, 1,
				0.0F, 0.6F, -1.7F, 0.0F, -0.6F, -0.5F, 8.6231F, 0.0F, 0.0F);
		addPart(earL2, "ear_l3", 1, 0, -0.5F, -0.5F, -0.5F, 1, 1, 1,
				0.0F, 0.6F, -0.3F, 0.0F, -0.6F, -0.5F, 10.8763F, 0.0F, 0.0001F);
		addPart(neck1, "mane", 96, 22, -5.0F, -4.0F, -3.0F, 10, 8, 6,
				0.0F, -2.5F, 3.0F, 0.0F, 1.8F, -2.0F, 9.1841F, 0.0F, 0.0F);
		PartDefinition legR1 = addPart(body, "leg_r1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				-4.2F, -5.0F, -2.0F, 0.0F, 4.0F, -0.0F, -2.0F, 0.0F, 0.0F);
		addPart(legR1, "leg_r2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 4.0F, 0.2F, 0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);
		PartDefinition legL1 = addPart(body, "leg_l1", 2, 37, -1.0F, -4.5F, -2.0F, 2, 9, 4,
				4.2F, -5.0F, -2.0F, 0.0F, 4.0F, -0.0F, -2.0F, 0.0F, 0.0F);
		addPart(legL1, "leg_l2", 1, 52, -1.0F, -4.5F, -1.5F, 2, 9, 3,
				0.0F, 4.0F, 0.2F, -0.12F, 4.0F, -0.6F, 0.0F, 0.0F, 0.0F);

		return LayerDefinition.create(mesh, TEX_W, TEX_H);
	}

	public static final Map<String, CatPartPose> BASELINE = buildBaseline();

	private static Map<String, CatPartPose> buildBaseline()
	{
		Map<String, CatPartPose> m = new HashMap<>();
		m.put("body", new CatPartPose(0.0F, 12.0F, -4.0F, 0.03490658503988659F, 0.0F, 0.0F));
		m.put("lower_body", new CatPartPose(0.0F, -1.0F, 4.0F, -0.04414810342919657F, 0.0F, 0.0F));
		m.put("tail", new CatPartPose(0.0F, -3.0F, 5.0F, -0.9733229999474338F, 0.0F, 0.0F));
		m.put("tail2", new CatPartPose(0.0F, 0.0F, 3.0F, 0.40470694695244513F, 0.0F, 0.0F));
		m.put("tail3", new CatPartPose(0.0F, 0.0F, 3.0F, 0.43627646246251855F, 0.0F, 0.0F));
		m.put("tail4", new CatPartPose(0.0F, -1.0F, 3.0F, 0.0F, 0.0F, 0.0F));
		m.put("back_leg_r1", new CatPartPose(-4.0F, -4.5F, 3.0F, -1.7453292519943296E-6F, 0.0F, 0.0F));
		m.put("back_leg_r2", new CatPartPose(0.0F, 2.5F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("back_leg_l1", new CatPartPose(4.0F, -4.5F, 3.0F, -1.7453292519943296E-6F, 0.0F, 0.0F));
		m.put("back_leg_l2", new CatPartPose(0.0F, 2.5F, 1.0F, 0.0F, 0.0F, 0.0F));
		m.put("neck1", new CatPartPose(0.0F, -3.0F, -5.0F, -0.8681459685637515F, 0.0F, 0.0F));
		m.put("head_base", new CatPartPose(0.0F, -1.0F, -1.7F, 1.0383626945230024F, 0.0F, 0.0F));
		m.put("head_front", new CatPartPose(0.0F, 1.5F, 1.5F, 0.08333772645347724F, 0.0F, 0.0F));
		m.put("head_slope", new CatPartPose(0.0F, -1.0F, 3.0F, 0.35123180400059084F, 0.0F, 0.0F));
		m.put("nose", new CatPartPose(0.0F, -0.7F, -1.5F, -0.17677218262974168F, 0.0F, 0.0F));
		m.put("jaw", new CatPartPose(0.0F, 2.4F, -0.5F, -0.009829694347232064F, 0.0F, 0.0F));
		m.put("cheek_l", new CatPartPose(1.4F, 1.0F, 2.0F, 0.0464484473833251F, 0.17291151432433022F, -0.08372868020592397F));
		m.put("cheek_l2", new CatPartPose(-1.0F, 0.6F, 1.5F, 0.0F, 0.24005433064855206F, 1.7453292519943296E-6F));
		m.put("cheek_r", new CatPartPose(-1.4F, 1.0F, 2.0F, 0.0464484473833251F, -0.17290976899507823F, 0.08373042553517596F));
		m.put("cheek_r2", new CatPartPose(1.0F, 0.6F, 1.5F, 0.0F, -0.24005258531930007F, 0.0F));
		m.put("ear_r", new CatPartPose(-2.5F, -2.5F, 0.7001F, -1.0327043370880369F, 1.4596223441013618F, -1.433051451569F));
		m.put("ear_r2", new CatPartPose(0.0F, 0.6F, -1.7F, 0.15050148672872304F, 0.0F, 0.0F));
		m.put("ear_r3", new CatPartPose(0.0F, 0.6F, -0.3F, 0.1898272454346593F, 1.7453292519943296E-6F, 0.0F));
		m.put("ear_l", new CatPartPose(2.5F, -2.5F, 0.7001F, -1.0327043370880369F, -1.4596205987721098F, 1.433053196898252F));
		m.put("ear_l2", new CatPartPose(0.0F, 0.6F, -1.7F, 0.15050148672872304F, 0.0F, 0.0F));
		m.put("ear_l3", new CatPartPose(0.0F, 0.6F, -0.3F, 0.1898272454346593F, 0.0F, 1.7453292519943296E-6F));
		m.put("mane", new CatPartPose(0.0F, -2.5F, 3.0F, 0.16029278383241125F, 0.0F, 0.0F));
		m.put("leg_r1", new CatPartPose(-4.2F, -5.0F, -2.0F, -0.03490658503988659F, 0.0F, 0.0F));
		m.put("leg_r2", new CatPartPose(0.0F, 4.0F, 0.2F, 0.0F, 0.0F, 0.0F));
		m.put("leg_l1", new CatPartPose(4.2F, -5.0F, -2.0F, -0.03490658503988659F, 0.0F, 0.0F));
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
