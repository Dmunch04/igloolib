package me.munchii.igloolib.gui.window;

import me.munchii.igloolib.player.IglooPlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

// we should not use inventory holder. store the created inventory instead, and match it in events
// https://www.spigotmc.org/threads/null-point-error-on-inventory-click-event.491301/#post-4093639
public interface IglooWindow {
    String getDisplayName();

    InventoryView open(@NotNull IglooPlayer player);

    void close(@NotNull IglooPlayer player);

    @ApiStatus.Internal
    void update();

    Inventory getInventory();

    @NotNull
    List<HumanEntity> getViewers();

    List<IglooWindow> OPEN_WINDOWS = new ArrayList<>();

    static void registerWindow(IglooWindow window) {
        OPEN_WINDOWS.add(window);
    }

    class IglooWindowListener implements Listener {
        @EventHandler
        public void onInventoryClose(InventoryCloseEvent event) {
            for (IglooWindow window : OPEN_WINDOWS) {
                if (window.getInventory().equals(event.getInventory())) {
                    window.close(IglooPlayer.get(event.getPlayer()));

                    if (window.getViewers().isEmpty() || (window.getViewers().size() == 1 && window.getViewers().get(0).equals(event.getPlayer()))) {
                        OPEN_WINDOWS.remove(window);
                    }

                    return;
                }
            }
        }
    }
}
