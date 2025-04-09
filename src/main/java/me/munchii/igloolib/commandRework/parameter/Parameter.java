package me.munchii.igloolib.commandRework.parameter;

import me.munchii.igloolib.commandRework.IglooCommand;

import java.util.Set;

public interface Parameter {
    boolean isOptional();

    boolean isTerminal();

    interface Key<T> extends Parameter {

    }

    interface Value<T> extends Parameter {

    }

    interface Subcommand extends Parameter {
        IglooCommand getCommand();

        Set<String> aliases();
    }
}
