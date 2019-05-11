package calculator.calc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(calculator.plus(2, 3)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(calculator.minus(3, 2)).isEqualTo(1);
    }

    @AfterEach
    void testDown() {
    }
}