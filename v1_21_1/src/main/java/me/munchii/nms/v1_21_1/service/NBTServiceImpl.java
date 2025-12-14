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
        nbt.a(key, value);
    }

    @Override
    public void putShort(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, short value) {
        nbt.a(key, value);
    }

    @Override
    public void putInt(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int value) {
        nbt.a(key, value);
    }

    @Override
    public void putLong(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, long value) {
        nbt.a(key, value);
    }

    @Override
    public void putUUID(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, UUID value) {
        nbt.a(key, value);
    }

    @Override
    public void putFloat(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, float value) {
        nbt.a(key, value);
    }

    @Override
    public void putDouble(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, double value) {
        nbt.a(key, value);
    }

    @Override
    public void putString(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, String value) {
        nbt.a(key, value);
    }

    @Override
    public void putByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, byte[] value) {
        nbt.a(key, value);
    }

    @Override
    public void putByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Byte> value) {
        nbt.a(key, value);
    }

    @Override
    public void putIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int[] value) {
        nbt.a(key, value);
    }

    @Override
    public void putIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Integer> value) {
        nbt.b(key, value);
    }

    @Override
    public void putLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, long[] value) {
        nbt.a(key, value);
    }

    @Override
    public void putLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Long> value) {
        nbt.c(key, value);
    }

    @Override
    public void putBoolean(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, boolean value) {
        nbt.a(key, value);
    }

    @Override
    public net.minecraft.nbt.@NotNull NBTTagCompound getCompound(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.p(key);
    }

    @Override
    public byte getByte(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.f(key);
    }

    @Override
    public short getShort(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.g(key);
    }

    @Override
    public int getInt(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.h(key);
    }

    @Override
    public long getLong(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.i(key);
    }

    @Override
    public @NotNull UUID getUUID(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.a(key);
    }

    @Override
    public float getFloat(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.j(key);
    }

    @Override
    public double getDouble(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.k(key);
    }

    @Override
    public @NotNull String getString(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.l(key);
    }

    @Override
    public byte[] getByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.m(key);
    }

    @Override
    public int[] getIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.n(key);
    }

    @Override
    public long[] getLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.o(key);
    }

    @Override
    public boolean getBoolean(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.q(key);
    }

    @Override
    public boolean hasKey(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return nbt.e(key);
    }

    @Override
    public boolean has(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int type) {
        return nbt.b(key, type);
    }

    @Override
    public Optional<net.minecraft.nbt.NBTBase> getBase(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        return hasKey(nbt, key) ? Optional.ofNullable(nbt.c(key)) : Optional.empty();
    }

    @Override
    public int getSize(net.minecraft.nbt.@NotNull NBTTagCompound nbt) {
        return nbt.f();
    }

    @Override
    public Set<String> getKeySet(net.minecraft.nbt.@NotNull NBTTagCompound nbt) {
        return nbt.e();
    }

    @Override
    public void remove(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key) {
        nbt.r(key);
    }

    @Override
    public boolean isEmpty(net.minecraft.nbt.@NotNull NBTTagCompound nbt) {
        return nbt.g();
    }

    @Override
    public net.minecraft.nbt.@NotNull NBTTagCompound copy(net.minecraft.nbt.@NotNull NBTTagCompound from, net.minecraft.nbt.@NotNull NBTTagCompound to) {
        return from.a(to);
    }
}
