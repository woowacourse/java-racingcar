package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(cal.add(1,2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(cal.subtract(3,1)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(cal.multiply(3,2)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(cal.divide(4,2)).isEqualTo(2);
    }

    @AfterEach
    void tearDown() {
    }
}