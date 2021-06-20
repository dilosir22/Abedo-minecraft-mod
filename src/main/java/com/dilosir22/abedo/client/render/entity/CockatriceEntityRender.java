package com.dilosir22.abedo.client.render.entity;

import com.dilosir22.abedo.Abedo;
import com.dilosir22.abedo.client.render.model.CockatriceModel;
import com.dilosir22.abedo.common.entities.Cockatrice;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CockatriceEntityRender extends GeoEntityRenderer<Cockatrice> {


    public CockatriceEntityRender(EntityRendererManager renderManager)
    {
        super(renderManager, new CockatriceModel());
        this.shadowSize = 0.7F; //change 0.7 to the desired shadow size.
    }


    public ResourceLocation getEntityTexture(Cockatrice entity) {
        return new ResourceLocation(Abedo.MOD_ID, "textures/entity/cockatrice.png");
    }

    @Override
    public RenderType getRenderType(Cockatrice animatable, float partialTicks, MatrixStack stack,
                                    IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(getTextureLocation(animatable));
    }



}
