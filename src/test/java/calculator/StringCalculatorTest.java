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
    void 덧셈() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int firstNumber = 1;
        int secondNumber = 2;
        Method plus = stringCalculator.getClass().getDeclaredMethod("plus", int.class, int.class);
        plus.setAccessible(true);

        assertThat(plus.invoke(stringCalculator, firstNumber, secondNumber)).isEqualTo(3);
    }

    @Test
    void 뺄셈() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int firstNumber = 1;
        int secondNumber = 2;
        Method minus = stringCalculator.getClass().getDeclaredMethod("minus", int.class, int.class);
        minus.setAccessible(true);

        assertThat(minus.invoke(stringCalculator, firstNumber, secondNumber)).isEqualTo(1);
    }

    @Test
    void 곱셈() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int firstNumber = 2;
        int secondNumber = 4;
        Method mul = stringCalculator.getClass().getDeclaredMethod("mul", int.class, int.class);
        mul.setAccessible(true);

        assertThat(mul.invoke(stringCalculator, firstNumber, secondNumber)).isEqualTo(8);
    }

    @Test
    void 나눗셈() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int firstNumber = 2;
        int secondNumber = 4;
        Method div = stringCalculator.getClass().getDeclaredMethod("div", int.class, int.class);
        div.setAccessible(true);

        assertThat(div.invoke(stringCalculator, firstNumber, secondNumber)).isEqualTo(2);
    }

    @Test
    void 계산결과_10() {
        String str = "2 + 3 * 4 / 2";
        assertThat(stringCalculator.getResult(str)).isEqualTo(10);
    }

    @Test
    void 사칙연산아닌특수문자입력() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "3 $ 4";
        Method checkInputValid = stringCalculator.getClass().getDeclaredMethod("checkInputValid", String.class);
        checkInputValid.setAccessible(true);

        assertThat(checkInputValid.invoke(stringCalculator, str)).isEqualTo(false);
    }

    @Test
    void 숫자하나입력() {
        String str = "4";

        assertThat(stringCalculator.getResult(str)).isEqualTo(4);
    }

    @Test
    void 숫자만입력() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "1 2 3";
        Method checkInputValid = stringCalculator.getClass().getDeclaredMethod("checkInputValid", String.class);
        checkInputValid.setAccessible(true);

        assertThat(checkInputValid.invoke(stringCalculator, str)).isEqualTo(false);
    }
}