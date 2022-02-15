package racingcar.numberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("generate() 무작위 숫자 테스트")
    @Test
    public void generator_random_test() throws Exception {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int number = numberGenerator.generate();
        assertThat(number).isGreaterThanOrEqualTo(0);
        assertThat(number).isLessThanOrEqualTo(9);
    }
}
