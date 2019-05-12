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
    void 수식토큰화테스트() {
        assertThat(calc.tokenizeExpression("1   - 3    *  6"))
                .isEqualTo(Arrays.asList("1", "-", "3", "*", "6"));
    }

    @Test
    void 덧셈테스트() {
        calc.calculateTokens(expressionToList("1 + 2 + 3"));
        assertThat(calc.val).isEqualTo(6);
    }

    @Test
    void 뺄셈테스트() {
        calc.calculateTokens(expressionToList("1 - 3"));
        assertThat(calc.val).isEqualTo(-2);
    }

    @Test
    void 곱셈테스트() {
        calc.calculateTokens(expressionToList("1 * -3"));
        assertThat(calc.val).isEqualTo(-3);
    }

    @Test
    void 나눗셈테스트() {
        calc.calculateTokens(expressionToList("12 / 3"));
        assertThat(calc.val).isEqualTo(4);
    }

    @Test
    void 수식테스트() {
        calc.calculateTokens(expressionToList("1 - 3 * 6 + 6 / 2"));
        assertThat(calc.val).isEqualTo(-3);
    }

    @Test
    void 예외테스트A() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("-"));
        });
    }

    @Test
    void 예외테스트B() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("1 +"));
        });
    }

    @Test
    void 예외테스트C() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("1 + /"));
        });
    }

    @Test
    void 예외테스트D() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("1 + 5 /"));
        });
    }

    @Test
    void 예외테스트E() {
        assertThrows(Exception.class, () -> {
            calc.calculateTokens(expressionToList("1 + 5 1 1"));
        });
    }
}
