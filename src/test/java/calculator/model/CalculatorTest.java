package calculator.model;

import java.util.List;

import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("숫자 하나 입력 시")
    void inputOneNumber() {
        int number = calculator.makeSumOfNumbers(List.of("1"));

        assertThat(number).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,3", "1,:3"})
    @DisplayName("구분자 무시하고 숫자 합 반환")
    void sumNumbersIgnoreDelimiter(String input) {
        int number = calculator.makeSumOfNumbers(InputView.divideNumbersByDelimiterAndCheckValidate(input));

        assertThat(number).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("구분자 기준으로 나누어서 연산")
    @ValueSource(strings = {"1,2", "1:2"})
    void calculateByCommaDelimiter(String input) {
        int number = calculator.makeSumOfNumbers(InputView.divideNumbersByDelimiterAndCheckValidate(input));

        assertThat(number).isEqualTo(3);
    }

    @Test
    @DisplayName("커스텀 구분자 기준 연산")
    void calculateByCustomDelimiter() {
        int number = calculator.makeSumOfNumbers(InputView.dividesByCustomAndCheckValidate("//;\n12;2;3"));

        assertThat(number).isEqualTo(17);
    }
}