package calculator.calcinterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorWithInterfaceTest {
    private CalculatorWithInterface calculatorWithInterface;

    @BeforeEach
    void setUp() {
        calculatorWithInterface = new CalculatorWithInterface();
    }

    @Test
    void 덧셈() {
        assertThat(5).isEqualTo(
                calculatorWithInterface.calculateFormula(
                        calculatorWithInterface.splitFormula("2 + 3"))
        );
    }
}