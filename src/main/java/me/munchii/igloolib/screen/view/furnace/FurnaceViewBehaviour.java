package me.munchii.igloolib.screen.view.furnace;

import me.munchii.igloolib.screen.view.IglooView;
import me.munchii.igloolib.screen.view.IglooViewBehavior;
import org.bukkit.inventory.InventoryView;

public abstract class FurnaceViewBehaviour implements IglooViewBehavior {
    public final FurnaceView view;
    public final InventoryView inventoryView;

    public FurnaceViewBehaviour(final FurnaceView view, final InventoryView inventoryView) {
        this.view = view;
        this.inventoryView = inventoryView;
    }

    @Override
    public IglooView getView() {
        return view;
    }

    @Override
    public InventoryView getInventoryView() {
        return inventoryView;
    }
}
