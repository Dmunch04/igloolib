package me.munchii.igloolib.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public abstract class IglooCommand implements CommandExecutor, TabCompleter {
    private final String command;
    private final Set<String> aliases;
    private final String permission;
    private final String description;
    private boolean enabled;

    public IglooCommand(String command) {
        this(command, Collections.emptySet(), "", "command /" + command);
    }

    public IglooCommand(String command, Set<String> aliases) {
        this(command, aliases, "", "command /" + command);
    }

    public IglooCommand(String command, Set<String> aliases, String permission) {
        this(command, Collections.emptySet(), permission, "command /" + command);
    }

    public IglooCommand(String command, Set<String> aliases, String permission, String description) {
        this.command = command;
        this.aliases = aliases;
        this.permission = permission;
        this.description = description;
    }

    public static Builder create(String command) {
        return new Builder(command);
    }

    public String getCommand() {
        return command;
    }

    public Set<String> getCommandAliases() {
        return aliases;
    }

    public String getPermission() {
        return permission;
    }

    public boolean hasPermission() {
        return permission.isEmpty();
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static final class Builder {
        private String command;
        private Set<String> aliases;
        private String permission;
        private String description;
        private BiFunction<CommandSender, List<String>, Boolean> onCommand;
        private BiFunction<CommandSender, List<String>, List<String>> tabComplete;

        public Builder(String cmd) {
            this.command = cmd;
        }

        public Builder withAlias(String alias) {
            this.aliases.add(alias);
            return this;
        }

        public Builder withPermission(String permission) {
            this.permission = permission;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withAction(BiFunction<CommandSender, List<String>, Boolean> onCommand) {
            this.onCommand = onCommand;
            return this;
        }

        public Builder withTabComplete(BiFunction<CommandSender, List<String>, List<String>> tabComplete) {
            this.tabComplete = tabComplete;
            return this;
        }

        public IglooCommand build() {
            return new IglooCommand(command, aliases, permission, description) {
                @Override
                public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
                    return onCommand.apply(sender, Arrays.asList(args));
                }

                @Nullable
                @Override
                public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
                    return tabComplete.apply(sender, Arrays.asList(args));
                }
            };
        }
    }
}
