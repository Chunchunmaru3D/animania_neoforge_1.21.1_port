package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogHusky {
	private ModelDogHusky() {}
	public static LayerDefinition createBodyLayer(){MeshDefinition m=new MeshDefinition();PartDefinition r=m.getRoot();
		PartDefinition body=p(r,"body",71,43,-4,-5,-5.5F,8,10,11,0,10,-5,0,.6F,-1.5F);PartDefinition l1=p(body,"leg_l1",0,54,-1,-3.5F,-1.5F,2,7,3,3.3F,0,-2,0,3,0);PartDefinition l2=p(l1,"leg_l2",15,53,-1,-4.5F,-1,2,9,2,0,2.5F,1,-.01F,3.5F,-.6F);p(l2,"toes_l",12,54,-1,-.5F,-.5F,2,1,1,0,-3.5F,.6F,0,7.5F,-1.5F);
		PartDefinition lower=p(body,"lower_body",29,24,-3,-4.5F,-6.5F,6,9,13,0,-1,6,0,.8F,5);PartDefinition tail=p(lower,"tail",52,14,-1.5F,-2,-2.5F,3,4,5,0,-4,6,0,2,2);PartDefinition tail2=p(tail,"tail2",69,25,-2,-2,-3.5F,4,4,7,0,-1,3,0,1,2.5F);p(tail2,"tail3",64,8,-1.5F,-1.5F,-2,3,3,4,0,0,3.3F,0,0,2);
		PartDefinition br1=p(lower,"back_leg_r1",20,52,-1,-4,-2,2,8,4,2.5F,-2,3,0,4,.5F);PartDefinition br2=p(br1,"back_leg_r2",0,39,-1,-5.5F,-1,2,11,2,0,2.5F,.5F,-.01F,3.5F,.7F);p(br2,"back_toe_r",1,40,-1,-.5F,-.5F,2,1,1,.0099F,-3.5F,-.6999F,-.01F,8.5F,-.4F);
		PartDefinition bl1=p(lower,"back_leg_l1",20,52,-1,-4,-2,2,8,4,-2.5F,-2,3,0,4,.5F);PartDefinition bl2=p(bl1,"back_leg_l2",0,39,-1,-5.5F,-1,2,11,2,0,2.5F,.5F,.01F,3.5F,.7F);p(bl2,"back_toe_l",1,40,-1,-.5F,-.5F,2,1,1,0,-3.5F,-.7F,-.01F,8.5F,-.4F);
		PartDefinition neck=p(body,"neck1",5,18,-2.5F,-3.5F,-5,5,7,10,0,-2,-4,0,2,-1);PartDefinition head=p(neck,"head_base",101,27,-3.5F,-3,-3,7,6,6,0,-1.3F,-5,0,.49F,-1.8F);PartDefinition front=p(head,"head_front",106,3,-1.5F,-1,-3.5F,3,2,7,0,1.2F,-.5F,0,-.4F,-2.9F);p(front,"nose",98,17,-.5F,-.5F,-.5F,1,1,1,0,-1,-2.5F,0,.6F,-.8F);p(front,"upper_jaw_detail",107,17,-1,-1,-2.5F,2,2,5,0,-2.9638F,3.5615F,0,1,-5);p(head,"jaw",86,4,-1,-.5F,-3,2,1,6,0,2.5F,-.5F,0,-.2F,-2.9F);
		PartDefinition er=p(head,"ear_r",76,2,-1.5F,-.5F,-1.5F,3,1,3,-2,-1.7F,.7F,-.5F,-.6F,-1.7F);p(er,"ear_r2",61,2,-1,-.5F,-1,2,1,2,0,.6F,-1,0,-.6F,-1);PartDefinition el=p(head,"ear_l",76,2,-1.5F,-.5F,-1.5F,3,1,3,2,-1.7F,.7F,.5F,-.6F,-1.7F);p(el,"ear_l2",61,2,-1,-.5F,-1,2,1,2,0,.6F,-1,0,-.6F,-1);
		PartDefinition r1=p(body,"leg_r1",0,54,-1,-3.5F,-1.5F,2,7,3,-3.3F,0,-2,0,3,0);PartDefinition r2=p(r1,"leg_r2",11,53,-1,-4.5F,-1,2,9,2,0,2.5F,1,.12F,3.5F,-.6F);p(r2,"toes_r",12,54,-1,-.5F,-.5F,2,1,1,-.12F,-3.5F,.6001F,.12F,7.5F,-1.5F);return LayerDefinition.create(m,128,64);}

	public static final Map<String,DogPartPose> BASELINE=baseline();
	 
	public static final Map<String,DogPartPose> SLEEP_TARGET=Map.copyOf(ModelDogGermanShepherd.SLEEP_TARGET);
	public static final Map<String,Float> SIT_POSE_X=Map.of("body",-.10049954898833749F,"leg_l1",-.4374388517443468F,"lower_body",-.68513423385813F,"tail",.7665852593902014F,"tail2",.458307753610443F,"back_leg_l1",-.43039993887105366F,"back_leg_r1",-.4596010425861708F,"head_base",1.1523920358728F,"leg_r1",-.4434654736514832F);
	public static final float SIT_BODY_Y=12F,SIT_BODY_Z=-5F,HEAD_TRACK_OFFSET=-.7F;
	private static Map<String,DogPartPose> baseline(){Map<String,DogPartPose>x=new HashMap<>();q(x,"body",0,10,-5,-.06981317007977318F,0,0);q(x,"leg_l1",3.3F,0,-2,.06981317007977318F,0,0);q(x,"leg_l2",0,2.5F,1,0,0,0);q(x,"toes_l",0,-3.5F,.6F,0,0,0);q(x,"lower_body",0,-1,6,.06981317007977318F,0,0);q(x,"tail",0,-4,6,-.8493138659347327F,0,0);q(x,"tail2",0,-1,3,-.40761990147402366F,0,0);q(x,"tail3",0,0,3.3F,.11862479327029861F,0,0);
		q(x,"back_leg_r1",2.5F,-2,3,0,0,0);q(x,"back_leg_r2",0,2.5F,.5F,0,0,0);q(x,"back_toe_r",.0099F,-3.5F,-.6999F,0,0,0);q(x,"back_leg_l1",-2.5F,-2,3,0,0,0);q(x,"back_leg_l2",0,2.5F,.5F,0,0,0);q(x,"back_toe_l",0,-3.5F,-.7F,0,0,0);q(x,"neck1",0,-2,-4,-.8264535433921109F,0,0);q(x,"head_base",0,-1.3F,-5,1.292103897165694F,0,0);q(x,"head_front",0,1.2F,-.5F,-.17280330391070658F,0,0);q(x,"nose",0,-1,-2.5F,-.091106186954104F,0,0);q(x,"upper_jaw_detail",0,-2.9638F,3.5615F,.2039696483635693F,0,0);q(x,"jaw",0,2.5F,-.5F,-.2525770680316114F,0,0);q(x,"ear_r",-2,-1.7F,.7F,-1.2936380415781972F,2.588148747782391F,-2.356194490192345F);q(x,"ear_r2",0,.6F,-1,.06981317007977318F,0,0);q(x,"ear_l",2,-1.7F,.7F,-1.2936380415781972F,-2.588148747782391F,2.356194490192345F);q(x,"ear_l2",0,.6F,-1,.06981317007977318F,0,0);q(x,"leg_r1",-3.3F,0,-2,.06981317007977318F,0,0);q(x,"leg_r2",0,2.5F,1,0,0,0);q(x,"toes_r",-.12F,-3.5F,.6001F,0,0,0);return x;}
	private static void q(Map<String,DogPartPose>x,String n,float a,float b,float c,float d,float e,float f){x.put(n,new DogPartPose(a,b,c,d,e,f));}private static PartDefinition p(PartDefinition r,String n,int u,int v,float a,float b,float c,int d,int e,int f,float g,float h,float i,float j,float k,float l){PartDefinition o=r.addOrReplaceChild(n,CubeListBuilder.create(),PartPose.offset(g,h,i));return o.addOrReplaceChild(n+"_box",CubeListBuilder.create().texOffs(u,v).addBox(a,b,c,d,e,f),PartPose.offset(j,k,l));}}
