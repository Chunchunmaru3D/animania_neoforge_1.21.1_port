package com.animania.client.model.placeholder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.animania.addons.extra.common.entity.rodents.EntityFerretBase;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Mob;

 







public class ModelFerret<T extends Mob> extends EntityModel<T>
{
	private final ModelPart Head;
	private final ModelPart Neck;
	private final ModelPart Body;
	private final ModelPart Body2;
	private final ModelPart PawLF;
	private final ModelPart PawRF;
	private final ModelPart PawLB;
	private final ModelPart PawRB;
	private final ModelPart Tail;

	public ModelFerret(ModelPart root)
	{
		this.Head = root.getChild("Head");
		this.Neck = root.getChild("Neck");
		this.Body = root.getChild("Body");
		this.Body2 = root.getChild("Body2");
		this.PawLF = root.getChild("PawLF");
		this.PawRF = root.getChild("PawRF");
		this.PawLB = root.getChild("PawLB");
		this.PawRB = root.getChild("PawRB");
		this.Tail = root.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 10)
				.addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, 14.35004F, -16.0F, -3.584692e-08F, 0.0F, 0.0F));
		head.addOrReplaceChild("EarR", CubeListBuilder.create().texOffs(12, 0)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(-2.5F, -2.0F, 2.0F, 0.0F, 0.0F, -0.7853982F));
		head.addOrReplaceChild("EarL", CubeListBuilder.create().texOffs(12, 0)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(2.5F, -2.0F, 2.0F, 0.0F, 0.0F, 0.7853982F));

		root.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(30, 0)
				.addBox(-2.0F, -4.0F, -7.0F, 4.0F, 4.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 19.99997F, -10.0F, -0.6108652F, 0.0F, 0.0F));

		root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(12, 10)
				.addBox(-2.01F, -2.01F, -10.0F, 4.0F, 4.0F, 10.0F),
				PartPose.offsetAndRotation(0.0F, 18.0F, 0.0F, 0F, 0F, 0F));

		root.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(36, 15)
				.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 10.0F),
				PartPose.offset(0.0F, 18.0F, 0.0F));

		root.addOrReplaceChild("PawLF", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
				PartPose.offsetAndRotation(1.0F, 19.99997F, -9.0F, 0F, 0F, 0F));

		root.addOrReplaceChild("PawRF", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
				PartPose.offsetAndRotation(-1.0F, 19.99997F, -9.0F, 0F, 0F, 0F));

		root.addOrReplaceChild("PawLB", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
				PartPose.offsetAndRotation(1.0F, 19.99997F, 9.0F, 0F, 0F, 0F));

		root.addOrReplaceChild("PawRB", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
				PartPose.offsetAndRotation(-1.0F, 19.99997F, 9.0F, 0F, 0F, 0F));

		root.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(44, 3)
				.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F),
				PartPose.offsetAndRotation(0.0F, 17.5F, 9.5F, -0.526944F, 0.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		if (entity instanceof EntityFerretBase ferret && ferret.isOrderedToSit())
		{
			this.Body2.z = -1.0F;
			this.Body2.xRot = -0.326944F;
			this.Tail.y = 20.0F;
		}
		else
		{
			this.Body2.z = 0.0F;
			this.Body2.xRot = 0.0F;
			this.Tail.y = 17.5F;
		}
		 
		 
		this.PawLF.xRot = net.minecraft.util.Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.PawRF.xRot = net.minecraft.util.Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.PawLB.xRot = net.minecraft.util.Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.PawRB.xRot = net.minecraft.util.Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.Head.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Neck.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Body.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Body2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.PawLF.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.PawRF.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.PawLB.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.PawRB.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Tail.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
