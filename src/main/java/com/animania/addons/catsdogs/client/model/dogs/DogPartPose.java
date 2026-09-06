package com.animania.addons.catsdogs.client.model.dogs;

 






public record DogPartPose(float px, float py, float pz, float rx, float ry, float rz, float ox, float oy, float oz)
{
	 
	public DogPartPose(float px, float py, float pz, float rx, float ry, float rz)
	{
		this(px, py, pz, rx, ry, rz, Float.NaN, Float.NaN, Float.NaN);
	}
}
