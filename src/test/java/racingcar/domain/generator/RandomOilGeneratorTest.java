package racingcar.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class RandomOilGeneratorTest {

    @DisplayName("유효 범위 내에서 숫자를 생성한다")
    @Test
    void testGenerate() {
        OilGenerator randomOilGenerator = new RandomOilGenerator();
        int trial = 10_000;

        for (int count = 0; count < trial; count++) {
            assertThatCode(randomOilGenerator::generateValidOil)
                    .doesNotThrowAnyException();
        }
    }
}
