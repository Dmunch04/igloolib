package me.munchii.igloolib.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;

public class CommandManager implements CommandExecutor, TabCompleter, Listener {
    private final Map<Set<String>, IglooCommand> commands;
    private final List<IglooCommandGroup> commandGroups;

    public CommandManager() {
        this.commands = new HashMap<>();
        this.commandGroups = new ArrayList<>();
    }

    public void registerCommand(Set<String> commandNames, IglooCommand command) {
        commands.put(commandNames, command);
    }

    public void registerCommand(Set<String> commandNames, Supplier<IglooCommand> command) {
        commands.put(commandNames, command.get());
    }

    public void registerCommandGroup(IglooCommandGroup group) {
        commandGroups.add(group);
    }

    public boolean hasCommand(String cmd) {
        return commands.keySet().stream().anyMatch(command -> command.contains(cmd)) || commandGroups.stream().anyMatch(group -> group.getBaseCommand().equals(cmd));
    }

    public Optional<IglooCommand> getCommand(String cmd) {
        return commands.entrySet().stream().filter(value -> value.getKey().contains(cmd)).findFirst().map(Map.Entry::getValue);
    }

    public Optional<IglooCommandGroup> getCommandGroup(String baseCommand) {
        return commandGroups.stream().filter(group -> group.getBaseCommand().equals(baseCommand)).findFirst();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 0 && hasCommand(args[0])) {

        }
    }

    @EventHandler
    public void onPreCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String[] args = event.getMessage().split(" ");
        List<String> commandAliases = new ArrayList<>();

        // TODO: we dont do this like CommandHandler, so how do we check perm?
        // https://github.com/MistwoodDev/FarmingPlugin/blob/master/FarmingPlugin/src/main/java/net/mistwood/FarmingPlugin/Commands/CommandHandler.java#L76
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }

    private static <T> T[] copyArrayOfRange(T[] original, int end) {
        int start = 1;
        if (original.length >= start) {
            if (start <= end) {
                int length = end - start;
                int copyLength = Math.min(length, original.length - start);
                T[] copy = (T[]) Array.newInstance(original.getClass().getComponentType(), length);
                System.arraycopy(original, start, copy, 0, copyLength);

                return copy;
            }

            throw new IllegalArgumentException();
        }

        throw new ArrayIndexOutOfBoundsException();
    }
}
