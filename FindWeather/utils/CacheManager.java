package utils;

import models.WeatherData;

import java.util.HashMap;

public class CacheManager {
    private final HashMap<String, CacheEntry> cache = new HashMap<>();
    public WeatherData getCachedData(String location)
    {
        return null;
    }
    private static class CacheEntry {
        WeatherData data;
        long timestamp;
        CacheEntry(WeatherData data) {
            this.data = data;
            this.timestamp = System.currentTimeMillis();
        }
    }
}
