package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 









public class ModelDogPug
{
	private static final int TEX_W = 64, TEX_H = 64;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition body = addPart(root, "body", 20, 42, -4.5F, -4.5F, -6.5F, 9, 9, 13,
				0.0F, 13.5F, 10.0F, 0.0F, -0.0F, -0.0F, 0.0F, 0.0F, 0.0F);
		addPart(body, "tail", 6, 39, -1.0F, -3.0F, -3.0F, 2, 6, 6,
				0.0F, -5.0F, 4.0F, 0.0F, -0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		PartDefinition neckBase = addPart(body, "neck_base", 16, 16, 0.0F, 0.0F, 0.0F, 0, 0, 0,
				0.0F, -1.0F, -4.0F, 0.0F, -0.0F, -0.0F, 0.0F, 0.0F, -8.9999F);
		PartDefinition neck = addPart(neckBase, "neck", 27, 27, -3.5F, -3.5F, -4.0F, 7, 7, 8,
				0.7821F, -4.9384F, -3.5F, 0.0F, 3.0F, 4.0F, -34.5076F, -6.251F, 10.9432F);
		PartDefinition pugHead = addPart(neck, "pug_head", 28, 13, -4.0F, -4.0F, -3.0F, 8, 8, 6,
				0.0F, 0.8914F, -4.3271F, 0.0F, -0.0F, -0.0F, 35.0F, 0.0F, 0.0F);
		addPart(pugHead, "ear1", 23, 9, -0.5F, -2.0F, -2.0F, 1, 4, 4,
				-4.0F, -4.0F, -0.0F, 0.5F, 2.0F, -0.0F, 15.0F, 0.0F, -10.0F);
		addPart(pugHead, "ear2", 24, 1, -0.5F, -2.0F, -2.0F, 1, 4, 4,
				4.0F, -4.0F, 1.0E-4F, 0.5F, 2.0F, -0.0F, -10.0F, 0.0F, -8.9999F);
		addPart(pugHead, "nose", 37, 9, -2.0F, -1.5F, -0.5F, 4, 3, 1,
				0.0F, 0.0F, -1.5F, 0.0F, 1.5F, -2.0F, 0.0F, 0.0F, 0.0F);
		addPart(body, "back_right", 3, 27, -1.5F, -3.0F, -1.5F, 3, 6, 3,
				-2.0F, 5.0F, 4.0F, 0.0F, 2.5F, -0.0F, 0.0F, 0.0F, 0.0F);
		addPart(body, "back_left", 3, 0, -1.5F, -3.0F, -1.5F, 3, 6, 3,
				2.5F, 5.0F, 4.0F, 0.0F, 2.5F, -0.0F, 0.0F, 0.0F, 0.0F);
		addPart(body, "front_right", 3, 18, -1.5F, -3.0F, -1.5F, 3, 6, 3,
				-2.5F, 5.0F, -4.0F, 0.0F, 2.5F, -0.0F, 0.0F, 0.0F, 0.0F);
		addPart(body, "front_left", 3, 9, -1.5F, -3.0F, -1.5F, 3, 6, 3,
				2.5F, 5.0F, -4.0F, 0.0F, 2.5F, -0.0F, 0.0F, 0.0F, 0.0F);

		return LayerDefinition.create(mesh, TEX_W, TEX_H);
	}

	public static final Map<String, DogPartPose> BASELINE = buildBaseline();
	public static final Map<String, DogPartPose> SLEEP_TARGET = buildSleepTarget();

	 
	public static final Map<String, Float> SIT_POSE_X = Map.of(
			"body", -0.3811921259403255F,
			"pug_head", 0.8168455058598821F,
			"back_right", -1.2237498223405883F,
			"back_left", -1.2199013713399407F,
			"front_right", -0.587254424077036F,
			"front_left", -0.5707523359994298F);
	public static final float SIT_BODY_Y = 17.0F;
	public static final float SIT_BODY_Z = 10.0F;
	 
	public static final float HEAD_TRACK_OFFSET = -0.7F;

	private static Map<String, DogPartPose> buildBaseline()
	{
		Map<String, DogPartPose> m = new HashMap<>();
		m.put("body", new DogPartPose(0.0F, 13.5F, 10.0F, 0.0F, 0.0F, 0.0F));
		m.put("tail", new DogPartPose(0.0F, -5.0F, 4.0F, 0.0F, 0.0F, 0.0F));
		m.put("neck_base", new DogPartPose(0.0F, -1.0F, -4.0F, 0.0F, 0.0F, -0.15707788735023767F));
		m.put("neck", new DogPartPose(0.7821F, -4.9384F, -3.5F, -0.6022712369611952F, -0.10910053154216555F, 0.19099487070424345F));
		m.put("pug_head", new DogPartPose(0.0F, 0.8914F, -4.3271F, 0.6108652381980153F, 0.0F, 0.0F));
		m.put("ear1", new DogPartPose(-4.0F, -4.0F, -0.0F, 0.2617993877991494F, 0.0F, -0.17453292519943295F));
		m.put("ear2", new DogPartPose(4.0F, -4.0F, 1.0E-4F, -0.17453292519943295F, 0.0F, -0.15707788735023767F));
		m.put("nose", new DogPartPose(0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F));
		m.put("back_right", new DogPartPose(-2.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F));
		m.put("back_left", new DogPartPose(2.5F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F));
		m.put("front_right", new DogPartPose(-2.5F, 5.0F, -4.0F, 0.0F, 0.0F, 0.0F));
		m.put("front_left", new DogPartPose(2.5F, 5.0F, -4.0F, 0.0F, 0.0F, 0.0F));
		return m;
	}

	private static Map<String, DogPartPose> buildSleepTarget()
	{
		Map<String, DogPartPose> m = new HashMap<>();
		m.put("body", new DogPartPose(0.0F, 18.0F, 10.0F, 0.0F, 0.0F, 0.0F));
		m.put("tail", new DogPartPose(0.0F, -5.0F, 4.0F, -0.8361645553502074F, 0.0F, 0.0F));
		m.put("neck_base", new DogPartPose(0.0F, -1.0F, -4.0F, 0.0F, 0.0F, -0.15707788735023767F));
		m.put("neck", new DogPartPose(0.7821F, -2.0F, -7.0F, 0.02995159529347469F, 0.004747295565424576F, 0.15715119117882143F));
		m.put("pug_head", new DogPartPose(0.0F, 0.8914F, -4.3271F, 0.6108652381980153F, 0.0F, 0.0F));
		m.put("ear1", new DogPartPose(-4.0F, -4.0F, -0.0F, 0.2617993877991494F, 0.0F, -0.17453292519943295F));
		m.put("ear2", new DogPartPose(4.0F, -4.0F, 1.0E-4F, -0.17453292519943295F, 0.0F, -0.15707788735023767F));
		m.put("nose", new DogPartPose(0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F));
		m.put("back_right", new DogPartPose(-2.0F, 5.0F, 4.0F, 0.08340928495280901F, -0.4044154769673621F, 1.5276709863073688F));
		m.put("back_left", new DogPartPose(2.5F, 5.0F, 4.0F, -0.022273891913951634F, 0.422294629824792F, -1.5212726092695574F));
		m.put("front_right", new DogPartPose(-2.5F, 5.0F, -4.0F, 0.0429682608548484F, -0.612518064999654F, 1.4249827944370304F));
		m.put("front_left", new DogPartPose(2.5F, 5.0F, -4.0F, -0.02410648762854568F, 0.3846740577980542F, -1.511325977862442F));
		return m;
	}

	private static PartDefinition addPart(PartDefinition parent, String name, int texX, int texY,
			float boxX, float boxY, float boxZ, int dx, int dy, int dz,
			float posX, float posY, float posZ, float offX, float offY, float offZ,
			float rotXdeg, float rotYdeg, float rotZdeg)
	{
		PartDefinition outer = parent.addOrReplaceChild(name, CubeListBuilder.create(),
				PartPose.offsetAndRotation(posX, posY, posZ,
						(float) Math.toRadians(rotXdeg), (float) Math.toRadians(rotYdeg), (float) Math.toRadians(rotZdeg)));
		CubeListBuilder cube = CubeListBuilder.create().texOffs(texX, texY).addBox(boxX, boxY, boxZ, dx, dy, dz);
		return outer.addOrReplaceChild(name + "_box", cube, PartPose.offset(offX, offY, offZ));
	}
}
