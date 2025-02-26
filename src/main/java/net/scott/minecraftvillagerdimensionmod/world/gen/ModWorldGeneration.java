package net.scott.minecraftvillagerdimensionmod.world.gen;


public class ModWorldGeneration {
    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModEntitySpawns.addSpawns();
    }
}
