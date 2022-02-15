package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @DisplayName("기본 구분자로 구분한 값들을 더해서 반환하다.")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void calculate_basicDelimiter_Test(String expression) {
        int actual = stringCalculator.calculate(expression);
        int  expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("null이 들어오면 0을 반환한다.")
    void calculate_null_Test() {
        int actual = stringCalculator.calculate(null);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("비어있는 문자열 혹은 공백으로만 이루어진 문자열이 들어오면 0을 반환한다.")
    @ValueSource(strings = {"", " "})
    void calculate_Blank_Test(String blackString) {
        int actual = stringCalculator.calculate(blackString);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사용자 지정 구분자로 구분한 값들을 더해서 반환한다.")
    void calculate_customizedDelimiter_Test() {
        String expression = "//;\n1;2;3";
        int actual = stringCalculator.calculate(expression);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("피연산자의 위치에 0 혹은 양의 정수가 아닌 값이 들어오면 예외를 발생시킨다.")
    @ValueSource(strings = {"//;\n-1;2;3", "//;\na;2;3"})
    void calculate_NotPositiveOrZeroOperand_Test(String expression) {
        String expectedExceptionMessage = "피연산자에 양의 정수 혹은 0이 아닌 값이 있습니다.";
        assertThatThrownBy(() -> stringCalculator.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }
}
