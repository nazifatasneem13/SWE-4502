package adapter;

import models.WeatherData;

public class OpenWeatherAdapter implements WeatherProvider{
    @Override
    public WeatherData getWeatherByIP(double latitude, double longitude) throws Exception {
        return new WeatherData();
    }
    
}
