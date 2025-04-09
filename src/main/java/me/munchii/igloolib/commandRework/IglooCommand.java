package me.munchii.igloolib.commandRework;

import me.munchii.igloolib.commandRework.parameter.IglooSubcommandParameter;
import me.munchii.igloolib.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class IglooCommand {
    private final List<IglooSubcommandParameter> subcommands;
    private final List<Parameter> parameters;
    private final List<Flag> flags;
    private final Optional<Text> shortDescription;
    private final Optional<Text> longDescription;
    private final @Nullable CommandExecutor executor;
    private final boolean isTerminal;

    public IglooCommand(
            final List<IglooSubcommandParameter> subcommands,
            final List<Parameter> parameters,
            final List<Flag> flags,
            final Optional<Text> shortDescription,
            final Optional<Text> longDescription,
            final @Nullable CommandExecutor executor,
            final boolean isTerminal) {
        this.subcommands = subcommands;
        this.parameters = parameters;
        this.flags = flags;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.executor = executor;
        this.isTerminal = isTerminal;
    }

    public boolean isTerminal() {
        return this.isTerminal();
    }

    public static final class Parameter {

    }

    public static final class Flag {

    }

    public static final class Builder {
        private final Set<String> claimedSubcommands = new HashSet<>();
        private final Map<IglooCommand, List<String>> subcommands = new HashMap<>();
        private final List<Parameter> parameters = new ArrayList<>();
        private final List<Flag> flags = new ArrayList<>();
        private final Set<String> flagAliases = new HashSet<>();
        private final Set<String> permissions = new HashSet<>();

        private Text shortDescription;
        private Text longDescription;
        private CommandExecutor executor;
    }
}
