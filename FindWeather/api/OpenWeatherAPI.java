package api;
import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class OpenWeatherAPI {
    private static final String API_KEY = "0e87b701dc735ede819b1fed3ad63aeb";
    public JSONObject getWeatherByCity(String city) throws Exception {
        String apiUrl = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s",
                city, API_KEY
        );
        return fetchWeatherData(apiUrl);
    }
    public JSONObject getWeatherByIP(String city)
    {
        return fetchWeatherData();
    }
    public JSONObject fetchWeatherData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(conn.getInputStream());
        return new JSONObject();
    }
}
