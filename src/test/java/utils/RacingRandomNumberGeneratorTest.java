package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RacingRandomNumberGeneratorTest {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @RepeatedTest(10)
    @DisplayName("0부터 9까지의 랜덤값이 생성된다.")
    void generate() {
        RacingRandomNumberGenerator generator = new RacingRandomNumberGenerator();

        Assertions.assertThat(generator.generate())
                .isGreaterThanOrEqualTo(MIN_VALUE)
                .isLessThanOrEqualTo(MAX_VALUE);
    }
}