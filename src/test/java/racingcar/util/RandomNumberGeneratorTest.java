package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @Test
    @DisplayName("범위가 있는 랜덤값을 생성한다")
    public void testRandomFromBoundary() {
        // given
        int lowerBound = 0;
        int upperBound = 10;
        RandomNumberGenerator random = RandomNumberGenerator.fromBounds(lowerBound, upperBound);

        // when
        int number = random.generate();

        // then
        assertThat(number).isGreaterThanOrEqualTo(lowerBound).isLessThan(upperBound);
    }

    @Test
    @DisplayName("범위의 시작과 끝이 같은 경우 해당 값을 생성한다")
    public void testRandomFromSpecificValue() {
        // given
        int lowerBound = 1;
        int upperBound = 1;
        RandomNumberGenerator random = RandomNumberGenerator.fromBounds(lowerBound, upperBound);

        // when
        int number = random.generate();

        // then
        assertThat(number).isEqualTo(lowerBound).isEqualTo(upperBound);
    }

}