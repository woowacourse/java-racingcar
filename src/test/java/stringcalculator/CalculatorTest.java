package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void 사칙연산_처리_결과1() {
        String[] inputText = {"1", "+", "2"};
        int result = cal.calculate(inputText);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 사칙연산_처리_결과2() {
        String[] inputText = {"1", "+", "2", "*", "3"};
        int result = cal.calculate(inputText);
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 더하기() {
        String[] inputText = {"1", "+", "2"};
        int result = cal.calculate(inputText);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 빼기() {
        String[] inputText = {"5", "-", "2"};
        int result = cal.calculate(inputText);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 곱하기() {
        String[] inputText = {"3", "*", "2"};
        int result = cal.calculate(inputText);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나누기() {
        String[] inputText = {"10", "/", "2"};
        int result = cal.calculate(inputText);
        assertThat(result).isEqualTo(5);
    }
}
