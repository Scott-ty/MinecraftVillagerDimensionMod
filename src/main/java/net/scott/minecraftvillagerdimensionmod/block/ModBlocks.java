package net.scott.minecraftvillagerdimensionmod.block;

import com.terraformersmc.terraform.sign.api.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;
import net.scott.minecraftvillagerdimensionmod.particle.ModParticleTypes;
import net.scott.minecraftvillagerdimensionmod.world.ModConfiguredFeatures;

import java.util.Optional;

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

    //************************************* ROWAN WOOD *******************************************************************//
    public static final Block ROWAN_LOG = registerBlock("rowan_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block ROWAN_WOOD = registerBlock("rowan_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_ROWAN_LOG = registerBlock("stripped_rowan_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_ROWAN_WOOD = registerBlock("stripped_rowan_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block ROWAN_PLANKS = registerBlock("rowan_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block ROWAN_LEAVES = registerBlock("rowan_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public static final Identifier ROWAN_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entity/signs/rowan");
    public static final Identifier ROWAN_HANGING_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entity/signs/hanging/rowan");
    public static final Identifier ROWAN_HANGING_GUI_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/gui/hanging_signs/rowan");

    public static final Block STANDING_ROWAN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "rowan_standing_sign"),
            new TerraformSignBlock(ROWAN_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.BIRCH_SIGN)));
    public static final Block WALL_ROWAN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "rowan_wall_sign"),
            new TerraformWallSignBlock(ROWAN_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.BIRCH_WALL_SIGN)));

    public static final Block HANGING_ROWAN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "rowan_hanging_sign"),
            new TerraformHangingSignBlock(ROWAN_HANGING_SIGN_TEXTURE,ROWAN_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.BIRCH_HANGING_SIGN)));
    public static final Block WALL_HANGING_ROWAN_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "rowan_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(ROWAN_HANGING_SIGN_TEXTURE,ROWAN_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.BIRCH_WALL_HANGING_SIGN)));

    public static final BlockFamily ROWAN_FAMILY = BlockFamilies.register(ModBlocks.ROWAN_PLANKS)
            .sign(ModBlocks.STANDING_ROWAN_SIGN, ModBlocks.WALL_ROWAN_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block ROWAN_STAIRS = registerBlock("rowan_stairs",
            new StairsBlock(ModBlocks.ROWAN_PLANKS.getDefaultState(),AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block ROWAN_SLAB = registerBlock("rowan_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block ROWAN_BUTTON = registerBlock("rowan_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
    public static final Block ROWAN_PRESSURE_PLATE = registerBlock("rowan_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block ROWAN_FENCE = registerBlock("rowan_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    public static final Block ROWAN_FENCE_GATE = registerBlock("rowan_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));
    public static final Block ROWAN_DOOR = registerBlock("rowan_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()));
    public static final Block ROWAN_TRAPDOOR = registerBlock("rowan_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()));


    public static final Block ROWAN_SAPLING = registerBlock("rowan_sapling",
            new SaplingBlock(
                    new SaplingGenerator(
                            MinecraftVillagerDimensionMod.MOD_ID,
                            0.1F,
                            Optional.empty(),
                            Optional.empty(),
                            Optional.of(ModConfiguredFeatures.ROWAN_KEY),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty()
                    ), AbstractBlock.Settings.copy(Blocks.DARK_OAK_SAPLING)));

    //*******************************************************************************************************************//

    //************************************* JUNIPER WOOD *******************************************************************//
    public static final Block JUNIPER_LOG = registerBlock("juniper_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block JUNIPER_WOOD = registerBlock("juniper_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_JUNIPER_LOG = registerBlock("stripped_juniper_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_JUNIPER_WOOD = registerBlock("stripped_juniper_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block JUNIPER_PLANKS = registerBlock("juniper_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block JUNIPER_LEAVES = registerBlock("juniper_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public static final Identifier JUNIPER_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entity/signs/juniper");
    public static final Identifier JUNIPER_HANGING_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entity/signs/hanging/juniper");
    public static final Identifier JUNIPER_HANGING_GUI_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/gui/hanging_signs/juniper");

    public static final Block STANDING_JUNIPER_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "juniper_standing_sign"),
            new TerraformSignBlock(JUNIPER_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    public static final Block WALL_JUNIPER_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "juniper_wall_sign"),
            new TerraformWallSignBlock(JUNIPER_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)));

    public static final Block HANGING_JUNIPER_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "juniper_hanging_sign"),
            new TerraformHangingSignBlock(JUNIPER_HANGING_SIGN_TEXTURE,JUNIPER_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_JUNIPER_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "juniper_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(JUNIPER_HANGING_SIGN_TEXTURE,JUNIPER_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final BlockFamily JUNIPER_FAMILY = BlockFamilies.register(ModBlocks.JUNIPER_PLANKS)
            .sign(ModBlocks.STANDING_JUNIPER_SIGN, ModBlocks.WALL_JUNIPER_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block JUNIPER_STAIRS = registerBlock("juniper_stairs",
            new StairsBlock(ModBlocks.JUNIPER_PLANKS.getDefaultState(),AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block JUNIPER_SLAB = registerBlock("juniper_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block JUNIPER_BUTTON = registerBlock("juniper_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
    public static final Block JUNIPER_PRESSURE_PLATE = registerBlock("juniper_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block JUNIPER_FENCE = registerBlock("juniper_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    public static final Block JUNIPER_FENCE_GATE = registerBlock("juniper_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));
    public static final Block JUNIPER_DOOR = registerBlock("juniper_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()));
    public static final Block JUNIPER_TRAPDOOR = registerBlock("juniper_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()));

    public static final Block JUNIPER_SAPLING = registerBlock("juniper_sapling",
            new SaplingBlock(
                    new SaplingGenerator(
                            MinecraftVillagerDimensionMod.MOD_ID,
                            0.1F,
                            Optional.empty(),
                            Optional.empty(),
                            Optional.of(ModConfiguredFeatures.JUNIPER_KEY),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty()
                    ), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    //*******************************************************************************************************************//

    //************************************* SYCAMORE WOOD *******************************************************************//
    public static final Block SYCAMORE_LOG = registerBlock("sycamore_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block SYCAMORE_WOOD = registerBlock("sycamore_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_SYCAMORE_LOG = registerBlock("stripped_sycamore_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_SYCAMORE_WOOD = registerBlock("stripped_sycamore_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block SYCAMORE_PLANKS = registerBlock("sycamore_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block SYCAMORE_LEAVES = registerBlock("sycamore_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public static final Identifier SYCAMORE_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entity/signs/sycamore");
    public static final Identifier SYCAMORE_HANGING_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "entity/signs/hanging/sycamore");
    public static final Identifier SYCAMORE_HANGING_GUI_SIGN_TEXTURE = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "textures/gui/hanging_signs/sycamore");

    public static final Block STANDING_SYCAMORE_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "sycamore_standing_sign"),
            new TerraformSignBlock(SYCAMORE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.ACACIA_SIGN)));
    public static final Block WALL_SYCAMORE_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "sycamore_wall_sign"),
            new TerraformWallSignBlock(SYCAMORE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.ACACIA_WALL_SIGN)));

    public static final Block HANGING_SYCAMORE_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "sycamore_hanging_sign"),
            new TerraformHangingSignBlock(SYCAMORE_HANGING_SIGN_TEXTURE,SYCAMORE_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.ACACIA_HANGING_SIGN)));
    public static final Block WALL_HANGING_SYCAMORE_SIGN = Registry.register(Registries.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "sycamore_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(SYCAMORE_HANGING_SIGN_TEXTURE,SYCAMORE_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.ACACIA_WALL_HANGING_SIGN)));

    public static final BlockFamily SYCAMORE_FAMILY = BlockFamilies.register(ModBlocks.SYCAMORE_PLANKS)
            .sign(ModBlocks.STANDING_SYCAMORE_SIGN, ModBlocks.WALL_SYCAMORE_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block SYCAMORE_STAIRS = registerBlock("sycamore_stairs",
            new StairsBlock(ModBlocks.SYCAMORE_PLANKS.getDefaultState(),AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block SYCAMORE_SLAB = registerBlock("sycamore_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block SYCAMORE_BUTTON = registerBlock("sycamore_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
    public static final Block SYCAMORE_PRESSURE_PLATE = registerBlock("sycamore_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block SYCAMORE_FENCE = registerBlock("sycamore_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    public static final Block SYCAMORE_FENCE_GATE = registerBlock("sycamore_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));
    public static final Block SYCAMORE_DOOR = registerBlock("sycamore_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()));
    public static final Block SYCAMORE_TRAPDOOR = registerBlock("sycamore_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()));

    public static final Block SYCAMORE_SAPLING = registerBlock("sycamore_sapling",
            new SaplingBlock(
                    new SaplingGenerator(
                            MinecraftVillagerDimensionMod.MOD_ID,
                            0.1F,
                            Optional.empty(),
                            Optional.empty(),
                            Optional.of(ModConfiguredFeatures.SYCAMORE_KEY),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty()
                    ), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    //*******************************************************************************************************************//

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
