package me.munchii.igloolib.nms.service;

import org.jetbrains.annotations.NotNull;

public interface PDCService {
    /**
     * Converts the provided PersistentDataContainer into an NBTTagCompound.
     *
     * @param container the PersistentDataContainer to be converted into an NBTTagCompound
     * @return the resulting NBTTagCompound containing the data from the provided PersistentDataContainer
     */
    net.minecraft.nbt.@NotNull NBTTagCompound toTagCompound(org.bukkit.persistence.@NotNull PersistentDataContainer container);
}
