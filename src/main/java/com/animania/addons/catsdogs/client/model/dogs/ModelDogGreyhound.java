package com.animania.addons.catsdogs.client.model.dogs;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelDogGreyhound {
	private ModelDogGreyhound() {}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition(); PartDefinition root = mesh.getRoot();
		PartDefinition body=p(root,"body",70,40,-4,-6,-6,8,12,12,0,3,-5,0,.6F,-1.5F);
		PartDefinition ll1=p(body,"leg_l1",0,53,-1,-3.5F,-2,2,7,4,-3.5F,5.4F,-3.5F,0,3,0); PartDefinition ll2=p(ll1,"leg_l2",8,41,-1,-4.5F,-1,2,9,2,0,2.5F,0,.12F,3.5F,-.6F); p(ll2,"toes_l",19,53,-1,-.5F,-.5F,2,1,1,-.12F,-3.5F,.6001F,.12F,7.5F,-1.5F);
		PartDefinition lr1=p(body,"leg_r1",0,53,-1,-3.5F,-2,2,7,4,3.5F,5.4F,-3.5F,0,3,0); PartDefinition lr2=p(lr1,"leg_r2",8,41,-1,-4.5F,-1,2,9,2,0,2.5F,0,-.12F,3.5F,-.6F); p(lr2,"toes_r",19,53,-1,-.5F,-.5F,2,1,1,.1199F,-3.5F,.6001F,-.12F,7.5F,-1.5F);
		PartDefinition lower=p(body,"lower_body",29,24,-3,-4,-6.5F,6,8,13,0,-2.6F,6.5F,0,.8F,5);
		PartDefinition bl1=p(lower,"back_leg_l1",19,49,-1,-4.5F,-3,2,9,6,-3,2.9614F,2.8805F,0,4,.5F); PartDefinition bl2=p(bl1,"back_leg_l2",17,39,-1,-3,-2,2,6,4,0,-2.9542F,-3.1279F,0,8,-4); PartDefinition bl3=p(bl2,"back_leg_l3",0,39,-1,-5.5F,-1,2,11,2,0,1.5593F,-.6497F,.01F,3.5F,1); p(bl3,"back_toe_l",1,37,-1,-.5F,-.5F,2,1,1,-.01F,-3.5F,-.6999F,.01F,8.5F,-.4F);
		PartDefinition br1=p(lower,"back_leg_r1",19,49,-1,-4.5F,-3,2,9,6,3,2.9614F,2.8805F,0,4,.5F); PartDefinition br2=p(br1,"back_leg_r2",17,39,-1,-3,-2,2,6,4,0,-2.9542F,-3.1279F,0,8,-4); PartDefinition br3=p(br2,"back_leg_r3",0,39,-1,-5.5F,-1,2,11,2,0,1.5593F,-.6497F,-.01F,3.5F,1); p(br3,"back_toe_r",1,37,-1,-.5F,-.5F,2,1,1,.0099F,-3.5F,-.6999F,-.01F,8.5F,-.4F);
		PartDefinition tail=p(lower,"tail",37,48,-1,-1,-6.5F,2,2,13,0,-2.4369F,6.0599F,0,.8F,5); p(tail,"tail2",41,52,-1,-1,-4.5F,2,2,9,0,1.9883F,-1.5034F,0,.8F,12);
		PartDefinition neck=p(body,"neck",16,16,0,0,0,0,0,0,0,-5.1F,-5.38F,0,0,0); PartDefinition neck1=p(neck,"neck1",0,1,-2.5F,-2.5F,-7,5,5,14,0,0,.0001F,0,2,-1); p(neck1,"neck2",0,20,-2.5F,-1,-4.5F,5,2,9,0,-4.5F,-.04F,0,1,-1);
		PartDefinition head=p(neck1,"head_base",101,27,-3,-3,-3,6,6,6,0,-.8529F,-6.7255F,0,-1,-1); PartDefinition front=p(head,"head_front",106,3,-1.5F,-1,-3.5F,3,2,7,0,2,-.5F,0,-.4F,-2.9F); p(front,"nose",97,16,-.5F,-.5F,-1,1,1,2,0,-1,-2.5F,0,0,-.8F); p(front,"upper_jaw_detail",107,17,-1.5F,-1,-2.5F,3,2,5,0,-3,3.5615F,0,1,-5); p(head,"jaw",86,4,-1,-.5F,-3,2,1,6,0,2.5F,-.5F,0,-.2F,-2.9F);
		PartDefinition er=p(head,"ear_r",68,9,-1.5F,-.5F,-1.5F,3,1,3,-2,-1.7F,.7F,-.5F,-.6F,-2); PartDefinition er2=p(er,"ear_r2",70,6,-1,-.5F,-1,2,1,2,0,0,-1,0,0,-1); p(er2,"ear_r3",72,4,-.5F,-.5F,-.5F,1,1,1,0,.6922F,.0043F,0,-.6F,-1);
		PartDefinition el=p(head,"ear_l",68,9,-1.5F,-.5F,-1.5F,3,1,3,2,-1.7F,.7F,.5F,-.6F,-2); PartDefinition el2=p(el,"ear_l2",70,6,-1,-.5F,-1,2,1,2,0,0,-1,0,0,-1); p(el2,"ear_l3",72,4,-.5F,-.5F,-.5F,1,1,1,-.0001F,.6922F,.0043F,0,-.6F,-1);
		return LayerDefinition.create(mesh,128,64);
	}

	public static final Map<String, DogPartPose> BASELINE=poses(false), SLEEP_TARGET=poses(true);
	public static final Map<String, Float> SIT_POSE_X=Map.of("body",.0498343861321941F,"leg_l1",-1.2861313804653693F,"leg_r1",-1.3041327063704389F,"lower_body",-.2823750743509106F,"back_leg_l1",-.9602522291792482F,"back_leg_r1",-.9624426173905011F);
	public static final Map<String, DogPartPose> SIT_POSE=Map.of("tail",new DogPartPose(0,-2.2F,17.5F,-.26909660940173774F,0,0));
	public static final float SIT_BODY_Y=13F, SIT_BODY_Z=-5F, HEAD_TRACK_OFFSET=-.7F;

	private static Map<String, DogPartPose> poses(boolean sleep) {
		Map<String,DogPartPose> x=new HashMap<>();
		if (!sleep) {
			q(x,"body",0,3,-5,0,0,0); q(x,"leg_l1",-3.5F,5.4F,-3.5F,0,0,0); q(x,"leg_l2",0,2.5F,0,0,0,0); q(x,"toes_l",-.12F,-3.5F,.6001F,0,0,0); q(x,"leg_r1",3.5F,5.4F,-3.5F,0,0,0); q(x,"leg_r2",0,2.5F,0,0,0,0); q(x,"toes_r",.1199F,-3.5F,.6001F,0,0,0);
			q(x,"lower_body",0,-2.6F,6.5F,.03291167370485707F,0,0); q(x,"back_leg_l1",-3,2.9614F,2.8805F,.3737500420098217F,0,0); q(x,"back_leg_l2",0,-2.9542F,-3.1279F,.8980190240408864F,0,0); q(x,"back_leg_l3",0,1.5593F,-.6497F,-1.3046842304140691F,0,0); q(x,"back_toe_l",-.01F,-3.5F,-.6999F,0,0,0); q(x,"back_leg_r1",3,2.9614F,2.8805F,.3737517873390737F,0,0); q(x,"back_leg_r2",0,-2.9542F,-3.1279F,.8980190240408864F,0,0); q(x,"back_leg_r3",0,1.5593F,-.6497F,-1.3046842304140691F,0,0); q(x,"back_toe_r",.0099F,-3.5F,-.6999F,0,0,0);
			q(x,"tail",0,-2.4369F,6.0599F,-.4668965188595071F,0,0); q(x,"tail2",0,1.9883F,-1.5034F,.35078849037058435F,0,0); q(x,"neck",0,-5.1F,-5.38F,0,0,0); q(x,"neck1",0,0,.0001F,-1.0039133857471385F,0,0); q(x,"neck2",0,-4.5F,-.04F,.38586262701866236F,0,0); q(x,"head_base",0,-.8529F,-6.7255F,1.023461073369475F,0,0);
			q(x,"head_front",0,2,-.5F,-.17280330391070658F,0,0); q(x,"nose",0,-1,-2.5F,0,0,0); q(x,"upper_jaw_detail",0,-3,3.5615F,.21191962310640397F,0,0); q(x,"jaw",0,2.5F,-.5F,-.2525770680316114F,0,0); q(x,"ear_r",-2,-1.7F,.7F,-.3815621357417483F,2.6514989636420294F,-1.5488994259993758F); q(x,"ear_r2",0,0,-1,.9210416622039436F,0,0); q(x,"ear_r3",0,.6922F,.0043F,.1620555663769255F,.000001745329252F,0); q(x,"ear_l",2,-1.7F,.7F,-.3815621357417483F,-2.6514989636420294F,1.5489011713286278F); q(x,"ear_l2",0,0,-1,.9210416622039436F,0,0); q(x,"ear_l3",-.0001F,.6922F,.0043F,.1620555663769255F,0,.000001745329252F);
		} else {
			q(x,"body",0,18,-5,.20162218051963693F,.3506890066032206F,.07312755032931041F); q(x,"leg_l1",-3.5F,5.4F,-3.5F,-1.3097334679400887F,2.830170064497941F,-2.895344149425913F); q(x,"leg_l2",0,2.5F,0,0,0,-.25465750049998864F); q(x,"toes_l",-.12F,-3.5F,.6001F,0,0,0); q(x,"leg_r1",3.5F,5.4F,-3.5F,-1.2640058415378375F,-3.1178247598361346F,2.8722202821662406F); q(x,"leg_r2",0,2.5F,0,0,0,.39289804923345145F); q(x,"toes_r",.1199F,-3.5F,.6001F,0,0,0);
			q(x,"lower_body",0,-2.6F,6.5F,-.5539867032047722F,.5432215123784712F,-.3075741380912047F); q(x,"back_leg_l1",-3,2.9614F,2.8805F,-1.2180007077845187F,-.33180978008439793F,.6353906048470397F); q(x,"back_leg_l2",0,-2.9542F,-3.1279F,.8349306075690474F,-.4951359461567753F,-.380745321651815F); q(x,"back_leg_l3",0,1.5593F,-.6497F,-.9714624789648078F,0,0); q(x,"back_toe_l",-.01F,-3.5F,-.6999F,0,0,0); q(x,"back_leg_r1",3,2.9614F,2.8805F,-1.0845074546164806F,.13464167981585057F,-.6328668587486558F); q(x,"back_leg_r2",0,-2.9542F,-3.1279F,.8980190240408864F,.000001745329252F,-.122501169538978F); q(x,"back_leg_r3",0,1.5593F,-.6497F,-.962482759963297F,0,0); q(x,"back_toe_r",.0099F,-3.5F,-.6999F,0,0,0);
			q(x,"tail",0,-2.4369F,6.0599F,-.055232689508612556F,0,0); q(x,"tail2",0,1.9883F,-1.5034F,.4014990317872796F,0,0); q(x,"neck",0,-5.1F,-5.38F,1.123190932157683F,0,.2461106231529724F); q(x,"neck1",0,0,.0001F,-1.0039133857471385F,0,0); q(x,"neck2",0,-1,-.04F,.38586262701866236F,0,0); q(x,"head_base",0,-.8529F,-6.7255F,.37451449622219524F,.5511243632315015F,.2211751041297294F);
			q(x,"head_front",0,2,-.5F,-.17280330391070658F,0,0); q(x,"nose",0,-1,-2.5F,0,0,0); q(x,"upper_jaw_detail",0,-3,3.5615F,.21191962310640397F,0,0); q(x,"jaw",0,2.5F,-.5F,-.2525770680316114F,0,0); q(x,"ear_r",-2,-1.7F,.7F,-.3815621357417483F,2.6514989636420294F,-1.5488994259993758F); q(x,"ear_r2",0,0,-1,.9210416622039436F,0,0); q(x,"ear_r3",0,.6922F,.0043F,.1620555663769255F,.000001745329252F,0); q(x,"ear_l",2,-1.7F,.7F,-.3815621357417483F,-2.6514989636420294F,1.5489011713286278F); q(x,"ear_l2",0,0,-1,.9210416622039436F,0,0); q(x,"ear_l3",-.0001F,.6922F,.0043F,.1620555663769255F,0,.000001745329252F);
		}
		return x;
	}
	private static void q(Map<String,DogPartPose> x,String n,float a,float b,float c,float d,float e,float f){x.put(n,new DogPartPose(a,b,c,d,e,f));}
	private static PartDefinition p(PartDefinition r,String n,int u,int v,float a,float b,float c,int d,int e,int f,float g,float h,float i,float j,float k,float l){PartDefinition o=r.addOrReplaceChild(n,CubeListBuilder.create(),PartPose.offset(g,h,i));return o.addOrReplaceChild(n+"_box",CubeListBuilder.create().texOffs(u,v).addBox(a,b,c,d,e,f),PartPose.offset(j,k,l));}
}
