
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(cal.add(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(cal.subtract(3, 1)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(cal.mult(3, 1)).isEqualTo(3);
    }

    @Test
    void 나눗셈() {
        assertThat(cal.divide(4, 2)).isEqualTo(2);
    }

    @Test
    void 하나의연산() {
        assertThat(cal.calculateSingleExpression(1, "+", "2")).isEqualTo(3);
        assertThat(cal.calculateSingleExpression(1, "-", "2")).isEqualTo(-1);
        assertThat(cal.calculateSingleExpression(1, "*", "2")).isEqualTo(2);
        assertThat(cal.calculateSingleExpression(2, "/", "1")).isEqualTo(2);
    }

    @Test
    void 여러개의연산() {
        String[] array = "3 + 2 * 4 / 10 * 3".split(" ");
        assertThat(cal.calculateMultiExpression(array)).isEqualTo(6);
        array = "3 * 3 * 4 / 4 + 4".split(" ");
        assertThat(cal.calculateMultiExpression(array)).isEqualTo(13);

    }

}
