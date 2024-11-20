package api;

import models.Location;

import java.net.HttpURLConnection;
import java.net.URL;

public class IPStackService {
    private static final String API_KEY = "672a2c4fe1dd4739cf51e155cec02b4f";
    public Location getLocationByIP() throws Exception {
        String apiUrl = "http://api.ipstack.com/check?access_key=" + API_KEY;

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
    }
}
