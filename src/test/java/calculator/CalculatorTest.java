package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1,2,3"})
    @DisplayName("음수가 들어온 경우 예외가 발생한다.")
    void sumNagativeNumberException(String input) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> Calculator.sum(input))
            .withMessageMatching("음수는 입력될 수 없다.");
    }

    @Test
    @DisplayName("문자가 들어온 경우 예외가 발생한다.")
    void sumStringException() {
        String input = "문,자,3";
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> Calculator.sum(input))
            .withMessageMatching("문자는 입력될 수 없다.");
    }
}
