package com.animania.addons.farm.client.model.goats;

import com.animania.addons.farm.common.entity.goats.EntityAnimaniaGoat;

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

 













public class ModelDoeAngora<T extends EntityAnimaniaGoat> extends EntityModel<T>
{
	private final ModelPart body, butt, tail;
	private final ModelPart leftBackLeg, rightBackLeg, leftFrontLeg, rightFrontLeg;
	private final ModelPart leftBackLegWool, rightBackLegWool, leftFrontLegWool, rightFrontLegWool;
	private final ModelPart wool1, wool2;
	private final ModelPart udder, udder1, udder2, udder3, udder4;
	private final ModelPart headNode, head, neck;
	private final ModelPart rightEar1, rightEar2, leftEar1, leftEar2;
	private final ModelPart rightHornBud, leftHornBud, rightHorn1, rightHorn2, leftHorn1, leftHorn2;
	private final ModelPart mouth, snout1, snout2, snout3, nose;
	private final ModelPart woolHead, woolNeck;

	private boolean sleeping;

	public ModelDoeAngora(ModelPart root)
	{
		this.body = root.getChild("body");
		this.butt = root.getChild("butt");
		this.tail = root.getChild("tail");
		this.leftBackLeg = root.getChild("left_back_leg");
		this.rightBackLeg = root.getChild("right_back_leg");
		this.leftBackLegWool = root.getChild("left_back_leg_wool");
		this.rightBackLegWool = root.getChild("right_back_leg_wool");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.rightFrontLeg = root.getChild("right_front_leg");
		this.leftFrontLegWool = root.getChild("left_front_leg_wool");
		this.rightFrontLegWool = root.getChild("right_front_leg_wool");
		this.wool1 = root.getChild("wool1");
		this.wool2 = root.getChild("wool2");
		this.udder = root.getChild("udder");
		this.udder1 = root.getChild("udder1");
		this.udder2 = root.getChild("udder2");
		this.udder3 = root.getChild("udder3");
		this.udder4 = root.getChild("udder4");
		this.headNode = root.getChild("head_node");
		this.head = this.headNode.getChild("head");
		this.neck = this.headNode.getChild("neck");
		this.rightEar1 = this.headNode.getChild("right_ear1");
		this.rightEar2 = this.headNode.getChild("right_ear2");
		this.leftEar1 = this.headNode.getChild("left_ear1");
		this.leftEar2 = this.headNode.getChild("left_ear2");
		this.rightHornBud = this.headNode.getChild("right_horn_bud");
		this.leftHornBud = this.headNode.getChild("left_horn_bud");
		this.rightHorn1 = this.headNode.getChild("right_horn1");
		this.rightHorn2 = this.headNode.getChild("right_horn2");
		this.leftHorn1 = this.headNode.getChild("left_horn1");
		this.leftHorn2 = this.headNode.getChild("left_horn2");
		this.mouth = this.headNode.getChild("mouth");
		this.snout1 = this.headNode.getChild("snout1");
		this.snout2 = this.headNode.getChild("snout2");
		this.snout3 = this.headNode.getChild("snout3");
		this.nose = this.headNode.getChild("nose");
		this.woolHead = this.headNode.getChild("wool_head");
		this.woolNeck = this.headNode.getChild("wool_neck");
	}

	protected static PartDefinition buildBody(PartDefinition root)
	{
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(81, 5)
				.addBox(-5F, -6.5F, -6.5F, 10, 13, 13), PartPose.offset(0F, 8F, 2F));
		root.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(71, 40)
				.addBox(-4.5F, -6F, 0F, 9, 12, 18), PartPose.offset(0F, 8.435779F, 6.980974F));
		root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(38, 10)
				.addBox(-1.5F, -5F, -1.5F, 3, 8, 3), PartPose.offset(0F, 3.104151F, 24.88555F));
		root.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(47, 28)
				.addBox(-1.5F, -3F, -2.5F, 3, 18, 5), PartPose.offset(5F, 9.213954F, 18.9974F));
		root.addOrReplaceChild("left_back_leg_wool", CubeListBuilder.create().texOffs(19, 208)
				.addBox(-2F, 0F, -3F, 4, 12, 6), PartPose.offset(5F, 5.714552F, 18.93275F));
		root.addOrReplaceChild("wool1", CubeListBuilder.create().texOffs(55, 179)
				.addBox(-6F, -6.5F, 1F, 12, 13, 16), PartPose.offsetAndRotation(0F, 8.610089F, 8.973363F, 0.01847221F, 0F, 0F));
		root.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(47, 28)
				.addBox(-1.5F, -3F, -2.5F, 3, 18, 5), PartPose.offset(-5F, 9.213954F, 18.9974F));
		root.addOrReplaceChild("right_back_leg_wool", CubeListBuilder.create().texOffs(19, 208)
				.addBox(-2F, 0F, -3F, 4, 12, 6), PartPose.offset(-5F, 5.714552F, 18.93275F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(62, 4)
				.addBox(-1.5F, -2F, -2F, 3, 16, 4), PartPose.offset(4F, 10.72712F, -1.250051F));
		root.addOrReplaceChild("left_front_leg_wool", CubeListBuilder.create().texOffs(51, 220)
				.addBox(-2.5F, 1F, -2.5F, 5, 10, 5), PartPose.offset(4.5F, 6.727118F, -1.250051F));
		root.addOrReplaceChild("wool2", CubeListBuilder.create().texOffs(54, 134)
				.addBox(-6.5F, -7F, 0F, 13, 14, 18), PartPose.offsetAndRotation(0F, 7.38991F, -4.973363F, -0.06927392F, 0F, 0F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(62, 4)
				.addBox(-1.5F, -2F, -2F, 3, 16, 4), PartPose.offset(-4F, 10.72712F, -1.250051F));
		root.addOrReplaceChild("right_front_leg_wool", CubeListBuilder.create().texOffs(51, 220)
				.addBox(-2.5F, 1F, -2.5F, 5, 10, 5), PartPose.offset(-4.5F, 6.727116F, -1.250051F));
		root.addOrReplaceChild("udder", CubeListBuilder.create().texOffs(10, 10)
				.addBox(-3F, -2F, -3F, 6, 4, 6), PartPose.offset(0F, 15.37166F, 17.41618F));
		root.addOrReplaceChild("udder1", CubeListBuilder.create().texOffs(15, 15)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(2F, 17.87166F, 15.41618F));
		root.addOrReplaceChild("udder2", CubeListBuilder.create().texOffs(15, 15)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-2F, 17.87166F, 15.41618F));
		root.addOrReplaceChild("udder3", CubeListBuilder.create().texOffs(15, 15)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-2F, 17.87166F, 19.41618F));
		root.addOrReplaceChild("udder4", CubeListBuilder.create().texOffs(15, 15)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(2F, 17.87166F, 19.41618F));

		return root;
	}

	protected static PartDefinition buildHead(PartDefinition root)
	{
		PartDefinition headNode = root.addOrReplaceChild("head_node", CubeListBuilder.create(),
				PartPose.offset(0F, 7.738533F, -0.9885842F));

		headNode.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(85, 78)
				.addBox(-2F, -4F, -14.5F, 4, 8, 15), PartPose.offsetAndRotation(0F, 0F, 0F, -0.9705301F, 0F, 0F));
		headNode.addOrReplaceChild("head", CubeListBuilder.create().texOffs(9, 60)
				.addBox(-3.5F, -3.5F, -7.5F, 7, 7, 7), PartPose.offsetAndRotation(0F, -2.993793F - 7.738533F, -5.669091F + 0.9885842F, 0.2771511F, 0F, 0F));
		headNode.addOrReplaceChild("right_ear1", CubeListBuilder.create().texOffs(60, 84)
				.addBox(-4F, -1F, -0.5F, 4, 2, 1), PartPose.offsetAndRotation(-2.5F, -4.096622F - 7.738533F, -9.101841F + 0.9885842F, 0.3975939F, -0.2030238F, 0.321354F));
		headNode.addOrReplaceChild("right_ear2", CubeListBuilder.create().texOffs(49, 80)
				.addBox(-2.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(-4.761655F, -4.824657F - 7.738533F, -9.879581F + 0.9885842F, 0.397594F, -0.2030239F, 0.3213542F));
		headNode.addOrReplaceChild("left_ear1", CubeListBuilder.create().texOffs(60, 84)
				.addBox(0F, -1F, -0.5F, 4, 2, 1), PartPose.offsetAndRotation(2.5F, -4.096622F - 7.738533F, -9.101841F + 0.9885842F, 0.3975939F, 0.2030238F, -0.321354F));
		headNode.addOrReplaceChild("left_ear2", CubeListBuilder.create().texOffs(49, 80)
				.addBox(1.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(4.761655F, -4.824657F - 7.738533F, -9.879581F + 0.9885842F, 0.397594F, 0.2030239F, -0.3213542F));
		headNode.addOrReplaceChild("right_horn_bud", CubeListBuilder.create().texOffs(38, 64)
				.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3), PartPose.offsetAndRotation(-1.8F, -6.101549F - 7.738533F, -8.632511F + 0.9885842F, 0.1493225F, -0.1260779F, -0.09751795F));
		headNode.addOrReplaceChild("right_horn1", CubeListBuilder.create().texOffs(38, 71)
				.addBox(-1F, -7.5F, -1F, 2, 7, 2), PartPose.offsetAndRotation(-1.691772F, -5.616201F - 7.738533F, -8.545192F + 0.9885842F, -0.7281986F, -0.4957607F, -0.6505846F));
		headNode.addOrReplaceChild("right_horn2", CubeListBuilder.create().texOffs(38, 71)
				.addBox(-1F, -7.4F, 1.7F, 2, 7, 2), PartPose.offsetAndRotation(-6.685526F, -9.676292F - 7.738533F, -7.587014F + 0.9885842F, -0.308694F, -0.19F, -1.523367F));
		headNode.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(8, 111)
				.addBox(-1.5F, -0.5F, -5.5F, 3, 1, 6), PartPose.offsetAndRotation(0F, 1.437237F - 7.738533F, -10.64664F + 0.9885842F, 0.2771511F, 0F, 0F));
		headNode.addOrReplaceChild("snout3", CubeListBuilder.create().texOffs(9, 86)
				.addBox(-1.5F, 0F, -5F, 3, 2, 5), PartPose.offsetAndRotation(0F, -2.624887F - 7.738533F, -13.36171F + 0.9885842F, 0.6541421F, 0F, 0F));
		headNode.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(40, 91)
				.addBox(-1F, 0F, 0F, 2, 2, 2), PartPose.offsetAndRotation(0F, 0.4948158F - 7.738533F, -17.93254F + 0.9885842F, 0.4028149F, 0F, 0F));
		headNode.addOrReplaceChild("snout1", CubeListBuilder.create().texOffs(11, 76)
				.addBox(-1.5F, 0F, -5.5F, 3, 2, 6), PartPose.offsetAndRotation(-0.01F, -3.827187F - 7.738533F, -13.70373F + 0.9885842F, 1.100248F, 0F, 0F));
		headNode.addOrReplaceChild("snout2", CubeListBuilder.create().texOffs(10, 96)
				.addBox(-2F, -0.5F, -5F, 4, 3, 6), PartPose.offsetAndRotation(0F, -1.029425F - 7.738533F, -12.76844F + 0.9885842F, 0.4028149F, 0F, 0F));
		headNode.addOrReplaceChild("left_horn_bud", CubeListBuilder.create().texOffs(38, 64)
				.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3), PartPose.offsetAndRotation(1.8F, -6.101549F - 7.738533F, -8.632511F + 0.9885842F, 0.1493225F, 0.1260779F, 0.09751797F));
		headNode.addOrReplaceChild("left_horn1", CubeListBuilder.create().texOffs(38, 71)
				.addBox(-1F, -7.5F, -1F, 2, 7, 2), PartPose.offsetAndRotation(1.691772F, -5.616201F - 7.738533F, -8.545192F + 0.9885842F, -0.7281986F, 0.4957606F, 0.6505845F));
		headNode.addOrReplaceChild("left_horn2", CubeListBuilder.create().texOffs(38, 71)
				.addBox(-1F, -7.4F, 1.7F, 2, 7, 2), PartPose.offsetAndRotation(6.685524F, -9.676292F - 7.738533F, -7.587016F + 0.9885842F, -0.308693F, 0.19F, 1.523367F));
		headNode.addOrReplaceChild("wool_head", CubeListBuilder.create().texOffs(9, 181)
				.addBox(-4F, -4F, -6.5F, 8, 8, 5), PartPose.offsetAndRotation(0F, -3.814644F - 7.738533F, -2.783574F + 0.9885842F, 0.2771511F, 0F, 0F));
		headNode.addOrReplaceChild("wool_neck", CubeListBuilder.create().texOffs(5, 141)
				.addBox(-3F, -4.5F, -14.5F, 6, 9, 15), PartPose.offsetAndRotation(0F, 7.738533F - 7.738533F, -0.9885848F + 0.9885842F, -0.9705304F, 0F, 0F));

		return headNode;
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = buildBody(mesh.getRoot());
		buildHead(root);
		return LayerDefinition.create(mesh, 128, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.headNode.xRot = entity.getHeadAngleX(0F);
		this.headNode.y = 7.75F + entity.getHeadAnchorPointY(0F) * 6.0F;

		this.sleeping = entity.getSleeping();
		float sleepTimer = entity.getSleepTimer();

		if (this.sleeping)
		{
			this.leftFrontLeg.xRot = sleepTimer * -1.8F;
			this.leftFrontLegWool.xRot = sleepTimer * -1.8F;
			this.rightFrontLeg.xRot = sleepTimer * -1.8F;
			this.rightFrontLegWool.xRot = sleepTimer * -1.8F;
			this.leftBackLeg.xRot = sleepTimer * 1.7F;
			this.leftBackLegWool.xRot = sleepTimer * 1.7F;
			this.rightBackLeg.xRot = sleepTimer * 1.75F;
			this.rightBackLegWool.xRot = sleepTimer * 1.75F;
			this.headNode.yRot = sleepTimer * -2.8F;
			this.body.xRot = sleepTimer > -0.28F ? -(sleepTimer / 3F) : (sleepTimer / 3F);
			this.tail.yRot = Mth.sin(1 * (float) Math.PI * 0.05F) * Mth.sin(1 * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
		else
		{
			this.tail.yRot = Mth.sin(ageInTicks * (float) Math.PI * 0.05F) * Mth.sin(ageInTicks * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
			this.leftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leftBackLegWool.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.rightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.rightBackLegWool.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leftFrontLegWool.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.rightFrontLegWool.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.headNode.yRot = 0F;
			this.body.xRot = 0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.butt.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udder.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udder1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udder2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udder3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.udder4.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wool1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wool2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.headNode.render(poseStack, buffer, packedLight, packedOverlay, color);

		if (this.sleeping)
		{
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftFrontLeg, 0.95F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftFrontLegWool, 0.95F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightFrontLeg, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightFrontLegWool, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftBackLeg, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftBackLegWool, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightBackLeg, 0.95F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightBackLegWool, 0.95F);
		}
		else
		{
			this.leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftBackLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightBackLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftFrontLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightFrontLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
	}
}
