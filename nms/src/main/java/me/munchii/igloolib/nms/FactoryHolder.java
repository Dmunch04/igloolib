package me.munchii.igloolib.nms;

import org.jetbrains.annotations.NotNull;

public final class FactoryHolder {
    private static NMSFactory factory;

    private FactoryHolder() {}

    public static void setFactory(@NotNull NMSFactory nmsFactory) {
        factory = nmsFactory;
    }

    public static @NotNull NMSFactory getFactory() {
        return factory;
    }
}
