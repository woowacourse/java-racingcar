package racingCar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberGeneratorTest {

    private final RandomNumberGenerator randomNumberPicker = new RandomNumberGenerator();

    @Test
    @DisplayName("범위를 0부터 3으로 설정했을 때 범위 내의 값이 나오는지 테스트")
    void pickOneNumberTest() {
        int pickOneNumber = randomNumberPicker.generateNumber();
        assertTrue(0 <= pickOneNumber && pickOneNumber <= 9);
    }
}