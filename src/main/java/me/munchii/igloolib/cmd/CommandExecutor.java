package me.munchii.igloolib.cmd;

@FunctionalInterface
public interface CommandExecutor {
    // https://github.com/SpongePowered/SpongeAPI/tree/api-15/src/main/java/org/spongepowered/api/command
    // https://github.com/SpongePowered/Sponge/tree/api-15/src/main/java/org/spongepowered/common/command

    CommandResult execute(CommandContext context);
}
