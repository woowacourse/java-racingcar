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
}
