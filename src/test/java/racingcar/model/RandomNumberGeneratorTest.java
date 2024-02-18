package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 한 값이 생성된다.")
    @RepeatedTest(100)
    void generate() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        int value = generator.generate();

        assertThat(value).isBetween(0, 9);
    }
}
