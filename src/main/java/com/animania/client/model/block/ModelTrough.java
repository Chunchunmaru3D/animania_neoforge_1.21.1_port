package com.animania.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelTrough
{
	private final ModelPart block1, block2, block3, block4, block5, base1, base2, feed;

	public ModelTrough(ModelPart root)
	{
		this.block1 = root.getChild("block1");
		this.block2 = root.getChild("block2");
		this.block3 = root.getChild("block3");
		this.block4 = root.getChild("block4");
		this.block5 = root.getChild("block5");
		this.base1 = root.getChild("base1");
		this.base2 = root.getChild("base2");
		this.feed = root.getChild("feed");
	}

	public static LayerDefinition createLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		part(root, "block1", 2, 2, -1, -5, -6, 2, 10, 12, -7, 17, 0, 0, 0, 0);
		part(root, "base2", 4, 4, -1, -1, -5, 2, 2, 10, 22, 23, 0, 0, 0, 0);
		part(root, "base1", 4, 4, -1, -1, -5, 2, 2, 10, -6, 23, 0, 0, 0, 0);
		part(root, "block2", 2, 2, -1, -5, -6, 2, 10, 12, 23, 17, 0, 0, 0, 0);
		part(root, "block3", 1, 26, -14, -4, -1, 28, 8, 2, 8, 18, -5, 0, 0, 0);
		part(root, "block4", 1, 26, -14, -4, -1, 28, 8, 2, 8, 18, 5, 0, 0, 0);
		part(root, "block5", 3, 42, -14, -.5F, -4, 28, 1, 8, 8, 21.5F, 0, 0, 0, 0);
		part(root, "feed", 56, 1, -14, -.5F, -4, 28, 1, 8, 8, 16, 0, 0, 0, 0);

		return LayerDefinition.create(mesh, 128, 64);
	}

	 
	public static LayerDefinition createFoodLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		float[][] pivots = {
			{-1, 15, 2.5F}, {8, 15, 1.000001F}, {17, 15, 2.500001F}, {14, 15, -1.999999F},
			{2, 15, -.9999991F}, {9.000001F, 14, -1.999999F}, {1.56835E-7F, 14, -.9999991F}, {17, 14, -.9999986F}
		};
		float[][] rotations = {
			{.5566564F, .6934777F, .418777F}, {.3321232F, 1.126472F, .4568707F}, {.5561382F, .6948478F, .4195006F}, {.329293F, -2.02634F, .4998787F},
			{.329293F, -2.02634F, .3414953F}, {.223693F, -1.865655F, .009323301F}, {.2029555F, -1.465355F, .09517268F}, {.286131F, 2.831252F, .4113167F}
		};
		for (int i = 0; i < 8; i++)
		{
			part(root, "front_" + i, 0, 0, -4.5F, 0, -5, 16, 0, 16,
					pivots[i][0], pivots[i][1], pivots[i][2], rotations[i][0], rotations[i][1], rotations[i][2]);
			part(root, "back_" + i, 0, 0, -4.5F, 0, -5, 16, 0, 16,
					pivots[i][0], pivots[i][1] + 2, pivots[i][2], rotations[i][0], rotations[i][1], rotations[i][2]);
		}
		return LayerDefinition.create(mesh, 16, 16);
	}

	private static PartDefinition part(PartDefinition parent, String name, int u, int v, float x, float y, float z,
			int dx, int dy, int dz, float px, float py, float pz, float rx, float ry, float rz)
	{
		return parent.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, dx, dy, dz),
				PartPose.offsetAndRotation(px, py, pz, rx, ry, rz));
	}

	public void renderBase(PoseStack poseStack, VertexConsumer buffer, int light, int overlay)
	{
		this.block1.render(poseStack, buffer, light, overlay);
		this.block2.render(poseStack, buffer, light, overlay);
		this.block3.render(poseStack, buffer, light, overlay);
		this.block4.render(poseStack, buffer, light, overlay);
		this.block5.render(poseStack, buffer, light, overlay);
		this.base1.render(poseStack, buffer, light, overlay);
		this.base2.render(poseStack, buffer, light, overlay);
	}

	public void renderFeed(PoseStack poseStack, VertexConsumer buffer, int light, int overlay, int count, int color)
	{
		poseStack.pushPose();
		poseStack.translate(0, .17D * (3 - count), 0);
		this.feed.render(poseStack, buffer, light, overlay, color);
		poseStack.popPose();
	}

	public static void renderFood(ModelPart root, PoseStack poseStack, VertexConsumer buffer, int light, int overlay, int count, int color)
	{
		poseStack.pushPose();
		poseStack.translate(0, .2D * (3 - count), 0);
		poseStack.mulPose(Axis.YP.rotationDegrees(-10));
		poseStack.scale(.8F, .8F, .8F);
		poseStack.translate(0, .25D, -.1D);
		for (int i = 0; i < 8; i++) root.getChild("front_" + i).render(poseStack, buffer, light, overlay, color);
		poseStack.mulPose(Axis.YP.rotationDegrees(180));
		poseStack.translate(-1.4D, -.1D, 0);
		for (int i = 0; i < 8; i++) root.getChild("back_" + i).render(poseStack, buffer, light, overlay, color);
		poseStack.popPose();
	}
}
