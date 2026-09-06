package com.animania.addons.extra.client.model.rabbits;

import com.animania.addons.extra.common.entity.rodents.rabbits.EntityAnimaniaRabbit;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;

 
public class ModelRabbitChinchilla<T extends EntityAnimaniaRabbit> extends ModelRabbitNewZealand<T>
{
	public ModelRabbitChinchilla(ModelPart root) { super(root); }

	public static LayerDefinition createBodyLayer()
	{
		return ModelRabbitRex.createBodyLayer(3, 0, -6.4F, 7, 12.870147F);
	}
}
