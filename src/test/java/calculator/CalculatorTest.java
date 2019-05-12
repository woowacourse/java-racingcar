package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void 덧셈() {
        assertThat(Calculator.selectCalculator("+").calculate(1,2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(Calculator.selectCalculator("-").calculate(4,2)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.selectCalculator("*").calculate(3,2)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.selectCalculator("/").calculate(4,2)).isEqualTo(2);
    }

    @Test
    void 잘못된_연산자_계산() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.selectCalculator("a").calculate(1,2);
        });
    }
}
