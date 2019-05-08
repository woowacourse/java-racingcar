package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(cal.add(1,2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(cal.subtract(3,1)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(cal.multiply(3,2)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(cal.divide(4,2)).isEqualTo(2);
    }

    @Test
    void 올바른_단일_계산() throws Exception {
        assertThat(cal.calculate(1,"+",2)).isEqualTo(3);
        assertThat(cal.calculate(3,"-",1)).isEqualTo(2);
        assertThat(cal.calculate(3,"*",2)).isEqualTo(6);
        assertThat(cal.calculate(4,"/",2)).isEqualTo(2);
    }

    @Test
    void 잘못된_연산자_계산() {
        assertThrows(IllegalArgumentException.class, () -> {
            assertThat(cal.calculate(1,"a", 2)).isEqualTo(3);
        });
    }

    @AfterEach
    void tearDown() {
    }
}