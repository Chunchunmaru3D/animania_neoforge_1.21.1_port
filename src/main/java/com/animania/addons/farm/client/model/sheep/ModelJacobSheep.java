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

 




public class ModelJacobSheep<T extends EntityAnimaniaSheep> extends EntityModel<T>
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
	private final ModelPart rightFrontLegWool, leftBackLegWool, rightBackLegWool, leftFrontLegWool;
	private final ModelPart leftHorn1, leftHorn2, leftHorn3, leftHorn4, leftHorn5, leftHorn6;
	private final ModelPart rightHorn1, rightHorn2, rightHorn3, rightHorn4, rightHorn5, rightHorn6;
	private final ModelPart headWool;

	private boolean sleeping;

	public ModelJacobSheep(ModelPart root)
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
		this.rightFrontLegWool = root.getChild("right_front_leg_wool");
		this.leftFrontLegWool = root.getChild("left_front_leg_wool");
		this.rightBackLegWool = root.getChild("right_back_leg_wool");
		this.leftBackLegWool = root.getChild("left_back_leg_wool");
		this.leftHorn1 = this.headNode.getChild("left_horn1");
		this.leftHorn2 = this.headNode.getChild("left_horn2");
		this.leftHorn3 = this.headNode.getChild("left_horn3");
		this.leftHorn4 = this.headNode.getChild("left_horn4");
		this.leftHorn5 = this.headNode.getChild("left_horn5");
		this.leftHorn6 = this.headNode.getChild("left_horn6");
		this.rightHorn1 = this.headNode.getChild("right_horn1");
		this.rightHorn2 = this.headNode.getChild("right_horn2");
		this.rightHorn3 = this.headNode.getChild("right_horn3");
		this.rightHorn4 = this.headNode.getChild("right_horn4");
		this.rightHorn5 = this.headNode.getChild("right_horn5");
		this.rightHorn6 = this.headNode.getChild("right_horn6");
		this.headWool = this.headNode.getChild("head_wool");
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
		root.addOrReplaceChild("right_front_leg_wool", CubeListBuilder.create().texOffs(98, 65)
				.addBox(-2F, -2F, -2.5F, 4, 10, 5), PartPose.offset(-4F, 9.149483F, -3.08116F));
		root.addOrReplaceChild("left_front_leg_wool", CubeListBuilder.create().texOffs(98, 65)
				.addBox(-2F, -2F, -2.5F, 4, 10, 5), PartPose.offset(4F, 9.149483F, -3.08116F));
		root.addOrReplaceChild("right_back_leg_wool", CubeListBuilder.create().texOffs(99, 83)
				.addBox(-2F, -1F, -2.5F, 4, 12, 5), PartPose.offset(-4.5F, 7.043413F, 16.245048F));
		root.addOrReplaceChild("left_back_leg_wool", CubeListBuilder.create().texOffs(99, 83)
				.addBox(-2F, -1F, -2.5F, 4, 12, 5), PartPose.offset(4.5F, 7.043413F, 16.245048F));

		return root;
	}

	protected static PartDefinition buildFriesianHead(PartDefinition root)
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
				.addBox(0F, -0.5F, -1F, 1, 1, 1), PartPose.offset(6.138942F, -4.34824F, -8.98533F));
		headNode.addOrReplaceChild("right_ear1", CubeListBuilder.create().texOffs(20, 15)
				.addBox(-4F, -1F, -1F, 4, 2, 1), PartPose.offset(-2.5F, -5.32432F, -8.49016F));
		headNode.addOrReplaceChild("right_ear2", CubeListBuilder.create().texOffs(0, 26)
				.addBox(-1F, -0.5F, -1F, 1, 1, 1), PartPose.offset(-6.139007F, -4.348332F, -8.98443F));
		headNode.addOrReplaceChild("head_wool", CubeListBuilder.create().texOffs(30, 75)
				.addBox(-4F, -1F, -2F, 8, 2, 4), PartPose.offset(0F, -6.712138F, -8.37163F));
		headNode.addOrReplaceChild("left_horn1", CubeListBuilder.create().texOffs(80, 15)
				.addBox(0.5F, -1F, 0F, 7, 2, 2), PartPose.offset(1F, -5.598128F, -12.21374F));
		headNode.addOrReplaceChild("right_horn1", CubeListBuilder.create().texOffs(80, 15)
				.addBox(-7.5F, -1F, 0F, 7, 2, 2), PartPose.offset(-1F, -5.598128F, -12.21374F));
		headNode.addOrReplaceChild("left_horn2", CubeListBuilder.create().texOffs(80, 15)
				.addBox(-0.5F, -1F, -1F, 5, 2, 2), PartPose.offset(5.191446F, -10.539961F, -10.43253F));
		headNode.addOrReplaceChild("right_horn2", CubeListBuilder.create().texOffs(80, 15)
				.addBox(-4.5F, -1F, -1F, 5, 2, 2), PartPose.offset(-5.191445F, -10.539961F, -10.43253F));
		headNode.addOrReplaceChild("left_horn3", CubeListBuilder.create().texOffs(80, 15)
				.addBox(0F, -1F, -1F, 6, 2, 2), PartPose.offset(5.756174F, -8.8120254F, -6.62131F));
		headNode.addOrReplaceChild("right_horn3", CubeListBuilder.create().texOffs(80, 15)
				.addBox(-6F, -1F, -1F, 6, 2, 2), PartPose.offset(-5.756174F, -8.8120254F, -6.62131F));
		headNode.addOrReplaceChild("left_horn4", CubeListBuilder.create().texOffs(80, 15)
				.addBox(1.5F, -1F, -1F, 5, 2, 2), PartPose.offset(0F, -4.2535175F, -11.82384F));
		headNode.addOrReplaceChild("right_horn4", CubeListBuilder.create().texOffs(80, 15)
				.addBox(-6.5F, -1F, -1F, 5, 2, 2), PartPose.offset(0F, -4.2535175F, -11.82384F));
		headNode.addOrReplaceChild("left_horn5", CubeListBuilder.create().texOffs(80, 15)
				.addBox(0F, -1F, -1F, 4, 2, 2), PartPose.offset(1.791364F, -9.788416F, -9.83254F));
		headNode.addOrReplaceChild("right_horn5", CubeListBuilder.create().texOffs(80, 15)
				.addBox(-4F, -1F, -1F, 4, 2, 2), PartPose.offset(-1.791363F, -9.788416F, -9.83254F));
		headNode.addOrReplaceChild("left_horn6", CubeListBuilder.create().texOffs(80, 15)
				.addBox(0F, -0.5F, -1F, 6, 1, 2), PartPose.offset(2.975353F, -12.697499F, -7.53798F));
		headNode.addOrReplaceChild("right_horn6", CubeListBuilder.create().texOffs(80, 15)
				.addBox(-6F, -0.5F, -1F, 6, 1, 2), PartPose.offset(-2.975352F, -12.697499F, -7.53798F));
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
		buildFriesianHead(root);
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
		this.rightFrontLegWool.xRot = -0.009773839F;
		this.leftFrontLegWool.xRot = -0.009773841F;
		this.rightBackLegWool.xRot = -0.01396263F;
		this.leftBackLegWool.xRot = -0.01396263F;
		this.woolBody1.xRot = 0.01443809F;
		this.woolBody2.xRot = -0.03490658F;
		this.woolHips.xRot = -0.03490658F;
		this.neckWool.xRot = -0.5530767F;
		this.neckWool2.xRot = -0.3974314F;
		this.headWool.xRot = 0.1118027F;
		this.leftHorn1.xRot = -0.8541339F; this.leftHorn1.yRot = -0.1428768F; this.leftHorn1.zRot = -0.9456399F;
		this.rightHorn1.xRot = -0.8541341F; this.rightHorn1.yRot = 0.1428769F; this.rightHorn1.zRot = 0.9456401F;
		this.leftHorn2.xRot = -0.9789219F; this.leftHorn2.yRot = -1F; this.leftHorn2.zRot = 1.628694F;
		this.rightHorn2.xRot = -0.9789221F; this.rightHorn2.yRot = 1F; this.rightHorn2.zRot = -1.628695F;
		this.leftHorn3.xRot = 0.2919102F; this.leftHorn3.zRot = 1.604513F;
		this.rightHorn3.xRot = 0.2919102F; this.rightHorn3.zRot = -1.604513F;
		this.leftHorn4.xRot = -0.5085339F; this.leftHorn4.yRot = -0.3490964F; this.leftHorn4.zRot = -1.245775F;
		this.rightHorn4.xRot = -0.508534F; this.rightHorn4.yRot = 0.3490964F; this.rightHorn4.zRot = 1.245775F;
		this.leftHorn5.xRot = -0.4881583F; this.leftHorn5.yRot = -0.58615F; this.leftHorn5.zRot = -1.1681811F;
		this.rightHorn5.xRot = -0.4881585F; this.rightHorn5.yRot = 0.58615F; this.rightHorn5.zRot = 1.1681811F;
		this.leftHorn6.xRot = -0.361659F; this.leftHorn6.yRot = -0.7571205F; this.leftHorn6.zRot = -1.2210798F;
		this.rightHorn6.xRot = -0.3616591F; this.rightHorn6.yRot = 0.7571207F; this.rightHorn6.zRot = 1.2210801F;

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
			this.leftFrontLegWool.xRot = sleepTimer * -1.8F;
			this.rightFrontLeg.xRot = sleepTimer * -1.8F;
			this.rightFrontLegWool.xRot = sleepTimer * -1.8F;
			this.leftBackLeg.xRot = sleepTimer * 1.8F;
			this.leftBackLegWool.xRot = sleepTimer * 1.8F;
			this.rightBackLeg.xRot = sleepTimer * 1.8F;
			this.rightBackLegWool.xRot = sleepTimer * 1.8F;
			this.headNode.yRot = sleepTimer * -4.5F;
			this.body.xRot = sleepTimer > -0.28F ? -(sleepTimer / 3F) : (sleepTimer / 3F);
			this.tail.yRot = Mth.sin(1 * (float) Math.PI * 0.05F) * Mth.sin(1 * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
		else
		{
			this.tail.yRot = Mth.sin(ageInTicks * (float) Math.PI * 0.05F) * Mth.sin(ageInTicks * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
			this.leftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
			this.leftBackLegWool.xRot = Mth.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
			this.rightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.rightBackLegWool.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leftFrontLegWool.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.rightFrontLegWool.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftBackLeg, 0.97F);
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightBackLeg, 0.95F);
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftFrontLeg, 0.95F);
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightFrontLeg, 0.97F);
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftBackLegWool, 0.97F);
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightBackLegWool, 0.95F);
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.leftFrontLegWool, 0.95F);
			ModelDorperSheep.renderScaled(poseStack, buffer, packedLight, packedOverlay, color, this.rightFrontLegWool, 0.97F);
		}
		else
		{
			this.leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftBackLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightBackLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.leftFrontLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.rightFrontLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
		this.headWool.render(poseStack, buffer, packedLight, packedOverlay, color);
	}

	 



	public void renderWool(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.woolHips.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.woolBody1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.woolBody2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.neckWool.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.neckWool2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leftBackLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.rightBackLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leftFrontLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.rightFrontLegWool.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
