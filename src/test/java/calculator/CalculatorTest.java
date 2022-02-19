package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ErrorMessage;

class CalculatorTest {

    @DisplayName("sum() null 혹은 빈칸 입력되었을 때 테스트")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void sum_null_empty_test(String input) {
        int inputResult = Calculator.sum(input);
        assertThat(inputResult).isZero();
    }

    @DisplayName("sum() 입력 값이 하나인 경우 테스트")
    @Test
    void sum_with_only_one_test() {
        int inputResult = Calculator.sum("3");
        assertThat(inputResult).isEqualTo(3);
    }

    @DisplayName("sum() 사용자 임의의 구분자를 이용한 테스트")
    @Test
    void sum_custom_delimiter_test() {
        int inputResult = Calculator.sum("//;\n1;2;3");
        assertThat(inputResult).isEqualTo(6);
    }

    @DisplayName("sum() 입력 값이 문자인 경우 예외 테스트")
    @Test
    void sum_nonNumber_test() {
        assertThatThrownBy(() -> Calculator.sum("a,b"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("sum() 음수를 입력 했을 때 예외 테스트")
    @Test
    void sum_negativeNumber_test() {
        assertThatThrownBy(() -> Calculator.sum("-1,-2"))
                .hasMessageContaining(ErrorMessage.NUMBER_NEGATIVE.getMessage());
    }
}
