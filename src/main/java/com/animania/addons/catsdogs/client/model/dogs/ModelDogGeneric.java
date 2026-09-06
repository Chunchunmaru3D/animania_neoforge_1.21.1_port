package com.animania.addons.catsdogs.client.model.dogs;

import java.util.Map;
import java.util.HashMap;

import com.animania.addons.catsdogs.client.model.ModelPartTreeLookup;
import com.animania.addons.catsdogs.common.entity.canids.EntityAnimaniaDog;
import com.leviathanstudio.craftstudio.client.model.CSModelBaker;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TamableAnimal;

 




















public class ModelDogGeneric<T extends EntityAnimaniaDog> extends EntityModel<T>
{
	private final ModelPart root;
	private final String rootName;
	private final Map<String, DogPartPose> baseline;
	private final Map<String, DogPartPose> sleepTarget;
	private final Map<String, Float> sitPoseX;
	private final Map<String, DogPartPose> sitPose;
	private final boolean walkWhileSleeping;
	private final boolean reverseWalkPhases;
	private final float sitBodyY, sitBodyZ;
	private final float headTrackOffset;
	private final Map<String, ModelPart> parts;
	private final Map<String, ModelPart> offsetBoxes;
	private final Map<String, DogPartPose> originalBoxOffsets;

	 












	public ModelDogGeneric(ModelPart root, String rootName, Map<String, DogPartPose> baseline,
			Map<String, DogPartPose> sleepTarget, Map<String, Float> sitPoseX,
			float sitBodyY, float sitBodyZ, float headTrackOffset)
	{
		this(root, rootName, baseline, sleepTarget, sitPoseX, sitBodyY, sitBodyZ, headTrackOffset, Map.of(), false, false);
	}

	 
	public ModelDogGeneric(ModelPart root, String rootName, Map<String, DogPartPose> baseline,
			Map<String, DogPartPose> sleepTarget, Map<String, Float> sitPoseX,
			float sitBodyY, float sitBodyZ, float headTrackOffset, Map<String, DogPartPose> sitPose)
	{
		this(root, rootName, baseline, sleepTarget, sitPoseX, sitBodyY, sitBodyZ, headTrackOffset, sitPose, false, false);
	}

	 
	public ModelDogGeneric(ModelPart root, String rootName, Map<String, DogPartPose> baseline,
			Map<String, DogPartPose> sleepTarget, Map<String, Float> sitPoseX,
			float sitBodyY, float sitBodyZ, float headTrackOffset, Map<String, DogPartPose> sitPose, boolean walkWhileSleeping)
	{
		this(root, rootName, baseline, sleepTarget, sitPoseX, sitBodyY, sitBodyZ, headTrackOffset, sitPose, walkWhileSleeping, false);
	}

	 
	public ModelDogGeneric(ModelPart root, String rootName, Map<String, DogPartPose> baseline,
			Map<String, DogPartPose> sleepTarget, Map<String, Float> sitPoseX,
			float sitBodyY, float sitBodyZ, float headTrackOffset, Map<String, DogPartPose> sitPose, boolean walkWhileSleeping, boolean reverseWalkPhases)
	{
		this.root = root;
		this.rootName = rootName;
		this.baseline = baseline;
		this.sleepTarget = sleepTarget;
		this.sitPoseX = sitPoseX;
		this.sitPose = sitPose;
		this.walkWhileSleeping = walkWhileSleeping;
		this.reverseWalkPhases = reverseWalkPhases;
		this.sitBodyY = sitBodyY;
		this.sitBodyZ = sitBodyZ;
		this.headTrackOffset = headTrackOffset;
		this.parts = ModelPartTreeLookup.resolve(root, baseline.keySet());
		this.offsetBoxes = new HashMap<>();
		this.originalBoxOffsets = new HashMap<>();
		for (String name : baseline.keySet())
		{
			ModelPart part = this.parts.get(name);
			if (part != null && part.hasChild(name + "_box"))
			{
				ModelPart box = part.getChild(name + "_box");
				this.offsetBoxes.put(name, box);
				this.originalBoxOffsets.put(name, new DogPartPose(box.x, box.y, box.z, 0, 0, 0));
			}
		}
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		boolean sleeping = entity.getSleeping();
		boolean sitting = entity instanceof TamableAnimal tamable && tamable.isInSittingPose();

		boolean sleepPoseApplied = sleeping && !sitting;
		if (sleepPoseApplied)
		{
			for (Map.Entry<String, DogPartPose> e : this.baseline.entrySet())
			{
				DogPartPose target = this.sleepTarget.getOrDefault(e.getKey(), e.getValue());
				applyPose(e.getKey(), this.parts.get(e.getKey()), target);
			}
			if (this.parts.containsKey("tail"))
			{
				DogPartPose tailPose = activePose("tail", true);
				setSourceRotation("tail", tailPose.rx(),
						Mth.sin(3.141593F * 0.05F) * Mth.sin(3.141593F * .03F * 0.05F) * 0.15F * 3.141593F,
						tailPose.rz());
			}
			if (!this.walkWhileSleeping)
				return;
		}

		 
		if (!sleepPoseApplied)
			for (Map.Entry<String, DogPartPose> e : this.baseline.entrySet())
				applyPose(e.getKey(), this.parts.get(e.getKey()), e.getValue());

		if (!sleeping && !sitting && this.parts.containsKey("neck1"))
		{
			DogPartPose base = this.baseline.get("neck1");
			setSourceRotation("neck1", headPitch * 0.001453292F + this.headTrackOffset,
					netHeadYaw * 0.017453292F, base.rz());
		}
		else if (!sleeping && !sitting && this.parts.containsKey("neck_base"))
		{
			DogPartPose base = this.baseline.get("neck_base");
			setSourceRotation("neck_base", headPitch * 0.001453292F + this.headTrackOffset,
					netHeadYaw * 0.017453292F, base.rz());
		}
		else if (!sleeping && !sitting && this.parts.containsKey("neck"))
		{
			DogPartPose base = this.baseline.get("neck");
			setSourceRotation("neck", headPitch * 0.001453292F + this.headTrackOffset,
					netHeadYaw * 0.017453292F, base.rz());
		}
		else if (!sleeping && !sitting && this.parts.containsKey("head"))
		{
			DogPartPose base = this.baseline.get("head");
			setSourceRotation("head", headPitch * 0.001453292F + this.headTrackOffset,
					netHeadYaw * 0.017453292F, base.rz());
		}

		float limbSwingAmountAdj = limbSwingAmount * 0.6F;
		float sway = Mth.sin(ageInTicks * 3.141593F * 0.05F) * Mth.sin(ageInTicks * 3.141593F * 0.03F * 0.05F) * 0.15F * 3.141593F;
		if (!sleeping && this.parts.containsKey("tail"))
		{
			DogPartPose tailPose = activePose("tail", sleepPoseApplied);
			setSourceRotation("tail", tailPose.rx(), sway, tailPose.rz());
		}

		float walkConst = 0.06981317007977318F;
		float forward = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmountAdj + walkConst;
		float opposite = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountAdj + walkConst;
		setLegX("back_leg_l1", "back_left", this.reverseWalkPhases ? opposite : forward, sleepPoseApplied);
		setLegX("back_leg_r1", "back_right", this.reverseWalkPhases ? forward : opposite, sleepPoseApplied);
		setLegX("leg_l1", "front_left", this.reverseWalkPhases ? forward : opposite, sleepPoseApplied);
		setLegX("leg_r1", "front_right", this.reverseWalkPhases ? opposite : forward, sleepPoseApplied);
		if (this.parts.containsKey("leg1"))
		{
			setLegX("leg1", "", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
			setLegX("leg2", "", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
			setLegX("leg3", "", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
			setLegX("leg4", "", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
		}
		if (this.parts.containsKey("leg_r11"))
		{
			setLegX("leg_r1", "", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
			setLegX("leg_r11", "", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
			setLegX("leg_r21", "", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
			setLegX("leg_r2", "", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmountAdj, sleepPoseApplied);
		}

		if (sitting)
		{
			ModelPart body = this.parts.get("body");
			if (body != null)
			{
				DogPartPose baseBody = this.baseline.get("body");
				body.setPos(baseBody.px(), this.sitBodyY, this.sitBodyZ);
			}
			for (Map.Entry<String, Float> e : this.sitPoseX.entrySet())
				if (this.parts.containsKey(e.getKey()))
				{
					DogPartPose base = this.baseline.get(e.getKey());
					setSourceRotation(e.getKey(), e.getValue(), base.ry(), base.rz());
				}
			for (Map.Entry<String, DogPartPose> e : this.sitPose.entrySet())
					applyPose(e.getKey(), this.parts.get(e.getKey()), e.getValue());
		}
	}

	 
	private void setLegX(String nameA, String nameB, float value, boolean sleeping)
	{
		String name = this.parts.containsKey(nameA) ? nameA : nameB;
		if (!name.isEmpty() && this.parts.containsKey(name))
		{
			DogPartPose pose = activePose(name, sleeping);
			setSourceRotation(name, value, pose.ry(), pose.rz());
		}
	}

	private DogPartPose activePose(String name, boolean sleeping)
	{
		DogPartPose base = this.baseline.get(name);
		return sleeping ? this.sleepTarget.getOrDefault(name, base) : base;
	}

	private void setSourceRotation(String name, float x, float y, float z)
	{
		ModelPart part = this.parts.get(name);
		if (part == null)
			return;
		 
		 
		 
		 
		 
		 
		float[] converted = CSModelBaker.convertRotationOrder(
				(float) Math.toDegrees(x), (float) Math.toDegrees(y), (float) Math.toDegrees(z));
		part.xRot = converted[0];
		part.yRot = converted[1];
		part.zRot = converted[2];
	}

	private void applyPose(String name, ModelPart part, DogPartPose pose)
	{
		if (part == null || pose == null)
			return;
		part.setPos(pose.px(), pose.py(), pose.pz());
		setSourceRotation(name, pose.rx(), pose.ry(), pose.rz());
		ModelPart box = this.offsetBoxes.get(name);
		if (box != null)
		{
			DogPartPose originalOffset = this.originalBoxOffsets.get(name);
			box.setPos(Float.isNaN(pose.ox()) ? originalOffset.px() : pose.ox(),
					Float.isNaN(pose.oy()) ? originalOffset.py() : pose.oy(),
					Float.isNaN(pose.oz()) ? originalOffset.pz() : pose.oz());
		}
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.root.getChild(this.rootName).render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
