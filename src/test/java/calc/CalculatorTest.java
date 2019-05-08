package calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        assertThat(calc.calculateTokens(expressionToList("1 - 2 - 3"))).isEqualTo(-4);
    }

    @Test
    void multiplicationTest() {
        assertThat(calc.calculateTokens(expressionToList("1 * 3 * 9"))).isEqualTo(27);
    }

    @Test
    void divisionTest() {
        assertThat(calc.calculateTokens(expressionToList("128 / 4 / 8"))).isEqualTo(4);
    }

    @Test
    void expressionTest() {
        assertThat(calc.calculateTokens(expressionToList("1 + 5 / 2 * 5 - 7"))).isEqualTo(8);
    }

    @Test
    void exceptionTestA() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("-"));
        });
    }

    @Test
    void exceptionTestB() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("1 +"));
        });
    }

    @Test
    void exceptionTestC() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("1 + /"));
        });
    }

    @Test
    void exceptionTestD() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("1 + 5 /"));
        });
    }

}
