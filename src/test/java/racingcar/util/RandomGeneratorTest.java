package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RandomGeneratorTest {
    @Test
    public void 랜덤_값() {
        // given
        int min = 0;
        int max = 10;

        // when
        int number = RandomGenerator.generateNumber(min, max);

        // then
        assertThat(number).isGreaterThanOrEqualTo(min).isLessThan(max);
    }

}