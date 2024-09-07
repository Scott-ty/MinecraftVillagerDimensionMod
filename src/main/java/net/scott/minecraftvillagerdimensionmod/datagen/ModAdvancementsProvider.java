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
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {

    public ModAdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup id, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancementRowan = Advancement.Builder.create()
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
                    .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/root");

        AdvancementEntry rootAdvancementJuniper = Advancement.Builder.create()
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
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/root");

        AdvancementEntry rootAdvancementSycamore = Advancement.Builder.create()
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
                .build(consumer, MinecraftVillagerDimensionMod.MOD_ID + "/root");
    }
}