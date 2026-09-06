package com.animania.addons.catsdogs.client.render.blockentity;

import com.animania.Animania;
import com.animania.addons.catsdogs.client.model.PetBowlFoodModel;
import com.animania.addons.catsdogs.common.blockentity.BlockEntityPetBowl;
import com.leviathanstudio.craftstudio.client.model.CraftStudioModelHelper;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

 
public class BlockEntityPetBowlRenderer implements BlockEntityRenderer<BlockEntityPetBowl>
{
	private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "blocks/model_pet_bowl");
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID, "textures/entity/tileentities/pet_bowl.png");

	public BlockEntityPetBowlRenderer(BlockEntityRendererProvider.Context context)
	{
	}

	@Override
	public void render(BlockEntityPetBowl bowl, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay)
	{
		poseStack.pushPose();
		poseStack.translate(0.5D, 1.5D, 0.5D);
		poseStack.mulPose(Axis.XP.rotationDegrees(180F));
		LayerDefinition layer = CraftStudioModelHelper.bakeLayer(MODEL, 64, 32);
		ModelPart root = layer.bakeRoot();
		CraftStudioModelHelper.renderAllRoots(root, MODEL, 64, 32, poseStack,
				buffer.getBuffer(RenderType.entityCutout(TEXTURE)), packedLight, packedOverlay);

		if (!bowl.getItemHandler().getStackInSlot(0).isEmpty())
		{
			ModelPart food = PetBowlFoodModel.bake();
			int color = Minecraft.getInstance().getItemColors().getColor(bowl.getItemHandler().getStackInSlot(0), 0);
			if (color == -1)
				color = 0xFFFFFFFF;
			poseStack.pushPose();
			poseStack.scale(1.2F, 1.2F, 1.2F);
			float offset = -0.12F - (bowl.getItemHandler().getStackInSlot(0).getCount() - 1) * 0.04F;
			poseStack.translate(0.0F, offset, 0.0F);
			PetBowlFoodModel.render(food, poseStack, buffer.getBuffer(RenderType.entityCutout(TEXTURE)), packedLight, packedOverlay, color);
			poseStack.popPose();
		}
		poseStack.popPose();
	}
}
