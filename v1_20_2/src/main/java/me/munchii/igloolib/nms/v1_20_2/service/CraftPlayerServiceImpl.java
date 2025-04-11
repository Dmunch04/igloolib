package me.munchii.igloolib.nms.v1_20_2.service;

import me.munchii.igloolib.nms.service.CraftPlayerService;
import net.minecraft.network.protocol.Packet;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CraftPlayerServiceImpl implements CraftPlayerService {
    @Override
    public boolean sendPacket(@NotNull Player player, Packet<?> packet) {
        // craftplayer.getHandle().connection.send(packet)
        return ((CraftPlayer) player).getHandle().c.a(packet);
    }
}
