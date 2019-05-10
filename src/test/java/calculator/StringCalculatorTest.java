package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void 더하기() {
        assertThat(calculator.calculateAll("2 + 4")).isEqualTo(6);
    }

    @Test
    void 빼기() {
        assertThat(calculator.calculateAll("2 - 4")).isEqualTo(-2);
    }

    @Test
    void 곱하기() {
        assertThat(calculator.calculateAll("2 * 4")).isEqualTo(8);
    }

    @Test
    void 나누기() {
        assertThat(calculator.calculateAll("2 / 4")).isEqualTo(0);
    }

    @Test
    void 더하고_빼고_곱하고_나누고() {
        assertThat(calculator.calculateAll("2 + 4 * 3 / 2 - 7")).isEqualTo(2);
    }

    @Test
    void 잘못된_수식어를_입력하면_에러인지_테스트() {
        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAll("+ + + + +");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAll("2 + 2 + +");
        });
        assertThrows(IllegalArgumentException.class, () -> {
           calculator.calculateAll("2 2 2 2 2");
        });
        assertThrows(IllegalArgumentException.class, () -> {
           calculator.calculateAll("2 + 2 2 2");
        });
    }
}
