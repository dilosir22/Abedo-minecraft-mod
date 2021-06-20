package com.dilosir22.abedo.core.init;

import com.dilosir22.abedo.Abedo;
import com.dilosir22.abedo.common.entities.Cockatrice;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Abedo.MOD_ID);

    public static final RegistryObject<EntityType<Cockatrice>> COCKATRICE = ENTITY_TYPES
            .register("cockatrice",
                    () -> EntityType.Builder.<Cockatrice>create(Cockatrice::new, EntityClassification.CREATURE)
                            .size(1.3f, 2.5f)
                            .immuneToFire()
                            .build(new ResourceLocation(Abedo.MOD_ID, "cockatrice").toString()));
}