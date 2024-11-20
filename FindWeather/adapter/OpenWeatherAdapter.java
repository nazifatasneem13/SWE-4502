package adapter;
import api.OpenWeatherAPI;
import models.WeatherData;
import org.json.JSONObject;

public class OpenWeatherAdapter implements WeatherProvider{
    private final OpenWeatherAPI api;
    public OpenWeatherAdapter() {
        this.api = new OpenWeatherAPI();
    }
    @Override
    public WeatherData getWeatherByIP(double latitude, double longitude) throws Exception {
        JSONObject response = api.getWeatherByIP(latitude, longitude);
        double temperature = response.getJSONObject("main").getDouble("temp");
        String conditions = response.getJSONArray("weather").getJSONObject(0).getString("description");
        return new WeatherData("Location via IP", temperature, conditions, "OpenWeather");
    }
    @Override
    public WeatherData getWeatherByCity(String city) throws Exception {
        JSONObject response = api.getWeatherByCity(city);
        double temperature = response.getJSONObject("current").getDouble("temperature");
        String conditions = response.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);
        return new WeatherData(city, temperature, conditions, "OpenWeather");
    }
}
