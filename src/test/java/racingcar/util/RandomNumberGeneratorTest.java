package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    private static final int TESTCASE_NUM = 10000;

    @Test
    @DisplayName("랜덤 숫자 생성")
    void generateRandomNumber() {
        final NumberGenerator randomNumber = new RandomNumberGenerator();
        for (int i = 0; i < TESTCASE_NUM; i++) {
            assertThat(randomNumber.generate()).isBetween(0,9);
        }
    }
}