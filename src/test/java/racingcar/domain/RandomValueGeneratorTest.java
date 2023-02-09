package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomValueGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("난수가 범위안에있는지 테스트")
    void generateTest() {
        RandomValueGenerator generator = new RandomValueGenerator();
        int randomNumber = generator.generate();
        assertThat(randomNumber).isBetween(0, 9);

    }
}