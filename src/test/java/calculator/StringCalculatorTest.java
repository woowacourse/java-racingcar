package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 덧셈() {
        assertThat(stringCalculator.plus(1, 2)).isEqualTo(3);
        System.out.println("PLUS");
    }

    @Test
    void 뺄셈() {
        assertThat(stringCalculator.minus(1, 2)).isEqualTo(1);
        System.out.println("MINUS");
    }

    @Test
    void 곱셈() {
        assertThat(stringCalculator.mul(2, 4)).isEqualTo(8);
        System.out.println("MUL");
    }

    @Test
    void 나눗셈() {
        assertThat(stringCalculator.div(2, 4)).isEqualTo(2);
        System.out.println("DIV");
    }

    @Test
    void 관리() {

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