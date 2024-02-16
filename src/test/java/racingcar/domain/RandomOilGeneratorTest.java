package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RandomOilGeneratorTest {

    @DisplayName("0부터 9 사이 숫자를 생성한다")
    @Test
    void testGenerate() {
        assertThat(RandomOilGenerator.generate())
                .matches((oil) -> oil <= 9 && oil >= 0);
    }
}