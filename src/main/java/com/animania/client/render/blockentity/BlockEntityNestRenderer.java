package com.animania.client.render.blockentity;

import com.animania.Animania;
import com.animania.addons.extra.ExtraItems;
import com.animania.addons.farm.FarmItems;
import com.animania.client.model.block.ModelNest;
import com.animania.client.model.block.ModelNest.EggType;
import com.animania.common.blockentity.BlockEntityNest;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

 
public final class BlockEntityNestRenderer implements BlockEntityRenderer<BlockEntityNest>
{
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Animania.MODID, "block_nest"), "main");
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Animania.MODID,
			"textures/entity/tileentities/block_nest_white.png");

	private final ModelNest model;

	public BlockEntityNestRenderer(BlockEntityRendererProvider.Context context)
	{
		this.model = new ModelNest(context.bakeLayer(MODEL_LAYER));
	}

	@Override
	public void render(BlockEntityNest nest, float partialTick, PoseStack poseStack, MultiBufferSource buffers, int light, int overlay)
	{
		poseStack.pushPose();
		 
		poseStack.translate(.5D, 1.5D, .5D);
		poseStack.scale(-1, -1, 1);
		var buffer = buffers.getBuffer(RenderType.entityCutout(TEXTURE));
		this.model.renderBase(poseStack, buffer, light, overlay);

		ItemStack eggs = nest.getItemHandler().getStackInSlot(0);
		EggType type = eggType(eggs);
		if (type != null)
			this.model.renderEggs(type, eggs.getCount(), poseStack, buffer, light, overlay);
		poseStack.popPose();
	}

	private static EggType eggType(ItemStack stack)
	{
		if (stack.is(Items.EGG)) return EggType.CHICKEN_WHITE;
		if (stack.is(FarmItems.BROWN_EGG.get())) return EggType.CHICKEN_BROWN;
		if (stack.is(ExtraItems.PEACOCK_EGG_BLUE.get())) return EggType.PEACOCK_BLUE;
		if (stack.is(ExtraItems.PEACOCK_EGG_WHITE.get())) return EggType.PEACOCK_WHITE;
		return null;
	}
}
