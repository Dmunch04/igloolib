package me.munchii.igloolib.commandRework;

import java.util.Arrays;
import java.util.Map;

public interface IIglooCommand {

    interface Builder {
        default Builder addChild(final IIglooCommand child, final String... aliases) {
            return this.addChild(child, Arrays.asList(aliases));
        }

        Builder addChild(IIglooCommand child, Iterable<String> aliases);

        default Builder addChildren(final Map<? extends Iterable<String>, ? extends IIglooCommand> children) {
            for (final Map.Entry<? extends Iterable<String>, ? extends IIglooCommand> entry : children.entrySet()) {
                this.addChild(entry.getValue(), entry.getKey());
            }

            return this;
        }
    }
}
