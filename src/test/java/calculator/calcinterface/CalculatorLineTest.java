package calculator.calcinterface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorLineTest {
    private CalculatorLine calculatorLine;

    @BeforeEach
    void setUp() {
        calculatorLine = new CalculatorLine();
    }

    @Test
    void 덧셈() {
        assertThat(5).isEqualTo(
                calculatorLine.calculateFormula("2 + 3")
        );
    }

    @Test
    void 뺄셈() {
        assertThat(2).isEqualTo(
                calculatorLine.calculateFormula("5 - 3")
        );
    }

    @Test
    void 곱셈() {
        assertThat(10).isEqualTo(
                calculatorLine.calculateFormula("5 * 2")
        );
    }

    @Test
    void 나눗셈() {
        assertThat(2).isEqualTo(
                calculatorLine.calculateFormula("10 / 5")
        );
    }

    @Test
    void 혼합_사칙연산() {
        assertThat(15).isEqualTo(
                calculatorLine.calculateFormula("2 + 3 - 2 * 10 / 2")
        );
    }

    @Test
    void 나눗셈_예외처리() {
        assertThrows(ArithmeticException.class, () -> {
           calculatorLine.calculateFormula("10 / 0");
        });

    }

    @AfterEach
    void tearDown() {
        calculatorLine = null;
    }
}