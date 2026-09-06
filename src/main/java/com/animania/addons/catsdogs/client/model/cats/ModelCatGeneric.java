package com.animania.addons.catsdogs.client.model.cats;

import java.util.Map;

import com.animania.addons.catsdogs.client.model.ModelPartTreeLookup;
import com.animania.addons.catsdogs.common.entity.felids.EntityAnimaniaCat;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TamableAnimal;

 
































public class ModelCatGeneric<T extends EntityAnimaniaCat> extends EntityModel<T>
{
	 





	private static final Map<String, CatPartPose> SLEEP_TARGET = buildSleepTarget();

	 
	private static final Map<String, Float> SIT_POSE_X = Map.of(
			"body", -0.12601277199399058F,
			"lower_body", -0.6898780387650506F,
			"tail", 0.5878635439859821F,
			"back_leg_r1", -0.41790512675602626F,
			"back_leg_l1", -0.4277452930787703F,
			"leg_r1", -0.050714032075199235F,
			"leg_l1", -0.04352676621548658F);

	private final ModelPart root;
	private final Map<String, CatPartPose> baseline;
	private final Map<String, ModelPart> parts;

	public ModelCatGeneric(ModelPart root, Map<String, CatPartPose> baseline)
	{
		this.root = root;
		this.baseline = baseline;
		this.parts = ModelPartTreeLookup.resolve(root, baseline.keySet());
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		boolean sleeping = entity.getSleeping();
		boolean sitting = entity instanceof TamableAnimal tamable && tamable.isInSittingPose();

		if (sleeping)
		{
			 
			 
			 
			for (String name : this.baseline.keySet())
				applyPoseIfPresent(name, SLEEP_TARGET.get(name));
		}
		else
		{
			 
			 
			for (Map.Entry<String, CatPartPose> e : this.baseline.entrySet())
				applyPose(this.parts.get(e.getKey()), e.getValue());

			if (!sitting && this.parts.containsKey("neck1"))
			{
				ModelPart neck1 = this.parts.get("neck1");
				neck1.xRot = headPitch * 0.001453292F - 0.7F;
				neck1.yRot = netHeadYaw * 0.017453292F;
			}

			float limbSwingAmountAdj = limbSwingAmount * 0.6F;
			this.parts.get("tail").yRot = Mth.sin(ageInTicks * 3.141593F * 0.05F) * Mth.sin(ageInTicks * 3.141593F * 0.03F * 0.05F) * 0.15F * 3.141593F;
			this.parts.get("back_leg_l1").xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmountAdj;
			this.parts.get("back_leg_r1").xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountAdj;
			this.parts.get("leg_l1").xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountAdj;
			this.parts.get("leg_r1").xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmountAdj;

			if (sitting)
				for (Map.Entry<String, Float> e : SIT_POSE_X.entrySet())
					if (this.parts.containsKey(e.getKey()))
						this.parts.get(e.getKey()).xRot = e.getValue();
		}
	}

	private void applyPoseIfPresent(String name, CatPartPose pose)
	{
		ModelPart part = this.parts.get(name);
		if (part != null && pose != null)
			applyPose(part, pose);
	}

	private static void applyPose(ModelPart part, CatPartPose pose)
	{
		part.setPos(pose.px(), pose.py(), pose.pz());
		part.xRot = pose.rx();
		part.yRot = pose.ry();
		part.zRot = pose.rz();
	}

	@Override
	public void renderToBuffer(com.mojang.blaze3d.vertex.PoseStack poseStack, com.mojang.blaze3d.vertex.VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		this.root.getChild("body").render(poseStack, buffer, packedLight, packedOverlay, color);
	}

	private static Map<String, CatPartPose> buildSleepTarget()
	{
		Map<String, CatPartPose> m = new java.util.HashMap<>();
		m.put("body", new CatPartPose(0.0F, 18.0F, -4.0F, 0.06625618906420873F, 0.32341649171155723F, -1.0548874718808847F));
		m.put("lower_body", new CatPartPose(0.0F, -1.0F, 5.0F, -1.0090568710527656F, 0.48442311520803416F, 0.23221954763634953F));
		m.put("tail", new CatPartPose(0.0F, -2.5F, 6.5F, -0.8058796021696017F, 0.5560950609411812F, -0.46257508363156913F));
		m.put("tail2", new CatPartPose(0.0F, 0.0F, 3.0F, -0.6273132210688099F, 0.3534029935900718F, -0.2132338560331552F));
		m.put("tail3", new CatPartPose(0.0F, 0.0F, 1.5F, -0.5570846626270621F, 0.26956435764127223F, 0.06366262979574516F));
		m.put("back_leg_r1", new CatPartPose(-4.0F, -4.0F, 3.0F, -0.37113379346108216F, 0.1191449013873929F, -0.05278922855582049F));
		m.put("back_leg_r2", new CatPartPose(0.0F, 2.5F, 1.0F, 0.1890383566127578F, 0.3021252201664784F, -0.7988371986378047F));
		m.put("back_leg_l1", new CatPartPose(4.0F, -4.0F, 3.0001F, -0.317335764597609F, -0.024499186710244404F, -0.351507566022406F));
		m.put("back_leg_l2", new CatPartPose(0.0F, 2.5F, 1.0F, -0.27035150113392165F, 0.0F, 0.0F));
		m.put("neck1", new CatPartPose(0.0F, 0.0F, -2.4F, 0.3872623810787618F, -0.2003096929221372F, 0.08771675754673101F));
		m.put("head_base", new CatPartPose(0.0F, -2.4F, -2.4F, 0.15652636330660744F, -0.09010087730495527F, 0.9300213812054544F));
		m.put("head_front", new CatPartPose(0.0F, 1.4F, 1.5F, 0.20943951023931956F, 0.0F, 0.0F));
		m.put("head_slope", new CatPartPose(0.0F, 0.0F, 3.0F, 0.10471975511965978F, 0.0F, 0.0F));
		m.put("nose", new CatPartPose(0.0F, -0.7F, -1.5F, -0.17677218262974168F, 0.0F, 0.0F));
		m.put("jaw", new CatPartPose(0.0F, 2.5F, -0.4F, 0.13962634015954636F, 0.0F, 0.0F));
		m.put("cheek_r", new CatPartPose(-0.4F, 0.5F, 2.0F, 0.0F, -0.16720254234105678F, -0.12217304763960307F));
		m.put("cheek_r2", new CatPartPose(1.0F, 0.6F, 1.5F, 0.0F, -0.24005258531930007F, 0.0F));
		m.put("cheek_l", new CatPartPose(0.4F, 0.5F, 2.0F, 0.0F, 0.16720428767030876F, 0.0F));
		m.put("cheek_l2", new CatPartPose(-1.0F, 0.6F, 1.5F, 0.0F, 0.24005433064855206F, 1.7453292519943296E-6F));
		m.put("ear_r", new CatPartPose(-2.0F, -1.5F, 0.7F, -0.39989158354619275F, 0.7372707092737046F, -0.35642066786677F));
		m.put("ear_r2", new CatPartPose(0.0F, 0.6F, -2.2F, 0.13962634015954636F, 0.0F, 0.0F));
		m.put("ear_r3", new CatPartPose(0.0F, 0.6F, -0.5F, 0.20053833105414848F, 0.0F, 0.0F));
		m.put("ear_l", new CatPartPose(2.0F, -1.5F, 0.7F, -0.4867775643689745F, -0.7524062045469995F, 0.3484375318681479F));
		m.put("ear_l2", new CatPartPose(0.0F, 0.6F, -2.2F, 0.13962634015954636F, 0.0F, 0.0F));
		m.put("ear_l3", new CatPartPose(0.0F, 0.6F, -0.5F, 0.20053833105414848F, 0.0F, 0.0F));
		m.put("leg_r1", new CatPartPose(-3.0F, -4.5F, -3.0F, -0.7143702441582871F, 0.15020827141438797F, -0.09882926889417891F));
		m.put("leg_r2", new CatPartPose(0.0F, 3.8F, 0.2F, -0.4264956373343423F, 0.39690707052528246F, -0.3543960859344566F));
		m.put("leg_l1", new CatPartPose(3.0F, -4.5F, -3.0F, -0.03362027738116677F, -0.0018256143975860686F, 0.015287338918218332F));
		m.put("leg_l2", new CatPartPose(0.0F, 3.8F, 0.2F, -0.7601938636693982F, -0.4308764137568481F, 0.43011195954447456F));
		return m;
	}
}
