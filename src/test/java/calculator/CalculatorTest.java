package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void 하나의연산() {
        assertThat(cal.calculateSingleExpression(1, "+", "2")).isEqualTo(3);
        assertThat(cal.calculateSingleExpression(1, "-", "2")).isEqualTo(-1);
        assertThat(cal.calculateSingleExpression(1, "*", "2")).isEqualTo(2);
        assertThat(cal.calculateSingleExpression(2, "/", "1")).isEqualTo(2);
    }

    @Test
    void 여러개의연산() {
        String[] array = "3 + 2 * 4 / 10 5 3".split(" ");
        assertThat(cal.calculateMultiExpression(array)).isEqualTo(6);
    }

    @Test
    void 영으로나누는연산() {
        String input = "3 / 0";
        Calculator calculator = new Calculator();
        assertThrows(Exception.class, () -> {
            calculator.calculateMultiExpression(input.split(" "));
        }).printStackTrace();
    }





}
