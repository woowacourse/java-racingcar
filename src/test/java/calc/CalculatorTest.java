package calc;

import calc.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calc;

    @BeforeEach
    public void testInit() {
        calc = new Calculator();

    }

    @Test
    void addTest() {
        assertThat(calc.calculate(new ArrayList<>(Arrays.asList("1 + 2 + 3".split(" "))))).isEqualTo(6);
    }

    @Test
    void subtractTest() {
        assertThat(calc.calculate(new ArrayList<>(Arrays.asList("1 - 2 - 3".split(" "))))).isEqualTo(-4);
    }

    @Test
    void 곱Test() {
        assertThat(calc.calculate(new ArrayList<>(Arrays.asList("1 * 3 * 9".split(" "))))).isEqualTo(27);
    }

    @Test
    void 나누기Test() {
        assertThat(calc.calculate(new ArrayList<>(Arrays.asList("128 / 4 / 8".split(" "))))).isEqualTo(4);
    }

    @Test
    void 여러가지Test() {
        assertThat(calc.calculate(new ArrayList<>(Arrays.asList("1 + 5 / 2 * 5 - 7".split(" "))))).isEqualTo(8);
    }
}
