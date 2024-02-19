package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixedNumberGeneratorTest {

    @Test
    @DisplayName("이동가능한 경계숫자인 4를 반환한다")
    void generateTest() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        Assertions.assertThat(fixedNumberGenerator.generate()).isEqualTo(4);
    }
}
