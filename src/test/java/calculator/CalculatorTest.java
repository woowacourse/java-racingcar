package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void 덧셈() {
        int result = calculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        int result = calculator.calculate("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        int result = calculator.calculate("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        int result = calculator.calculate("4 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 복합_계산() {
        assertThat(calculator.calculate("5 * 2 + 2")).isEqualTo(12);
        assertThat(calculator.calculate("12 + 3 * 2")).isEqualTo(30);
        assertThat(calculator.calculate("100 / 25 + 5")).isEqualTo(9);
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }
}
