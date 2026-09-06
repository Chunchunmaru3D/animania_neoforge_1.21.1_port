package com.animania.addons.extra.common.entity.peafowl;

import com.animania.api.data.EntityGender;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

 




public class EntityPeacockBase extends EntityAnimaniaPeacock
{
	public EntityPeacockBase(EntityType<? extends EntityPeacockBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.MALE;
	}
}
