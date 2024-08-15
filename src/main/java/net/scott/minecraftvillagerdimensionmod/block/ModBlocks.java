package net.scott.minecraftvillagerdimensionmod.block;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ANCIENT_GEMSTONE_ORE = registerBlock("ancient_gemstone_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE))); // Will have to use create and set the block settings
    // .requiresTool().strength(3.0F, 3.0F) ... something like this?
    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){
        MinecraftVillagerDimensionMod.LOGGER.info("Registering ModBlocks for " + MinecraftVillagerDimensionMod.MOD_ID);
    }
}
