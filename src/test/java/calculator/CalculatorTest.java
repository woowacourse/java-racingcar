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
    void 덧셈연산() {
        assertThat(cal.calculateInput("1 + 2")).isEqualTo(3);
    }

    @Test
    void 뺄셈연산() {
        assertThat(cal.calculateInput("1 - 2")).isEqualTo(-1);
    }

    @Test
    void 곱셈연산() {
        assertThat(cal.calculateInput("1 * 2")).isEqualTo(2);
    }

    @Test
    void 나눗셈연산() {
        assertThat(cal.calculateInput("2 / 2")).isEqualTo(1);
    }


    @Test
    void 여러개의연산() {
        String[] array = "3 + 2 * 4 / 2 + 3".split(" ");
        assertThat(cal.calculateMultiExpression(array)).isEqualTo(13);
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
