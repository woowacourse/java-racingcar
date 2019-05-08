package calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calc;

    private ArrayList<String> expressionToList(String input) {
        return new ArrayList<>(Arrays.asList(input.split(" ")));
    }

    @BeforeEach
    public void testInit() {
        calc = new Calculator();

    }

    @Test
    void addTest() {
        assertThat(calc.calculateTokens(expressionToList("1 + 2 + 3"))).isEqualTo(6);
    }

    @Test
    void subtractTest() {
        assertThat(calc.calculateTokens(new ArrayList<>(Arrays.asList("1 - 2 - 3".split(" "))))).isEqualTo(-4);
    }

    @Test
    void 곱Test() {
        assertThat(calc.calculateTokens(new ArrayList<>(Arrays.asList("1 * 3 * 9".split(" "))))).isEqualTo(27);
    }

    @Test
    void 나누기Test() {
        assertThat(calc.calculateTokens(new ArrayList<>(Arrays.asList("128 / 4 / 8".split(" "))))).isEqualTo(4);
    }

    @Test
    void 여러가지Test() {
        assertThat(calc.calculateTokens(new ArrayList<>(Arrays.asList("1 + 5 / 2 * 5 - 7".split(" "))))).isEqualTo(8);
    }
}
