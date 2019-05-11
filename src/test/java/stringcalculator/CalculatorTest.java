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

}
