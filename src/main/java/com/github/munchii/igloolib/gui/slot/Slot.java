package com.github.munchii.igloolib.gui.slot;

import com.github.munchii.igloolib.gui.InventoryActionResult;
import com.github.munchii.igloolib.gui.InventoryClickEventContext;
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

    // TODO: allow for changing amount / material / stack?
    // ^ needs to be able to update realtime
    // so like Slot.setAmount(3); InventoryWindow.update();
    // maybe??
}
