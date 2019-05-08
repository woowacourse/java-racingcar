package calculator.calcinterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalcMainTest {
    private CalcMain calcMain;

    @BeforeEach
    void setUp() {
        calcMain = new CalcMain();
    }

    @Test
    void 덧셈() {
        assertThat(5).isEqualTo(calcMain.calcFormulaWithEnum(calcMain.splitFormula("2 + 3")));
    }
}