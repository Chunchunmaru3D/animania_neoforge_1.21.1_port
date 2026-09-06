package com.animania.addons.extra.common.pocket;

import com.animania.Animania;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

 







@EventBusSubscriber(modid = Animania.MODID)
public final class PocketCarryHandler
{
	 




	public static boolean tryCapture(TamableAnimal pet, Player player)
	{
		if (!player.isShiftKeyDown() || !player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty())
			return false;
		if (!pet.isTame() || !pet.isOwnedBy(player))
			return false;

		CompoundTag pocket = player.getData(PocketAttachments.POCKET_ANIMAL.get());
		if (!pocket.isEmpty())
			return false;

		if (pet.level().isClientSide)
			return true;

		CompoundTag animalTag = new CompoundTag();
		pet.saveWithoutId(animalTag);
		player.setData(PocketAttachments.POCKET_ANIMAL.get(), animalTag);

		pet.discard();
		player.swing(InteractionHand.MAIN_HAND);
		player.playSound(SoundEvents.ITEM_PICKUP, 1.0F, (player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.2F + 1.0F);
		return true;
	}

	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
	{
		Player player = event.getEntity();
		if (!player.isShiftKeyDown())
			return;

		CompoundTag pocket = player.getData(PocketAttachments.POCKET_ANIMAL.get());
		if (pocket.isEmpty())
			return;

		event.setCanceled(true);

		if (player.level().isClientSide)
			return;

		if (!(player.level() instanceof ServerLevel serverLevel))
			return;

		BlockPos pos = event.getPos().above();
		Entity released = EntityType.loadEntityRecursive(pocket, serverLevel, e ->
		{
			e.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, e.getYRot(), e.getXRot());
			return e;
		});

		if (released != null)
			serverLevel.addFreshEntity(released);

		player.setData(PocketAttachments.POCKET_ANIMAL.get(), new CompoundTag());
		player.swing(InteractionHand.MAIN_HAND);
		player.playSound(SoundEvents.ITEM_PICKUP, 1.0F, (player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.2F + 1.0F);
		serverLevel.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.6F, 1.0F);
	}

	private PocketCarryHandler()
	{
	}
}
