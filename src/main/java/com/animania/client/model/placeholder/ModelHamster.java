package com.animania.client.model.placeholder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;

 

























public class ModelHamster<T extends Mob> extends EntityModel<T>
{
	private final ModelPart hamsterHead;
	private final ModelPart hamsterNose;
	private final ModelPart hamsterEarRight;
	private final ModelPart hamsterEarLeft;
	private final ModelPart hamsterBody;
	private final ModelPart hamsterTail;
	private final ModelPart hamsterLegBackRight;
	private final ModelPart hamsterLegBackLeft;
	private final ModelPart hamsterLegFrontRight;
	private final ModelPart hamsterLegFrontLeft;
	private final ModelPart[] cheekRight = new ModelPart[5];
	private final ModelPart[] cheekLeft = new ModelPart[5];

	public ModelHamster(ModelPart root)
	{
		this.hamsterHead = root.getChild("hamsterHead");
		this.hamsterNose = root.getChild("hamsterNose");
		this.hamsterEarRight = root.getChild("hamsterEarRight");
		this.hamsterEarLeft = root.getChild("hamsterEarLeft");
		this.hamsterBody = root.getChild("hamsterBody");
		this.hamsterTail = root.getChild("hamsterTail");
		this.hamsterLegBackRight = root.getChild("hamsterLegBackRight");
		this.hamsterLegBackLeft = root.getChild("hamsterLegBackLeft");
		this.hamsterLegFrontRight = root.getChild("hamsterLegFrontRight");
		this.hamsterLegFrontLeft = root.getChild("hamsterLegFrontLeft");
		for (int i = 0; i < 5; i++)
		{
			this.cheekRight[i] = root.getChild("cheekRight" + i);
			this.cheekLeft[i] = root.getChild("cheekLeft" + i);
		}
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("hamsterHead", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.51F, -1.5F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-1.5F, 16.0F, -2.0F));

		root.addOrReplaceChild("hamsterNose", CubeListBuilder.create().texOffs(0, 25)
				.addBox(-1.5F, 1.5F, -6.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-1.5F, 16.0F, -2.0F));

		root.addOrReplaceChild("hamsterEarRight", CubeListBuilder.create().texOffs(10, 15)
				.addBox(-2.5F, -3.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-1.5F, 16.0F, -2.0F));

		root.addOrReplaceChild("hamsterEarLeft", CubeListBuilder.create().texOffs(10, 18)
				.addBox(1.5F, -3.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-1.5F, 16.0F, -2.0F));

		root.addOrReplaceChild("hamsterBody", CubeListBuilder.create().texOffs(28, 8)
				.addBox(-4.02F, -3.0F, -2.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, (float) (Math.PI / 2), 0.0F, 0.0F));

		root.addOrReplaceChild("hamsterTail", CubeListBuilder.create().texOffs(10, 15)
				.addBox(-2.0F, 4.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 15.0F, 2.0F));

		root.addOrReplaceChild("hamsterLegBackRight", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.01F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-2.0F, 21.0F, 6.0F));

		root.addOrReplaceChild("hamsterLegBackLeft", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.01F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(2.0F, 21.0F, 6.0F));

		root.addOrReplaceChild("hamsterLegFrontRight", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-2.0F, 21.0F, -0.5F));

		root.addOrReplaceChild("hamsterLegFrontLeft", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.5F)),
				PartPose.offset(2.0F, 21.0F, -0.5F));

		for (int i = 0; i < 5; i++)
		{
			root.addOrReplaceChild("cheekRight" + i, CubeListBuilder.create().texOffs(10, 21)
					.addBox(-3.5F, 1.5F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(i * 0.4F)),
					PartPose.offset(-1.5F, 16.0F, -2.0F));
			root.addOrReplaceChild("cheekLeft" + i, CubeListBuilder.create().texOffs(10, 24)
					.addBox(2.5F, 1.5F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(i * 0.4F)),
					PartPose.offset(-1.5F, 16.0F, -2.0F));
		}

		return LayerDefinition.create(mesh, 64, 32);
	}

	 
	public int foodStackCount;

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.hamsterLegBackRight.xRot = Mth.cos(limbSwing * 1.5F) * 1.4F * limbSwingAmount;
		this.hamsterLegBackLeft.xRot = Mth.cos(limbSwing * 1.5F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.hamsterLegFrontRight.xRot = Mth.cos(limbSwing * 1.5F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.hamsterLegFrontLeft.xRot = Mth.cos(limbSwing * 1.5F) * 1.4F * limbSwingAmount;

		for (int i = 0; i < 5; i++)
		{
			this.cheekRight[i].visible = i < this.foodStackCount;
			this.cheekLeft[i].visible = i < this.foodStackCount;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.hamsterHead.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterNose.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterEarRight.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterEarLeft.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterBody.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterTail.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterLegBackRight.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterLegBackLeft.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterLegFrontRight.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hamsterLegFrontLeft.render(poseStack, buffer, packedLight, packedOverlay, color);
		for (int i = 0; i < 5; i++)
		{
			this.cheekRight[i].render(poseStack, buffer, packedLight, packedOverlay, color);
			this.cheekLeft[i].render(poseStack, buffer, packedLight, packedOverlay, color);
		}
	}
}
