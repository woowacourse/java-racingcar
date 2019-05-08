package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator cal;

    @BeforeEach
    public void setUp(){
        cal = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(cal.plus(2,3)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(cal.minus(5,4)).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        assertThat(cal.multiply(2,6)).isEqualTo(12);
    }

    @Test
    void 나눗셈() {
        assertThat(cal.divide(8,4)).isEqualTo(2);
    }

    @AfterEach
    public void tearDown(){
        cal = null;
    }
}
