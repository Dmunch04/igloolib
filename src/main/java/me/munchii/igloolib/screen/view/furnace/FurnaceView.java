package me.munchii.igloolib.screen.view.furnace;

import me.munchii.igloolib.player.IglooPlayer;
import me.munchii.igloolib.screen.view.IglooView;
import me.munchii.igloolib.screen.view.IglooViewBehavior;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FurnaceView implements IglooView {
    private final IglooViewBehavior.IglooViewBehaviorFactory<FurnaceViewBehaviour> behaviourFactory;

    public FurnaceView(IglooViewBehavior.IglooViewBehaviorFactory<FurnaceViewBehaviour> behaviourFactory) {
        this.behaviourFactory = behaviourFactory;
    }

    @Override
    public InventoryView open(@NotNull IglooPlayer player) {
        return null;
    }

    @Override
    public void close(@NotNull IglooPlayer player) {

    }

    @Override
    public void update() {

    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    @Override
    public @NotNull List<HumanEntity> getViewers() {
        return List.of();
    }
}
