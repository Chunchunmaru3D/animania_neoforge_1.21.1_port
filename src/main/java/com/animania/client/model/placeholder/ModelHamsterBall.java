package com.animania.client.model.placeholder;

import com.animania.addons.extra.common.entity.rodents.EntityHamster;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public class ModelHamsterBall extends EntityModel<EntityHamster>
{
	private final ModelPart root;

	public ModelHamsterBall(ModelPart root)
	{
		this.root = root;
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		CubeListBuilder cubes = CubeListBuilder.create().texOffs(0, 0)
				.addBox(-5.001F, 21.001F, -5.002F, 10.0F, 1.0F, 10.0F)
				.addBox(-5.002F, 11.998F, -5.003F, 10.0F, 1.0F, 10.0F)
				.addBox(-5.003F, 12.997F, -5.004F, 1.0F, 8.0F, 10.0F)
				.addBox(4.01F, 12.996F, -5.005F, 1.0F, 8.0F, 10.0F)
				.addBox(-4.02F, 12.995F, -6.006F, 8.0F, 8.0F, 2.0F)
				.addBox(-3.01F, 13.998F, 6.007F, 6.0F, 6.0F, 1.0F)
				.addBox(5.01F, 12.994F, -4.003F, 1.0F, 8.0F, 8.0F)
				.addBox(-6.01F, 12.993F, -4.005F, 1.0F, 8.0F, 8.0F)
				.addBox(-4.01F, 11.004F, -4.009F, 8.0F, 1.0F, 8.0F)
				.addBox(-4.01F, 22.009F, -4.010F, 8.0F, 1.0F, 8.0F)
				.addBox(-3.01F, 13.99F, -7.011F, 6.0F, 6.0F, 1.0F)
				.addBox(-7.01F, 13.998F, -3.012F, 1.0F, 6.0F, 6.0F)
				.addBox(-4.01F, 12.989F, 4.013F, 8.0F, 8.0F, 2.0F)
				.addBox(6.01F, 13.988F, -3.014F, 1.0F, 6.0F, 6.0F)
				.addBox(-3.02F, 9.998F, -3.015F, 6.0F, 1.0F, 6.0F)
				.addBox(-3.03F, 23.002F, -3.016F, 6.0F, 1.0F, 6.0F);
		root.addOrReplaceChild("ball", cubes, PartPose.ZERO);
		return LayerDefinition.create(mesh, 64, 32);
	}

	@Override
	public void setupAnim(EntityHamster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
