package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    StringCalculator calculator;

    @Test
    void 덧셈() {
        calculator = new StringCalculator("3 + 5");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        calculator = new StringCalculator("3 - 2");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        calculator = new StringCalculator("3 * 2");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        calculator = new StringCalculator("4 / 2");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 복합_계산() {
        calculator = new StringCalculator("4 + 2 / 2 * 2 - 6");
        assertThat(calculator.calculate()).isEqualTo(0);
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }
}
