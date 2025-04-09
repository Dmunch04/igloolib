package me.munchii.igloolib.commandRework.parameter;

import me.munchii.igloolib.commandRework.IglooCommand;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class IglooSubcommandParameter implements Parameter {
    private final IglooCommand command;
    private final Set<String> aliases;

    public IglooSubcommandParameter(final @NotNull IglooCommand command, @NotNull Set<String> aliases) {
        this.command = command;
        this.aliases = aliases;
    }

    public IglooCommand command() {
        return this.command;
    }

    public Set<String> aliases() {
        return this.aliases;
    }

    @Override
    public boolean isOptional() {
        return true;
    }

    @Override
    public boolean isTerminal() {
        return this.command.isTerminal();
    }
}
