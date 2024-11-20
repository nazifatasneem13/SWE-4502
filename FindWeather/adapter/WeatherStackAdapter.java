package adapter;
import api.WeatherStackAPI;
import models.WeatherData;

public class WeatherStackAdapter implements WeatherProvider{
    private final WeatherStackAPI api;
    public WeatherStackAdapter() {
        this.api = new WeatherStackAPI();
    }
    @Override
    public WeatherData getWeatherByCity(String city) throws Exception {}
    @Override
    public WeatherData getWeatherByIP(double latitude, double longitude) throws Exception {}
}
