package sda.orange.grcy.dirtyWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherGetApp {

    private static final String GET_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/1-269508_1_AL" +
            "?apikey=LVz6RsCGYDwj1rJ6keYiNWU5KzLRg7KB&details=true&metric=true";
    public static void main(String[] args) {
        /**
         * Doróbcie pętlę w której będzie można "sterować programem":
         *  - wciśnięcie 0 kończy program
         *  - wciśnięcie 1 zaciąga nowe dane o pogodzie
         *  - wciśnięcie 2 wyświetla informacje pogodowe na ekranie
         *  Wszystkie powyższe akcje mają być przekazane do klasy kontrolera (z wyjątkiem 0)
         *
         * Doróbcie "kontrolera" który będzie reagował na "menu - akcje użytkownika"
         *  - jak macie pobrać nowe dane to wysyłacie żądanie URL i zapisujecie do obiektu pogody
         *  - jak macie wyświetlić to wyciągacie dane z obiektu pogody
         */





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
            int responseCode = conn.getResponseCode();

            /**
             * Kody odpowiedzi HTTP:
             * 100 - info
             * 200 - OK
             * 300 - przekierowanie
             * 400 - błąd użytkownika
             * 500 - błąd serwera
             */

            System.out.println("Kod odpowiedzi:" + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
                reader.close();
                System.out.println(response);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
