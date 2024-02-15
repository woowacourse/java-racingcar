package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    @Test
    @DisplayName("숫자를 랜덤으로 생성한다.")
    void generateTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int result = randomNumberGenerator.generate();

        assertThat(result).isBetween(0, 9);
    }
}