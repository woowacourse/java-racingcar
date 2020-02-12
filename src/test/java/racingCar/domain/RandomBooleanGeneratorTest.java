package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomBooleanGeneratorTest {
    @Test
    void generate() {
        boolean result = RandomBooleanGenerator.generate();
        Assertions.assertThat(result).isInstanceOf(Boolean.class);
    }
}
