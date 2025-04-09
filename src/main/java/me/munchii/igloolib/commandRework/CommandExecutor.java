package me.munchii.igloolib.commandRework;

@FunctionalInterface
public interface CommandExecutor {
    CommandResult execute(CommandExecutionContext context);
}
