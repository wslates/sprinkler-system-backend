package io.slates.weather;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import io.slates.weather.api.CurrentWeather;
import javax.net.ssl.HttpsURLConnection;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Weather {

    private static class Config {
        @SerializedName("apiKey")
        @Expose
        private String apiKey;
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
    }


    private static final String CONFIG_FILE = "config.json";
    private static final String URL_PATTERN = "https://api.openweathermap.org/data/2.5/onecall?lat=%f&lon=%f&exclude=current,minutely,hourly&appid=%s&units=imperial";
    private static final String API_KEY;
    private static final Double LATITUDE;
    private static final Double LONGITUDE;


    static {
        Config config = new Config();
        try (FileReader fileReader = new FileReader(Paths.get(Weather.class.getClassLoader().getResource(CONFIG_FILE).toURI()).toFile())) {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(fileReader);
            config = gson.fromJson(reader, Config.class);

        } catch (IOException exception) {
        } catch (URISyntaxException e) {
        }
        API_KEY = config.apiKey == null ? "" : config.apiKey;
        LATITUDE = config.latitude;
        LONGITUDE = config.longitude;
    }

    public static CurrentWeather getWeather() {
        try {
            URL url = new URL(String.format(URL_PATTERN, LATITUDE, LONGITUDE, API_KEY));
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            InputStreamReader reader = new InputStreamReader(url.openStream());
            Gson gson = new Gson();
            CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);
            return currentWeather;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
