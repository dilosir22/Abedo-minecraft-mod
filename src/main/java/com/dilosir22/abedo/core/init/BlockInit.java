package com.dilosir22.abedo.core.init;

import com.dilosir22.abedo.Abedo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Abedo.MOD_ID);

    public  static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.STONE)));
    public  static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(6.0f, 5.0f).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));

    public  static final RegistryObject<Block> DIORITE_BRICKS = BLOCKS.register("diorite_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
    public  static final RegistryObject<Block> GRANITE_BRICKS = BLOCKS.register("granite_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)));
    //crystal dimension
    public static final RegistryObject<Block> BCRYSTAL_LOG = BLOCKS.register("bcrystal_log", ()->new Block(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(4.0f, 1.0f).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.GLASS).notSolid()));
    public static final RegistryObject<Block> GCRYSTAL_LEAVES = BLOCKS.register("gcrystal_leaves", ()->new Block(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(4.0f, 1.0f).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.GLASS).notSolid()));
    public static final RegistryObject<Block> GCRYSTAL_LEAF_FLOWERS = BLOCKS.register("gcrystal_leaf_flowers", ()->new Block(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(4.0f, 1.0f).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.GLASS).notSolid()));
}
