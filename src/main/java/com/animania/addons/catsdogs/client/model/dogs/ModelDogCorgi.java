package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogCorgi
{
	private ModelDogCorgi() {}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartDefinition body = part(root, "body", 37, 44, -3.5F, -3.5F, -3.5F, 7, 7, 7, 0, 18, -10, 0, .8F, 5);
		leg(body, "leg_r1", "toes_r", 2, 1.45F, 1); leg(body, "leg_r11", "toes_r1", -2, 1.45F, 1);
		PartDefinition lower = part(body, "lower_body", 29, 25, -3, -3, -6.5F, 6, 6, 13, 0, -.8851F, -1, 0, .8F, 5);
		PartDefinition tail = part(lower, "tail", 71, 27, -1.5F, -1.5F, -2.5F, 3, 3, 5, 0, -1, 7, 0, 1, -1);
		part(tail, "tail2", 70, 26, -1, -1.5F, -3, 2, 3, 6, 0, -.7853F, 2.5086F, 0, 1, 2.5F);
		part(tail, "tail3", 70, 26, 0, -1, -3, 0, 2, 6, 0, -.7853F, 2.5086F, 0, 1, 4);
		leg(lower, "leg_r2", "toes_r2", -2, 1.5352F, 5); leg(lower, "leg_r21", "toes_r21", 2, 1.5352F, 5);
		PartDefinition neck = part(body, "neck", 38, 16, -3, -1.5F, -2.5F, 6, 3, 5, 0, 1, -2, 0, 0, -3);
		PartDefinition head = part(neck, "head_base", 102, 28, -3.5F, -3, -2.5F, 7, 6, 5, 0, 2, -2, 0, -3, 0);
		PartDefinition front = part(head, "head_front", 104, 3, -1.5F, -1.5F, -3.5F, 3, 3, 7, 0, 2, 1, 0, -.4F, -3);
		part(front, "nose", 98, 17, -.5F, -.5F, -.5F, 1, 1, 1, 0, -2, -2.5F, 0, .6F, -.8F);
		part(front, "jaw", 85, 3, -1, -1, -3.5F, 2, 2, 7, 0, -2, 3.158F, 0, -.2F, -2.9F);
		ear(head, "ear_r", "ear_r2", "ear_r3", -2, .7001F, -.5F); ear(head, "ear_l", "ear_l2", "ear_l3", 2, .7F, .5F);
		return LayerDefinition.create(mesh, 128, 64);
	}

	private static void leg(PartDefinition parent, String name, String toes, float x, float y, float z)
	{
		PartDefinition leg = part(parent, name, 1, 55, -1, -1.5F, -1, 2, 3, 2, x, y, z, 0, 3, 0);
		part(leg, toes, 12, 54, -1, -.5F, -.5F, 2, 1, 1, 0, 1, -1.5F, 0, 0, 0);
	}

	private static void ear(PartDefinition head, String outer, String mid, String tip, float x, float z, float offsetX)
	{
		PartDefinition ear = part(head, outer, 76, 2, -2, -.5F, -1.5F, 4, 1, 3, x, -2, z, offsetX, -.6F, -1.7F);
		part(ear, mid, 61, 2, -1.5F, -.5F, -1, 3, 1, 2, 0, .6F, -1, 0, -.6F, -1);
		part(ear, tip, 64, 0, -.5F, -.5F, -.5F, 1, 1, 1, outer.equals("ear_r") ? 0 : -.0001F, .6F, -.9999F, 0, -.6F, -2.5F);
	}

	public static final Map<String, DogPartPose> BASELINE = poses(false);
	public static final Map<String, DogPartPose> SLEEP_TARGET = poses(true);
	public static final Map<String, Float> SIT_POSE_X = Map.of(
			"body", -.07355690132530102F, "leg_r1", -.39865763576503277F, "leg_r11", -.40206975445268167F,
			"lower_body", -.06664190682889948F, "tail", -.0519846317706511F, "tail2", .3797661919414462F,
			"tail3", .3947725328500934F, "leg_r2", -.6804916580478251F, "leg_r21", -.7049157956002338F);
	public static final float SIT_BODY_Y = 18F, SIT_BODY_Z = -10F, HEAD_TRACK_OFFSET = -.7F;

	private static Map<String, DogPartPose> poses(boolean sleep)
	{
		Map<String, DogPartPose> p = new HashMap<>();
		put(p,"body",0,sleep?21:18,-10,sleep?.16237845228854444F:0,sleep?.17407215827690645F:0,sleep?1.7453292519943296E-6F:0);
		put(p,"leg_r1",2,1.45F,1,0,0,sleep?-1.3385645618537831F:0); put(p,"toes_r",0,1,-1.5F,0,0,0);
		put(p,"leg_r11",-2,1.45F,1,0,0,sleep?1.2984691129477173F:0); put(p,"toes_r1",0,1,-1.5F,0,0,0);
		put(p,"lower_body",0,sleep?-1:-.8851F,-1,sleep?-.08702560716294126F:0,sleep?.12910549542852454F:0,sleep?-.10515434210340635F:0);
		put(p,"tail",0,sleep?0:-1,7,sleep?-.5764700346289631F:-.4323512169747833F,0,0);
		put(p,"tail2",0,-.7853F,2.5086F,sleep?.321653709167043F:-.2780745830739965F,0,0);
		put(p,"tail3",0,-.7853F,2.5086F,sleep?.2945923791148709F:-.29183650422597185F,0,0);
		put(p,"leg_r2",-2,1.5352F,5,0,0,sleep?1.372514706463577F:0); put(p,"toes_r2",0,1,-1.5F,0,0,0);
		put(p,"leg_r21",2,1.5352F,5,0,0,sleep?-1.2947428349947094F:0); put(p,"toes_r21",0,1,-1.5F,0,0,0);
		put(p,"neck",0,1,-2,sleep?-.12372464534462602F:-.7303504787895471F,sleep?-.2057952627611554F:0,sleep?.025757569100932316F:0);
		put(p,"head_base",0,2,-2,sleep?.1230230229853243F:.6643194371988457F,sleep?-.35411159726638153F:0,sleep?-.04533492732055271F:0);
		put(p,"head_front",0,2,1,.04036772026937685F,0,0); put(p,"nose",0,-2,-2.5F,0,0,0); put(p,"jaw",0,-2,3.158F,.26870740097854295F,0,0);
		put(p,"ear_r",-2,-2,.7001F,sleep?-1.0310741995666741F:-1.3181616628979693F,sleep?.7134958342030379F:1.9450786942265765F,sleep?-.5051471547462147F:-1.6712679505152022F);
		put(p,"ear_r2",0,.6F,-1,sleep?.02950479100496414F:.06981317007977318F,0,0); put(p,"ear_r3",0,.6F,-.9999F,.06981317007977318F,1.7453292519943296E-6F,0);
		put(p,"ear_l",2,-2,.7F,sleep?-1.1604729103095337F:-1.3181634082272213F,sleep?-.9018849283340539F:-1.9450786942265765F,sleep?.673135095250669F:1.6712696958444542F);
		put(p,"ear_l2",0,.6F,-1,.06981317007977318F,0,0); put(p,"ear_l3",-.0001F,.6F,-.9999F,.06981317007977318F,0,1.7453292519943296E-6F);
		return p;
	}

	private static void put(Map<String, DogPartPose> p, String n, float x, float y, float z, float rx, float ry, float rz)
	{
		p.put(n, new DogPartPose(x, y, z, rx, ry, rz));
	}

	private static PartDefinition part(PartDefinition parent, String name, int u, int v, float x, float y, float z,
			int dx, int dy, int dz, float px, float py, float pz, float ox, float oy, float oz)
	{
		PartDefinition outer = parent.addOrReplaceChild(name, CubeListBuilder.create(), PartPose.offset(px, py, pz));
		return outer.addOrReplaceChild(name + "_box", CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, dx, dy, dz), PartPose.offset(ox, oy, oz));
	}
}
