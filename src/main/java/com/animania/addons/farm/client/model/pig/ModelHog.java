package com.animania.addons.farm.client.model.pig;

import com.animania.addons.farm.common.entity.pigs.EntityAnimaniaPig;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 




public class ModelHog<T extends EntityAnimaniaPig> extends EntityModel<T>
{
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tail1;
	private final ModelPart nipple1, nipple2, nipple3, nipple4, nipple5, nipple6;
	private final ModelPart ear1, ear1a, ear1b, ear2, ear2a, ear2b;
	private final ModelPart tail1a, tail1b, tail1c, tail1d;
	private final ModelPart blockA, blockB;

	public ModelHog(ModelPart root)
	{
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.tail1 = root.getChild("tail1");
		this.nipple1 = root.getChild("nipple1");
		this.nipple2 = root.getChild("nipple2");
		this.nipple3 = root.getChild("nipple3");
		this.nipple4 = root.getChild("nipple4");
		this.nipple5 = root.getChild("nipple5");
		this.nipple6 = root.getChild("nipple6");
		this.ear1 = this.head.getChild("ear1");
		this.ear1a = this.head.getChild("ear1a");
		this.ear1b = this.head.getChild("ear1b");
		this.ear2 = this.head.getChild("ear2");
		this.ear2a = this.head.getChild("ear2a");
		this.ear2b = this.head.getChild("ear2b");
		this.tail1a = this.tail1.getChild("tail1a");
		this.tail1b = this.tail1.getChild("tail1b");
		this.tail1c = this.tail1.getChild("tail1c");
		this.tail1d = this.tail1.getChild("tail1d");
		this.blockA = root.getChild("block_a");
		this.blockB = root.getChild("block_b");
	}

	protected static PartDefinition buildCommonParts(MeshDefinition mesh)
	{
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2F, 0F, -2F, 4, 6, 4), PartPose.offset(3F, 18F, -5F));
		root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2F, 0F, -2F, 4, 6, 4), PartPose.offset(-3F, 18F, -5F));
		root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2F, 0F, -2F, 4, 6, 4), PartPose.offset(3F, 18F, 7F));
		root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2F, 0F, -2F, 4, 6, 4), PartPose.offset(-3F, 18F, 7F));

		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 8)
				.addBox(-5F, -10F, -7F, 10, 16, 8), PartPose.offsetAndRotation(0F, 11F, 2F, (float) Math.PI / 2F, 0F, 0F));

		root.addOrReplaceChild("nipple1", CubeListBuilder.create().texOffs(17, 22)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(-1.5F, 18.25F, 3.5F, 1.570796F, 0F, 0F));
		root.addOrReplaceChild("nipple2", CubeListBuilder.create().texOffs(17, 22)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(1.5F, 18.25F, 3.5F, 1.570796F, 0F, 0F));
		root.addOrReplaceChild("nipple3", CubeListBuilder.create().texOffs(17, 24)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(-1.5F, 18.25F, 0.4999999F, 1.570796F, 0F, 0F));
		root.addOrReplaceChild("nipple4", CubeListBuilder.create().texOffs(17, 24)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(1.5F, 18.25F, 0.4999997F, 1.570796F, 0F, 0F));
		root.addOrReplaceChild("nipple5", CubeListBuilder.create().texOffs(17, 26)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(-1.5F, 18.25F, -2.5F, 1.570796F, 0F, 0F));
		root.addOrReplaceChild("nipple6", CubeListBuilder.create().texOffs(17, 26)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offsetAndRotation(1.5F, 18.25F, -2.5F, 1.570796F, 0F, 0F));

		root.addOrReplaceChild("block_a", CubeListBuilder.create().texOffs(38, 0)
				.addBox(-1F, -1F, -1.5F, 2, 2, 3), PartPose.offset(0F, 18F, 3F));
		root.addOrReplaceChild("block_b", CubeListBuilder.create().texOffs(44, 1)
				.addBox(-1F, -1F, -1F, 2, 2, 2), PartPose.offset(0F, 19F, 5F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4F, -4F, -8F, 8, 8, 8), PartPose.offset(0F, 11F, -6F));

		head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(16, 16)
				.addBox(-2F, 0F, -9F, 4, 3, 1), PartPose.offset(0F, 0F, 0F));

		addStandardEars(head);

		PartDefinition tail1 = root.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(26, 0)
				.addBox(-2.5F, -0.5F, -0.5F, 3, 1, 1), PartPose.offset(1.5F, 11.5F, 8.499999F));
		tail1.addOrReplaceChild("tail1a", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3), PartPose.offset(-2.908867F, 2.99008F, -0.052852F));
		tail1.addOrReplaceChild("tail1b", CubeListBuilder.create().texOffs(26, 0)
				.addBox(0F, -0.5F, -0.5F, 2, 1, 1), PartPose.offset(-2.3336565F, 3.96033F, 0.258232F));
		tail1.addOrReplaceChild("tail1c", CubeListBuilder.create().texOffs(26, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(0.135806F, 2.88999F, 0.179873F));
		tail1.addOrReplaceChild("tail1d", CubeListBuilder.create().texOffs(26, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-0.891945F, 1.93201F, 0.01863F));

		return root;
	}

	 


	protected static void addStandardEars(PartDefinition head)
	{
		head.addOrReplaceChild("ear1", CubeListBuilder.create().texOffs(3, 28)
				.addBox(-1.5F, -2.5F, -0.5F, 3, 3, 1), PartPose.offset(3F, -2.75F, -5F));
		head.addOrReplaceChild("ear1a", CubeListBuilder.create().texOffs(2, 27)
				.addBox(-1.5F, -0.5F, -1F, 3, 1, 2), PartPose.offset(4.850319F, -5.099236F, -5.554450F));
		head.addOrReplaceChild("ear1b", CubeListBuilder.create().texOffs(3, 28)
				.addBox(-1F, -0.5F, -0.5F, 2, 1, 1), PartPose.offset(4.013302F, -4.488703F, -5.97475F));
		head.addOrReplaceChild("ear2", CubeListBuilder.create().texOffs(3, 28)
				.addBox(-1.5F, -2.5F, -0.5F, 3, 3, 1), PartPose.offset(-3F, -2.75F, -5F));
		head.addOrReplaceChild("ear2a", CubeListBuilder.create().texOffs(2, 27)
				.addBox(-1.5F, -0.5F, -1F, 3, 1, 2), PartPose.offset(-4.850319F, -5.099236F, -5.554450F));
		head.addOrReplaceChild("ear2b", CubeListBuilder.create().texOffs(3, 28)
				.addBox(-1F, -0.5F, -0.5F, 2, 1, 1), PartPose.offset(-4.013302F, -4.488703F, -5.97475F));
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		buildCommonParts(mesh);
		return LayerDefinition.create(mesh, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.ear1.xRot = -0.2617994F; this.ear1.yRot = 0.3490658F; this.ear1.zRot = 0.6981317F;
		this.ear1a.xRot = -0.2617994F; this.ear1a.yRot = 0.3490658F; this.ear1a.zRot = 0.6981317F;
		this.ear1b.xRot = -0.2617994F; this.ear1b.yRot = 0.3490658F; this.ear1b.zRot = 0.6981317F;
		this.ear2.xRot = -0.2617994F; this.ear2.yRot = -0.3490658F; this.ear2.zRot = -0.6981317F;
		this.ear2a.xRot = -0.2617994F; this.ear2a.yRot = -0.3490658F; this.ear2a.zRot = -0.6981317F;
		this.ear2b.xRot = -0.2617994F; this.ear2b.yRot = -0.3490658F; this.ear2b.zRot = -0.6981317F;

		this.tail1.xRot = 0.1409582F;
		this.tail1.yRot = 0.2046205F;
		this.tail1a.xRot = 1.429837F;
		this.tail1a.yRot = -2.936972F;
		this.tail1a.zRot = -3.141593F;

		this.nipple1.xRot = 1.570796F;
		this.nipple2.xRot = 1.570796F;
		this.nipple3.xRot = 1.570796F;
		this.nipple4.xRot = 1.570796F;
		this.nipple5.xRot = 1.570796F;
		this.nipple6.xRot = 1.570796F;

		if (com.animania.config.AnimaniaConfig.gameRules.showParts.get())
		{
			this.blockA.xRot = 0.2617994F;
			this.blockB.xRot = 0F;
		}

		this.head.xRot = entity.getHeadAngleX(0F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.head.y = 11.0F + entity.getHeadAnchorPointY(0F) * 5.5F;
		this.body.xRot = (float) Math.PI / 2F;

		this.leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.leg1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg4.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.nipple1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.nipple2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.nipple3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.nipple4.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.nipple5.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.nipple6.render(poseStack, buffer, packedLight, packedOverlay, color);
		if (com.animania.config.AnimaniaConfig.gameRules.showParts.get())
		{
			this.blockA.render(poseStack, buffer, packedLight, packedOverlay, color);
			this.blockB.render(poseStack, buffer, packedLight, packedOverlay, color);
		}
		this.head.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail1.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
