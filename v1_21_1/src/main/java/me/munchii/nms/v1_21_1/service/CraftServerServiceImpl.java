package me.munchii.nms.v1_21_1.service;

import me.munchii.igloolib.nms.service.CraftServerService;
import org.bukkit.Server;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.craftbukkit.v1_21_R1.CraftServer;
import org.jetbrains.annotations.NotNull;

public class CraftServerServiceImpl implements CraftServerService {
    @Override
    public @NotNull SimpleCommandMap getCommandMap(@NotNull Server server) {
        return ((CraftServer) server).getCommandMap();
    }
}
