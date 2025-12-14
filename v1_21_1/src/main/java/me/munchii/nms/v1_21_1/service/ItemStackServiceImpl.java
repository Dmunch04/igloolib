package me.munchii.nms.v1_21_1.service;

import me.munchii.igloolib.nms.service.ItemStackService;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_21_R1.inventory.CraftItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemStackServiceImpl implements ItemStackService {
    @Override
    public @NotNull ItemStack asNMSCopy(org.bukkit.inventory.@NotNull ItemStack stack) {
        return CraftItemStack.asNMSCopy(stack);
    }

    @Override
    public org.bukkit.inventory.@NotNull ItemStack asBukkitCopy(@NotNull ItemStack stack) {
        return CraftItemStack.asBukkitCopy(stack);
    }

    @Override
    public @NotNull NBTTagCompound getNBT(org.bukkit.inventory.@NotNull ItemStack stack) {
        //return CraftItemStack.asNMSCopy(stack).;
        return null;
    }

    @Override
    public @NotNull NBTTagCompound getNBT(@NotNull ItemStack stack) {
        //return stack.;
        return null;
    }

    @Override
    public void putNBT(org.bukkit.inventory.@NotNull ItemStack stack, @Nullable NBTTagCompound nbt) {

    }

    @Override
    public void putNBT(@NotNull ItemStack stack, @Nullable NBTTagCompound nbt) {

    }

    @Override
    public @NotNull Item getItem(@NotNull ItemStack stack) {
        return null;
    }

    @Override
    public int getAmount(@NotNull ItemStack stack) {
        return 0;
    }

    @Override
    public void setAmount(@NotNull ItemStack stack, int amount) {

    }

    @Override
    public boolean isEmpty(@NotNull ItemStack stack) {
        return false;
    }
}
