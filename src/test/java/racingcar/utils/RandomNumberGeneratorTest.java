package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    public void generateRandomNumber() {
        // given
        int random = RandomNumberGenerator.generate();
        // when
        Assertions.assertThat(random).isGreaterThanOrEqualTo(0).isLessThan(10);
        // then
    }
}