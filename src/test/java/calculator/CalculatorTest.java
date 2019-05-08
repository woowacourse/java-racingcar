package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(calculator.plus(1, 2)).isEqualTo(3);
        System.out.println("PLUS");
    }

    @Test
    void 뺄셈() {
        assertThat(calculator.minus(1, 2)).isEqualTo(-1);
        System.out.println("Minus");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}