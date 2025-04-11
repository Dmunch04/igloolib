package me.munchii.igloolib.profanity;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class AllowList {
    private final Set<String> allowList;

    public AllowList()
    {
        this.allowList = new HashSet<>();
    }

    public AllowList(@NotNull Set<String> allowList) {
        this.allowList = allowList;
    }

    public void add(@NotNull String word) {
        if (!word.isBlank() && !allowList.contains(word)) {
            allowList.add(word.toLowerCase(Locale.ROOT));
        }
    }

    public void add(@NotNull String... words) {
        for (String word : words) {
            add(word);
        }
    }

    public void remove(@NotNull String word) {
        allowList.remove(word.toLowerCase(Locale.ROOT));
    }

    public void remove(@NotNull String... words) {
        for (String word : words) {
            remove(word);
        }
    }

    public boolean contains(@NotNull String word) {
        return word.isBlank() || allowList.contains(word.toLowerCase(Locale.ROOT));
    }

    public int size() {
        return allowList.size();
    }

    public void clear() {
        allowList.clear();
    }
}
