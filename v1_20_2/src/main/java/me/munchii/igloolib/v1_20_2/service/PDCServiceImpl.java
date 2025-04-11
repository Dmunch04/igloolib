package me.munchii.igloolib.v1_20_2.service;

import me.munchii.igloolib.nms.service.PDCService;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.craftbukkit.v1_20_R2.persistence.CraftPersistentDataContainer;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;

public class PDCServiceImpl implements PDCService {
    @Override
    public @NotNull NBTTagCompound toTagCompound(@NotNull PersistentDataContainer container) {
        return ((CraftPersistentDataContainer) container).toTagCompound();
    }
}
