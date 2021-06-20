package com.dilosir22.abedo.core.init;

import com.dilosir22.abedo.Abedo;
import com.dilosir22.abedo.common.items.SnowballLauncherItem;
import com.dilosir22.abedo.common.items.SpecialItem;
import com.dilosir22.abedo.core.enums.AbedoItemTier;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.security.PublicKey;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Abedo.MOD_ID);

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    //tools
    public static final RegistryObject<SwordItem> SILVER_SWORD = ITEMS.register("silver_sword", () -> new SwordItem(AbedoItemTier.SILVER, 2, -2.4f, new Item.Properties()));

    public static final RegistryObject<SnowballLauncherItem> SNOWBALL_LAUNCHER = ITEMS.register("snowball_launcher",() -> new SnowballLauncherItem(new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()));
}
