package net.scott.minecraftvillagerdimensionmod.block;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.particle.ModParticleTypes;

public class ModBlocks {

    public static final Block EMERALD_TORCH = registerBlock("emerald_torch", new TorchBlock(
            ModParticleTypes.EMERALD_FLAME,
            AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(state -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)
    ));
    public static final Block WALL_EMERALD_TORCH = registerBlock("wall_emerald_torch",new WallTorchBlock(
                    ModParticleTypes.EMERALD_FLAME,
                    AbstractBlock.Settings.create()
                            .noCollision()
                            .breakInstantly()
                            .luminance(state -> 14)
                            .sounds(BlockSoundGroup.WOOD)
                            .dropsLike(EMERALD_TORCH)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );


    public static final Block ANCIENT_GEMSTONE_ORE = registerBlock("ancient_gemstone_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE))); // Will have to use create and set the block settings
    // .requiresTool().strength(3.0F, 3.0F) ... something like this?
    public static final Block DEEPSLATE_ANCIENT_GEMSTONE_ORE = registerBlock("deepslate_ancient_gemstone_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block ANCIENT_GEMSTONE_BLOCK = registerBlock("ancient_gemstone_block",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)));

    public static final Block PILLAGERITE_ORE = registerBlock("pillagerite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_PILLAGERITE_ORE = registerBlock("deepslate_pillagerite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block PILLAGERITE_BLOCK = registerBlock("pillagerite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)));

    public static final Block MAGICITE_ORE = registerBlock("magicite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_MAGICITE_ORE = registerBlock("deepslate_magicite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block MAGICITE_BLOCK = registerBlock("magicite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)));


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
