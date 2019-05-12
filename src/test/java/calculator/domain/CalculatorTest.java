package calculator.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void 덧셈() {
        calculator = new Calculator(new String[]{"2", "+", "3.5"});
        assertThat(calculator.calculate()).isEqualTo(5.5);
    }

    @Test
    public void 뺄셈() {
        calculator = new Calculator(new String[]{"2", "-", "3.5"});
        assertThat(calculator.calculate()).isEqualTo(-1.5);
    }

    @Test
    public void 곱셈() {
       calculator = new Calculator(new String[]{"2.0", "*", "3.0"});
        assertThat(calculator.calculate()).isEqualTo(6.0);
    }

    @Test
    public void 나눗셈() {
        calculator = new Calculator(new String[]{"3.0", "/", "2.0"});
        assertThat(calculator.calculate()).isEqualTo(1.5);
    }

    @Test
    public void 정상적인_입력() {
        calculator = new Calculator(new String[]{"2","+","3","*","4","/","2"});
        assertThat(calculator.calculate()).isEqualTo(10);
    }
}
