package me.munchii.igloolib.test;

import me.munchii.igloolib.command.IglooCommand;
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
                .registerCommand(IglooCommand.create("yeet")
                        .withAlias("hehe")
                        .withPermission("some.perm")
                        .withDescription("good command")
                        .withAction((sender, args) -> {
                            sender.sendMessage("hello");
                            return true;
                        })
                        .build())
                .registerCommandGroup(new IglooCommandGroup("farming")
                        .registerCommand(TestSubOneCommand::new)
                        .registerCommand(TestSubTwoCommand::new)
                );

        // =>
        //  - /test /tt
        //  - /yeet /hehe
        //  - /farming
        //    - /farming subone
        //    - /farming subtwo
    }

    @Override
    public void onDisable() {

    }
}
