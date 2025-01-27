package net.scott.minecraftvillagerdimensionmod.datagen;

import com.mojang.datafixers.types.templates.Tag;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.util.ModTags;

import javax.swing.text.html.HTML;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg){

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ROWAN_LOG)
                .add(ModBlocks.STRIPPED_ROWAN_LOG)
                .add(ModBlocks.ROWAN_WOOD)
                .add(ModBlocks.STRIPPED_ROWAN_WOOD)
                .add(ModBlocks.ROWAN_DOOR)
                .add(ModBlocks.ROWAN_TRAPDOOR)
                .add(ModBlocks.ROWAN_BERRY_LEAVES)
                .add(ModBlocks.ROWAN_LEAVES)
                .add(ModBlocks.ROWAN_PLANKS)
                .add(ModBlocks.ROWAN_SLAB)
                .add(ModBlocks.ROWAN_STAIRS)
                .add(ModBlocks.ROWAN_PRESSURE_PLATE)
                .add(ModBlocks.ROWAN_BUTTON)
                .add(ModBlocks.ROWAN_FENCE)
                .add(ModBlocks.ROWAN_FENCE_GATE);

        // New tag for blocks that the sycamore trunk can grow through
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraftvillagerdimensionmod", "sycamore_grow_through")))
                .add(Blocks.AIR)  // Adding air is a typical block trees grow through
                .add(ModBlocks.SYCAMORE_LEAVES);  // Add more blocks as needed

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ROWAN_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ROWAN_FENCE_GATE);
        //*******************************************************************************************************************//


        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.JUNIPER_LOG)
                .add(ModBlocks.STRIPPED_JUNIPER_LOG)
                .add(ModBlocks.JUNIPER_WOOD)
                .add(ModBlocks.STRIPPED_JUNIPER_WOOD)
                .add(ModBlocks.JUNIPER_DOOR)
                .add(ModBlocks.JUNIPER_TRAPDOOR)
                .add(ModBlocks.JUNIPER_BERRY_LEAVES)
                .add(ModBlocks.JUNIPER_LEAVES)
                .add(ModBlocks.JUNIPER_PLANKS)
                .add(ModBlocks.JUNIPER_SLAB)
                .add(ModBlocks.JUNIPER_STAIRS)
                .add(ModBlocks.JUNIPER_PRESSURE_PLATE)
                .add(ModBlocks.JUNIPER_BUTTON)
                .add(ModBlocks.JUNIPER_FENCE)
                .add(ModBlocks.JUNIPER_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.JUNIPER_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.JUNIPER_FENCE_GATE);
        //*******************************************************************************************************************//



        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SYCAMORE_LOG)
                .add(ModBlocks.STRIPPED_SYCAMORE_LOG)
                .add(ModBlocks.SYCAMORE_WOOD)
                .add(ModBlocks.STRIPPED_SYCAMORE_WOOD)
                .add(ModBlocks.SYCAMORE_DOOR)
                .add(ModBlocks.SYCAMORE_TRAPDOOR)
                .add(ModBlocks.SYCAMORE_LEAVES)
                .add(ModBlocks.SYCAMORE_PLANKS)
                .add(ModBlocks.SYCAMORE_SLAB)
                .add(ModBlocks.SYCAMORE_STAIRS)
                .add(ModBlocks.SYCAMORE_PRESSURE_PLATE)
                .add(ModBlocks.SYCAMORE_BUTTON)
                .add(ModBlocks.SYCAMORE_FENCE)
                .add(ModBlocks.SYCAMORE_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.SYCAMORE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SYCAMORE_FENCE_GATE);
        //*******************************************************************************************************************//


        // Since I cant set my tool to be the only one to break, I have to prevent all other tools from breaking this block.
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ANCIENT_GEMSTONE_BLOCK)
                .add(ModBlocks.ANCIENT_GEMSTONE_ORE)
                .add(ModBlocks.DEEPSLATE_ANCIENT_GEMSTONE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ANCIENT_GEMSTONE_TOOL)
                .add(ModBlocks.ANCIENT_GEMSTONE_BLOCK)
                .add(ModBlocks.ANCIENT_GEMSTONE_ORE)
                .add(ModBlocks.DEEPSLATE_ANCIENT_GEMSTONE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_ANCIENT_GEMSTONE_TOOL)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_MAGICITE_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PILLAGERITE_TOOL)
                .add(ModBlocks.MAGICITE_BLOCK)
                .add(ModBlocks.MAGICITE_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICITE_ORE)
                .add(ModBlocks.PILLAGERITE_BLOCK)
                .add(ModBlocks.PILLAGERITE_ORE)
                .add(ModBlocks.DEEPSLATE_PILLAGERITE_ORE);
    }
}
