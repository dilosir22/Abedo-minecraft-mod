package com.dilosir22.abedo.client.event;

import com.dilosir22.abedo.Abedo;
import com.dilosir22.abedo.core.init.ItemInit;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_SHIFT;


@Mod.EventBusSubscriber(modid = Abedo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {


    private static int i = 1;
    private static boolean isCrouching;

    @SubscribeEvent
    public static void playerInteract(final PlayerInteractEvent event){
        PlayerEntity player = event.getPlayer();
        Hand hand = event.getHand();
        Item item = player.getHeldItem(hand).getItem();

    }

    @SubscribeEvent
    public static void onShift(InputEvent.KeyInputEvent event) {
        LivingEntity player = Minecraft.getInstance().player;
        World world = player.getEntityWorld();
        if (event.getKey() == GLFW_KEY_LEFT_SHIFT) {
            isCrouching = true;
        }else{
            isCrouching = false;
        }
    }

    @SubscribeEvent
    public static void renderHand(final RenderHandEvent event) {
        MatrixStack stack = event.getMatrixStack();

        if (event.getItemStack().getItem().equals(ItemInit.SNOWBALL_LAUNCHER.get())) {
            if (isCrouching == false) {
                stack.translate((double)((float)i * -0.541864F), 0.0D, 0.0D);
                stack.rotate(Vector3f.XP.rotationDegrees(0F));
                stack.rotate(Vector3f.YP.rotationDegrees((float)i * 10.0F));
                stack.rotate(Vector3f.ZP.rotationDegrees(0F));
            } if (isCrouching == true){
                stack.translate((double)((float)i * -0.541864F), 0.0D, 0.0D);
                stack.rotate(Vector3f.XP.rotationDegrees(0F));
                stack.rotate(Vector3f.YP.rotationDegrees((float)i * 10.0F));
                stack.rotate(Vector3f.ZP.rotationDegrees(0F));
            }
        }
    }
}
