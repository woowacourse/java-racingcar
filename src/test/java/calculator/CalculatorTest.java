package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void 덧셈() {
        assertThat(Operation.run("+", 2, 3.5)).isEqualTo(5.5);
    }

    @Test
    void 뺄셈() {
        assertThat(Operation.run("-", 2, 3.5)).isEqualTo(-1.5);
    }

    @Test
    void 곱셈() {
        assertThat(Operation.run("*", 2, 3)).isEqualTo(6.0);
    }

    @Test
    void 나눗셈() {
        assertThat(Operation.run("/", 2, 4)).isEqualTo(0.5);
    }

    @Test
    void 정상적인_입력() {
        String testInput = "2 + 3 * 4 / 2";
        Calculator cal = new Calculator(testInput.split(" "));
        assertThat(cal.calculate()).isEqualTo(10);
    }
}
