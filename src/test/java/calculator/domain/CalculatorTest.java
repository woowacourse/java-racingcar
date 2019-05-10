package calculator.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @Test
    public void 덧셈() {
        calculator = new Calculator(new String[]{"2", "+", "3.5"});
        assertThat(calculator.add(2, 3.5)).isEqualTo(5.5);
    }

    @Test
    public void 뺄셈() {
        calculator = new Calculator(new String[]{"2", "-", "3.5"});
        assertThat(calculator.subtract(2, 3.5)).isEqualTo(-1.5);
    }

    @Test
    public void 곱셈() {
        calculator = new Calculator(new String[]{"2.0", "*", "3.0"});
        assertThat(calculator.multiply(2.0, 3.0)).isEqualTo(6.0);
    }

    @Test
    public void 나눗셈() {
        calculator = new Calculator(new String[]{"2.0", "/", "3.0"});
        assertThat(calculator.divide(2.0, 4.0)).isEqualTo(0.5);
    }

    @Test
    public void 정상적인_입력() {
        String testInput = "2 + 3 * 4 / 2";
        Calculator cal = new Calculator(testInput.split(" "));
        assertThat(cal.calculate()).isEqualTo(10);
    }
}
