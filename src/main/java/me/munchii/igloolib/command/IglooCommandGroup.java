package me.munchii.igloolib.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class IglooCommandGroup {
    private final String baseCommand;
    private final Map<Set<String>, IglooCommand> commands;

    public IglooCommandGroup(String baseCommand) {
        this.baseCommand = baseCommand;
        this.commands = new HashMap<>();
    }

    public void registerCommand(Set<String> commandNames, IglooCommand command) {
        commands.put(commandNames, command);
    }

    public void registerCommand(Set<String> commandNames, Supplier<IglooCommand> command) {
        commands.put(commandNames, command.get());
    }

    public String getBaseCommand() {
        return baseCommand;
    }
}
