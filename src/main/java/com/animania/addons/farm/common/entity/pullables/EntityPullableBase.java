package com.animania.addons.farm.common.entity.pullables;

import javax.annotation.Nullable;
import java.util.UUID;

import com.animania.addons.farm.FarmSounds;
import com.animania.addons.farm.common.entity.horses.EntityAnimaniaHorse;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

 

















public abstract class EntityPullableBase extends Entity
{
	protected static final EntityDataAccessor<Boolean> PULLED = SynchedEntityData.defineId(EntityPullableBase.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Integer> PULLER_TYPE = SynchedEntityData.defineId(EntityPullableBase.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Integer> PULLER_ENTITY_ID = SynchedEntityData.defineId(EntityPullableBase.class, EntityDataSerializers.INT);

	 
	public Entity puller;
	@Nullable
	private UUID pullerUuid;

	 
	protected float distanceMoved;

	 





	private float wheelAnimationTime;
	private boolean wheelAnimationActive;

	public EntityPullableBase(EntityType<?> entityType, Level level)
	{
		super(entityType, level);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		builder.define(PULLED, false);
		builder.define(PULLER_TYPE, 0);
		builder.define(PULLER_ENTITY_ID, -1);
	}

	public boolean isPulled()
	{
		return this.entityData.get(PULLED);
	}

	public void setPulled(boolean pulled)
	{
		this.entityData.set(PULLED, pulled);
	}

	public int getPullerType()
	{
		return this.entityData.get(PULLER_TYPE);
	}

	public void setPullerType(int type)
	{
		this.entityData.set(PULLER_TYPE, type);
	}

	 
	protected int getPullerTypeFor(Entity candidate)
	{
		return candidate instanceof Player ? 2 : 0;
	}

	protected final boolean canBePulledBy(Entity candidate)
	{
		return this.getPullerTypeFor(candidate) != 0;
	}

	protected final void setPuller(@Nullable Entity candidate)
	{
		this.puller = candidate;
		this.pullerUuid = candidate == null ? null : candidate.getUUID();
		this.entityData.set(PULLER_ENTITY_ID, candidate == null ? -1 : candidate.getId());
		this.setPullerType(candidate == null ? 0 : this.getPullerTypeFor(candidate));
	}

	protected final void detachPuller()
	{
		this.setPulled(false);
		this.setPuller(null);
	}

	private void resolvePuller()
	{
		if (this.puller != null && !this.puller.isRemoved())
			return;

		int entityId = this.entityData.get(PULLER_ENTITY_ID);
		if (entityId >= 0)
			this.puller = this.level().getEntity(entityId);
		if (this.puller == null && this.pullerUuid != null && this.level() instanceof ServerLevel serverLevel)
			this.puller = serverLevel.getEntity(this.pullerUuid);
		if (this.puller != null)
		{
			this.pullerUuid = this.puller.getUUID();
			if (!this.level().isClientSide)
				this.entityData.set(PULLER_ENTITY_ID, this.puller.getId());
		}
	}

	 





	public float getWheelRotation()
	{
		return (this.distanceMoved / 5.655F) * 360F;
	}

	public float getWheelAnimationTime()
	{
		return this.wheelAnimationTime;
	}

	public boolean isWheelAnimationActive()
	{
		return this.wheelAnimationActive;
	}

	@Override
	public void tick()
	{
		super.tick();
		this.resolvePuller();

		 
		if (this.puller != null && (Math.abs(this.puller.getX() - this.getX()) > 5 || Math.abs(this.puller.getZ() - this.getZ()) > 5))
		{
			this.detachPuller();
			if (!this.level().isClientSide)
				this.level().playSound(null, this.getX(), this.getY(), this.getZ(), FarmSounds.UNHITCH.get(), SoundSource.PLAYERS, 0.7F, 1.5F);
		}

		if (this.isPulled() && this.puller != null)
		{
			double deltaAngle = -Math.atan2(this.puller.getX() - this.getX(), this.puller.getZ() - this.getZ());
			Vec3 behindPuller = new Vec3(0.0D, 0.0D, -2.5D).yRot((float) -deltaAngle);
			Vec3 target = new Vec3(this.puller.getX(), this.puller.getY(), this.puller.getZ())
					.subtract(this.getX(), this.getY(), this.getZ())
					.add(behindPuller);

			double dx = this.getX(), dz = this.getZ();
			this.setDeltaMovement(target);
			this.move(MoverType.SELF, target);
			this.setYRot((float) Math.toDegrees(deltaAngle));

			float moved = (float) Math.sqrt((this.getX() - dx) * (this.getX() - dx) + (this.getZ() - dz) * (this.getZ() - dz));
			this.distanceMoved += moved;
			this.wheelAnimationActive = moved > 0.005F;
			if (this.wheelAnimationActive)
			{
				 
				 
				 
				float yaw = this.getYRot() * ((float) Math.PI / 180F);
				float forwardX = -net.minecraft.util.Mth.sin(yaw);
				float forwardZ = net.minecraft.util.Mth.cos(yaw);
				float direction = ((float) (this.getX() - dx) * forwardX + (float) (this.getZ() - dz) * forwardZ) >= 0F ? 1F : -1F;
				this.wheelAnimationTime += direction;
			}
		}
		else
		{
			this.wheelAnimationActive = false;
			 
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
			this.move(MoverType.SELF, new Vec3(0.0D, this.getDeltaMovement().y, 0.0D));
		}
	}

	 











	protected boolean handleHitchInteract(Player player, InteractionHand hand)
	{
		boolean hasLead = player.getItemInHand(hand).is(Items.LEAD);
		if (!player.getItemInHand(hand).isEmpty() && !hasLead)
			return false;

		Entity mount = player.getVehicle();

		if (this.isPulled() && this.puller == mount)
		{
			this.detachPuller();
			if (!this.level().isClientSide)
				this.level().playSound(null, this.getX(), this.getY(), this.getZ(), FarmSounds.UNHITCH.get(), SoundSource.PLAYERS, 0.7F, 1.5F);
			return true;
		}

		if (!this.isPulled() && mount != null && this.canBePulledBy(mount))
		{
			this.setPuller(mount);
			this.setPulled(true);
			if (!this.level().isClientSide)
				this.level().playSound(null, this.getX(), this.getY(), this.getZ(), FarmSounds.HITCH.get(), SoundSource.PLAYERS, 0.7F, 1.5F);
			return true;
		}

		 
		 
		 
		if (!this.isPulled() && mount == null && (player.getItemInHand(hand).isEmpty() || hasLead))
		{
			Entity leashedPuller = this.level().getEntities(this, new AABB(player.blockPosition()).inflate(3.0D),
					candidate -> candidate instanceof Mob mob && mob.isLeashed() && mob.getLeashHolder() == player
							&& this.canBePulledBy(candidate)).stream().findFirst().orElse(null);
			if (leashedPuller instanceof Mob mob)
			{
				if (!this.level().isClientSide)
				{
					mob.dropLeash(true, false);
					if (!player.getAbilities().instabuild)
						player.addItem(new net.minecraft.world.item.ItemStack(Items.LEAD));
				}
				this.setPuller(leashedPuller);
				this.setPulled(true);
				if (!this.level().isClientSide)
					this.level().playSound(null, this.getX(), this.getY(), this.getZ(), FarmSounds.HITCH.get(), SoundSource.PLAYERS, 0.7F, 1.5F);
				return true;
			}
		}

		if (mount == null && !hasLead && this.isPulled() && this.puller == player)
		{
			this.detachPuller();
			if (!this.level().isClientSide)
				this.level().playSound(null, this.getX(), this.getY(), this.getZ(), FarmSounds.UNHITCH.get(), SoundSource.PLAYERS, 0.7F, 1.5F);
			return true;
		}
		if (mount == null && !hasLead && !this.isPulled() && this.canBePulledBy(player))
		{
			this.setPuller(player);
			this.setPulled(true);
			if (!this.level().isClientSide)
				this.level().playSound(null, this.getX(), this.getY(), this.getZ(), FarmSounds.HITCH.get(), SoundSource.PLAYERS, 0.7F, 1.5F);
			return true;
		}

		return false;
	}

	 



	protected boolean handleMountInteract(Player player, InteractionHand hand)
	{
		if (!player.isShiftKeyDown() || !player.getItemInHand(hand).isEmpty())
			return false;
		if (player.getVehicle() == this)
			return false;
		player.startRiding(this);
		if (this.puller == player)
		{
			this.detachPuller();
		}
		return true;
	}

	@Nullable
	public BlockPos getPullerPosition()
	{
		return this.puller != null ? this.puller.blockPosition() : null;
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag)
	{
		this.setPulled(tag.getBoolean("Pulled"));
		this.distanceMoved = tag.getFloat("DistanceMoved");
		this.setPullerType(tag.getInt("PullerType"));
		this.pullerUuid = tag.hasUUID("Puller") ? tag.getUUID("Puller") : null;
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag)
	{
		tag.putBoolean("Pulled", this.isPulled());
		tag.putFloat("DistanceMoved", this.distanceMoved);
		tag.putInt("PullerType", this.getPullerType());
		if (this.pullerUuid != null)
			tag.putUUID("Puller", this.pullerUuid);
	}

	@Override
	public boolean isPickable()
	{
		return !this.isRemoved();
	}

	 





	@Override
	public boolean canCollideWith(Entity other)
	{
		if (this.isPulled() || !super.canCollideWith(other))
			return false;
		if (other.getClass() == this.getClass())
			return other.getBoundingBox().minY < this.getBoundingBox().maxY;
		return other.getBoundingBox().minY <= this.getBoundingBox().minY;
	}

	@Override
	public boolean isPushable()
	{
		return true;
	}
}
