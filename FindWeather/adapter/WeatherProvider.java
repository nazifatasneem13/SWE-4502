package adapter;
import models.WeatherData;
public interface WeatherProvider{
    WeatherData getWeather() throws Exception;
    WeatherData getWeatherByCity(String city);
}