package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("숫자 하나 입력 시")
    void inputOneNumber() {
        int number = calculator.sumAndDivideInput("1");

        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("음수 입력 시 예외")
    void inputNegativeNumberException() {
        assertThatThrownBy(() -> calculator.sumAndDivideInput("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력 시 예외")
    void inputStringException() {
        assertThatThrownBy(() -> calculator.sumAndDivideInput("a,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,3", "1,:3"})
    @DisplayName("구분자 무시하고 숫자 합 반환")
    void sumNumbersIgnoreDelimiter(String input) {
        assertThat(calculator.sumAndDivideInput(input)).isEqualTo(4);
    }

    @Test
    @DisplayName("구분자 기준으로 나누어서 연산")
    void calculateByDelimiter() {
        int number = calculator.sumAndDivideInput("1,2");

        assertThat(number).isEqualTo(3);

        number = calculator.sumAndDivideInput("1:2");

        assertThat(number).isEqualTo(3);
    }

    @Test
    @DisplayName("커스텀 구분자 기준 연산")
    void calculateByCustomDelimiter() {
        int number = calculator.sumAndDivideInput("//;\n12;2;3");

        assertThat(number).isEqualTo(17);
    }
}