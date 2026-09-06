package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogCollie
{
	private ModelDogCollie() {}
	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh=new MeshDefinition(); PartDefinition root=mesh.getRoot();
		PartDefinition body=part(root,"body",71,43,-4,-5,-5.5F,8,10,11,0,10,-5,0,.6F,-1.5F);
		PartDefinition legL1=part(body,"leg_l1",37,53,-1,-3.5F,-2,2,7,4,3.3F,0,-2,0,3,0);
		PartDefinition legL2=part(legL1,"leg_l2",12,52,-1,-4.5F,-1.5F,2,9,3,0,2.5F,1,-.01F,3.5F,-.6F);
		part(legL2,"toes_l",12,61,-1,-.5F,-.5F,2,1,1,0,-3.5F,0,0,7.5F,-1.5F);
		PartDefinition lower=part(body,"lower_body",29,24,-3,-4.5F,-6.5F,6,9,13,0,-1,6,0,.8F,5);
		PartDefinition tail=part(lower,"tail",51,13,-1.5F,-2,-3,3,4,6,0,-3.8F,6,0,2,2);
		PartDefinition tail2=part(tail,"tail2",68,24,-2,-2,-4,4,4,8,0,-1,4,0,1,2.5F);
		part(tail2,"tail3",66,10,-1.5F,-1.5F,-1,3,3,2,0,0,3,0,0,2);
		PartDefinition backL1=part(lower,"back_leg_l1",21,51,-1,-4,-2.5F,2,8,5,2.5F,-2.5F,3,0,4,.5F);
		PartDefinition backL2=part(backL1,"back_leg_l2",0,38,-1,-5.5F,-1.5F,2,11,3,0,2.5F,.5F,-.01F,3.5F,.7F);
		part(backL2,"back_toe_l",5,49,-1,-.5F,-.5F,2,1,1,.0099F,-3.5F,-1,-.01F,8.5F,-.4F);
		PartDefinition backR1=part(lower,"back_leg_r1",21,51,-1,-4,-2.5F,2,8,5,-2.5F,-2.5F,3,0,4,.5F);
		PartDefinition backR2=part(backR1,"back_leg_r2",0,38,-1,-5.5F,-1.5F,2,11,3,0,2.5F,.5F,.01F,3.5F,.7F);
		part(backR2,"back_toe_r",5,49,-1,-.5F,-.5F,2,1,1,0,-3.5F,-1,-.01F,8.5F,-.4F);
		PartDefinition neck=part(body,"neck1",5,18,-2.5F,-4,-5,5,8,10,0,-2,-3,0,2,-2);
		PartDefinition head=part(neck,"head_base",101,27,-3.5F,-3,-3,7,6,6,0,-1,-5,0,.49F,-1);
		PartDefinition front=part(head,"head_front",106,3,-1.5F,-1,-3.5F,3,2,7,0,1.2F,-1,0,-.4F,-2.9F);
		part(front,"nose",98,17,-.5F,-.5F,-.5F,1,1,1,0,-1.6F,-2.5F,0,.6F,-.8F);
		part(front,"upper_jaw_detail",107,17,-1,-1,-2.5F,2,2,5,0,-2.9638F,3.5615F,0,1,-5);
		part(head,"jaw",86,4,-1,-.5F,-3,2,1,6,0,2.5F,-1,0,-.2F,-2.9F);
		PartDefinition earL=part(head,"ear_l",76,2,-1.5F,-.5F,-1.5F,3,1,3,2,-1.7F,.7F,.5F,-.6F,-1.7F);
		part(earL,"ear_l2",61,2,-1,-.5F,-1,2,1,2,0,0,-1,0,-.6F,-1);
		PartDefinition earL1=part(head,"ear_l1",76,2,-1.5F,-.5F,-1.5F,3,1,3,-2,-1.7F,.7F,-.5F,-.6F,-1.7F);
		part(earL1,"ear_l21",61,2,-1,-.5F,-1,2,1,2,0,0,-1,0,-.6F,-1);
		PartDefinition cheek=part(head,"cheek",105,43,-1.5F,-2.5F,-1,3,5,2,-1,0,2,-2,.49F,-1);
		part(cheek,"cheek1",105,43,-.5F,-2,-1,1,4,2,0,-.49F,1,-2,.49F,-1);
		PartDefinition cheek11=part(head,"cheek11",105,43,-1.5F,-2.5F,-1,3,5,2,1,0,2,2,.49F,-1);
		part(cheek11,"cheek111",105,43,-.5F,-2,-1,1,4,2,0,-.49F,1,2,.49F,-1);
		PartDefinition legR1=part(body,"leg_r1",37,53,-1,-3.5F,-2,2,7,4,-3.3F,0,-2,0,3,0);
		PartDefinition legR2=part(legR1,"leg_r2",11,52,-1,-4.5F,-1.5F,2,9,3,0,2.5F,1,.12F,3.5F,-.6F);
		part(legR2,"toes_r",12,61,-1,-.5F,-.5F,2,1,1,-.12F,-3.5F,0,.12F,7.5F,-1.5F);
		return LayerDefinition.create(mesh,128,64);
	}

	public static final Map<String,DogPartPose> BASELINE=poses(false), SLEEP_TARGET=poses(true);
	public static final Map<String,Float> SIT_POSE_X=Map.of("body",-.10049954898833749F,"leg_l1",-.4374388517443468F,"lower_body",-.68513423385813F,"tail",.7665852593902014F,"tail2",.458307753610443F,"back_leg_l1",-.43039993887105366F,"back_leg_r1",-.4596010425861708F,"head_base",1.1523920358728F,"leg_r1",-.4434654736514832F);
	public static final float SIT_BODY_Y=12F,SIT_BODY_Z=-5F,HEAD_TRACK_OFFSET=-.7F;

	private static Map<String,DogPartPose> poses(boolean sleep)
	{
		Map<String,DogPartPose> p=new HashMap<>();
		put(p,"body",0,sleep?21:10,-5,sleep?.24093921257931322F:-.06981317007977318F,0,0);
		put(p,"leg_l1",3.3F,0,-2,sleep?-1.5503759745465628F:.06981317007977318F,sleep?-.3215908773139712F:0,sleep?.21734934240935785F:0); put(p,"leg_l2",0,2.5F,1,0,sleep?-.36083809620356766F:0,sleep?.2121360439336508F:0); put(p,"toes_l",0,-3.5F,0,0,0,0);
		put(p,"lower_body",0,-1,6,sleep?-.4014100199954278F:0,sleep?.737762892122767F:0,sleep?-.18757402537033457F:0); put(p,"tail",0,sleep?-3:-3.8F,sleep?5:6,sleep?-.19028626702793378F:-.6834220658619237F,sleep?.5352191777580771F:0,sleep?.15578110771600587F:0); put(p,"tail2",0,-1,sleep?3:4,sleep?-.030538025922144784F:-.40761990147402366F,sleep?.8290610652945904F:0,sleep?.2372164252848093F:0); put(p,"tail3",0,0,sleep?3.3F:3,sleep?.11862479327029861F:.08067609934418589F,0,0);
		put(p,"back_leg_l1",sleep?-2.5F:2.5F,sleep?-2:-2.5F,3,sleep?-1.1373455523913567F:.06981317007977318F,sleep?-.004394739056521722F:0,sleep?.2506397525618977F:0); put(p,"back_leg_l2",0,2.5F,.5F,0,0,sleep?-.3993330781855546F:0); put(p,"back_toe_l",sleep?0:.0099F,-3.5F,sleep?-.7F:-1,0,0,0);
		put(p,"back_leg_r1",sleep?2.5F:-2.5F,sleep?-2:-2.5F,3,sleep?-.9829519814306865F:.06981317007977318F,sleep?.15209846299429786F:0,sleep?-.6296746515467583F:0); put(p,"back_leg_r2",0,2.5F,.5F,0,0,0); put(p,"back_toe_r",sleep?.0099F:0,-3.5F,sleep?-.6999F:-1,0,0,0);
		put(p,"neck1",0,-2,sleep?-4:-3,sleep?-.3867108570351316F:-.8180236031049783F,0,sleep?.27705007480307586F:0); put(p,"head_base",0,sleep?-1.3F:-1,-5,sleep?.5040039640861586F:1.1907142302588394F,sleep?-.2476849101382713F:0,sleep?-.46416507858013595F:0); put(p,"head_front",0,1.2F,sleep?-.5F:-1,-.17280330391070658F,0,0); put(p,"nose",0,sleep?-1:-1.6F,-2.5F,-.091106186954104F,0,0); put(p,"upper_jaw_detail",0,-2.9638F,3.5615F,.2039696483635693F,0,0); put(p,"jaw",0,2.5F,sleep?-.5F:-1,sleep?-.2525770680316114F:-.2525770680316114F,0,0);
		put(p,"ear_l",2,-1.7F,.7F,sleep?-1.1051215384117856F:-1.293639786907449F,sleep?-.6157678680668675F:-2.588148747782391F,sleep?.44547958360828466F:2.3736477827122884F); put(p,"ear_l2",0,sleep?.6F:0,-1,sleep?.06981317007977318F:.8103877876275032F,0,0); put(p,"ear_l1",-2,-1.7F,.7F,-1.0111390488503949F,2.130956259563973F,-1.9506096426261468F); put(p,"ear_l21",0,0,-1,1.054184104192331F,0,0);
		put(p,"cheek",-1,0,2,-.36139136557644985F,-.2775701829201702F,0); put(p,"cheek1",0,-.49F,1,0,0,0); put(p,"cheek11",1,0,2,-.36139136557644985F,.2775701829201702F,1.7453292519943296E-6F); put(p,"cheek111",0,-.49F,1,0,1.7453292519943296E-6F,1.7453292519943296E-6F);
		put(p,"leg_r1",-3.3F,0,-2,sleep?-1.5566190172809469F:.06981317007977318F,0,0); put(p,"leg_r2",0,2.5F,1,0,0,0); put(p,"toes_r",-.12F,-3.5F,0,0,0,0);
		if(sleep){offset(p,"body",0,.6F,-1.5F);offset(p,"leg_l1",0,3,0);offset(p,"leg_l2",-.01F,3.5F,-.6F);offset(p,"toes_l",0,7.5F,-1.5F);offset(p,"lower_body",0,.8F,5);offset(p,"tail",0,0,3);offset(p,"tail2",0,1,2.5F);offset(p,"tail3",0,0,2);offset(p,"back_leg_l1",0,4,.5F);offset(p,"back_leg_l2",.01F,3.5F,.7F);offset(p,"back_toe_l",-.01F,8.5F,-.4F);offset(p,"back_leg_r1",0,4,.5F);offset(p,"back_leg_r2",-.01F,3.5F,.7F);offset(p,"back_toe_r",-.01F,8.5F,-.4F);offset(p,"neck1",0,2,-1);offset(p,"head_base",0,.49F,-1.8F);offset(p,"head_front",0,-.4F,-2.9F);offset(p,"nose",0,.6F,-.8F);offset(p,"upper_jaw_detail",0,1,-5);offset(p,"jaw",0,-.2F,-2.9F);offset(p,"ear_l",.5F,-.6F,-1.7F);offset(p,"ear_l2",0,-.6F,-1);offset(p,"leg_r1",0,3,0);offset(p,"leg_r2",.12F,3.5F,-.6F);offset(p,"toes_r",.12F,7.5F,-1.5F);}
		return p;
	}
	private static void put(Map<String,DogPartPose> p,String n,float x,float y,float z,float rx,float ry,float rz){p.put(n,new DogPartPose(x,y,z,rx,ry,rz));}
	private static void offset(Map<String,DogPartPose> p,String n,float x,float y,float z){DogPartPose q=p.get(n);p.put(n,new DogPartPose(q.px(),q.py(),q.pz(),q.rx(),q.ry(),q.rz(),x,y,z));}
	private static PartDefinition part(PartDefinition parent,String n,int u,int v,float x,float y,float z,int dx,int dy,int dz,float px,float py,float pz,float ox,float oy,float oz){PartDefinition outer=parent.addOrReplaceChild(n,CubeListBuilder.create(),PartPose.offset(px,py,pz));return outer.addOrReplaceChild(n+"_box",CubeListBuilder.create().texOffs(u,v).addBox(x,y,z,dx,dy,dz),PartPose.offset(ox,oy,oz));}
}
