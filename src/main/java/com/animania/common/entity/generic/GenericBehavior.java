package com.animania.common.entity.generic;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import com.animania.Animania;
import com.animania.api.interfaces.AnimaniaType;
import com.animania.api.interfaces.IAgeable;
import com.animania.api.interfaces.IAnimaniaAnimal;
import com.animania.api.interfaces.IBlinking;
import com.animania.api.interfaces.IChild;
import com.animania.api.interfaces.IFoodEating;
import com.animania.api.interfaces.IImpregnable;
import com.animania.api.interfaces.IMateable;
import com.animania.api.interfaces.ISleeping;
import com.animania.api.interfaces.ISterilizable;
import com.animania.api.interfaces.IVariant;
import com.animania.common.helper.AnimaniaHelper;
import com.animania.config.AnimaniaConfig;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.BabyEntitySpawnEvent;

 












public class GenericBehavior
{
	private static final Random rand = Animania.RANDOM;

	public static <T extends Animal & IFoodEating & ISleeping & IAgeable & IBlinking> void livingUpdateCommon(T entity)
	{
		if (entity.level().isClientSide)
			entity.setEatTimer(Math.max(0, entity.getEatTimer() - 1));

		if (entity.isLeashed() && entity.getSleeping())
			entity.setSleeping(false);

		if (entity.isLeashed() && !entity.getInteracted())
			entity.setInteracted(true);

		if (entity.isVehicle() && entity.getSleeping())
			entity.setSleeping(false);

		if (entity.getAge() == 0)
			entity.setAge(1);

		int fedTimer = entity.getFedTimer();

		final boolean ambiance = AnimaniaConfig.gameRules.ambianceMode.get();
		final boolean requireInteraction = AnimaniaConfig.gameRules.requireAnimalInteractionForAI.get();

		if (ambiance)
		{
			entity.setFed(true);
			entity.setWatered(true);
		}

		if (fedTimer > -1 && (requireInteraction ? entity.getInteracted() : true) && !ambiance)
		{
			fedTimer--;
			entity.setFedTimer(fedTimer);

			if (fedTimer == 0)
				entity.setFed(false);
		}

		int wateredTimer = entity.getWaterTimer();

		if (wateredTimer > -1)
		{
			wateredTimer--;
			entity.setWaterTimer(wateredTimer);

			if (wateredTimer == 0 && (requireInteraction ? entity.getInteracted() : true) && !ambiance)
				entity.setWatered(false);
		}

		boolean fed = entity.getFed();
		boolean watered = entity.getWatered();

		if (!fed && !watered)
		{
			entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2, 1, false, false));
			if (AnimaniaConfig.gameRules.animalsStarve.get())
			{
				int damageTimer = entity.getDamageTimer();

				if (damageTimer >= AnimaniaConfig.careAndFeeding.starvationTimer.get())
				{
					entity.hurt(entity.level().damageSources().starve(), 4f);
					entity.setDamageTimer(0);
				}
				if (!entity.getSleeping())
				{
					damageTimer++;
					entity.setDamageTimer(damageTimer);
				}
			}
		}
		else if (!fed || !watered)
			entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2, 0, false, false));

		int happyTimer = entity.getHappyTimer();

		if (happyTimer > -1)
		{
			happyTimer--;
			entity.setHappyTimer(happyTimer);
			if (happyTimer == 0)
			{
				entity.setHappyTimer(60);

				if (!entity.getFed() && !entity.getWatered() && !entity.getSleeping() && AnimaniaConfig.gameRules.showUnhappyParticles.get() && (requireInteraction ? entity.getInteracted() : true))
				{
					double d = rand.nextGaussian() * 0.001D;
					double d1 = rand.nextGaussian() * 0.001D;
					double d2 = rand.nextGaussian() * 0.001D;
					entity.level().addParticle(ParticleTypes.SMOKE,
							entity.getX() + rand.nextFloat() * entity.getBbWidth() - entity.getBbWidth(),
							entity.getY() + 1.5D + rand.nextFloat() * entity.getBbHeight(),
							entity.getZ() + rand.nextFloat() * entity.getBbWidth() - entity.getBbWidth(), d, d1, d2);
				}
			}
		}

		int blinkTimer = entity.getBlinkTimer();

		if (blinkTimer > -1)
		{
			blinkTimer--;
			entity.setBlinkTimer(blinkTimer);
			if (blinkTimer == 0)
				entity.setBlinkTimer(100 + rand.nextInt(100));
		}
	}

	public static <T extends AgeableMob & IFoodEating & ISleeping & IChild> void livingUpdateChild(T entity, Class<? extends LivingEntity> motherClass)
	{
		Level world = entity.level();

		entity.setAge((int) -((0.85 - entity.getEntityAge()) * 100 * AnimaniaConfig.careAndFeeding.childGrowthTick.get()));

		boolean fed = entity.getFed();
		boolean watered = entity.getWatered();

		int ageTimer = entity.getAgeTimer();

		ageTimer++;
		entity.setAgeTimer(ageTimer);

		if (ageTimer >= AnimaniaConfig.careAndFeeding.childGrowthTick.get())
			if (fed && watered && !entity.getSleeping())
			{
				entity.setAgeTimer(0);
				float age = entity.getEntityAge();
				age = age + .01F;
				entity.setEntityAge(age);

				if (age >= 0.85 && !world.isClientSide)
				{
					entity.discard();

					Mob grownUp;

					if (rand.nextInt(2) == 0)
						grownUp = (Mob) entity.getAnimalType().getFemale(world);
					else
						grownUp = (Mob) entity.getAnimalType().getMale(world);

					if (IImpregnable.class.isAssignableFrom(motherClass))
					{
						List<? extends LivingEntity> entities = AnimaniaHelper.getEntitiesInRange(motherClass, 15, world, entity);
						for (LivingEntity potentialMother : entities)
						{
							if (potentialMother.getUUID().equals(entity.getParentUniqueId()))
							{
								((IImpregnable) potentialMother).setHasKids(false);
								break;
							}
						}
					}

					if (grownUp != null)
					{
						if (entity instanceof IVariant variant && grownUp instanceof IVariant grownVariant)
							grownVariant.setVariant(variant.getVariant());

						grownUp.setPos(entity.getX(), entity.getY() + .5, entity.getZ());
						if (entity.hasCustomName())
							grownUp.setCustomName(entity.getCustomName());

						if (grownUp instanceof IAgeable ageable)
							ageable.setAge(1);

						if (grownUp instanceof IFoodEating foodEating)
							foodEating.setInteracted(entity.getInteracted());

						AnimaniaHelper.spawnEntity(world, grownUp);
						grownUp.playAmbientSound();
					}
				}
			}
	}

	public static <T extends Animal & IFoodEating & ISleeping & IMateable> void livingUpdateMateable(T entity, Class<? extends LivingEntity> partnerClass)
	{
		Level world = entity.level();

		if (rand.nextInt(200) == 0)
		{
			 
			if (entity.getMateUniqueId() != null)
			{
				UUID mateUUID = entity.getMateUniqueId();
				boolean mateReset = true;

				List<? extends LivingEntity> entities = AnimaniaHelper.getEntitiesInRange(partnerClass, 30, world, entity);
				for (LivingEntity mate : entities)
				{
					if (mate != null && mate.getUUID().equals(mateUUID) && mate.isAlive())
					{
						mateReset = false;
						break;
					}
				}

				if (mateReset)
					entity.setMateUniqueId(null);
			}
		}
	}

	public static <T extends Animal & IFoodEating & ISleeping & IMateable & IImpregnable> void livingUpdateFemale(T entity, Class<? extends LivingEntity> partnerClass)
	{
		livingUpdateMateable(entity, partnerClass);

		Level world = entity.level();

		int dryTimer = entity.getDryTimer();

		if (!entity.getFertile() && dryTimer > -1)
		{
			dryTimer--;
			entity.setDryTimer(dryTimer);
		}
		else
		{
			entity.setFertile(true);
			entity.setDryTimer(AnimaniaConfig.careAndFeeding.gestationTimer.get() / 9 + rand.nextInt(50));
		}

		int gestationTimer = entity.getGestation();
		if (gestationTimer > -1 && entity.getPregnant())
		{
			gestationTimer--;
			entity.setGestation(gestationTimer);

			if (gestationTimer < 200 && entity.getSleeping())
				entity.setSleeping(false);

			if (gestationTimer == 0)
			{
				UUID mateID = entity.getMateUniqueId();
				List<? extends LivingEntity> entities = AnimaniaHelper.getEntitiesInRange(partnerClass, 30, world, entity);
				Mob male = null;
				for (LivingEntity potentialMate : entities)
				{
					if (potentialMate != null && potentialMate.getUUID().equals(mateID))
					{
						male = (Mob) potentialMate;
						break;
					}
				}

				if (!entity.getFed() && !entity.getWatered())
				{
					if (rand.nextDouble() <= AnimaniaConfig.careAndFeeding.animalLossChance.get())
					{
						entity.setPregnant(false);
						entity.setFertile(false);
						entity.setHasKids(false);
						return;
					}
				}

				double birthChance = 1;
				while (rand.nextDouble() <= birthChance)
				{
					birthChance *= AnimaniaConfig.careAndFeeding.birthMultipleChance.get();

					entity.setInLove(null);
					AnimaniaType maleType = male == null ? entity.getAnimalType() : ((IAnimaniaAnimal) male).getAnimalType();
					AnimaniaType babyType = maleType.breed(entity.getAnimalType());

					AgeableMob entityKid = (AgeableMob) babyType.getChild(world);
					entityKid.setPos(entity.getX(), entity.getY() + .2, entity.getZ());

					((IChild) entityKid).setParentUniqueId(entity.getUUID());
					entityKid.playAmbientSound();

					if (entityKid instanceof IFoodEating foodEating)
						foodEating.setInteracted(entity.getInteracted());

					if (!world.isClientSide)
						AnimaniaHelper.spawnEntity(world, entityKid);

					entity.setPregnant(false);
					entity.setFertile(false);
					entity.setHasKids(true);

					BabyEntitySpawnEvent event = new BabyEntitySpawnEvent(entity, male == null ? entity : male, entityKid);
					NeoForge.EVENT_BUS.post(event);
				}
			}
		}
		else if (gestationTimer < 0)
			entity.setGestation(1);
	}

	 




	public static <T extends Animal & IFoodEating & ISleeping> boolean interactCommon(T entity, Player player, InteractionHand hand)
	{
		if (!entity.getInteracted())
			entity.setInteracted(true);

		ItemStack stack = player.getItemInHand(hand);

		if (!stack.isEmpty() && AnimaniaHelper.isWaterContainer(stack) && !entity.getSleeping())
		{
			if (!player.getAbilities().instabuild)
			{
				ItemStack emptied = AnimaniaHelper.emptyContainer(stack);
				stack.shrink(1);
				AnimaniaHelper.addItem(player, emptied);
			}

			entity.setEatTimer(40);
			entity.setWatered(true);
			entity.setInLove(player);
			return true;
		}
		else if (entity.isFood(stack))
		{
			if (entity.getSleeping())
				return true;

			if (!player.getAbilities().instabuild)
				stack.shrink(1);

			entity.setFed(true);
			entity.setHandFed(true);
			entity.setEatTimer(80);

			if (entity instanceof TamableAnimal tame)
			{
				if (!tame.isTame())
				{
					tame.setOwnerUUID(player.getUUID());
					tame.setTame(true, true);
				}
			}

			entity.setInLove(player);
			return true;
		}
		else if (entity instanceof TamableAnimal tame)
		{
			if (stack.isEmpty() && tame.isTame() && !tame.isOrderedToSit() && !player.isShiftKeyDown() && !entity.getSleeping())
			{
				tame.setOrderedToSit(true);
				tame.setJumping(false);
				tame.getNavigation().stop();
				return true;
			}
			else if (stack.isEmpty() && tame.isTame() && tame.isOrderedToSit() && !player.isShiftKeyDown() && !entity.getSleeping())
			{
				tame.setOrderedToSit(false);
				tame.setJumping(false);
				tame.getNavigation().stop();
				return true;
			}
		}

		return false;
	}

	public static <T extends Animal & IFoodEating & ISleeping & IImpregnable & IAnimaniaAnimal> void initialSpawnFemale(T entity, Class<? extends LivingEntity> baseClass)
	{
		if (entity.level().isClientSide)
			return;

		int chooser = rand.nextInt(3);

		List<? extends LivingEntity> others = AnimaniaHelper.getEntitiesInRange(baseClass, 64, entity.level(), entity.blockPosition());

		if (others.size() <= 8)
		{
			LivingEntity animal = null;

			if (chooser == 0)
			{
				animal = entity.getAnimalType().getMale(entity.level());
				if (animal instanceof IMateable mateable)
					mateable.setMateUniqueId(entity.getUUID());
			}
			else if (chooser == 1)
			{
				animal = entity.getAnimalType().getChild(entity.level());
				((IChild) animal).setParentUniqueId(entity.getUUID());
				entity.setHasKids(true);
			}

			if (animal != null)
			{
				animal.setPos(entity.getX(), entity.getY(), entity.getZ());
				AnimaniaHelper.spawnEntity(entity.level(), animal);
			}
		}
	}

	public static <T extends Animal & IFoodEating & ISleeping & IAgeable> void writeCommonNBT(CompoundTag tag, T entity)
	{
		tag.putBoolean("Fed", entity.getFed());
		tag.putBoolean("Interacted", entity.getInteracted());
		tag.putBoolean("Handfed", entity.getHandFed());
		tag.putBoolean("Watered", entity.getWatered());
		tag.putInt("Age", entity.getAge());
		tag.putBoolean("Sleep", entity.getSleeping());
		tag.putFloat("SleepTimer", entity.getSleepTimer());

		if (entity instanceof IImpregnable preg)
		{
			tag.putBoolean("Pregnant", preg.getPregnant());
			tag.putBoolean("HasKids", preg.getHasKids());
			tag.putBoolean("Fertile", preg.getFertile());
			tag.putInt("Gestation", preg.getGestation());
		}

		if (entity instanceof IMateable mateable)
		{
			UUID mate = mateable.getMateUniqueId();
			if (mate != null)
				tag.putString("MateUUID", mate.toString());
		}

		if (entity instanceof ISterilizable sterilizable)
			tag.putBoolean("Sterilized", sterilizable.getSterilized());

		if (entity instanceof IChild child)
		{
			tag.putFloat("Age", child.getEntityAge());
			if (child.getParentUniqueId() != null)
				tag.putString("ParentUUID", child.getParentUniqueId().toString());
		}
	}

	public static <T extends Animal & IFoodEating & ISleeping & IAgeable> void readCommonNBT(CompoundTag tag, T entity)
	{
		entity.setFed(tag.getBoolean("Fed"));
		entity.setInteracted(tag.getBoolean("Interacted"));
		entity.setHandFed(tag.getBoolean("Handfed"));
		entity.setWatered(tag.getBoolean("Watered"));
		entity.setAge(tag.getInt("Age"));
		entity.setSleeping(tag.getBoolean("Sleep"));
		entity.setSleepTimer(tag.getFloat("SleepTimer"));

		if (entity instanceof IImpregnable preg)
		{
			preg.setPregnant(tag.getBoolean("Pregnant"));
			preg.setHasKids(tag.getBoolean("HasKids"));
			preg.setFertile(tag.getBoolean("Fertile"));
			preg.setGestation(tag.getInt("Gestation"));
		}

		if (entity instanceof IMateable mateable)
		{
			String s = "";
			if (tag.contains("MateUUID"))
				s = tag.getString("MateUUID");

			if (!s.isEmpty())
				mateable.setMateUniqueId(UUID.fromString(s));
		}

		if (entity instanceof ISterilizable sterilizable)
			sterilizable.setSterilized(tag.getBoolean("Sterilized"));

		if (entity instanceof IChild child)
		{
			String s = "";
			if (tag.contains("ParentUUID"))
				s = tag.getString("ParentUUID");

			if (!s.isEmpty())
				child.setParentUniqueId(UUID.fromString(s));

			child.setEntityAge(tag.getFloat("Age"));
		}
	}

	public static SoundEvent getRandomSound(SoundEvent... sounds)
	{
		if (sounds == null || sounds.length == 0)
			return null;

		return sounds[rand.nextInt(sounds.length)];
	}

	@Nullable
	public static <T extends Animal & IFoodEating & ISleeping> SoundEvent getAmbientSound(T entity, SoundEvent... sounds)
	{
		if (sounds == null || sounds.length == 0)
			return null;

		int len = sounds.length * 8;
		int num = len;

		if (entity.getWatered())
			num -= len / 3;
		if (entity.getFed())
			num -= len / 3;

		if (entity.getSleeping())
			return null;

		int index = rand.nextInt(num);
		if (index > sounds.length - 1)
			return null;

		return sounds[index];
	}
}
