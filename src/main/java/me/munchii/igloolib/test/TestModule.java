package me.munchii.igloolib.test;

import me.munchii.igloolib.command.IglooCommandGroup;
import me.munchii.igloolib.test.command.TestCommand;
import me.munchii.igloolib.module.PluginModule;
import me.munchii.igloolib.test.command.TestSubOneCommand;
import me.munchii.igloolib.test.command.TestSubTwoCommand;

public class TestModule extends PluginModule {
    public TestModule() {
        super("test", true);
    }

    @Override
    public void onEnable() {
        getCommandManager()
                .registerCommand(TestCommand::new)
                .registerCommandGroup(new IglooCommandGroup("farming")
                        .registerCommand(TestSubOneCommand::new)
                        .registerCommand(TestSubTwoCommand::new)
                );

        // =>
        //  - /test /tt
        //  - /farming
        //    - /farming subone
        //    - /farming subtwo
    }

    @Override
    public void onDisable() {

    }
}
