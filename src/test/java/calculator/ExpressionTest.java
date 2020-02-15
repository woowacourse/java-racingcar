package calculator;

import calculator.domain.Expression;
import calculator.domain.ExpressionException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {
    private Expression expression;

    @Test
    @DisplayName("입력값이 null인 경우")
    void nullTest() {
        Assertions.assertThatThrownBy(
                () -> expression = new Expression(null)
        ).isInstanceOf(ExpressionException.class);
    }

    @Test
    @DisplayName("빈 문자열을 입력받은 경우")
    void blankTest() {
        Assertions.assertThatThrownBy(
                () -> expression = new Expression("")
        ).isInstanceOf(ExpressionException.class);
    }

    @Test
    @DisplayName("숫자 하나를 입력한 경우")
    void singleNumberTest() {
        expression = new Expression("1");
        Assertions.assertThat(expression.calculate())
                .isEqualTo(1);
    }
}
