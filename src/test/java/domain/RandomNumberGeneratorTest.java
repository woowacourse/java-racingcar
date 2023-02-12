package domain;

import domain.numbergenerator.NumberGenerator;
import domain.numbergenerator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("난수 발생기로 생성되는 숫자는 1~9사이의 정수이다.")
    public void checkRandomNumberRange() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < 10000; i++) {
            assertThat(numberGenerator.generate())
                    .isBetween(0, 9);
        }
    }
}