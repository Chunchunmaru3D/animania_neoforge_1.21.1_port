package com.animania.addons.extra.client.model.rabbits;

import com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;

 



public class ModelRabbitDutch<T extends EntityAnimaniaRabbit> extends ModelRabbitRex<T>
{
	public ModelRabbitDutch(ModelPart root) { super(root); }

	public static LayerDefinition createBodyLayer() { return ModelRabbitRex.createBodyLayer(); }
}
