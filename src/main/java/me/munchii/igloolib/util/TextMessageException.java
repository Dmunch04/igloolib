package me.munchii.igloolib.util;

import me.munchii.igloolib.text.Text;
import org.jetbrains.annotations.Nullable;

public class TextMessageException extends Exception {
    private final Text message;

    public TextMessageException() {
        super();
        message = null;
    }

    public TextMessageException(Text message) {
        super(message.toString());
        this.message = message;
    }

    public TextMessageException(Text message, Throwable cause) {
        super(message.toString(), cause);
        this.message = message;
    }

    public TextMessageException(Throwable cause) {
        super(cause);
        this.message = null;
    }

    @Override
    @Nullable
    public String getMessage() {
        return message == null ? super.getMessage() : message.toString();
    }

    @Override
    @Nullable
    public String getLocalizedMessage() {
        return message == null ? super.getLocalizedMessage() : message.toString();
    }

    @Nullable
    public Text getText() {
        return message;
    }
}
