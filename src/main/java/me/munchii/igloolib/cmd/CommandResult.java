package me.munchii.igloolib.cmd;

import me.munchii.igloolib.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public final class CommandResult {
    private final boolean isSuccess;
    private final int result;
    @Nullable
    private final Text errorMessage;

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

    @NotNull
    public Optional<Text> getErrorMessage() {
        return Optional.ofNullable(this.errorMessage);
    }

    @NotNull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean isSuccess = true;
        private int result;
        @Nullable
        private Text errorMessage;

        private Builder() { }

        @NotNull
        public Builder result(final int result) {
            this.result = result;
            return this;
        }

        @NotNull
        public Builder error(final @Nullable Text errorMessage) {
            this.errorMessage = errorMessage;
            this.isSuccess = false;
            return this;
        }

        @NotNull
        public CommandResult build() {
            return new CommandResult(this.isSuccess, this.result, this.errorMessage);
        }

        @NotNull
        public Builder reset() {
            this.result = 0;
            this.errorMessage = null;
            this.isSuccess = true;
            return this;
        }
    }
}
