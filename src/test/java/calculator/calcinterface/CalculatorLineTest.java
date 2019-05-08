package calculator.calcinterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorLineTest {
    private CalculatorLine calculatorLine;
    private UserInterfaceView userInterfaceView;

    @BeforeEach
    void setUp() {
        calculatorLine = new CalculatorLine();
        userInterfaceView = new UserInterfaceView();
    }

    @Test
    void 덧셈() {
        assertThat(5).isEqualTo(
                calculatorLine.calculateFormula(
                        userInterfaceView.splitFormula("2 + 3"))
        );
    }
}