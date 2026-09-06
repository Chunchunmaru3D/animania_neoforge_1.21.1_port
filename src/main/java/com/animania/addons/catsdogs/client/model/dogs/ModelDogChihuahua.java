package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogChihuahua
{
	private ModelDogChihuahua() {}
	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition(); PartDefinition root = mesh.getRoot();
		PartDefinition body = part(root,"body",20,42,-3,-3.5F,-6.5F,6,7,13,0,13.5F,10,0,0,0);
		part(body,"tail",10,43,-1,-3,-1,2,6,2,0,-6,7,0,0,2);
		PartDefinition neck=part(body,"neck",28,28,-2.5F,-3,-3.5F,5,6,7,0,-1,-5,0,0,-1);
		PartDefinition head=part(neck,"pug_head",27,12,-4,-4,-3.5F,8,8,7,0,.8914F,-4.3271F,0,-1,0);
		part(head,"snout",47,27,-2,-1.5F,-2,4,3,4,0,0,-2,0,1.5F,-2);
		part(head,"nose",40,3,-.5F,-.5F,-.5F,1,1,1,0,-1.5F,-4,0,1.5F,-2);
		ear(head,"ear_l","ear_l2","ear_l3",-3); ear(head,"ear_r","ear_r2","ear_r3",3);
		part(body,"front_right",4,19,-1,-3,-1,2,6,2,-1.5F,3.5F,-4,0,2.5F,0);
		part(body,"front_left",4,19,-1,-3,-1,2,6,2,1.5F,3.5F,-4,0,2.5F,0);
		part(body,"back_left",4,19,-1,-3,-1,2,6,2,1.5F,3.5F,4,0,2.5F,0);
		part(body,"back_right",4,19,-1,-3,-1,2,6,2,-1.5F,3.5F,4,0,2.5F,0);
		return LayerDefinition.create(mesh,64,64);
	}
	private static void ear(PartDefinition parent,String outer,String middle,String tip,float x)
	{
		PartDefinition ear=part(parent,outer,16,8,-2.5F,-2,-.5F,5,4,1,x,-3.4909F,.5292F,0,-1,0);
		PartDefinition mid=part(ear,middle,18,5,-1.5F,-1,-.5F,3,2,1,0,-2,0,0,-1,0);
		part(mid,tip,19,3,-1,-.5F,-.5F,2,1,1,0,-.5F,0,0,-1,0);
	}
	public static final Map<String,DogPartPose> BASELINE=poses(false), SLEEP_TARGET=poses(true);
	public static final Map<String,Float> SIT_POSE_X=Map.of("body",-.5040528333052143F,"neck",-.9206419818052369F,"pug_head",1.2854227767890596F,"front_left",-.04153534553896105F,"back_left",5.323938387649487F,"back_right",-.9943507267754614F);
	public static final float SIT_BODY_Y=18F,SIT_BODY_Z=10F,HEAD_TRACK_OFFSET=-.9F;
	private static Map<String,DogPartPose> poses(boolean sleep)
	{
		Map<String,DogPartPose> p=new HashMap<>();
		put(p,"body",0,sleep?19:13.5F,10,0,0,0); put(p,"tail",0,sleep?-3:-6,sleep?9:7,sleep?-1.1438608664890515F:-.6430019857149869F,0,0);
		put(p,"neck",0,sleep?0:-1,-5,sleep?.25098358242454055F:-.9424777960769379F,0,0); put(p,"pug_head",sleep?1:0,sleep?0:.8914F,sleep?-6:-4.3271F,sleep?-.7135831006656377F:.9867323645905062F,0,0);
		put(p,"snout",0,0,-2,0,0,0); put(p,"nose",0,-1.5F,-4,-1.7453292519943296E-6F,0,0);
		put(p,"ear_l",-3,-3.4909F,.5292F,sleep?.568769641969164F:-.04002563573598596F,sleep?-.3183445649052617F:0,sleep?-.521092482792435F:-.43320991896676453F);
		put(p,"ear_l2",0,-2,0,sleep?.4638212487174931F:0,0,0); put(p,"ear_l3",0,-.5F,0,sleep?.9510037294729303F:0,0,0);
		put(p,"ear_r",3,-3.4909F,.5292F,sleep?.5938604952958346F:-.04002563573598596F,sleep?.3357699321571731F:1.7453292519943296E-6F,sleep?.5306621230811199F:.43321166429601654F);
		put(p,"ear_r2",0,-2,0,sleep?.47525315531805595F:0,0,0); put(p,"ear_r3",0,-.5F,0,sleep?.610034461474066F:0,0,0);
		put(p,"front_right",-1.5F,3.5F,-4,sleep?.017643533408410676F:0,sleep?-.43522053826506196F:0,sleep?1.4188357448115063F:0);
		put(p,"front_left",1.5F,3.5F,-4,sleep?-.037261034200826944F:0,sleep?.5536847612441771F:0,sleep?-1.347230121589935F:0);
		put(p,"back_left",1.5F,3.5F,4,sleep?-.034812337260278894F:0,sleep?.6960373056953386F:0,sleep?-1.529164988147076F:0);
		put(p,"back_right",-1.5F,3.5F,4,sleep?.02530727415391778F:0,sleep?-.7541567697867498F:0,sleep?1.458571655891661F:0); return p;
	}
	private static void put(Map<String,DogPartPose> p,String n,float x,float y,float z,float rx,float ry,float rz){p.put(n,new DogPartPose(x,y,z,rx,ry,rz));}
	private static PartDefinition part(PartDefinition parent,String n,int u,int v,float x,float y,float z,int dx,int dy,int dz,float px,float py,float pz,float ox,float oy,float oz){PartDefinition outer=parent.addOrReplaceChild(n,CubeListBuilder.create(),PartPose.offset(px,py,pz));return outer.addOrReplaceChild(n+"_box",CubeListBuilder.create().texOffs(u,v).addBox(x,y,z,dx,dy,dz),PartPose.offset(ox,oy,oz));}
}
