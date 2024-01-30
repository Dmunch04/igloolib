package com.github.munchii.igloolib;

import java.util.function.Supplier;

public enum IglooVersion {
    RELEASE,
    DEV;

    // no idea if this actually works. it works in dev/test env
    public static final Supplier<IglooVersion> VERSION = () -> {
        try {
            Class<?> pluginClass = Class.forName("org.bukkit.plugin.java.JavaPlugin");
            return IglooVersion.RELEASE;
        } catch (ClassNotFoundException e) {
            return IglooVersion.DEV;
        }
    };
}
