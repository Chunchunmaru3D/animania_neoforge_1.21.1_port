package com.animania.addons.farm.client.model.cow;

import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 









public class ModelCow<T extends EntityAnimaniaCow> extends EntityModel<T>
{
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart udder;
	private final ModelPart udderA;
	private final ModelPart udderB;
	private final ModelPart udderC;
	private final ModelPart udderD;
	private final ModelPart tailTop;
	private final ModelPart tail;
	private final ModelPart tailHair1;
	private final ModelPart tailHair2;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	private boolean sleeping;

	public ModelCow(ModelPart root)
	{
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.udder = root.getChild("udder");
		this.udderA = root.getChild("udder_a");
		this.udderB = root.getChild("udder_b");
		this.udderC = root.getChild("udder_c");
		this.udderD = root.getChild("udder_d");
		this.tailTop = root.getChild("tail_top");
		this.tail = root.getChild("tail");
		this.tailHair1 = this.tail.getChild("tail_hair1");
		this.tailHair2 = this.tail.getChild("tail_hair2");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4F, -4F, -3F, 8, 8, 6), PartPose.offset(0F, 5F, -12F));

		head.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(22, 0)
				.addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1), PartPose.offset(4.5F, -3.5F, -0.5F));
		head.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(22, 0)
				.addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1), PartPose.offset(-4.5F, -3.5F, -0.5F));
		head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(49, 50)
				.addBox(-2F, -2F, -1.5F, 4, 4, 3), PartPose.offset(0F, 3F, -2.5F));
		head.addOrReplaceChild("ear_l", CubeListBuilder.create().texOffs(39, 53)
				.addBox(-1.5F, -1F, -0.5F, 3, 2, 1), PartPose.offset(-5.5F, -1.5F, 1F));
		head.addOrReplaceChild("ear_la", CubeListBuilder.create().texOffs(45, 50)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-4.5F, -0.04F, 0.69718F));
		head.addOrReplaceChild("ear_r", CubeListBuilder.create().texOffs(39, 53)
				.addBox(-1.5F, -1F, -0.5F, 3, 2, 1), PartPose.offset(5.5F, -1.5F, 1F));
		head.addOrReplaceChild("ear_ra", CubeListBuilder.create().texOffs(41, 50)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(4.5F, -0.04F, 0.69718F));

		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4)
				.addBox(-6F, -9F, -5F, 12, 18, 10), PartPose.offsetAndRotation(0F, 8F, 0F, (float) Math.PI / 2F, 0F, 0F));

		root.addOrReplaceChild("udder", CubeListBuilder.create().texOffs(52, 0)
				.addBox(-2F, -3F, -1F, 4, 6, 2), PartPose.offsetAndRotation(0F, 14F, 5.5F, (float) Math.PI / 2F, 0F, 0F));
		root.addOrReplaceChild("udder_a", CubeListBuilder.create().texOffs(54, 9)
				.addBox(-0.5F, -0.5F, -1F, 1, 1, 2), PartPose.offsetAndRotation(-1.5F, 15F, 4F, (float) Math.PI / 2F, 0F, 0F));
		root.addOrReplaceChild("udder_b", CubeListBuilder.create().texOffs(54, 9)
				.addBox(-0.5F, -0.5F, -1F, 1, 1, 2), PartPose.offsetAndRotation(-1.5F, 15F, 7F, (float) Math.PI / 2F, 0F, 0F));
		root.addOrReplaceChild("udder_c", CubeListBuilder.create().texOffs(54, 9)
				.addBox(-0.5F, -0.5F, -1F, 1, 1, 2), PartPose.offsetAndRotation(1.5F, 15F, 7F, (float) Math.PI / 2F, 0F, 0F));
		root.addOrReplaceChild("udder_d", CubeListBuilder.create().texOffs(54, 9)
				.addBox(-0.5F, -0.5F, -1F, 1, 1, 2), PartPose.offsetAndRotation(1.5F, 15F, 4F, (float) Math.PI / 2F, 0F, 0F));

		root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 32)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(-4F, 13F, -7F));
		root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(24, 32)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(4F, 13F, -7F));
		root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(40, 32)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(4F, 13F, 7F));
		root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(-4F, 13F, 7F));

		root.addOrReplaceChild("tail_top", CubeListBuilder.create().texOffs(32, 49)
				.addBox(-1F, -0.5F, 0F, 2, 1, 1), PartPose.offsetAndRotation(0F, 4F, 9F, (float) Math.PI / 2F, 0F, 0F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(27, 51)
				.addBox(-0.5F, -1F, -5.7F, 1, 1, 6), PartPose.offsetAndRotation(0F, 4F, 9F, -2F, (float) Math.PI, (float) Math.PI));
		tail.addOrReplaceChild("tail_hair1", CubeListBuilder.create().texOffs(23, 52)
				.addBox(-1F, 0F, -4F, 2, 0, 3), PartPose.offsetAndRotation(0F, -0.5F, -4.64188F, 0F, 0F, -2.280276F));
		tail.addOrReplaceChild("tail_hair2", CubeListBuilder.create().texOffs(23, 52)
				.addBox(-1F, 0F, -4F, 2, 0, 3), PartPose.offsetAndRotation(0F, -0.5F, -4.64188F, 0F, 0F, 2.432113F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		boolean sleeping = entity.getSleeping();
		this.sleeping = sleeping;
		float sleepTimer = entity.getSleepTimer();

		if (sleeping)
		{
			this.leg1.xRot = sleepTimer * -1.8F;
			this.leg2.xRot = sleepTimer * -1.8F;
			this.leg3.xRot = sleepTimer * 1.7F;
			this.leg4.xRot = sleepTimer * 1.75F;
			this.head.yRot = sleepTimer * -2.8F;
			this.body.xRot = sleepTimer > -0.28F
					? (float) Math.PI / 2F - (sleepTimer / 3F)
					: (float) Math.PI / 2F + (sleepTimer / 3F);
			this.tail.yRot = Mth.sin(1 * (float) Math.PI * 0.05F) * Mth.sin(1 * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
		else
		{
			this.leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leg3.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
			 
			 
			this.head.xRot = entity.getHeadAngleX(0F);
			this.head.y = 6.0F + entity.getHeadAnchorPointY(0F) * 9.0F;
			this.body.xRot = (float) Math.PI / 2F;
			this.tail.yRot = Mth.sin(ageInTicks * (float) Math.PI * 0.05F) * Mth.sin(ageInTicks * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.udder.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udderA.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udderB.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udderC.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udderD.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tailTop.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.head.render(poseStack, buffer, packedLight, packedOverlay, color);
		if (this.sleeping)
		{
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg1, 0.95F);
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg2, 0.97F);
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg3, 0.97F);
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg4, 0.95F);
		}
		else
		{
			this.leg1.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leg2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leg3.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leg4.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
	}

	 




	static void renderScaled(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer,
			int packedLight, int packedOverlay, int color, ModelPart part, float scale)
	{
		poseStack.pushPose();
		poseStack.scale(scale, scale, scale);
		part.render(poseStack, buffer, packedLight, packedOverlay, color);
		poseStack.popPose();
	}
}
