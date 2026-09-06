package com.animania.client.model.placeholder;

import com.animania.api.interfaces.ISleeping;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;

 








public class ModelPeacock<T extends Mob> extends EntityModel<T>
{
	private final ModelPart Neck;
	private final ModelPart Neck2;
	private final ModelPart Neck3;
	private final ModelPart Head;
	private final ModelPart Crest;
	private final ModelPart BeakBottom;
	private final ModelPart BeakTop;
	private final ModelPart Body1;
	private final ModelPart leg1Top;
	private final ModelPart leg1top2;
	private final ModelPart leg1bottom;
	private final ModelPart Foot1;
	private final ModelPart Foot1b;
	private final ModelPart leg2Top;
	private final ModelPart leg2top2;
	private final ModelPart leg2bottom;
	private final ModelPart Foot2;
	private final ModelPart Foot2b;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart FanNodeA;
	private final ModelPart FeatherA;
	private final ModelPart FeatherA1;
	private final ModelPart FeatherA1b;
	private final ModelPart FeatherA2;
	private final ModelPart FeatherA2b;
	private final ModelPart FeatherA3;
	private final ModelPart FeatherA3b;
	private final ModelPart FeatherA4;
	private final ModelPart FeatherA4b;
	private final ModelPart FeatherA5;
	private final ModelPart FeatherA5b;
	private final ModelPart FeatherA6;
	private final ModelPart FeatherA6b;
	private final ModelPart FeatherA7;
	private final ModelPart FeatherA7b;
	private final ModelPart FeatherA8;
	private final ModelPart FeatherA8b;
	private final ModelPart FanNodeB;
	private final ModelPart FeatherB;
	private final ModelPart FeatherB1;
	private final ModelPart FeatherB1b;
	private final ModelPart FeatherB2;
	private final ModelPart FeatherB2b;
	private final ModelPart FeatherB3;
	private final ModelPart FeatherB3b;
	private final ModelPart FeatherB4;
	private final ModelPart FeatherB4b;
	private final ModelPart FeatherB5;
	private final ModelPart FeatherB5b;
	private final ModelPart FeatherB6;
	private final ModelPart FeatherB6b;
	private final ModelPart FeatherB7;
	private final ModelPart FeatherB7b;
	private final ModelPart FeatherB8;
	private final ModelPart FeatherB8b;
	private final ModelPart FanNodeC;
	private final ModelPart FeatherB11;
	private final ModelPart FeatherB1b1;
	private final ModelPart FeatherB21;
	private final ModelPart FeatherB2b1;
	private final ModelPart FeatherB31;
	private final ModelPart FeatherB3b1;
	private final ModelPart FeatherB41;
	private final ModelPart FeatherB4b1;
	private final ModelPart FanNodeD;
	private final ModelPart FeatherD;
	private final ModelPart FeatherD1;
	private final ModelPart FeatherD1b;
	private final ModelPart FeatherD2;
	private final ModelPart FeatherD2b;
	private final ModelPart Wing1;
	private final ModelPart Wing1a;
	private final ModelPart Wing1b;
	private final ModelPart Wing2;
	private final ModelPart Wing2a;
	private final ModelPart Wing2b;

	public ModelPeacock(ModelPart root)
	{
		this.Neck = root.getChild("Neck");
		this.Body1 = root.getChild("Body1");
		this.leg1Top = root.getChild("leg1Top");
		this.leg2Top = root.getChild("leg2Top");
		this.Wing1 = root.getChild("Wing1");
		this.Wing2 = root.getChild("Wing2");
		this.Tail1 = root.getChild("Tail1");
		this.FanNodeA = root.getChild("FanNodeA");
		this.FanNodeB = root.getChild("FanNodeB");
		this.FanNodeC = root.getChild("FanNodeC");
		this.FanNodeD = root.getChild("FanNodeD");
		this.Neck2 = this.Neck.getChild("Neck2");
		this.Neck3 = this.Neck.getChild("Neck3");
		this.Head = this.Neck.getChild("Head");
		this.Crest = this.Neck.getChild("Crest");
		this.BeakBottom = this.Neck.getChild("BeakBottom");
		this.BeakTop = this.Neck.getChild("BeakTop");
		this.leg1top2 = this.leg1Top.getChild("leg1top2");
		this.leg1bottom = this.leg1Top.getChild("leg1bottom");
		this.Foot1 = this.leg1Top.getChild("Foot1");
		this.Foot1b = this.leg1Top.getChild("Foot1b");
		this.leg2top2 = this.leg2Top.getChild("leg2top2");
		this.leg2bottom = this.leg2Top.getChild("leg2bottom");
		this.Foot2 = this.leg2Top.getChild("Foot2");
		this.Foot2b = this.leg2Top.getChild("Foot2b");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.FeatherA = this.FanNodeA.getChild("FeatherA");
		this.FeatherA1 = this.FanNodeA.getChild("FeatherA1");
		this.FeatherA1b = this.FanNodeA.getChild("FeatherA1b");
		this.FeatherA2 = this.FanNodeA.getChild("FeatherA2");
		this.FeatherA2b = this.FanNodeA.getChild("FeatherA2b");
		this.FeatherA3 = this.FanNodeA.getChild("FeatherA3");
		this.FeatherA3b = this.FanNodeA.getChild("FeatherA3b");
		this.FeatherA4 = this.FanNodeA.getChild("FeatherA4");
		this.FeatherA4b = this.FanNodeA.getChild("FeatherA4b");
		this.FeatherA5 = this.FanNodeA.getChild("FeatherA5");
		this.FeatherA5b = this.FanNodeA.getChild("FeatherA5b");
		this.FeatherA6 = this.FanNodeA.getChild("FeatherA6");
		this.FeatherA6b = this.FanNodeA.getChild("FeatherA6b");
		this.FeatherA7 = this.FanNodeA.getChild("FeatherA7");
		this.FeatherA7b = this.FanNodeA.getChild("FeatherA7b");
		this.FeatherA8 = this.FanNodeA.getChild("FeatherA8");
		this.FeatherA8b = this.FanNodeA.getChild("FeatherA8b");
		this.FeatherB = this.FanNodeB.getChild("FeatherB");
		this.FeatherB1 = this.FanNodeB.getChild("FeatherB1");
		this.FeatherB1b = this.FanNodeB.getChild("FeatherB1b");
		this.FeatherB2 = this.FanNodeB.getChild("FeatherB2");
		this.FeatherB2b = this.FanNodeB.getChild("FeatherB2b");
		this.FeatherB3 = this.FanNodeB.getChild("FeatherB3");
		this.FeatherB3b = this.FanNodeB.getChild("FeatherB3b");
		this.FeatherB4 = this.FanNodeB.getChild("FeatherB4");
		this.FeatherB4b = this.FanNodeB.getChild("FeatherB4b");
		this.FeatherB5 = this.FanNodeB.getChild("FeatherB5");
		this.FeatherB5b = this.FanNodeB.getChild("FeatherB5b");
		this.FeatherB6 = this.FanNodeB.getChild("FeatherB6");
		this.FeatherB6b = this.FanNodeB.getChild("FeatherB6b");
		this.FeatherB7 = this.FanNodeB.getChild("FeatherB7");
		this.FeatherB7b = this.FanNodeB.getChild("FeatherB7b");
		this.FeatherB8 = this.FanNodeB.getChild("FeatherB8");
		this.FeatherB8b = this.FanNodeB.getChild("FeatherB8b");
		this.FeatherB11 = this.FanNodeC.getChild("FeatherB11");
		this.FeatherB1b1 = this.FanNodeC.getChild("FeatherB1b1");
		this.FeatherB21 = this.FanNodeC.getChild("FeatherB21");
		this.FeatherB2b1 = this.FanNodeC.getChild("FeatherB2b1");
		this.FeatherB31 = this.FanNodeC.getChild("FeatherB31");
		this.FeatherB3b1 = this.FanNodeC.getChild("FeatherB3b1");
		this.FeatherB41 = this.FanNodeC.getChild("FeatherB41");
		this.FeatherB4b1 = this.FanNodeC.getChild("FeatherB4b1");
		this.FeatherD = this.FanNodeD.getChild("FeatherD");
		this.FeatherD1 = this.FanNodeD.getChild("FeatherD1");
		this.FeatherD1b = this.FanNodeD.getChild("FeatherD1b");
		this.FeatherD2 = this.FanNodeD.getChild("FeatherD2");
		this.FeatherD2b = this.FanNodeD.getChild("FeatherD2b");
		this.Wing1a = this.Wing1.getChild("Wing1a");
		this.Wing1b = this.Wing1.getChild("Wing1b");
		this.Wing2a = this.Wing2.getChild("Wing2a");
		this.Wing2b = this.Wing2.getChild("Wing2b");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition NeckDef = root.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(3, 19)
				.addBox(-2.5F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 12.3998F, -1.0F, -0.539251F, 0.0F, 0.0F));

		PartDefinition Neck2Def = NeckDef.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(21, 21)
				.addBox(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F),
				PartPose.offsetAndRotation(0.0F, -1.4982600000000001F, -2.01686F, -0.9490896F, 0.0F, 0.0F));

		PartDefinition Neck3Def = NeckDef.addOrReplaceChild("Neck3", CubeListBuilder.create().texOffs(3, 28)
				.addBox(-1.51F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, -1.8998000000000008F, -2.75F, -1.376694F, 0.0F, 0.0F));

		PartDefinition HeadDef = NeckDef.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-1.5F, -2.5F, -2.0F, 3.0F, 3.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, -7.899800000000001F, -4.0F, 0.07594994F, 0.0F, 0.0F));

		PartDefinition BeakTopDef = NeckDef.addOrReplaceChild("BeakTop", CubeListBuilder.create().texOffs(19, 0)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, -8.839152F, -6.962383F, 0.3341772F, 0.0F, 0.0F));

		PartDefinition BeakBottomDef = NeckDef.addOrReplaceChild("BeakBottom", CubeListBuilder.create().texOffs(19, 0)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, -8.537474000000001F, -7.057199000000001F, 0.07594992F, 0.0F, 0.0F));

		PartDefinition CrestDef = NeckDef.addOrReplaceChild("Crest", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -12.443737680000002F, -3.59361F, -0.1465151F, 0.0F, 0.0F));

		PartDefinition Body1Def = root.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 7)
				.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, 13.5F, 2.0F, -0.1745329F, 0.0F, 0.0F));

		PartDefinition leg1TopDef = root.addOrReplaceChild("leg1Top", CubeListBuilder.create().texOffs(39, 0)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(-1.5F, 16.79997F, 1.75F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg1top2Def = leg1TopDef.addOrReplaceChild("leg1top2", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 2.9526400000000024F, 0.8522509999999999F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg1bottomDef = leg1TopDef.addOrReplaceChild("leg1bottom", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 6.150030000000001F, 0.4500000000000002F, -0.1745331F, 0.0F, 0.0F));

		PartDefinition Foot1Def = leg1TopDef.addOrReplaceChild("Foot1", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(-0.75F, 7.151750000000003F, -0.549126F, -5.789743e-08F, 0.0F, 0.0F));

		PartDefinition Foot1bDef = leg1TopDef.addOrReplaceChild("Foot1b", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(0.75F, 7.151750000000003F, -0.549126F, 0F, 0F, 0F));

		PartDefinition leg2TopDef = root.addOrReplaceChild("leg2Top", CubeListBuilder.create().texOffs(39, 0)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(1.5F, 16.79997F, 1.75F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg2top2Def = leg2TopDef.addOrReplaceChild("leg2top2", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 3.4332700000000003F, 0.9900699999999998F, 0.2792527F, 0.0F, 0.0F));

		PartDefinition leg2bottomDef = leg2TopDef.addOrReplaceChild("leg2bottom", CubeListBuilder.create().texOffs(35, 0)
				.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 6.150030000000001F, 0.4500000000000002F, -0.1745331F, 0.0F, 0.0F));

		PartDefinition Foot2Def = leg2TopDef.addOrReplaceChild("Foot2", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(-0.75F, 7.151750000000003F, -0.549126F, -5.789743e-08F, 0.0F, 0.0F));

		PartDefinition Foot2bDef = leg2TopDef.addOrReplaceChild("Foot2b", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F),
				PartPose.offsetAndRotation(0.75F, 7.151750000000003F, -0.549126F, 0F, 0F, 0F));

		PartDefinition Wing1Def = root.addOrReplaceChild("Wing1", CubeListBuilder.create().texOffs(92, 2)
				.addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(-3.5F, 12.6603F, 0.1172081F, -0.2947292F, 0.0F, 0.0F));

		PartDefinition Wing1aDef = Wing1Def.addOrReplaceChild("Wing1a", CubeListBuilder.create().texOffs(96, 2)
				.addBox(-0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(0.009999999999999787F, 0.30716000000000143F, 4.3059639F, 0F, 0F, 0F));

		PartDefinition Wing1bDef = Wing1Def.addOrReplaceChild("Wing1b", CubeListBuilder.create().texOffs(93, 2)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 6.0F),
				PartPose.offsetAndRotation(0.020000000000000018F, 1.91376F, -0.5809618F, 0F, 0F, 0F));

		PartDefinition Wing2Def = root.addOrReplaceChild("Wing2", CubeListBuilder.create().texOffs(92, 2)
				.addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(3.5F, 12.6603F, 0.1172086F, -0.2947292F, 0.0F, 0.0F));

		PartDefinition Wing2aDef = Wing2Def.addOrReplaceChild("Wing2a", CubeListBuilder.create().texOffs(96, 2)
				.addBox(-0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 2.0F),
				PartPose.offsetAndRotation(-0.009999999999999787F, 0.30716000000000143F, 4.3059634F, 0F, 0F, 0F));

		PartDefinition Wing2bDef = Wing2Def.addOrReplaceChild("Wing2b", CubeListBuilder.create().texOffs(93, 2)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 6.0F),
				PartPose.offsetAndRotation(-0.020000000000000018F, 1.91376F, -0.5809618F, 0F, 0F, 0F));

		PartDefinition Tail1Def = root.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(36, 20)
				.addBox(-2.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 14.10777F, 5.446827F, -0.4363323F, 0.0F, 0.0F));

		PartDefinition Tail2Def = Tail1Def.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(25, 14)
				.addBox(-2.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F),
				PartPose.offsetAndRotation(0.0F, 0.15024000000000015F, 2.6883880000000007F, -0.121238F, 0.0F, 0.0F));

		PartDefinition FanNodeADef = root.addOrReplaceChild("FanNodeA", CubeListBuilder.create(),
		PartPose.offsetAndRotation(0.0F, 19.892870000000002F, 14.49056F, -0.2617994F, 0.0F, 0.0F));

		PartDefinition FeatherADef = FanNodeADef.addOrReplaceChild("FeatherA", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2617994F, 0.0F, 0.0F));

		PartDefinition FeatherA1Def = FanNodeADef.addOrReplaceChild("FeatherA1", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, -0.2792528F, -5.792813e-09F, 0.2268928F));

		PartDefinition FeatherA1bDef = FanNodeADef.addOrReplaceChild("FeatherA1b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -0.2792527F, 3.986776e-09F, -0.2268928F));

		PartDefinition FeatherA2Def = FanNodeADef.addOrReplaceChild("FeatherA2", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(8.0F, 2.0F, 0.0F, -0.296706F, -6.077558e-09F, 0.4537856F));

		PartDefinition FeatherA2bDef = FanNodeADef.addOrReplaceChild("FeatherA2b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-8.0F, 2.0F, 0.0F, -0.296706F, 1.589279e-09F, -0.4537856F));

		PartDefinition FeatherA3Def = FanNodeADef.addOrReplaceChild("FeatherA3", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(12.0F, 4.0F, 0.0F, -0.3141594F, -3.567901e-08F, 0.6806786F));

		PartDefinition FeatherA3bDef = FanNodeADef.addOrReplaceChild("FeatherA3b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-12.0F, 4.0F, 0.0F, -0.3141594F, 1.490632e-08F, -0.6806785F));

		PartDefinition FeatherA4Def = FanNodeADef.addOrReplaceChild("FeatherA4", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(16.0F, 6.0F, 0.0F, -0.3316126F, -1.525341e-08F, 0.9075713F));

		PartDefinition FeatherA4bDef = FanNodeADef.addOrReplaceChild("FeatherA4b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-16.0F, 6.0F, 0.0F, -0.3316126F, 1.525341e-08F, -0.9075713F));

		PartDefinition FeatherA5Def = FanNodeADef.addOrReplaceChild("FeatherA5", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(18.0F, 8.0F, 0.0F, -0.3490659F, -4.286015e-08F, 1.134464F));

		PartDefinition FeatherA5bDef = FanNodeADef.addOrReplaceChild("FeatherA5b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-18.0F, 8.0F, 0.0F, -0.349066F, 2.922648e-08F, -1.134464F));

		PartDefinition FeatherA6Def = FanNodeADef.addOrReplaceChild("FeatherA6", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(20.0F, 10.50001F, 0.0F, -0.3563616F, -0.01687157F, 1.365743F));

		PartDefinition FeatherA6bDef = FanNodeADef.addOrReplaceChild("FeatherA6b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-20.0F, 10.50001F, 0.0F, -0.3563616F, -0.01687157F, -1.356971F));

		PartDefinition FeatherA7Def = FanNodeADef.addOrReplaceChild("FeatherA7", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(22.0F, 14.78575F, 0.0F, -0.3635876F, -0.03381116F, 1.597045F));

		PartDefinition FeatherA7bDef = FanNodeADef.addOrReplaceChild("FeatherA7b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-22.0F, 14.78575F, 0.0F, -0.3635877F, -0.0338112F, -1.579455F));

		PartDefinition FeatherA8Def = FanNodeADef.addOrReplaceChild("FeatherA8", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(22.0F, 17.78575F, 0.0F, -0.3707415F, -0.05100469F, 1.828417F));

		PartDefinition FeatherA8bDef = FanNodeADef.addOrReplaceChild("FeatherA8b", flatFeather(-42.5F, 64.0F),
				PartPose.offsetAndRotation(-22.0F, 17.78575F, 0.0F, -0.3707415F, -0.05100469F, -1.801868F));

		PartDefinition FanNodeBDef = root.addOrReplaceChild("FanNodeB", CubeListBuilder.create(),
		PartPose.offsetAndRotation(0.0F, 23.74961F, 10.853049F, -0.2617994F, 0.0F, 0.0F));

		PartDefinition FeatherBDef = FanNodeBDef.addOrReplaceChild("FeatherB", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(0.0F, 2.421249999999999F, -0.5592510000000002F, -0.2617994F, 0.0F, 0.0F));

		PartDefinition FeatherB1Def = FanNodeBDef.addOrReplaceChild("FeatherB1", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(4.0F, 2.414819999999999F, -0.6470479999999998F, -0.2792527F, -5.112545e-10F, 0.2268928F));

		PartDefinition FeatherB1bDef = FanNodeBDef.addOrReplaceChild("FeatherB1b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-4.0F, 2.414819999999999F, -0.6470479999999998F, -0.2792527F, -3.301778e-09F, -0.2268928F));

		PartDefinition FeatherB2Def = FanNodeBDef.addOrReplaceChild("FeatherB2", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(8.0F, 4.41482F, -0.6470479999999998F, -0.296706F, -3.057893e-09F, 0.4537857F));

		PartDefinition FeatherB2bDef = FanNodeBDef.addOrReplaceChild("FeatherB2b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-8.0F, 4.41482F, -0.6470479999999998F, -0.296706F, 1.056584e-08F, -0.4537857F));

		PartDefinition FeatherB3Def = FanNodeBDef.addOrReplaceChild("FeatherB3", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(12.0F, 6.41482F, -0.6470479999999998F, -0.3141594F, -2.389782e-08F, 0.6806788F));

		PartDefinition FeatherB3bDef = FanNodeBDef.addOrReplaceChild("FeatherB3b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-12.0F, 6.41482F, -0.6470479999999998F, -0.3141594F, 9.560558e-09F, -0.6806785F));

		PartDefinition FeatherB4Def = FanNodeBDef.addOrReplaceChild("FeatherB4", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(16.0F, 8.414819999999999F, -0.6470479999999998F, -0.3316126F, -1.282882e-09F, 0.9075713F));

		PartDefinition FeatherB4bDef = FanNodeBDef.addOrReplaceChild("FeatherB4b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-16.0F, 8.414819999999999F, -0.6470479999999998F, -0.3316126F, 1.282882e-09F, -0.9075713F));

		PartDefinition FeatherB5Def = FanNodeBDef.addOrReplaceChild("FeatherB5", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(18.0F, 12.41404F, -0.6470479999999998F, -0.3490659F, -5.144992e-09F, 1.134465F));

		PartDefinition FeatherB5bDef = FanNodeBDef.addOrReplaceChild("FeatherB5b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-18.0F, 12.41404F, -0.6470479999999998F, -0.3490659F, 2.968926e-08F, -1.134464F));

		PartDefinition FeatherB6Def = FanNodeBDef.addOrReplaceChild("FeatherB6", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(20.0F, 15.41404F, -0.647049F, -0.3563616F, -0.01687154F, 1.365743F));

		PartDefinition FeatherB6bDef = FanNodeBDef.addOrReplaceChild("FeatherB6b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-20.0F, 15.41404F, -0.647049F, -0.3563617F, -0.01687153F, -1.356971F));

		PartDefinition FeatherB7Def = FanNodeBDef.addOrReplaceChild("FeatherB7", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(22.0F, 18.41404F, -0.647049F, -0.3635876F, -0.03381118F, 1.597045F));

		PartDefinition FeatherB7bDef = FanNodeBDef.addOrReplaceChild("FeatherB7b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-22.0F, 18.41404F, -0.647049F, -0.3635877F, -0.03381117F, -1.579455F));

		PartDefinition FeatherB8Def = FanNodeBDef.addOrReplaceChild("FeatherB8", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(22.0F, 21.41404F, -0.647049F, -0.3707415F, -0.05100475F, 1.828418F));

		PartDefinition FeatherB8bDef = FanNodeBDef.addOrReplaceChild("FeatherB8b", flatFeather(-35.0F, 52.0F),
				PartPose.offsetAndRotation(-22.0F, 21.41404F, -0.647049F, -0.3707414F, -0.05100471F, -1.801867F));

		PartDefinition FanNodeCDef = root.addOrReplaceChild("FanNodeC", CubeListBuilder.create(),
		PartPose.offsetAndRotation(0.13F, 26.575961F, 3.8682410000000003F, -0.2617994F, 3.139456e-09F, -7.534808e-08F));

		PartDefinition FeatherB11Def = FanNodeCDef.addOrReplaceChild("FeatherB11", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(0.003027502F, 2.9434890000000014F, -0.7986429999999998F, -0.2792527F, -6.7773e-09F, -0.2268928F));

		PartDefinition FeatherB1b1Def = FanNodeCDef.addOrReplaceChild("FeatherB1b1", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(0.003027502F, 2.9434890000000014F, -0.7986429999999998F, -0.2792527F, 1.632293e-09F, 0.2268928F));

		PartDefinition FeatherB21Def = FanNodeCDef.addOrReplaceChild("FeatherB21", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(4.003027502F, 4.9434890000000005F, -0.7986429999999998F, -0.3141594F, -3.313954e-08F, 0.6806789F));

		PartDefinition FeatherB2b1Def = FanNodeCDef.addOrReplaceChild("FeatherB2b1", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(-4.003027502F, 4.9434890000000005F, -0.7986429999999998F, -0.3141593F, 1.610589e-08F, -0.6806785F));

		PartDefinition FeatherB31Def = FanNodeCDef.addOrReplaceChild("FeatherB31", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(8.003027502F, 6.9434890000000005F, -0.7986429999999998F, -0.3490659F, 5.208576e-09F, 1.134464F));

		PartDefinition FeatherB3b1Def = FanNodeCDef.addOrReplaceChild("FeatherB3b1", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(-8.003027502F, 6.9434890000000005F, -0.7986429999999998F, -0.3490659F, 1.29077e-08F, -1.134464F));

		PartDefinition FeatherB41Def = FanNodeCDef.addOrReplaceChild("FeatherB41", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(12.003025029F, 8.943489000000001F, -0.7986439999999999F, -0.3635876F, -0.03381122F, 1.597045F));

		PartDefinition FeatherB4b1Def = FanNodeCDef.addOrReplaceChild("FeatherB4b1", flatFeather(-27.0F, 40.0F),
				PartPose.offsetAndRotation(-12.003025029F, 8.943489000000001F, -0.7986439999999999F, -0.3635877F, -0.0338112F, -1.579455F));

		PartDefinition FanNodeDDef = root.addOrReplaceChild("FanNodeD", CubeListBuilder.create(),
		PartPose.offsetAndRotation(0.0F, 24.473945F, 4.202189F, -0.2617995F, 0.0F, 0.0F));

		PartDefinition FeatherDDef = FanNodeDDef.addOrReplaceChild("FeatherD", flatFeather(-8.5F, 13.0F),
				PartPose.offsetAndRotation(0.0F, 9.999999992515995e-07F, -1.000000000139778e-06F, -0.2617994F, 0.0F, 0.0F));

		PartDefinition FeatherD1Def = FanNodeDDef.addOrReplaceChild("FeatherD1", flatFeather(-8.5F, 13.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.296706F, 3.409307e-09F, 0.7853982F));

		PartDefinition FeatherD1bDef = FanNodeDDef.addOrReplaceChild("FeatherD1b", flatFeather(-8.5F, 13.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.296706F, -5.56468e-10F, -0.7853984F));

		PartDefinition FeatherD2Def = FanNodeDDef.addOrReplaceChild("FeatherD2", flatFeather(-8.5F, 13.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3316126F, 0.0F, 1.570797F));

		PartDefinition FeatherD2bDef = FanNodeDDef.addOrReplaceChild("FeatherD2b", flatFeather(-8.5F, 13.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3316126F, 0.0F, -1.570797F));

		return LayerDefinition.create(mesh, 128, 64);
	}

	 
	private static CubeListBuilder flatFeather(float y, float height)
	{
		return CubeListBuilder.create().texOffs(63, 0).addBox(-6.5F, y, 0.0F, 13.0F, height, 0.0F);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		 
		 
		 
		 
		 
		 
		this.Neck.xRot = Math.abs(netHeadYaw / (180F / (float) Math.PI));

		 
		 
		this.Body1.xRot = (float) Math.PI / 2F;

		this.leg1Top.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2Top.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.Wing1.zRot = ageInTicks;
		this.Wing2.zRot = -ageInTicks;

		boolean sleeping = entity instanceof ISleeping animaniaAnimal && animaniaAnimal.getSleeping();
		this.FanNodeA.xRot = sleeping ? -1.5F : -0.2617994F;
		this.FanNodeB.xRot = sleeping ? -1.5F : -0.2617994F;
		this.FanNodeC.xRot = sleeping ? -1.5F : -0.2617994F;
		this.FanNodeD.xRot = sleeping ? -1.5F : -0.2617995F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color)
	{
		 
		 
		this.Neck.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Body1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg1Top.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.leg2Top.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Wing1.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Wing2.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.Tail1.render(poseStack, buffer, packedLight, packedOverlay, color);
		 
		poseStack.pushPose();
		poseStack.scale(1.0F / 3.0F, 1.0F / 3.0F, 1.0F / 3.0F);
		this.FanNodeA.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FanNodeB.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FanNodeC.render(poseStack, buffer, packedLight, packedOverlay, color);
		this.FanNodeD.render(poseStack, buffer, packedLight, packedOverlay, color);
		poseStack.popPose();
	}
}
