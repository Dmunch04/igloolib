package me.munchii.igloolib.nms;

import me.munchii.igloolib.nms.service.ItemStackService;
import me.munchii.igloolib.nms.service.NBTService;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public abstract class NbtCompound {
    private static final NBTService NBT = FactoryHolder.getFactory().createNBTService();
    private static final ItemStackService ITEM_STACK = FactoryHolder.getFactory().createItemStackService();

    protected net.minecraft.nbt.NBTTagCompound compound;

    public NbtCompound() {
        this.compound = new net.minecraft.nbt.NBTTagCompound();
    }

    public NbtCompound(net.minecraft.nbt.NBTTagCompound compound) {
        this.compound = compound;
    }

    public static NbtCompound empty() {
        return FactoryHolder.getFactory().createNbtCompound();
    }

    public static NbtCompound of(org.bukkit.inventory.@NotNull ItemStack stack) {
        return FactoryHolder.getFactory().createNbtCompound(ITEM_STACK.getNBT(stack));
    }

    public static NbtCompound of(net.minecraft.world.item.@NotNull ItemStack stack) {
        return FactoryHolder.getFactory().createNbtCompound(ITEM_STACK.getNBT(stack));
    }

    public static NbtCompound of(NbtCompound compound) {
        return FactoryHolder.getFactory().createNbtCompound(compound.compound);
    }

    public static NbtCompound of(net.minecraft.nbt.NBTTagCompound compound) {
        return FactoryHolder.getFactory().createNbtCompound(compound);
    }

    public abstract void putCompound(@NotNull String key, @NotNull NbtCompound compound);
    public abstract void putCompound(@NotNull String key, net.minecraft.nbt.@NotNull NBTTagCompound compound);

    public abstract void putByte(@NotNull String key, byte value);

    public abstract void putShort(@NotNull String key, short value);

    public abstract void putInt(@NotNull String key, int value);

    public abstract void putLong(@NotNull String key, long value);

    public abstract void putUUID(@NotNull String key, @NotNull UUID uuid);

    public abstract void putFloat(@NotNull String key, float value);

    public abstract void putDouble(@NotNull String key, double value);

    public abstract void putString(@NotNull String key, @NotNull String value);

    public abstract void putByteArray(@NotNull String key, byte[] value);

    public abstract void putByteArray(@NotNull String key, @NotNull List<Byte> value);

    public abstract void putIntArray(@NotNull String key, int[] value);

    public abstract void putIntArray(@NotNull String key, @NotNull List<Integer> value);

    public abstract void putLongArray(@NotNull String key, long[] value);

    public abstract void putLongArray(@NotNull String key, @NotNull List<Long> value);

    public abstract void putBoolean(@NotNull String key, boolean value);

    public abstract NbtCompound getCompound(@NotNull String key);

    public abstract net.minecraft.nbt.@NotNull NBTTagCompound getRawCompound(@NotNull String key);

    public abstract byte getByte(@NotNull String key);

    public abstract short getShort(@NotNull String key);

    public abstract int getInt(@NotNull String key);

    public abstract long getLong(@NotNull String key);

    public abstract @NotNull UUID getUUID(@NotNull String key);

    public abstract float getFloat(@NotNull String key);

    public abstract double getDouble(@NotNull String key);

    public abstract @NotNull String getString(@NotNull String key);

    public abstract byte[] getByteArray(@NotNull String key);

    public abstract int[] getIntArray(@NotNull String key);

    public abstract long[] getLongArray(@NotNull String key);

    public abstract boolean getBoolean(@NotNull String key);

    public abstract boolean contains(@NotNull String key);

    public abstract boolean contains(@NotNull String key, int type);

    public abstract void remove(@NotNull String key);

    public abstract int size();

    public abstract @NotNull Set<String> keySet();

    public abstract void copyFrom(@NotNull NbtCompound compound);

    public abstract void copyFrom(net.minecraft.nbt.@NotNull NBTTagCompound compound);

    public abstract void copyInto(org.bukkit.inventory.meta.@NotNull ItemMeta itemMeta);

    public abstract boolean isEmpty();

    public abstract net.minecraft.nbt.@NotNull NBTTagCompound getCompound();

    public abstract @NotNull PersistentDataContainer toPersistentDataContainer();
}
