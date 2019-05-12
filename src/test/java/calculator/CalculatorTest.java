package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    private Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(Calculator.Operator.getOperator(ADD).calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(Calculator.Operator.getOperator(SUB).calculate(3, 1)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.Operator.getOperator(MUL).calculate(3, 1)).isEqualTo(3);
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.Operator.getOperator(DIV).calculate(4, 2)).isEqualTo(2);
    }

    @Test
    void 하나의_덧셈_연산을_하는_경우() {
        assertThat(cal.calculateSingleExpression(1, "+", 2)).isEqualTo(3);
    }

    @Test
    void 하나의_뺄셈_연산을_하는_경우() {
        assertThat(cal.calculateSingleExpression(3, "-", 1)).isEqualTo(2);
    }

    @Test
    void 하나의_곱셈_연산을_하는_경우() {
        assertThat(cal.calculateSingleExpression(1, "*", 2)).isEqualTo(2);
    }

    @Test
    void 하나의_나눗셈_연산을_하는_경우() {
        assertThat(cal.calculateSingleExpression(4, "/", 2)).isEqualTo(2);
    }

    @Test
    void 여러개의_연산을_하는_경우() {
        String[] array = "3 + 2 * 4 / 10 * 3".split(" ");
        assertThat(cal.calculateMultiExpression(array)).isEqualTo(6);
    }
}
