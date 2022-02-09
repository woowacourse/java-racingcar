package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 공백 혹은 null인 경우 0을 반환한다.")
    void sumNullAndBlankInput(String input) {
        assertThat(Calculator.sum(input)).isEqualTo(0);
    }
}
