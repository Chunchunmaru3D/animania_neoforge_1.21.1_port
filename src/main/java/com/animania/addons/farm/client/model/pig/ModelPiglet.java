package com.animania.addons.farm.client.model.pig;

import com.animania.addons.farm.common.entity.pigs.EntityPigletBase;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 



public class ModelPiglet<T extends EntityPigletBase> extends EntityModel<T>
{
	private final ModelPart body;
	private final ModelPart leg1, leg2, leg3, leg4;
	private final ModelPart head;
	private final ModelPart tail1;
	private final ModelPart ear1, ear1a, ear1b, ear2, ear2a, ear2b;
	private final ModelPart tail1a, tail1b, tail1c, tail1d;

	public ModelPiglet(ModelPart root)
	{
		this.body = root.getChild("body");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.head = root.getChild("head");
		this.tail1 = root.getChild("tail1");
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
	}

	protected static PartDefinition buildCommonParts(MeshDefinition mesh)
	{
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 8)
				.addBox(-1F, 0F, -1F, 2, 3, 2), PartPose.offset(2F, 21F, 0.5F));
		root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 8)
				.addBox(-1F, 0F, -1F, 2, 3, 2), PartPose.offset(-2F, 21F, 0.5F));
		root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 8)
				.addBox(-1F, 0F, -1F, 2, 3, 2), PartPose.offset(2F, 21F, 6.75F));
		root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 8)
				.addBox(-1F, 0F, -1F, 2, 3, 2), PartPose.offset(-2F, 21F, 6.75F));

		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-3F, -4F, -2F, 6, 8, 4), PartPose.offset(0F, 19F, 3F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.5F, -2F, -4F, 5, 4, 4), PartPose.offset(0F, 17F, 1F));

		head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(10, 9)
				.addBox(-2F, -1.5F, -0.5F, 4, 3, 1), PartPose.offset(0F, 1F, -4F));

		addStandardEars(head);

		PartDefinition tail1 = root.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(19, 0)
				.addBox(-2.5F, -0.5F, -0.5F, 3, 1, 1), PartPose.offset(1F, 22.5F, 9.2F));
		tail1.addOrReplaceChild("tail1a", CubeListBuilder.create().texOffs(18, 0)
				.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3), PartPose.offset(-2.168969F, 0.2F, 0.368204F));
		tail1.addOrReplaceChild("tail1b", CubeListBuilder.create().texOffs(20, 1)
				.addBox(-1F, -0.5F, -0.5F, 2, 1, 1), PartPose.offset(-0.994362F, 2.266F, 0.412212F));
		tail1.addOrReplaceChild("tail1c", CubeListBuilder.create().texOffs(24, 0)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-0.195715F, 1.56972F, 0.1946F));
		tail1.addOrReplaceChild("tail1d", CubeListBuilder.create().texOffs(22, 1)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-0.862418F, 1.04738F, 0.246239F));

		return root;
	}

	 


	protected static void addStandardEars(PartDefinition head)
	{
		head.addOrReplaceChild("ear2", CubeListBuilder.create().texOffs(19, 5)
				.addBox(-1.5F, -2.5F, -0.5F, 2, 2, 1), PartPose.offset(-1.4F, -1F, -2F));
		head.addOrReplaceChild("ear2a", CubeListBuilder.create().texOffs(18, 4)
				.addBox(-1.5F, -0.5F, -1F, 2, 1, 2), PartPose.offset(-2.778925F, -2.70552F, -2.34608F));
		head.addOrReplaceChild("ear2b", CubeListBuilder.create().texOffs(19, 5)
				.addBox(-1F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-2.175599F, -2.15293F, -2.72376F));

		head.addOrReplaceChild("ear1", CubeListBuilder.create().texOffs(19, 5)
				.addBox(-1.5F, -2.5F, -0.5F, 2, 2, 1), PartPose.offset(2.2F, -0.4F, -2F));
		head.addOrReplaceChild("ear1a", CubeListBuilder.create().texOffs(18, 4)
				.addBox(-1.5F, -0.5F, -1F, 2, 1, 2), PartPose.offset(3.578925F, -2.10552F, -2.34608F));
		head.addOrReplaceChild("ear1b", CubeListBuilder.create().texOffs(19, 5)
				.addBox(-1F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(2.977831F, -1.42547F, -2.47276F));
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		buildCommonParts(mesh);
		return LayerDefinition.create(mesh, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.ear2.xRot = -0.2617994F; this.ear2.yRot = -0.3490658F; this.ear2.zRot = -0.6981317F;
		this.ear2a.xRot = -0.2617995F; this.ear2a.yRot = -0.3490659F; this.ear2a.zRot = -0.6981319F;
		this.ear2b.xRot = -0.2617995F; this.ear2b.yRot = -0.3490659F; this.ear2b.zRot = -0.6981319F;
		this.ear1.xRot = -0.2617994F; this.ear1.yRot = 0.3490658F; this.ear1.zRot = 0.6981317F;
		this.ear1a.xRot = -0.2617995F; this.ear1a.yRot = 0.3490659F; this.ear1a.zRot = 0.6981319F;
		this.ear1b.xRot = -0.2617995F; this.ear1b.yRot = 0.3490659F; this.ear1b.zRot = 0.6981319F;

		this.tail1a.yRot = 1.5F;
		this.tail1a.xRot = 1.5F;

		this.head.xRot = entity.getHeadAngleX(0F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.head.y = 17.0F + entity.getHeadAnchorPointY(0F) * 3.0F;
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
		this.head.render(poseStack, buffer, packedLight, packedOverlay, color);
		 
		poseStack.pushPose();
		poseStack.scale(0.8F, 0.8F, 0.8F);
		this.tail1.render(poseStack, buffer, packedLight, packedOverlay, color);
		poseStack.popPose();
	}
}
