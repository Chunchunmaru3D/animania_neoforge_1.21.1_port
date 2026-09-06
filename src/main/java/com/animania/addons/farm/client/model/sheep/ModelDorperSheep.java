package com.animania.addons.farm.client.model.sheep;

import com.animania.addons.farm.common.entity.sheep.EntityAnimaniaSheep;
import com.animania.addons.farm.common.entity.sheep.EntityRamBase;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 






public class ModelDorperSheep<T extends EntityAnimaniaSheep> extends EntityModel<T>
{
	private final ModelPart body;
	private final ModelPart rightFrontLeg;
	private final ModelPart leftFrontLeg;
	private final ModelPart hips;
	private final ModelPart rightBackLeg;
	private final ModelPart leftBackLeg;
	private final ModelPart tail;
	private final ModelPart woolBody1;
	private final ModelPart woolBody2;
	private final ModelPart woolHips;
	private final ModelPart headNode;
	private final ModelPart neckWool;
	private final ModelPart neckWool2;

	private boolean sleeping;

	public ModelDorperSheep(ModelPart root)
	{
		this.body = root.getChild("body");
		this.rightFrontLeg = root.getChild("right_front_leg");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.hips = root.getChild("hips");
		this.rightBackLeg = root.getChild("right_back_leg");
		this.leftBackLeg = root.getChild("left_back_leg");
		this.tail = root.getChild("tail");
		this.woolBody1 = root.getChild("wool_body1");
		this.woolBody2 = root.getChild("wool_body2");
		this.woolHips = root.getChild("wool_hips");
		this.headNode = root.getChild("head_node");
		this.neckWool = this.headNode.getChild("neck_wool");
		this.neckWool2 = this.headNode.getChild("neck_wool2");
	}

	protected static PartDefinition buildBody(PartDefinition root)
	{
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 39)
				.addBox(-3.5F, -5.5F, -13.5F, 7, 13, 17), PartPose.offset(0F, 7F, 7F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(107, 4)
				.addBox(-1.5F, 0F, -1.5F, 3, 16, 3), PartPose.offset(-4F, 9.149483F, -3.08116F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(107, 4)
				.addBox(-1.5F, 0F, -1.5F, 3, 16, 3), PartPose.offset(4F, 9.149483F, -3.08116F));
		root.addOrReplaceChild("hips", CubeListBuilder.create().texOffs(56, 25)
				.addBox(-4F, -1F, 0F, 8, 12, 11), PartPose.offset(0F, 2.675018F, 8.651946F));
		root.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(107, 26)
				.addBox(-1.5F, -0.5F, -1.5F, 3, 18, 3), PartPose.offset(-4.5F, 7.543364F, 16.238067F));
		root.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(107, 26)
				.addBox(-1.5F, -0.5F, -1.5F, 3, 18, 3), PartPose.offset(4.5F, 7.543364F, 16.238067F));
		root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.5F, -1F, -2F, 3, 7, 3), PartPose.offset(0F, 3.352909F, 19.66545F));
		root.addOrReplaceChild("wool_body1", CubeListBuilder.create().texOffs(40, 100)
				.addBox(-4.5F, -1.9F, -6F, 9, 8, 12), PartPose.offset(0F, 3.205133F, 6.930936F));
		root.addOrReplaceChild("wool_body2", CubeListBuilder.create().texOffs(1, 104)
				.addBox(-5F, -2.5F, -5F, 10, 7, 8), PartPose.offset(0F, 2.858269F, -1.846455F));
		root.addOrReplaceChild("wool_hips", CubeListBuilder.create().texOffs(85, 104)
				.addBox(-5.5F, -2.5F, -6F, 11, 7, 8), PartPose.offset(0F, 3.509068F, 18.16795F));

		return root;
	}

	protected static PartDefinition buildDorperHead(PartDefinition root)
	{
		PartDefinition headNode = root.addOrReplaceChild("head_node", CubeListBuilder.create(),
				PartPose.offset(0F, 5.110041F, -4.14083F));

		headNode.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 25)
				.addBox(-3F, -2F, -4F, 6, 7, 5), PartPose.offset(0F, -5.132233F, -8.43446F));
		headNode.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 18)
				.addBox(-2.5F, -1.5F, -10.5F, 5, 7, 11), PartPose.offset(0F, 0F, 0F));
		headNode.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(32, 39)
				.addBox(-2F, 0F, -5F, 4, 3, 5), PartPose.offset(0F, -3.057787F, -11.9977F));
		headNode.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 36)
				.addBox(-1F, 0F, 0F, 2, 2, 2), PartPose.offset(-1F, -1.329575F, -17.22295F));
		headNode.addOrReplaceChild("upper_jaw_detail1", CubeListBuilder.create().texOffs(0, 10)
				.addBox(-1.5F, 0F, -5F, 3, 2, 5), PartPose.offset(0F, -5.747008F, -12.77751F));
		headNode.addOrReplaceChild("upper_jaw_detail2", CubeListBuilder.create().texOffs(14, 0)
				.addBox(-1.5F, 0F, -5F, 3, 2, 5), PartPose.offset(0F, -4.745892F, -12.76118F));
		headNode.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(12, 8)
				.addBox(-1.5F, 0F, -5F, 3, 1, 5), PartPose.offset(0F, -0.439627F, -10.61378F));
		headNode.addOrReplaceChild("left_ear1", CubeListBuilder.create().texOffs(20, 15)
				.addBox(0F, -1F, -1F, 4, 2, 1), PartPose.offset(2.5F, -5.32432F, -8.49016F));
		headNode.addOrReplaceChild("left_ear2", CubeListBuilder.create().texOffs(0, 26)
				.addBox(0F, -0.5F, -1F, 1, 1, 1), PartPose.offset(6.166575F, -5.797778F, -9.36884F));
		headNode.addOrReplaceChild("right_ear1", CubeListBuilder.create().texOffs(20, 15)
				.addBox(-4F, -1F, -1F, 4, 2, 1), PartPose.offset(-2.5F, -5.32432F, -8.49016F));
		headNode.addOrReplaceChild("right_ear2", CubeListBuilder.create().texOffs(0, 26)
				.addBox(-1F, -0.5F, -1F, 1, 1, 1), PartPose.offset(-6.166575F, -5.797776F, -9.36883F));
		headNode.addOrReplaceChild("neck_wool", CubeListBuilder.create().texOffs(59, 69)
				.addBox(-3.5F, -2.5F, -5F, 7, 10, 10), PartPose.offset(0F, -2.251757F, -2.0444F));
		headNode.addOrReplaceChild("neck_wool2", CubeListBuilder.create().texOffs(30, 75)
				.addBox(-4F, -2.5F, -2F, 8, 11, 4), PartPose.offset(0F, -5.042712F, -5.98717F));

		return headNode;
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = buildBody(mesh.getRoot());
		buildDorperHead(root);
		return LayerDefinition.create(mesh, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.body.xRot = -0.03490658F;
		this.rightFrontLeg.xRot = -0.009773841F;
		this.leftFrontLeg.xRot = -0.009773842F;
		this.hips.xRot = 0.0174533F;
		this.rightBackLeg.xRot = -0.01396263F;
		this.leftBackLeg.xRot = -0.01396263F;
		this.tail.xRot = 0.6251218F;
		this.woolBody1.xRot = -0.01679522F;
		this.woolBody2.xRot = -0.03490658F;
		this.woolHips.xRot = -0.03490658F;
		this.neckWool.xRot = -0.5530767F;
		this.neckWool2.xRot = -0.19262F;

		boolean fighting = entity instanceof EntityRamBase ram && ram.getFighting() && ram.getRivalUniqueId() != null;

		if (fighting)
		{
			this.headNode.xRot = 0.687F;
			this.headNode.y = 4.0F + entity.getHeadAnchorPointY(0F) * 4.0F;
		}
		else
		{
			this.headNode.xRot = entity.getHeadAngleX(0F);
			this.headNode.yRot = netHeadYaw * ((float) Math.PI / 180F);
			this.headNode.y = 4.0F + entity.getHeadAnchorPointY(0F) * 4.0F;
		}

		boolean sleeping = entity.getSleeping();
		this.sleeping = sleeping;
		float sleepTimer = entity.getSleepTimer();

		if (sleeping)
		{
			this.leftFrontLeg.xRot = sleepTimer * -1.8F;
			this.rightFrontLeg.xRot = sleepTimer * -1.8F;
			this.leftBackLeg.xRot = sleepTimer * 1.7F;
			this.rightBackLeg.xRot = sleepTimer * 1.75F;
			this.headNode.yRot = sleepTimer * -2.8F;
			this.body.xRot = sleepTimer > -0.28F ? -(sleepTimer / 3F) : (sleepTimer / 3F);
			this.tail.yRot = Mth.sin(1 * (float) Math.PI * 0.05F) * Mth.sin(1 * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
		else
		{
			this.tail.yRot = Mth.sin(ageInTicks * (float) Math.PI * 0.05F) * Mth.sin(ageInTicks * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
			this.leftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
			this.rightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		}
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.headNode.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.hips.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.woolHips.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.woolBody1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.woolBody2.render(poseStack, buffer, packedLight, packedOverlay, color);
		if (this.sleeping)
		{
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftBackLeg, 0.97F);
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightBackLeg, 0.95F);
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftFrontLeg, 0.95F);
			renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightFrontLeg, 0.97F);
		}
		else
		{
			this.leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
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

	 



	public void renderWool(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.woolHips.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.woolBody1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.woolBody2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.neckWool.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.neckWool2.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
