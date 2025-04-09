package me.munchii.igloolib.screen.view;

import me.munchii.igloolib.player.IglooPlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IglooView {
    InventoryView open(@NotNull IglooPlayer player);

    void close(@NotNull IglooPlayer player);

    @ApiStatus.Internal
    void update();

    Inventory getInventory();

    @NotNull
    List<HumanEntity> getViewers();
}
