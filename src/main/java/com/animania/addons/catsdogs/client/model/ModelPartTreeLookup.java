package com.animania.addons.catsdogs.client.model;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.leviathanstudio.craftstudio.client.model.CSModelBaker;

import net.minecraft.client.model.geom.ModelPart;

 








public final class ModelPartTreeLookup
{
	private ModelPartTreeLookup()
	{
	}

	public static Map<String, ModelPart> resolve(ModelPart root, Collection<String> names)
	{
		Map<String, ModelPart> resolved = new HashMap<>();
		Set<String> unresolved = new HashSet<>(names);
		ArrayDeque<ModelPart> parents = new ArrayDeque<>();
		parents.add(root);

		while (!parents.isEmpty() && !unresolved.isEmpty())
		{
			ModelPart parent = parents.removeFirst();
			for (var iterator = unresolved.iterator(); iterator.hasNext();)
			{
				String name = iterator.next();
				try
				{
					ModelPart child = parent.getChild(name);
					resolved.put(name, child);
					parents.addLast(child);
					try
					{
						 
						 
						parents.addLast(child.getChild(name + CSModelBaker.BOX_SUFFIX));
					}
					catch (NoSuchElementException ignored)
					{
						 
					}
					iterator.remove();
				}
				catch (NoSuchElementException ignored)
				{
					 
				}
			}
		}

		if (!unresolved.isEmpty())
			throw new IllegalArgumentException("Model layer is missing articulated parts: " + unresolved);

		return resolved;
	}
}
