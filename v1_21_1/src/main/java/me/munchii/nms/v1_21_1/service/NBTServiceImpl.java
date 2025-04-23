package me.munchii.nms.v1_21_1.service;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class NBTServiceImpl implements me.munchii.igloolib.nms.service.NBTService {
    @Override
    public void putCompound(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, net.minecraft.nbt.NBTTagCompound value) {
        nbt.a(key, value);
    }

    @Override
    public void putByte(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, byte value) {

    }

    @Override
    public void putShort(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, short value) {

    }

    @Override
    public void putInt(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int value) {

    }

    @Override
    public void putLong(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, long value) {

    }

    @Override
    public void putUUID(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, UUID value) {

    }

    @Override
    public void putFloat(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, float value) {

    }

    @Override
    public void putDouble(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, double value) {

    }

    @Override
    public void putString(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, String value) {

    }

    @Override
    public void putByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, byte[] value) {

    }

    @Override
    public void putByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Byte> value) {

    }

    @Override
    public void putIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int[] value) {

    }

    @Override
    public void putIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Integer> value) {

    }

    @Override
    public void putLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, long[] value) {

    }

    @Override
    public void putLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Long> value) {

    }

    @Override
    public void putBoolean(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, boolean value) {

    }

    @Override
    public net.minecraft.nbt.@NotNull NBTTagCompound getCompound(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return null;
    }

    @Override
    public byte getByte(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return 0;
    }

    @Override
    public short getShort(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return 0;
    }

    @Override
    public int getInt(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return 0;
    }

    @Override
    public long getLong(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return 0;
    }

    @Override
    public @NotNull UUID getUUID(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return null;
    }

    @Override
    public float getFloat(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return 0;
    }

    @Override
    public double getDouble(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return 0;
    }

    @Override
    public @NotNull String getString(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return "";
    }

    @Override
    public byte[] getByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return new byte[0];
    }

    @Override
    public int[] getIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return new int[0];
    }

    @Override
    public long[] getLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return new long[0];
    }

    @Override
    public boolean getBoolean(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return false;
    }

    @Override
    public boolean hasKey(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return false;
    }

    @Override
    public boolean has(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int type) {
        return false;
    }

    @Override
    public Optional<net.minecraft.nbt.NBTBase> getBase(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return Optional.empty();
    }

    @Override
    public int getSize(net.minecraft.nbt.@NotNull NBTTagCompound nbt) {
        return 0;
    }

    @Override
    public Set<String> getKeySet(net.minecraft.nbt.@NotNull NBTTagCompound nbt) {
        return Set.of();
    }

    @Override
    public void remove(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {

    }

    @Override
    public boolean isEmpty(net.minecraft.nbt.@NotNull NBTTagCompound nbt) {
        return false;
    }

    @Override
    public net.minecraft.nbt.@NotNull NBTTagCompound copy(net.minecraft.nbt.@NotNull NBTTagCompound from, net.minecraft.nbt.@NotNull NBTTagCompound to) {
        return null;
    }
}
