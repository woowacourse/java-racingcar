package racingcar.numberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UnMovableNumberGeneratorTest {

    @DisplayName("generate() 정지 숫자 테스트")
    @Test
    void generator_unMovableNumber_test() throws Exception {
        NumberGenerator numberGenerator = new UnMovableNumberGenerator();
        int number = numberGenerator.generate();
        assertThat(number).isLessThanOrEqualTo(3);
    }
}
