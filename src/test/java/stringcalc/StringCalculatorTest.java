package stringcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    StringCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new StringCalculator();
    }

    @Test
    void 덧셈() {
        assertThat(calc.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(calc.calculate("2 - 1")).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        assertThat(calc.calculate("1 * 2")).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        assertThat(calc.calculate("2 / 1")).isEqualTo(2);
    }

    @Test
    void 복합계산() {
        assertThat(calc.calculate("2 + 1 + 3 * 2 / 3")).isEqualTo(4);
    }
}
