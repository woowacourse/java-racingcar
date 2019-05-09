package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 계산결과_10() {
        String str = "2 + 3 * 4 / 2";

        assertThat(stringCalculator.getResult(str)).isEqualTo(10);
    }

    @Test
    void 사칙연산아닌특수문자입력() {
        String str = "3 $ 4";

        assertThat(stringCalculator.checkInputValid(str)).isFalse();
    }

    @Test
    void 숫자하나입력() {
        String str = "4";

        assertThat(stringCalculator.getResult(str)).isEqualTo(4);
    }

    @Test
    void 숫자만입력() {
        String str = "1 2 3";

        assertThat(stringCalculator.checkInputValid(str)).isFalse();
    }
}