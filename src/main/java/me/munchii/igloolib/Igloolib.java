package me.munchii.igloolib;

import org.bukkit.plugin.java.JavaPlugin;

public final class Igloolib extends JavaPlugin {

    public static Igloolib INSTANCE = null;

    @Override
    public void onEnable() {
        INSTANCE = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
