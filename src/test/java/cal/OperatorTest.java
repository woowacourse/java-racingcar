package cal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    @Test
    void 덧셈_테스트() {
        Operator plusOperator = Operator.findOperator("+");
        assertThat(plusOperator.calculator(3, 5)).isEqualTo(8);
    }

    @Test
    void 뺄셈_테스트() {
        Operator plusOperator = Operator.findOperator("-");
        assertThat(plusOperator.calculator(3, 5)).isEqualTo(-2);
    }

    @Test
    void 곱셈_테스트() {
        Operator plusOperator = Operator.findOperator("*");
        assertThat(plusOperator.calculator(3, 5)).isEqualTo(15);
    }

    @Test
    void 나눗셈_테스트() {
        Operator plusOperator = Operator.findOperator("/");
        assertThat(plusOperator.calculator(4, 2)).isEqualTo(2);
    }
}