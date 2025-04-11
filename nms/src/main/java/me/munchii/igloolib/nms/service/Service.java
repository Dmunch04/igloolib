package me.munchii.igloolib.nms.service;

public interface Service<T extends Service<T>> {
    default String getId() {
        return this.getClass().getSimpleName();
    }

    @FunctionalInterface
    interface Factory<T extends Service<T>> {
        T create();
    }
}
