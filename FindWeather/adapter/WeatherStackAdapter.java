package adapter;
import api.WeatherStackAPI;
import models.WeatherData;
import org.json.JSONObject;

public class WeatherStackAdapter implements WeatherProvider{
    private final WeatherStackAPI api;
    public WeatherStackAdapter() {
        this.api = new WeatherStackAPI();
    }
    @Override
    public WeatherData getWeatherByCity(String city) throws Exception {
        JSONObject response = api.getWeatherByCity(city);
        double temperature = response.getJSONObject("current").getDouble("temperature");
        String conditions = response.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);
    }
    @Override
    public WeatherData getWeatherByIP(double latitude, double longitude) throws Exception {}
}
