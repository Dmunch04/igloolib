package me.munchii.igloolib.gui.slot;

import me.munchii.igloolib.gui.InventoryActionResult;
import me.munchii.igloolib.gui.InventoryClickEventContext;
import org.bukkit.Material;

public class InputSlot extends Slot {
    public InputSlot() {
        // TODO: does air work here?
        super(Material.AIR);
    }

    @Override
    public InventoryActionResult onClick(InventoryClickEventContext context) {
        return null;
    }
}
