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

 









public class ModelKidPygmy<T extends EntityAnimaniaGoat> extends EntityModel<T>
{
	private final ModelPart body, butt, tail;
	private final ModelPart leftBackLeg, rightBackLeg, leftFrontLeg, rightFrontLeg;
	private final ModelPart headNode, head, neck;
	private final ModelPart rightEar1, rightEar2, leftEar1, leftEar2;
	private final ModelPart rightHornBud, leftHornBud;
	private final ModelPart mouth, snout1, snout2, snout3, nose;

	private boolean sleeping;

	public ModelKidPygmy(ModelPart root)
	{
		this.body = root.getChild("body");
		this.butt = root.getChild("butt");
		this.tail = root.getChild("tail");
		this.leftBackLeg = root.getChild("left_back_leg");
		this.rightBackLeg = root.getChild("right_back_leg");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.rightFrontLeg = root.getChild("right_front_leg");
		this.headNode = root.getChild("head_node");
		this.head = this.headNode.getChild("head");
		this.neck = this.headNode.getChild("neck");
		this.rightEar1 = this.headNode.getChild("right_ear1");
		this.rightEar2 = this.headNode.getChild("right_ear2");
		this.leftEar1 = this.headNode.getChild("left_ear1");
		this.leftEar2 = this.headNode.getChild("left_ear2");
		this.rightHornBud = this.headNode.getChild("right_horn_bud");
		this.leftHornBud = this.headNode.getChild("left_horn_bud");
		this.mouth = this.headNode.getChild("mouth");
		this.snout1 = this.headNode.getChild("snout1");
		this.snout2 = this.headNode.getChild("snout2");
		this.snout3 = this.headNode.getChild("snout3");
		this.nose = this.headNode.getChild("nose");
	}

	protected static PartDefinition buildBody(PartDefinition root)
	{
		 
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(81, 5)
				.addBox(-5F, -6F, -6.5F, 10, 12, 13), PartPose.offsetAndRotation(0F, 9F, 2F, -0.08726646F, 0F, 0F));
		root.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(74, 43)
				.addBox(-4.5F, -5.5F, -0.5F, 9, 11, 15), PartPose.offset(0F, 9.435779F, 6.980974F));
		root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(38, 10)
				.addBox(-1.5F, -3.5F, -1.5F, 3, 5, 3), PartPose.offset(0F, 5.177864F, 20.9047F));
		root.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(47, 28)
				.addBox(-1.5F, -2F, -2.5F, 3, 16, 5), PartPose.offset(5F, 10.2509F, 16.99774F));
		root.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(47, 28)
				.addBox(-1.5F, -2F, -2.5F, 3, 16, 5), PartPose.offset(-5F, 10.2509F, 16.99774F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(62, 4)
				.addBox(-1.5F, -1F, -2F, 3, 14, 4), PartPose.offset(4F, 11.72712F, -1.250051F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(62, 4)
				.addBox(-1.5F, -1F, -2F, 3, 14, 4), PartPose.offset(-4F, 11.72712F, -1.250051F));

		return root;
	}

	protected static PartDefinition buildHead(PartDefinition root)
	{
		PartDefinition headNode = root.addOrReplaceChild("head_node", CubeListBuilder.create(),
				PartPose.offset(0F, 10.73092F, -1.162896F));

		headNode.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(87, 80)
				.addBox(-2.5F, -4F, -13.5F, 5, 8, 13), PartPose.offsetAndRotation(0F, 0F, 0F, -0.9705301F, 0F, 0F));
		headNode.addOrReplaceChild("head", CubeListBuilder.create().texOffs(9, 60)
				.addBox(-3F, -3.5F, -7.5F, 6, 7, 7), PartPose.offsetAndRotation(0F, -0.4532948F - 10.73092F, -5.183255F + 1.162896F, 0.2771511F, 0F, 0F));
		headNode.addOrReplaceChild("right_ear1", CubeListBuilder.create().texOffs(60, 84)
				.addBox(-4F, -1F, -0.5F, 4, 2, 1), PartPose.offsetAndRotation(-2.5F, -1.556122F - 10.73092F, -8.616005F + 1.162896F, 0.3975939F, -0.2030238F, 0.321354F));
		headNode.addOrReplaceChild("right_ear2", CubeListBuilder.create().texOffs(49, 80)
				.addBox(-2.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(-4.761655F, -2.284157F - 10.73092F, -9.393745F + 1.162896F, 0.397594F, -0.2030239F, 0.3213542F));
		headNode.addOrReplaceChild("left_ear1", CubeListBuilder.create().texOffs(60, 84)
				.addBox(0F, -1F, -0.5F, 4, 2, 1), PartPose.offsetAndRotation(2.5F, -1.556122F - 10.73092F, -8.616005F + 1.162896F, 0.3975939F, 0.2030238F, -0.321354F));
		headNode.addOrReplaceChild("left_ear2", CubeListBuilder.create().texOffs(49, 80)
				.addBox(1.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(4.761655F, -2.284157F - 10.73092F, -9.393745F + 1.162896F, 0.397594F, 0.2030239F, -0.3213542F));
		headNode.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(8, 111)
				.addBox(-1.5F, -0.5F, -5.5F, 3, 1, 6), PartPose.offsetAndRotation(0F, 3.977737F - 10.73092F, -10.1608F + 1.162896F, 0.2771511F, 0F, 0F));
		headNode.addOrReplaceChild("snout3", CubeListBuilder.create().texOffs(9, 86)
				.addBox(-1.5F, 0F, -5F, 3, 2, 5), PartPose.offsetAndRotation(0F, -0.2211952F - 10.73092F, -12.39496F + 1.162896F, 0.6541421F, 0F, 0F));
		headNode.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(40, 91)
				.addBox(-1F, 0F, 0F, 2, 2, 2), PartPose.offsetAndRotation(0F, 2.882965F - 10.73092F, -16.94551F + 1.162896F, 0.4028149F, 0F, 0F));
		headNode.addOrReplaceChild("snout1", CubeListBuilder.create().texOffs(11, 76)
				.addBox(-1.5F, 0F, -5.5F, 3, 2, 6), PartPose.offsetAndRotation(-0.01F, -1.447739F - 10.73092F, -12.70536F + 1.162896F, 1.100248F, 0F, 0F));
		headNode.addOrReplaceChild("snout2", CubeListBuilder.create().texOffs(10, 96)
				.addBox(-2F, -0.5F, -5F, 4, 3, 6), PartPose.offsetAndRotation(0F, 1.374268F - 10.73092F, -11.80168F + 1.162896F, 0.4028149F, 0F, 0F));
		headNode.addOrReplaceChild("left_horn_bud", CubeListBuilder.create().texOffs(38, 64)
				.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3), PartPose.offsetAndRotation(1.8F, -3.561049F - 10.73092F, -8.146675F + 1.162896F, 0.1493225F, 0.1260779F, 0.09751797F));
		headNode.addOrReplaceChild("right_horn_bud", CubeListBuilder.create().texOffs(38, 64)
				.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3), PartPose.offsetAndRotation(-1.8F, -3.561049F - 10.73092F, -8.146675F + 1.162896F, 0.1493226F, -0.1260779F, -0.09751798F));

		return headNode;
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = buildBody(mesh.getRoot());
		buildHead(root);
		return LayerDefinition.create(mesh, 128, 128);
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
			this.leftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.rightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.headNode.yRot = 0F;
			this.body.xRot = -0.08726646F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.butt.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.headNode.render(poseStack, buffer, packedLight, packedOverlay, color);

		if (this.sleeping)
		{
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftFrontLeg, 0.95F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightFrontLeg, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftBackLeg, 0.97F);
			ModelDoeAlpine.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightBackLeg, 0.95F);
		}
		else
		{
			this.leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
	}
}
