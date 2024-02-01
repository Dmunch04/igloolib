package me.munchii.igloolib.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.Set;

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
}
