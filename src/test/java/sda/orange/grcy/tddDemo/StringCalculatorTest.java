package sda.orange.grcy.tddDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    void shouldReturnZeroWhenEmptyStringPassed() {
        var entry = "";

        var result = calculator.add(entry);

        assertEquals(0, result, "Incorrect value, expected 0, but having " + result);
    }

    @Test
    void shouldReturnNumberPassedOnEntry() {
        var entry = "1";

        var result = calculator.add(entry);

        assertEquals(1, result, "Should return 1 but got " + result);
    }

    @Test
    void shouldReturnSumOfTwoNumbersSeparatedByComma() {
        var entry = "1,2";

        var result = calculator.add(entry);

        assertEquals(3, result, "Should return sum of 2 numbers, but it's incorrect");
    }
}