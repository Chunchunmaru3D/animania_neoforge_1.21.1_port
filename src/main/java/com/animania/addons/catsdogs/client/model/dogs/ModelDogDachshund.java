package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogDachshund
{
	private ModelDogDachshund() {}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartDefinition body = part(root, "body", 25, 0, -2, -2, -6, 4, 4, 12, 0, 20, 0, 0, 0, 0);
		leg(body, "leg1", "toe2", -1.5F, 5); leg(body, "leg2", "toe21", 1.5F, 5);
		leg(body, "leg3", "toe1", -1.5F, -5); leg(body, "leg4", "toe211", 1.5F, -5);
		PartDefinition head = part(body, "head", 16, 16, 0, 0, 0, 0, 0, 0, 0, -1, -6, 0, 0, 0);
		PartDefinition wolfHead = part(head, "wolf_head", 0, 0, -2, -2, -2, 4, 4, 4, 1, 0, 1, -1, -1, -2);
		part(wolfHead, "ear1", 16, 14, -.5F, -1.5F, -1, 1, 3, 2, -2, -2, 0, -.5F, 1.5F, 0);
		part(wolfHead, "ear2", 16, 14, -.5F, -1.5F, -1, 1, 3, 2, 2, -2, 0, .5F, 1.5F, 0);
		part(wolfHead, "nose", 0, 10, -1, -1, -1.5F, 2, 2, 3, 1, 0, 1, -1, 1, -3.5F);
		part(body, "tail", 9, 18, -.5F, -2.5F, -.5F, 1, 5, 1, -.5F, -1, 5, .5F, 2.5F, -.5F);
		return LayerDefinition.create(mesh, 64, 32);
	}

	private static void leg(PartDefinition body, String name, String toe, float x, float z)
	{
		PartDefinition leg = part(body, name, 0, 18, -1, -2, -1, 2, 4, 2, x, 0, z, 0, 2, 0);
		part(leg, toe, 0, 22, -1, -.5F, -.5F, 2, 1, 1, 0, -2, 0, 0, 3.5F, -1);
	}

	public static final Map<String, DogPartPose> BASELINE = poses(false);
	public static final Map<String, DogPartPose> SLEEP_TARGET = poses(true);
	public static final Map<String, Float> SIT_POSE_X = Map.of();
	public static final Map<String, DogPartPose> SIT_POSE = sitPose();
	public static final float SIT_BODY_Y = 20F, SIT_BODY_Z = 0F, HEAD_TRACK_OFFSET = 0F;

	private static Map<String, DogPartPose> poses(boolean sleep)
	{
		Map<String, DogPartPose> p = new HashMap<>();
		put(p, "body", 0, sleep ? 23 : 20, 0, 0, 0, 0);
		put(p, "leg1", -1.5F, 0, 5, sleep ? -1.2459905529987518F : 0, sleep ? .7487462491055673F : 0, 0);
		put(p, "toe2", 0, -2, 0, 0, 0, 0);
		put(p, "leg2", 1.5F, 0, 5, sleep ? -1.300793891511374F : 0, sleep ? -.6234298634831226F : 0, 0);
		put(p, "toe21", 0, -2, 0, 0, 0, 0);
		put(p, "leg3", -1.5F, 0, -5, sleep ? -1.1978194656437082F : 0, sleep ? .7908086840786308F : 0, 0);
		put(p, "toe1", 0, -2, 0, 0, 0, 0);
		put(p, "leg4", 1.5F, 0, -5, sleep ? -1.3425072606340382F : 0, sleep ? -1.4800374603619393F : 0, 0);
		put(p, "toe211", 0, -2, 0, -1.7453292519943296E-6F, 0, 0);
		put(p, "head", 0, -1, -6, 0, 0, 0);
		put(p, "wolf_head", 1, 0, 1, sleep ? .5423889903252698F : 0, sleep ? -.41134617942703156F : 0, sleep ? -.22148053674882842F : 0);
		put(p, "ear1", -2, -2, 0, 0, 0, .17453292519943295F);
		put(p, "ear2", 2, -2, 0, 0, 0, -.17453292519943295F);
		put(p, "nose", 1, 0, 1, 0, 0, 0);
		put(p, "tail", -.5F, -1, 5, sleep ? .8482474697617641F : .9191165640389938F, 0, 0);
		return p;
	}

	private static Map<String, DogPartPose> sitPose()
	{
		Map<String, DogPartPose> p = new HashMap<>();
		put(p, "body", 0, 20, 0, 1.3789724246959558F, 0, 0);
		put(p, "leg1", -1.5F, 0, 5, -.5787459439735637F, -(float) Math.PI, -(float) Math.PI);
		put(p, "leg2", 1.5F, 0, 5, -.6416929887759912F, -(float) Math.PI, -(float) Math.PI);
		put(p, "leg3", -1.5F, 0, -5, -1.301659574820363F, -(float) Math.PI, -(float) Math.PI);
		put(p, "leg4", 1.5F, 0, -5, -1.2743696066361798F, -(float) Math.PI, -(float) Math.PI);
		put(p, "toe211", 0, -2, 0, -1.7453292519943296E-6F, 0, 0);
		return p;
	}

	private static void put(Map<String, DogPartPose> p, String name, float x, float y, float z, float rx, float ry, float rz)
	{
		p.put(name, new DogPartPose(x, y, z, rx, ry, rz));
	}

	private static PartDefinition part(PartDefinition parent, String name, int u, int v, float x, float y, float z,
			int dx, int dy, int dz, float px, float py, float pz, float ox, float oy, float oz)
	{
		PartDefinition outer = parent.addOrReplaceChild(name, CubeListBuilder.create(), PartPose.offset(px, py, pz));
		return outer.addOrReplaceChild(name + "_box", CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, dx, dy, dz), PartPose.offset(ox, oy, oz));
	}
}
