package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import service.RandomNumberGenerator;
import service.RandomNumberGeneratorImpl;

class RandomNumberGeneratorTest {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    @Test
    void generateRandomNumber() {
        //given
        //when
        int randomNumber = randomNumberGenerator.generateRandomNumber(10);
        //then
        Assertions.assertThat(randomNumber).isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9);
    }
}