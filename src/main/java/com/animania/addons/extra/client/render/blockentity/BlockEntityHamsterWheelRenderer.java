package com.animania.addons.extra.client.render.blockentity;

import com.animania.Animania;
import com.animania.addons.extra.common.block.BlockHamsterWheel;
import com.animania.addons.extra.common.blockentity.BlockEntityHamsterWheel;

import com.leviathanstudio.craftstudio.client.animation.CSAnimationApplier;
import com.leviathanstudio.craftstudio.client.json.CSReadedAnim;
import com.leviathanstudio.craftstudio.client.json.CSReadedModel;
import com.leviathanstudio.craftstudio.client.model.CraftStudioModelHelper;
import com.leviathanstudio.craftstudio.client.registry.CSModelRegistry;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

 
























public class BlockEntityHamsterWheelRenderer implements BlockEntityRenderer<BlockEntityHamsterWheel>
{
	private static final ResourceLocation WHEEL_MODEL_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/model_hamster_wheel");
	private static final ResourceLocation WHEEL_ANIM_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/anim_hamster_wheel");
	private static final ResourceLocation HAMSTER_MODEL_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/hamster");
	private static final ResourceLocation HAMSTER_ANIM_KEY = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "entity/hamster_run");

	private static final ResourceLocation WHEEL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/tileentities/hamster_wheel.png");
	 
	private static final ResourceLocation HAMSTER_TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/rodents/hamster_tarou.png");

	public BlockEntityHamsterWheelRenderer(BlockEntityRendererProvider.Context context)
	{
	}

	@Override
	public void render(BlockEntityHamsterWheel wheel, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay)
	{
		BlockState state = wheel.getBlockState();
		Direction facing = state.hasProperty(BlockHamsterWheel.FACING) ? state.getValue(BlockHamsterWheel.FACING) : Direction.NORTH;

		poseStack.pushPose();
		poseStack.translate(0.5D, 1.5D, 0.5D);
		poseStack.mulPose(Axis.XP.rotationDegrees(180F));
		poseStack.mulPose(Axis.YP.rotationDegrees(facing.toYRot()));

		boolean running = wheel.isRunning();
		float rawPhase = running ? (wheel.getLevel().getGameTime() % 1000) : 0F;

		CSReadedModel wheelModel = CSModelRegistry.INSTANCE.getModel(WHEEL_MODEL_KEY);
		ModelPart wheelRoot = CraftStudioModelHelper.bakeLayer(WHEEL_MODEL_KEY, 64, 32).bakeRoot();
		if (running)
		{
			CSReadedAnim wheelAnim = CSModelRegistry.INSTANCE.getAnim(WHEEL_ANIM_KEY);
			CSAnimationApplier.apply(wheelRoot, wheelAnim, wheelModel, CSAnimationApplier.computePhase(wheelAnim, rawPhase));
		}
		wheelRoot.render(poseStack, buffer.getBuffer(RenderType.entityCutout(WHEEL_TEXTURE)), packedLight, packedOverlay);

		if (running)
		{
			poseStack.pushPose();
			poseStack.scale(0.5F, 0.5F, 0.5F);
			poseStack.translate(0D, 0.9D, 0D);
			poseStack.mulPose(Axis.YP.rotationDegrees(-90F));

			CSReadedModel hamsterModel = CSModelRegistry.INSTANCE.getModel(HAMSTER_MODEL_KEY);
			CSReadedAnim hamsterAnim = CSModelRegistry.INSTANCE.getAnim(HAMSTER_ANIM_KEY);
			ModelPart hamsterRoot = CraftStudioModelHelper.bakeLayer(HAMSTER_MODEL_KEY, 64, 32).bakeRoot();
			CSAnimationApplier.apply(hamsterRoot, hamsterAnim, hamsterModel, CSAnimationApplier.computePhase(hamsterAnim, rawPhase));
			hamsterRoot.render(poseStack, buffer.getBuffer(RenderType.entityCutout(HAMSTER_TEXTURE)), packedLight, packedOverlay);

			poseStack.popPose();
		}

		poseStack.popPose();
	}
}
