package me.munchii.igloolib.commandRework;

import me.munchii.igloolib.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public final class CommandResult {
    private final boolean isSuccess;
    private final int result;
    @Nullable
    private final Text errorMessage;

    public CommandResult(final boolean isSuccess, final State result, final @Nullable Text errorMessage) {
        this(
            isSuccess,
            result.state,
            errorMessage);
    }

    public CommandResult(final boolean isSuccess, final int result, final @Nullable Text errorMessage) {
        this.isSuccess = isSuccess;
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public int getResult() {
        return result;
    }

    public @NotNull Optional<Text> getErrorMessage() {
        return Optional.ofNullable(this.errorMessage);
    }

    public enum State {
        UNDEFINED(-1),
        UNSUCCESSFUL(0),
        SUCCESSFUL(1);

        private final int state;

        State(final int state) {
            this.state = state;
        }
    }
}
