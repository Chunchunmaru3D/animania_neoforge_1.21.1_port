package com.animania.addons.extra.common.pocket;

import java.util.function.Supplier;

import com.animania.Animania;

import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

 


















public class PocketAttachments
{
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
			DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Animania.MODID);

	public static final Supplier<AttachmentType<CompoundTag>> POCKET_ANIMAL = ATTACHMENT_TYPES.register("pocket_animal",
			() -> AttachmentType.builder(CompoundTag::new).serialize(CompoundTag.CODEC).build());

	private PocketAttachments()
	{
	}
}
