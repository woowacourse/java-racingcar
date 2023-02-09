package racingCar.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberGeneratorTest {

    private final RandomNumberGenerator randomNumberPicker = new RandomNumberGenerator();

    @Test
    void pickOneNumberTest() {
        int pickOneNumber = randomNumberPicker.pickOneNumber();
        assertTrue(0 <= pickOneNumber && pickOneNumber <= 9);
    }
}