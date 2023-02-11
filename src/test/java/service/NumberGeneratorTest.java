package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    @Test
    @DisplayName("랜덤 숫자 생성")
    void generateRandomNumber() {
        //given
        //when
        int randomNumber = numberGenerator.generateNumber(10);

        //then
        Assertions.assertThat(randomNumber)
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9);
    }
}