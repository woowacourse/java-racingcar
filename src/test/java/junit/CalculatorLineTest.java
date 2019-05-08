package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorLineTest {
    CalculatorLine cal;
    @BeforeEach
    void setUp() {
        cal = new CalculatorLine();
    }

    @Test
    void 입력() {
        assertThat("2").isEqualTo(cal.splitFormula("2 + 3")[0]);
    }

    @Test
    void 연산() {
        assertThat(5).isEqualTo(cal.calcul(2, "+", 3));
    }

    @Test
    void 최종연산() {
        assertThat(10).isEqualTo(cal.calculFormula(cal.splitFormula("2 + 3 * 4 / 2")));
    }
}
