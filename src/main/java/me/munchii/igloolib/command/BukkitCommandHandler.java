package me.munchii.igloolib.command;

import me.munchii.igloolib.Igloolib;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.craftbukkit.v1_20_R2.CraftServer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BukkitCommandHandler implements ICommandHandler<BukkitCommand> {
    private final Map<String, BukkitCommand> commands;

    public BukkitCommandHandler() {
        this.commands = new HashMap<>();
    }

    public void registerCommand(BukkitCommand command) {
        commands.put(command.getName(), command);
    }

    public void registerCommand(Supplier<BukkitCommand> commandSupplier) {
        registerCommand(commandSupplier.get());
    }

    public void registerAll() {
        CraftServer server = (CraftServer) Igloolib.INSTANCE.getServer();
        commands.forEach((name, cmd) -> server.getCommandMap().register(name, cmd));
    }

    public void register(String name) {
        if (commands.containsKey(name)) {
            ((CraftServer) Igloolib.INSTANCE.getServer()).getCommandMap().register(name, commands.get(name));
        }
    }

    public void deregisterAll() {
        CraftServer server = (CraftServer) Igloolib.INSTANCE.getServer();
        commands.forEach((name, cmd) -> cmd.unregister(server.getCommandMap()));
    }

    public void deregister(String name) {
        if (commands.containsKey(name)) {
            commands.get(name).unregister(((CraftServer) Igloolib.INSTANCE.getServer()).getCommandMap());
        }
    }

    public void removeCommand(String name) {
        if (hasCommand(name)) {
            commands.remove(name);
        }
    }

    public Optional<BukkitCommand> getCommand(String name) {
        return hasCommand(name) ? Optional.of(commands.get(name)) : Optional.empty();
    }

    public Stream<BukkitCommand> getCommands() {
        return commands.values().stream();
    }

    public boolean hasCommand(String name) {
        return commands.containsKey(name);
    }
}
