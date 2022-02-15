package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private static final char DELIMITER = ' ';

    @DisplayName("null 또는 빈 문자가 입력되었을 경우 0을 반환한다")
    @Test
    public void nullOrEmpty() {
        assertThat(StringCalculator.sum(null)).isEqualTo(0);
        assertThat(StringCalculator.sum("")).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1 1", "2 2", "3 3"}, delimiter = DELIMITER)
    public void singleNumber(String input, int expected) {
        assertThat(StringCalculator.sum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2 3", "3,4 7", "100,1000 1100"}, delimiter = DELIMITER)
    public void twoNumbersWithComma(String input, int expected) {
        assertThat(StringCalculator.sum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 콜론 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:2 3", "3:4 7", "100:1000 1100"}, delimiter = DELIMITER)
    public void twoNumbersWithColon(String input, int expected) {
        assertThat(StringCalculator.sum(input)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//_\n1_2_3", "//-\n1-2-3"})
    public void customDelimiter(String input) {
        assertThat(StringCalculator.sum(input)).isEqualTo(6);
    }

    @DisplayName("음수를 입력받으면 예외를 Throw 한다")
    @ParameterizedTest
    @ValueSource(strings = {"-3", "3,-5", "//;\n1;-2;3"})
    public void negative(String input) {
        assertThatThrownBy(() -> StringCalculator.sum(input))
                .isInstanceOf(RuntimeException.class);
    }
}

