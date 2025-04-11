package me.munchii.igloolib.profanity;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public final class ProfanityChecker {
    private AllowList allowList;
    private ProfanityList profanityList;

    public ProfanityChecker() {
        this.allowList = new AllowList();
        this.profanityList = new ProfanityList();
    }

    public ProfanityChecker(@NotNull AllowList allowList) {
        this.allowList = allowList;
        this.profanityList = new ProfanityList();
    }

    public ProfanityChecker(@NotNull ProfanityList profanityList) {
        this.allowList = new AllowList();
        this.profanityList = profanityList;
    }

    public ProfanityChecker(@NotNull AllowList allowList, @NotNull ProfanityList profanityList) {
        this.allowList = allowList;
        this.profanityList = profanityList;
    }

    public boolean isProfanity(@NotNull String word) {
        if (word.isBlank()) return false;
        if (allowList.contains(word)) return false;
        return profanityList.containsProfanity(word);
    }

    public List<String> detectAllProfanities(@NotNull String text) {
        return detectAllProfanities(text, false);
    }

    public List<String> detectAllProfanities(@NotNull String text, boolean removePartialMatches)
    {
        if (text.isBlank()) return new ArrayList<>();

        String alteredText = text.toLowerCase(Locale.ROOT)
                .replace(".", "")
                .replace(",", "");

        var words = alteredText.split(" ");
        var filteredWords = filterWordListByAllowList(words);
        List<String> swearList = new ArrayList<>();

        addMultiWordProfanities(swearList, alteredText);

        if (removePartialMatches) {
            swearList.removeIf(word -> swearList.stream().anyMatch(s -> !Objects.equals(word, s) && s.contains(word)));
        }

        // https://github.com/stephenhaunts/ProfanityDetector/blob/main/ProfanityFilter/ProfanityFilter/ProfanityFilter.cs#L137
        return new ArrayList<>(swearList);
    }

    private List<String> filterSwearListForCompleteWordsOnly(String sentence, List<String> swearList) {
        List<String> filteredSwearList = new ArrayList<>();
        StringBuilder tracker = new StringBuilder(sentence);

        // https://github.com/stephenhaunts/ProfanityDetector/blob/main/ProfanityFilter/ProfanityFilter/ProfanityFilter.cs#L339

        return null;
    }

    private List<String> filterWordListByAllowList(String[] wordList) {
        var filteredWordList = new ArrayList<String>();
        for (String word : wordList) {
            if (!allowList.contains(word)) {
                filteredWordList.add(word);
            }
        }

        return filteredWordList;
    }

    private void addMultiWordProfanities(List<String> swearList, String filteredSentence) {
        swearList.addAll(
                profanityList.getAll()
                        .stream()
                        .filter(s -> filteredSentence.toLowerCase(Locale.ROOT).contains(s))
                        .collect(Collectors.toSet())
        );
    }
}
