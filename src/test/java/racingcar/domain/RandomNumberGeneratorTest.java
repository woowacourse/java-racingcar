package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("난수가 범위안에있는지 테스트")
    void generateTest() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int randomNumber = generator.generate(0, 9);
        assertThat(randomNumber).isBetween(0, 9);

    }
}