package sda.orange.grcy.tddDemo;

public class StringCalculator {

    /**
     * TDD działa "w kółko" :
     * RED - mamy test(y), zwraca(ją) błąd, idziemy poprawiać metodę
     * GREEN - poprawiliśmy metodę, test(y) działa(ją) OK
     * REFACTOR - "wygładzamy" nasz kod do lepszej postaci
     * jeśli jest dalej logika do dopisania do metody to najpierw tworzymy kolejny test i lądujemy w fazie RED
     *
     * https://osherove.com/tdd-kata-1
     */
    public int add(String argument) {
        if(argument.length() == 0) {
            return 0;
        }

        if(argument.length() == 1) {
            return Integer.valueOf(argument);
        }

        String[] splitted = argument.split("");
        return Integer.valueOf(splitted[0]) + Integer.valueOf(splitted[2]);

    }
}
