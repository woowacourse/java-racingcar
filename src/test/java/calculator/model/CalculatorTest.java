package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("숫자 하나 입력 시")
    void inputOneNumber() {
        int number = calculator.sumAndDivideInput("1");

        assertThat(number).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("숫자 이외의 값 입력시 예외")
    @ValueSource(strings = {"-1,2,3", "a,2,3"})
    void inputNegativeNumberException(String input) {
        assertThatThrownBy(() -> calculator.sumAndDivideInput(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,3", "1,:3"})
    @DisplayName("구분자 무시하고 숫자 합 반환")
    void sumNumbersIgnoreDelimiter(String input) {
        assertThat(calculator.sumAndDivideInput(input)).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("구분자 기준으로 나누어서 연산")
    @ValueSource(strings = {"1,2", "1:2"})
    void calculateByCommaDelimiter() {
        int number = calculator.sumAndDivideInput("1,2");

        assertThat(number).isEqualTo(3);
    }

    @Test
    @DisplayName("커스텀 구분자 기준 연산")
    void calculateByCustomDelimiter() {
        int number = calculator.sumAndDivideInput("//;\n12;2;3");

        assertThat(number).isEqualTo(17);
    }
}