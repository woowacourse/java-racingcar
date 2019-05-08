package calculator.calcinterface;

import org.junit.jupiter.api.AfterEach;
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
                        userInterfaceView.splitFormula("2 + 3")
                )
        );
    }

    @Test
    void 뺄셈() {
        assertThat(2).isEqualTo(
                calculatorLine.calculateFormula(
                        userInterfaceView.splitFormula("5 - 3")
                )
        );
    }

    @Test
    void 곱셈() {
        assertThat(10).isEqualTo(
                calculatorLine.calculateFormula(
                        userInterfaceView.splitFormula("5 * 2")
                )
        );
    }

    @Test
    void 나눗셈() {
        assertThat(2).isEqualTo(
                calculatorLine.calculateFormula(
                        userInterfaceView.splitFormula("10 / 5")
                )
        );
    }

    @Test
    void 혼합_사칙연산() {
        assertThat(15).isEqualTo(
                calculatorLine.calculateFormula(
                        userInterfaceView.splitFormula("2 + 3 - 2 * 10 / 2")
                )
        );
    }

    @AfterEach
    void tearDown() {
        calculatorLine = null;
        userInterfaceView = null;
    }
}