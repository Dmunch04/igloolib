package me.munchii.igloolib.nms;

import me.munchii.igloolib.NMSProvider;
import me.munchii.igloolib.util.NBTUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.item.ItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_20_R2.persistence.CraftPersistentDataContainer;
import org.bukkit.craftbukkit.v1_20_R2.persistence.CraftPersistentDataTypeRegistry;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class NbtCompound {
    private NBTTagCompound compound;

    public NbtCompound() {
        this(new NBTTagCompound());
    }

    public NbtCompound(NBTTagCompound compound) {
        this.compound = compound;
    }

    public static NbtCompound of(ItemStack stack) {
        return new NbtCompound(NMSProvider.ITEM_STACK.getNBT(stack));
    }

    public static NbtCompound of(org.bukkit.inventory.ItemStack stack) {
        return new NbtCompound(NMSProvider.ITEM_STACK.getNBT(stack));
    }

    public static NbtCompound of(NbtCompound compound) {
        NbtCompound nbt = new NbtCompound();
        nbt.compound = NMSProvider.NBT.copy(compound.compound, nbt.compound);
        return nbt;
    }

    public void putCompound(String key, NbtCompound compound) {
        NMSProvider.NBT.putCompound(this.compound, key, compound.compound);
    }

    public void putCompound(String key, NBTTagCompound compound) {
        NMSProvider.NBT.putCompound(this.compound, key, compound);
    }

    public void putByte(String key, byte value) {
        NMSProvider.NBT.putByte(compound, key, value);
    }

    public void putShort(String key, short value) {
        NMSProvider.NBT.putShort(compound, key, value);
    }

    public void putInt(String key, int value) {
        NMSProvider.NBT.putInt(compound, key, value);
    }

    public void putLong(String key, long value) {
        NMSProvider.NBT.putLong(compound, key, value);
    }

    public void putUUID(String key, UUID value) {
        NMSProvider.NBT.putUUID(compound, key, value);
    }

    public void putFloat(String key, float value) {
        NMSProvider.NBT.putFloat(compound, key, value);
    }

    public void putDouble(String key, double value) {
        NMSProvider.NBT.putDouble(compound, key, value);
    }

    public void putString(String key, String value) {
        NMSProvider.NBT.putString(compound, key, value);
    }

    public void putByteArray(String key, byte[] value) {
        NMSProvider.NBT.putByteArray(compound, key, value);
    }

    public void putByteArray(String key, List<Byte> value) {
        NMSProvider.NBT.putByteArray(compound, key, value);
    }

    public void putIntArray(String key, int[] value) {
        NMSProvider.NBT.putIntArray(compound, key, value);
    }

    public void putIntArray(String key, List<Integer> value) {
        NMSProvider.NBT.putIntArray(compound, key, value);
    }

    public void putLongArray(String key, long[] value) {
        NMSProvider.NBT.putLongArray(compound, key, value);
    }

    public void putLongArray(String key, List<Long> value) {
        NMSProvider.NBT.putLongArray(compound, key, value);
    }

    public void putBoolean(String key, boolean value) {
        NMSProvider.NBT.putBoolean(compound, key, value);
    }

    public NbtCompound getCompound(String key) {
        return new NbtCompound(NMSProvider.NBT.getCompound(compound, key));
    }

    public NBTTagCompound getRawCompound(String key) {
        return NMSProvider.NBT.getCompound(compound, key);
    }

    public byte getByte(String key) {
        return NMSProvider.NBT.getByte(compound, key);
    }

    public short getShort(String key) {
        return NMSProvider.NBT.getShort(compound, key);
    }

    public int getInt(String key) {
        return NMSProvider.NBT.getInt(compound, key);
    }

    public long getLong(String key) {
        return NMSProvider.NBT.getLong(compound, key);
    }

    public UUID getUUID(String key) {
        return NMSProvider.NBT.getUUID(compound, key);
    }

    public float getFloat(String key) {
        return NMSProvider.NBT.getFloat(compound, key);
    }

    public double getDouble(String key) {
        return NMSProvider.NBT.getDouble(compound, key);
    }

    public String getString(String key) {
        return NMSProvider.NBT.getString(compound, key);
    }

    public byte[] getByteArray(String key) {
        return NMSProvider.NBT.getByteArray(compound, key);
    }

    public int[] getIntArray(String key) {
        return NMSProvider.NBT.getIntArray(compound, key);
    }

    public long[] getLongArray(String key) {
        return NMSProvider.NBT.getLongArray(compound, key);
    }

    public boolean getBoolean(String key) {
        return NMSProvider.NBT.getBoolean(compound, key);
    }

    public boolean contains(String key) {
        return NMSProvider.NBT.hasKey(compound, key);
    }

    public boolean contains(String key, int type) {
        return NMSProvider.NBT.has(compound, key, type);
    }

    public void remove(String key) {
        NMSProvider.NBT.remove(compound, key);
    }

    public int size() {
        return NMSProvider.NBT.getSize(compound);
    }

    public Set<String> keySet() {
        return NMSProvider.NBT.getKeySet(compound);
    }

    public void copyFrom(NbtCompound compound) {
        this.compound = NMSProvider.NBT.copy(this.compound, compound.compound);
    }

    public void copyFrom(NBTTagCompound compound) {
        this.compound = NMSProvider.NBT.copy(this.compound, compound);
    }

    public void copyInto(@NotNull ItemMeta meta) {
        ((CraftPersistentDataContainer) meta.getPersistentDataContainer()).putAll(getCompound());
    }

    public boolean isEmpty() {
        return NMSProvider.NBT.isEmpty(compound);
    }

    public NBTTagCompound getCompound() {
        return compound;
    }

    public CraftPersistentDataContainer toPersistentDataContainer() {
        CraftPersistentDataContainer pdc = new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
        pdc.putAll(compound);

        return pdc;
    }
}