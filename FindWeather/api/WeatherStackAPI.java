package api;

import org.json.JSONObject;

public class WeatherStackAPI {
    private static final String API_KEY = "f1177d07fc4272ae4bbccb419a699e91";
    public JSONObject getWeatherByCity(String city) throws Exception {
        String apiUrl = String.format(
                "http://api.weatherstack.com/current?access_key=%s&query=%s",
                API_KEY, city
        );
        return fetchWeatherData(apiUrl);
    }
    private JSONObject fetchWeatherData(String apiUrl) throws Exception {

    }
}
