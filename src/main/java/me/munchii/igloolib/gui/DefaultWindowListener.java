package me.munchii.igloolib.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class DefaultWindowListener implements Listener {
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if (event.getInventory().getHolder() instanceof IInventoryGUI) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() instanceof IInventoryGUI) {
            event.setCancelled(true);

            ((IInventoryGUI) event.getInventory().getHolder()).onClick(new InventoryClickEventContext(event.getClick(), (Player) event.getWhoClicked(), event.getInventory(), event.getRawSlot()));
        }
    }
}
