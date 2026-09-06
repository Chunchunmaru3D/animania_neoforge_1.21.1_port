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
import net.minecraft.world.entity.Mob;

 







public class ModelToad<T extends Mob> extends EntityModel<T>
{
	private final ModelPart MainBody;
	private final ModelPart Chubs;
	private final ModelPart Head;
	private final ModelPart Snout1;
	private final ModelPart Snout2;
	private final ModelPart EyeL;
	private final ModelPart EyeR;
	private final ModelPart Neck;
	private final ModelPart HindLegR;
	private final ModelPart HindFootR;
	private final ModelPart HindLegL;
	private final ModelPart HindFootL;
	private final ModelPart FrontLegLTop;
	private final ModelPart FrontLegLMiddle;
	private final ModelPart FrontFootL;
	private final ModelPart FrontLegRTop;
	private final ModelPart FrontLegRMiddle;
	private final ModelPart FrontFootR;

	public ModelToad(ModelPart root)
	{
		this.MainBody = root.getChild("MainBody");
		this.Chubs = root.getChild("Chubs");
		this.Head = root.getChild("Head");
		this.Snout1 = root.getChild("Snout1");
		this.Snout2 = root.getChild("Snout2");
		this.EyeL = root.getChild("EyeL");
		this.EyeR = root.getChild("EyeR");
		this.Neck = root.getChild("Neck");
		this.HindLegR = root.getChild("HindLegR");
		this.HindFootR = root.getChild("HindFootR");
		this.HindLegL = root.getChild("HindLegL");
		this.HindFootL = root.getChild("HindFootL");
		this.FrontLegLTop = root.getChild("FrontLegLTop");
		this.FrontLegLMiddle = root.getChild("FrontLegLMiddle");
		this.FrontFootL = root.getChild("FrontFootL");
		this.FrontLegRTop = root.getChild("FrontLegRTop");
		this.FrontLegRMiddle = root.getChild("FrontLegRMiddle");
		this.FrontFootR = root.getChild("FrontFootR");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("MainBody", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.0F, 0.0F, -7.0F, 4.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(-2.25725e-07F, 19.0F, -2.581994F, 0.3378883F, -3.141593F, -9.023148e-16F));

		root.addOrReplaceChild("Chubs", CubeListBuilder.create().texOffs(7, 22)
				.addBox(-3.0F, 0.0F, -5.5F, 6.0F, 3.0F, 6.0F),
				PartPose.offsetAndRotation(-1.577356e-07F, 19.80322F, -1.804284F, 0.3378883F, -3.141593F, -9.023148e-16F));

		root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 10)
				.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 3.0F),
				PartPose.offsetAndRotation(-0.01000023F, 19.0F, -2.581994F, -0.1531985F, 8.742279e-08F, -3.141593F));

		root.addOrReplaceChild("Snout1", CubeListBuilder.create().texOffs(0, 15)
				.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-4.854712e-07F, 18.5422F, -5.546859F, -0.6654596F, -3.141593F, -4.153653e-15F));

		root.addOrReplaceChild("Snout2", CubeListBuilder.create().texOffs(0, 21)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(0.00999938F, 19.77704F, -7.120125F, -0.03649529F, -3.141593F, -3.182659e-15F));

		root.addOrReplaceChild("EyeL", CubeListBuilder.create().texOffs(1, 2)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(1.3F, 18.67613F, -6.039873F, -0.1938854F, 2.785568F, 0.07152723F));

		root.addOrReplaceChild("EyeR", CubeListBuilder.create().texOffs(1, 2)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-1.300001F, 18.67613F, -6.039873F, -0.1938854F, -2.785568F, -0.07152724F));

		root.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 18)
				.addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-3.141467e-07F, 21.83037F, -3.576481F, 0.6386186F, -3.141593F, -4.058466e-15F));

		root.addOrReplaceChild("HindLegR", CubeListBuilder.create().texOffs(20, 0)
				.addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F),
				PartPose.offsetAndRotation(-2.5F, 23.0F, 2.0F, 0.3026401F, -2.96706F, -1.009837e-08F));

		root.addOrReplaceChild("HindFootR", CubeListBuilder.create().texOffs(21, 6)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(-3.90315F, 23.4039F, -0.1988889F, 3.076197e-05F, -2.96706F, -9.639443e-09F));

		root.addOrReplaceChild("HindLegL", CubeListBuilder.create().texOffs(20, 0)
				.addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F),
				PartPose.offsetAndRotation(2.5F, 23.0F, 2.0F, 0.3026401F, 2.96706F, 1.009837e-08F));

		root.addOrReplaceChild("HindFootL", CubeListBuilder.create().texOffs(21, 6)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(3.90315F, 23.4039F, -0.1988887F, 3.076197e-05F, 2.96706F, 9.639443e-09F));

		root.addOrReplaceChild("FrontLegLTop", CubeListBuilder.create().texOffs(24, 11)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(2.5F, 19.97F, -4.5F, -0.5422654F, -3.141593F, -6.446634e-16F));

		root.addOrReplaceChild("FrontLegLMiddle", CubeListBuilder.create().texOffs(24, 14)
				.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(2.49F, 21.42505F, -3.039574F, 0.521095F, -3.141593F, -2.761143e-15F));

		root.addOrReplaceChild("FrontFootL", CubeListBuilder.create().texOffs(23, 18)
				.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(2.49F, 24.02687F, -4.533063F, -2.610812e-07F, -3.141593F, -2.39467e-15F));

		root.addOrReplaceChild("FrontLegRTop", CubeListBuilder.create().texOffs(24, 11)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(-2.5F, 19.97F, -4.5F, -0.5422654F, -3.141593F, -6.446634e-16F));

		root.addOrReplaceChild("FrontLegRMiddle", CubeListBuilder.create().texOffs(24, 14)
				.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(-2.51F, 21.42505F, -3.039574F, 0.521095F, -3.141593F, -2.761143e-15F));

		root.addOrReplaceChild("FrontFootR", CubeListBuilder.create().texOffs(23, 18)
				.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-2.51F, 24.02687F, -4.533063F, -2.610812e-07F, -3.141593F, -2.39467e-15F));

		return LayerDefinition.create(mesh, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		 
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.MainBody.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Chubs.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Head.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Snout1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Snout2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.EyeL.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.EyeR.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Neck.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.HindLegR.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.HindFootR.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.HindLegL.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.HindFootL.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegLTop.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegLMiddle.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontFootL.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegRTop.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegRMiddle.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontFootR.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
