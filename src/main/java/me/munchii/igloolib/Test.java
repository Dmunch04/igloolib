package me.munchii.igloolib;

import me.munchii.igloolib.chat.profanity.ProfanityFilter;
import me.munchii.igloolib.chat.profanity.ProfanityResult;
import me.munchii.igloolib.util.SizedCache;

public class Test {
    public static void main(String... args) {
        SizedCache<String, Integer> cache = new SizedCache<>(2);
        cache.put("yeet", 1);
        cache.put("yeet2", 2);
        cache.put("yeet3", 3);
        assert !cache.containsKey("yeet2");
        cache.getSafe("yeet3").ifPresent(System.out::println);

        String test = "hello you! you are a cunt.";
        ProfanityResult result = ProfanityFilter.filter(test, true);
        System.out.println(result.getSafeText("*"));
    }
}
