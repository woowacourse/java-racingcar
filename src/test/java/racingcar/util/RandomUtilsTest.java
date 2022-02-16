package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RandomUtilsTest {
    @Test
    public void 랜덤_값() {
        // given
        int min = 0;
        int max = 10;

        // when
        int number = RandomUtils.generateNumber(min, max);

        // then
        assertThat(number).isGreaterThanOrEqualTo(min).isLessThan(max);
    }

    @Test
    public void max가_더_작은_경우() {
        // given
        int min = 10;
        int max = 0;

        // when

        // then
        assertDoesNotThrow(() -> RandomUtils.generateNumber(min, max));
    }
}