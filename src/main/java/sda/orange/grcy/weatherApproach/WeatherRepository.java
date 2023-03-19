package sda.orange.grcy.weatherApproach;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository będzie odpowiadać za sesje Hibernate, otiweranie
 * i zamykanie transakcji, commit / rollback
 * i wykonywanie .persist, .get, .find, .remove
 */
public class WeatherRepository {
    public boolean save(Weather weather) {
        //tutaj otwieramy sesję, zapisujemy do bazy
        //i zamykamy sesję
        //jak zapiszemy to zwracamy true, jak nie zapiszemy to false
        return false;
    }

    public Weather findCurrentConditions() {
        //otwieramy sesję, znajdujemy najnowszy wpis o pogodzie i go zwracamy
        return new Weather();
    }

    public List<Weather> findAll() {
        //otwieramy sesję, bierzemy listę wszystkich warunków pododowych i zwracamy
        return new ArrayList<>();
    }

    public String getAvgTemperature() {
        //Wyciągnięcie średniej temperatury od razu z bazy za pomocą Native Query, albo HQL
        //Native Query - zwykłe zapytanie SQL które jest definiowane dla metody do uruchomienia
        //HQL - zapytanie po encjach, charakterystyczne dla JPA / Hibernate
        //JPA - interfejs, ogólna definicja, Hibernate - konkretna implementacja standardu JPA
        return "";
    }
}
