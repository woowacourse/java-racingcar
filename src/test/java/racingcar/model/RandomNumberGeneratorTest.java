package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 한 값이 생성된다.")
    @RepeatedTest(100)
    void generate() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        // when
        int value = generator.generate();

        // then
        Assertions.assertThat(value).isBetween(0, 9);
    }
}