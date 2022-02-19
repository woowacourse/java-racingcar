package racingcar.numberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovableNumberGeneratorTest {

    @DisplayName("generate() 전진 숫자 테스트")
    @Test
    void generator_movableNumber_test() throws Exception {
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        int number = numberGenerator.generate();
        assertThat(number).isGreaterThanOrEqualTo(4);
    }
}
