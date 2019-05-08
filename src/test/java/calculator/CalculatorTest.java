package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @Test
    void 덧셈() {
        calculator = new Calculator(new String[]{"2", "+", "3"});
        assertThat(calculator.calculate()).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        calculator = new Calculator(new String[]{"2", "-", "3"});
        assertThat(calculator.subtract(2, 3)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        calculator = new Calculator(new String[]{"2", "*", "3"});
        assertThat(calculator.multiply(2, 3)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        calculator = new Calculator(new String[]{"2", "/", "3"});
        assertThat(calculator.divide(2, 3)).isEqualTo(0);
    }

    @Test
    void 정상적인_입력() {
        String testInput = "2 + 3 * 4 / 2";
        Calculator cal = new Calculator(testInput.split(" "));
        assertThat(cal.calculate()).isEqualTo(10);
    }
}
