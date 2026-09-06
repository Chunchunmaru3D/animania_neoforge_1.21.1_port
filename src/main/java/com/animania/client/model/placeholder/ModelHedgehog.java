package com.animania.client.model.placeholder;

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
import net.minecraft.world.entity.Mob;

 






public class ModelHedgehog<T extends Mob> extends EntityModel<T>
{
	private final ModelPart Head;
	private final ModelPart BodyNode;
	private final ModelPart Block3;
	private final ModelPart Block3b;
	private final ModelPart Block3c;
	private final ModelPart Block3d;
	private final ModelPart Block2;
	private final ModelPart Block2b;
	private final ModelPart Block2c;
	private final ModelPart Block2d;
	private final ModelPart Block2e;
	private final ModelPart Block1;
	private final ModelPart Block1b;
	private final ModelPart Block1c;
	private final ModelPart Block4;
	private final ModelPart Block4b;
	private final ModelPart Block4c;
	private final ModelPart Block5;
	private final ModelPart Block5b;
	private final ModelPart Block5c;
	private final ModelPart Block6;
	private final ModelPart Block6b;
	private final ModelPart Block7;
	private final ModelPart Block8;
	private final ModelPart LegBackLeft;
	private final ModelPart LegBackRight;
	private final ModelPart LegFrontLeft;
	private final ModelPart LegFrontRight;
	private final ModelPart LegFrontLeftFoot;
	private final ModelPart LegFrontLeftFoot1;
	private final ModelPart LegFrontLeftFoot2;
	private final ModelPart LegFrontLeftFoot3;
	private final ModelPart Spike1;
	private final ModelPart Spike2;
	private final ModelPart Spike3;
	private final ModelPart Spike4;
	private final ModelPart Spike5;
	private final ModelPart Spike6;
	private final ModelPart Spike7;
	private final ModelPart Spike8;
	private final ModelPart Spike9;
	private final ModelPart Spike10;
	private final ModelPart Spike11;
	private final ModelPart Spike12;
	private final ModelPart Spike13;
	private final ModelPart Spike14;
	private final ModelPart Spike15;
	private final ModelPart Spike16;
	private final ModelPart Spike17;
	private final ModelPart Spike18;
	private final ModelPart Spike19;
	private final ModelPart Spike20;
	private final ModelPart Spike21;
	private final ModelPart Spike22;
	private final ModelPart Spike23;
	private final ModelPart Spike24;
	private final ModelPart Spike25;
	private final ModelPart Spike26;
	private final ModelPart Spike27;
	private final ModelPart Spike28;
	private final ModelPart Spike29;
	private final ModelPart Spike30;
	private final ModelPart Spike31;
	private final ModelPart Spike32;
	private final ModelPart Spike33;
	private final ModelPart Spike34;
	private final ModelPart Spike35;
	private final ModelPart Spike36;
	private final ModelPart Spike37;
	private final ModelPart Spike38;
	private final ModelPart Spike39;
	private final ModelPart Spike40;
	private final ModelPart Spike41;
	private final ModelPart Spike42;
	private final ModelPart Spike43;
	private final ModelPart Spike44;
	private final ModelPart Spike45;
	private final ModelPart Spike46;
	private final ModelPart Spike47;
	private final ModelPart Spike48;
	private final ModelPart Spike49;
	private final ModelPart Spike50;

	public ModelHedgehog(ModelPart root)
	{
		this.Head = root.getChild("Head");
		this.BodyNode = root.getChild("BodyNode");
		this.Block3 = root.getChild("Block3");
		this.Block3b = root.getChild("Block3b");
		this.Block3c = root.getChild("Block3c");
		this.Block3d = root.getChild("Block3d");
		this.Block2 = root.getChild("Block2");
		this.Block2b = root.getChild("Block2b");
		this.Block2c = root.getChild("Block2c");
		this.Block2d = root.getChild("Block2d");
		this.Block2e = root.getChild("Block2e");
		this.Block1 = root.getChild("Block1");
		this.Block1b = root.getChild("Block1b");
		this.Block1c = root.getChild("Block1c");
		this.Block4 = root.getChild("Block4");
		this.Block4b = root.getChild("Block4b");
		this.Block4c = root.getChild("Block4c");
		this.Block5 = root.getChild("Block5");
		this.Block5b = root.getChild("Block5b");
		this.Block5c = root.getChild("Block5c");
		this.Block6 = root.getChild("Block6");
		this.Block6b = root.getChild("Block6b");
		this.Block7 = root.getChild("Block7");
		this.Block8 = root.getChild("Block8");
		this.LegBackLeft = root.getChild("LegBackLeft");
		this.LegBackRight = root.getChild("LegBackRight");
		this.LegFrontLeft = root.getChild("LegFrontLeft");
		this.LegFrontRight = root.getChild("LegFrontRight");
		this.LegFrontLeftFoot = root.getChild("LegFrontLeftFoot");
		this.LegFrontLeftFoot1 = root.getChild("LegFrontLeftFoot1");
		this.LegFrontLeftFoot2 = root.getChild("LegFrontLeftFoot2");
		this.LegFrontLeftFoot3 = root.getChild("LegFrontLeftFoot3");
		this.Spike1 = root.getChild("Spike1");
		this.Spike2 = root.getChild("Spike2");
		this.Spike3 = root.getChild("Spike3");
		this.Spike4 = root.getChild("Spike4");
		this.Spike5 = root.getChild("Spike5");
		this.Spike6 = root.getChild("Spike6");
		this.Spike7 = root.getChild("Spike7");
		this.Spike8 = root.getChild("Spike8");
		this.Spike9 = root.getChild("Spike9");
		this.Spike10 = root.getChild("Spike10");
		this.Spike11 = root.getChild("Spike11");
		this.Spike12 = root.getChild("Spike12");
		this.Spike13 = root.getChild("Spike13");
		this.Spike14 = root.getChild("Spike14");
		this.Spike15 = root.getChild("Spike15");
		this.Spike16 = root.getChild("Spike16");
		this.Spike17 = root.getChild("Spike17");
		this.Spike18 = root.getChild("Spike18");
		this.Spike19 = root.getChild("Spike19");
		this.Spike20 = root.getChild("Spike20");
		this.Spike21 = root.getChild("Spike21");
		this.Spike22 = root.getChild("Spike22");
		this.Spike23 = root.getChild("Spike23");
		this.Spike24 = root.getChild("Spike24");
		this.Spike25 = root.getChild("Spike25");
		this.Spike26 = root.getChild("Spike26");
		this.Spike27 = root.getChild("Spike27");
		this.Spike28 = root.getChild("Spike28");
		this.Spike29 = root.getChild("Spike29");
		this.Spike30 = root.getChild("Spike30");
		this.Spike31 = root.getChild("Spike31");
		this.Spike32 = root.getChild("Spike32");
		this.Spike33 = root.getChild("Spike33");
		this.Spike34 = root.getChild("Spike34");
		this.Spike35 = root.getChild("Spike35");
		this.Spike36 = root.getChild("Spike36");
		this.Spike37 = root.getChild("Spike37");
		this.Spike38 = root.getChild("Spike38");
		this.Spike39 = root.getChild("Spike39");
		this.Spike40 = root.getChild("Spike40");
		this.Spike41 = root.getChild("Spike41");
		this.Spike42 = root.getChild("Spike42");
		this.Spike43 = root.getChild("Spike43");
		this.Spike44 = root.getChild("Spike44");
		this.Spike45 = root.getChild("Spike45");
		this.Spike46 = root.getChild("Spike46");
		this.Spike47 = root.getChild("Spike47");
		this.Spike48 = root.getChild("Spike48");
		this.Spike49 = root.getChild("Spike49");
		this.Spike50 = root.getChild("Spike50");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 0)
				.addBox(-2.5F, -1.5F, -2.0F, 5.0F, 3.0F, 4.0F),
				PartPose.offsetAndRotation(-5.245366e-07F, 19.5F, -6.0F, 0.0F, -3.141593F, 0.0F));
		head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(1, 1)
				.addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(-2.18557e-07F, 0.5F, -2.5F, 0.0F, -3.141593F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 4)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-3.059797e-07F, 0.5F, -3.5F, 0.0F, -3.141593F, 0.0F));
		head.addOrReplaceChild("cheek1", CubeListBuilder.create().texOffs(21, 1)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(3.0F, 0.0F, 0.5F, 0.0F, -3.141593F, 0.0F));
		head.addOrReplaceChild("cheek2", CubeListBuilder.create().texOffs(21, 1)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(-3.0F, 0.0F, 0.5F, 0.0F, -3.141593F, 0.0F));
		head.addOrReplaceChild("EarR", CubeListBuilder.create().texOffs(1, 9)
				.addBox(-2.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(2.5F, -1.0F, 1.0F, 0.0F, -2.96706F, 0.3141593F));
		head.addOrReplaceChild("EarL", CubeListBuilder.create().texOffs(1, 9)
				.addBox(-2.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(2.5F, -1.0F, 1.0F, 0.0F, -2.96706F, 0.3141593F));
		head.addOrReplaceChild("EarR1", CubeListBuilder.create().texOffs(1, 12)
				.addBox(0.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(-2.5F, -1.0F, 1.0F, 0.0F, 2.96706F, -0.3141593F));

		root.addOrReplaceChild("BodyNode", CubeListBuilder.create().texOffs(16, 16)
				.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
				PartPose.offsetAndRotation(0.0F, 19.5F, 0.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block3", CubeListBuilder.create().texOffs(0, 25)
				.addBox(-3.5F, -0.5F, -5.5F, 7.0F, 1.0F, 11.0F),
				PartPose.offsetAndRotation(-1.311342e-07F, 20.5F, -1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block3b", CubeListBuilder.create().texOffs(49, 24)
				.addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(3.934025e-07F, 20.5F, 4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block3c", CubeListBuilder.create().texOffs(44, 19)
				.addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F),
				PartPose.offsetAndRotation(4.0F, 20.5F, -3.496911e-07F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block3d", CubeListBuilder.create().texOffs(44, 19)
				.addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F),
				PartPose.offsetAndRotation(-4.0F, 20.5F, 3.496911e-07F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block2", CubeListBuilder.create().texOffs(0, 13)
				.addBox(-3.5F, -0.5F, -5.5F, 7.0F, 1.0F, 11.0F),
				PartPose.offsetAndRotation(-4.371139e-08F, 21.5F, -0.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block2b", CubeListBuilder.create().texOffs(45, 7)
				.addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.68248e-07F, 21.5F, -6.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block2c", CubeListBuilder.create().texOffs(45, 7)
				.addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-6.556708e-07F, 21.5F, -7.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block2d", CubeListBuilder.create().texOffs(42, 24)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(4.0F, 21.5F, 2.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block2e", CubeListBuilder.create().texOffs(42, 24)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(-4.0F, 21.5F, 2.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block1", CubeListBuilder.create().texOffs(38, 0)
				.addBox(-2.5F, -0.5F, -4.0F, 5.0F, 1.0F, 8.0F),
				PartPose.offsetAndRotation(0.0F, 22.50005F, 0.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block1b", CubeListBuilder.create().texOffs(45, 7)
				.addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-3.934025e-07F, 22.50005F, -4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block1c", CubeListBuilder.create().texOffs(45, 20)
				.addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(3.934025e-07F, 22.50005F, 4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block4", CubeListBuilder.create().texOffs(29, 21)
				.addBox(-4.5F, -1.5F, -3.5F, 9.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(-4.371139e-08F, 18.5F, -0.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block4b", CubeListBuilder.create().texOffs(33, 25)
				.addBox(-2.5F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(-4.808253e-07F, 17.5F, -5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block4c", CubeListBuilder.create().texOffs(35, 27)
				.addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-6.556708e-07F, 17.5F, -7.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block5", CubeListBuilder.create().texOffs(30, 21)
				.addBox(-3.5F, -0.5F, -4.0F, 7.0F, 1.0F, 8.0F),
				PartPose.offsetAndRotation(-8.742278e-08F, 16.5F, -1.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block5b", CubeListBuilder.create().texOffs(35, 27)
				.addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-4.808253e-07F, 16.5F, -5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block5c", CubeListBuilder.create().texOffs(35, 27)
				.addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.68248e-07F, 16.5F, -6.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block6", CubeListBuilder.create().texOffs(30, 21)
				.addBox(-2.5F, -0.5F, -4.0F, 5.0F, 1.0F, 8.0F),
				PartPose.offsetAndRotation(-8.742278e-08F, 15.5F, -1.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block6b", CubeListBuilder.create().texOffs(35, 27)
				.addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-4.808253e-07F, 15.5F, -5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block7", CubeListBuilder.create().texOffs(37, 31)
				.addBox(-3.5F, -2.0F, -0.5F, 7.0F, 4.0F, 1.0F),
				PartPose.offsetAndRotation(3.059797e-07F, 18.0F, 3.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Block8", CubeListBuilder.create().texOffs(43, 21)
				.addBox(-2.5F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(3.934025e-07F, 18.5F, 4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("LegBackLeft", CubeListBuilder.create().texOffs(46, 1)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(3.0F, 21.5F, 2.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("LegBackRight", CubeListBuilder.create().texOffs(46, 1)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(-3.0F, 21.5F, 2.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("LegFrontLeft", CubeListBuilder.create().texOffs(46, 1)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(3.0F, 21.5F, -2.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("LegFrontRight", CubeListBuilder.create().texOffs(46, 1)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(-3.0F, 21.5F, -2.0F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("LegFrontLeftFoot", CubeListBuilder.create().texOffs(5, 4)
				.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(3.0F, 23.0F, -2.5F, 0.0F, 2.932153F, 0.0F));

		root.addOrReplaceChild("LegFrontLeftFoot1", CubeListBuilder.create().texOffs(5, 4)
				.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(3.0F, 23.0F, 1.5F, 0.0F, 2.932153F, 0.0F));

		root.addOrReplaceChild("LegFrontLeftFoot2", CubeListBuilder.create().texOffs(5, 4)
				.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-3.0F, 23.0F, 1.5F, 0.0F, -2.932153F, 0.0F));

		root.addOrReplaceChild("LegFrontLeftFoot3", CubeListBuilder.create().texOffs(5, 4)
				.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-3.0F, 23.0F, -2.5F, 0.0F, -2.932153F, 0.0F));

		root.addOrReplaceChild("Spike1", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(4.808253e-07F, 22.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike2", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(2.0F, 21.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike3", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-2.0F, 21.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike4", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.0F, 21.50005F, 2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike5", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(5.0F, 21.50005F, 2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike6", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(1.0F, 20.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike7", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-0.9999995F, 20.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike8", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(4.0F, 20.50005F, 3.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike9", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-4.0F, 20.50005F, 3.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike10", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.0F, 20.50005F, -0.4999996F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike11", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(5.0F, 20.50005F, -0.5000004F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike12", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(5.0F, 19.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike13", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(5.0F, 19.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike14", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(5.0F, 17.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike15", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(5.0F, 17.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike16", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(5.0F, 18.50005F, -0.5000005F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike17", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.0F, 19.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike18", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.0F, 19.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike19", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.0F, 17.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike20", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.0F, 17.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike21", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-5.0F, 18.50005F, -0.4999995F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike22", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(4.0F, 16.50005F, -0.5000004F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike23", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-4.0F, 16.50005F, -0.4999997F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike24", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-4.371139e-07F, 16.50005F, -7.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike25", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(0.9999996F, 15.50005F, -6.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike26", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-1.0F, 15.50005F, -6.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike27", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(3.0F, 15.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike28", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(3.0F, 15.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike29", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-3.0F, 15.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike30", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-3.0F, 15.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike31", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(1.0F, 14.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike32", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-0.9999996F, 14.50005F, 1.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike33", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-2.0F, 14.50005F, -0.4999999F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike34", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(1.748456e-07F, 14.50005F, -0.5000001F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike35", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(2.0F, 14.50005F, -0.5000002F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike36", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(1.0F, 14.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike37", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-1.0F, 14.50005F, -2.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike38", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-1.748456e-07F, 14.50005F, -4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike39", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(2.0F, 14.50005F, -4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike40", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-2.0F, 14.50005F, -4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike41", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(4.0F, 18.50005F, 3.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike42", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-4.0F, 18.50005F, 3.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike43", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(2.0F, 18.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike44", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(4.808253e-07F, 18.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike45", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-2.0F, 18.50005F, 5.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike46", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(3.0F, 19.50005F, 4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike47", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-3.0F, 19.50005F, 4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike48", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(1.0F, 16.50005F, 4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike49", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-0.9999996F, 16.50005F, 4.5F, 0.0F, -3.141593F, 0.0F));

		root.addOrReplaceChild("Spike50", CubeListBuilder.create().texOffs(15, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(3.059797e-07F, 15.50005F, 3.5F, 0.0F, -3.141593F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		 
		 
		 
		this.Head.xRot = headPitch * ((float) Math.PI / 180F);
		this.Head.yRot = netHeadYaw * ((float) Math.PI / 180F);

		this.LegFrontLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LegFrontLeftFoot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.LegBackLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.LegFrontLeftFoot1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.LegBackRight.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.LegFrontLeftFoot2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.LegFrontRight.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LegFrontLeftFoot3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.Head.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.BodyNode.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block3b.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block3c.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block3d.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block2b.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block2c.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block2d.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block2e.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block1b.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block1c.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block4.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block4b.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block4c.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block5.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block5b.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block5c.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block6.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block6b.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block7.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Block8.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegBackLeft.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegBackRight.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegFrontLeft.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegFrontRight.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegFrontLeftFoot.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegFrontLeftFoot1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegFrontLeftFoot2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.LegFrontLeftFoot3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike4.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike5.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike6.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike7.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike8.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike9.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike10.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike11.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike12.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike13.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike14.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike15.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike16.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike17.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike18.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike19.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike20.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike21.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike22.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike23.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike24.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike25.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike26.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike27.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike28.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike29.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike30.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike31.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike32.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike33.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike34.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike35.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike36.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike37.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike38.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike39.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike40.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike41.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike42.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike43.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike44.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike45.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike46.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike47.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike48.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike49.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Spike50.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
