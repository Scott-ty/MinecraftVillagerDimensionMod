package net.scott.minecraftvillagerdimensionmod.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.block.ModBlocks;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

public class ModBoats {
    public static final Identifier ROWAN_BOAT_ID = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "rowan_boat");
    public static final Identifier ROWAN_CHEST_BOAT_ID = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "rowan_chest_boat");

    public static final RegistryKey<TerraformBoatType> ROWAN_BOAT_KEY = TerraformBoatTypeRegistry.createKey(ROWAN_BOAT_ID);


    public static final Identifier JUNIPER_BOAT_ID = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "juniper_boat");
    public static final Identifier JUNIPER_CHEST_BOAT_ID = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "juniper_chest_boat");

    public static final RegistryKey<TerraformBoatType> JUNIPER_BOAT_KEY = TerraformBoatTypeRegistry.createKey(JUNIPER_BOAT_ID);


    public static final Identifier SYCAMORE_BOAT_ID = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "sycamore_boat");
    public static final Identifier SYCAMORE_CHEST_BOAT_ID = Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, "sycamore_chest_boat");

    public static final RegistryKey<TerraformBoatType> SYCAMORE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(SYCAMORE_BOAT_ID);


    public static void registerBoats(){
        TerraformBoatType rowanBoat = new TerraformBoatType.Builder()
                .item(ModItems.ROWAN_BOAT)
                .chestItem(ModItems.ROWAN_CHEST_BOAT)
                .planks(ModBlocks.ROWAN_PLANKS.asItem())
                .build();

        TerraformBoatType juniperBoat = new TerraformBoatType.Builder()
                .item(ModItems.JUNIPER_BOAT)
                .chestItem(ModItems.JUNIPER_CHEST_BOAT)
                .planks(ModBlocks.JUNIPER_PLANKS.asItem())
                .build();

        TerraformBoatType sycamoreBoat = new TerraformBoatType.Builder()
                .item(ModItems.SYCAMORE_BOAT)
                .chestItem(ModItems.SYCAMORE_CHEST_BOAT)
                .planks(ModBlocks.SYCAMORE_PLANKS.asItem())
                .build();


        Registry.register(TerraformBoatTypeRegistry.INSTANCE, ROWAN_BOAT_KEY, rowanBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, JUNIPER_BOAT_KEY, juniperBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, SYCAMORE_BOAT_KEY, sycamoreBoat);

    }
}
