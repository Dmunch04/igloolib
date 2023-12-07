package me.munchii.igloolib.gui;

import me.munchii.igloolib.gui.slot.Slot;
import org.bukkit.inventory.InventoryHolder;

import java.util.Optional;

public interface IInventoryGUI extends InventoryHolder {
    void onClick(InventoryClickEventContext context);

    Optional<Slot> getSlot(int slotId);
}
