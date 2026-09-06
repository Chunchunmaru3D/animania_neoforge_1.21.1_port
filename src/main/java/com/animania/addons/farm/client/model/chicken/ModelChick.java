package com.animania.addons.farm.client.model.chicken;

import com.animania.addons.farm.common.entity.chickens.EntityChickBase;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 







public class ModelChick<T extends EntityChickBase> extends EntityModel<T>
{
	private final ModelPart body;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart wing1;
	private final ModelPart wing2;
	private final ModelPart wing3;
	private final ModelPart wing4;
	private final ModelPart neck;
	private final ModelPart leg1Top;
	private final ModelPart leg2Top;

	public ModelChick(ModelPart root)
	{
		this.body = root.getChild("body");
		this.tail1 = root.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.wing1 = root.getChild("wing1");
		this.wing2 = root.getChild("wing2");
		this.wing3 = root.getChild("wing3");
		this.wing4 = root.getChild("wing4");
		this.neck = root.getChild("neck");
		this.leg1Top = root.getChild("leg1_top");
		this.leg2Top = root.getChild("leg2_top");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10)
				.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3), PartPose.offset(0F, 20.5F, 0F));

		PartDefinition tail1 = root.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(2, 16)
				.addBox(-1F, -1F, -1F, 2, 2, 2),
				PartPose.offsetAndRotation(0F, 20.39043F, 1.525777F, 0.3593722F, 0F, 0F));
		tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(3, 20)
				.addBox(-1F, -0.5F, -0.5F, 2, 1, 1),
				PartPose.offsetAndRotation(0F, -0.73803F, 1.1111F, 0.6340498F, 0F, 0F));

		root.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(2, 23)
				.addBox(-0.5F, -0.5F, 0F, 1, 1, 2), PartPose.offset(1.5F, 20.17379F, -1.547121F));
		root.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(2, 26)
				.addBox(-0.5F, -0.5F, 0F, 1, 1, 2), PartPose.offset(1.4F, 20.66941F, -1.480338F));
		root.addOrReplaceChild("wing3", CubeListBuilder.create().texOffs(2, 23)
				.addBox(-0.5F, -0.5F, 0F, 1, 1, 2), PartPose.offset(-1.5F, 20.17379F, -1.547121F));
		root.addOrReplaceChild("wing4", CubeListBuilder.create().texOffs(2, 26)
				.addBox(-0.5F, -0.5F, 0F, 1, 1, 2), PartPose.offset(-1.4F, 20.66941F, -1.480338F));

		PartDefinition neck = root.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 5)
				.addBox(-1F, -1F, -1.5F, 2, 2, 3), PartPose.offset(0F, 20.1F, -0.7F));
		neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1F, -1F, -1F, 2, 2, 2),
				PartPose.offsetAndRotation(0F, -1.11309F, -1.418133F, -0.0213736F, 0F, 0F));
		neck.addOrReplaceChild("beak_top", CubeListBuilder.create().texOffs(9, 1)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1),
				PartPose.offsetAndRotation(0F, -1.03F, -2.32F, 0.7268012F, 0F, 0F));

		 
		PartDefinition leg1Top = root.addOrReplaceChild("leg1_top", CubeListBuilder.create().texOffs(11, 8)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(-0.75F, 22.1F, 0F));
		leg1Top.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(9, 2)
				.addBox(-0.5F, -2F, -0.5F, 1, 2, 1),
				PartPose.offsetAndRotation(0F, 1.83978F, -0.1833104F, -0.2617994F, 0F, 0F));
		leg1Top.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(9, 2)
				.addBox(-0.5F, -1F, -0.5F, 1, 1, 1),
				PartPose.offsetAndRotation(0F, 1.5983F, -0.1186057F, 1.570796F, 0F, 0F));

		 
		PartDefinition leg2Top = root.addOrReplaceChild("leg2_top", CubeListBuilder.create().texOffs(11, 8)
				.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1), PartPose.offset(0.75F, 22.1F, 0F));
		leg2Top.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(9, 2)
				.addBox(-0.5F, -2F, -0.5F, 1, 2, 1),
				PartPose.offsetAndRotation(0F, 1.83978F, -0.1833103F, -0.2617995F, 0F, 0F));
		leg2Top.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(9, 2)
				.addBox(-0.5F, -1F, -0.5F, 1, 1, 1),
				PartPose.offsetAndRotation(0F, 1.5983F, -0.1186056F, 1.570796F, 0F, 0F));

		return LayerDefinition.create(mesh, 16, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.body.xRot = (float) Math.PI / 2F;
		this.tail1.xRot = 0.3593722F;
		this.tail2.xRot = 0.6340498F;

		this.neck.xRot = Math.abs(netHeadYaw * ((float) Math.PI / 180F));

		this.leg1Top.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2Top.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.wing1.xRot = 0.1139416F;
		this.wing2.xRot = 0.1139416F;
		this.wing3.xRot = 0.1139416F;
		this.wing4.xRot = 0.1139416F;
		this.wing1.zRot = ageInTicks;
		this.wing2.zRot = -ageInTicks;
		this.wing3.zRot = ageInTicks;
		this.wing4.zRot = -ageInTicks;
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wing1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wing2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wing3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wing4.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.neck.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg1Top.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg2Top.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
