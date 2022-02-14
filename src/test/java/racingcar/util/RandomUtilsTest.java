package racingcar.util;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {

    @DisplayName("generateNumber 메서드는 0과 9 사이의 정수를 임의로 반환한다.")
    @Test
    void generateNumber() {
        for (int i = 0; i < 10000; i++) {
            int randomNum = RandomUtils.generateNumber();
            assertThat(randomNum).isBetween(0, 9);
        }
    }

    @DisplayName("generateNumber 메서드는 0도 반환할 수 있다.")
    @Test
    void generateNumber_includeZero() {
        Set<Integer> generatedNumbers = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            int randomNum = RandomUtils.generateNumber();
            generatedNumbers.add(randomNum);
        }

        assertThat(generatedNumbers.contains(0)).isTrue();
    }

    @DisplayName("generateNumber 메서드는 10을 반환하지 않는다.")
    @Test
    void generateNumber_excludeTen() {
        for (int i = 0; i < 10000; i++) {
            int randomNum = RandomUtils.generateNumber();
            assertThat(randomNum).isNotEqualTo(10);
        }
    }
}
