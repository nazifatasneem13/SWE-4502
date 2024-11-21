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
        }
    }
}
