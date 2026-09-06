package com.animania.addons.extra.common.entity.rodents.rabbits;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IImpregnable;
import com.animania.api.interfaces.IMateable;
import com.animania.common.entity.generic.GenericBehavior;
import com.animania.config.AnimaniaConfig;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

 




public class EntityRabbitDoeBase extends EntityAnimaniaRabbit implements IMateable, IImpregnable
{
	protected static final EntityDataAccessor<Boolean> PREGNANT = SynchedEntityData.defineId(EntityRabbitDoeBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> HAS_KIDS = SynchedEntityData.defineId(EntityRabbitDoeBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Boolean> FERTILE = SynchedEntityData.defineId(EntityRabbitDoeBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> GESTATION_TIMER = SynchedEntityData.defineId(EntityRabbitDoeBase.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Optional<UUID>> MATE_UNIQUE_ID = SynchedEntityData.defineId(EntityRabbitDoeBase.class, EntityDataSerializers.OPTIONAL_UUID);

	public int dryTimer;

	public EntityRabbitDoeBase(EntityType<? extends EntityRabbitDoeBase> entityType, Level level)
	{
		super(entityType, level);
		this.gender = EntityGender.FEMALE;
		this.mateable = true;
	}

	public static AttributeSupplier.Builder createDoeAttributes()
	{
		return EntityAnimaniaRabbit.createAttributes();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(PREGNANT, false);
		builder.define(HAS_KIDS, false);
		builder.define(FERTILE, true);
		builder.define(GESTATION_TIMER, AnimaniaConfig.careAndFeeding.gestationTimer.get() + this.random.nextInt(200));
		builder.define(MATE_UNIQUE_ID, Optional.empty());
	}

	@Override
	public void setInLove(@Nullable Player player)
	{
		if (!this.getSleeping())
			this.level().broadcastEntityEvent(this, (byte) 18);
	}

	@Override
	public net.minecraft.world.entity.SpawnGroupData finalizeSpawn(net.minecraft.world.level.ServerLevelAccessor level,
			net.minecraft.world.DifficultyInstance difficulty, net.minecraft.world.entity.MobSpawnType spawnType,
			@Nullable net.minecraft.world.entity.SpawnGroupData spawnGroupData)
	{
		GenericBehavior.initialSpawnFemale(this, EntityAnimaniaRabbit.class);
		return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
	}

	@Override
	public void aiStep()
	{
		GenericBehavior.livingUpdateFemale(this, EntityRabbitBuckBase.class);
		super.aiStep();
	}

	@Override
	public EntityRabbitDoeBase getBreedOffspring(net.minecraft.server.level.ServerLevel level, AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
	}

	@Override
	public EntityDataAccessor<Integer> getGestationParam()
	{
		return GESTATION_TIMER;
	}

	@Override
	public EntityDataAccessor<Boolean> getPregnantParam()
	{
		return PREGNANT;
	}

	@Override
	public EntityDataAccessor<Boolean> getFertileParam()
	{
		return FERTILE;
	}

	@Override
	public EntityDataAccessor<Boolean> getHasKidsParam()
	{
		return HAS_KIDS;
	}

	@Override
	public int getDryTimer()
	{
		return this.dryTimer;
	}

	@Override
	public void setDryTimer(int i)
	{
		this.dryTimer = i;
	}

	@Override
	public EntityDataAccessor<Optional<UUID>> getMateUniqueIdParam()
	{
		return MATE_UNIQUE_ID;
	}
}
