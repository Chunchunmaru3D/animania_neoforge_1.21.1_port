package com.animania.addons.extra.client.model.rabbits;

import com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 
public class ModelRabbitRex<T extends EntityAnimaniaRabbit> extends EntityModel<T>
{
	private final ModelPart root;
	private final ModelPart tail, backLegR1, backLegR2, backLegL1, backLegL2, legL1, legR1, neck;

	public ModelRabbitRex(ModelPart root)
	{
		this.root = root;
		this.tail = root.getChild("tail");
		this.backLegR1 = root.getChild("back_leg_r1");
		this.backLegR2 = root.getChild("back_leg_r2");
		this.backLegL1 = root.getChild("back_leg_l1");
		this.backLegL2 = root.getChild("back_leg_l2");
		this.legL1 = root.getChild("leg_l1");
		this.legR1 = root.getChild("leg_r1");
		this.neck = root.getChild("neck");
	}

	public static LayerDefinition createBodyLayer()
	{
		return createBodyLayer(4, 1, -5F, 6);
	}

	 
	protected static LayerDefinition createBodyLayer(int earU, int earV, float earZ, int earDepth)
	{
		return createBodyLayer(earU, earV, earZ, earDepth, 14.870147F);
	}

	 
	protected static LayerDefinition createBodyLayer(int earU, int earV, float earZ, int earDepth, float tailPivotZ)
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		part(root, "lower_body", 24, 25, -3.5F, -2.9F, -3.2F, 7, 7, 13, 0, 16.1F, 5.5F, -.3186971F, 0, 0);
		part(root, "tail", 50, 18, -1.5F, -2, -1.7F, 3, 3, 4, 0, 19.29693F, tailPivotZ, -1.548105F, -Mth.PI, -Mth.PI);
		part(root, "back_leg_r1", 20, 52, -1, 0, -2.5F, 2, 6, 5, 3.8F, 16.39402F, 12.77417F, .3186971F, -Mth.PI, 0);
		part(root, "back_leg_r2", 0, 43, -1.02F, -1.4F, -.7F, 2, 8, 2, 3.8F, 22.27699F, 12.412659F, -1.365852F, .02615925F, -.0163918F);
		part(root, "back_leg_l1", 20, 52, -1, 0, -2.5F, 2, 6, 5, -3.8F, 16.39402F, 12.77417F, -.3186971F, 0, 0);
		part(root, "back_leg_l2", 0, 43, -.98F, -1.4F, -.7F, 2, 8, 2, -3.8F, 22.27699F, 12.412659F, -1.357649F, -.02552362F, .01577001F);
		part(root, "leg_l1", 0, 54, -1, 0, -1.5F, 2, 7, 2, 2.7F, 17.46663F, 3.258945F, -.004537883F, 0, 0);
		part(root, "leg_r1", 0, 54, -1, 0, -1.5F, 2, 7, 2, -2.7F, 17.46663F, 3.258945F, -.004537883F, 0, 0);
		PartDefinition neck = part(root, "neck", 0, 27, -2, -2.2F, -4.8F, 4, 5, 6, 0, 15.88453F, 3.570344F, -.7740535F, 0, 0);
		part(neck, "head_base", 0, 16, -2.5F, -2.51F, -3.5F, 5, 4, 5, 0, -3.57794F, -2.515626F, .3642503F, 0, 0);
		part(neck, "head_front", 0, 9, -1.5F, -1.2F, -2.6F, 3, 3, 3, 0, -3.1767F, -5.252231F, .4098033F, 0, 0);
		part(neck, "whisker_r1", 0, 2, -.5F, -.5F, -2, 1, 1, 2, -.5F, -2.33F, -8.478354F, -.1162607F, 1.495321F, 0);
		part(neck, "whisker_r2", 0, 2, -1, -.5F, -1.9F, 1, 1, 2, -.4F, -1.59046F, -8.697894F, .09258097F, 1.58639F, 0);
		part(neck, "whisker_l1", 0, 2, -.5F, -.5F, -2, 1, 1, 2, .5F, -2.34F, -7.478354F, -.1162607F, -1.495321F, 0);
		part(neck, "whisker_l2", 0, 2, 0, -.5F, -1.9F, 1, 1, 2, .4F, -1.59046F, -7.697894F, .09258097F, -1.58639F, 0);
		part(neck, "nose", 0, 0, -.5F, -.9F, -.6F, 1, 1, 1, 0, -2.02499F, -7.150544F, .2731441F, 0, 0);
		part(neck, "ear_r", earU, earV, -1.5F, -1.1F, earZ, 3, 1, earDepth, -2.5F, -5.1664F, -3.121248F, -2.424416F, .9441F, -1.032535F);
		part(neck, "ear_l", earU, earV, -1.5F, -1.1F, earZ, 3, 1, earDepth, 2.5F, -5.1664F, -3.121248F, -2.424416F, -.9441F, 1.032535F);
		return LayerDefinition.create(mesh, 128, 128);
	}

	private static PartDefinition part(PartDefinition parent, String name, int u, int v, float x, float y, float z,
			int dx, int dy, int dz, float px, float py, float pz, float rx, float ry, float rz)
	{
		return parent.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, dx, dy, dz),
				PartPose.offsetAndRotation(px, py, pz, rx, ry, rz));
	}

	@Override
	public void setupAnim(T rabbit, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.root.getAllParts().forEach(ModelPart::resetPose);
		this.tail.xRot = Mth.HALF_PI;
		this.neck.xRot = 0;
		this.neck.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		float walk = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		this.backLegL1.xRot = -.3186971F + walk;
		this.backLegL2.xRot = -1.357649F + walk;
		this.backLegR1.xRot = .3186971F + walk;
		this.backLegR2.xRot = -1.365852F + walk;
		this.legL1.xRot = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		this.legR1.xRot = this.legL1.xRot;
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer,
			int packedLight, int packedOverlay, int color)
	{
		this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
