package com.animania.addons.farm.client.model.cow;

import com.animania.addons.farm.common.entity.cows.EntityAnimaniaCow;
import com.animania.config.AnimaniaConfig;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 






public class ModelBullLonghorn<T extends EntityAnimaniaCow> extends EntityModel<T>
{
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart bodyHump;
	private final ModelPart bodyHump2;
	private final ModelPart sac;
	private final ModelPart penis;
	private final ModelPart tailTop;
	private final ModelPart tail;
	private final ModelPart earL;
	private final ModelPart earLa;
	private final ModelPart earR;
	private final ModelPart earRa;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;

	private boolean sleeping;

	public ModelBullLonghorn(ModelPart root)
	{
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.bodyHump = root.getChild("body_hump");
		this.bodyHump2 = root.getChild("body_hump2");
		this.sac = root.getChild("sac");
		this.penis = root.getChild("penis");
		this.tailTop = root.getChild("tail_top");
		this.tail = root.getChild("tail");
		this.earL = this.head.getChild("ear_l");
		this.earLa = this.head.getChild("ear_la");
		this.earR = this.head.getChild("ear_r");
		this.earRa = this.head.getChild("ear_ra");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
	}

	 



	protected static void addStandardHorns(PartDefinition head)
	{
		head.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(22, 0)
				.addBox(-2.5F, -1F, -1F, 5, 2, 2), PartPose.offset(4.5F, -4F, 0F));
		head.addOrReplaceChild("horn1a", CubeListBuilder.create().texOffs(22, 0)
				.addBox(-0.5F, -1F, -1F, 3, 2, 2), PartPose.offset(6.4F, -4F, 0F));
		head.addOrReplaceChild("horn1b", CubeListBuilder.create().texOffs(46, 0)
				.addBox(-0.5F, -1F, -1F, 1, 2, 2), PartPose.offset(7.536851F, -3.71F, -2.0F));
		head.addOrReplaceChild("horn1c", CubeListBuilder.create().texOffs(52, 1)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(7.121497F, -5.6769695F, -3.15219F));

		head.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(22, 0)
				.addBox(-2.5F, -1F, -1F, 5, 2, 2), PartPose.offset(-4.5F, -4F, 0F));
		head.addOrReplaceChild("horn2a", CubeListBuilder.create().texOffs(36, 0)
				.addBox(-0.5F, -1F, -1F, 3, 2, 2), PartPose.offset(-8.4F, -4F, 0F));
		head.addOrReplaceChild("horn2b", CubeListBuilder.create().texOffs(46, 0)
				.addBox(-0.5F, -1F, -1F, 1, 2, 2), PartPose.offset(-7.406949F, -4.71F, -2.0F));
		head.addOrReplaceChild("horn2c", CubeListBuilder.create().texOffs(52, 1)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(-7.079102F, -5.7030411F, -3.22298F));
	}

	protected static PartDefinition buildCommonParts(PartDefinition root)
	{
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4)
				.addBox(-6F, -5F, -5F, 12, 10, 10), PartPose.offsetAndRotation(0F, 8F, 4F, 1.570796F, 0F, 0F));
		root.addOrReplaceChild("body_hump", CubeListBuilder.create().texOffs(62, 9)
				.addBox(-7F, -5.02F, -6.5F, 14, 10, 13), PartPose.offsetAndRotation(0F, 8.01F, -5F, 1.570796F, 0F, 0F));
		root.addOrReplaceChild("body_hump2", CubeListBuilder.create().texOffs(71, 34)
				.addBox(-5.5F, -3.02F, -5F, 11, 6, 10), PartPose.offsetAndRotation(0F, 7.200001F, 1F, 1.308997F, 0F, 0F));

		root.addOrReplaceChild("sac", CubeListBuilder.create().texOffs(64, 5)
				.addBox(-1.5F, -1.5F, -1F, 3, 3, 2), PartPose.offsetAndRotation(0F, 14F, 6.983971F, -3.821371E-15F, -3.141593F, -3.141593F));
		root.addOrReplaceChild("penis", CubeListBuilder.create().texOffs(52, 0)
				.addBox(-1F, -2.5F, -2F, 2, 5, 4), PartPose.offsetAndRotation(-3.059797E-07F, 12.5F, 4.983971F, 1.457546F, 3.141593F, 3.141593F));

		root.addOrReplaceChild("tail_top", CubeListBuilder.create().texOffs(32, 49)
				.addBox(-1F, -0.5F, 0F, 2, 1, 1), PartPose.offsetAndRotation(0F, 4.1F, 8.999999F, (float) Math.PI / 2F, 0F, 0F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(27, 51)
				.addBox(-0.5F, -0.5F, -5.7F, 1, 1, 6), PartPose.offsetAndRotation(0F, 4F, 9F, -2F, (float) Math.PI, (float) Math.PI));
		tail.addOrReplaceChild("tail_hair1", CubeListBuilder.create().texOffs(23, 52)
				.addBox(-1F, 0F, -4F, 2, 0, 3), PartPose.offsetAndRotation(0F, -0.1F, -4.64188F, 0F, 0F, -2.280276F));
		tail.addOrReplaceChild("tail_hair2", CubeListBuilder.create().texOffs(23, 52)
				.addBox(-1F, 0F, -4F, 2, 0, 3), PartPose.offsetAndRotation(0F, -0.1F, -4.64188F, 0F, 0F, 2.432113F));

		root.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(0, 32)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(-4F, 13F, -7F));
		root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(24, 32)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(4F, 13F, -7F));
		root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(40, 32)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(4F, 13F, 7F));
		root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2F, 0F, -2F, 4, 12, 4), PartPose.offset(-4F, 13F, 7F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4F, -4F, -3F, 8, 8, 6), PartPose.offset(0F, 5F, -13.0F));

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
		head.addOrReplaceChild("head_top", CubeListBuilder.create().texOffs(3, 3)
				.addBox(-3F, -1.5F, -1.5F, 6, 3, 3), PartPose.offset(0F, -4F, 0F));

		return head;
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartDefinition head = buildCommonParts(root);
		addLonghornHorns(head);
		return LayerDefinition.create(mesh, 128, 64);
	}

	 



	private static void addLonghornHorns(PartDefinition head)
	{
		head.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(22, 0)
				.addBox(0F, -1F, -1F, 6, 2, 2), PartPose.offset(3F, -4F, 0F));
		head.addOrReplaceChild("horn1a", CubeListBuilder.create().texOffs(38, 0)
				.addBox(-1F, -1F, -1F, 2, 2, 2), PartPose.offset(9.964239F, -4.87F, 0F));
		head.addOrReplaceChild("horn1b", CubeListBuilder.create().texOffs(46, 0)
				.addBox(-0.5F, -1F, -1F, 1, 2, 2), PartPose.offset(11.40985F, -5.9427986F, 0F));
		head.addOrReplaceChild("horn1c", CubeListBuilder.create().texOffs(52, 1)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(12.35614F, -6.993765F, 0F));

		head.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(22, 0)
				.addBox(0F, -1F, -1F, 6, 2, 2), PartPose.offset(-9F, -4F, 0F));
		head.addOrReplaceChild("horn2a", CubeListBuilder.create().texOffs(38, 0)
				.addBox(-1F, -1F, -1F, 2, 2, 2), PartPose.offset(-9.964239F, -4.87F, 0F));
		head.addOrReplaceChild("horn2b", CubeListBuilder.create().texOffs(46, 0)
				.addBox(-0.5F, -1F, -1F, 1, 2, 2), PartPose.offset(-11.40985F, -5.9427986F, 0F));
		head.addOrReplaceChild("horn2c", CubeListBuilder.create().texOffs(52, 1)
				.addBox(-0.5F, -1F, -0.5F, 1, 2, 1), PartPose.offset(-12.35614F, -6.993765F, 0F));
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.earL.xRot = 0.2032792F;
		this.earLa.xRot = 0.2032792F;
		this.earR.xRot = 0.2032792F;
		this.earRa.xRot = 0.2032792F;

		boolean sleeping = entity.getSleeping();
		this.sleeping = sleeping;
		float sleepTimer = entity.getSleepTimer();

		if (sleeping)
		{
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
			this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
			if (entity instanceof com.animania.addons.farm.common.entity.cows.EntityBullBase bull && bull.getFighting())
			{
				this.head.y = 14.0F;
				this.head.xRot = bull.getHeadAngleX(-3F);
			}
			else
			{
				this.head.xRot = entity.getHeadAngleX(0F);
				this.head.y = 6.0F + entity.getHeadAnchorPointY(0F) * 9.0F;
			}
			this.body.xRot = (float) Math.PI / 2F;
			this.tail.yRot = Mth.sin(ageInTicks * (float) Math.PI * 0.05F) * Mth.sin(ageInTicks * (float) Math.PI * 0.03F * 0.05F) * 0.15F * (float) Math.PI;
		}
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		 
		 
		this.head.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.bodyHump.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.bodyHump2.render(poseStack, buffer, packedLight, packedOverlay, color);
		if (AnimaniaConfig.gameRules.showParts.get())
		{
			this.sac.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.penis.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
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
		this.tailTop.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
