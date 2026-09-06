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

 





public class ModelCalfLonghorn<T extends EntityAnimaniaCow> extends EntityModel<T>
{
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tailTop;
	private final ModelPart tail;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;

	private boolean sleeping;

	public ModelCalfLonghorn(ModelPart root)
	{
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tailTop = root.getChild("tail_top");
		this.tail = root.getChild("tail");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
	}

	 



	protected static void addLegs(PartDefinition root, int u0, int v0, int u1, int v1, int u2, int v2, int u3, int v3)
	{
		root.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(u0, v0)
				.addBox(-1F, 1F, -1F, 2, 8, 2), PartPose.offset(-2F, 15F, -3.5F));
		root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(u1, v1)
				.addBox(-1F, 1F, -1F, 2, 8, 2), PartPose.offset(2F, 15F, -3.5F));
		root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(u2, v2)
				.addBox(-1F, 1F, -1F, 2, 8, 2), PartPose.offset(-2F, 15F, 3.5F));
		root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(u3, v3)
				.addBox(-1F, 1F, -1F, 2, 8, 2), PartPose.offset(2F, 15F, 3.5F));
	}

	protected static void addStandardHorns(PartDefinition head)
	{
		head.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(22, 0)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(-2F, -3.5F, 0F));
		head.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(22, 0)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(2F, -3.5F, 0F));
	}

	protected static PartDefinition buildCommonParts(MeshDefinition mesh)
	{
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(29, 9)
				.addBox(-3F, -4.5F, -2.5F, 6, 9, 5), PartPose.offsetAndRotation(0F, 13.5F, 0F, (float) Math.PI / 2F, 0F, 0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(3, 4)
				.addBox(-3.01F, -3F, -2F, 6, 6, 4), PartPose.offset(0F, 11.5F, -6.5F));

		head.addOrReplaceChild("ear_l", CubeListBuilder.create().texOffs(6, 48)
				.addBox(-1F, -1F, -0.5F, 2, 2, 1), PartPose.offset(-4F, -1F, 0F));
		head.addOrReplaceChild("ear_r", CubeListBuilder.create().texOffs(0, 48)
				.addBox(-1F, -1F, -0.5F, 2, 2, 1), PartPose.offset(4F, -1F, 0F));
		head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(50, 51)
				.addBox(-2F, -1.5F, -1F, 4, 3, 2), PartPose.offset(0F, 2F, -1.5F));

		root.addOrReplaceChild("tail_top", CubeListBuilder.create().texOffs(32, 49)
				.addBox(-0.5F, -0.5F, 0F, 1, 1, 1), PartPose.offsetAndRotation(0F, 12.1F, 4.5F, (float) Math.PI / 2F, 0F, 0F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(28, 15)
				.addBox(-0.5F, -0.5F, -2F, 1, 1, 2), PartPose.offsetAndRotation(0F, 12F, 4.5F, -2F, (float) Math.PI, (float) Math.PI));
		tail.addOrReplaceChild("tail_hair1", CubeListBuilder.create().texOffs(23, 52)
				.addBox(-1F, 0F, -3.05F, 2, 0, 3), PartPose.offsetAndRotation(0F, 0.25F, -1.3F, 0F, 0F, -2.280276F));
		tail.addOrReplaceChild("tail_hair2", CubeListBuilder.create().texOffs(23, 52)
				.addBox(-1F, 0F, -2.5F, 2, 0, 3), PartPose.offsetAndRotation(-1.769535E-16F, 0F, -2.547969F, 0F, 0F, 2.432113F));

		return root;
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = buildCommonParts(mesh);
		addLegs(root, 28, 34, 6, 34, 4, 18, 4, 18);  
		addStandardHorns(root.getChild("head"));
		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		boolean sleeping = entity.getSleeping();
		this.sleeping = sleeping;

		if (sleeping)
		{
			float sleepTimer = entity.getSleepTimer();
			this.leg0.xRot = sleepTimer * -1.8F;
			this.leg1.xRot = sleepTimer * -1.8F;
			this.leg2.xRot = sleepTimer * 1.7F;
			this.leg3.xRot = sleepTimer * 1.75F;
			this.head.yRot = sleepTimer * 2.8F;
			this.body.xRot = sleepTimer > -0.28F
					? (float) Math.PI / 2F - (sleepTimer / 3F)
					: (float) Math.PI / 2F + (sleepTimer / 3F);
			this.tail.yRot = Mth.sin(1 * (float) Math.PI * 0.05F) * Mth.sin(1 * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
		else
		{
			this.leg0.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leg1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.head.yRot = 0F;
			this.head.y = 10.0F + entity.getHeadAnchorPointY(0F) * 6.0F;
			this.body.xRot = (float) Math.PI / 2F;
			this.tail.yRot = Mth.sin(ageInTicks * (float) Math.PI * 0.05F) * Mth.sin(ageInTicks * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.head.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tailTop.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail.render(poseStack, buffer, packedLight, packedOverlay, color);
		if (this.sleeping)
		{
			ModelCow.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg0, 0.95F);
			ModelCow.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg1, 0.97F);
			ModelCow.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg2, 0.97F);
			ModelCow.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leg3, 0.95F);
		}
		else
		{
			this.leg0.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leg1.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leg2.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leg3.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
	}
}
