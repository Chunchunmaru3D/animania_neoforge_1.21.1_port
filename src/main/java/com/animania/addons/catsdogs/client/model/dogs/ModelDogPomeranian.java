package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogPomeranian
{
	private ModelDogPomeranian() {}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartDefinition body = part(root, "body", 20, 42, -4.5F, -3.5F, -6.5F, 9, 7, 13, 0, 13.5F, 10, 0, 0, 0);
		part(body, "back_right", 3, 27, -1.5F, -4, -1.5F, 3, 8, 3, -2, 4, 4, 0, 2.5F, 0);
		part(body, "tail", 7, 40, -2, -2, -2.5F, 4, 4, 5, 0, -3, 5, 0, -2, 2);
		part(body, "back_left", 3, 27, -1.5F, -4, -1.5F, 3, 8, 3, 2, 4, 4, 0, 2.5F, 0);
		PartDefinition upper = part(body, "upperbody", 25, 62, -5, -4.5F, -3.5F, 10, 9, 7, 0, 0, -4, 0, 0, 0);
		part(upper, "front_right", 3, 18, -1.5F, -3, -1.5F, 3, 6, 3, -2.5F, 5, 0, 0, 2.5F, 0);
		part(upper, "front_left", 3, 9, -1.5F, -3, -1.5F, 3, 6, 3, 2.5F, 5, 0, 0, 2.5F, 0);
		PartDefinition neckBase = part(upper, "neck_base", 16, 16, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -6, -3);
		PartDefinition neck = part(neckBase, "neck", 29, 27, -3.5F, -3.5F, -4, 7, 7, 8, 0, 6, 3, 0, 0, -4);
		PartDefinition head = part(neck, "pug_head", 25, 8, -5, -5, -4, 10, 10, 8, 0, .8914F, -4.3271F, 0, -2, -1);
		part(head, "snout", 36, 2, -1.5F, -1, -1, 3, 2, 2, 0, 0, -3, 0, 1.5F, -2);
		part(head, "nose", 39, 0, -.5F, -.5F, -.5F, 1, 1, 1, 0, -1, -4, 0, 1.5F, -2);
		part(head, "ear_l", 52, 0, -1.5F, -1.5F, -1, 3, 3, 2, 0, 2.0001F, 1, -2, -8, -1);
		part(head, "ear_l1", 52, 0, -1.5F, -1.5F, -1, 3, 3, 2, 0, 2.0001F, 1, 2, -8, -1);
		return LayerDefinition.create(mesh, 64, 128);
	}

	public static final Map<String, DogPartPose> BASELINE = poses(false);
	public static final Map<String, DogPartPose> SLEEP_TARGET = poses(true);
	public static final Map<String, Float> SIT_POSE_X = Map.of("body", -0.4521991012284628F, "pug_head", .8466574748131973F,
			"back_right", -1.096649710222605F, "back_left", -1.0346835404597985F, "upperbody", .09062622140980556F,
			"front_right", -.5693700352318501F, "front_left", -.560472346705183F);
	public static final float SIT_BODY_Y = 18F, SIT_BODY_Z = 10F, HEAD_TRACK_OFFSET = -.1F;

	private static Map<String, DogPartPose> poses(boolean sleep)
	{
		Map<String, DogPartPose> p = new HashMap<>();
		put(p,"body",0,sleep?20:13.5F,10,sleep?-.017203710436908107F:0,sleep?.32456666368862147F:0,sleep?.008983209660014814F:0);
		put(p,"back_right",-2,4,4,sleep?.01995783999655516F:0,sleep?-.5505641125416113F:0,sleep?1.603297848125535F:0);
		put(p,"tail",0,-3,5,sleep?-.9991468915599417F:0,0,0);
		put(p,"back_left",2,4,4,sleep?-.004707152992628707F:0,sleep?.35579060400680007F:0,sleep?-1.5581322177424257F:0);
		put(p,"upperbody",0,0,-4,sleep?.26333004155314843F:0,sleep?-.2438940550029396F:0,sleep?-.05014854539755307F:0);
		put(p,"front_right",-2.5F,5,0,sleep?-1.3828906888666832F:0,sleep?1.7535654607344908F:0,sleep?-1.4452355950771725F:0);
		put(p,"front_left",2.5F,5,0,sleep?-.9995552986049085F:0,sleep?-2.5899586542167095F:0,sleep?1.558376563837705F:0);
		put(p,"neck_base",0,1,0,sleep?.4133934506396209F:-.030037116426822413F,sleep?-.24517861733240745F:0,sleep?.008066911802717791F:0);
		put(p,"neck",0,6,3,-.5546935615518298F,0,0);
		put(p,"pug_head",0,.8914F,-4.3271F,sleep?.15711104860602554F:.6108652381980153F,sleep?-.3220132469929538F:0,sleep?.008529424054496288F:0);
		put(p,"snout",0,0,-3,0,0,0); put(p,"nose",0,-1,-4,0,0,0);
		put(p,"ear_l",0,2.0001F,1,0,0,-.23574336739612609F); put(p,"ear_l1",0,2.0001F,1,0,.0000017453292519943296F,.23574336739612609F);
		return p;
	}
	private static void put(Map<String, DogPartPose> p,String n,float x,float y,float z,float rx,float ry,float rz){p.put(n,new DogPartPose(x,y,z,rx,ry,rz));}
	private static PartDefinition part(PartDefinition parent,String n,int u,int v,float x,float y,float z,int dx,int dy,int dz,float px,float py,float pz,float ox,float oy,float oz)
	{
		PartDefinition outer=parent.addOrReplaceChild(n,CubeListBuilder.create(),PartPose.offset(px,py,pz));
		return outer.addOrReplaceChild(n+"_box",CubeListBuilder.create().texOffs(u,v).addBox(x,y,z,dx,dy,dz),PartPose.offset(ox,oy,oz));
	}
}
