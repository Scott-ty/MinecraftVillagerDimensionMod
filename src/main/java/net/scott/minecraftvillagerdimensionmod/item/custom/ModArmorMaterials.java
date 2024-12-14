package net.scott.minecraftvillagerdimensionmod.item.custom;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.scott.minecraftvillagerdimensionmod.MinecraftVillagerDimensionMod;
import net.scott.minecraftvillagerdimensionmod.item.ModItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    // ANCIENT GEMSTONE
    public static final RegistryEntry<ArmorMaterial> ANCIENT_GEMSTONE_DUST = register("ancient_gemstone_dust", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
        map.put(ArmorItem.Type.BODY, 12);
    }), 25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            2.5F,
            0.1F,
            () -> Ingredient.ofItems(ModItems.ANCIENT_GEMSTONE_DUST));


    // MAGICITE
    public static final RegistryEntry<ArmorMaterial> MAGICITE_DUST = register("magicite_dust", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 10);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 13);
            }), 30,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            3.0F,
            0.2F,
            () -> Ingredient.ofItems(ModItems.MAGICITE_DUST));


    // PILLAGERITE
    public static final RegistryEntry<ArmorMaterial> PILLAGERITE_INGOT = register("pillagerite_ingot", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 6);
                map.put(ArmorItem.Type.LEGGINGS, 9);
                map.put(ArmorItem.Type.CHESTPLATE, 11);
                map.put(ArmorItem.Type.HELMET, 6);
                map.put(ArmorItem.Type.BODY, 14);
            }), 25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            3.5F,
            0.3F,
            () -> Ingredient.ofItems(ModItems.PILLAGERITE_INGOT));

    // BOSS ARMOR
    public static final RegistryEntry<ArmorMaterial> BOSS_ARMOR = register("boss_armor", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 8);
                map.put(ArmorItem.Type.LEGGINGS, 11);
                map.put(ArmorItem.Type.CHESTPLATE, 13);
                map.put(ArmorItem.Type.HELMET, 8);
                map.put(ArmorItem.Type.BODY, 16);
            }), 30,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            4.5F,
            0.4F,
            Ingredient::empty); // No repair ingredient

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.of(MinecraftVillagerDimensionMod.MOD_ID, id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }

}
