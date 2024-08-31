package net.scott.minecraftvillagerdimensionmod.item.custom;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

import java.util.function.Supplier;

public class AncientGemstoneToolMaterial {
    public enum ancientGemstoneToolMaterial implements ToolMaterial{
        ANCIENT_GEMSTONE_DUST(
                2032,
                8.3F,
                7.2F,
                15,
                BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
                () -> Ingredient.ofItems(ModItems.ANCIENT_GEMSTONE_DUST));

        private final TagKey<Block> inverseTag;
        private final int itemDurability;
        private final float miningSpeed;
        private final float attackDamage;
        private final int enchantability;
        private final Supplier<Ingredient> repairIngredient;

        ancientGemstoneToolMaterial(int itemDurability, float miningSpeed, float attackDamage, int enchantability, TagKey<Block> inverseTag, Supplier<Ingredient> repairIngredient){
            this.itemDurability = itemDurability;
            this.miningSpeed = miningSpeed;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.inverseTag = inverseTag;
            this.repairIngredient = Suppliers.memoize(repairIngredient::get);
        }

        @Override
        public int getDurability(){
            return this.itemDurability;
        }

        @Override
        public float getMiningSpeedMultiplier(){
            return this.miningSpeed;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public TagKey<Block> getInverseTag(){
            return this.inverseTag;
        }

        @Override
        public int getEnchantability(){
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairIngredient(){
            return this.repairIngredient.get();
        }
    }
}
