package com.animania.common.entity.generic.ai;

import java.util.EnumSet;
import java.util.List;

import com.animania.addons.catsdogs.common.entity.canids.DogType;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import com.animania.api.interfaces.ISleeping;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;

 










public class GenericAIGetDogHerdedGoal<T extends PathfinderMob & ISleeping> extends Goal
{
	private final T herdAnimal;
	private final DogType herderBreed;

	public GenericAIGetDogHerdedGoal(T herdAnimal, DogType herderBreed)
	{
		this.herdAnimal = herdAnimal;
		this.herderBreed = herderBreed;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse()
	{
		return !this.herdAnimal.getSleeping() && this.findHerder() != null;
	}

	@Override
	public boolean canContinueToUse()
	{
		return this.canUse();
	}

	@Override
	public void tick()
	{
		EntityAnimaniaDog herder = this.findHerder();
		if (herder == null)
			return;

		Path herderPath = herder.getNavigation().getPath();
		if (herderPath == null || herderPath.getNodeCount() == 0)
			return;

		BlockPos dest = herderPath.getTarget();
		this.herdAnimal.getNavigation().moveTo(dest.getX() + 0.5, dest.getY(), dest.getZ() + 0.5, 1.0D);
	}

	private EntityAnimaniaDog findHerder()
	{
		List<EntityAnimaniaDog> nearby = this.herdAnimal.level().getEntitiesOfClass(EntityAnimaniaDog.class,
				new AABB(this.herdAnimal.blockPosition()).inflate(10.0D),
				dog -> dog.type == this.herderBreed && dog.isTame() && !dog.isBaby() && !dog.getSleeping() && !dog.isOrderedToSit());

		return nearby.isEmpty() ? null : nearby.get(0);
	}
}
