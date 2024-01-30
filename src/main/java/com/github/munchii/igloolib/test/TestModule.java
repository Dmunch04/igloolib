package com.github.munchii.igloolib.test;

import com.github.munchii.igloolib.command.BukkitCommandHandler;
import com.github.munchii.igloolib.command.CommandManager;
import com.github.munchii.igloolib.command.IglooCommandGroup;
import com.github.munchii.igloolib.test.command.TestCommand;
import com.github.munchii.igloolib.module.PluginModule;
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
