package com.dilosir22.abedo.client.util;

import com.dilosir22.abedo.Abedo;
import com.dilosir22.abedo.client.render.entity.CockatriceEntityRender;
import com.dilosir22.abedo.core.init.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.example.registry.EntityRegistry;

@Mod.EventBusSubscriber(modid = Abedo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.COCKATRICE.get(),
                manager -> new CockatriceEntityRender(manager));
    }
}
