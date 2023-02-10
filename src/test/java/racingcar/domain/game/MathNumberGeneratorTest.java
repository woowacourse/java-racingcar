package racingcar.domain.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class MathNumberGeneratorTest {

    @Disabled("많은 반복, 따로 테스트")
    @Test
    @DisplayName("generate() 시 최솟값과 최댓값 사이의 임의의 값을 생성한다.")
    @RepeatedTest(2000)
    void test_1() {
        // given
        NumberGenerator generator = new MathNumberGenerator();

        // when
        int generatedNumber = generator.generate(0, 9);
        // Math.random() 같은 함수는 어떻게 테스트하면 좋을지?

        // then
        Assertions.assertThat(generatedNumber).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(generatedNumber).isLessThanOrEqualTo(9);
    }
}
