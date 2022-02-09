package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("입력값이 공백 혹은 null인 경우 0을 반환한다.")
    void sumNullAndBlankInput() {
        assertThat(Calculator.sum(null)).isEqualTo(0);
        assertThat(Calculator.sum("")).isEqualTo(0);
    }
}
