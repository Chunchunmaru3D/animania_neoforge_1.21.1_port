package com.animania.addons.catsdogs.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

 
public final class PetBowlFoodModel
{
    private PetBowlFoodModel() {}

    public static ModelPart bake()
    {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        addAll(root);
        return LayerDefinition.create(mesh, 64, 32).bakeRoot();
    }

    public static void render(ModelPart root, PoseStack poseStack, VertexConsumer consumer, int packedLight, int packedOverlay, int color)
    {
        root.render(poseStack, consumer, packedLight, packedOverlay, color);
    }

    private static void addAll(PartDefinition builder)
    {
		add(builder, "Kibble", -0.5F, 21.5F, 2.5F, 0F, 0F, 0F);
		add(builder, "Kibble1", 1.982582F, 21.5F, 1.5F, 0F, 1.489042F, 0F);
		add(builder, "Kibble10", -2.966135F, 21.27966F, 0.1258362F, 0.1521878F, -1.053035F, 0.1203963F);
		add(builder, "Kibble11", 1.5F, 21.5F, 0.1000004F, 0F, -2.296948F, 0F);
		add(builder, "Kibble12", 0.5993088F, 21.5F, 2.620312F, 0F, -0.807906F, 0F);
		add(builder, "Kibble2", 0.5F, 21F, 1.5F, -0.1574999F, -0.4672038F, -0.3014539F);
		add(builder, "Kibble21", -1.912066F, 21F, 1.577905F, -0.1574999F, 1.944106F, -0.3014538F);
		add(builder, "Kibble210", -2.165683F, 21F, -0.1639889F, -0.1574999F, 2.365415F, -0.3014538F);
		add(builder, "Kibble211", 0.08056542F, 21F, -2.437655F, -0.1574999F, 1.443147F, -0.3014538F);
		add(builder, "Kibble212", 0.9574023F, 21F, -0.1892587F, -0.1574999F, -2.428728F, -0.3014538F);
		add(builder, "Kibble213", -1.659482F, 20.99866F, -0.6876404F, -0.101737F, -2.994199F, -0.4886197F);
		add(builder, "Kibble214", 0.2692313F, 21.32954F, -2.099983F, -0.07101945F, -0.6271345F, -0.1268627F);
		add(builder, "Kibble215", -1.536606F, 21.05934F, 0.5232083F, 0.03257762F, -1.531796F, -0.2637101F);
		add(builder, "Kibble216", -2.750532F, 20.76118F, -1.541159F, -0.3232938F, 0.8571585F, -0.1980595F);
		add(builder, "Kibble217", 1.583739F, 21F, 1.511733F, -0.1574999F, -2.764152F, -0.3014539F);
		add(builder, "Kibble218", 3.12709F, 21F, -0.3435835F, -0.1574999F, -0.3528416F, -0.3014538F);
		add(builder, "Kibble219", 2.013164F, 21F, 2.65214F, -0.1574999F, -1.27511F, -0.3014539F);
		add(builder, "Kibble22", 1.067586F, 21F, 0.4216765F, -0.1574999F, 1.021838F, -0.3014539F);
		add(builder, "Kibble220", 0.2900807F, 21F, 0.9624316F, -0.1574999F, 1.1362F, -0.3014538F);
		add(builder, "Kibble221", 2.802393F, 21F, 2.064903F, -0.1574999F, -2.420374F, -0.3014539F);
		add(builder, "Kibble23", 0.8106487F, 21F, 2.68691F, -0.1574999F, -2.850037F, -0.3014538F);
		add(builder, "Kibble24", -1.235981F, 20.99866F, 1.307058F, -0.101737F, 2.867677F, -0.4886197F);
		add(builder, "Kibble25", 1.101661F, 21.32954F, 0.8069769F, -0.07101944F, -1.048444F, -0.1268627F);
		add(builder, "Kibble26", -1.619033F, 21.05934F, 2.462274F, 0.03257764F, -1.953105F, -0.2637101F);
		add(builder, "Kibble27", -1.882572F, 20.76118F, 0.08198526F, -0.3232937F, 0.4358495F, -0.1980595F);
		add(builder, "Kibble28", -0.6491588F, 21.22169F, 2.48901F, -0.04301889F, -3.080209F, -0.4586606F);
		add(builder, "Kibble29", 0.003598869F, 21F, -1.221509F, -0.1574999F, -0.04589463F, -0.3014538F);
		add(builder, "Kibble3", -1.267418F, 20.5F, 1.9F, 0.3970294F, 0.3625107F, 0.775726F);
		add(builder, "Kibble31", -0.3285331F, 20.5F, 2.458921F, 0.3970294F, 2.773821F, 0.775726F);
		add(builder, "Kibble310", -0.3578667F, 20.35F, -0.006823928F, 0.3970294F, -3.088056F, 0.775726F);
		add(builder, "Kibble311", -0.1387583F, 21.5F, 0.06311534F, 0.3970294F, -3.088056F, 0.775726F);
		add(builder, "Kibble312", 0.6518521F, 21.5F, -2.413765F, 0.3970294F, -3.088056F, 0.775726F);
		add(builder, "Kibble313", -1.25344F, 21.5F, -3.021926F, 0.3970294F, -3.088056F, 0.775726F);
		add(builder, "Kibble314", 1.046395F, 20.5F, -0.9043784F, 0.3970294F, 2.272861F, 0.775726F);
		add(builder, "Kibble315", 1.260692F, 20.5F, -1.975814F, 0.3970293F, -1.599014F, 0.775726F);
		add(builder, "Kibble316", -0.3376997F, 20.70565F, -1.991788F, 0.5685233F, -2.236345F, 0.6736611F);
		add(builder, "Kibble317", -1.409041F, 20.49984F, -1.930401F, 0.3192494F, 0.2892379F, 0.9653188F);
		add(builder, "Kibble318", -2.625513F, 20.29823F, -0.8067404F, 0.4908113F, -0.6187222F, 0.9636468F);
		add(builder, "Kibble319", -2.659093F, 20.32496F, 0.2850727F, 0.211188F, 1.694274F, 0.718143F);
		add(builder, "Kibble32", 1.321916F, 20.5F, 2.215857F, 0.3970294F, 1.851552F, 0.7757261F);
		add(builder, "Kibble320", 2.080258F, 21.5F, -2.059467F, 0.3970294F, -1.934437F, 0.7757261F);
		add(builder, "Kibble321", 1.416863F, 20.5F, 0.2554886F, 0.3970294F, 0.4768728F, 0.775726F);
		add(builder, "Kibble322", 0.502718F, 20.5F, 1.650982F, 0.3970294F, -0.4453953F, 0.775726F);
		add(builder, "Kibble323", 0.7474885F, 20.5F, 2.715869F, 0.3970294F, 1.965915F, 0.775726F);
		add(builder, "Kibble324", 3.090747F, 20.5F, 0.2758757F, 0.3970294F, -1.590659F, 0.775726F);
		add(builder, "Kibble325", 2.163996F, 21.5F, -0.6477347F, 0.3970294F, -1.934437F, 0.7757261F);
		add(builder, "Kibble326", 0.6685259F, 21.5F, -1.975729F, 0.3970294F, -1.934437F, 0.7757261F);
		add(builder, "Kibble33", 1.955643F, 20.5F, 1.325751F, 0.3970294F, -2.020323F, 0.775726F);
		add(builder, "Kibble34", 0.5035561F, 20.70565F, 0.6575029F, 0.5685233F, -2.657655F, 0.6736612F);
		add(builder, "Kibble35", -0.4992056F, 20.49984F, 0.2753914F, -5.963936F, -0.1320712F, 0.9653189F);
		add(builder, "Kibble36", -2.06883F, 20.29823F, 0.8033095F, 0.4908113F, -1.040031F, 0.9636469F);
		add(builder, "Kibble37", -2.545976F, 20.32496F, 1.785915F, 0.2111879F, 1.272965F, 0.7181429F);
		add(builder, "Kibble38", 0.7681076F, 20.8202F, 1.321139F, 0.5892963F, -2.279304F, 0.7483609F);
		add(builder, "Kibble39", -1.445684F, 20.5F, -0.1336928F, 0.3970294F, 0.7838198F, 0.775726F);
		add(builder, "Kibble4", -0.5F, 21.5F, 1.5F, 0F, 2.41131F, 0F);
		add(builder, "Kibble41", 0.9859222F, 21.5F, 1.418336F, 0F, -2.382834F, 0F);
		add(builder, "Kibble410", 1.322151F, 21.5F, 1.929298F, 0F, 1.603404F, 0F);
		add(builder, "Kibble411", 2.247736F, 21.5F, 0.7639973F, -6.283185F, -1.95317F, -1.241958E-08F);
		add(builder, "Kibble42", -0.3424319F, 21.6307F, 1.078821F, -0.003045561F, -0.5615618F, 0.1937396F);
		add(builder, "Kibble43", -1.7772F, 21.43127F, 1.419847F, -0.1933369F, 0.9265222F, 0.01292846F);
		add(builder, "Kibble44", -0.342432F, 21.6307F, 1.078821F, 0.1715521F, -2.636588F, -0.09052449F);
		add(builder, "Kibble45", -0.9089555F, 21.5F, -0.8125539F, 0F, 2.832619F, 0F);
		add(builder, "Kibble46", 0.4136325F, 21.5F, -1.494752F, 0F, -1.961524F, 0F);
		add(builder, "Kibble47", -0.9374095F, 21.6307F, -1.261341F, -0.003045562F, -0.1402526F, 0.1937396F);
		add(builder, "Kibble48", -2.107249F, 21.43127F, -0.3633795F, 6.089849F, 1.347831F, 0.01292845F);
		add(builder, "Kibble49", 2.247736F, 21.5F, 0.7639972F, -6.283185F, 0.1143622F, 0F);
		add(builder, "Kibble5", -0.5F, 21.5F, 0.1000004F, 0.1310762F, -2.981984F, -0.1431112F);
		add(builder, "Kibble6", -2.761048F, 21.27966F, 1.515037F, 0.1521878F, -1.474344F, 0.1203963F);
		add(builder, "Kibble7", -0.5F, 21.5F, 0.1000004F, 0F, 0.4213091F, 0F);
		add(builder, "Kibble8", 1.356536F, 21.5F, -1.827819F, 0F, 1.910351F, 0F);
		add(builder, "Kibble9", -1.481493F, 21.5F, -2.09013F, 0.1310762F, -2.560675F, -0.1431112F);
    }

    private static void add(PartDefinition builder, String name, float x, float y, float z, float xRot, float yRot, float zRot)
    {
        builder.addOrReplaceChild(name, CubeListBuilder.create().texOffs(18, 2).addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1),
                PartPose.offsetAndRotation(x, y, z, xRot, yRot, zRot));
    }
}
