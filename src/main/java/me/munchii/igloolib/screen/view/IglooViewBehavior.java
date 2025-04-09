package me.munchii.igloolib.screen.view;

import org.bukkit.inventory.InventoryView;

public interface IglooViewBehavior {
    IglooView getView();
    InventoryView getInventoryView();

    void update();

    @FunctionalInterface
    interface IglooViewBehaviorFactory<T extends IglooViewBehavior> {
        T create(IglooView view, InventoryView inventoryView);
    }
}
