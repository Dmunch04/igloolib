package me.munchii.nms.v1_21_1.service;

import me.munchii.igloolib.nms.service.CraftPlayerService;
import net.minecraft.network.protocol.Packet;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CraftPlayerServiceImpl implements CraftPlayerService {
    @Override
    public boolean sendPacket(@NotNull Player player, Packet<?> packet) {
        return ((CraftPlayer) player).getHandle().c.a(packet);
    }
}
