package com.animania.addons.farm.client.render.blockentity;

import com.animania.Animania;
import com.animania.addons.farm.FarmBlocks;
import com.animania.addons.farm.common.block.BlockHive;
import com.animania.addons.farm.common.blockentity.BlockEntityHive;

import com.leviathanstudio.craftstudio.client.animation.CSAnimationApplier;
import com.leviathanstudio.craftstudio.client.json.CSReadedAnim;
import com.leviathanstudio.craftstudio.client.json.CSReadedModel;
import com.leviathanstudio.craftstudio.client.model.CraftStudioModelHelper;
import com.leviathanstudio.craftstudio.client.registry.CSModelRegistry;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

 





























public class BlockEntityHiveRenderer implements BlockEntityRenderer<BlockEntityHive>
{
	private static final ResourceLocation HIVE_MODEL_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/model_bee_hive");
	private static final ResourceLocation HIVE_ANIM_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/anim_bees");
	private static final ResourceLocation WILD_HIVE_MODEL_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/model_wild_hive");
	private static final ResourceLocation WILD_HIVE_ANIM_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/anim_bees_wild");

	private static final ResourceLocation HIVE_TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/bee_hive.png");
	private static final ResourceLocation WILD_HIVE_TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/props/wild_hive.png");

	public BlockEntityHiveRenderer(BlockEntityRendererProvider.Context context)
	{
	}

	@Override
	public void render(BlockEntityHive hive, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay)
	{
		boolean wild = hive.getBlockState().getBlock() == FarmBlocks.WILD_HIVE.get();
		BlockState state = hive.getBlockState();
		Direction facing = state.hasProperty(BlockHive.FACING) ? state.getValue(BlockHive.FACING) : Direction.NORTH;

		ResourceLocation modelKey = wild ? WILD_HIVE_MODEL_KEY : HIVE_MODEL_KEY;
		ResourceLocation animKey = wild ? WILD_HIVE_ANIM_KEY : HIVE_ANIM_KEY;
		ResourceLocation texture = wild ? WILD_HIVE_TEXTURE : HIVE_TEXTURE;

		poseStack.pushPose();

		if (wild)
		{
			 
			 
			switch (facing)
			{
				case SOUTH -> poseStack.translate(0.5D, 1.0D, 0.25D);
				case EAST -> poseStack.translate(0.25D, 1.0D, 0.5D);
				case WEST -> poseStack.translate(0.75D, 1.0D, 0.5D);
				case NORTH -> poseStack.translate(0.5D, 1.0D, 0.75D);
				default -> poseStack.translate(0.25D, 1.0D, 0.5D);
			}
		}
		else
		{
			 
			poseStack.translate(0.5D, 1.5D, 0.5D);
		}

		poseStack.mulPose(Axis.XP.rotationDegrees(180F));
		poseStack.mulPose(Axis.YP.rotationDegrees(facing.toYRot()));

		LayerDefinition layer = bakeLayerCached(modelKey);
		ModelPart root = layer.bakeRoot();

		CSReadedModel model = CSModelRegistry.INSTANCE.getModel(modelKey);
		CSReadedAnim anim = CSModelRegistry.INSTANCE.getAnim(animKey);
		 
		 
		long phaseOffset = hive.getBlockPos().asLong() & 0x3F;
		float rawPhase = (hive.getLevel().getGameTime() + phaseOffset) % anim.getDuration();
		CSAnimationApplier.apply(root, anim, model, rawPhase);

		root.render(poseStack, buffer.getBuffer(RenderType.entityCutout(texture)), packedLight, packedOverlay);

		poseStack.popPose();
	}

	private static LayerDefinition bakeLayerCached(ResourceLocation modelKey)
	{
		return CraftStudioModelHelper.bakeLayer(modelKey, 128, 64);
	}
}
