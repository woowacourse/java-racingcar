package racingCar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberGeneratorTest {

    private final RandomNumberGenerator randomNumberPicker = new RandomNumberGenerator();

    @RepeatedTest(20)
    @DisplayName("범위를 0부터 9범위 내의 값이 나오는지 테스트")
    void pickOneNumberTest() {
        int pickOneNumber = randomNumberPicker.generateNumber();
        assertTrue(0 <= pickOneNumber && pickOneNumber <= 9);
    }
}