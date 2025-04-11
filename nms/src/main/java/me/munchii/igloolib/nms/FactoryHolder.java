package me.munchii.igloolib.nms;

import org.jetbrains.annotations.NotNull;

/**
 * FactoryHolder serves as a singleton container for the {@link NMSFactory} implementation.
 * It provides methods to set and access the {@link NMSFactory} instance, ensuring
 * the factory is properly initialized before use.
 *
 * This class is final, and its constructor is private to prevent instantiation.
 * It enforces a single {@link NMSFactory} instance to be shared across the application.
 */
public final class FactoryHolder {
    private static NMSFactory factory;

    private FactoryHolder() {}

    /**
     * Sets the NMSFactory instance to be used by the FactoryHolder.
     *
     * @param nmsFactory The NMSFactory instance to set. Must not be null.
     */
    public static void setFactory(@NotNull NMSFactory nmsFactory) {
        factory = nmsFactory;
    }

    /**
     * Retrieves the current instance of the {@link NMSFactory}.
     * This method ensures that the factory has been initialized before returning it.
     *
     * @return The non-null instance of the {@link NMSFactory}.
     * @throws AssertionError if the factory has not been initialized.
     */
    public static @NotNull NMSFactory getFactory() {
        assert factory != null : "NMSFactory is not initialized";
        return factory;
    }
}
