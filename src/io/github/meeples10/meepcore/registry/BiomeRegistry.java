package io.github.meeples10.meepcore.registry;

import java.util.HashMap;
import java.util.Map;

public class BiomeRegistry {
    public static final Map<String, String> BIOMES = new HashMap<String, String>();
    static {
        BIOMES.put("0", "minecraft:ocean");
        BIOMES.put("1", "minecraft:plains");
        BIOMES.put("2", "minecraft:desert");
        BIOMES.put("3", "minecraft:mountains");
        BIOMES.put("4", "minecraft:forest");
        BIOMES.put("5", "minecraft:taiga");
        BIOMES.put("6", "minecraft:swamp");
        BIOMES.put("7", "minecraft:river");
        BIOMES.put("8", "minecraft:nether");
        BIOMES.put("9", "minecraft:the_end");
        BIOMES.put("10", "minecraft:frozen_ocean");
        BIOMES.put("11", "minecraft:frozen_river");
        BIOMES.put("12", "minecraft:snowy_tundra");
        BIOMES.put("13", "minecraft:snowy_mountains");
        BIOMES.put("14", "minecraft:mushroom_fields");
        BIOMES.put("15", "minecraft:mushroom_field_shore");
        BIOMES.put("16", "minecraft:beach");
        BIOMES.put("17", "minecraft:desert_hills");
        BIOMES.put("18", "minecraft:wooded_hills");
        BIOMES.put("19", "minecraft:taiga_hills");
        BIOMES.put("20", "minecraft:mountain_edge");
        BIOMES.put("21", "minecraft:jungle");
        BIOMES.put("22", "minecraft:jungle_hills");
        BIOMES.put("23", "minecraft:jungle_edge");
        BIOMES.put("24", "minecraft:deep_ocean");
        BIOMES.put("25", "minecraft:stone_shore");
        BIOMES.put("26", "minecraft:snowy_beach");
        BIOMES.put("27", "minecraft:birch_forest");
        BIOMES.put("28", "minecraft:birch_forest_hills");
        BIOMES.put("29", "minecraft:dark_forest");
        BIOMES.put("30", "minecraft:snowy_taiga");
        BIOMES.put("31", "minecraft:snowy_taiga_hills");
        BIOMES.put("32", "minecraft:giant_tree_taiga");
        BIOMES.put("33", "minecraft:giant_tree_taiga_hills");
        BIOMES.put("34", "minecraft:wooded_mountains");
        BIOMES.put("35", "minecraft:savanna");
        BIOMES.put("36", "minecraft:savanna_plateau");
        BIOMES.put("37", "minecraft:badlands");
        BIOMES.put("38", "minecraft:wooded_badlands_plateau");
        BIOMES.put("39", "minecraft:badlands_plateau");
        BIOMES.put("40", "minecraft:small_end_islands");
        BIOMES.put("41", "minecraft:end_midlands");
        BIOMES.put("42", "minecraft:end_highlands");
        BIOMES.put("43", "minecraft:end_barrens");
        BIOMES.put("44", "minecraft:warm_ocean");
        BIOMES.put("45", "minecraft:lukewarm_ocean");
        BIOMES.put("46", "minecraft:cold_ocean");
        BIOMES.put("47", "minecraft:deep_warm_ocean");
        BIOMES.put("48", "minecraft:deep_lukewarm_ocean");
        BIOMES.put("49", "minecraft:deep_cold_ocean");
        BIOMES.put("50", "minecraft:deep_frozen_ocean");
        BIOMES.put("127", "minecraft:the_void");
        BIOMES.put("129", "minecraft:sunflower_plains");
        BIOMES.put("130", "minecraft:the_void");
        BIOMES.put("131", "minecraft:gravelly_mountains");
        BIOMES.put("132", "minecraft:flower_forest");
        BIOMES.put("133", "minecraft:taiga_mountains");
        BIOMES.put("134", "minecraft:swamp_hills");
        BIOMES.put("140", "minecraft:ice_spikes");
        BIOMES.put("149", "minecraft:modified_jungle");
        BIOMES.put("151", "minecraft:modified_jungle_edge");
        BIOMES.put("155", "minecraft:tall_birch_forest");
        BIOMES.put("156", "minecraft:tall_birch_hills");
        BIOMES.put("157", "minecraft:dark_forest_hills");
        BIOMES.put("158", "minecraft:snowy_taiga_mountains");
        BIOMES.put("160", "minecraft:giant_spruce_taiga");
        BIOMES.put("161", "minecraft:giant_spruce_taiga_hills");
        BIOMES.put("162", "minecraft:modified_gravelly_mountains");
        BIOMES.put("163", "minecraft:shattered_savanna");
        BIOMES.put("164", "minecraft:shattered_savanna_plateau");
        BIOMES.put("165", "minecraft:eroded_badlands");
        BIOMES.put("166", "minecraft:modified_wooded_badlands_plateau");
        BIOMES.put("167", "minecraft:modified_badlands_plateau");
    }

    /**
     * @param id
     *            The numerical ID of the biome
     * @return The string ID of the biome, or null if no biome is found
     */
    public static String getByLegacyID(String id) {
        return BIOMES.get(id);
    }

    /**
     * @param id
     *            The string ID of the biome, e.g. {@code minecraft:ocean}
     * @return The numerical ID of the biome, or -1 if no biome is found
     */
    public static int getLegacyID(String id) {
        for(String s : BIOMES.keySet()) {
            if(BIOMES.get(id).equalsIgnoreCase(s)) {
                return Integer.parseInt(s);
            }
        }
        return -1;
    }
}