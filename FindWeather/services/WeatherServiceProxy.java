package services;
import adapter.OpenWeatherAdapter;
import models.WeatherData;
import utils.CacheManager;
public class WeatherServiceProxy{
    private final OpenWeatherAdapter openWeather;
    private final CacheManager cacheManager;
    public WeatherServiceProxy() {
        this.openWeather = new OpenWeatherAdapter();
        this.cacheManager = new CacheManager();
    }
    public WeatherData getWeatherByCity(String city) throws Exception {
        WeatherData cachedData = cacheManager.getCachedData(city);
        if (cachedData != null) return cachedData;
        try {} catch{}
        WeatherData weatherData = openWeather.getWeatherByCity(city);
        return weatherData;
    }
}