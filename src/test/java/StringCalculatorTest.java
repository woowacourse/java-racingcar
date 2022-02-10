
import StringCalculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("정수 파라미터 두개를 더해서 반환한다.")
    void calculate() {
        String expression = "//;\n1;2;3";
        int actual = stringCalculator.calculate(expression);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("피연산자의 위치에 0 혹은 양의 정수가 아닌 값이 들어오면 예외를 발생시킨다.")
    @ValueSource(strings = {"//;\n-1;2;3","//;\na;2;3"})
    void calculate_NotPositiveOrZeroOperand(String expression) {
        assertThatThrownBy(() -> stringCalculator.calculate(expression))
                        .isInstanceOf(RuntimeException.class);
    }
}
