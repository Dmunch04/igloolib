package me.munchii.igloolib.nms.service;

import org.jetbrains.annotations.NotNull;

public interface CraftPlayerService {
    /**
     * Sends a network packet to the specified player.
     *
     * @param player the player to whom the packet will be sent; must not be null
     * @param packet the packet to send to the player
     * @return true if the packet was successfully sent, false otherwise
     */
    boolean sendPacket(org.bukkit.entity.@NotNull Player player, net.minecraft.network.protocol.Packet<?> packet);
}
