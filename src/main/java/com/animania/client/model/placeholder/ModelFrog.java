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

 







public class ModelFrog<T extends Mob> extends EntityModel<T>
{
	private final ModelPart MainBody;
	private final ModelPart HindLegR;
	private final ModelPart HindFootR;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Snout1;
	private final ModelPart Snout2;
	private final ModelPart EyeL;
	private final ModelPart EyeR;
	private final ModelPart FrontLegRTop;
	private final ModelPart FrontLegRMiddle;
	private final ModelPart FrontFootR;
	private final ModelPart FrontLegLTop;
	private final ModelPart FrontLegLMiddle;
	private final ModelPart FrontFootL;
	private final ModelPart HindLegL;
	private final ModelPart HindFootL;

	public ModelFrog(ModelPart root)
	{
		this.MainBody = root.getChild("MainBody");
		this.HindLegR = root.getChild("HindLegR");
		this.HindFootR = root.getChild("HindFootR");
		this.Neck = root.getChild("Neck");
		this.Head = root.getChild("Head");
		this.Snout1 = root.getChild("Snout1");
		this.Snout2 = root.getChild("Snout2");
		this.EyeL = root.getChild("EyeL");
		this.EyeR = root.getChild("EyeR");
		this.FrontLegRTop = root.getChild("FrontLegRTop");
		this.FrontLegRMiddle = root.getChild("FrontLegRMiddle");
		this.FrontFootR = root.getChild("FrontFootR");
		this.FrontLegLTop = root.getChild("FrontLegLTop");
		this.FrontLegLMiddle = root.getChild("FrontLegLMiddle");
		this.FrontFootL = root.getChild("FrontFootL");
		this.HindLegL = root.getChild("HindLegL");
		this.HindFootL = root.getChild("HindFootL");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("MainBody", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 5.0F),
				PartPose.offsetAndRotation(-2.25725e-07F, 19.0F, -2.581994F, 0.5443909F, -3.141593F, -3.529419e-16F));

		root.addOrReplaceChild("HindLegR", CubeListBuilder.create().texOffs(20, 0)
				.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F),
				PartPose.offsetAndRotation(-2.5F, 22.47402F, 5.702166e-07F, 0.3026092F, -3.141593F, 8.267461e-18F));

		root.addOrReplaceChild("HindFootR", CubeListBuilder.create().texOffs(21, 6)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(-2.5F, 23.47402F, -0.4999994F, -1.947392e-07F, -3.141593F, 7.89182e-18F));

		root.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(2, 19)
				.addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-3.615531e-07F, 21.56633F, -4.135685F, 0.8451216F, -3.141593F, 8.215925e-16F));

		root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 8)
				.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 3.0F),
				PartPose.offsetAndRotation(-0.01000047F, 17.94402F, -5.39F, -0.3597011F, 8.74228e-08F, -3.141593F));

		root.addOrReplaceChild("Snout1", CubeListBuilder.create().texOffs(2, 13)
				.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-4.719492e-07F, 17.94402F, -5.39F, -0.458957F, -3.141593F, 2.203421e-16F));

		root.addOrReplaceChild("Snout2", CubeListBuilder.create().texOffs(2, 16)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(0.009999371F, 18.83004F, -7.183031F, 0.1700074F, -3.141593F, 1.505328e-15F));

		root.addOrReplaceChild("EyeL", CubeListBuilder.create().texOffs(0, 8)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(1.299999F, 17.97402F, -5.900001F, -1.248631e-07F, 2.792527F, 4.380097e-08F));

		root.addOrReplaceChild("EyeR", CubeListBuilder.create().texOffs(0, 8)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
				PartPose.offsetAndRotation(-1.3F, 17.97402F, -5.9F, -1.248631e-07F, -2.792527F, -4.380097e-08F));

		root.addOrReplaceChild("FrontLegRTop", CubeListBuilder.create().texOffs(24, 11)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(-2.5F, 19.97402F, -4.5F, -0.5422653F, -3.141593F, -2.302643e-15F));

		root.addOrReplaceChild("FrontLegRMiddle", CubeListBuilder.create().texOffs(24, 14)
				.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(-2.49F, 21.42906F, -3.039574F, 0.5210952F, -3.141593F, -2.330141e-15F));

		root.addOrReplaceChild("FrontFootR", CubeListBuilder.create().texOffs(23, 18)
				.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(-2.49F, 24.03089F, -4.533064F, -1.766048e-07F, -3.141593F, -2.020871e-15F));

		root.addOrReplaceChild("FrontLegLTop", CubeListBuilder.create().texOffs(24, 11)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(2.5F, 19.97402F, -4.5F, -0.5422653F, -3.141593F, -2.302643e-15F));

		root.addOrReplaceChild("FrontLegLMiddle", CubeListBuilder.create().texOffs(24, 14)
				.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(2.49F, 21.42906F, -3.039574F, 0.5210952F, -3.141593F, -2.330141e-15F));

		root.addOrReplaceChild("FrontFootL", CubeListBuilder.create().texOffs(23, 18)
				.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(2.49F, 24.03089F, -4.533064F, -1.766048e-07F, -3.141593F, -2.020871e-15F));

		root.addOrReplaceChild("HindLegL", CubeListBuilder.create().texOffs(20, 0)
				.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F),
				PartPose.offsetAndRotation(2.5F, 22.47402F, 1.253854e-07F, 0.3026092F, -3.141593F, 8.267461e-18F));

		root.addOrReplaceChild("HindFootL", CubeListBuilder.create().texOffs(21, 6)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F),
				PartPose.offsetAndRotation(2.5F, 23.47402F, -0.4999997F, -1.947392e-07F, -3.141593F, 7.89182e-18F));

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
		this.HindLegR.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.HindFootR.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Neck.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Head.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Snout1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Snout2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.EyeL.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.EyeR.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegRTop.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegRMiddle.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontFootR.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegLTop.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontLegLMiddle.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FrontFootL.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.HindLegL.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.HindFootL.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
