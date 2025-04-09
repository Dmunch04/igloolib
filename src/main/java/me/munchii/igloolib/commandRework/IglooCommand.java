package me.munchii.igloolib.commandRework;

import java.util.*;

public class IglooCommand {
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

        private CommandExecutor executor;
    }
}
