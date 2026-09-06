package com.animania.addons.catsdogs.client.render.blockentity;

import com.animania.Animania;
import com.animania.addons.catsdogs.common.block.BlockProp;
import com.animania.addons.catsdogs.common.blockentity.BlockEntityProp;
import com.animania.addons.catsdogs.common.blockentity.BlockEntityProp.PropType;

import com.leviathanstudio.craftstudio.client.model.CraftStudioModelHelper;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

 
















public class BlockEntityPropRenderer implements BlockEntityRenderer<BlockEntityProp>
{
	public BlockEntityPropRenderer(BlockEntityRendererProvider.Context context)
	{
	}

	@Override
	public void render(BlockEntityProp prop, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay)
	{
		PropType type = prop.getPropType();
		if (type == null)
			return;

		String blockName = type.name().toLowerCase(java.util.Locale.ROOT);
		ResourceLocation modelKey = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/model_" + blockName);
		ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/tileentities/" + blockName + ".png");

		BlockState state = prop.getBlockState();
		Direction facing = state.hasProperty(BlockProp.FACING) ? state.getValue(BlockProp.FACING) : Direction.NORTH;

		poseStack.pushPose();
		poseStack.translate(0.5D, 1.5D, 0.5D);
		poseStack.mulPose(Axis.XP.rotationDegrees(180F));
		poseStack.mulPose(Axis.YP.rotationDegrees(facing.toYRot()));

		 
		 
		 
		net.minecraft.client.model.geom.builders.LayerDefinition layer =
				CraftStudioModelHelper.bakeLayer(modelKey, type.textureWidth, type.textureHeight);
		net.minecraft.client.model.geom.ModelPart root = layer.bakeRoot();

		CraftStudioModelHelper.renderAllRoots(root, modelKey, type.textureWidth, type.textureHeight,
				poseStack, buffer.getBuffer(RenderType.entityCutout(texture)), packedLight, packedOverlay);

		poseStack.popPose();
	}
}
