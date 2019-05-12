package calculator.calcinterface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.jdi.ArrayTypeImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorLineTest {
    private CalculatorLine calculatorLine;

    @Test
    void 덧셈() {
        calculatorLine = new CalculatorLine("2 + 3");
        assertThat(5).isEqualTo(calculatorLine.calculateFormula());
    }

    @Test
    void 뺄셈() {
        calculatorLine = new CalculatorLine("2 - 3");
        assertThat(-1).isEqualTo(calculatorLine.calculateFormula());
    }

    @Test
    void 곱셈() {
        calculatorLine = new CalculatorLine("2 * 3");
        assertThat(6).isEqualTo(calculatorLine.calculateFormula());
    }

    @Test
    void 나눗셈() {
        calculatorLine = new CalculatorLine("10 / 2");
        assertThat(5).isEqualTo(calculatorLine.calculateFormula());
    }

    @Test
    void 혼합_사칙_연산() {
        calculatorLine = new CalculatorLine("2 + 3 * 2 / 5");
        assertThat(2).isEqualTo(calculatorLine.calculateFormula());
    }

    @Test
    void 나눗셈_예외_처리() {
        calculatorLine = new CalculatorLine("10 / 0");
        assertThrows(ArithmeticException.class, () -> {
            calculatorLine.calculateFormula();
        });
    }

    @AfterEach
    void tearDown() {
        calculatorLine = null;
    }
}