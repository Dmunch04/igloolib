package me.munchii.igloolib.util;

import org.bukkit.Material;

public class SmeltingRecipe {
    public static final SmeltingRecipe BAKED_POTATO = new SmeltingRecipe(Material.POTATO, Material.BAKED_POTATO, 0.35f);
    public static final SmeltingRecipe DRIED_KELP = new SmeltingRecipe(Material.KELP, Material.DRIED_KELP, 0.1f);
    public static final SmeltingRecipe COOKED_BEEF = new SmeltingRecipe(Material.BEEF, Material.COOKED_BEEF, 0.35f);
    public static final SmeltingRecipe COOKED_PORKCHOP = new SmeltingRecipe(Material.PORKCHOP, Material.COOKED_PORKCHOP, 0.35f);
    public static final SmeltingRecipe COOKED_MUTTON = new SmeltingRecipe(Material.MUTTON, Material.COOKED_MUTTON, 0.35f);
    public static final SmeltingRecipe COOKED_CHICKEN = new SmeltingRecipe(Material.CHICKEN, Material.COOKED_CHICKEN, 0.35f);
    public static final SmeltingRecipe COOKED_RABBIT = new SmeltingRecipe(Material.RABBIT, Material.COOKED_RABBIT, 0.35f);
    public static final SmeltingRecipe COOKED_COD = new SmeltingRecipe(Material.COD, Material.COOKED_COD, 0.35f);
    public static final SmeltingRecipe COOKED_SALMON = new SmeltingRecipe(Material.SALMON, Material.COOKED_SALMON, 0.35f);

    public static final SmeltingRecipe IRON_INGOT = new SmeltingRecipe(Material.RAW_IRON, Material.IRON_INGOT, 0.7f);
    public static final SmeltingRecipe COPPER_INGOT = new SmeltingRecipe(Material.RAW_COPPER, Material.COPPER_INGOT, 0.7f);
    public static final SmeltingRecipe GOLD_INGOT = new SmeltingRecipe(Material.RAW_GOLD, Material.GOLD_INGOT, 1.0f);
    public static final SmeltingRecipe GOLD_INGOT_NETHER = new SmeltingRecipe(Material.NETHER_GOLD_ORE, Material.GOLD_INGOT, 1.0f);
    public static final SmeltingRecipe NETHERITE_SCRAP = new SmeltingRecipe(Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP, 2.0f);

    public static final SmeltingRecipe REDSTONE_DUST_ORE = new SmeltingRecipe(Material.REDSTONE_ORE, Material.REDSTONE, 0.3f);
    public static final SmeltingRecipe REDSTONE_DUST_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_REDSTONE_ORE, Material.REDSTONE, 0.3f);
    public static final SmeltingRecipe COAL_ORE = new SmeltingRecipe(Material.COAL_ORE, Material.COAL, 0.1f);
    public static final SmeltingRecipe COAL_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_COAL_ORE, Material.COAL, 0.1f);
    public static final SmeltingRecipe EMERALD_ORE = new SmeltingRecipe(Material.EMERALD_ORE, Material.EMERALD, 1.0f);
    public static final SmeltingRecipe EMERALD_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_EMERALD_ORE, Material.EMERALD, 1.0f);
    public static final SmeltingRecipe LAPIS_ORE = new SmeltingRecipe(Material.LAPIS_ORE, Material.LAPIS_LAZULI, 0.2f);
    public static final SmeltingRecipe LAPIS_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_LAPIS_ORE, Material.LAPIS_LAZULI, 0.2f);
    public static final SmeltingRecipe DIAMOND_ORE = new SmeltingRecipe(Material.DIAMOND_ORE, Material.DIAMOND, 1.0f);
    public static final SmeltingRecipe DIAMOND_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_DIAMOND_ORE, Material.DIAMOND, 1.0f);
    public static final SmeltingRecipe QUARTZ_ORE = new SmeltingRecipe(Material.NETHER_QUARTZ_ORE, Material.QUARTZ, 0.2f);
    public static final SmeltingRecipe IRON_INGOT_ORE = new SmeltingRecipe(Material.IRON_ORE, Material.IRON_INGOT, 0.7f);
    public static final SmeltingRecipe IRON_INGOT_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_IRON_ORE, Material.IRON_INGOT, 0.7f);
    public static final SmeltingRecipe COPPER_INGOT_ORE = new SmeltingRecipe(Material.COPPER_ORE, Material.COPPER_INGOT, 0.7f);
    public static final SmeltingRecipe COPPER_INGOT_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_COPPER_ORE, Material.COPPER_INGOT, 0.7f);
    public static final SmeltingRecipe GOLD_INGOT_ORE = new SmeltingRecipe(Material.GOLD_ORE, Material.GOLD_INGOT, 1.0f);
    public static final SmeltingRecipe GOLD_INGOT_ORE_DEEPSLATE = new SmeltingRecipe(Material.DEEPSLATE_GOLD_ORE, Material.GOLD_INGOT, 1.0f);

    public static final SmeltingRecipe[] DEFAULT_RECIPES = {
            BAKED_POTATO, DRIED_KELP, COOKED_BEEF, COOKED_PORKCHOP, COOKED_MUTTON, COOKED_CHICKEN, COOKED_RABBIT, COOKED_COD, COOKED_SALMON,
            IRON_INGOT, COPPER_INGOT, GOLD_INGOT, GOLD_INGOT_NETHER, NETHERITE_SCRAP,
            REDSTONE_DUST_ORE, REDSTONE_DUST_ORE_DEEPSLATE, COAL_ORE, COAL_ORE_DEEPSLATE, EMERALD_ORE, EMERALD_ORE_DEEPSLATE,
            LAPIS_ORE, LAPIS_ORE_DEEPSLATE, DIAMOND_ORE, DIAMOND_ORE_DEEPSLATE, QUARTZ_ORE, IRON_INGOT_ORE, IRON_INGOT_ORE_DEEPSLATE,
            COPPER_INGOT_ORE, COPPER_INGOT_ORE_DEEPSLATE, GOLD_INGOT_ORE, GOLD_INGOT_ORE_DEEPSLATE
    };

    public final Material ingredient;
    public final Material result;
    public final float experience;
    public final int cookingTime;

    public SmeltingRecipe(Material ingredient, Material result, float experience) {
        this(ingredient, result, experience, 200);
    }

    public SmeltingRecipe(Material ingredient, Material result, float experience, int cookingTime) {
        this.ingredient = ingredient;
        this.result = result;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public float getOperationCount() {
        return cookingTime / 200f;
    }

    public boolean canFinish(int totalBurnTime, int currentBurnTime) {
        return (totalBurnTime - currentBurnTime) >= cookingTime;
    }
}
