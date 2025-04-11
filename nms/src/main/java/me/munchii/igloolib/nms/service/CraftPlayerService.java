package me.munchii.igloolib.nms.service;

import org.jetbrains.annotations.NotNull;

public interface CraftPlayerService {
    boolean sendPacket(org.bukkit.entity.@NotNull Player player, net.minecraft.network.protocol.Packet<?> packet);
}
