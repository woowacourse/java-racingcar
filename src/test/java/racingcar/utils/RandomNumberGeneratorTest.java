package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("생성된 난수는 0 이상 10 미만이다.")
    void randomBoundTest() {
        int randomNumber = RandomNumberGenerator.generate();
        assertThat(randomNumber).isBetween(0, 9);
    }
}
