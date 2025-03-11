package net.scott.minecraftvillagerdimensionmod.datagen;
// ... (Previous imports)
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.JsonKeySortOrderCallback;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.entity.ModEntities;
import net.scott.minecraftvillagerdimensionmod.entity.custom.EvilVillagerBossEntity;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;
import net.scott.minecraftvillagerdimensionmod.world.dimension.ModDimensions;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {

    public ModAdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }
    //ADVANCEMENT ORDER
    // ROOT: entered_dimension
    // - a_dark_wood
    //      + pillagerite_ingot
    //          - armor
    //          - tools
    //          - sword
    // - feeling_grey
    //      + magicite_dust
    //          - armor
    //          - tools
    //          - sword
    // - youre_syc
    //      + ancient_gemstone_dust
    //          - armor
    //          - tools
    //          - sword

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup id, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry enterDimensionAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.EMERALD_TORCH_ITEM, // Display icon, such as a custom item used to light the portal
                        Text.literal("Into the Unknown"), // Title
                        Text.literal("Enter the villager dimension."), // Description
                        Identifier.of("textures/gui/advancements/backgrounds/end.png"), // You can customize the background image
                        AdvancementFrame.GOAL, // Frame type
                        true, // Show toast
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .criterion("entered_dimension", ChangedDimensionCriterion.Conditions.to(ModDimensions.DIMW_LEVEL_KEY)) // Detect entering the custom dimension
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/enter_dimension");

        AdvancementEntry rootAdvancementRowan = Advancement.Builder.create()
                .parent(enterDimensionAdvancement)
                .display(
                            ModBlocks.ROWAN_LOG, // The display icon
                            Text.literal("A Dark Wood"), // The title
                            Text.literal("Conquer the Rowans!"), // The description
                            Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                            true, // Show toast top right
                            true, // Announce to chat
                            false // Hidden in the advancement tab
                    )
                    // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                    .criterion("a_dark_wood", InventoryChangedCriterion.Conditions.items(ModBlocks.ROWAN_LOG))
                    .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/rowan_advancement");

        AdvancementEntry rootAdvancementJuniper = Advancement.Builder.create()
                .parent(enterDimensionAdvancement)
                .display(
                        ModBlocks.JUNIPER_LOG, // The display icon
                        Text.literal("Feeling Grey"), // The title
                        Text.literal("Are we on the west coast?"), // The description
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("feeling_grey", InventoryChangedCriterion.Conditions.items(ModBlocks.JUNIPER_LOG))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/juniper_advancement");

        AdvancementEntry rootAdvancementSycamore = Advancement.Builder.create()
                .parent(enterDimensionAdvancement)
                .display(
                        ModBlocks.SYCAMORE_LOG, // The display icon
                        Text.literal("You're Syc!"), // The title
                        Text.literal("Why would you cut such a beautiful tree?"), // The description
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("youre_syc", InventoryChangedCriterion.Conditions.items(ModBlocks.SYCAMORE_LOG))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/sycamore_advancement");

        // Advancement for obtaining magicite_dust
        AdvancementEntry magiciteDustAdvancement = Advancement.Builder.create()
                .parent(rootAdvancementJuniper)
                .display(
                        ModItems.MAGICITE_DUST,
                        Text.literal("Magic in the Air"),
                        Text.literal("Obtain Magicite Dust."),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("magicite_dust", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_DUST)) // Criterion: obtain magicite dust
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/magicite_dust_advancement");

        // Advancements for Magicite Armor Set
        AdvancementEntry magiciteArmorAdvancement = Advancement.Builder.create()
                .parent(magiciteDustAdvancement)
                .display(
                        ModItems.MAGICITE_HELMET,
                        Text.literal("Magicite Armor"),
                        Text.literal("Craft Magicite Armor"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("magicite_helmet", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_HELMET))
                .criterion("magicite_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_CHESTPLATE))
                .criterion("magicite_leggings", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_LEGGINGS))
                .criterion("magicite_boots", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_BOOTS))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/magicite_armor");

        // Advancements for Magicite Tools Set
        AdvancementEntry magiciteToolsAdvancement = Advancement.Builder.create()
                .parent(magiciteDustAdvancement)
                .display(
                        ModItems.MAGICITE_PICKAXE,
                        Text.literal("Magicite Tools"),
                        Text.literal("Craft Magicite Tools"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("magicite_shovel", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_SHOVEL))
                .criterion("magicite_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_PICKAXE))
                .criterion("magicite_axe", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_AXE))
                .criterion("magicite_hoe", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_HOE))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/magicite_tools");

        // Advancements for Magicite weapon
        AdvancementEntry magiciteWeaponAdvancement = Advancement.Builder.create()
                .parent(magiciteDustAdvancement)
                .display(
                        ModItems.MAGICITE_SWORD,
                        Text.literal("Sword of Magic"),
                        Text.literal("Craft a Magicite Sword"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("magicite_sword", InventoryChangedCriterion.Conditions.items(ModItems.MAGICITE_SWORD))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/magicite_weapon");




        // Advancement for obtaining pillagerite_ingot
        AdvancementEntry pillageriteIngotAdvancement = Advancement.Builder.create()
                .parent(rootAdvancementRowan)
                .display(
                        ModItems.PILLAGERITE_INGOT,
                        Text.literal("Pillager's Reward"),
                        Text.literal("Obtain a Pillagerite Ingot."),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("pillagerite_ingot", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_INGOT)) // Criterion: obtain pillagerite ingot
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/pillagerite_ingot_advancement");

        // Advancements for Pillagerite Armor Set
        AdvancementEntry pillageriteArmorAdvancement = Advancement.Builder.create()
                .parent(pillageriteIngotAdvancement)
                .display(
                        ModItems.PILLAGERITE_HELMET,
                        Text.literal("Powerful Dark Armor"),
                        Text.literal("Craft Pillagerite Armor"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("pillagerite_chest", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_HELMET))
                .criterion("pillagerite_helmet", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_CHESTPLATE))
                .criterion("pillagerite_leggings", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_LEGGINGS))
                .criterion("pillagerite_boots", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_BOOTS))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/pillagerite_armor");

        // Advancements for Pillagerite Tools Set
        AdvancementEntry pillageriteToolsAdvancement = Advancement.Builder.create()
                .parent(pillageriteIngotAdvancement)
                .display(
                        ModItems.PILLAGERITE_PICKAXE,
                        Text.literal("Powerful Dark Tools"),
                        Text.literal("Craft the dark tools armor"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("pillagerite_shovel", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_SHOVEL))
                .criterion("pillagerite_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_PICKAXE))
                .criterion("pillagerite_axe", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_AXE))
                .criterion("pillagerite_hoe", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_HOE))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/pillagerite_tools");

        // Advancements for Pillagerite weapon
        AdvancementEntry pillageriteWeaponAdvancement = Advancement.Builder.create()
                .parent(pillageriteIngotAdvancement)
                .display(
                        ModItems.PILLAGERITE_SWORD,
                        Text.literal("Sword of Darkness"),
                        Text.literal("Craft a pillagerite sword"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("pillagerite_sword", InventoryChangedCriterion.Conditions.items(ModItems.PILLAGERITE_SWORD))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/pillagerite_weapon");


        // Advancement for obtaining ancient_gemstone_dust
        AdvancementEntry ancientGemstoneDustAdvancement = Advancement.Builder.create()
                .parent(rootAdvancementSycamore)
                .display(
                        ModItems.ANCIENT_GEMSTONE_DUST,
                        Text.literal("Ancient Secrets"),
                        Text.literal("Obtain Ancient Gemstone Dust."),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("ancient_gemstone_dust", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_DUST)) // Criterion: obtain ancient gemstone dust
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/ancient_gemstone_dust_advancement");

        // Advancements for Ancient Gemstone Armor Set
        AdvancementEntry ancientGemstoneArmorAdvancement = Advancement.Builder.create()
                .parent(ancientGemstoneDustAdvancement)
                .display(
                        ModItems.ANCIENT_GEMSTONE_HELMET,
                        Text.literal("Ancient Gemstone Armor"),
                        Text.literal("Craft Ancient Gemstone Armor"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("ancient_gemstone_helmet", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_HELMET))
                .criterion("ancient_gemstone_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_CHESTPLATE))
                .criterion("ancient_gemstone_leggings", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_LEGGINGS))
                .criterion("ancient_gemstone_boots", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_BOOTS))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/ancient_gemstone_armor");

        // Advancements for Ancient Gemstone Tools Set
        AdvancementEntry ancientGemstoneToolsAdvancement = Advancement.Builder.create()
                .parent(ancientGemstoneDustAdvancement)
                .display(
                        ModItems.ANCIENT_GEMSTONE_PICKAXE,
                        Text.literal("Ancient Gemstone Tools"),
                        Text.literal("Craft Ancient Gemstone Tools"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("ancient_gemstone_shovel", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_SHOVEL))
                .criterion("ancient_gemstone_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_PICKAXE))
                .criterion("ancient_gemstone_axe", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_AXE))
                .criterion("ancient_gemstone_hoe", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_HOE))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/ancient_gemstone_tools");

        // Advancements for Ancient Gemstone weapon
        AdvancementEntry ancientGemstoneWeaponAdvancement = Advancement.Builder.create()
                .parent(ancientGemstoneDustAdvancement)
                .display(
                        ModItems.ANCIENT_GEMSTONE_SWORD,
                        Text.literal("Sword of the Ancients"),
                        Text.literal("Craft an Ancient Gemstone Sword"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("ancient_gemstone_sword", InventoryChangedCriterion.Conditions.items(ModItems.ANCIENT_GEMSTONE_SWORD))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/ancient_gemstone_weapon");

        // Advancements for Boss Armor Set
        AdvancementEntry bossArmorAdvancement = Advancement.Builder.create()
                .parent(enterDimensionAdvancement)
                .display(
                        ModItems.BOSS_CROWN,
                        Text.literal("Full Power of The Villagers"),
                        Text.literal("Obtain all 4 boss armor pieces"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("boss_crown", InventoryChangedCriterion.Conditions.items(ModItems.BOSS_CROWN))
                .criterion("boss_chest", InventoryChangedCriterion.Conditions.items(ModItems.BOSS_CHESTPLATE))
                .criterion("boss_leggings", InventoryChangedCriterion.Conditions.items(ModItems.BOSS_LEGGINGS))
                .criterion("boss_boots", InventoryChangedCriterion.Conditions.items(ModItems.BOSS_BOOTS))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/boss_armor");

        // Advancements for Killing Evil Villager
        AdvancementEntry evilVillagerAdvancement = Advancement.Builder.create()
                .parent(ancientGemstoneWeaponAdvancement)
                .display(
                        ModItems.EVIL_VILLAGER_BOSS_SPAWN_EGG,
                        Text.literal("Cleanse the village"),
                        Text.literal("Kill an Evil Villager Boss"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true)
                .criterion("killed_evil_villager", OnKilledCriterion.Conditions.createPlayerKilledEntity(
                        EntityPredicate.Builder.create().type(ModEntities.EVIL_VILLAGER_BOSS)))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/killed_evil_pillager");

        // Advancements for Killing Pillager Brute
        AdvancementEntry pillagerBruteAdvancement = Advancement.Builder.create()
                .parent(magiciteWeaponAdvancement)
                .display(
                        ModItems.PILLAGER_BRUTE_BOSS_SPAWN_EGG,
                        Text.literal("Free The Contested Lands"),
                        Text.literal("Kill a Pillager Brute Boss"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true)
                .criterion("killed_brute_pillager", OnKilledCriterion.Conditions.createPlayerKilledEntity(
                        EntityPredicate.Builder.create().type(ModEntities.PILLAGER_BRUTE_BOSS)))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/killed_brute_pillager");

        // Advancements for Killing Pillager Wizard
        AdvancementEntry pillagerWizardAdvancement = Advancement.Builder.create()
                .parent(pillageriteWeaponAdvancement)
                .display(
                        ModItems.PILLAGER_BRUTE_BOSS_SPAWN_EGG,
                        Text.literal("You Aren't A Wizard Harry"),
                        Text.literal("Kill a Pillager Wizard Boss"),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true)
                .criterion("killed_wizard_pillager", OnKilledCriterion.Conditions.createPlayerKilledEntity(
                        EntityPredicate.Builder.create().type(ModEntities.PILLAGER_WIZARD_BOSS)))
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/killed_wizard_pillager");
    }
}
