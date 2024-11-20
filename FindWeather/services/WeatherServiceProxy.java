package services;
import adapter.IPAdapter;
import adapter.OpenWeatherAdapter;
import adapter.WeatherStackAdapter;
import models.Location;
import models.WeatherData;
import utils.CacheManager;

import java.util.HashMap;

public class WeatherServiceProxy{
    private final WeatherStackAdapter weatherStack;
    private final OpenWeatherAdapter openWeather;
    private final IPAdapter ipAdapter;
    private final CacheManager cacheManager;
    private final HashMap<String, Long> rateLimiter;
    public WeatherServiceProxy() {
        this.weatherStack = new WeatherStackAdapter();
        this.openWeather = new OpenWeatherAdapter();
        this.ipAdapter = new IPAdapter();
        this.cacheManager = new CacheManager();
        this.rateLimiter = new HashMap<>();
    }
    public WeatherData getWeatherByIP() throws Exception {
        Location location = ipAdapter.getLocationByIP(); // Fetch location by IP
        return getWeatherFromProvidersByIP(location.getLatitude(), location.getLongitude());
    }
    private WeatherData getWeatherFromProvidersByIP(double latitude, double longitude) throws Exception {}
    public WeatherData getWeatherByCity(String city) throws Exception {
        WeatherData cachedData = cacheManager.getCachedData(city);
        if (cachedData != null) return cachedData;

        try {
            if (isRateAllowed("WeatherStack")) {
                WeatherData weatherData = weatherStack.getWeatherByCity(city);
                cacheManager.cacheData(city, weatherData);
                updateRateLimiter("WeatherStack");
                return weatherData;
            }
        } catch (Exception e) {
            System.out.println("WeatherStack failed: " + e.getMessage());
        }

        WeatherData weatherData = openWeather.getWeatherByCity(city);
        cacheManager.cacheData(city, weatherData);
        return weatherData;
    }
    private boolean isRateAllowed(String provider) {
        long currentTime = System.currentTimeMillis();
        Long lastRequestTime = rateLimiter.get(provider);

        return lastRequestTime == null || (currentTime - lastRequestTime > 30000);
    }
    private void updateRateLimiter(String provider) {
        rateLimiter.put(provider, System.currentTimeMillis());
    }
}