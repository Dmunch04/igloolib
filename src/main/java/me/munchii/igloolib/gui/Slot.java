package me.munchii.igloolib.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Slot {
    private ItemStack stack;
    private int amount;

    public Slot(Material type) {
        this(new ItemStack(type, 1));
    }

    public Slot(ItemStack stack) {
        this.stack = stack;
        this.amount = stack.getAmount();
    }

    public abstract InventoryActionResult onClick(ClickType type, Player player, Inventory inventory, int slot);

    public ItemStack getStack() {
        return stack;
    }

    public int getAmount() {
        return amount;
    }
}
