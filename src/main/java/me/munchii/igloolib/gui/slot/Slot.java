package me.munchii.igloolib.gui.slot;

import me.munchii.igloolib.gui.InventoryActionResult;
import me.munchii.igloolib.gui.InventoryClickEventContext;
import org.bukkit.Material;
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

    public abstract InventoryActionResult onClick(InventoryClickEventContext context);

    public ItemStack getStack() {
        return stack;
    }

    public int getAmount() {
        return amount;
    }
}
