package me.munchii.igloolib.v1_20_2;

import me.munchii.igloolib.nms.service.ItemStackService;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_20_R2.inventory.CraftItemStack;
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
        // #getOrCreateTag();
        return CraftItemStack.asNMSCopy(stack).w();
    }

    @Override
    public @NotNull NBTTagCompound getNBT(@NotNull ItemStack stack) {
        // #getOrCreateTag();
        return stack.w();
    }

    @Override
    public void putNBT(org.bukkit.inventory.@NotNull ItemStack stack, @Nullable NBTTagCompound nbt) {
        // ?
    }

    @Override
    public void putNBT(@NotNull ItemStack stack, @Nullable NBTTagCompound nbt) {
        // #setTag(nbt);
        stack.c(nbt);
    }
}
