package com.animania.addons.farm;

import com.animania.Animania;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

 



public class FarmSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, Animania.MODID);

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> COMBO = register("combo");
	 
	public static final DeferredHolder<SoundEvent, SoundEvent> HITCH = registerPath("hitch", "props/hitch");
	public static final DeferredHolder<SoundEvent, SoundEvent> UNHITCH = registerPath("unhitch", "props/unhitch");

	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CLUCK_1 = register("cluck1");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CLUCK_2 = register("cluck2");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CLUCK_3 = register("cluck3");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CLUCK_4 = register("cluck4");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CLUCK_5 = register("cluck5");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CLUCK_6 = register("cluck6");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CROW_1 = register("crow1");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CROW_2 = register("crow2");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_CROW_3 = register("crow3");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_HURT_1 = register("hurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_HURT_2 = register("hurt2");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_DEATH_1 = register("death1");
	public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_DEATH_2 = register("death2");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_MOO_1 = register("moo1");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_MOO_3 = register("moo3");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_MOO_4 = register("moo4");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_MOO_5 = register("moo5");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_MOO_6 = register("moo6");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_MOO_7 = register("moo7");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_MOO_8 = register("moo8");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_HURT_1 = register("cowhurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_HURT_2 = register("cowhurt2");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_DEATH_1 = register("cowdeath1");
	public static final DeferredHolder<SoundEvent, SoundEvent> COW_DEATH_2 = register("cowdeath2");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_1 = register("bullmoo1");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_2 = register("bullmoo2");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_3 = register("bullmoo3");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_4 = register("bullmoo4");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_5 = register("bullmoo5");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_6 = register("bullmoo6");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_7 = register("bullmoo7");
	public static final DeferredHolder<SoundEvent, SoundEvent> BULL_MOO_8 = register("bullmoo8");
	public static final DeferredHolder<SoundEvent, SoundEvent> ANGRY_BULL_1 = register("angrybull1");
	public static final DeferredHolder<SoundEvent, SoundEvent> ANGRY_BULL_2 = register("angrybull2");
	public static final DeferredHolder<SoundEvent, SoundEvent> ANGRY_BULL_3 = register("angrybull3");
	public static final DeferredHolder<SoundEvent, SoundEvent> MOO_CALF_1 = register("moocalf1");
	public static final DeferredHolder<SoundEvent, SoundEvent> MOO_CALF_2 = register("moocalf2");
	public static final DeferredHolder<SoundEvent, SoundEvent> MOO_CALF_3 = register("moocalf3");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_1 = register("pig1");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_2 = register("pig2");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_3 = register("pig3");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_4 = register("pig4");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_5 = register("pig5");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_6 = register("pig6");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_7 = register("pig7");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_HURT_1 = register("pighurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_HURT_2 = register("pighurt2");
	public static final DeferredHolder<SoundEvent, SoundEvent> HOG_1 = register("hog1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HOG_2 = register("hog2");
	public static final DeferredHolder<SoundEvent, SoundEvent> HOG_3 = register("hog3");
	public static final DeferredHolder<SoundEvent, SoundEvent> HOG_4 = register("hog4");
	public static final DeferredHolder<SoundEvent, SoundEvent> HOG_5 = register("hog5");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIGLET_1 = register("piglet1");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIGLET_2 = register("piglet2");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIGLET_3 = register("piglet3");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIGLET_HURT_1 = register("piglethurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIGLET_HURT_2 = register("piglethurt2");
	public static final DeferredHolder<SoundEvent, SoundEvent> PIGLET_HURT_3 = register("piglethurt3");

	 
	 
	 
	 
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_LIVING_1 = registerPath("sheepliving1", "sheep/living1");
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_LIVING_2 = registerPath("sheepliving2", "sheep/living2");
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_LIVING_3 = registerPath("sheepliving3", "sheep/living3");
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_LIVING_4 = registerPath("sheepliving4", "sheep/living4");
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_LIVING_5 = registerPath("sheepliving5", "sheep/living5");
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_LIVING_6 = registerPath("sheepliving6", "sheep/living6");
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_LIVING_7 = registerPath("sheepliving7", "sheep/living7");
	public static final DeferredHolder<SoundEvent, SoundEvent> SHEEP_HURT_1 = registerPath("sheephurt1", "sheep/hurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> LAMB_LIVING_1 = registerPath("lambliving1", "sheep/lambliving1");
	public static final DeferredHolder<SoundEvent, SoundEvent> LAMB_LIVING_2 = registerPath("lambliving2", "sheep/lambliving2");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAT_LIVING_1 = registerPath("goatliving1", "goats/living1");
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAT_LIVING_2 = registerPath("goatliving2", "goats/living2");
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAT_LIVING_3 = registerPath("goatliving3", "goats/living3");
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAT_LIVING_4 = registerPath("goatliving4", "goats/living4");
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAT_LIVING_5 = registerPath("goatliving5", "goats/living5");
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAT_HURT_1 = registerPath("goathurt1", "goats/hurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAT_HURT_2 = registerPath("goathurt2", "goats/hurt2");
	public static final DeferredHolder<SoundEvent, SoundEvent> KID_LIVING_1 = registerPath("kidliving1", "goats/kidliving1");
	public static final DeferredHolder<SoundEvent, SoundEvent> KID_LIVING_2 = registerPath("kidliving2", "goats/kidliving2");
	public static final DeferredHolder<SoundEvent, SoundEvent> KID_LIVING_3 = registerPath("kidliving3", "goats/kidliving3");
	public static final DeferredHolder<SoundEvent, SoundEvent> KID_HURT_1 = registerPath("kidhurt1", "goats/kidhurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> KID_HURT_2 = registerPath("kidhurt2", "goats/kidhurt2");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_LIVING_1 = registerPath("livinghorse1", "horses/livinghorse1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_LIVING_2 = registerPath("livinghorse2", "horses/livinghorse2");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_LIVING_3 = registerPath("livinghorse3", "horses/livinghorse3");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_LIVING_4 = registerPath("livinghorse4", "horses/livinghorse4");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_LIVING_5 = registerPath("livinghorse5", "horses/livinghorse5");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_LIVING_6 = registerPath("livinghorse6", "horses/livinghorse6");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_HURT_1 = registerPath("hurthorse1", "horses/hurthorse1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_HURT_2 = registerPath("hurthorse2", "horses/hurthorse2");
	public static final DeferredHolder<SoundEvent, SoundEvent> HORSE_HURT_3 = registerPath("hurthorse3", "horses/hurthorse3");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> FROG_LIVING_1 = registerPath("frogliving1", "amphibians/frogliving1");
	public static final DeferredHolder<SoundEvent, SoundEvent> FROG_LIVING_2 = registerPath("frogliving2", "amphibians/frogliving2");
	public static final DeferredHolder<SoundEvent, SoundEvent> FROG_LIVING_3 = registerPath("frogliving3", "amphibians/frogliving3");
	public static final DeferredHolder<SoundEvent, SoundEvent> TOAD_LIVING_1 = registerPath("toadliving1", "amphibians/toadliving1");
	public static final DeferredHolder<SoundEvent, SoundEvent> TOAD_LIVING_2 = registerPath("toadliving2", "amphibians/toadliving2");
	public static final DeferredHolder<SoundEvent, SoundEvent> TOAD_LIVING_3 = registerPath("toadliving3", "amphibians/toadliving3");
	public static final DeferredHolder<SoundEvent, SoundEvent> TOAD_LIVING_4 = registerPath("toadliving4", "amphibians/toadliving4");
	public static final DeferredHolder<SoundEvent, SoundEvent> DART_FROG_LIVING_1 = registerPath("dartfrogliving1", "amphibians/dartfrogliving1");
	public static final DeferredHolder<SoundEvent, SoundEvent> DART_FROG_LIVING_2 = registerPath("dartfrogliving2", "amphibians/dartfrogliving2");
	public static final DeferredHolder<SoundEvent, SoundEvent> DART_FROG_LIVING_3 = registerPath("dartfrogliving3", "amphibians/dartfrogliving3");
	public static final DeferredHolder<SoundEvent, SoundEvent> DART_FROG_LIVING_4 = registerPath("dartfrogliving4", "amphibians/dartfrogliving4");
	 
	 
	public static final DeferredHolder<SoundEvent, SoundEvent> PEPE_REEEE = registerPath("reeee", "amphibians/reeee");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEPE_OOOOOHH = registerPath("ooooohh", "amphibians/ooooohh");

	 
	 
	 
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_1 = registerPath("peacock1", "peacocks/peacock1");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_2 = registerPath("peacock2", "peacocks/peacock2");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_3 = registerPath("peacock3", "peacocks/peacock3");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_4 = registerPath("peacock4", "peacocks/peacock4");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_5 = registerPath("peacock5", "peacocks/peacock5");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_6 = registerPath("peacock6", "peacocks/peacock6");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_7 = registerPath("peacock7", "peacocks/peacock7");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_8 = registerPath("peacock8", "peacocks/peacock8");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_9 = registerPath("peacock9", "peacocks/peacock9");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_10 = registerPath("peacock10", "peacocks/peacock10");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_HURT_1 = registerPath("peacockhurt1", "peacocks/peacockhurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> PEACOCK_HURT_2 = registerPath("peacockhurt2", "peacocks/peacockhurt2");

	 
	 
	public static final DeferredHolder<SoundEvent, SoundEvent> HAMSTER_DEATH = registerPath("hamsterdeath", "hamsters/deathsound");
	public static final DeferredHolder<SoundEvent, SoundEvent> HAMSTER_EAT_1 = registerPath("hamstereat1", "hamsters/eatsound1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HAMSTER_EAT_2 = registerPath("hamstereat2", "hamsters/eatsound2");
	public static final DeferredHolder<SoundEvent, SoundEvent> HAMSTER_HURT_1 = registerPath("hamsterhurt1", "hamsters/hurtsound1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HAMSTER_LIVING_1 = registerPath("hamsterliving1", "hamsters/livingsound1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HAMSTER_LIVING_2 = registerPath("hamsterliving2", "hamsters/livingsound2");
	public static final DeferredHolder<SoundEvent, SoundEvent> HAMSTER_LIVING_3 = registerPath("hamsterliving3", "hamsters/livingsound3");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> FERRET_LIVING_1 = registerPath("ferretliving1", "rodents/ferret_living1");
	public static final DeferredHolder<SoundEvent, SoundEvent> FERRET_LIVING_2 = registerPath("ferretliving2", "rodents/ferret_living2");
	public static final DeferredHolder<SoundEvent, SoundEvent> FERRET_LIVING_3 = registerPath("ferretliving3", "rodents/ferret_living3");
	public static final DeferredHolder<SoundEvent, SoundEvent> FERRET_LIVING_4 = registerPath("ferretliving4", "rodents/ferret_living4");
	public static final DeferredHolder<SoundEvent, SoundEvent> FERRET_LIVING_5 = registerPath("ferretliving5", "rodents/ferret_living5");
	public static final DeferredHolder<SoundEvent, SoundEvent> FERRET_LIVING_6 = registerPath("ferretliving6", "rodents/ferret_living6");
	public static final DeferredHolder<SoundEvent, SoundEvent> FERRET_HURT_1 = registerPath("ferrethurt1", "rodents/ferret_hurt1");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> HEDGEHOG_LIVING_1 = registerPath("hedgehogliving1", "rodents/hedgehog_living1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HEDGEHOG_LIVING_2 = registerPath("hedgehogliving2", "rodents/hedgehog_living2");
	public static final DeferredHolder<SoundEvent, SoundEvent> HEDGEHOG_LIVING_3 = registerPath("hedgehogliving3", "rodents/hedgehog_living3");
	public static final DeferredHolder<SoundEvent, SoundEvent> HEDGEHOG_LIVING_4 = registerPath("hedgehogliving4", "rodents/hedgehog_living4");
	public static final DeferredHolder<SoundEvent, SoundEvent> HEDGEHOG_LIVING_5 = registerPath("hedgehogliving5", "rodents/hedgehog_living5");
	public static final DeferredHolder<SoundEvent, SoundEvent> HEDGEHOG_HURT_1 = registerPath("hedgehoghurt1", "rodents/hedgehog_hurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> HEDGEHOG_HURT_2 = registerPath("hedgehoghurt2", "rodents/hedgehog_hurt2");

	 
	public static final DeferredHolder<SoundEvent, SoundEvent> RABBIT_LIVING_1 = registerPath("rabbitliving1", "rabbits/rabbit1");
	public static final DeferredHolder<SoundEvent, SoundEvent> RABBIT_LIVING_2 = registerPath("rabbitliving2", "rabbits/rabbit2");
	public static final DeferredHolder<SoundEvent, SoundEvent> RABBIT_LIVING_3 = registerPath("rabbitliving3", "rabbits/rabbit3");
	public static final DeferredHolder<SoundEvent, SoundEvent> RABBIT_LIVING_4 = registerPath("rabbitliving4", "rabbits/rabbit4");
	public static final DeferredHolder<SoundEvent, SoundEvent> RABBIT_HURT_1 = registerPath("rabbithurt1", "rabbits/rabbithurt1");
	public static final DeferredHolder<SoundEvent, SoundEvent> RABBIT_HURT_2 = registerPath("rabbithurt2", "rabbits/rabbithurt2");

	private static DeferredHolder<SoundEvent, SoundEvent> register(String name)
	{
		return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Animania.MODID, name)));
	}

	 




	private static DeferredHolder<SoundEvent, SoundEvent> registerPath(String id, String unusedPathHint)
	{
		return register(id);
	}
}
