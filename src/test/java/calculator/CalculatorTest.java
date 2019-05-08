package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("setUp");
    }

    @Test
    void 덧셈() {
        assertThat(calculator.plus(2, 3)).isEqualTo(5);
        System.out.println("plus");
    }

    @Test
    void 뺄셈() {
        assertThat(calculator.minus(3, 2)).isEqualTo(1);
        System.out.println("minus");
    }

    @AfterEach
    void testDown() {
        System.out.println("testDown");
    }
}