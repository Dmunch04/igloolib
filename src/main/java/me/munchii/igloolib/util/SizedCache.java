package me.munchii.igloolib.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class SizedCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public SizedCache(int maxSize) {
        super(maxSize + 2, 1F);

        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
