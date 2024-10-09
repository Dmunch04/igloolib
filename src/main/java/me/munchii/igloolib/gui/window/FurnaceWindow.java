package me.munchii.igloolib.gui.window;

import me.munchii.igloolib.nms.IglooItemStack;
import me.munchii.igloolib.player.IglooPlayer;
import me.munchii.igloolib.util.Chat;
import me.munchii.igloolib.util.TaskManager;
import me.munchii.igloolib.util.TimeUnit;
import me.munchii.igloolib.util.VanillaFuel;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public final class FurnaceWindow implements IglooWindow {
    private String title;
    private final Consumer<FurnaceWindow> tickTask;
    private FurnaceInventory inventory;
    private BiFunction<FurnaceWindow, InventoryView, FurnaceBehavior> behaviorSupplier = VanillaFurnaceBehavior::new;

    private boolean isBurning = false;
    private boolean isSmelting = false;

    public FurnaceWindow(String title) {
        this(title, window -> {});
    }

    public FurnaceWindow(String title, Consumer<FurnaceWindow> tickTask) {
        this.title = Chat.color(title);
        this.tickTask = tickTask;
        this.inventory = createInventory();
    }

    public void setDisplayName(String title) {
        this.title = Chat.color(title);
        this.inventory = createInventory();
    }

    @Override
    public String getDisplayName() {
        return title;
    }

    public void setCustomBehavior(@NotNull BiFunction<FurnaceWindow, InventoryView, FurnaceBehavior> behaviorSupplier) {
        this.behaviorSupplier = behaviorSupplier;
    }

    @Override
    public InventoryView open(@NotNull IglooPlayer player) {
        //update();

        InventoryView view = player.openInventory(inventory);
        FurnaceBehavior behavior = behaviorSupplier.apply(this, view);

        TaskManager.registerRepeatingTask("FurnaceWindow_Tick_" + hashCode(), () -> {
            behavior.tick();
            tickTask.accept(this);
        }, 1, 1, TimeUnit.TICK);

        return view;
    }

    @Override
    public void close(@NotNull IglooPlayer player) {
        TaskManager.removeTask("FurnaceWindow_Tick_" + hashCode());
    }

    @Override
    public void update() {
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @NotNull
    public IglooItemStack getInputSlot() {
        ItemStack stack = inventory.getSmelting();
        return stack == null ? IglooItemStack.of(Material.AIR) : IglooItemStack.of(stack);
    }

    public void setInput(@Nullable ItemStack stack) {
        inventory.setSmelting(stack);
    }

    @NotNull
    public IglooItemStack getFuelSlot() {
        ItemStack stack = inventory.getFuel();
        return stack == null ? IglooItemStack.of(Material.AIR) : IglooItemStack.of(stack);
    }

    public void setFuel(@Nullable ItemStack stack) {
        inventory.setFuel(stack);
    }

    @NotNull
    public IglooItemStack getOutputSlot() {
        ItemStack stack = inventory.getResult();
        return stack == null ? IglooItemStack.of(Material.AIR) : IglooItemStack.of(stack);
    }

    public void setOutput(@Nullable ItemStack stack) {
        inventory.setResult(stack);
    }

    @NotNull
    public List<HumanEntity> getViewers() {
        return inventory.getViewers();
    }

    private FurnaceInventory createInventory() {
        return (FurnaceInventory) Bukkit.createInventory(this, InventoryType.FURNACE, title);
    }

    interface FurnaceBehavior {
        FurnaceWindow getWindow();
        InventoryView getView();

        void tick();

        void setBurnTime(int ticks);
        void setBurnProgress(int ticks);
        void setSmeltingTime(int ticks);
        void setSmeltingProgress(int ticks);
    }

    static class VanillaFurnaceBehavior implements FurnaceBehavior {
        FurnaceWindow window;
        InventoryView view;

        public VanillaFurnaceBehavior(FurnaceWindow window, InventoryView view) {
            this.window = window;
            this.view = view;
        }

        public FurnaceWindow getWindow() {
            return window;
        }

        public InventoryView getView() {
            return view;
        }

        public void tick() {
            if (!window.getInputSlot().isEmpty() && !window.getFuelSlot().isEmpty()) {
                int burnTime = VanillaFuel.getBurnTime(window.getFuelSlot().getMaterial());
                if (burnTime > 0) {
                    window.isBurning = true;
                    window.isSmelting = true;
                    setBurnTime(burnTime);
                    setBurnProgress(0);

                    // TODO: check input slot for recipe
                }
            }
            // if burning but input has been removed

            // if smelting but no fuel is there after running out

            // more cases?
        }

        public void setBurnTime(int ticks) {
            // total fuel burn time
            view.setProperty(InventoryView.Property.TICKS_FOR_CURRENT_FUEL, ticks);
        }

        public void setBurnProgress(int ticks) {
            // current fuel burn time progress
            view.setProperty(InventoryView.Property.BURN_TIME, ticks);
        }

        public void setSmeltingTime(int ticks) {
            // total smelt time
            view.setProperty(InventoryView.Property.TICKS_FOR_CURRENT_SMELTING, ticks);
        }

        public void setSmeltingProgress(int ticks) {
            // current smelt time progress
            view.setProperty(InventoryView.Property.COOK_TIME, ticks);
        }
    }
}
