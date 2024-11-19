package api;
import org.json.JSONObject;
public class OpenWeatherAPI {
    private static final String API_KEY = "0e87b701dc735ede819b1fed3ad63aeb";
    public JSONObject getWeatherByCity(String city)
    {
        String apiUrl = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s",
                city, API_KEY
        );
        return featchWeatherData();
    }
    public JSONObject getWeatherByIP(String city)
    {
        return featchWeatherData();
    }
    public JSONObject featchWeatherData()
    {
        return new JSONObject();
    }
}
