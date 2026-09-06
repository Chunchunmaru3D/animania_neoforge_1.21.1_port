package com.animania.client.model.placeholder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;

 








public class ModelPeachick<T extends Mob> extends EntityModel<T>
{
	private final ModelPart Neck;
	private final ModelPart Neck2;
	private final ModelPart Neck3;
	private final ModelPart Head;
	private final ModelPart BeakBottom;
	private final ModelPart BeakTop;
	private final ModelPart Body1;
	private final ModelPart leg1Top;
	private final ModelPart leg1top2;
	private final ModelPart leg1bottom;
	private final ModelPart Foot1;
	private final ModelPart Foot1b;
	private final ModelPart leg2Top;
	private final ModelPart leg2top2;
	private final ModelPart leg2bottom;
	private final ModelPart Foot2;
	private final ModelPart Foot2b;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Wing1;
	private final ModelPart Wing1a;
	private final ModelPart Wing1b;
	private final ModelPart Wing2;
	private final ModelPart Wing2a;
	private final ModelPart Wing2b;

	public ModelPeachick(ModelPart root)
	{
		this.Neck = root.getChild("Neck");
		this.Body1 = root.getChild("Body1");
		this.leg1Top = root.getChild("leg1Top");
		this.leg2Top = root.getChild("leg2Top");
		this.Wing1 = root.getChild("Wing1");
		this.Wing2 = root.getChild("Wing2");
		this.Tail1 = root.getChild("Tail1");
		this.Neck2 = this.Neck.getChild("Neck2");
		this.Neck3 = this.Neck.getChild("Neck3");
		this.Head = this.Neck.getChild("Head");
		this.BeakBottom = this.Neck.getChild("BeakBottom");
		this.BeakTop = this.Neck.getChild("BeakTop");
		this.leg1top2 = this.leg1Top.getChild("leg1top2");
		this.leg1bottom = this.leg1Top.getChild("leg1bottom");
		this.Foot1 = this.leg1Top.getChild("Foot1");
		this.Foot1b = this.leg1Top.getChild("Foot1b");
		this.leg2top2 = this.leg2Top.getChild("leg2top2");
		this.leg2bottom = this.leg2Top.getChild("leg2bottom");
		this.Foot2 = this.leg2Top.getChild("Foot2");
		this.Foot2b = this.leg2Top.getChild("Foot2b");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Wing1a = this.Wing1.getChild("Wing1a");
		this.Wing1b = this.Wing1.getChild("Wing1b");
		this.Wing2a = this.Wing2.getChild("Wing2a");
		this.Wing2b = this.Wing2.getChild("Wing2b");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition NeckDef = root.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(3, 19)
				.addBox(-2.5F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 13.3998F, -1.0F, -0.539251F, 0.0F, 0.0F));

		PartDefinition Neck2Def = NeckDef.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(21, 21)
				.addBox(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F),
				PartPose.offsetAndRotation(0.0F, -1.4982600000000001F, -2.01686F, -0.9490896F, 0.0F, 0.0F));

		PartDefinition Neck3Def = NeckDef.addOrReplaceChild("Neck3", CubeListBuilder.create().texOffs(5, 30)
				.addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, -1.2070500000000006F, -2.423303F, -1.376694F, 0.0F, 0.0F));

		PartDefinition HeadDef = NeckDef.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.51F, -2.5F, -2.0F, 3.0F, 3.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, -6.099652000000001F, -3.456411F, 0.07594994F, 0.0F, 0.0F));

		PartDefinition BeakTopDef = NeckDef.addOrReplaceChild("BeakTop", CubeListBuilder.create().texOffs(19, 0)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, -7.039004000000001F, -6.418793F, 0.3341772F, 0.0F, 0.0F));

		PartDefinition BeakBottomDef = NeckDef.addOrReplaceChild("BeakBottom", CubeListBuilder.create().texOffs(19, 0)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, -6.737326000000001F, -6.51361F, 0.07594992F, 0.0F, 0.0F));

		PartDefinition Body1Def = root.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 7)
				.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, 14.5F, 2.0F, -0.1745329F, 0.0F, 0.0F));

		PartDefinition leg1TopDef = root.addOrReplaceChild("leg1Top", CubeListBuilder.create().texOffs(39, 0)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(-1.5F, 17.79997F, 1.75F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg1top2Def = leg1TopDef.addOrReplaceChild("leg1top2", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 2.9526400000000024F, 0.8522509999999999F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg1bottomDef = leg1TopDef.addOrReplaceChild("leg1bottom", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 5.700030000000002F, 0.5F, -0.1745331F, 0.0F, 0.0F));

		PartDefinition Foot1Def = leg1TopDef.addOrReplaceChild("Foot1", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(-0.75F, 6.153760000000002F, -0.5548139999999999F, -1.588343e-07F, 0.0F, 0.0F));

		PartDefinition Foot1bDef = leg1TopDef.addOrReplaceChild("Foot1b", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(0.75F, 6.153760000000002F, -0.5548139999999999F, -1.692242e-07F, 0.0F, 0.0F));

		PartDefinition leg2TopDef = root.addOrReplaceChild("leg2Top", CubeListBuilder.create().texOffs(39, 0)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(1.5F, 17.79997F, 1.75F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg2top2Def = leg2TopDef.addOrReplaceChild("leg2top2", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 3.4332700000000003F, 0.9900699999999998F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg2bottomDef = leg2TopDef.addOrReplaceChild("leg2bottom", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 5.700030000000002F, 0.5F, -0.1745331F, 0.0F, 0.0F));

		PartDefinition Foot2Def = leg2TopDef.addOrReplaceChild("Foot2", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(-0.75F, 6.194890000000001F, -0.551912F, -1.588343e-07F, 0.0F, 0.0F));

		PartDefinition Foot2bDef = leg2TopDef.addOrReplaceChild("Foot2b", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(0.75F, 6.194890000000001F, -0.551912F, -1.692242e-07F, 0.0F, 0.0F));

		PartDefinition Wing1Def = root.addOrReplaceChild("Wing1", CubeListBuilder.create().texOffs(1, 41)
				.addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(-3.5F, 12.860299999999999F, 0.1172086F, -0.2947292F, 0.0F, 0.0F));

		PartDefinition Wing1aDef = Wing1Def.addOrReplaceChild("Wing1a", CubeListBuilder.create().texOffs(4, 41)
				.addBox(-0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, 0.0071600000000013875F, 4.3059634F, 0F, 0F, 0F));

		PartDefinition Wing1bDef = Wing1Def.addOrReplaceChild("Wing1b", CubeListBuilder.create().texOffs(2, 41)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, 1.91376F, -0.5809618F, 0F, 0F, 0F));

		PartDefinition Wing2Def = root.addOrReplaceChild("Wing2", CubeListBuilder.create().texOffs(1, 41)
				.addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(3.5F, 12.860299999999999F, 0.1172086F, -0.2947292F, 0.0F, 0.0F));

		PartDefinition Wing2aDef = Wing2Def.addOrReplaceChild("Wing2a", CubeListBuilder.create().texOffs(4, 41)
				.addBox(-0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, 0.0071600000000013875F, 4.3059634F, 0F, 0F, 0F));

		PartDefinition Wing2bDef = Wing2Def.addOrReplaceChild("Wing2b", CubeListBuilder.create().texOffs(2, 41)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, 1.91376F, -0.5809618F, 0F, 0F, 0F));

		PartDefinition Tail1Def = root.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(36, 20)
				.addBox(-2.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 15.10777F, 5.446827F, -0.4363323F, 0.0F, 0.0F));

		PartDefinition Tail2Def = Tail1Def.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(25, 14)
				.addBox(-2.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F),
				PartPose.offsetAndRotation(0.0F, 0.15024000000000015F, 2.6883880000000007F, -0.121238F, 0.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.Neck.xRot = Math.abs(netHeadYaw / (180F / (float) Math.PI));
		this.Body1.xRot = (float) Math.PI / 2F;
		this.leg1Top.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2Top.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.Wing1.zRot = ageInTicks;
		this.Wing2.zRot = -ageInTicks;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		 
		 
		this.Neck.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Body1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg1Top.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg2Top.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Wing1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Wing2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Tail1.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
