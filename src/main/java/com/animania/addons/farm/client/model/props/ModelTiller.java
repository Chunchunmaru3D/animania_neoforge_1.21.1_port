package com.animania.addons.farm.client.model.props;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.pullables.EntityTiller;

import com.leviathanstudio.craftstudio.client.model.CraftStudioModelHelper;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

 


























public class ModelTiller<T extends EntityTiller> extends EntityModel<T>
{
	private static final ResourceLocation MODEL_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/model_tiller");
	private static final ResourceLocation ANIM_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/anim_tiller");

	private final ModelPart root;

	public ModelTiller(ModelPart root)
	{
		this.root = root;
		CraftStudioModelHelper.applyStaticStretch(root, MODEL_KEY);
	}

	public static LayerDefinition createBodyLayer()
	{
		return CraftStudioModelHelper.bakeLayer(MODEL_KEY, 128, 64);
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
		this.root.getChild("Wheel1Axle").render(poseStack, buffer, packedLight, packedOverlay, color);
		this.root.getChild("Wheel2Axle").render(poseStack, buffer, packedLight, packedOverlay, color);
		this.root.getChild("TillerBase").render(poseStack, buffer, packedLight, packedOverlay, color);
		this.root.getChild("Fastener").render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
