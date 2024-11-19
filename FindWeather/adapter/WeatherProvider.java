package adapter;
import models.WeatherData;
public interface WeatherProvider{
    WeatherData getWeather() throws Exception;
}