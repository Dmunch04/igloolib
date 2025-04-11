package me.munchii.igloolib.v1_20_2.service;

import me.munchii.igloolib.nms.service.NBTService;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class NBTServiceImpl implements NBTService {
    @Override
    public void putCompound(@NotNull NBTTagCompound nbt, @NotNull String key, NBTTagCompound value) {
        // #put(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putByte(@NotNull NBTTagCompound nbt, @NotNull String key, byte value) {
        // #putByte(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putShort(@NotNull NBTTagCompound nbt, @NotNull String key, short value) {
        // #putShort(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putInt(@NotNull NBTTagCompound nbt, @NotNull String key, int value) {
        // #putInt(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putLong(@NotNull NBTTagCompound nbt, @NotNull String key, long value) {
        // #putLong(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putUUID(@NotNull NBTTagCompound nbt, @NotNull String key, UUID value) {
        // #putUUID(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putFloat(@NotNull NBTTagCompound nbt, @NotNull String key, float value) {
        // #putFloat(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putDouble(@NotNull NBTTagCompound nbt, @NotNull String key, double value) {
        // #putDouble(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putString(@NotNull NBTTagCompound nbt, @NotNull String key, String value) {
        // #putString(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putByteArray(@NotNull NBTTagCompound nbt, @NotNull String key, byte[] value) {
        // #putByteArray(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putByteArray(@NotNull NBTTagCompound nbt, @NotNull String key, List<Byte> value) {
        // #putByteArray(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putIntArray(@NotNull NBTTagCompound nbt, @NotNull String key, int[] value) {
        // #putIntArray(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putIntArray(@NotNull NBTTagCompound nbt, @NotNull String key, List<Integer> value) {
        // #putIntArray(key, value);
        nbt.b(key, value);
    }

    @Override
    public void putLongArray(@NotNull NBTTagCompound nbt, @NotNull String key, long[] value) {
        // #putLongArray(key, value);
        nbt.a(key, value);
    }

    @Override
    public void putLongArray(@NotNull NBTTagCompound nbt, @NotNull String key, List<Long> value) {
        // #putLongArray(key, value);
        nbt.c(key, value);
    }

    @Override
    public void putBoolean(@NotNull NBTTagCompound nbt, @NotNull String key, boolean value) {
        // #putBoolean(key, value);
        nbt.a(key, value);
    }

    @Override
    public @NotNull NBTTagCompound getCompound(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getCompound(key);
        return nbt.p(key);
    }

    @Override
    public byte getByte(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getByte(key);
        return nbt.f(key);
    }

    @Override
    public short getShort(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getShort(key);
        return nbt.g(key);
    }

    @Override
    public int getInt(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getInt(key);
        return nbt.h(key);
    }

    @Override
    public long getLong(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getLong(key);
        return nbt.i(key);
    }

    @Override
    public @NotNull UUID getUUID(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getUUID(key);
        return nbt.a(key);
    }

    @Override
    public float getFloat(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getFloat(key);
        return nbt.j(key);
    }

    @Override
    public double getDouble(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getDouble(key);
        return nbt.k(key);
    }

    @Override
    public @NotNull String getString(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getString(key);
        return nbt.l(key);
    }

    @Override
    public byte[] getByteArray(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getByteArray(key);
        return nbt.m(key);
    }

    @Override
    public int[] getIntArray(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getIntArray(key);
        return nbt.n(key);
    }

    @Override
    public long[] getLongArray(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getLongArray(key);
        return nbt.o(key);
    }

    @Override
    public boolean getBoolean(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #getBoolean(key);
        return nbt.q(key);
    }

    @Override
    public boolean hasKey(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #contains(key);
        return nbt.e(key);
    }

    @Override
    public boolean has(@NotNull NBTTagCompound nbt, @NotNull String key, int type) {
        // #get(key);
        return nbt.b(key, type);
    }

    @Override
    public Optional<NBTBase> getBase(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #contains(key) ? #get(key) : ...
        return hasKey(nbt, key) ? Optional.ofNullable(nbt.c(key)) : Optional.empty();
    }

    @Override
    public int getSize(@NotNull NBTTagCompound nbt) {
        // #size();
        return nbt.f();
    }

    @Override
    public Set<String> getKeySet(@NotNull NBTTagCompound nbt) {
        // #getAllKeys();
        return nbt.e();
    }

    @Override
    public void remove(@NotNull NBTTagCompound nbt, @NotNull String key) {
        // #remove(key);
        nbt.r(key);
    }

    @Override
    public boolean isEmpty(@NotNull NBTTagCompound nbt) {
        // #isEmpty();
        return nbt.g();
    }

    @Override
    public @NotNull NBTTagCompound copy(@NotNull NBTTagCompound from, @NotNull NBTTagCompound to) {
        // #merge(to);
        return from.a(to);
    }
}
