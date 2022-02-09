package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 공백 혹은 null인 경우 0을 반환한다.")
    void sumNullAndBlankInput(String input) {
        assertThat(Calculator.sum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("입력값에 구분자가 없는 숫자를 그대로 반환한다.")
    void sumNotContainsDelimiterInput() {
        String input = "123";
        assertThat(Calculator.sum(input)).isEqualTo(123);
    }

    @Test
    @DisplayName("콤마가 구분자로 들어오는 경우 값의 덧셈을 반환한다.")
    void sumCommaDelimiterInput() {
        String input = "1,2,3";
        assertThat(Calculator.sum(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("컬럼이 구분자로 들어오는 경우 값의 덧셈을 반환한다.")
    void sumColumnDelimiterInput() {
        String input = "1:2:3";
        assertThat(Calculator.sum(input)).isEqualTo(6);
    }
}
