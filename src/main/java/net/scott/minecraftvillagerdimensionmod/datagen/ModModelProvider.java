package net.scott.minecraftvillagerdimensionmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        //************************************* ROWAN WOOD ****************************************************************//
        blockStateModelGenerator.registerLog(ModBlocks.ROWAN_LOG).log(ModBlocks.ROWAN_LOG).wood(ModBlocks.ROWAN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ROWAN_LOG).log(ModBlocks.STRIPPED_ROWAN_LOG).wood(ModBlocks.STRIPPED_ROWAN_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROWAN_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROWAN_BERRY_LEAVES);

        BlockStateModelGenerator.BlockTexturePool rowan_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROWAN_PLANKS);
        rowan_pool.family(ModBlocks.ROWAN_FAMILY);
        rowan_pool.stairs(ModBlocks.ROWAN_STAIRS);
        rowan_pool.button(ModBlocks.ROWAN_BUTTON);
        rowan_pool.slab(ModBlocks.ROWAN_SLAB);
        rowan_pool.pressurePlate(ModBlocks.ROWAN_PRESSURE_PLATE);
        rowan_pool.fence(ModBlocks.ROWAN_FENCE);
        rowan_pool.fenceGate(ModBlocks.ROWAN_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.ROWAN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ROWAN_TRAPDOOR);

        blockStateModelGenerator.registerTintableCross(ModBlocks.ROWAN_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        //*******************************************************************************************************************//
        //************************************* JUNIPER WOOD ****************************************************************//
        blockStateModelGenerator.registerLog(ModBlocks.JUNIPER_LOG).log(ModBlocks.JUNIPER_LOG).wood(ModBlocks.JUNIPER_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_JUNIPER_LOG).log(ModBlocks.STRIPPED_JUNIPER_LOG).wood(ModBlocks.STRIPPED_JUNIPER_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JUNIPER_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JUNIPER_BERRY_LEAVES);

        BlockStateModelGenerator.BlockTexturePool juniper_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JUNIPER_PLANKS);
        juniper_pool.family(ModBlocks.JUNIPER_FAMILY);
        juniper_pool.stairs(ModBlocks.JUNIPER_STAIRS);
        juniper_pool.button(ModBlocks.JUNIPER_BUTTON);
        juniper_pool.slab(ModBlocks.JUNIPER_SLAB);
        juniper_pool.pressurePlate(ModBlocks.JUNIPER_PRESSURE_PLATE);
        juniper_pool.fence(ModBlocks.JUNIPER_FENCE);
        juniper_pool.fenceGate(ModBlocks.JUNIPER_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.JUNIPER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.JUNIPER_TRAPDOOR);

        blockStateModelGenerator.registerTintableCross(ModBlocks.JUNIPER_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        //*******************************************************************************************************************//

        //************************************* SYCAMORE WOOD ****************************************************************//
        blockStateModelGenerator.registerLog(ModBlocks.SYCAMORE_LOG).log(ModBlocks.SYCAMORE_LOG).wood(ModBlocks.SYCAMORE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SYCAMORE_LOG).log(ModBlocks.STRIPPED_SYCAMORE_LOG).wood(ModBlocks.STRIPPED_SYCAMORE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SYCAMORE_LEAVES);

        BlockStateModelGenerator.BlockTexturePool sycamore_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYCAMORE_PLANKS);
        sycamore_pool.family(ModBlocks.SYCAMORE_FAMILY);
        sycamore_pool.stairs(ModBlocks.SYCAMORE_STAIRS);
        sycamore_pool.button(ModBlocks.SYCAMORE_BUTTON);
        sycamore_pool.slab(ModBlocks.SYCAMORE_SLAB);
        sycamore_pool.pressurePlate(ModBlocks.SYCAMORE_PRESSURE_PLATE);
        sycamore_pool.fence(ModBlocks.SYCAMORE_FENCE);
        sycamore_pool.fenceGate(ModBlocks.SYCAMORE_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.SYCAMORE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SYCAMORE_TRAPDOOR);

        blockStateModelGenerator.registerTintableCross(ModBlocks.SYCAMORE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        //*******************************************************************************************************************//

        // Block states for hanging signs - Fixes Breaking texture bug
        blockStateModelGenerator.registerHangingSign(
                ModBlocks.STRIPPED_JUNIPER_LOG,      // the log that provides the particle texture
                ModBlocks.HANGING_JUNIPER_SIGN,       // the free-standing hanging sign block
                ModBlocks.WALL_HANGING_JUNIPER_SIGN   // the wall-mounted variant
        );
        blockStateModelGenerator.registerHangingSign(
                ModBlocks.STRIPPED_ROWAN_LOG,
                ModBlocks.HANGING_ROWAN_SIGN,
                ModBlocks.WALL_HANGING_ROWAN_SIGN
        );
        blockStateModelGenerator.registerHangingSign(
                ModBlocks.STRIPPED_SYCAMORE_LOG,
                ModBlocks.HANGING_SYCAMORE_SIGN,
                ModBlocks.WALL_HANGING_SYCAMORE_SIGN
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        // ROWAN WOOD
        //itemModelGenerator.register(ModItems.HANGING_ROWAN_SIGN, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROWAN_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROWAN_CHEST_BOAT, Models.GENERATED);

        // JUNIPER WOOD
        //itemModelGenerator.register(ModItems.HANGING_JUNIPER_SIGN, Models.GENERATED);

        itemModelGenerator.register(ModItems.JUNIPER_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.JUNIPER_CHEST_BOAT, Models.GENERATED);


        // SYCAMORE WOOD
        // Had to remove these because of duplicate definitions?? Minecraft can be weird
        //itemModelGenerator.register(ModItems.HANGING_SYCAMORE_SIGN, Models.GENERATED);

        itemModelGenerator.register(ModItems.SYCAMORE_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SYCAMORE_CHEST_BOAT, Models.GENERATED);

        // ANCIENT GEMSTONE
        itemModelGenerator.register(ModItems.ANCIENT_GEMSTONE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_GEMSTONE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_GEMSTONE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_GEMSTONE_BOOTS, Models.GENERATED);


        // PILLAGERITE
        itemModelGenerator.register(ModItems.PILLAGERITE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PILLAGERITE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PILLAGERITE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PILLAGERITE_BOOTS, Models.GENERATED);

        // MAGICITE
        itemModelGenerator.register(ModItems.MAGICITE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICITE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICITE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICITE_BOOTS, Models.GENERATED);

        // BOSS ARMOR
        itemModelGenerator.register(ModItems.BOSS_CROWN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOSS_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOSS_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOSS_BOOTS, Models.GENERATED);

        // KOI FISH
        itemModelGenerator.register(ModItems.ORANGE_KOI_FISH_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.ORANGE_KOI_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.WHITE_KOI_FISH_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.WHITE_KOI_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLACK_KOI_FISH_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.BLACK_KOI_BUCKET, Models.GENERATED);

        // Pillager Brute Boss
        itemModelGenerator.register(ModItems.PILLAGER_BRUTE_BOSS_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        // Evil Villager Boss
        itemModelGenerator.register(ModItems.EVIL_VILLAGER_BOSS_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        // Pillager Wizard Boss
        itemModelGenerator.register(ModItems.PILLAGER_WIZARD_BOSS_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        // Monarch Butterfly
        itemModelGenerator.register(ModItems.MONARCH_BUTTERFLY_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

    }
}
