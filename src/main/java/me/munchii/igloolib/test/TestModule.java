package me.munchii.igloolib.test;

import me.munchii.igloolib.command.BukkitCommandHandler;
import me.munchii.igloolib.command.CommandManager;
import me.munchii.igloolib.command.IglooCommandGroup;
import me.munchii.igloolib.test.command.TestCommand;
import me.munchii.igloolib.module.PluginModule;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.Set;

public class TestModule extends PluginModule<BukkitCommand> {
    public TestModule() {
        super("test", true, new BukkitCommandHandler());
    }

    @Override
    public void onEnable() {
        CommandManager commandManager = new CommandManager();

        commandManager.registerCommand(Set.of("yeet", "ye"), TestCommand::new);

        IglooCommandGroup cmdGroup = new IglooCommandGroup("farming");
    }

    @Override
    public void onDisable() {

    }
}
