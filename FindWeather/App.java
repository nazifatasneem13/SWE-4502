import models.WeatherData;
import services.WeatherServiceProxy;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        WeatherServiceProxy weatherService = new WeatherServiceProxy();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Weather App Menu:");
            System.out.println("1. Get Weather by IP");
            System.out.println("2. Get Weather by City Name");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    System.out.println("Fetching weather data by IP...");
                    WeatherData weatherByIP = weatherService.getWeatherByIP();
                    System.out.println("Weather Data:");
                    System.out.println("Location: " + weatherByIP.getLocation());
                    System.out.println("Temperature: " + weatherByIP.getTemperature() + "°C");
                    System.out.println("Conditions: " + weatherByIP.getConditions());
                    System.out.println("Source: " + weatherByIP.getSource());
                } else if (choice == 2) {
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    System.out.println("Fetching weather data for city: " + cityName + "...");
                    WeatherData weatherByCity = weatherService.getWeatherByCity(cityName);
                    System.out.println("Weather Data:");
                    System.out.println("Location: " + weatherByCity.getLocation());
                    System.out.println("Temperature: " + weatherByCity.getTemperature() + "°C");
                    System.out.println("Conditions: " + weatherByCity.getConditions());
                    System.out.println("Source: " + weatherByCity.getSource());
                } else if (choice == 3) {
                    System.out.println("Exiting the Weather App. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice! Please select a valid option.");
                }
            }catch(Exception e){}
        }
    }
}
