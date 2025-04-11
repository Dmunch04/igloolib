package me.munchii.igloolib.nms.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An interface for handling conversions and manipulation of ItemStack objects
 * between Bukkit and NMS (net.minecraft.server) implementations.
 */
public interface ItemStackService {
    /**
     * Converts a Bukkit ItemStack to its corresponding NMS (net.minecraft.server) ItemStack.
     *
     * @param stack The Bukkit ItemStack to be converted. Must not be null.
     * @return The NMS representation of the provided Bukkit ItemStack.
     */
    net.minecraft.world.item.@NotNull ItemStack asNMSCopy(org.bukkit.inventory.@NotNull ItemStack stack);

    /**
     * Converts an NMS (net.minecraft.server) ItemStack to its corresponding Bukkit ItemStack.
     *
     * @param stack The NMS ItemStack to be converted. Must not be null.
     * @return The Bukkit representation of the provided NMS ItemStack.
     */
    org.bukkit.inventory.@NotNull ItemStack asBukkitCopy(net.minecraft.world.item.@NotNull ItemStack stack);

    /**
     * Retrieves the NBT (Named Binary Tag) data associated with the given Bukkit ItemStack.
     *
     * @param stack The Bukkit ItemStack whose NBT data is to be retrieved. Must not be null.
     * @return The NBT data of the provided Bukkit ItemStack. Guaranteed to be non-null.
     */
    net.minecraft.nbt.@NotNull NBTTagCompound getNBT(org.bukkit.inventory.@NotNull ItemStack stack);

    /**
     * Retrieves the NBT (Named Binary Tag) data associated with the given NMS (net.minecraft.server) ItemStack.
     *
     * @param stack The NMS ItemStack whose NBT data is to be retrieved. Must not be null.
     * @return The NBT data of the provided NMS ItemStack. Guaranteed to be non-null.
     */
    net.minecraft.nbt.@NotNull NBTTagCompound getNBT(net.minecraft.world.item.@NotNull ItemStack stack);

    /**
     * Associates the specified NBT (Named Binary Tag) data with the given Bukkit ItemStack.
     *
     * @param stack The Bukkit ItemStack to which the NBT data will be applied. Must not be null.
     * @param nbt   The NBT data to associate with the ItemStack, or null to remove any existing NBT data.
     */
    void putNBT(org.bukkit.inventory.@NotNull ItemStack stack, net.minecraft.nbt.@Nullable NBTTagCompound nbt);

    /**
     * Associates the specified NBT (Named Binary Tag) data with the given NMS (net.minecraft.server) ItemStack.
     *
     * @param stack The NMS ItemStack to which the NBT data will be applied. Must not be null.
     * @param nbt   The NBT data to associate with the ItemStack, or null to remove any existing NBT data.
     */
    void putNBT(net.minecraft.world.item.@NotNull ItemStack stack, net.minecraft.nbt.@Nullable NBTTagCompound nbt);
}
