package me.munchii.igloolib.gui.slot;

import me.munchii.igloolib.gui.InventoryActionResult;
import me.munchii.igloolib.gui.InventoryClickEventContext;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class InputSlot extends Slot {
    public InputSlot() {
        // TODO: does air work here?
        super(Material.AIR);
    }

    public abstract InventoryActionResult onInput(InventoryClickEventContext context, ItemStack stack);
}
