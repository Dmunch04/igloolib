package me.munchii.igloolib.nms;

import org.jetbrains.annotations.NotNull;

public interface NbtCompound {
    void putCompound(@NotNull String key, NbtCompound compound);

    void putCompound(@NotNull String key, net.minecraft.nbt.NBTTagCompound compound);
}
