package com.animania.addons.farm.client.model.props;

import com.animania.Animania;
import com.animania.addons.farm.common.entity.pullables.EntityCart;

import com.leviathanstudio.craftstudio.client.model.CraftStudioModelHelper;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

 















public class ModelCart<T extends EntityCart> extends EntityModel<T>
{
	private static final ResourceLocation MODEL_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/model_cart");
	private static final ResourceLocation ANIM_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/anim_cart");

	 








	private static final float PHASE_UNITS_PER_DEGREE = 128F / 360F;

	private final ModelPart root;

	public ModelCart(ModelPart root)
	{
		this.root = root;
		CraftStudioModelHelper.applyStaticStretch(root, MODEL_KEY);
	}

	public static LayerDefinition createBodyLayer()
	{
		return CraftStudioModelHelper.bakeLayer(MODEL_KEY, 128, 128);
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
		this.root.getChild("RootNode").render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
