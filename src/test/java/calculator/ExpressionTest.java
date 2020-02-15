package calculator;

import calculator.domain.Expression;
import calculator.domain.ExpressionException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExpressionTest {
    Expression expression;

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

    @ParameterizedTest
    @DisplayName(",나 :를 구분자로 식을 입력한 경우")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void splitDefaultDelimiterTest(String exp) {
        expression = new Expression(exp);
        Assertions.assertThat(expression.calculate())
                .isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("사용자가 구분자를 지정한 경우")
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3"})
    void splitCustomDelimiterTest(String exp) {
        expression = new Expression(exp);
        Assertions.assertThat(expression.calculate())
                .isEqualTo(6);
    }
}
