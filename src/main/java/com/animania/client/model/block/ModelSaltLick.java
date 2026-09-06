package com.animania.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;

 
public final class ModelSaltLick
{
	private final ModelPart block;

	public ModelSaltLick(ModelPart root)
	{
		this.block = root.getChild("block");
	}

	public static LayerDefinition createLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		mesh.getRoot().addOrReplaceChild("block", CubeListBuilder.create().texOffs(6, 6)
				.addBox(-5, -5, -5, 10, 10, 10), PartPose.offset(0, 19, 0));
		return LayerDefinition.create(mesh, 64, 32);
	}

	public void render(PoseStack poseStack, VertexConsumer buffer, int light, int overlay)
	{
		this.block.render(poseStack, buffer, light, overlay);
	}
}
