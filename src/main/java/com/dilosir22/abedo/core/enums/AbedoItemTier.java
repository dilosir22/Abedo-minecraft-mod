package com.dilosir22.abedo.core.enums;

import com.dilosir22.abedo.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.rmi.registry.RegistryHandler;
import java.util.function.Supplier;

public enum AbedoItemTier implements IItemTier {
    SILVER(2, 190, .0f, 1.5f, 25, () -> {return Ingredient.fromItems(ItemInit.SILVER_INGOT.get());});

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    AbedoItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}