package com.animania.addons.extra.common.entity.amphibians;

import com.animania.api.data.EntityGender;
import com.animania.api.interfaces.IAnimaniaAnimal;
import com.animania.api.interfaces.IGendered;
import com.animania.api.interfaces.ISpawnable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.JumpControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

 




























public abstract class EntityAmphibian extends Animal implements ISpawnable, IAnimaniaAnimal, IGendered
{
	private static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(EntityAmphibian.class, EntityDataSerializers.INT);

	private int jumpTicks;
	private int jumpDuration;
	private boolean wasOnGround;
	private final boolean canEntityJump;
	private int currentMoveTypeDuration;
	public float squishAmount;
	public float squishFactor;
	public float prevSquishFactor;

	protected EntityAmphibian(EntityType<? extends EntityAmphibian> type, Level level)
	{
		this(type, level, true);
	}

	protected EntityAmphibian(EntityType<? extends EntityAmphibian> type, Level level, boolean canEntityJumpIn)
	{
		super(type, level);
		this.canEntityJump = canEntityJumpIn;
		this.jumpControl = new AmphibianJumpControl(this);
		this.moveControl = new AmphibianMoveControl(this);
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return Animal.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 3.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.3D);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder)
	{
		super.defineSynchedData(builder);
		builder.define(AGE, 0);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer)
	{
		return false;
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new AmphibianPanicGoal(this, 2.2D));
		if (!"Pepe".equals(this.getName().getString()))
			this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 6.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 10.0F));
	}

	protected float getJumpUpwardsMotion()
	{
		if (!this.horizontalCollision && (!this.getMoveControl().hasWanted() || this.getMoveControl().getWantedY() <= this.getY() + 0.5D))
		{
			Path path = this.getNavigation().getPath();
			if (path != null && path.getNextNodeIndex() < path.getNodeCount())
			{
				Vec3 vec3 = path.getNextEntityPos(this);
				if (vec3.y > this.getY() + 0.5D)
					return 0.5F;
			}
			return this.getMoveControl().getSpeedModifier() <= 0.6D ? 0.2F : 0.3F;
		}
		return 0.5F;
	}

	public int getAge()
	{
		return this.entityData.get(AGE);
	}

	public void setAge(int age)
	{
		this.entityData.set(AGE, age);
	}

	@Override
	public void jumpFromGround()
	{
		super.jumpFromGround();
		double speed = this.getMoveControl().getSpeedModifier();
		if (speed > 0.0D)
		{
			double horizontalSqr = this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z;
			if (horizontalSqr < 0.010000000000000002D)
				this.moveRelative(0.1F, new Vec3(0.0D, 0.0D, 1.0D));
		}
	}

	public void setMovementSpeed(double newSpeed)
	{
		this.getNavigation().setSpeedModifier(newSpeed);
	}

	public void startJumping()
	{
		this.setJumping(true);
		this.jumpDuration = 10;
		this.jumpTicks = 0;
	}

	@Override
	protected void customServerAiStep()
	{
		if (this.canEntityJump)
		{
			if (this.currentMoveTypeDuration > 0)
				--this.currentMoveTypeDuration;

			if (this.onGround())
			{
				if (!this.wasOnGround)
				{
					this.setJumping(false);
					this.checkLandingDelay();
				}

				AmphibianJumpControl jumpControl = (AmphibianJumpControl) this.jumpControl;

				if (!jumpControl.isJumping())
				{
					if (this.getMoveControl().hasWanted() && this.currentMoveTypeDuration == 0)
					{
						Path path = this.getNavigation().getPath();
						Vec3 target = new Vec3(this.getMoveControl().getWantedX(), this.getMoveControl().getWantedY(), this.getMoveControl().getWantedZ());
						if (path != null && path.getNextNodeIndex() < path.getNodeCount())
							target = path.getNextEntityPos(this);

						this.calculateRotationYaw(target.x, target.z);
						this.startJumping();
					}
				}
				else if (!jumpControl.canJump())
					jumpControl.setCanJump(true);
			}
			this.wasOnGround = this.onGround();
		}
	}

	private void calculateRotationYaw(double x, double z)
	{
		this.setYRot((float) (Mth.atan2(z - this.getZ(), x - this.getX()) * (180D / Math.PI)) - 90.0F);
	}

	private void checkLandingDelay()
	{
		this.currentMoveTypeDuration = this.getMoveControl().getSpeedModifier() < 2.2D ? 10 : 1;
		((AmphibianJumpControl) this.jumpControl).setCanJump(false);
	}

	@Override
	public void aiStep()
	{
		if (this.getAge() == 0)
			this.setAge(1);

		if ("Pepe".equals(this.getName().getString()) && this.getMaxHealth() != 20.0D)
		{
			this.registerGoals();
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
			this.setHealth(20.0F);
		}

		if (this.canEntityJump)
		{
			if (this.jumpTicks != this.jumpDuration)
				++this.jumpTicks;
			else if (this.jumpDuration != 0)
			{
				this.jumpTicks = 0;
				this.jumpDuration = 0;
				this.setJumping(false);
			}
		}

		this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
		this.prevSquishFactor = this.squishFactor;
		super.aiStep();

		this.squishAmount = this.onGround() ? -0.5F : 0.5F;
		this.alterSquishAmount();
	}

	protected void alterSquishAmount()
	{
		this.squishAmount *= 0.6F;
	}

	@Override
	protected net.minecraft.sounds.SoundEvent getAmbientSound()
	{
		return null;
	}

	@Override
	protected net.minecraft.sounds.SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source)
	{
		return null;
	}

	@Override
	protected net.minecraft.sounds.SoundEvent getDeathSound()
	{
		return null;
	}

	@Override
	public net.minecraft.sounds.SoundSource getSoundSource()
	{
		return net.minecraft.sounds.SoundSource.NEUTRAL;
	}

	@Override
	public net.minecraft.world.entity.AgeableMob getBreedOffspring(net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.AgeableMob otherParent)
	{
		return null;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound)
	{
		super.addAdditionalSaveData(compound);
		compound.putInt("Age", this.getAge());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound)
	{
		super.readAdditionalSaveData(compound);
		this.setAge(compound.getInt("Age"));
	}

	@Override
	public void handleEntityEvent(byte id)
	{
		if (id == 1)
		{
			this.jumpDuration = 3;
			this.jumpTicks = 0;
		}
		else
			super.handleEntityEvent(id);
	}

	@Override
	public Item getSpawnEgg()
	{
		net.minecraft.world.item.SpawnEggItem egg = net.minecraft.world.item.SpawnEggItem.byId(this.getType());
		return egg != null ? egg : net.minecraft.world.item.Items.AIR;
	}

	 






	@Override
	public ItemStack getPickResult()
	{
		return new ItemStack(this.getSpawnEgg());
	}

	@Override
	public int getPrimaryEggColor()
	{
		return 0;
	}

	@Override
	public int getSecondaryEggColor()
	{
		return 0;
	}

	@Override
	public EntityGender getEntityGender()
	{
		return EntityGender.NONE;
	}

	 
	static class AmphibianPanicGoal extends PanicGoal
	{
		private final EntityAmphibian amphibian;

		AmphibianPanicGoal(EntityAmphibian amphibian, double speedModifier)
		{
			super(amphibian, speedModifier);
			this.amphibian = amphibian;
		}

		@Override
		public void tick()
		{
			super.tick();
			this.amphibian.setMovementSpeed(this.speedModifier);
		}
	}

	 
	public static class AmphibianJumpControl extends JumpControl
	{
		private final EntityAmphibian amphibian;
		private boolean canJump;

		public AmphibianJumpControl(EntityAmphibian amphibian)
		{
			super(amphibian);
			this.amphibian = amphibian;
		}

		public boolean isJumping()
		{
			return this.jump;
		}

		public boolean canJump()
		{
			return this.canJump;
		}

		public void setCanJump(boolean canJump)
		{
			this.canJump = canJump;
		}

		@Override
		public void tick()
		{
			if (this.jump)
			{
				this.amphibian.startJumping();
				this.jump = false;
			}
		}
	}

	 
	static class AmphibianMoveControl extends MoveControl
	{
		private final EntityAmphibian amphibian;
		private double nextJumpSpeed;

		AmphibianMoveControl(EntityAmphibian amphibian)
		{
			super(amphibian);
			this.amphibian = amphibian;
		}

		@Override
		public void tick()
		{
			 
			 
			 
			if (this.amphibian.onGround() && !this.amphibian.jumping && !((AmphibianJumpControl) this.amphibian.jumpControl).isJumping())
				this.amphibian.setMovementSpeed(0.0D);
			else if (this.hasWanted())
				this.amphibian.setMovementSpeed(this.nextJumpSpeed);

			super.tick();
		}

		@Override
		public void setWantedPosition(double x, double y, double z, double speedModifier)
		{
			if (this.amphibian.isInWater())
				speedModifier = 1.5D;

			super.setWantedPosition(x, y, z, speedModifier);

			if (speedModifier > 0.0D)
				this.nextJumpSpeed = speedModifier + this.amphibian.getRandom().nextFloat() / 25.0F;
		}
	}
}
