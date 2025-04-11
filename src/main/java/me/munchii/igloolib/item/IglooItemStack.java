package me.munchii.igloolib.item;

import me.munchii.igloolib.NMSProvider;
import me.munchii.igloolib.block.IglooBlock;
import me.munchii.igloolib.nms.NbtCompound;
import net.minecraft.world.item.ItemStack;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public final class IglooItemStack {
    private final ItemStack nmsStack;
    @Nullable
    private NbtCompound nbtCompound;

    public IglooItemStack(ItemStack stack) {
        this.nmsStack = stack;
    }

    public static IglooItemStack of(org.bukkit.inventory.ItemStack stack) {
        return new IglooItemStack(NMSProvider.ITEM_STACK.asNMSCopy(stack));
    }

    public static IglooItemStack of(Material material) {
        return new IglooItemStack(NMSProvider.ITEM_STACK.asNMSCopy(new org.bukkit.inventory.ItemStack(material)));
    }

    public static IglooItemStack of(IglooItem item) {
        return new IglooItemStack(null);
    }

    public static IglooItemStack of(IglooBlock block) {
        return of(block.asItem().getItem());
    }

    public String getMaterialId() {
        return NMSProvider.ITEM_STACK.getItem(nmsStack).toString();
    }

    public Material getMaterial() {
        return Material.matchMaterial(getMaterialId());
    }

    public int getAmount() {
        return NMSProvider.ITEM_STACK.getAmount(nmsStack);
    }

    public void setAmount(int amount) {
        NMSProvider.ITEM_STACK.setAmount(nmsStack, amount);
    }

    public void incrementAmount(int amount) {
        setAmount(getAmount() + amount);
    }

    public void decrementAmount(int amount) {
        incrementAmount(-amount);
    }

    public boolean isEmpty() {
        return NMSProvider.ITEM_STACK.isEmpty(nmsStack);
    }

    public boolean hasNbt() {
        return nbtCompound != null && !nbtCompound.isEmpty();
    }

    @Nullable
    public NbtCompound getNbt() {
        return nbtCompound;
    }

    public NbtCompound getOrCreateNbt() {
        if (nbtCompound == null) {
            nbtCompound = NbtCompound.of(nmsStack);
        }

        return nbtCompound;
    }

    public NbtCompound getOrCreateSubNbt(String key) {
        if (nbtCompound != null && nbtCompound.contains(key, 10)) {
            return nbtCompound.getCompound(key);
        } else {
            NbtCompound nbt = NbtCompound.empty();
            setSubNbt(key, nbt);
            return nbt;
        }
    }

    @Nullable
    public NbtCompound getSubNbt(String key) {
        return nbtCompound != null && nbtCompound.contains(key, 10) ? nbtCompound.getCompound(key) : null;
    }

    public void removeSubNbt(String key) {
        if (nbtCompound != null && nbtCompound.contains(key)) {
            nbtCompound.remove(key);
            if (nbtCompound.isEmpty()) {
                nbtCompound = null;
            }
        }
    }

    public void setNbt(@Nullable NbtCompound compound) {
        nbtCompound = compound;
    }

    public void setSubNbt(String key, NbtCompound nbtCompound) {
        // TODO: revisit; accept NBTBase so it can be set to anything?
        getOrCreateNbt().putCompound(key, nbtCompound);
    }

    private void prepare() {
        getOrCreateNbt();
        NMSProvider.ITEM_STACK.putNBT(nmsStack, nbtCompound != null ? nbtCompound.getCompound() : null);
    }

    public ItemStack asNMSStack() {
        prepare();
        return nmsStack;
    }

    public org.bukkit.inventory.ItemStack asBukkitStack() {
        prepare();
        return NMSProvider.ITEM_STACK.asBukkitCopy(nmsStack);
    }
}