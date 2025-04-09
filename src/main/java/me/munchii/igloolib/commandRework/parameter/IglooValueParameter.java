package me.munchii.igloolib.commandRework.parameter;

public class IglooValueParameter<T> implements Parameter {

    @Override
    public boolean isOptional() {
        return false;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }
}
