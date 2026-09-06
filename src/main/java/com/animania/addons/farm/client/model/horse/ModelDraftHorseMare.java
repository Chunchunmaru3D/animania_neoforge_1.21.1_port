package com.animania.addons.farm.client.model.horse;

import com.animania.addons.farm.client.model.goats.ModelDoeAlpine;
import com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 





























public class ModelDraftHorseMare<T extends EntityAnimaniaHorse> extends EntityModel<T>
{
	private final ModelPart body;
	private final ModelPart tailNode, tailA, tailB, tailC, tailD;

	private final ModelPart backLeftMuscle, backLeftA, backLeftB, backLeftHoof, backLeftHoof2, backLeftFluff, backLeftFluffb;
	private final ModelPart backRightMuscle, backRightA, backRightB, backRightHoof, backRightHoof2, backRightFluff, backRightFluffb;
	private final ModelPart frontLeftMuscle, frontLeftA, frontLeftB, frontLeftHoof, frontLeftHoof2, frontLeftFluff, frontLeftFluffb;
	private final ModelPart frontRightMuscle, frontRightA, frontRightB, frontRightHoof, frontRightHoof2, frontRightFluff, frontRightFluffb;

	private final ModelPart headNode, neck, head, nose, mouth, earLeft, earRight;
	private final ModelPart fleco1, fleco2, fleco3, fleco4, mane;

	private final ModelPart saddleBase, saddleBase2, saddleBase3, saddle, saddle2, saddle3, saddle4, saddle5, saddle6;
	private final ModelPart footstrap, foot1, foot2, foot3, foot4;
	private final ModelPart footstrap2, foot1a, foot2a, foot3a, foot4a;
	private final ModelPart saddle7, saddleHump, saddleHump2, strap1, strap2, strap3;

	 
	private float headRotationAngleX;
	private boolean sleeping;
	private boolean saddled;

	public ModelDraftHorseMare(ModelPart root)
	{
		this.body = root.getChild("body");
		this.tailNode = root.getChild("tail_node");
		this.tailA = this.tailNode.getChild("tail_a");
		this.tailB = this.tailNode.getChild("tail_b");
		this.tailC = this.tailNode.getChild("tail_c");
		this.tailD = this.tailNode.getChild("tail_d");

		this.backLeftMuscle = root.getChild("back_left_muscle");
		this.backLeftA = this.backLeftMuscle.getChild("back_left_a");
		this.backLeftB = this.backLeftMuscle.getChild("back_left_b");
		this.backLeftHoof = this.backLeftMuscle.getChild("back_left_hoof");
		this.backLeftHoof2 = this.backLeftMuscle.getChild("back_left_hoof2");
		this.backLeftFluff = this.backLeftMuscle.getChild("back_left_fluff");
		this.backLeftFluffb = this.backLeftMuscle.getChild("back_left_fluffb");

		this.backRightMuscle = root.getChild("back_right_muscle");
		this.backRightA = this.backRightMuscle.getChild("back_right_a");
		this.backRightB = this.backRightMuscle.getChild("back_right_b");
		this.backRightHoof = this.backRightMuscle.getChild("back_right_hoof");
		this.backRightHoof2 = this.backRightMuscle.getChild("back_right_hoof2");
		this.backRightFluff = this.backRightMuscle.getChild("back_right_fluff");
		this.backRightFluffb = this.backRightMuscle.getChild("back_right_fluffb");

		this.frontLeftMuscle = root.getChild("front_left_muscle");
		this.frontLeftA = this.frontLeftMuscle.getChild("front_left_a");
		this.frontLeftB = this.frontLeftMuscle.getChild("front_left_b");
		this.frontLeftHoof = this.frontLeftMuscle.getChild("front_left_hoof");
		this.frontLeftHoof2 = this.frontLeftMuscle.getChild("front_left_hoof2");
		this.frontLeftFluff = this.frontLeftMuscle.getChild("front_left_fluff");
		this.frontLeftFluffb = this.frontLeftMuscle.getChild("front_left_fluffb");

		this.frontRightMuscle = root.getChild("front_right_muscle");
		this.frontRightA = this.frontRightMuscle.getChild("front_right_a");
		this.frontRightB = this.frontRightMuscle.getChild("front_right_b");
		this.frontRightHoof = this.frontRightMuscle.getChild("front_right_hoof");
		this.frontRightHoof2 = this.frontRightMuscle.getChild("front_right_hoof2");
		this.frontRightFluff = this.frontRightMuscle.getChild("front_right_fluff");
		this.frontRightFluffb = this.frontRightMuscle.getChild("front_right_fluffb");

		this.headNode = root.getChild("head_node");
		this.neck = this.headNode.getChild("neck");
		this.head = this.headNode.getChild("head");
		this.nose = this.headNode.getChild("nose");
		this.mouth = this.headNode.getChild("mouth");
		this.earLeft = this.headNode.getChild("ear_left");
		this.earRight = this.headNode.getChild("ear_right");
		this.fleco1 = this.headNode.getChild("fleco1");
		this.fleco2 = this.headNode.getChild("fleco2");
		this.fleco3 = this.headNode.getChild("fleco3");
		this.fleco4 = this.headNode.getChild("fleco4");
		this.mane = this.headNode.getChild("mane");

		this.saddleBase = root.getChild("saddle_base");
		this.saddleBase2 = root.getChild("saddle_base2");
		this.saddleBase3 = root.getChild("saddle_base3");
		this.saddle = root.getChild("saddle");
		this.saddle2 = root.getChild("saddle2");
		this.saddle3 = root.getChild("saddle3");
		this.saddle4 = root.getChild("saddle4");
		this.saddle5 = root.getChild("saddle5");
		this.saddle6 = root.getChild("saddle6");
		this.footstrap = root.getChild("footstrap");
		this.foot1 = root.getChild("foot1");
		this.foot2 = root.getChild("foot2");
		this.foot3 = root.getChild("foot3");
		this.foot4 = root.getChild("foot4");
		this.footstrap2 = root.getChild("footstrap2");
		this.foot1a = root.getChild("foot1a");
		this.foot2a = root.getChild("foot2a");
		this.foot3a = root.getChild("foot3a");
		this.foot4a = root.getChild("foot4a");
		this.saddle7 = root.getChild("saddle7");
		this.saddleHump = root.getChild("saddle_hump");
		this.saddleHump2 = root.getChild("saddle_hump2");
		this.strap1 = root.getChild("strap1");
		this.strap2 = root.getChild("strap2");
		this.strap3 = root.getChild("strap3");
	}

	protected static PartDefinition buildBody(PartDefinition root)
	{
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-7F, -7F, -16F, 14, 14, 32), PartPose.offset(0F, -3F, 3F));

		PartDefinition tailNode = root.addOrReplaceChild("tail_node", CubeListBuilder.create(),
				PartPose.offset(0F, -10F, 19F));
		tailNode.addOrReplaceChild("tail_a", CubeListBuilder.create().texOffs(108, 108)
				.addBox(-1F, -1F, 0F, 2, 2, 3), PartPose.offsetAndRotation(0F, 0F, 0F, -1.105676F, 0F, 0F));
		tailNode.addOrReplaceChild("tail_b", CubeListBuilder.create().texOffs(102, 115)
				.addBox(-1.5F, -2F, 3F, 3, 4, 7), PartPose.offsetAndRotation(0F, 0F, 0F, -1.105676F, 0F, 0F));
		tailNode.addOrReplaceChild("tail_c", CubeListBuilder.create().texOffs(88, 111)
				.addBox(-1.5F, -4.5F, 9F, 3, 4, 7), PartPose.offsetAndRotation(0F, 0F, 0F, -1.367476F, 0F, 0F));
		tailNode.addOrReplaceChild("tail_d", CubeListBuilder.create().texOffs(54, 56)
				.addBox(-2F, -2.5F, 0.5F, 4, 5, 11), PartPose.offsetAndRotation(0F, 4.186213F + 10F, 24.47736F - 19F, -1.507424F, 0F, 0F));

		return root;
	}

	 
	private static void buildLeg(PartDefinition muscle, String prefix,
			float aX, float aY, float aZ,
			float bX, float bY, float bZ,
			float hoofX, float hoofY, float hoofZ,
			float hoof2X, float hoof2Y, float hoof2Z,
			float fluffX, float fluffY, float fluffZ, float fluffRotX, float fluffRotY, float fluffRotZ,
			float fluffbX, float fluffbY, float fluffbZ, float fluffbRotX, float fluffbRotY, float fluffbRotZ,
			int aTexU, int aTexV, int bTexU, int bTexV, int hoofTexU, int hoofTexV, int hoof2TexU, int hoof2TexV, int fluffTexU, int fluffTexV)
	{
		muscle.addOrReplaceChild(prefix + "_a", CubeListBuilder.create().texOffs(aTexU, aTexV)
				.addBox(-3F, 0.5F, -3F, 5, 9, 6), PartPose.offsetAndRotation(aX, aY, aZ, 0.1745329F, 0F, 0F));
		muscle.addOrReplaceChild(prefix + "_b", CubeListBuilder.create().texOffs(bTexU, bTexV)
				.addBox(-2.5F, -1F, -2F, 4, 8, 4), PartPose.offsetAndRotation(bX, bY, bZ, -0.1745329F, 0F, 0F));
		muscle.addOrReplaceChild(prefix + "_hoof", CubeListBuilder.create().texOffs(hoofTexU, hoofTexV)
				.addBox(-3F, 5.1F, -2.5F, 5, 3, 5), PartPose.offsetAndRotation(hoofX, hoofY, hoofZ, 4.00787E-08F, 0F, 0F));
		muscle.addOrReplaceChild(prefix + "_hoof2", CubeListBuilder.create().texOffs(hoof2TexU, hoof2TexV)
				.addBox(-3.5F, 5.1F, -3F, 6, 3, 6), PartPose.offsetAndRotation(hoof2X, hoof2Y, hoof2Z, 4.007869E-08F, 0F, 0F));
		muscle.addOrReplaceChild(prefix + "_fluff", CubeListBuilder.create().texOffs(fluffTexU, fluffTexV)
				.addBox(-1F, -1.5F, -2F, 1, 9, 4), PartPose.offsetAndRotation(fluffX, fluffY, fluffZ, fluffRotX, fluffRotY, fluffRotZ));
		muscle.addOrReplaceChild(prefix + "_fluffb", CubeListBuilder.create().texOffs(fluffTexU, fluffTexV)
				.addBox(-1F, -1.5F, -2F, 1, 9, 4), PartPose.offsetAndRotation(fluffbX, fluffbY, fluffbZ, fluffbRotX, fluffbRotY, fluffbRotZ));
	}

	protected static PartDefinition buildLegs(PartDefinition root)
	{
		PartDefinition backLeftMuscle = root.addOrReplaceChild("back_left_muscle", CubeListBuilder.create().texOffs(60, 2)
				.addBox(-4F, -6F, -6F, 7, 12, 12), PartPose.offset(5F, -1F, 14F));
		buildLeg(backLeftMuscle, "back_left",
				0.5F, 4.5F, 1F, 0.5F, 13.84808F, 2.736481F, 0.5F, 14.98481F, 1.673648F, 0.5F, 16.98481F, 1.673648F,
				1F, 16.16499F, 4.3588F, 0.08790723F, 0.08461326F, -0.01519369F,
				0.000259F, 16.18772F, 4.3578F, 0.08393065F, -0.09052216F, -0.0302609F,
				1, 67, 77, 72, 75, 84, 97, 92, 74, 49);

		PartDefinition backRightMuscle = root.addOrReplaceChild("back_right_muscle", CubeListBuilder.create().texOffs(60, 2)
				.addBox(-4F, -6F, -6F, 7, 12, 12), PartPose.offset(-4F, -1F, 14F));
		buildLeg(backRightMuscle, "back_right",
				-0.5F, 4.5F, 1F, -0.499999F, 14F, 2.56283F, -0.499999F, 15.13673F, 1.5F, -0.499999F, 17.13673F, 1.5F,
				0.000001F, 16.16499F, 4.3588F, 0.08790723F, 0.08461326F, -0.01519369F,
				-0.99974F, 16.18772F, 4.3578F, 0.08393065F, -0.09052216F, -0.0302609F,
				23, 67, 93, 72, 75, 84, 97, 92, 74, 49);

		PartDefinition frontLeftMuscle = root.addOrReplaceChild("front_left_muscle", CubeListBuilder.create().texOffs(60, 2)
				.addBox(-4F, -6F, -6F, 7, 12, 12), PartPose.offset(5F, -1F, -8F));
		buildLeg(frontLeftMuscle, "front_left",
				0.5F, 4F, -1F, 0.5F, 13.84808F, -1F, 0.5F, 14.98481F, -1F, 0.5F, 16.98481F, -1F,
				1F, 16.16499F, 2F, 0.1745329F, -0.08726647F, 1.599395E-10F,
				0.015076F, 16.18012F, 1.827673F, 0.1718547F, -0.2644362F, -0.03060928F,
				1, 67, 77, 72, 75, 84, 73, 92, 74, 49);

		PartDefinition frontRightMuscle = root.addOrReplaceChild("front_right_muscle", CubeListBuilder.create().texOffs(60, 2)
				.addBox(-4F, -6F, -6F, 7, 12, 12), PartPose.offset(-4F, -1F, -8F));
		buildLeg(frontRightMuscle, "front_right",
				-0.5F, 4F, -1F, -0.5F, 13.84808F, -1F, -0.5F, 14.98481F, -1F, -0.5F, 16.98481F, -1F,
				0.000001F, 16.16499F, 2F, 0.1745329F, 0.08726647F, -1.599395E-10F,
				-0.999883F, 16.18012F, 2.001321F, 0.1718547F, -0.08990332F, -0.03060928F,
				23, 67, 93, 72, 75, 84, 73, 92, 74, 49);

		return root;
	}

	protected static PartDefinition buildHead(PartDefinition root)
	{
		PartDefinition headNode = root.addOrReplaceChild("head_node", CubeListBuilder.create(),
				PartPose.offset(0F, -7F, -9F));

		headNode.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(87, 46)
				.addBox(-4.05F, -14F, -5F, 8, 14, 10), PartPose.offsetAndRotation(0F, 0F, 0F, 0.5235988F, 0F, 0F));
		headNode.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 46)
				.addBox(-4F, -4F, -6F, 8, 8, 12), PartPose.offsetAndRotation(4.842877E-08F, -18.87436F + 7F, -16.43301F + 9F, 0.5235988F, 0F, 0F));
		headNode.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(28, 46)
				.addBox(-3.5F, -2.5F, -6F, 7, 5, 6), PartPose.offsetAndRotation(4.842877E-08F, -17.4234F + 7F, -21.94615F + 9F, 0.6616941F, 0F, 0F));
		headNode.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(40, 57)
				.addBox(-3F, -0.5F, -6F, 6, 3, 6), PartPose.offsetAndRotation(4.842877E-08F, -16.15272F + 7F, -20.32277F + 9F, 0.836227F, 0F, 0F));
		headNode.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(1, 25)
				.addBox(-1.5F, -4F, -0.5F, 3, 4, 1), PartPose.offsetAndRotation(-2.5F, -23.40545F + 7F, -15.58494F + 9F, 0.5040353F, -0.3000592F, -0.4101312F));
		headNode.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(10, 25)
				.addBox(-1.5F, -4F, -0.5F, 3, 4, 1), PartPose.offsetAndRotation(2.5F, -23.40545F + 7F, -15.58494F + 9F, 0.5040353F, 0.3000592F, 0.4101312F));
		headNode.addOrReplaceChild("fleco1", CubeListBuilder.create().texOffs(88, 113)
				.addBox(-0.5F, -0.5F, -4F, 1, 1, 8), PartPose.offsetAndRotation(0.5000001F, -24.77147F + 7F, -15.21891F + 9F, 0.5235988F, 0F, 0F));
		headNode.addOrReplaceChild("fleco2", CubeListBuilder.create().texOffs(104, 116)
				.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 7), PartPose.offsetAndRotation(-0.4999999F, -25.02147F + 7F, -14.7859F + 9F, 0.5235988F, 0F, 0F));
		headNode.addOrReplaceChild("fleco3", CubeListBuilder.create().texOffs(103, 118)
				.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 7), PartPose.offsetAndRotation(1.5F, -25.02147F + 7F, -14.7859F + 9F, 0.5235988F, 0F, 0F));
		headNode.addOrReplaceChild("fleco4", CubeListBuilder.create().texOffs(92, 114)
				.addBox(-0.5F, -0.5F, -3F, 1, 1, 6), PartPose.offsetAndRotation(-1.5F, -25.27147F + 7F, -14.35288F + 9F, 0.5235988F, 0F, 0F));
		headNode.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(65, 101)
				.addBox(-1.5F, -10F, -2.5F, 3, 20, 5), PartPose.offsetAndRotation(4.842877E-08F, -16.9282F + 7F, -7.803848F + 9F, 0.5235988F, 0F, 0F));

		return headNode;
	}

	protected static PartDefinition buildSaddle(PartDefinition root)
	{
		root.addOrReplaceChild("saddle_base", CubeListBuilder.create().texOffs(0, 82)
				.addBox(-7.5F, -0.5F, -10F, 15, 1, 20), PartPose.offset(0F, -10F, 8F));
		root.addOrReplaceChild("saddle_base2", CubeListBuilder.create().texOffs(0, 82)
				.addBox(-0.5F, -0.5F, -10F, 1, 7, 20), PartPose.offsetAndRotation(7F, -9F, 8F, 0F, 0F, -0.2617994F));
		root.addOrReplaceChild("saddle_base3", CubeListBuilder.create().texOffs(0, 82)
				.addBox(-0.5F, -0.5F, -10F, 1, 7, 20), PartPose.offsetAndRotation(-7F, -9F, 8F, 0F, 0F, 0.2617994F));
		root.addOrReplaceChild("saddle", CubeListBuilder.create().texOffs(0, 114)
				.addBox(-8F, -0.5F, -6.5F, 16, 1, 13), PartPose.offset(0F, -11F, 6F));
		root.addOrReplaceChild("saddle2", CubeListBuilder.create().texOffs(12, 123)
				.addBox(-6.5F, -1F, -1F, 13, 2, 2), PartPose.offset(0F, -11.5F, 13.5F));
		root.addOrReplaceChild("saddle3", CubeListBuilder.create().texOffs(4, 113)
				.addBox(-0.5F, -0.5F, -4.5F, 1, 5, 9), PartPose.offsetAndRotation(7.5F, -10.5F, 6F, 0F, 0F, -0.2617994F));
		root.addOrReplaceChild("saddle4", CubeListBuilder.create().texOffs(20, 119)
				.addBox(-0.5F, -1F, -3F, 1, 2, 6), PartPose.offsetAndRotation(8.923505F, -5.187408F, 6F, 0F, 0F, -0.2617994F));
		root.addOrReplaceChild("saddle5", CubeListBuilder.create().texOffs(17, 113)
				.addBox(-0.5F, -0.5F, -4.5F, 1, 5, 9), PartPose.offsetAndRotation(-7.5F, -10.5F, 6F, 0F, 0F, 0.2617994F));
		root.addOrReplaceChild("saddle6", CubeListBuilder.create().texOffs(23, 118)
				.addBox(-0.5F, -1F, -3F, 1, 2, 6), PartPose.offsetAndRotation(-8.923504F, -5.187408F, 6F, 0F, 0F, 0.2617994F));
		root.addOrReplaceChild("footstrap", CubeListBuilder.create().texOffs(11, 120)
				.addBox(-0.5F, 0F, -1F, 1, 6, 2), PartPose.offsetAndRotation(8F, -6.5F, 6F, 0F, 0F, -0.2617994F));
		root.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(2, 89)
				.addBox(-0.5F, -0.5F, -2F, 1, 1, 4), PartPose.offset(9.682323F, -0.2214813F, 6F));
		root.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(2, 89)
				.addBox(-0.5F, -0.5F, -2F, 1, 1, 4), PartPose.offset(9.682324F, 2.778519F, 6F));
		root.addOrReplaceChild("foot3", CubeListBuilder.create().texOffs(5, 92)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(9.682323F, 1.278519F, 4.5F));
		root.addOrReplaceChild("foot4", CubeListBuilder.create().texOffs(5, 92)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(9.682323F, 1.278519F, 7.5F));
		root.addOrReplaceChild("footstrap2", CubeListBuilder.create().texOffs(11, 120)
				.addBox(-0.5F, 0F, -1F, 1, 6, 2), PartPose.offsetAndRotation(-8F, -6.5F, 6F, 0F, 0F, 0.2617994F));
		root.addOrReplaceChild("foot1a", CubeListBuilder.create().texOffs(2, 89)
				.addBox(-0.5F, -0.5F, -2F, 1, 1, 4), PartPose.offset(-9.682323F, -0.2214813F, 6F));
		root.addOrReplaceChild("foot2a", CubeListBuilder.create().texOffs(2, 89)
				.addBox(-0.5F, -0.5F, -2F, 1, 1, 4), PartPose.offset(-9.682323F, 2.778519F, 6F));
		root.addOrReplaceChild("foot3a", CubeListBuilder.create().texOffs(5, 92)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(-9.682323F, 1.278519F, 4.5F));
		root.addOrReplaceChild("foot4a", CubeListBuilder.create().texOffs(5, 92)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(-9.682323F, 1.278519F, 7.5F));
		root.addOrReplaceChild("saddle7", CubeListBuilder.create().texOffs(11, 110)
				.addBox(-5.5F, -0.5F, -1F, 11, 1, 2), PartPose.offset(0F, -11F, 15.5F));
		root.addOrReplaceChild("saddle_hump", CubeListBuilder.create().texOffs(2, 111)
				.addBox(-3F, -1.5F, -1.5F, 6, 3, 3), PartPose.offsetAndRotation(0F, -12F, 0F, 0.07325316F, 0F, 0F));
		root.addOrReplaceChild("saddle_hump2", CubeListBuilder.create().texOffs(2, 113)
				.addBox(-2F, -1F, -2F, 4, 2, 4), PartPose.offsetAndRotation(0F, -14.49329F, -0.1829692F, 0.1765722F, 0F, 0F));
		root.addOrReplaceChild("strap1", CubeListBuilder.create().texOffs(10, 124)
				.addBox(-8F, -0.5F, -1.5F, 16, 1, 3), PartPose.offset(0F, 4.5F, 6F));
		root.addOrReplaceChild("strap2", CubeListBuilder.create().texOffs(40, 110)
				.addBox(-0.5F, -4.5F, -1.5F, 1, 9, 3), PartPose.offset(-7.5F, -0.5F, 6F));
		root.addOrReplaceChild("strap3", CubeListBuilder.create().texOffs(41, 110)
				.addBox(-0.5F, -4.5F, -1.5F, 1, 9, 3), PartPose.offset(7.5F, -0.5F, 6F));

		return root;
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = buildBody(mesh.getRoot());
		buildLegs(root);
		buildHead(root);
		buildSaddle(root);
		return LayerDefinition.create(mesh, 256, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.saddled = entity.isSaddled();

		 
		 
		 
		 
		if (!entity.isVehicle())
		{
			this.headNode.y = -7.0F + entity.getHeadAnchorPointY(0F) * 10.0F;
			this.headRotationAngleX = entity.getHeadAngleX(0F);
		}

		this.headNode.yRot = netHeadYaw / (180F / (float) Math.PI);

		 
		 
		if (entity.getEatTimer() > 4 && entity.getEatTimer() < 160)
			this.headNode.xRot = 0.687F + this.headRotationAngleX;
		else
			this.headNode.xRot = this.headRotationAngleX;

		this.backLeftMuscle.xRot = Mth.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
		this.backRightMuscle.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount;
		this.frontLeftMuscle.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount;
		this.frontRightMuscle.xRot = Mth.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;

		this.sleeping = entity.getSleeping();
		float sleepTimer = entity.getSleepTimer();

		if (this.sleeping)
		{
			this.frontLeftMuscle.xRot = sleepTimer * -1.8F;
			this.frontRightMuscle.xRot = sleepTimer * -1.8F;
			this.backLeftMuscle.xRot = sleepTimer * 1.7F;
			this.backRightMuscle.xRot = sleepTimer * 1.75F;
			this.headNode.yRot = sleepTimer * 2.8F;
			this.body.xRot = sleepTimer > -0.28F ? -(sleepTimer / 3F) : (sleepTimer / 3F);
		}
		else
		{
			this.body.xRot = 0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tailNode.render(poseStack, buffer, packedLight, packedOverlay, color);

		if (this.sleeping)
		{
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.frontLeftMuscle, 0.95F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.frontRightMuscle, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.backLeftMuscle, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.backRightMuscle, 0.95F);
		}
		else
		{
			this.backLeftMuscle.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.backRightMuscle.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.frontLeftMuscle.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.frontRightMuscle.render(poseStack, buffer, packedLight, packedOverlay, color);
		}

		this.headNode.render(poseStack, buffer, packedLight, packedOverlay, color);

		if (this.saddled)
		{
			this.saddleBase.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddleBase2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddleBase3.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddle.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddle2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddle3.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddle4.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddle5.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddle6.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.footstrap.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot1.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot3.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot4.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.footstrap2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot1a.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot2a.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot3a.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.foot4a.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddle7.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddleHump.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.saddleHump2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.strap1.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.strap2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.strap3.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
	}
}
