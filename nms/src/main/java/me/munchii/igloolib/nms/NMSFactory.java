package me.munchii.igloolib.nms;

import me.munchii.igloolib.nms.service.*;
import org.jetbrains.annotations.NotNull;

public interface NMSFactory {
    @NotNull NBTService createNBTService();
    @NotNull ItemStackService createItemStackService();
    @NotNull PDCService createPDCService();
    @NotNull CraftPlayerService createCraftPlayerService();
    @NotNull CraftServerService createCraftServerService();

    @NotNull NbtCompound createNbtCompound();
    @NotNull NbtCompound createNbtCompound(net.minecraft.nbt.NBTTagCompound compound);
}
