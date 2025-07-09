package com.example.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherLogger {
    private static final String API_KEY = "0cf121a918624afc85452745250907";
    private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        try {
            String response = fetchWeatherData(city);
            if (response != null) {
                logToFile(response);
                System.out.println("Weather data saved to weather_log.txt");
            } else {
                System.out.println("Failed to retrieve weather data.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String fetchWeatherData(String city) throws IOException {
        String urlString = BASE_URL + "?key=" + API_KEY + "&q=" + city;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int status = conn.getResponseCode();
        if (status == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            reader.close();
            conn.disconnect();
            return result.toString();
        } else {
            System.out.println("HTTP Error Code: " + status);
            return null;
        }
    }

    public static void logToFile(String data) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Admin\\javacode\\demo\\src\\main\\resources\\weather_log.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("==== Weather Log Entry ====\n");
        bufferedWriter.write(data);
        bufferedWriter.write("\n===========================\n");
        bufferedWriter.close();
    }
}


