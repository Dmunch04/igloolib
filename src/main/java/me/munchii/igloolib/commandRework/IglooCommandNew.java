package me.munchii.igloolib.commandRework;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public final class IglooCommandNew implements CommandExecutor, TabCompleter {
    //private final Set<String> aliases;

    @Override
    public CommandResult execute(CommandExecutionContext context) {
        return null;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return List.of();
    }
}
