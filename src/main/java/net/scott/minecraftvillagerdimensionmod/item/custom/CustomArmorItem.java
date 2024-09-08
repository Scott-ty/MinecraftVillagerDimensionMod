package net.scott.minecraftvillagerdimensionmod.item.custom;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

public class CustomArmorItem extends ArmorItem {

    public CustomArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Item.Settings settings) {
        super(material, type, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        // Always apply the glint effect
        return true;
    }
}