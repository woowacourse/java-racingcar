package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RandomNumberGeneratorTest {
    @Test
    public void 범위가_다른_랜덤값() {
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
    public void 범위의_시작과_끝이_같은_경우() {
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