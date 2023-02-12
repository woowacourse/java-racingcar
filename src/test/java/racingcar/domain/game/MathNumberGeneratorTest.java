package racingcar.domain.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MathNumberGeneratorTest {

    @ParameterizedTest(name = "generate() 시 최솟값과 최댓값 사이의 임의의 값을 생성한다.")
    @ValueSource(doubles = {0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9})
    void test_1(final double random) {
        // given
        NumberGenerator generator = new NumberGenerator(() -> random);

        // when
        int generatedNumber = generator.generate(0, 9);

        // then
        Assertions.assertThat(generatedNumber).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(generatedNumber).isLessThanOrEqualTo(9);
    }
}
