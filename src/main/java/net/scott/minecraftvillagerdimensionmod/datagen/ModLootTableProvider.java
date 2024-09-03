package net.scott.minecraftvillagerdimensionmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ROWAN_LOG);
        addDrop(ModBlocks.ROWAN_WOOD);
        addDrop(ModBlocks.STRIPPED_ROWAN_WOOD);
        addDrop(ModBlocks.STRIPPED_ROWAN_LOG);
        addDrop(ModBlocks.ROWAN_PLANKS);
        // Change Log to sapling
        addDrop(ModBlocks.ROWAN_LEAVES, leavesDrops(ModBlocks.ROWAN_LEAVES, ModBlocks.ROWAN_LOG, 0.005f));

        addDrop(ModBlocks.STANDING_ROWAN_SIGN);
        addDrop(ModBlocks.WALL_ROWAN_SIGN);
        addDrop(ModBlocks.WALL_HANGING_ROWAN_SIGN);
        addDrop(ModBlocks.HANGING_ROWAN_SIGN);

        addDrop(ModBlocks.ROWAN_STAIRS);
        addDrop(ModBlocks.ROWAN_BUTTON);
        addDrop(ModBlocks.ROWAN_PRESSURE_PLATE);
        addDrop(ModBlocks.ROWAN_FENCE);
        addDrop(ModBlocks.ROWAN_FENCE_GATE);
        addDrop(ModBlocks.ROWAN_TRAPDOOR);

        addDrop(ModBlocks.ROWAN_DOOR, doorDrops(ModBlocks.ROWAN_DOOR));
        addDrop(ModBlocks.ROWAN_SLAB, slabDrops(ModBlocks.ROWAN_SLAB));

    }
}