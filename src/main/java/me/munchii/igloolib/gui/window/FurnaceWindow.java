package me.munchii.igloolib.gui.window;

import me.munchii.igloolib.Igloolib;
import me.munchii.igloolib.item.IglooItemStack;
import me.munchii.igloolib.player.IglooPlayer;
import me.munchii.igloolib.util.*;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public final class FurnaceWindow implements IglooWindow {
    private final UUID uuid = UUID.randomUUID();
    private String title;
    private final Consumer<FurnaceWindow> tickTask;
    private FurnaceInventory inventory;
    private Inventory parentInventory;
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

        TaskManager.registerRepeatingTask("FurnaceWindow_Tick_" + uuid + "_" + player.getUniqueId(), () -> {
            behavior.tick();
            tickTask.accept(this);
        }, 1, 1, TimeUnit.TICK);

        IglooWindow.registerWindow(this);
        return view;
    }

    @Override
    public void close(@NotNull IglooPlayer player) {
        TaskManager.removeTask("FurnaceWindow_Tick_" + uuid + "_" + player.getUniqueId());
    }

    @Override
    public void update() {
    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return parentInventory;
    }

    @Override
    @NotNull
    public List<HumanEntity> getViewers() {
        return inventory.getViewers();
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

    private FurnaceInventory createInventory() {
        Inventory inv = Bukkit.createInventory(null, InventoryType.FURNACE, title);
        parentInventory = inv;
        return (FurnaceInventory) inv;
    }

    interface FurnaceBehavior {
        FurnaceWindow getWindow();
        InventoryView getView();

        void tick();

        void setBurnTime(int ticks);
        void setBurnProgress(int ticks);
        void setSmeltingTime(int ticks);
        void setSmeltingProgress(int ticks);

        boolean registerSmeltingRecipe(SmeltingRecipe recipe);
    }

    static class VanillaFurnaceBehavior implements FurnaceBehavior {
        FurnaceWindow window;
        InventoryView view;

        private List<SmeltingRecipe> customRecipes;
        private SmeltingRecipe currentRecipe;
        private int currentBurnTimeTotal;
        private int currentBurnTimeProgress;
        private int currentSmeltTimeTotal;
        private int currentSmeltTimeProgress;

        public VanillaFurnaceBehavior(FurnaceWindow window, InventoryView view) {
            this.window = window;
            this.view = view;
            this.customRecipes = new ArrayList<>();
        }

        public FurnaceWindow getWindow() {
            return window;
        }

        public InventoryView getView() {
            return view;
        }

        public void tick() {
            if (!window.getInputSlot().isEmpty() && !window.getFuelSlot().isEmpty()) {
                Igloolib.INSTANCE.getLogger().severe(window.getFuelSlot().getMaterialId());
                Igloolib.INSTANCE.getLogger().severe(window.getInputSlot().getMaterial().name());
                int burnTime = VanillaFuel.getBurnTime(window.getFuelSlot().getMaterial());
                Igloolib.INSTANCE.getLogger().severe(String.valueOf(burnTime));
                if (burnTime > 0) {
                    SmeltingRecipe recipe = findRecipe(window.getInputSlot().getMaterial());
                    Igloolib.INSTANCE.getLogger().severe(String.valueOf(recipe == null));
                    if (recipe != null) {
                        Igloolib.INSTANCE.getLogger().severe(recipe.result.name());
                        window.isBurning = true;
                        window.isSmelting = true;
                        currentRecipe = recipe;
                        setSmeltingTime(recipe.cookingTime);
                        setSmeltingProgress(0);
                        window.getFuelSlot().decrementAmount(1);
                        setBurnTime(burnTime);
                        setBurnProgress(burnTime);
                    }
                }
            } else if (window.getInputSlot().isEmpty() && window.isBurning) {
                window.isSmelting = false;
                currentRecipe = null;
                setSmeltingTime(0);
                setSmeltingProgress(0);
            } else if (window.isSmelting && !window.isBurning) {
                window.isSmelting = false;
                currentRecipe = null;
                reset();
            } else if (window.getFuelSlot().isEmpty() && window.isBurning) {

            }

            if (window.isBurning && currentBurnTimeProgress >= currentBurnTimeTotal) {
                window.isBurning = false;
                setBurnTime(0);
                setBurnProgress(0);
            }

            if (window.isSmelting && window.isBurning) {
                setBurnProgress(currentBurnTimeProgress - 1);
                setSmeltingProgress(currentSmeltTimeProgress + 1);

                if (currentSmeltTimeProgress >= currentSmeltTimeTotal) {
                    window.isSmelting = false;
                    window.getInputSlot().decrementAmount(1);
                    window.setOutput(new ItemStack(currentRecipe.result));
                }
            }
        }

        private void reset() {
            setBurnTime(0);
            setBurnProgress(0);
            setSmeltingTime(0);
            setSmeltingProgress(0);
        }

        public void setBurnTime(int ticks) {
            // total fuel burn time
            view.setProperty(InventoryView.Property.TICKS_FOR_CURRENT_FUEL, ticks);
            currentBurnTimeTotal = ticks;
        }

        public void setBurnProgress(int ticks) {
            // current fuel burn time progress
            view.setProperty(InventoryView.Property.BURN_TIME, ticks);
            currentBurnTimeProgress = ticks;
        }

        public void setSmeltingTime(int ticks) {
            // total smelt time
            view.setProperty(InventoryView.Property.TICKS_FOR_CURRENT_SMELTING, ticks);
            currentSmeltTimeTotal = ticks;
        }

        public void setSmeltingProgress(int ticks) {
            // current smelt time progress
            view.setProperty(InventoryView.Property.COOK_TIME, ticks);
            currentSmeltTimeProgress = ticks;
        }

        public boolean registerSmeltingRecipe(SmeltingRecipe recipe) {
            for (SmeltingRecipe r : SmeltingRecipe.DEFAULT_RECIPES) {
                if (r.ingredient.equals(recipe.ingredient)) {
                    return false;
                }
            }

            customRecipes.add(recipe);
            return true;
        }

        @Nullable
        private SmeltingRecipe findRecipe(Material ingredient) {
            for (SmeltingRecipe r : customRecipes) {
                if (r.ingredient.equals(ingredient)) {
                    return r;
                }
            }

            for (SmeltingRecipe r : SmeltingRecipe.DEFAULT_RECIPES) {
                if (r.ingredient.equals(ingredient)) {
                    return r;
                }
            }

            return null;
        }
    }
}
