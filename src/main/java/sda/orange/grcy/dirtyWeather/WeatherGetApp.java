package sda.orange.grcy.dirtyWeather;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherGetApp {

    private static final String GET_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/1-269508_1_AL" +
            "?apikey=&details=true&metric=true";
    public static void main(String[] args) {
        try {
            URL obj = new URL(GET_URL);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");

            /**
             * HTTP:
             * GET - pobieranie danych (po bazodanowemu - SELECT)
             *
             * POST - wstawienie (pierwsze) danych - (INSERT)
             * PUT  - korekta (wszystkich) danych - (UPDATE / MERGE)
             * PATCH - korekta pojedynczych pól - (UPDATE / MERGE)
             *
             * DELETE - kasowanie danych (DELETE)
             *
             * INFO - pobranie informacji - np na temat dostępnych tzw. endpointów czyli adresów pod którymi
             *        można wysłać GET, POST, ...
             */

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
