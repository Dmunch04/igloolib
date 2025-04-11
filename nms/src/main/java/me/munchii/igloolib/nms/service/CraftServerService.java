package me.munchii.igloolib.nms.service;

import org.jetbrains.annotations.NotNull;

public interface CraftServerService {
    org.bukkit.command.@NotNull SimpleCommandMap getCommandMap(org.bukkit.@NotNull Server server);
}
