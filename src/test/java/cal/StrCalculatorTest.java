package cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class StrCalculatorTest {
    StrCalculator strCalculator;

    @BeforeEach
    void setUp() {
        strCalculator = new StrCalculator();
    }
    @Test
    void 수식쪼개기() {
        String input = "1 + 1 * 100 / 50 - 4";
        String[] result = {"1", "+", "1", "*", "100", "/", "50", "-", "4"};
        assertThat(strCalculator.splitExpression(input)).isEqualTo(result);
    }
    @Test
    void 수식빈값확인() {
        String input = "      ";
        assertThat(strCalculator.checkIsEmpty(input)).isEqualTo(input);
    }
    @Test
    void 사칙연산확인() {
        String[] input = {"1", "+", "1", "*", "100", "/", "50", "-", "4"};
        assertThat(strCalculator.calculate(input)).isEqualTo(0);
    }

    @Test
    void 수식이홀수인예외확인() {
        String[] input = {"-1", "+"};
        assertThat(strCalculator.expressionIsOdd(input)).isEqualTo(true);
    }

    @Test
    void 짝수인덱스확인() {
        String[] input = {"-1", "+", "2", "-", "4", "*", "2", "/", "1"};
        assertThat(strCalculator.isEvenPositionMatch(input)).isEqualTo(true);
    }

    @Test
    void 짝수인덱스연산자예외확인() {
        String[] arr = {"-1", "+", "-"};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(false);
    }

    @Test
    void 짝수인덱스없는값예외확인() {
        String[] arr = {""};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(false);
    }

    @Test
    void 짝수인덱스널예외확인() {
        String[] arr = {"-1", "+", "2", "-", null};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(false);
    }

    @Test
    void 홀수인덱스확인() {
        String[] input = {"-1", "+", "2", "-", "4", "*", "2", "/", "1"};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(true);
    }


    @Test
    void 홀수인덱스없는값확인() {
        String[] input = {"-1", "+", "2", "-", ""};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(false);
    }

    @Test
    void 홀수인덱스숫자확인() {
        String[] input = {"-1", "1", "2"};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(false);
    }

    @Test
    void 홀수인덱스널확인() {
        String[] input = {"-1", "+", "2", "-", "2",null};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(false);
    }

    @Test
    void 출력문자열확인() {
        String[] input = {"-1", "+", "2"};
        assertThat(strCalculator.makeResultSentence(input,1)).isEqualTo("-1 + 2 의 결과는 1");
    }
}