package sda.orange.grcy.weatherApproach;


/**
 * Controller - warstwa odpowiadająca za komunikację ze światem zewnętrznym
 * np. nasz frontend, ale też serwisy zewnętrzne
 */
public class WeatherController {

    private WeatherService weatherService;

    public boolean getCurrentConditions() {
        //tutaj wystawiamy metodę która połączy się z serwisem pogodowym,
        //następnie zaciągnie dane i zapisze je do bazy
        return weatherService.getCurrentWeatherAndSave();
    }

    public String printCurrentConditions() {
        //tutaj metoda która wyświetli aktualne warunki
        //na podstawie najnowszego wpisu w bazie
        return weatherService.getCurrentConditions();
    }

    public String printAverageTemperature() {
        //tutaj metoda która wyświetli średnią temperaturę
        //na podstawie danych zapisanych w bazie
        return weatherService.getAverageTemperature();
    }
}
