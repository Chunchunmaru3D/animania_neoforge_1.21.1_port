package com.animania.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class ModelNest
{
	public enum EggType { CHICKEN_WHITE, CHICKEN_BROWN, PEACOCK_BLUE, PEACOCK_WHITE }

	private static final String[] BODY = { "nest1", "fluff3", "fluff1", "nest2", "nest3", "nest4", "nest5", "nest6", "nest7", "nest8", "block", "fluff2", "fluff4", "fluff5" };
	private final ModelPart root;
	private final ModelPart[][][] eggs = new ModelPart[EggType.values().length][3][4];

	public ModelNest(ModelPart root)
	{
		this.root = root;
		for (EggType type : EggType.values())
			for (int egg = 0; egg < 3; egg++)
				for (int part = 0; part < 4; part++)
					this.eggs[type.ordinal()][egg][part] = root.getChild("egg_" + type.ordinal() + '_' + egg + '_' + part);
	}

	public static LayerDefinition createLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		 
		part(root, "nest1", 0, 0, -3, -2, -8, 6, 4, 3, 0, 22, 0, 0, 0, 0);
		part(root, "fluff3", -16, 38, -8, 0, -8, 16, 0, 16, 0, 21.5F, 0, 0, 1.133858F, 0);
		part(root, "fluff1", -16, 38, -8, 0, -8, 16, 0, 16, 0, 22.5F, 0, 0, 0, 0);
		part(root, "nest2", 0, 7, -3, -2, 5, 6, 4, 3, 0, 22, 0, 0, 0, 0);
		part(root, "nest3", 0, 14, -3, -2, 5, 6, 4, 3, 0, 22, 0, 0, 1.570796F, 0);
		part(root, "nest4", 19, 0, -3, -2, 5, 6, 4, 3, 0, 22, 0, 0, -1.570796F, 0);
		part(root, "nest5", 18, 7, -3.5F, -2, 5, 7, 4, 3, 0, 21.9F, 0, 0, -.7853982F, 0);
		part(root, "nest6", 18, 14, -3.5F, -2, 5, 7, 4, 3, 0, 21.9F, 0, 0, .7853982F, 0);
		part(root, "nest7", 18, 20, -3.5F, -2, 5, 7, 4, 3, 0, 21.9F, 0, 0, 2.356194F, 0);
		part(root, "nest8", 41, 0, -3.5F, -2, 5, 7, 4, 3, 0, 21.9F, 0, 0, -2.356194F, 0);
		part(root, "block", 13, 8, -5.5F, -1.5F, -5.5F, 11, 3, 11, 0, 22.5F, 0, 0, 0, 0);
		part(root, "fluff2", -16, 38, -8, 0, -8, 16, 0, 16, 0, 23.8F, 0, 0, .5906957F, 0);
		part(root, "fluff4", 18, 38, -8, 0, -8, 16, 0, 16, 0, 19.7F, 0, 0, 0, 0);
		part(root, "fluff5", 18, 38, -8, 0, -8, 16, 0, 16, 0, 19.65F, 0, 0, .3574434F, 0);

		for (EggType type : EggType.values())
			addEggs(root, type.ordinal(), type.ordinal() == 0 ? 0 : type.ordinal() == 1 ? 20 : type.ordinal() == 2 ? 30 : 40);
		return LayerDefinition.create(mesh, 128, 64);
	}

	private static void addEggs(PartDefinition root, int type, int vOffset)
	{
		int[][][] uvs = {
			{{68, 2}, {71, 4}, {72, 3}, {71, 6}}, {{73, 4}, {73, 3}, {75, 6}, {78, 2}}, {{76, 3}, {77, 6}, {78, 4}, {75, 2}}
		};
		float[][][] pivots = {
			{{-2.5F, 20.5F, 1F}, {-2.768189F, 18.83211F, 1.45686F}, {-2.845569F, 18.35441F, 1.582717F}, {-2.270879F, 21.92846F, .6037322F}},
			{{0F, 20.5F, -2.25F}, {-1.557231F, 19.99435F, -2.867943F}, {-2.000357F, 19.84989F, -3.049029F}, {1.336568F, 20.93341F, -1.724865F}},
			{{2F, 20.5F, 2F}, {3.119674F, 19.40652F, 2.783019F}, {3.438589F, 19.09068F, 3.003399F}, {1.039286F, 21.43386F, 1.3255F}}
		};
		float[][] rotations = {
			{-.2400439F, .1601751F, -.1941436F}, {-1.666733E-08F, -.3777635F, -1.277677F}, {-.7743126F, .2888342F, .5073518F}
		};
		float[][] box = {{-1.5F, -1.5F, -1.5F, 3, 3, 3}, {-1F, -.5F, -1F, 2, 1, 2}, {-.5F, -.5F, -.5F, 1, 1, 1}, {-1F, -.5F, -1F, 2, 1, 2}};
		for (int egg = 0; egg < 3; egg++)
			for (int fragment = 0; fragment < 4; fragment++)
				part(root, "egg_" + type + '_' + egg + '_' + fragment, uvs[egg][fragment][0], uvs[egg][fragment][1] + vOffset,
						box[fragment][0], box[fragment][1], box[fragment][2], (int) box[fragment][3], (int) box[fragment][4], (int) box[fragment][5],
						pivots[egg][fragment][0], pivots[egg][fragment][1], pivots[egg][fragment][2], rotations[egg][0], rotations[egg][1], rotations[egg][2]);
	}

	private static void part(PartDefinition parent, String name, int u, int v, float x, float y, float z, int dx, int dy, int dz,
			float px, float py, float pz, float rx, float ry, float rz)
	{
		parent.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, dx, dy, dz), PartPose.offsetAndRotation(px, py, pz, rx, ry, rz));
	}

	public void renderBase(PoseStack poseStack, VertexConsumer buffer, int light, int overlay)
	{
		for (String name : BODY)
			this.root.getChild(name).render(poseStack, buffer, light, overlay);
	}

	public void renderEggs(EggType type, int count, PoseStack poseStack, VertexConsumer buffer, int light, int overlay)
	{
		for (int egg = 0; egg < Math.min(count, 3); egg++)
			for (ModelPart fragment : this.eggs[type.ordinal()][egg])
				fragment.render(poseStack, buffer, light, overlay);
	}
}
