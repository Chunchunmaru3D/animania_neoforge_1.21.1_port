package com.animania.addons.farm.client.model.chicken;

import com.animania.addons.farm.common.entity.chickens.EntityRoosterBase;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

 



public class ModelRooster<T extends EntityRoosterBase> extends EntityModel<T>
{
	private final ModelPart body1;
	private final ModelPart wing1;
	private final ModelPart wing2;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart feather1;
	private final ModelPart feather2;
	private final ModelPart feather3;
	private final ModelPart leg1Pivot;
	private final ModelPart leg2Pivot;
	private final ModelPart neck;

	public ModelRooster(ModelPart root)
	{
		this.body1 = root.getChild("body1");
		this.wing1 = root.getChild("wing1");
		this.wing2 = root.getChild("wing2");
		this.tail1 = root.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.feather1 = root.getChild("feather1");
		this.feather2 = root.getChild("feather2");
		this.feather3 = root.getChild("feather3");
		this.leg1Pivot = root.getChild("leg1_pivot");
		this.leg2Pivot = root.getChild("leg2_pivot");
		this.neck = root.getChild("neck");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 7)
				.addBox(-3F, -3F, -3F, 6, 6, 6), PartPose.offset(0F, 17.99997F, 2F));

		root.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(30, 6)
				.addBox(-0.5F, -1.5F, 0F, 1, 3, 4), PartPose.offset(-3.5F, 17.3922F, -1.446827F));

		root.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(41, 6)
				.addBox(-0.5F, -1.5F, 0F, 1, 3, 4), PartPose.offset(3.5F, 17.3922F, -1.446827F));

		PartDefinition tail1 = root.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(36, 20)
				.addBox(-2.5F, -2F, -2F, 5, 4, 4), PartPose.offset(0F, 17.62293F, 5.620475F));

		tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(25, 14)
				.addBox(-2F, -1F, -1.5F, 4, 2, 3), PartPose.offset(0F, -1.50911F, 2.23F));

		 
		root.addOrReplaceChild("feather1", CubeListBuilder.create().texOffs(45, 8)
				.addBox(0F, -2.5F, -3F, 0, 5, 6),
				PartPose.offsetAndRotation(-1.5F, 12.69338F, 8.745152F, 0.5097123F, -0.3010362F, -0.1503443F));
		root.addOrReplaceChild("feather2", CubeListBuilder.create().texOffs(45, 8)
				.addBox(0F, -2.5F, -3F, 0, 5, 6),
				PartPose.offsetAndRotation(1.5F, 12.69338F, 8.745152F, 0.5097123F, 0.3010362F, 0.1503443F));
		root.addOrReplaceChild("feather3", CubeListBuilder.create().texOffs(44, 7)
				.addBox(0F, -3F, -3.5F, 0, 6, 7),
				PartPose.offsetAndRotation(0F, 11.3252F, 9.103053F, 0.5295422F, 0F, 0F));

		 
		PartDefinition leg1Pivot = root.addOrReplaceChild("leg1_pivot", CubeListBuilder.create(),
				PartPose.offset(-1.5F, 19.9968F, 1.749448F));
		leg1Pivot.addOrReplaceChild("leg1_top", CubeListBuilder.create().texOffs(39, 0)
				.addBox(-1F, -1F, -1F, 2, 2, 2), PartPose.offsetAndRotation(0F, 1.30317F, 0F, 0.2617994F, 0F, 0F));
		leg1Pivot.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -2F, -0.5F, 1, 2, 1), PartPose.offsetAndRotation(0F, 4.13197F, -0.749448F, -0.2617995F, 0F, 0F));
		leg1Pivot.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 3), PartPose.offset(-1F, 4.0032F, -1.75F));
		leg1Pivot.addOrReplaceChild("foot1b", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 3), PartPose.offset(1F, 4.0032F, -1.75F));

		 
		PartDefinition leg2Pivot = root.addOrReplaceChild("leg2_pivot", CubeListBuilder.create(),
				PartPose.offset(1.5F, 19.9968F, 1.749448F));
		leg2Pivot.addOrReplaceChild("leg2_top", CubeListBuilder.create().texOffs(39, 0)
				.addBox(-1F, -1F, -1F, 2, 2, 2), PartPose.offsetAndRotation(0F, 1.30317F, 0F, 0.2617994F, 0F, 0F));
		leg2Pivot.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -2F, -0.5F, 1, 2, 1), PartPose.offsetAndRotation(0F, 4.13197F, -0.749448F, -0.2617995F, 0F, 0F));
		leg2Pivot.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 3), PartPose.offset(-1F, 4.0032F, -1.75F));
		leg2Pivot.addOrReplaceChild("foot2b", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 3), PartPose.offset(1F, 4.0032F, -1.75F));

		 
		PartDefinition neck = root.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(3, 19)
				.addBox(-2.5F, -2.5F, -2F, 5, 5, 4), PartPose.offset(0F, 16.8998F, -1F));
		neck.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(21, 21)
				.addBox(-2F, -2F, -1.5F, 4, 4, 3), PartPose.offsetAndRotation(0F, -1.88264F, -2.01686F, -0.7360098F, 0F, 0F));
		neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.5F, -2F, -1.5F, 3, 4, 3), PartPose.offsetAndRotation(0F, -4.025F, -3.212082F, 0.05872217F, 0F, 0F));
		neck.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(19, 3)
				.addBox(0F, -1.5F, -2F, 0, 3, 4), PartPose.offsetAndRotation(0F, -6.57F, -4.265868F, 0.3490659F, 0F, 0F));
		neck.addOrReplaceChild("crest_bottom", CubeListBuilder.create().texOffs(22, 6)
				.addBox(0F, -1F, -0.5F, 0, 2, 1), PartPose.offset(0F, -2.955F, -5.078995F));
		neck.addOrReplaceChild("beak_bottom", CubeListBuilder.create().texOffs(19, 0)
				.addBox(-0.5F, -0.5F, -1F, 1, 1, 2), PartPose.offsetAndRotation(0F, -3.97745F, -5.227087F, 0.05872219F, 0F, 0F));
		neck.addOrReplaceChild("beak_top", CubeListBuilder.create().texOffs(19, 0)
				.addBox(-0.5F, -0.5F, -1F, 1, 1, 2), PartPose.offsetAndRotation(0F, -4.26586F, -5.097404F, 0.3169494F, 0F, 0F));

		return LayerDefinition.create(mesh, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.body1.xRot = (float) Math.PI / 2F;
		this.tail1.xRot = 0.2144478F;
		this.tail2.xRot = 0.5295422F;

		 
		long dayTime = entity.level().getDayTime() % 24000;
		int crowDuration = (dayTime > 23250 || dayTime < 500) ? entity.getCrowDuration() : 0;

		if (crowDuration > 0)
		{
			if (crowDuration < 10)
				this.neck.xRot = 0F - (float) (crowDuration * .005);
			else if (crowDuration >= 40)
				this.neck.xRot = -0.5742105F + (float) (crowDuration * .005);
			else
				this.neck.xRot = -0.5742105F;
		}
		else
		{
			this.neck.xRot = Math.abs(netHeadYaw * ((float) Math.PI / 180F));
		}

		this.leg1Pivot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2Pivot.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.wing1.zRot = ageInTicks;
		this.wing2.zRot = -ageInTicks;
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.body1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wing1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.wing2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.tail1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.feather1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.feather2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.feather3.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg1Pivot.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg2Pivot.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.neck.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
