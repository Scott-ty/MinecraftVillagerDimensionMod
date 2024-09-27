package net.scott.minecraftvillagerdimensionmod.item.custom;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;
import net.scott.minecraftvillagerdimensionmod.util.ModTags;

import java.util.function.Supplier;

public class PillageriteToolMaterial {
    public enum pillageriteToolMaterial implements ToolMaterial{
        PILLAGERITE_INGOT(
                2750,
                12.0F,
                7.2F,
                16,
                ModTags.Blocks.INCORRECT_FOR_PILLAGERITE_TOOL,
                () -> Ingredient.ofItems(ModItems.PILLAGERITE_INGOT));

        private final TagKey<Block> inverseTag;
        private final int itemDurability;
        private final float miningSpeed;
        private final float attackDamage;
        private final int enchantability;
        private final Supplier<Ingredient> repairIngredient;

        pillageriteToolMaterial(int itemDurability, float miningSpeed, float attackDamage, int enchantability, TagKey<Block> inverseTag, Supplier<Ingredient> repairIngredient){
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
