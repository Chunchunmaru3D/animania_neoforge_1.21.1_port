package com.animania.addons.farm.client.model.props;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.pullables.EntityWagon;

import com.leviathanstudio.craftstudio.client.model.CraftStudioModelHelper;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

 




























public class ModelWagon<T extends EntityWagon> extends EntityModel<T>
{
	private static final ResourceLocation MODEL_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/model_wagon");
	private static final ResourceLocation ANIM_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/anim_wagon");

	 






	private static final float PHASE_UNITS_PER_DEGREE = 128F / 360F;

	private final ModelPart root;

	public ModelWagon(ModelPart root)
	{
		this.root = root;
		CraftStudioModelHelper.applyStaticStretch(root, MODEL_KEY);
	}

	public static LayerDefinition createBodyLayer()
	{
		return CraftStudioModelHelper.bakeLayer(MODEL_KEY, 256, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		float rawPhase = entity.isWheelAnimationActive() ? entity.getWheelAnimationTime() : 0.0F;
		CraftStudioModelHelper.playAnimation(this.root, MODEL_KEY, ANIM_KEY, rawPhase);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.root.getChild("Ground").render(poseStack, buffer, packedLight, packedOverlay, color);
		this.root.getChild("MaintBackSupport").render(poseStack, buffer, packedLight, packedOverlay, color);
		this.root.getChild("MaintFrontSupport").render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
