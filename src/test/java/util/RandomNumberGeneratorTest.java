package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @RepeatedTest(100)
    void 랜덤으로_생성한_숫자는_범위_이내의_값이다() {
        int number = randomNumberGenerator.generateNumber();
        assertThat(number).isBetween(0, 9);
    }
}