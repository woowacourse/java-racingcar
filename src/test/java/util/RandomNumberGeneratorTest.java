package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void generateRandomNumber() {
        //given
        //when
        int randomNumber = RandomNumberGenerator.generateRandomNumber(10);
        //then
        Assertions.assertThat(randomNumber).isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9);
    }
}