package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @DisplayName("generateNumber 메서드는 0과 9 사이의 정수를 임의로 반환한다.")
    @Test
    void generateNumber() {
        for (int i = 0; i < 10000; i++) {
            int randomNum = RandomUtils.generateNumber();
            assertThat(randomNum).isBetween(0, 9);
        }
    }
}
