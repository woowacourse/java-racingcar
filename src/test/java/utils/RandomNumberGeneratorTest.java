package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("난수는 1~9 사이어야 한다.")
    @Test
    void randomNumberTest() {
        for (int count = 0; count < 100; count++) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            assertThat(randomNumber).isBetween(1, 9);
        }
    }
}