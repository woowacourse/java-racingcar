package domain.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @RepeatedTest(value = 1000)
    void 랜덤한_수를_뽑는다() {
        // given
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        int result = randomNumberGenerator.generate();

        // then
        assertThat(result)
                .isGreaterThan(0)
                .isLessThan(10)
                .isInstanceOf(Integer.class)
                .isNotNull();
    }
}
