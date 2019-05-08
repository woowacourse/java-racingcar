package calculator.calcenum;

import calculator.calcenum.CalculatorLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void enum연산() {
        assertThat(15).isEqualTo(cal.calcFormulaWithEnum(cal.splitFormula("2 + 3 - 2 * 10 / 2")));
    }

}
