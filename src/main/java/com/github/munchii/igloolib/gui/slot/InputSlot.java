package com.github.munchii.igloolib.gui.slot;

import com.github.munchii.igloolib.gui.InventoryActionResult;
import com.github.munchii.igloolib.gui.InventoryClickEventContext;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiFunction;

public class InputSlot extends Slot {
    private final BiFunction<InventoryClickEventContext, ItemStack, InventoryActionResult> callback;

    public InputSlot() {
        this((ctx, stack) -> InventoryActionResult.PASS);
    }

    public InputSlot(BiFunction<InventoryClickEventContext, ItemStack, InventoryActionResult> callback) {
        // TODO: does air work here?
        super(Material.AIR);

        this.callback = callback;
    }

    public InventoryActionResult onInput(InventoryClickEventContext context, ItemStack stack) {
        return callback.apply(context, stack);
    }

    @Override
    public InventoryActionResult onClick(InventoryClickEventContext context) {
        return InventoryActionResult.PASS;
    }
}
