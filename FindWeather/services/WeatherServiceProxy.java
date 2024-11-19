package services;
import adapter.OpenWeatherAdapter;
import models.WeatherData;
import utils.CacheManager;

import java.util.HashMap;

public class WeatherServiceProxy{
    private final OpenWeatherAdapter openWeather;
    private final CacheManager cacheManager;
    private final HashMap<String, Long> rateLimiter;
    public WeatherServiceProxy() {
        this.openWeather = new OpenWeatherAdapter();
        this.cacheManager = new CacheManager();
        this.rateLimiter = new HashMap<>();
    }
    public WeatherData getWeatherByCity(String city) throws Exception {
        WeatherData cachedData = cacheManager.getCachedData(city);
        if (cachedData != null) return cachedData;
        try {
            if (isRateAllowed("WeatherStack")) {
                WeatherData weatherData = weatherStack.getWeatherByCity(city);
                return weatherData;}
        } catch{}
        WeatherData weatherData = openWeather.getWeatherByCity(city);
        return weatherData;
    }
    private boolean isRateAllowed(String provider) {
        long currentTime = System.currentTimeMillis();
        Long lastRequestTime = rateLimiter.get(provider);

        return lastRequestTime == null || (currentTime - lastRequestTime > 30000);
    }
}