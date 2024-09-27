package net.scott.minecraftvillagerdimensionmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ANCIENT_GEMSTONE_TOOL = createTag("needs_ancient_gemstone_tool");
        public static final TagKey<Block> INCORRECT_FOR_ANCIENT_GEMSTONE_TOOL = TagKey.of(RegistryKeys.BLOCK, MinecraftVillagerDimensionMod.id(
                "incorrect_for_ancient_gemstone_tool"));

        public static final TagKey<Block> NEEDS_MAGICITE_TOOL = createTag("needs_magicite_tool");
        public static final TagKey<Block> INCORRECT_FOR_MAGICITE_TOOL = TagKey.of(RegistryKeys.BLOCK, MinecraftVillagerDimensionMod.id(
                "incorrect_for_magicite_tool"));

        public static final TagKey<Block> NEEDS_PILLAGERITE_TOOL = createTag("needs_pillagerite_tool");
        public static final TagKey<Block> INCORRECT_FOR_PILLAGERITE_TOOL = TagKey.of(RegistryKeys.BLOCK, MinecraftVillagerDimensionMod.id(
                "incorrect_for_pillagerite_tool"));

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name));
        }
    }
    public static class Items {
        //Not Used RN
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, name));
        }
    }
}
