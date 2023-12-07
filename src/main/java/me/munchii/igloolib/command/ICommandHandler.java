package me.munchii.igloolib.command;

import org.bukkit.command.defaults.BukkitCommand;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface ICommandHandler<T> {
    void registerCommand(T command);

    void registerCommand(Supplier<T> commandSupplier);

    void registerAll();

    void register(String name);

    void deregisterAll();

    void deregister(String name);

    void removeCommand(String name);

    Optional<T> getCommand(String name);

    Stream<BukkitCommand> getCommands();

    boolean hasCommand(String name);
}
