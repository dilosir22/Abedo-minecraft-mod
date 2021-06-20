package com.dilosir22.abedo;

import com.dilosir22.abedo.common.entities.Cockatrice;
import com.dilosir22.abedo.core.init.BlockInit;
import com.dilosir22.abedo.core.init.ItemInit;
import com.dilosir22.abedo.core.init.ModEntityTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(Abedo.MOD_ID)
public class Abedo
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "d22abo";



    public Abedo() {

        GeckoLib.initialize();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ModEntityTypes.ENTITY_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.COCKATRICE.get(), Cockatrice.setCustomAttributes().create());
        });


        RenderTypeLookup.setRenderLayer(BlockInit.BCRYSTAL_LOG.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.GCRYSTAL_LEAVES.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.GCRYSTAL_LEAF_FLOWERS.get(), RenderType.getTranslucent());


    }


}
