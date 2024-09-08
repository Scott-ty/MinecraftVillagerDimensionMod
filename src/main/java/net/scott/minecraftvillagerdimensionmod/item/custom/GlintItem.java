package net.scott.minecraftvillagerdimensionmod.item.custom;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlintItem extends Item {

    public GlintItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        // Return true to always apply the glint effect
        return true; // or you can apply custom logic here
    }
}
