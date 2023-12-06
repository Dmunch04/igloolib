package me.munchii.igloolib.gui;

import me.munchii.igloolib.Igloolib;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InventoryWindow implements IInventoryGUI, Listener {
    private final Inventory inventory;

    private final Map<Integer, Slot> slots;
    private final String title;
    private final int rows;
    private final int columns;

    public InventoryWindow(String title, int rows, int columns) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Igloolib.INSTANCE);

        this.inventory = Bukkit.createInventory(null, rows * columns, title);
        this.slots = new HashMap<>();

        this.title = title;
        this.rows = rows;
        this.columns = columns;
    }

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

            ((IInventoryGUI) event.getInventory().getHolder()).onClick(event.getClick(), (Player) event.getWhoClicked(), event.getInventory(), event.getRawSlot());
        }
    }

    public void display(Player player) {
        slots.forEach((slotId, slot) -> inventory.setItem(slotId, slot.getStack()));

        player.openInventory(inventory);
    }

    @Override
    public void onClick(ClickType clickType, Player player, Inventory inventory, int slot) {
        if (slots.containsKey(slot)) {
            Slot slotItem = slots.get(slot);
            InventoryActionResult result = slotItem.onClick(clickType, player, inventory, slot);

            if (result == null) {
                return;
            }

            if (result == InventoryActionResult.CLOSE) {
                player.closeInventory();
            }
        }
    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return inventory;
    }

    public void fillVoidSlot(Material material) {
        ItemStack stack = new ItemStack(material, 1);
        stack.getItemMeta().setDisplayName(" ");
        fillVoidSlot(stack);
    }

    public void fillVoidSlot(ItemStack stack) {
        for (int i = 0; i < inventory.getSize(); i++) {
            setSlot(i, new Slot(stack) {
                @Override
                public InventoryActionResult onClick(ClickType type, Player player, Inventory inventory, int slot) {
                    return InventoryActionResult.PASS;
                }
            });
        }
    }

    public void setSlot(int slotId, Slot slot) {
        slots.put(slotId, slot);
    }

    public Optional<Slot> getSlot(int slotId) {
        return slots.containsKey(slotId) ? Optional.of(slots.get(slotId)) : Optional.empty();
    }
}
