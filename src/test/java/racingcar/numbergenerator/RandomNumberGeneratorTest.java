package racingcar.numbergenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("generate() 무작위 숫자 테스트")
    @Test
    void generator_random_test() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int number = numberGenerator.generate();
        assertThat(number).isNotNegative();
        assertThat(number).isLessThanOrEqualTo(9);
    }
}
