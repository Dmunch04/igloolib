package me.munchii.igloolib.nms.service;

import org.jetbrains.annotations.NotNull;

public interface CraftServerService {
    /**
     * Retrieves the command map associated with the specified server.
     *
     * @param server the server for which the command map is to be retrieved; must not be null
     * @return the command map associated with the provided server; never null
     */
    org.bukkit.command.@NotNull SimpleCommandMap getCommandMap(org.bukkit.@NotNull Server server);
}
