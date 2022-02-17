package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {
    @Test
    @DisplayName("랜덤 값")
    public void random() {
        // given
        int min = 0;
        int max = 10;

        // when
        int number = RandomUtils.generateNumber(min, max);

        // then
        assertThat(number).isGreaterThanOrEqualTo(min).isLessThan(max);
    }

    @Test
    @DisplayName("max가_더_작은_경우")
    public void less() {
        // given
        int min = 10;
        int max = 0;

        // when

        // then
        assertDoesNotThrow(() -> RandomUtils.generateNumber(min, max));
    }
}