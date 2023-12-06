package me.munchii.igloolib.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public interface IInventoryGUI extends InventoryHolder {
    void onClick(ClickType clickType, Player player, Inventory inventory, int slot);
}
