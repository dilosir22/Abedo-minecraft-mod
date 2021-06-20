package com.dilosir22.abedo.client.util;

import com.dilosir22.abedo.Abedo;
import com.dilosir22.abedo.core.init.BlockInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_SHIFT;

@Mod.EventBusSubscriber(modid = Abedo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusSubscriber {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)
                .forEach(block -> {
                    final Item.Properties properties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    blockItem.setRegistryName(block.getRegistryName());
                    registry.register(blockItem);
                });
    }

}