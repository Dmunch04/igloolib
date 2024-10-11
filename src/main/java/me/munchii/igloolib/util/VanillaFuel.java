package me.munchii.igloolib.util;

import org.bukkit.Material;

import java.util.Set;

public enum VanillaFuel {
    LAVA_BUCKET(Material.LAVA_BUCKET, 20000, 100),
    COAL_BLOCK(Material.COAL_BLOCK, 16000, 80),
    DRIED_KELP_BLOCK(Material.DRIED_KELP_BLOCK, 4000, 20),
    BLAZE_ROD(Material.BLAZE_ROD, 2400, 12),
    COAL(Material.COAL, 1600, 8),
    CHARCOAL(Material.CHARCOAL, 1600, 8),
    BOAT(Set.of(Material.ACACIA_BOAT, Material.BIRCH_BOAT, Material.CHERRY_BOAT, Material.DARK_OAK_BOAT, Material.JUNGLE_BOAT, Material.MANGROVE_BOAT, Material.OAK_BOAT, Material.SPRUCE_BOAT), 1200, 6),
    CHEST_BOAT(Set.of(Material.ACACIA_CHEST_BOAT, Material.BIRCH_CHEST_BOAT, Material.CHERRY_CHEST_BOAT, Material.DARK_OAK_CHEST_BOAT, Material.JUNGLE_CHEST_BOAT, Material.MANGROVE_CHEST_BOAT, Material.OAK_CHEST_BOAT, Material.SPRUCE_CHEST_BOAT), 1200, 6),
    BAMBOO_MOSAIC(Set.of(Material.BAMBOO_MOSAIC, Material.BAMBOO_MOSAIC_STAIRS), 300, 1.5f),
    CHISELED_BOOKSHELF(Material.CHISELED_BOOKSHELF, 300, 1.5f),
    BAMBOO_BLOCK(Set.of(Material.BAMBOO_BLOCK, Material.STRIPPED_BAMBOO_BLOCK), 300, 1.5f),
    LOG(Set.of(Material.ACACIA_LOG, Material.BIRCH_LOG, Material.CHERRY_LOG, Material.DARK_OAK_LOG, Material.JUNGLE_LOG, Material.MANGROVE_LOG, Material.OAK_LOG, Material.SPRUCE_LOG), 300, 1.5f),
    STRIPPED_LOG(Set.of(Material.STRIPPED_ACACIA_LOG, Material.STRIPPED_BIRCH_LOG, Material.STRIPPED_CHERRY_LOG, Material.STRIPPED_DARK_OAK_LOG, Material.STRIPPED_JUNGLE_LOG, Material.STRIPPED_MANGROVE_LOG, Material.STRIPPED_OAK_LOG, Material.STRIPPED_SPRUCE_LOG), 300, 1.5f),
    WOOD(Set.of(Material.ACACIA_WOOD, Material.BIRCH_WOOD, Material.CHERRY_WOOD, Material.DARK_OAK_WOOD, Material.JUNGLE_WOOD, Material.MANGROVE_WOOD, Material.OAK_WOOD, Material.SPRUCE_WOOD), 300, 1.5f),
    STRIPPED_WOOD(Set.of(Material.STRIPPED_ACACIA_WOOD, Material.STRIPPED_BIRCH_WOOD, Material.STRIPPED_CHERRY_WOOD, Material.STRIPPED_DARK_OAK_WOOD, Material.STRIPPED_JUNGLE_WOOD, Material.STRIPPED_MANGROVE_WOOD, Material.STRIPPED_OAK_WOOD, Material.STRIPPED_SPRUCE_WOOD), 300, 1.5f),
    PLANKS(Set.of(Material.ACACIA_PLANKS, Material.BIRCH_PLANKS, Material.CHERRY_PLANKS, Material.DARK_OAK_PLANKS, Material.JUNGLE_PLANKS, Material.MANGROVE_PLANKS, Material.OAK_PLANKS, Material.SPRUCE_PLANKS), 300, 1.5f),
    SLABS(Set.of(Material.BAMBOO_MOSAIC_SLAB, Material.ACACIA_SLAB, Material.BIRCH_SLAB, Material.CHERRY_SLAB, Material.DARK_OAK_SLAB, Material.JUNGLE_SLAB, Material.MANGROVE_SLAB, Material.OAK_SLAB, Material.SPRUCE_SLAB), 150, 0.75f),
    ;

    private final Set<Material> fuelType;
    private final int burnTime;
    private final float smeltOperations;

    VanillaFuel(final Material fuelType, final int burnTime, final float smeltOperations) {
        this.fuelType = Set.of(fuelType);
        this.burnTime = burnTime;
        this.smeltOperations = smeltOperations;
    }

    VanillaFuel(final Set<Material> fuelType, final int burnTime, final float smeltOperations) {
        this.fuelType = fuelType;
        this.burnTime = burnTime;
        this.smeltOperations = smeltOperations;
    }

    public static int getBurnTime(Material material) {
        for (VanillaFuel fuel : values()) {
            if (fuel.fuelType.contains(material)) {
                return fuel.burnTime;
            }
        }

        return 0;
    }
}
