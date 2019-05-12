package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void 덧셈() {
        assertEquals(3.8, cal.add(2.3, 1.5), 0.01);
    }

    @Test
    void 뺄셈() {
        assertEquals(0.8, cal.subtract(2.3, 1.5), 0.01);
    }

    @Test
    void 곱셈() {
        assertEquals(6.6, cal.multiply(3.3, 2));
    }

    @Test
    void 나눗셈() {
        assertEquals(2, cal.divide(4.4, 2.2));
    }

    @Test
    void 올바른_단일_계산() throws Exception {
        assertThat(cal.calculate(1, "+", 2)).isEqualTo(3);
        assertThat(cal.calculate(3, "-", 1)).isEqualTo(2);
        assertThat(cal.calculate(3, "*", 2)).isEqualTo(6);
        assertThat(cal.calculate(4, "/", 2)).isEqualTo(2);
    }

    @Test
    void 잘못된_연산자_계산() {
        assertThrows(IllegalArgumentException.class, () -> {
            assertThat(cal.calculate(1, "a", 2)).isEqualTo(3);
        });
    }

    @Test
    void 올바른_전체_계산() throws Exception {
        String[] inputs = {"2", "+", "3", "*", "4", "/", "2"};
        assertThat(cal.calculateAll(inputs)).isEqualTo(10);
    }

    @Test
    void 잘못된_입력_개수() {
        assertThrows(IllegalArgumentException.class, () -> {
            String[] inputs = {"2", "+", "3", "*", "4", "/"};
            assertThat(cal.calculateAll(inputs)).isEqualTo(10);
        });
    }

    @Test
    void 잘못된_숫자로_계산() {
        assertThrows(NumberFormatException.class, () -> {
            String[] inputs = {"a", "+", "3", "*", "4", "/", "2"};
            assertThat(cal.calculateAll(inputs)).isEqualTo(10);
        });
    }

    @AfterEach
    void tearDown() {
    }
}