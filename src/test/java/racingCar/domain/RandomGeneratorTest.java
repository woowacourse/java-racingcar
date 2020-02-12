package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
    @Test
    void decideGoOrStop() {
        boolean result = RandomGenerator.decideGoOrStop();
        Assertions.assertThat(result).isInstanceOf(Boolean.class);
    }
}
