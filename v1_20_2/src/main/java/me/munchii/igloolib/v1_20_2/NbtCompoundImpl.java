package me.munchii.igloolib.v1_20_2;

import me.munchii.igloolib.nms.FactoryHolder;
import me.munchii.igloolib.nms.NbtCompound;
import me.munchii.igloolib.nms.service.NBTService;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.craftbukkit.v1_20_R2.persistence.CraftPersistentDataContainer;
import org.bukkit.craftbukkit.v1_20_R2.persistence.CraftPersistentDataTypeRegistry;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class NbtCompoundImpl extends NbtCompound {
    private static final NBTService NBT = FactoryHolder.getFactory().createNBTService();

    @Override
    public void putCompound(@NotNull String key, @NotNull NbtCompound compound) {
        NBT.putCompound(this.compound, key, compound.getCompound());
    }

    @Override
    public void putCompound(@NotNull String key, @NotNull NBTTagCompound compound) {
        NBT.putCompound(this.compound, key, compound);
    }

    @Override
    public void putByte(@NotNull String key, byte value) {
        NBT.putByte(this.compound, key, value);
    }

    @Override
    public void putShort(@NotNull String key, short value) {
        NBT.putShort(this.compound, key, value);
    }

    @Override
    public void putInt(@NotNull String key, int value) {
        NBT.putInt(this.compound, key, value);
    }

    @Override
    public void putLong(@NotNull String key, long value) {
        NBT.putLong(this.compound, key, value);
    }

    @Override
    public void putUUID(@NotNull String key, @NotNull UUID uuid) {
        NBT.putUUID(this.compound, key, uuid);
    }

    @Override
    public void putFloat(@NotNull String key, float value) {
        NBT.putFloat(this.compound, key, value);
    }

    @Override
    public void putDouble(@NotNull String key, double value) {
        NBT.putDouble(this.compound, key, value);
    }

    @Override
    public void putString(@NotNull String key, @NotNull String value) {
        NBT.putString(this.compound, key, value);
    }

    @Override
    public void putByteArray(@NotNull String key, byte[] value) {
        NBT.putByteArray(this.compound, key, value);
    }

    @Override
    public void putByteArray(@NotNull String key, @NotNull List<Byte> value) {
        NBT.putByteArray(this.compound, key, value);
    }

    @Override
    public void putIntArray(@NotNull String key, int[] value) {
        NBT.putIntArray(this.compound, key, value);
    }

    @Override
    public void putIntArray(@NotNull String key, @NotNull List<Integer> value) {
        NBT.putIntArray(this.compound, key, value);
    }

    @Override
    public void putLongArray(@NotNull String key, long[] value) {
        NBT.putLongArray(this.compound, key, value);
    }

    @Override
    public void putLongArray(@NotNull String key, @NotNull List<Long> value) {
        NBT.putLongArray(this.compound, key, value);
    }

    @Override
    public void putBoolean(@NotNull String key, boolean value) {
        NBT.putBoolean(this.compound, key, value);
    }

    @Override
    public NbtCompound getCompound(@NotNull String key) {
        return NbtCompound.of(NBT.getCompound(this.compound, key));
    }

    @Override
    public @NotNull NBTTagCompound getRawCompound(@NotNull String key) {
        return NBT.getCompound(this.compound, key);
    }

    @Override
    public byte getByte(@NotNull String key) {
        return NBT.getByte(this.compound, key);
    }

    @Override
    public short getShort(@NotNull String key) {
        return NBT.getShort(this.compound, key);
    }

    @Override
    public int getInt(@NotNull String key) {
        return NBT.getInt(this.compound, key);
    }

    @Override
    public long getLong(@NotNull String key) {
        return NBT.getLong(this.compound, key);
    }

    @Override
    public @NotNull UUID getUUID(@NotNull String key) {
        return NBT.getUUID(this.compound, key);
    }

    @Override
    public float getFloat(@NotNull String key) {
        return NBT.getFloat(this.compound, key);
    }

    @Override
    public double getDouble(@NotNull String key) {
        return NBT.getDouble(this.compound, key);
    }

    @Override
    public @NotNull String getString(@NotNull String key) {
        return NBT.getString(this.compound, key);
    }

    @Override
    public byte[] getByteArray(@NotNull String key) {
        return NBT.getByteArray(this.compound, key);
    }

    @Override
    public int[] getIntArray(@NotNull String key) {
        return NBT.getIntArray(this.compound, key);
    }

    @Override
    public long[] getLongArray(@NotNull String key) {
        return NBT.getLongArray(this.compound, key);
    }

    @Override
    public boolean getBoolean(@NotNull String key) {
        return NBT.getBoolean(this.compound, key);
    }

    @Override
    public boolean contains(@NotNull String key) {
        return NBT.hasKey(this.compound, key);
    }

    @Override
    public boolean contains(@NotNull String key, int type) {
        return NBT.has(this.compound, key, type);
    }

    @Override
    public void remove(@NotNull String key) {
        NBT.remove(this.compound, key);
    }

    @Override
    public int size() {
        return NBT.getSize(this.compound);
    }

    @Override
    public @NotNull Set<String> keySet() {
        return NBT.getKeySet(this.compound);
    }

    @Override
    public void copyFrom(@NotNull NbtCompound compound) {
        this.compound = NBT.copy(this.compound, compound.getCompound());
    }

    @Override
    public void copyFrom(@NotNull NBTTagCompound compound) {
        this.compound = NBT.copy(this.compound, compound);
    }

    @Override
    public void copyInto(@NotNull ItemMeta itemMeta) {
        ((CraftPersistentDataContainer) itemMeta.getPersistentDataContainer())
                .putAll(this.compound);
    }

    @Override
    public boolean isEmpty() {
        return NBT.isEmpty(this.compound);
    }

    @Override
    public @NotNull NBTTagCompound getCompound() {
        return this.compound;
    }

    @Override
    public @NotNull PersistentDataContainer toPersistentDataContainer() {
        CraftPersistentDataContainer pdc = new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
        pdc.putAll(this.compound);

        return pdc;
    }
}
