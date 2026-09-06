package com.animania.addons.catsdogs.common.entity.canids;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IMateable;
import com.animania.api.interfaces.ISterilizable;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

 



public class EntityMaleDogBase extends EntityAnimaniaDog implements IMateable, ISterilizable
{
	protected static final EntityDataAccessor<Boolean> STERILIZED = SynchedEntityData.defineId(EntityMaleDogBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityMaleDogBase.class, EntityDataSerializers.OPTIONAL_UUID);

	public EntityMaleDogBase(EntityType<? extends EntityMaleDogBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.MALE;
		this.mateable = true;
	}

	public static AttributeSupplier.Builder createMaleAttributes()
	{
		return EntityAnimaniaDog.createAttributes();
	}

	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		if (!this.getSterilized())
			this.goalSelector.addGoal(8, new BreedGoal(this, 1.0D));
	}

	@Override
	public void aiStep()
	{
		com.animania.common.entity.generic.GenericBehavior.livingUpdateMateable(this, EntityFemaleDogBase.class);
		super.aiStep();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(STERILIZED, false);
		builder.define(MATE_UNIQUE_ID, Optional.empty());
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		if (!this.getSleeping())
			this.level().broadcastEntityEvent(this, (byte) 18);
	}

	public boolean getSterilized()
	{
		return this.entityData.get(STERILIZED);
	}

	@Override
	public void setSterilized(boolean sterilized)
	{
		this.entityData.set(STERILIZED, sterilized);
	}

	@Override
	public void sterilize()
	{
		this.setSterilized(true);
		this.goalSelector.removeAllGoals(goal -> goal instanceof BreedGoal);
	}

	@Override
	public EntityDataAccessor<Optional<UUID>> getMateUniqueIdParam()
	{
		return MATE_UNIQUE_ID;
	}

	@Override
	public EntityMaleDogBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}
}
